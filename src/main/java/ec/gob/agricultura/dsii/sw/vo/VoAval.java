package ec.gob.agricultura.dsii.sw.vo;

import java.util.Date;

public class VoAval {

	private int avalId; //
	private int benCedula; //
	private String benApellidosnombres; //
	private String ubiCodInecProv;//
	private String ubiCodInecCant;//
	private String ubiCodInecParr;//
	private String preNomRecinto;//
	private String preDireccion;//
	private String preNombre;//
	private String codCulBanEcuador;// homologar 1=maiz duro 2 = arroz
	private String pcCoordX;//
	private String pcCoordY;//
	private int avalHectareasFinanciar;//
	private Date avalFechaTentativaSiembra;//
	// private String avalEstadoProceso;
	// private int avalEstado;// validar en consulta especifica 11= activo
	// 12=inactivo

	
	public VoAval() {
		this.avalId=1;
		this.benCedula=1201478391;
		this.benApellidosnombres="GARCIA MACIAS EULOGIO REIBER";
		this.ubiCodInecProv="12";
		this.ubiCodInecCant="01";
		this.ubiCodInecParr="53";
		this.preNomRecinto="SAN VICENTE";
		this.preDireccion="SAN VICENTE";
		this.preNombre="S/N";
		this.codCulBanEcuador="001021";
		this.pcCoordX="673241";
		this.pcCoordY="9789644";
		this.avalHectareasFinanciar=5;
		this.avalFechaTentativaSiembra= new Date();
	}
	
	
	public int getAvalId() {
		return avalId;
	}

	public void setAvalId(int avalId) {
		this.avalId = avalId;
	}

	public int getBenCedula() {
		return benCedula;
	}

	public void setBenCedula(int benCedula) {
		this.benCedula = benCedula;
	}

	public String getBenApellidosnombres() {
		return benApellidosnombres;
	}

	public void setBenApellidosnombres(String benApellidosnombres) {
		this.benApellidosnombres = benApellidosnombres;
	}

	public String getUbiCodInecProv() {
		return ubiCodInecProv;
	}

	public void setUbiCodInecProv(String ubiCodInecProv) {
		this.ubiCodInecProv = ubiCodInecProv;
	}

	public String getUbiCodInecCant() {
		return ubiCodInecCant;
	}

	public void setUbiCodInecCant(String ubiCodInecCant) {
		this.ubiCodInecCant = ubiCodInecCant;
	}

	public String getUbiCodInecParr() {
		return ubiCodInecParr;
	}

	public void setUbiCodInecParr(String ubiCodInecParr) {
		this.ubiCodInecParr = ubiCodInecParr;
	}

	public String getPreNomRecinto() {
		return preNomRecinto;
	}

	public void setPreNomRecinto(String preNomRecinto) {
		this.preNomRecinto = preNomRecinto;
	}

	public String getPreDireccion() {
		return preDireccion;
	}

	public void setPreDireccion(String preDireccion) {
		this.preDireccion = preDireccion;
	}

	public String getPreNombre() {
		return preNombre;
	}

	public void setPreNombre(String preNombre) {
		this.preNombre = preNombre;
	}

	
	

	public String getCodCulBanEcuador() {
		return codCulBanEcuador;
	}


	public void setCodCulBanEcuador(String codCulBanEcuador) {
		this.codCulBanEcuador = codCulBanEcuador;
	}


	public String getPcCoordX() {
		return pcCoordX;
	}

	public void setPcCoordX(String pcCoordX) {
		this.pcCoordX = pcCoordX;
	}

	public String getPcCoordY() {
		return pcCoordY;
	}

	public void setPcCoordY(String pcCoordY) {
		this.pcCoordY = pcCoordY;
	}

	public int getAvalHectareasFinanciar() {
		return avalHectareasFinanciar;
	}

	public void setAvalHectareasFinanciar(int avalHectareasFinanciar) {
		this.avalHectareasFinanciar = avalHectareasFinanciar;
	}

	public Date getAvalFechaTentativaSiembra() {
		return avalFechaTentativaSiembra;
	}

	public void setAvalFechaTentativaSiembra(Date avalFechaTentativaSiembra) {
		this.avalFechaTentativaSiembra = avalFechaTentativaSiembra;
	}

}
