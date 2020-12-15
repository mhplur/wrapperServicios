package ec.gob.agricultura.dsii.sw;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import ec.gob.agricultura.dsii.sw.interno.AuthTokenImpl;
import ec.gob.agricultura.dsii.sw.servicio.rna.ServiciosRNAUtil;
import ec.gob.agricultura.dsii.sw.vo.AuthTokenVo;
import ec.gob.agricultura.dsii.sw.vo.VoBeneficiario;
import ec.gob.agricultura.dsii.sw.vo.VoBeneficiarioResponse;

public class ServicioPersonasNaturalesImp implements ServicioPersonasNaturales {

	@Override
	public VoBeneficiarioResponse consultarOld(String cedula) {
		VoBeneficiarioResponse response=new VoBeneficiarioResponse();
		AuthTokenImpl token= new AuthTokenImpl();
		AuthTokenVo authTokenVo= token.solicitarToken();
		response=token.consultaPersonaNatural(authTokenVo, cedula); 
		return response;
	}

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
	public VoBeneficiarioResponse registrar(VoBeneficiario beneficiario) {
		
		VoBeneficiarioResponse response=new VoBeneficiarioResponse();
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
			//registrar datos al rna 
			try {
				JsonNode data=srna.crearProductor(beneficiario, null);
				System.out.println("----------------------------- PRODUCTOR CREADO ------------------------------------------");
				System.out.println(data.toString());
				response.setBenId(data.get("perId").intValue());
				response.setEstado("REGISTRADO");
				response.setObservacion("Beneficiario registrado");
			} catch (Exception ex) {
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
