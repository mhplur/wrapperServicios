package ec.gob.agricultura.dsii.sw.vo;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import net.shibboleth.utilities.java.support.annotation.constraint.NotEmpty;
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
	
	@NotNull(message = "Los direccion es obligatorio")
	@NotBlank(message = "Los direccion es obligatorio")
	private String direccion;
	
	@NotNull(message = "El télefon es obligatorio")
	private String telefono;
	
	private String celular;
	
	private String codInecParroquia;
	
	@NotNull(message = "La fecha de nacimiento es obligatoria")
	private String fechaNacimiento;
	
	private String lugarNacimiento;
	
	//CAMPOS NUEVOS
	
	private String genero;
	private String estadoCivil;
	//verificar si me puede enviar el id de la parroquia, si no puede enviar 1 por defecto
	@NotNull(message = "El id del domicilio es obligatorio")
	private String ubiIdDomicilio;

	public String getCedula() {
		return cedula;
	}

	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
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

	@Override
	public String toString() {
		return "VoBeneficiario [cedula=" + cedula + ", apellidos=" + apellidos + ", nombres=" + nombres
				+ ", nombresApellidosCompletos=" + nombresApellidosCompletos + ", correo=" + correo + ", direccion="
				+ direccion + ", telefono=" + telefono + ", celular=" + celular + ", codInecParroquia="
				+ codInecParroquia + ", fechaNacimiento=" + fechaNacimiento + ", lugarNacimiento=" + lugarNacimiento
				+ ", genero=" + genero + ", estadoCivil=" + estadoCivil + ", ubiIdDomicilio=" + ubiIdDomicilio
				+ ", getCedula()=" + getCedula() + ", getLugarNacimiento()=" + getLugarNacimiento()
				+ ", getApellidos()=" + getApellidos() + ", getNombres()=" + getNombres()
				+ ", getNombresApellidosCompletos()=" + getNombresApellidosCompletos() + ", getCorreo()=" + getCorreo()
				+ ", getDireccion()=" + getDireccion() + ", getTelefono()=" + getTelefono() + ", getCelular()="
				+ getCelular() + ", getCodInecParroquia()=" + getCodInecParroquia() + ", getFechaNacimiento()="
				+ getFechaNacimiento() + ", getGenero()=" + getGenero() + ", getEstadoCivil()=" + getEstadoCivil()
				+ ", getUbiIdDomicilio()=" + getUbiIdDomicilio() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	

}
