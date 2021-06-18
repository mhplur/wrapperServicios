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
import java.text.ParseException;
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
	public static Integer buscarRnaIdEstadoCivil(String estado) {
		
		if(estado=="SOLTERO"|| estado=="S")
			return 23;
		if(estado=="CASADO"|| estado=="C")
			return 24;
		if(estado=="DIVORCIADO"|| estado=="D")
			return 25;
		if(estado=="VIUDO"|| estado=="V")
			return 26;
		if(estado=="UNIÓN LIBRE"|| estado=="U")
			return 300;
		if(estado=="EN UNIÓN DE HECHO"|| estado=="H")
			return 362;
		
		return 23;
	}
	public static Integer buscarRnaIdGenero(String genero) {
		if(genero=="MASCULINO"|| genero=="M")
			return 21;
		if(genero=="FEMENINO"|| genero=="F")
			return 22;
		return 21;
	}
	public static JsonNode productorNuevoToProductorRNA(VoBeneficiario productorNuevo, JsonNode informacionServicios,TokenDto token)
			throws Exception {

		//estudiar que codigo poner
		/*
		"detailsJson": "error:{
		//debe enviar desde el sias
		perLugarNacRc : El campo es requerido perLugarNacRc,"
		
		//se quemo el valor 27
		+ "catIdTipoNac : Solo se aceptan estos valores [27, 344],ubiIdDomicilio : "
		
		//no se sabe que sucede si es not nulo
		+ "El campo no puede ser nulo ubiIdDomicilio}",
				
		*/

		String catidtiponacionalidad = "27";
		String lugarnacimiento = "NA";
		
		System.out.println(productorNuevo.getCedula()+":XXXXXXXXXXXXXXXXXXXXXXXXXXX DIRECCION1:"+productorNuevo.getDireccion());
		if(productorNuevo.getLugarNacimiento()!=null)
			lugarnacimiento=productorNuevo.getLugarNacimiento();
		String direccion=productorNuevo.getDireccion();
		
		System.out.println(productorNuevo.getCedula()+":XXXXXXXXXXXXXXXXXXXXXXXXXXX DIRECCION2:"+direccion);
		System.out.println(productorNuevo.getCedula()+":XXXXXXXXXXXXXXXXXXXXXXXXXXX FECHA NACIMIENTO:"+productorNuevo.getFechaNacimiento());
		
		String na="NA";
		SimpleDateFormat formatoFechaLlegada = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		SimpleDateFormat formatoFechaRna = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm.sss-05:00");
		String fechaNacimiento ="";
		if(productorNuevo.getFechaNacimiento()!=null) {
			fechaNacimiento =productorNuevo.getFechaNacimiento();
			try {
				Date date1= formatoFechaLlegada.parse(fechaNacimiento);
				fechaNacimiento = formatoFechaRna.format(date1);
				System.out.println(productorNuevo.getCedula()+":XXXXXXXXXXXXXXXXXXXXXXXXXXX FECHA NACIMIENTO MODIFICADA:"+fechaNacimiento);
			} catch (ParseException e) {
				e.printStackTrace();
				throw new Exception("El formato de la fecha enviada no es valido");
			}
		}
		String perRegUsu=token.getUsuarios().get(0).getUsuId().toString();
		String fechaActual =formatoFechaRna.format(new Date());
		String productorRnaString= "{"+
									"  \"catTipoIdentificacion\": 18,"+
									"  \"catGenero\": "+buscarRnaIdGenero(productorNuevo.getGenero())+","+
									"  \"catEstadoCivil\":"+buscarRnaIdEstadoCivil(productorNuevo.getEstadoCivil())+","+//añadir lógica para parsear strings por ids
									"  \"perNombre\": \""+productorNuevo.getNombres()+"\","+
									"  \"perApellido\": \""+productorNuevo.getApellidos()+"\","+
									"  \"perNombres\": \""+productorNuevo.getNombresApellidosCompletos()+"\","+
									"  \"perIdentificacion\": \""+productorNuevo.getCedula()+"\","+
									"  \"perFechaNac\": \""+fechaNacimiento+"\","+
									"  \"perFuente\": \"SIAS\","+
									"  \"ubiIdDomicilio\": "+productorNuevo.getUbiIdDomicilio()+","+
									"  \"perFuenteId\": 0,"+
									"  \"perFuenteApli\": 17,"+
									"  \"perFuenteFecha\": \""+fechaActual+"\","+
									"  \"perRccondicion\": \"CIUDADANO\","+
									"  \"perRegUsu\": "+perRegUsu+","+
									"  \"perDirDomicilio\": \""+direccion+"\","+//quitar comillas
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
		System.out.println("JSON ENVIADO XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX :");
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
