package ec.gob.agricultura.dsii.sw.servicio.rna.dto;

import java.util.List;

public class UsuarioDto {
	private Integer usuId;
	private Integer usupId;
	private List<PerfilTipoDto> perfilTipo;
	public Integer getUsuId() {
		return usuId;
	}
	public void setUsuId(Integer usuId) {
		this.usuId = usuId;
	}
	public Integer getUsupId() {
		return usupId;
	}
	public void setUsupId(Integer usupId) {
		this.usupId = usupId;
	}
	public List<PerfilTipoDto> getPerfilTipo() {
		return perfilTipo;
	}
	public void setPerfilTipo(List<PerfilTipoDto> perfilTipo) {
		this.perfilTipo = perfilTipo;
	}
	
	
}
