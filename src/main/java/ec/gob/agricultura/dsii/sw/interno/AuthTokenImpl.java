package ec.gob.agricultura.dsii.sw.interno;

import java.net.URI;
import java.util.Arrays;
import java.util.LinkedHashMap;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import com.google.gson.internal.LinkedTreeMap;

import ec.gob.agricultura.dsii.sw.env.Config;
import ec.gob.agricultura.dsii.sw.env.MyEnviroment;
import ec.gob.agricultura.dsii.sw.vo.AuthTokenVo;
import ec.gob.agricultura.dsii.sw.vo.VoBeneficiario;
import ec.gob.agricultura.dsii.sw.vo.VoBeneficiarioResponse;
import ec.gob.agricultura.dsii.sw.vo.VoRespuestaRegistroCivil;
import ec.gob.agricultura.dsii.sw.vo.VoRespuestaSri;

@Service
public class AuthTokenImpl {
	public static final String REST_SERVICE_URI_DR=Config.obtenerValorParametro("REGISTRO_CIVIL_NEW");;
	public static final String REST_SERVICE_URI = Config.obtenerValorParametro("REGISTRO_CIVIL_OLD");//"http://10.10.1.18:8080/wsministerial";
	public static final String AUTH_SERVER_URI = Config.obtenerValorParametro("CRED_WSMINIS_AUTH_SERVER_URI");//"http://10.10.1.18:8080/wsministerial/oauth/token";
	public static final String QPM_PASSWORD_GRANT = Config.obtenerValorParametro("CRED_WSMINIS_QPM_PASSWORD_GRANT");//"?grant_type=password&username=userprueba&password=acceso";
	public static final String QPM_ACCESS_TOKEN = Config.obtenerValorParametro("CRED_WSMINIS_QPM_ACCESS_TOKEN"); //"?access_token=";
	Logger logger = Logger.getLogger(AuthTokenImpl.class.getName());
/*	public static final String REST_SERVICE_URI = "http://servicios.agricultura.gob.ec/interoperabilidad";
	public static final String AUTH_SERVER_URI = "http://servicios.agricultura.gob.ec/interoperabilidad/oauth/token";
	public static final String QPM_PASSWORD_GRANT = "?grant_type=password&username=clientemag&password=mag_operaciones";
	public static final String QPM_ACCESS_TOKEN = "?access_token=";*/

	// * Prepare HTTP Headers.

	private static HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}

	// * Add HTTP Authorization header, using Basic-Authentication to send
	// client-credentials.
	private static HttpHeaders getHeadersWithClientCredentials() {
		String plainClientCredentials = "dsii:desarrollo";
//		String plainClientCredentials = "banecuador:3anEcuadoR/4378";
		String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));

		HttpHeaders headers = getHeaders();
		headers.add("Authorization", "Basic " + base64ClientCredentials);
		return headers;
	}

	@SuppressWarnings("unchecked")
	public AuthTokenVo solicitarToken() {
		AuthTokenVo tokenInfo = null;
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<String> request = new HttpEntity<String>(getHeadersWithClientCredentials());
		ResponseEntity<Object> response = restTemplate.exchange(AUTH_SERVER_URI + QPM_PASSWORD_GRANT, HttpMethod.POST,
				request, Object.class);

		// LinkedTreeMap<String, Object> map = (LinkedTreeMap<String,
		// Object>)response.getBody();
		LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) response.getBody();

		if (map != null) {
			System.out.println(map.get("access_token"));
			tokenInfo = new AuthTokenVo();
			tokenInfo.setAccess_token((String) map.get("access_token"));
			tokenInfo.setToken_type((String) map.get("token_type"));
			tokenInfo.setRefresh_token((String) map.get("refresh_token"));
			// tokenInfo.setExpires_in((Integer) map.get("expires_in"));
			tokenInfo.setScope((String) map.get("scope"));
//			System.out.println("access_token =" + map.get("access_token") + ", token_type=" + map.get("token_type")
//					+ ", refresh_token=" + map.get("refresh_token") + ", expires_in=" + map.get("expires_in")
//					+ ", scope=" + map.get("scope"));
		} else {
			System.out.println("No user exist----------");

		}
		return tokenInfo;

	}
	
//    * Send a GET request to get a specific user.
    
    public VoRespuestaRegistroCivil getDatosCiudadanoNew(AuthTokenVo tokenInfo, String parametro){
    	 RestTemplate restTemplate = new RestTemplate();
        VoRespuestaRegistroCivil respuesta = null;
		try {
			HttpEntity<String> request = new HttpEntity<String>(getHeaders());
			//modificado por paul
//			ResponseEntity<VoRespuestaRegistroCivil> response = restTemplate.exchange(REST_SERVICE_URI+"/user/consultaciudadano/"+parametro+"/2/"+QPM_ACCESS_TOKEN+tokenInfo.getAccess_token(),
//					HttpMethod.GET, request, VoRespuestaRegistroCivil.class);
//			
			ResponseEntity<VoRespuestaRegistroCivil> response = restTemplate.exchange(REST_SERVICE_URI_DR+"/utilitarios/registrocivildatosciudadano/"+parametro,
					HttpMethod.GET, request, VoRespuestaRegistroCivil.class);
			respuesta = response.getBody();
	    }catch(Exception e) {
			try {
			HttpEntity<String> request = new HttpEntity<String>(getHeaders());
			//modificado por paul
			ResponseEntity<VoRespuestaRegistroCivil> response = restTemplate.exchange(REST_SERVICE_URI_DR+"/utilitarios/registrocivildatosciudadano/"+parametro,
					HttpMethod.GET, request, VoRespuestaRegistroCivil.class);
			respuesta = response.getBody();
			}catch(Exception ex) {}
				
	    }
		if(respuesta==null){
			try {
			HttpEntity<String> request = new HttpEntity<String>(getHeaders());
			//modificado por paul
			ResponseEntity<VoRespuestaRegistroCivil> response = restTemplate.exchange(REST_SERVICE_URI_DR+"/utilitarios/registrocivildatosciudadano/"+parametro,
					HttpMethod.GET, request, VoRespuestaRegistroCivil.class);
			respuesta = response.getBody();
			}catch(Exception e) {
				System.out.println("SE HA DETECTADO UN PROBLEMA EN EL SERVICIO, PORFAVOR REVISE SU BUEN FUNCIONAMIENTO");
			}
		}
       // LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) response.getBody();
		if(respuesta.getNUI()!="" && respuesta.getNUI()!=null) {
			 if(respuesta.getGenero()==null)
				 if(respuesta.getSexo().equals("HOMBRE"))  respuesta.setGenero("MASCULINO");
				 else respuesta.setGenero("FEMENINO");
			
		    if(respuesta.getEstadoCivil()==null) respuesta.setEstadoCivil("SOLTERO");
			if(respuesta.getDomicilio()==null) respuesta.setDomicilio("NI/NI/NI");
			//depurar espacios
			respuesta.setCalle(respuesta.getCalle().trim());
			respuesta.setCodigoDomicilio(respuesta.getCodigoDomicilio().trim());
			respuesta.setCondicionCedulado(respuesta.getCondicionCedulado().trim());
			respuesta.setConyuge(respuesta.getConyuge().trim());
			respuesta.setNombrePadre(respuesta.getNombrePadre().trim());
			respuesta.setNombreMadre(respuesta.getNombreMadre().trim());
			respuesta.setDomicilio(respuesta.getDomicilio().trim());
			respuesta.setError(respuesta.getError().trim());
			respuesta.setCodigoError(respuesta.getCodigoError().trim());
			respuesta.setEstadoCivil(respuesta.getEstadoCivil().trim());
			respuesta.setFechaInscripcionGenero(respuesta.getFechaInscripcionGenero().trim());
			respuesta.setFechaNacimiento(respuesta.getFechaNacimiento().trim());
			respuesta.setGenero(respuesta.getGenero().trim());
			respuesta.setInstruccion(respuesta.getInstruccion().trim());
			respuesta.setLugarInscripcionGenero(respuesta.getLugarInscripcionGenero().trim());
			respuesta.setLugarNacimiento(respuesta.getLugarNacimiento().trim());
			respuesta.setNombre(respuesta.getNombre().trim());
			respuesta.setNumeroCasa(respuesta.getNumeroCasa().trim());
			respuesta.setSexo(respuesta.getSexo().trim());
			respuesta.setFechaDefuncion(respuesta.getFechaDefuncion().trim());
			respuesta.setNacionalidad(respuesta.getNacionalidad().trim());
			respuesta.setNUI(respuesta.getNUI().trim());
			
		}
		
        return respuesta;
    }
    
//  * Send a GET request to get a specific user.
    
  public VoRespuestaSri getDatoscontribuyente(AuthTokenVo tokenInfo, String parametro){
  	Assert.notNull(tokenInfo, "Authenticate first please......");
      RestTemplate restTemplate = new RestTemplate();
      VoRespuestaSri respuesta= new VoRespuestaSri();
      HttpEntity<String> request = new HttpEntity<String>(getHeaders());
      ResponseEntity<VoRespuestaSri> response = restTemplate.exchange(REST_SERVICE_URI+"/user/consultatributaria/"+parametro+"/"+QPM_ACCESS_TOKEN+tokenInfo.getAccess_token(),
      		HttpMethod.GET, request, VoRespuestaSri.class);
      
      respuesta = response.getBody();
      return respuesta;
  }
  
  public VoBeneficiarioResponse consultaPersonaNatural(AuthTokenVo tokenInfo, String parametro){
	  	Assert.notNull(tokenInfo, "Authenticate first please......");
	      RestTemplate restTemplate = new RestTemplate();
	      VoBeneficiarioResponse respuesta= new VoBeneficiarioResponse();
	      HttpEntity<String> request = new HttpEntity<String>(getHeaders());
	      ResponseEntity<VoBeneficiarioResponse> response = restTemplate.exchange(REST_SERVICE_URI+"/user/beneficiario/"+parametro+"/"+QPM_ACCESS_TOKEN+tokenInfo.getAccess_token(),
	      		HttpMethod.GET, request, VoBeneficiarioResponse.class);
	      respuesta = response.getBody();
	      return respuesta;
	  }
  
  public VoBeneficiarioResponse registrarPersonaNatural(AuthTokenVo tokenInfo, VoBeneficiario beneficiario){
	  VoBeneficiarioResponse respuesta= new VoBeneficiarioResponse();
	  try {
		  Assert.notNull(tokenInfo, "Authenticate first please......");
	      RestTemplate restTemplate = new RestTemplate();
	      HttpEntity<Object> request = new HttpEntity<Object>(beneficiario,getHeaders());
	      ResponseEntity<VoBeneficiarioResponse> response = restTemplate.exchange(REST_SERVICE_URI+"/user/beneficiario/"+QPM_ACCESS_TOKEN+tokenInfo.getAccess_token(),
	      		HttpMethod.POST, request, VoBeneficiarioResponse.class);
	      respuesta = response.getBody();
	      
		  
	  }catch(Exception e) {
		  
	  }
	  return respuesta;
	  
	  }

}
