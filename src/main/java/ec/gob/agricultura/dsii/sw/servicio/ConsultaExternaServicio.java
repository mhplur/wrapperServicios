package ec.gob.agricultura.dsii.sw.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.agricultura.dsii.sw.interno.AuthToken;
import ec.gob.agricultura.dsii.sw.vo.AuthTokenVo;

@Service
public class ConsultaExternaServicio {
	
	@Autowired
	AuthToken authToken;
	
	
	public AuthTokenVo solicitarToken() {
		return authToken.solicitarToken();
	}
	

}
