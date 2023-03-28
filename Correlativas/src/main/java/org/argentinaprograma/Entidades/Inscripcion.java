package org.argentinaprograma.Entidades;

import java.util.Date;

import org.argentinaprograma.exceptions.CorrelativaNoAprobadaException;
import org.argentinaprograma.exceptions.MateriaAprobadaException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Inscripcion {

	private Alumno alumno;
	private Materia materia;
	private Date fecha;
	private boolean valida;
	
	public Inscripcion(Alumno alumno, Materia materia) {
		this.setAlumno(alumno);
		this.setMateria(materia);
		this.setFecha(new Date());
		this.setValida(false);
	}
	
	public String toString() {
		return "El/La alumno/a " + this.alumno.getNombre() + " de Legajo N°" + this.getAlumno().getLegajo() + " fue inscripto/a a " + this.getMateria().getNombre();
	}
	
	public boolean aprobada() throws MateriaAprobadaException, CorrelativaNoAprobadaException {
		
		if(this.getMateria().puedeCursar(this.getAlumno())) {
			this.setValida(true);
			return true;
		} else {
			return false;
		}
			
	}
	
}
