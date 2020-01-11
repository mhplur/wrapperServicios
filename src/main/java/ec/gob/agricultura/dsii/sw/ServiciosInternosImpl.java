package ec.gob.agricultura.dsii.sw;

import java.util.LinkedHashMap;

import ec.gob.agricultura.dsii.sw.dto.SumRequest;
import ec.gob.agricultura.dsii.sw.dto.SumResponse;
import ec.gob.agricultura.dsii.sw.interno.AuthTokenImpl;
import ec.gob.agricultura.dsii.sw.vo.AuthTokenVo;
import ec.gob.agricultura.dsii.sw.vo.VoRespuestaRegistroCivil;

public class ServiciosInternosImpl implements ServiciosInternos {


	@Override
	public SumResponse consultaRegistroCivil(SumRequest request) {
		
		SumResponse sumResponse = new SumResponse();
		AuthTokenImpl tokenImpl= new AuthTokenImpl();
		AuthTokenVo authTokenVo= tokenImpl.solicitarToken();
		VoRespuestaRegistroCivil registroCivil= new VoRespuestaRegistroCivil();
		registroCivil= tokenImpl.getDatosCiudadano(authTokenVo,request.getParametro());
		sumResponse.setRespuestaRegistroCivil(registroCivil);
		return sumResponse;
	}

	

}
