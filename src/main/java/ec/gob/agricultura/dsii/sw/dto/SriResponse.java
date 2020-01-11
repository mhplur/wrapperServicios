package ec.gob.agricultura.dsii.sw.dto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import ec.gob.agricultura.dsii.sw.vo.VoRespuestaSri;

@XmlType(name = "SriResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class SriResponse {

	// @XmlElement(name = "result")
	// private int result;

	@XmlElement(name = "respuestaSri")
	private VoRespuestaSri respuestaSri;

	public VoRespuestaSri getRespuestaSri() {
		return respuestaSri;
	}

	public void setRespuestaSri(VoRespuestaSri respuestaSri) {
		this.respuestaSri = respuestaSri;
	}

}
