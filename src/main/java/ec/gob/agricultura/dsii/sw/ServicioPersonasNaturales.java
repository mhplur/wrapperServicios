package ec.gob.agricultura.dsii.sw;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import ec.gob.agricultura.dsii.sw.vo.VoBeneficiario;
import ec.gob.agricultura.dsii.sw.vo.VoBeneficiarioResponse;

@WebService(name="ServicioPersonasNaturales")
public interface ServicioPersonasNaturales {
	
	@WebMethod(operationName="consultarOld")
	@WebResult(name="response")
	VoBeneficiarioResponse consultarRNA(@WebParam(name="cedula")String cedula);
	
	@WebMethod(operationName="registrarOld")
	@WebResult(name="response")
	VoBeneficiarioResponse registrarRNA(@WebParam(name="cedula")VoBeneficiario beneficiario);
	
	
	@WebMethod(operationName="consultar")
	@WebResult(name="response")
	VoBeneficiarioResponse consultar(@WebParam(name="cedula")String cedula);
	
	@WebMethod(operationName="registrar")
	@WebResult(name="response")
	VoBeneficiarioResponse registrar(@WebParam(name="cedula")VoBeneficiario beneficiario);

}
