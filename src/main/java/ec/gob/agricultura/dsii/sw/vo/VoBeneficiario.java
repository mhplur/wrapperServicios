package ec.gob.agricultura.dsii.sw.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
public class VoBeneficiario {
	@NotNull(message = "La cedula es obligatorio")
	private String cedula;
	@NotNull(message = "Los apellidos son obligatorios")
	private String apellidos;
	@NotNull(message = "Los nombres son obligatorio")
	private String nombres;
	
	private String nombresApellidosCompletos;
	
	@Email(message = "Correo no valido")
	private String correo;
	
	@NotNull(message = "Los nombres sonobligatorio")
	private String direccion;
	
	@NotNull(message = "Los nombres son obligatorio")
	private String telefono;
	
	private String celular;
	
	private String codInecParroquia;
	
	@NotNull(message = "La fecha de nacimiento es obligatoria")
	private String fechaNacimiento;
	
	//CAMPOS NUEVOS
	
	private String genero;
	private String estadoCivil;
	@NotNull(message = "El id del domicilio es obligatorio")
	private String ubiIdDomicilio;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNombresApellidosCompletos() {
		return this.apellidos+" "+ this.nombres;
	}

	public void setNombresApellidosCompletos(String nombresApellidosCompletos) {
		this.nombresApellidosCompletos = nombresApellidosCompletos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCodInecParroquia() {
		return codInecParroquia;
	}

	public void setCodInecParroquia(String codInecParroquia) {
		this.codInecParroquia = codInecParroquia;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getUbiIdDomicilio() {
		return ubiIdDomicilio;
	}

	public void setUbiIdDomicilio(String ubiIdDomicilio) {
		this.ubiIdDomicilio = ubiIdDomicilio;
	}

	

}
