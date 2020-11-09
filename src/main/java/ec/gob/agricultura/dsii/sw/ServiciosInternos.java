package ec.gob.agricultura.dsii.sw;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import ec.gob.agricultura.dsii.sw.dto.SumRequest;
import ec.gob.agricultura.dsii.sw.dto.SumResponse;

@WebService(name="ServiciosInternos")
public interface ServiciosInternos {
	//@WebMethod(operationName="consultaRegistroCivil")
	@WebResult(name="response")
	SumResponse consultaRegistroCivil(@WebParam SumRequest request);
}
