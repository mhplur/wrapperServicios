package ec.gob.agricultura.dsii.sw;

import ec.gob.agricultura.dsii.sw.interno.AuthTokenImpl;
import ec.gob.agricultura.dsii.sw.vo.AuthTokenVo;
import ec.gob.agricultura.dsii.sw.vo.VoBeneficiario;
import ec.gob.agricultura.dsii.sw.vo.VoBeneficiarioResponse;

public class ServicioPersonasNaturalesImp implements ServicioPersonasNaturales {

	@Override
	public VoBeneficiarioResponse consultar(String cedula) {
		VoBeneficiarioResponse response=new VoBeneficiarioResponse();
		AuthTokenImpl token= new AuthTokenImpl();
		AuthTokenVo authTokenVo= token.solicitarToken();
		response=token.consultaPersonaNatural(authTokenVo, cedula); 
		return response;
	}

	@Override
	public VoBeneficiarioResponse consultar(VoBeneficiario beneficiario) {
		VoBeneficiarioResponse response=new VoBeneficiarioResponse();
		AuthTokenImpl token= new AuthTokenImpl();
		AuthTokenVo authTokenVo= token.solicitarToken();
		response=token.registrarPersonaNatural(authTokenVo, beneficiario);
		return response;
	}

}
