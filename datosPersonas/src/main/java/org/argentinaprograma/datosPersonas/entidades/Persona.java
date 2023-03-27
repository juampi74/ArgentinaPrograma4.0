package org.argentinaprograma.datosPersonas.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Persona {

	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	
	public Persona(String nombre, String apellido, Date fechaNacimiento) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setFechaNacimiento(fechaNacimiento);
	}
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String fechaNac = sdf.format(this.getFechaNacimiento());
		
		return "+ " + this.getNombre() + " " + this.getApellido() + " - " + fechaNac;
	}
	
}
