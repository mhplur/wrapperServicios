package ec.gob.agricultura.dsii.sw.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="SumRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class SumRequest {

	@XmlElement(name="parametro")
	private String parametro;

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	

	

}
