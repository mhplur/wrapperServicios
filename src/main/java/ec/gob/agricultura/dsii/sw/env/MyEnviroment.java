package ec.gob.agricultura.dsii.sw.env;

import ec.gob.agricultura.dsii.sw.exception.MyInternalException;

public class MyEnviroment {
	public  static String obtenerValorParametroDev(String nombreParametro) {
		if(nombreParametro.equalsIgnoreCase("VALIDAR_PRODUCTOR"))
			return "http://10.10.1.121:8080/micro_validacion-0.0.1/validate/productor";
		else if(nombreParametro.equalsIgnoreCase("REGISTRO_CIVIL_OLD"))
			return "http://10.10.1.17:8080/wsministerial";
		else if(nombreParametro.equalsIgnoreCase("BUSCAR_PRODUCTOR"))
			return "http://10.10.1.121:8080/micro_persona-0.0.1/productor/findByCedulaProductor";
		else if(nombreParametro.equalsIgnoreCase("CREAR_PRODUCTOR"))
			return "http://10.10.1.121:8080/micro_persona-0.0.1/productor/create";
		else if(nombreParametro.equalsIgnoreCase("REGISTRO_CIVIL_NEW"))
			return "http://10.10.1.121:8080/api_dinardap/api/dinardap/interoperador/1";
		else if(nombreParametro.equalsIgnoreCase("AUTH"))
			return "http://10.10.1.121:8080/servicio_seguridad-0.0.1/api/oauth/token";
		
		else if(nombreParametro.equalsIgnoreCase("username_apli"))
			return "us_sias";
		else if(nombreParametro.equalsIgnoreCase("password_apli"))
			return "us_sias_2020";
		
		else if(nombreParametro.equalsIgnoreCase("username"))
			return "1722295126";
		else if(nombreParametro.equalsIgnoreCase("password"))
			return "6bd1e48bdfd68ac1a64aadca289933e3";
		else if(nombreParametro.equalsIgnoreCase("grant_type"))
			return "password";
		else if(nombreParametro.equalsIgnoreCase("idapli"))
			return "17";
		else if(nombreParametro.equalsIgnoreCase("CRED_WSMINIS_AUTH_SERVER_URI"))
			return "http://10.10.1.33:8080/wsministerial/oauth/token";
		else if(nombreParametro.equalsIgnoreCase("CRED_WSMINIS_QPM_PASSWORD_GRANT"))
			return "?grant_type=password&username=userprueba&password=acceso";
		else if(nombreParametro.equalsIgnoreCase("CRED_WSMINIS_QPM_ACCESS_TOKEN"))
			return "?access_token=";
		else 
			throw new MyInternalException("NO SE ENCONTR0 LA VARIABLE "+nombreParametro+" CONFIGURADA");
	}
	public  static String obtenerValorParametroTest(String nombreParametro) {
		if(nombreParametro.equalsIgnoreCase("VALIDAR_PRODUCTOR"))
			return "http://10.10.1.121:8080/micro_validacion-0.0.1/validate/productor";
		else if(nombreParametro.equalsIgnoreCase("REGISTRO_CIVIL_OLD"))
			return "http://10.10.1.33:8080/wsministerial";
		else if(nombreParametro.equalsIgnoreCase("BUSCAR_PRODUCTOR"))
			return "http://10.10.1.121:8080/micro_persona-0.0.1/productor/findByCedulaProductor";
		else if(nombreParametro.equalsIgnoreCase("CREAR_PRODUCTOR"))
			return "http://10.10.1.121:8080/micro_persona-0.0.1/productor/create";
		else if(nombreParametro.equalsIgnoreCase("REGISTRO_CIVIL_NEW"))
			return "http://10.10.1.121:8080/api_dinardap/api/dinardap/interoperador/1";
		else if(nombreParametro.equalsIgnoreCase("AUTH"))
			return "http://10.10.1.121:8080/servicio_seguridad-0.0.1/api/oauth/token";
		
		else if(nombreParametro.equalsIgnoreCase("username_apli"))
			return "us_sias";
		else if(nombreParametro.equalsIgnoreCase("password_apli"))
			return "us_sias_2020";
		
		else if(nombreParametro.equalsIgnoreCase("username"))
			return "1722295126";
		else if(nombreParametro.equalsIgnoreCase("password"))
			return "6bd1e48bdfd68ac1a64aadca289933e3";
		else if(nombreParametro.equalsIgnoreCase("grant_type"))
			return "password";
		else if(nombreParametro.equalsIgnoreCase("idapli"))
			return "17";
		else if(nombreParametro.equalsIgnoreCase("CRED_WSMINIS_AUTH_SERVER_URI"))
			return "http://10.10.1.33:8080/wsministerial/oauth/token";
		else if(nombreParametro.equalsIgnoreCase("CRED_WSMINIS_QPM_PASSWORD_GRANT"))
			return "?grant_type=password&username=userprueba&password=acceso";
		else if(nombreParametro.equalsIgnoreCase("CRED_WSMINIS_QPM_ACCESS_TOKEN"))
			return "?access_token=";
		else 
			throw new MyInternalException("NO SE ENCONTR0 LA VARIABLE "+nombreParametro+" CONFIGURADA");
	}
	
	public  static String obtenerValorParametroProd(String nombreParametro) {
		if(nombreParametro.equalsIgnoreCase("VALIDAR_PRODUCTOR"))
			return "http://192.168.1.20:8080/micro_validacion-0.0.1/validate/productor";
		else if(nombreParametro.equalsIgnoreCase("REGISTRO_CIVIL_OLD"))
			return "http://10.10.1.17:8080/wsministerial";
		else if(nombreParametro.equalsIgnoreCase("BUSCAR_PRODUCTOR"))
			return "http://192.168.1.20:8080/micro_persona-0.0.1/productor/findByCedulaProductor";
		else if(nombreParametro.equalsIgnoreCase("CREAR_PRODUCTOR"))
			return "http://192.168.1.20:8080/micro_persona-0.0.1/productor/create";
		else if(nombreParametro.equalsIgnoreCase("REGISTRO_CIVIL_NEW"))
			return "http://192.168.1.20:8080/api_dinardap/api/dinardap/interoperador/1";
		else if(nombreParametro.equalsIgnoreCase("AUTH"))
			return "http://192.168.1.20:8080/servicio_seguridad-0.0.1/api/oauth/token"; //poner la local
		
		else if(nombreParametro.equalsIgnoreCase("username_apli"))
			return "us_servmag";
		else if(nombreParametro.equalsIgnoreCase("password_apli"))
			return "bdc8bd6bd776b48a2a";
		else if(nombreParametro.equalsIgnoreCase("username"))
			return "9999999901";
		else if(nombreParametro.equalsIgnoreCase("password"))
			return "dd81c37436ea3084cd828fd9e0753534";
		else if(nombreParametro.equalsIgnoreCase("grant_type"))
			return "password";
		else if(nombreParametro.equalsIgnoreCase("idapli"))
			return "92";
		else if(nombreParametro.equalsIgnoreCase("CRED_WSMINIS_AUTH_SERVER_URI"))
			return "http://10.10.1.17:8080/wsministerial/oauth/token";
		else if(nombreParametro.equalsIgnoreCase("CRED_WSMINIS_QPM_PASSWORD_GRANT"))
			return "?grant_type=password&username=userprueba&password=acceso";
		else if(nombreParametro.equalsIgnoreCase("CRED_WSMINIS_QPM_ACCESS_TOKEN"))
			return "?access_token=";
		else 
			throw new MyInternalException("NO SE ENCONTR0 LA VARIABLE "+nombreParametro+" CONFIGURADA");
	}
	
	
}
