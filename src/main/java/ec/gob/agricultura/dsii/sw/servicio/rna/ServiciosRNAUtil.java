package ec.gob.agricultura.dsii.sw.servicio.rna;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;

//import org.apache.tomcat.util.codec.binary.Base64;
//import org.apache.commons.lang3.tuple.MutablePair;
//import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
//import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import ec.gob.agricultura.dsii.sw.env.Config;
import ec.gob.agricultura.dsii.sw.exception.MyBadRequestException;
import ec.gob.agricultura.dsii.sw.exception.MyDependencyException;
import ec.gob.agricultura.dsii.sw.exception.MyInternalException;
import ec.gob.agricultura.dsii.sw.servicio.rna.dto.TokenDto;
import ec.gob.agricultura.dsii.sw.servicio.rna.dto.TokenResponseDTO;
import ec.gob.agricultura.dsii.sw.vo.VoBeneficiario;
import ec.gob.agricultura.dsii.sw.vo.VoRespuestaRegistroCivil;
//import ec.gob.magap.sigs.repository.ParametroRepository;
@Service
public class ServiciosRNAUtil {
	private String urlGetValidador;
	private String urlGetBuscarProductor;
	private String urlPostCrearProductor;
	Properties propiedades = new Properties();
	
	public ServiciosRNAUtil() {
		System.out.println("xxxxxxxxxxxxload properties2 ---xxxxxxxxxxxxxx");
	}
	
	public void testPropiedades() {
		String pr=propiedades.getProperty("var");
		System.out.println("---------------- INICIO	 ------------------");
		System.out.println(pr);
		System.out.println("----------------   FIN  ------------------");
	}
	private HttpHeaders getHeaders(String credential) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		headers.setContentLength(1000);
		String encodedCredential = new String(Base64.encodeBase64(credential.getBytes()));
		headers.add("Authorization", "Basic " + encodedCredential);
		return headers;
	}

	public TokenResponseDTO getToken() {
		String usuarioApli=Config.obtenerValorParametro("username_apli");
		String passwordApli=Config.obtenerValorParametro("password_apli");
		HttpHeaders headers = getHeaders(usuarioApli+":"+passwordApli);
		RestTemplate restTemplate = new RestTemplate();
		final String url =Config.obtenerValorParametro("AUTH");
		try {
			URI uri = new URI(url);
			MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
			parametersMap.set("username", Config.obtenerValorParametro("username"));
			parametersMap.set("password", Config.obtenerValorParametro("password"));
			parametersMap.set("grant_type", Config.obtenerValorParametro("grant_type"));
			parametersMap.set("idapli", Config.obtenerValorParametro("idapli"));
			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(
					parametersMap, headers);
			ResponseEntity<TokenResponseDTO> response = restTemplate.postForEntity(url, request, TokenResponseDTO.class);
			System.out.println(response.getBody());
			return response.getBody();
		} catch (Exception e) {
			System.out.println("PROBLEMA EN LA OBTENCIÓN DEL TOKEN, REVICE LAS CREDENCIALES");
			e.printStackTrace();
		}
		return null;
	}
	
	


	/**
	 * Funcion para validar productor 
	 * @param cedula
	 * @param token
	 * @return
	 */	
	public  JsonNode validarProductor(String cedula) {
		String url = Config.obtenerValorParametro("VALIDAR_PRODUCTOR") + "/" + cedula;
		String token=getToken().getAccess_token();
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Bearer " + token);
		MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(parametersMap,
				headers);
		ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, request, JsonNode.class);
		return response.getBody();
	}

	public  HttpStatus buscarProductor(String cedula) {
		String url = Config.obtenerValorParametro("BUSCAR_PRODUCTOR") + "/" + cedula;
		String token=getToken().getAccess_token();
		System.out.println("URL:" + url);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Bearer " + token);
		MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(parametersMap,
				headers);
		ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, request, JsonNode.class);
		return response.getStatusCode();
	}
	public  JsonNode buscarDataProductor(String cedula) {
		String url = Config.obtenerValorParametro("BUSCAR_PRODUCTOR") + "/" + cedula;
		//SY
		String token=getToken().getAccess_token();
		System.out.println("URL:" + url);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Bearer " + token);
		MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(parametersMap,
				headers);
		ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, request, JsonNode.class);
		return response.getBody();
	}
	public  VoRespuestaRegistroCivil buscarRegistroCivil(String cedula) {
		String url = Config.obtenerValorParametro("REGISTRO_CIVIL_NEW") + "/" + cedula;
		//SY
		String token=getToken().getAccess_token();
		System.out.println("URL:" + url);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Bearer " + token);
		MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(parametersMap,
				headers);
		ResponseEntity<VoRespuestaRegistroCivil> response = restTemplate.exchange(url, HttpMethod.GET, request, VoRespuestaRegistroCivil.class);
		return response.getBody();
	}


	public  JsonNode crearProductor(VoBeneficiario data, JsonNode informacionServicios)
			throws Exception {
		String url = Config.obtenerValorParametro("CREAR_PRODUCTOR");
		String token=getToken().getAccess_token();
		System.out.println("url servicio productor:"+url);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		// headers.setContentLength(1000);
		headers.add("Authorization", "Bearer " + token);
		TokenDto tokenDto = ParseObject.getTokenWithoutBearer(token);
		if(tokenDto.getUsuarios()!=null && tokenDto.getUsuarios().size()>0) {
			JsonNode productorRNA = ParseObject.productorNuevoToProductorRNA(data, informacionServicios, tokenDto);
			HttpEntity<JsonNode> request = new HttpEntity<JsonNode>(productorRNA, headers);
			ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.POST, request, JsonNode.class);
			return response.getBody();
		}
		else
			throw  new MyInternalException("El token no dispone del campo usuId, necesario para realizar el registro del productor");
	}
	
}

