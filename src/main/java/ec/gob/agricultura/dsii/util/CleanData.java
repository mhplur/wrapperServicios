package ec.gob.agricultura.dsii.util;

import ec.gob.agricultura.dsii.sw.vo.VoRespuestaRegistroCivil;

public class CleanData {

	public static VoRespuestaRegistroCivil cleanDatosRegistroCivil(VoRespuestaRegistroCivil data) {
		if (data.getNUI() != "" && data.getNUI() != null) {
			if (data.getGenero() == null && data.getSexo()!=null)
				if (data.getSexo().equals("HOMBRE"))
					data.setGenero("MASCULINO");
				else
					data.setGenero("FEMENINO");

			if (data.getEstadoCivil() == null)
				data.setEstadoCivil("SOLTERO");
			if (data.getDomicilio() == null)
				data.setDomicilio("");
			
			data.setCalle((data.getCalle() != null ? data.getCalle().trim() : data.getCalle()));
			data.setCodigoDomicilio(
					(data.getCodigoDomicilio() != null ? data.getCodigoDomicilio().trim() : data.getCodigoDomicilio()));

			data.setCondicionCedulado((data.getCondicionCedulado() != null ? data.getCondicionCedulado().trim()
					: data.getCondicionCedulado()));
			data.setConyuge((data.getConyuge() != null ? data.getConyuge().trim() : data.getConyuge()));
			data.setNombrePadre((data.getNombrePadre() != null ? data.getNombrePadre().trim() : data.getNombrePadre()));
			data.setNombreMadre((data.getNombreMadre() != null ? data.getNombreMadre().trim() : data.getNombreMadre()));

			data.setDomicilio((data.getDomicilio() != null ? data.getDomicilio().trim() : data.getDomicilio()));
			data.setError((data.getError() != null ? data.getError().trim() : data.getError()));
			data.setCodigoError((data.getCodigoError() != null ? data.getCodigoError().trim() : data.getCodigoError()));
			data.setEstadoCivil((data.getEstadoCivil() != null ? data.getEstadoCivil().trim() : data.getEstadoCivil()));
			data.setFechaInscripcionGenero(
					(data.getFechaInscripcionGenero() != null ? data.getFechaInscripcionGenero().trim()
							: data.getFechaInscripcionGenero()));
			data.setFechaNacimiento(
					(data.getFechaNacimiento() != null ? data.getFechaNacimiento().trim() : data.getFechaNacimiento()));
			data.setGenero((data.getGenero() != null ? data.getGenero().trim() : data.getGenero()));
			data.setInstruccion((data.getInstruccion() != null ? data.getInstruccion().trim() : data.getInstruccion()));

			data.setLugarInscripcionGenero(
					(data.getLugarInscripcionGenero() != null ? data.getLugarInscripcionGenero().trim()
							: data.getLugarInscripcionGenero()));
			data.setLugarNacimiento(
					(data.getLugarNacimiento() != null ? data.getLugarNacimiento().trim() : data.getLugarNacimiento()));

			data.setNombre((data.getNombre() != null ? data.getNombre().trim() : data.getNombre()));
			data.setNumeroCasa((data.getNumeroCasa() != null ? data.getNumeroCasa().trim() : data.getNumeroCasa()));
			data.setSexo((data.getSexo() != null ? data.getSexo().trim() : data.getSexo()));
			data.setFechaDefuncion(
					(data.getFechaDefuncion() != null ? data.getFechaDefuncion().trim() : data.getFechaDefuncion()));
			data.setNacionalidad(
					(data.getNacionalidad() != null ? data.getNacionalidad().trim() : data.getNacionalidad()));
			data.setNUI((data.getNUI() != null ? data.getNUI().trim() : data.getNUI()));
		}
		return data;
	}
}
