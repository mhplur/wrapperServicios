package ec.gob.agricultura.dsii.sw.dto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import ec.gob.agricultura.dsii.sw.vo.VoRespuestaRegistroCivil;

@XmlType(name = "SumResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class SumResponse {

//	@XmlElement(name = "result")
//	private int result;

	@XmlElement(name = "respuestaRegistroCivil")
	private VoRespuestaRegistroCivil respuestaRegistroCivil;


//	public int getResult() {
//		return result;
//	}
//
//	public void setResult(int result) {
//		this.result = result;
//	}

public VoRespuestaRegistroCivil getRespuestaRegistroCivil() {
		return respuestaRegistroCivil;
	}

	public void setRespuestaRegistroCivil(VoRespuestaRegistroCivil respuestaRegistroCivil) {
		this.respuestaRegistroCivil = respuestaRegistroCivil;
	}

	

	

}
