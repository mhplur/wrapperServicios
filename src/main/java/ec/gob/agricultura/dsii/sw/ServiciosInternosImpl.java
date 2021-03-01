package ec.gob.agricultura.dsii.sw;

import java.util.LinkedHashMap;
import javax.xml.ws.http.HTTPException;

import org.apache.commons.httpclient.HttpException;
import org.apache.cxf.BusException;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;

import com.fasterxml.jackson.databind.JsonNode;

import ec.gob.agricultura.dsii.sw.dto.SumRequest;
import ec.gob.agricultura.dsii.sw.dto.SumResponse;
import ec.gob.agricultura.dsii.sw.exception.MyDependencyException;
import ec.gob.agricultura.dsii.sw.interno.AuthTokenImpl;
import ec.gob.agricultura.dsii.sw.servicio.rna.ServiciosRNAUtil;
import ec.gob.agricultura.dsii.sw.vo.AuthTokenVo;
import ec.gob.agricultura.dsii.sw.vo.VoBeneficiarioResponse;
import ec.gob.agricultura.dsii.sw.vo.VoRespuestaRegistroCivil;
import ec.gob.agricultura.dsii.util.CleanData;

public class ServiciosInternosImpl implements ServiciosInternos {

	@Deprecated
	@Override
	public SumResponse consultaRegistroCivilOld(SumRequest request) {
		SumResponse sumResponse = new SumResponse();
		AuthTokenImpl tokenImpl = new AuthTokenImpl();
		AuthTokenVo authTokenVo = tokenImpl.solicitarToken();
		VoRespuestaRegistroCivil registroCivil = new VoRespuestaRegistroCivil();
		registroCivil = tokenImpl.getDatosCiudadanoNew(authTokenVo, request.getParametro());
		sumResponse.setRespuestaRegistroCivil(registroCivil);
		return sumResponse;
	}

	/**
	 * CONSULTA DE LA NUEVA FUENTE ADMINISTRADA POR CGTIC
	 */
	@Override
	public SumResponse consultaRegistroCivil(SumRequest request) {
		SumResponse sumResponse = new SumResponse();
		ServiciosRNAUtil srna = new ServiciosRNAUtil();
		VoRespuestaRegistroCivil data = new VoRespuestaRegistroCivil();
		try {
			
			data = srna.buscarRegistroCivil(request.getParametro());
			data=CleanData.cleanDatosRegistroCivil(data);
		} catch (HttpServerErrorException e) {
			if(e.getStatusCode()==HttpStatus.INTERNAL_SERVER_ERROR)
			{
				data.setCodigoError("505");
				data.setError("Se ha detectado un problema con el servicio de busqueda del registro civil CGTIC, verifique el número de cédula. En el caso de que el número de cédula sea valido y el problema persiste probablemente se deben a problemas con el origen de los datos del registro civil DINARDAP");
			}
			if(e.getStatusCode()==HttpStatus.NOT_FOUND)
			{
				data.setCodigoError("404");
				data.setError("El beneficiario con número de cédula "+request.getParametro()+" no existe");
			}		
		}
		catch (Exception  ex) {
			data.setCodigoError("500");
			data.setError("Error en wrapperServicios, solicite revisar el funcionamiento del servicio que administra la CGTIC"+ex.getMessage().toString());
		}

		System.out.println("respuesta registro civil");
		System.out.println(data.toString());
		sumResponse.setRespuestaRegistroCivil(data);
		return sumResponse;

	}

}
