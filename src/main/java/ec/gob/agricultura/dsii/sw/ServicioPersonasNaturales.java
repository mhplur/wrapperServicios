package ec.gob.agricultura.dsii.sw;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import ec.gob.agricultura.dsii.sw.vo.VoBeneficiario;
import ec.gob.agricultura.dsii.sw.vo.VoBeneficiarioResponse;

@WebService(name="ServicioPersonasNaturales")
public interface ServicioPersonasNaturales {
	@Deprecated
	@WebMethod(operationName="consultarOld")
	@WebResult(name="response")
	VoBeneficiarioResponse consultarOld(@WebParam(name="cedula")String cedula);
	
	@Deprecated
	@WebMethod(operationName="registrarOld")
	@WebResult(name="response")
	VoBeneficiarioResponse registrarOld(@WebParam(name="cedula")VoBeneficiario beneficiario);
	
	
	@WebMethod(operationName="consultar")
	@WebResult(name="response")
	VoBeneficiarioResponse consultar(@WebParam(name="cedula")String cedula);
	
	@WebMethod(operationName="registrar")
	@WebResult(name="response")
	VoBeneficiarioResponse registrar(@Valid @WebParam(name="cedula")VoBeneficiario beneficiario);

}
