package ec.gob.agricultura.dsii.sw;

import java.util.LinkedHashMap;

import ec.gob.agricultura.dsii.sw.dto.SriResponse;
import ec.gob.agricultura.dsii.sw.dto.SumRequest;
import ec.gob.agricultura.dsii.sw.dto.SumResponse;
import ec.gob.agricultura.dsii.sw.interno.AuthTokenImpl;
import ec.gob.agricultura.dsii.sw.vo.AuthTokenVo;
import ec.gob.agricultura.dsii.sw.vo.VoRespuestaSri;

public class SRIServiceImpl implements SRIService {

	@Override
	public SriResponse consultaServicioRentasInternas(SumRequest request) {
		SriResponse sriResponse= new SriResponse();
		AuthTokenImpl tokenImpl = new AuthTokenImpl();
		AuthTokenVo authTokenVo = tokenImpl.solicitarToken();
		VoRespuestaSri respuestaSri = new VoRespuestaSri();
		respuestaSri = tokenImpl.getDatoscontribuyente(authTokenVo, request.getParametro());
		sriResponse.setRespuestaSri(respuestaSri);
		return sriResponse;
	}

}
