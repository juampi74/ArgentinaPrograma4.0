package org.argentinaprograma.Correlativas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



import org.argentinaprograma.Entidades.Alumno;
import org.argentinaprograma.Entidades.Inscripcion;
import org.argentinaprograma.Entidades.Materia;
import org.argentinaprograma.exceptions.CorrelativaNoAprobadaException;
import org.argentinaprograma.exceptions.MateriaAprobadaException;

public class MainTest {

	@Test
	public void validarInscripcionAprobadaSinCorrelativas() throws MateriaAprobadaException, CorrelativaNoAprobadaException {
		
		Materia programacionI = new Materia("Programacion I");
		Materia programacionII = new Materia("Programacion II");
		Materia basesDeDatosI = new Materia("Bases de Datos I");
		
		programacionII.agregarCorrelativa(programacionI);
		
		Alumno alumno = new Alumno("Jose Rodriguez", "25678");
		
		Inscripcion inscripcion = new Inscripcion(alumno, basesDeDatosI);
		
		assertTrue(inscripcion.aprobada());
		
	}
	
	@Test
	public void validarInscripcionAprobadaConCorrelativasYQueElAlumnoLasTenga() throws MateriaAprobadaException, CorrelativaNoAprobadaException {
		
		Materia programacionI = new Materia("Programacion I");
		Materia programacionII = new Materia("Programacion II");
		Materia basesDeDatosI = new Materia("Bases de Datos I");
		
		programacionII.agregarCorrelativa(programacionI);
		
		Alumno alumno = new Alumno("Jose Rodriguez", "25678");
		alumno.agregarMatAprobada(programacionI);
		
		Inscripcion inscripcion = new Inscripcion(alumno, programacionII);
		
		
		assertTrue(inscripcion.aprobada());
		
	}
	
	@Test
	public void validarInscripcionAprobadaConCorrelativasYQueElNoAlumnoLasTenga() {
		
		Materia programacionI = new Materia("Programacion I");
		Materia programacionII = new Materia("Programacion II");
		Materia basesDeDatosI = new Materia("Bases de Datos I");
		
		programacionII.agregarCorrelativa(programacionI);
		
		Alumno alumno = new Alumno("Jose Rodriguez", "25678");
		
		Inscripcion inscripcion = new Inscripcion(alumno, programacionII);
		
		
		try {
			inscripcion.aprobada();
		} catch (CorrelativaNoAprobadaException e) {
			System.out.println("\n------------------ Solicitud Rechazada (Correlativas No Aprobadas)------------------ \n");
		} catch (MateriaAprobadaException e) {
			
		}
		
	}
	

}
