package ec.gob.agricultura.dsii.sw;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.HttpServerErrorException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import ec.gob.agricultura.dsii.sw.interno.AuthTokenImpl;
import ec.gob.agricultura.dsii.sw.servicio.rna.ServiciosRNAUtil;
import ec.gob.agricultura.dsii.sw.vo.AuthTokenVo;
import ec.gob.agricultura.dsii.sw.vo.VoBeneficiario;
import ec.gob.agricultura.dsii.sw.vo.VoBeneficiarioResponse;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.xml.ws.http.HTTPException;

public class ServicioPersonasNaturalesImp implements ServicioPersonasNaturales {
	@Deprecated
	@Override
	public VoBeneficiarioResponse consultarOld(String cedula) {
		VoBeneficiarioResponse response=new VoBeneficiarioResponse();
		AuthTokenImpl token= new AuthTokenImpl();
		AuthTokenVo authTokenVo= token.solicitarToken();
		response=token.consultaPersonaNatural(authTokenVo, cedula); 
		return response;
	}
	@Deprecated
	@Override
	public VoBeneficiarioResponse registrarOld(VoBeneficiario beneficiario) {
		VoBeneficiarioResponse response=new VoBeneficiarioResponse();
		AuthTokenImpl token= new AuthTokenImpl();
		AuthTokenVo authTokenVo= token.solicitarToken();
		response=token.registrarPersonaNatural(authTokenVo, beneficiario);
		return response;
	}
	
	/**
	 * SERVICIOS ENRUTADOS AL RNA
	 */
	@Override
	public VoBeneficiarioResponse consultar(String cedula) {
		VoBeneficiarioResponse response=new VoBeneficiarioResponse();
		ServiciosRNAUtil srna = new ServiciosRNAUtil();
		try {
			JsonNode data=srna.buscarDataProductor(cedula);
			System.out.println(data.toString());
			data=data.get(0);
			Integer idProductor=data.get("perId").intValue();	
			response.setBenId(idProductor);
			response.setEstado("REGISTRADO");
			response.setObservacion("Beneficiario registrado");
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setBenId(0);
			response.setEstado("NO_REGISTRADO");
			response.setObservacion("Beneficiario no registrado");
		} 
		return response;
	}

	@Override
	public VoBeneficiarioResponse registrar(@Valid VoBeneficiario beneficiario) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<VoBeneficiario>> constraintViolations = validator.validate(beneficiario);
		List<String> messageError = constraintViolations.stream().map(c -> c.getMessage()).collect(Collectors.toList());
		VoBeneficiarioResponse response=new VoBeneficiarioResponse();
		if (messageError.size() >= 1) {
			messageError = messageError.stream().distinct().collect(Collectors.toList());
			response.setBenId(0);
			response.setEstado("NO_REGISTRADO");
			response.setObservacion(messageError.toString());
			return response;
		}
		ServiciosRNAUtil srna = new ServiciosRNAUtil();
		try {
			JsonNode data=srna.buscarDataProductor(beneficiario.getCedula());
			System.out.println(data.toString());
			data=data.get(0);
			Integer idProductor=data.get("perId").intValue();	
			if(idProductor!=null || idProductor>0) {
				response.setBenId(idProductor);
				response.setEstado("REGISTRADO");
				response.setObservacion("Beneficiario registrado");
				return response;
			}
		} catch (Exception e) {
			try {
				JsonNode data=srna.crearProductor(beneficiario, null);
				System.out.println("----------------------------- PRODUCTOR CREADO ------------------------------------------");
				System.out.println(data.toString());
				response.setBenId(data.get("perId").intValue());
				response.setEstado("REGISTRADO");
				response.setObservacion("Beneficiario registrado");
			} 
			catch (org.springframework.web.client.HttpClientErrorException exh) {
				System.out.println("----------------------------- ERROR EN LA CREACIÓN DEL PRODUCTOR ------------------------------------------");
				exh.printStackTrace();
				response.setBenId(0);
				response.setEstado("NO_REGISTRADO");
				if(exh.getStatusCode()== HttpStatus.BAD_REQUEST)
					response.setObservacion("Parametros enviados no validos CGTIC");
				else if(exh.getStatusCode()== HttpStatus.INTERNAL_SERVER_ERROR)
					response.setObservacion("Se produjo un error en el servicio de creación de productores CGTIC");
				else
					response.setObservacion("Se produjo un error en el servicio de creación de productores CGTIC");
			}
			catch (Exception ex) {
				System.out.println("----------------------------- ERROR EN LA CREACIÓN DEL PRODUCTOR ------------------------------------------");
				ex.printStackTrace();
				response.setBenId(0);
				response.setEstado("NO_REGISTRADO");
				response.setObservacion("Beneficiario no registrado");
			}	
		} 
		
		
		return response;
	}
	
	

}
