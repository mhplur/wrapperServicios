package ec.gob.agricultura.dsii.sw.servicio.rna;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ec.gob.agricultura.dsii.sw.exception.MyInternalException;
import ec.gob.agricultura.dsii.sw.servicio.rna.dto.TokenDto;
import ec.gob.agricultura.dsii.sw.vo.VoBeneficiario;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.codec.binary.Base64;
public class ParseObject {
	public static JsonNode convertStringToObject(String data)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode responseObj;
		responseObj = mapper.readValue(data, JsonNode.class);
		return responseObj;
	}
	public static JsonNode productorNuevoToProductorRNA(VoBeneficiario productorNuevo, JsonNode informacionServicios,TokenDto token)
			throws JsonParseException, JsonMappingException, IOException {
		Date fechaNacimiento = null;
		//estudiar que codigo poner
		String catidtiponacionalidad = "0";
		String lugarnacimiento = "";
		String na="NA";
		String perRegUsu=token.getUsuarios().get(0).getUsuId().toString();
		String pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
		String fechaActual =new SimpleDateFormat(pattern).format(new Date());
		String productorRnaString= "{"+
									"  \"catTipoIdentificacion\": 18,"+
									"  \"catGenero\": "+productorNuevo.getGenero()+","+
									"  \"catEstadoCivil\":"+productorNuevo.getEstadoCivil()+","+//añadir lógica para parsear strings por ids
									"  \"perNombre\": \""+productorNuevo.getNombres()+"\","+
									"  \"perApellido\": \""+productorNuevo.getApellidos()+"\","+
									"  \"perNombres\": \""+productorNuevo.getNombresApellidosCompletos()+"\","+
									"  \"perIdentificacion\": \""+productorNuevo.getCedula()+"\","+
									"  \"perFechaNac\": \""+productorNuevo.getFechaNacimiento()+"\","+
									"  \"perFuente\": \"SIAS\","+
									"  \"perFuenteId\": 0,"+
									"  \"perFuenteApli\": 17,"+
									"  \"perFuenteFecha\": \""+fechaActual+"\","+
									"  \"perRccondicion\": \"CIUDADANO\","+
									"  \"perRegUsu\": "+perRegUsu+","+
									"  \"perDirDomicilio\": \""+productorNuevo.getDireccion()+"\","+//quitar comillas
									"  \"perTelefono\": \""+productorNuevo.getTelefono()+"\","+
									"  \"perCelular\": \""+productorNuevo.getCelular()+"\","+
									"  \"perCorreo\": \""+Util.fixEmail( productorNuevo.getCorreo(), productorNuevo.getCedula())+"\","+
									"  \"catIdTipoNac\": "+catidtiponacionalidad+","+
									"  \"perLugarNacRc\":\""+lugarnacimiento+"\","+ 
									"  \"personaTipos\": ["+
									"    {"+
									"      \"areaId\": 2,"+
									"      \"cargoId\": 7,"+
									"      \"catTipoPer\": 46,"+
									"      \"petiFuente\": \"SIAS\","+
									"      \"petiFuenteApli\": 17,"+//no existe originalmente revisar sias ganadero.
									"      \"petiFuenteFecha\": \""+fechaActual+"\","+
									"      \"petiRegUsu\": "+perRegUsu+","+ //Estos ids como lo obtengo o siempre seran las mismas
									"      \"productor\": ["+
									"        {"+
									"          \"catActEconomica\": 502,"+
									"          \"catFuenteIngreso\": 0,"+
									"          \"proRegUsu\": "+perRegUsu+","+
									"          \"proGrupoEspecialesMayores60\": 0,"+
									"          \"proGrupoEspeciales_0_12\": 0,"+
									"          \"proGrupoEspeciales_12_18\": 0,"+
									"          \"proGrupoEspeciales_18_60\": 0,"+
									"          \"proGrupoMayor_60\": 0,"+
									"          \"proGrupo_0_12\": 0,"+
									"          \"proGrupo_12_18\": 0,"+
									"          \"proGrupo_18_60\": 0,"+
									"          \"proNumPersonasNoRemuneradas\": 0,"+
									"          \"proNumPersonasRemuneradas\": 0,"+
									"          \"proNumRemuneradasTemporal\": 0,"+
									"          \"proTotalManoObra\": 0,"+
									"          \"proTotalRecibeBonoDesarrollo\": 0"+
									"        }"+
									"      ]"+
									"    }"+
									"  ]"+
									"}";
		System.out.println("PRODUCTOR GUARDADO");
		System.out.println(productorRnaString);
		Charset UTF_8 = Charset.forName("UTF-8");
		@SuppressWarnings("unused")
		Charset ISO = Charset.forName("ISO-8859-1");
		String text = new String(productorRnaString.getBytes(), UTF_8);
		return convertStringToObject(text);
	} 
	
	public static TokenDto JSONStringtoToObjectToken(String body) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			TokenDto tokenDto = mapper.readValue(body, TokenDto.class);
			return tokenDto;
		} catch (JsonParseException e) {
			e.printStackTrace();
			throw new MyInternalException("La estructura de datos del Token ha cambiado");
		} catch (JsonMappingException e) {
			e.printStackTrace();
			throw new MyInternalException("La estructura de datos del Token ha cambiado");
		} catch (IOException e) {
			e.printStackTrace();
			throw new MyInternalException("La estructura de datos del Token ha cambiado");
		}
	}
	
	public static TokenDto getToken(String auth) {
		String jwtToken = auth.substring(7);
		String[] split_string = jwtToken.split("\\.");
		String base64EncodedBody = split_string[1];
		Base64 base64Url = new Base64(true);
		String body = new String(base64Url.decode(base64EncodedBody));
		return JSONStringtoToObjectToken(body);
	}
	public static TokenDto getTokenWithoutBearer(String jwtToken) {
		String[] split_string = jwtToken.split("\\.");
		String base64EncodedBody = split_string[1];
		Base64 base64Url = new Base64(true);
		String body = new String(base64Url.decode(base64EncodedBody));
		return JSONStringtoToObjectToken(body);
	}
}
