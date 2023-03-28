package org.argentinaprograma.Entidades;

import java.util.ArrayList;
import java.util.List;

import org.argentinaprograma.exceptions.CorrelativaNoAprobadaException;
import org.argentinaprograma.exceptions.MateriaAprobadaException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Materia {

	private String nombre;
	private List<Materia> correlativas;
	
	public Materia(String nombre) {
		this.setNombre(nombre);
		this.correlativas = new ArrayList<Materia>();
	}
	
	public boolean puedeCursar(Alumno alumno) throws MateriaAprobadaException, CorrelativaNoAprobadaException {
		
		boolean puede;
		
		if(alumno.getMateriasAprobadas().size() == 0 && this.correlativas.size() == 0) {
			puede = true;
		} else if (alumno.getMateriasAprobadas().size() == 0 && this.correlativas.size() != 0) {
			puede = false;
			throw new CorrelativaNoAprobadaException();
		} else {
			
			int i = 0;
			
			while(alumno.getMateriasAprobadas().get(i).getNombre().compareTo(this.getNombre()) != 0 && i < alumno.getMateriasAprobadas().size()) {
				i++;
				if(i == alumno.getMateriasAprobadas().size()) {
					break;
				}
				
			}
			
			if(i == alumno.getMateriasAprobadas().size()) {
				puede = true; //No aprobó la materia, entonces la puede cursar
				
				int j = 0;
				int c = 0;
				for(Materia correlativa : this.getCorrelativas()) {
					while(alumno.getMateriasAprobadas().get(j).getNombre().compareTo(correlativa.getNombre()) != 0 && j < alumno.getMateriasAprobadas().size()) {
						j++;
					}
					if(j == 0) {
						j++;
					}
					if(alumno.getMateriasAprobadas().get(j - 1).getNombre().equals(correlativa.getNombre())) {
						c++;
					}
				}
				
				if(c == correlativas.size()) {
					puede = true; //Aprobó todas las correlativas, entonces la puede cursar
				} else {
					puede = false; //No aprobó todas las correlativas, entonces no la puede cursar
					throw new CorrelativaNoAprobadaException();
				}
				
				
			} else {
				puede = false; //Ya aprobó la materia, entonces no la puede cursar
				throw new MateriaAprobadaException();
			}
		}
		
		return puede;
		
	}

	public void agregarCorrelativa(Materia c) {
		this.correlativas.add(c);
	}
	
	public void quitarCorrelativa(Materia c) {
		this.correlativas.remove(c);
	}
	
}
