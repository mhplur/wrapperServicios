package ec.gob.agricultura.dsii.util;

import ec.gob.agricultura.dsii.sw.vo.VoBeneficiario;
import ec.gob.agricultura.dsii.sw.vo.VoRespuestaRegistroCivil;

public class CompleteData {
	public static Integer buscarRnaIdGenero(String genero) {
		if(genero=="MASCULINO"|| genero=="M")
			return 21;
		if(genero=="FEMENINO"|| genero=="F")
			return 22;
		return 21;
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

	public static VoBeneficiario completarDatosRegistroCivil(VoBeneficiario data) {
		if(data.getCelular().equals("") || data.getCelular().equals(null)
				|| data.getCelular()==null ||data.getCelular().length()<10)
			data.setCelular("0000000000");
		data.setGenero(buscarRnaIdGenero(data.getGenero()).toString());
		data.setEstadoCivil(buscarRnaIdEstadoCivil(data.getEstadoCivil()).toString());
		return data;
	}
}
