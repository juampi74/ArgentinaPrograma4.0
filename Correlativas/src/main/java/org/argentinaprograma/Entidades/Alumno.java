package org.argentinaprograma.Entidades;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Alumno {

	private String nombre;
	private String legajo;
	private List<Materia> materiasAprobadas;
	
	public Alumno(String nombre, String legajo) {
		this.setNombre(nombre);
		this.setLegajo(legajo);
		this.materiasAprobadas = new ArrayList<Materia>();
	}
	
	public void agregarMatAprobada(Materia ma) {
		this.materiasAprobadas.add(ma);
	}
	
	public void quitarMatAprobada(Materia ma) {
		this.materiasAprobadas.remove(ma);
	}
	
}
