package ec.gob.agricultura.dsii.sw.env;

import ec.gob.agricultura.dsii.sw.exception.MyInternalException;

public class Config {
	/**
	 * DEV/PROD/TEST
	 * */
	public static final String ENVIRONMENT_CONFIG="DEV";
	
	public  static String obtenerValorParametro(String nombreParametro) {
		if(ENVIRONMENT_CONFIG.equalsIgnoreCase("DEV"))
			return MyEnviroment.obtenerValorParametroDev(nombreParametro);
		else if (ENVIRONMENT_CONFIG.equalsIgnoreCase("PROD"))
			return MyEnviroment.obtenerValorParametroProd(nombreParametro);
		else if (ENVIRONMENT_CONFIG.equalsIgnoreCase("TEST"))
			return MyEnviroment.obtenerValorParametroTest(nombreParametro);
		else 
			throw new MyInternalException("NO EXISTE EL ENTORNO SELECCIONADO.");
		
	}
	
}
