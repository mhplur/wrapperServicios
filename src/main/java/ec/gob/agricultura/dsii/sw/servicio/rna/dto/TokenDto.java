package ec.gob.agricultura.dsii.sw.servicio.rna.dto;

import java.util.List;

public class TokenDto {
	private Integer apliId;
	private String user_name;
	private List<String> scope;
	private List<RolDto> roles;
	private List<RecursoDto> recursos;
	private Integer exp;
	private List<UsuarioDto> usuarios;
	private List<String> authorities;
	private String jti;
	private Integer per_id;
	private String client_id;
	public Integer getApliId() {
		return apliId;
	}
	public void setApliId(Integer apliId) {
		this.apliId = apliId;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public List<String> getScope() {
		return scope;
	}
	public void setScope(List<String> scope) {
		this.scope = scope;
	}
	public List<RolDto> getRoles() {
		return roles;
	}
	public void setRoles(List<RolDto> roles) {
		this.roles = roles;
	}
	public List<RecursoDto> getRecursos() {
		return recursos;
	}
	public void setRecursos(List<RecursoDto> recursos) {
		this.recursos = recursos;
	}
	public Integer getExp() {
		return exp;
	}
	public void setExp(Integer exp) {
		this.exp = exp;
	}
	public List<UsuarioDto> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<UsuarioDto> usuarios) {
		this.usuarios = usuarios;
	}
	public List<String> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}
	public String getJti() {
		return jti;
	}
	public void setJti(String jti) {
		this.jti = jti;
	}
	public Integer getPer_id() {
		return per_id;
	}
	public void setPer_id(Integer per_id) {
		this.per_id = per_id;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	
	
}
