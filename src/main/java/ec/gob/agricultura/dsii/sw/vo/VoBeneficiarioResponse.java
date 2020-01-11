package ec.gob.agricultura.dsii.sw.vo;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class VoBeneficiarioResponse {

	@XmlElement(name = "benId")
	private int benId;
	@XmlElement(name = "observacion")
	private String observacion;
	
	@XmlElement(name = "estado")
	private String estado;
	

	public int getBenId() {
		return benId;
	}

	public void setBenId(int benId) {
		this.benId = benId;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
