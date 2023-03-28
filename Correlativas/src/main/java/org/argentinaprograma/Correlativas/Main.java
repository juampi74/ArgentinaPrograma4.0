package org.argentinaprograma.Correlativas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.argentinaprograma.Entidades.Alumno;
import org.argentinaprograma.Entidades.CSVManage;
import org.argentinaprograma.Entidades.Inscripcion;
import org.argentinaprograma.Entidades.Materia;
import org.argentinaprograma.exceptions.CorrelativaNoAprobadaException;
import org.argentinaprograma.exceptions.MateriaAprobadaException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Main {

	public static void main(String[] args) {
		
		if(args.length == 0){
            System.out.println("ERROR: No ingresaste ningun archivo como argumento!");
            System.exit(88);
        }
		
		CSVManage csvManage = new CSVManage();
		
		// Inicializacion materias
		List<Materia> materias = new ArrayList<Materia>();
		
		materias.add(new Materia("Programacion I"));
		materias.add(new Materia("Programacion II"));
		materias.add(new Materia("Programacion III"));
		
		materias.add(new Materia("Bases de Datos I"));
		materias.add(new Materia("Bases de Datos II"));
		materias.add(new Materia("Bases de Datos III"));
		
		materias.get(2).agregarCorrelativa(materias.get(0));
		materias.get(2).agregarCorrelativa(materias.get(1));
		
		materias.get(1).agregarCorrelativa(materias.get(0));
		
		materias.get(5).agregarCorrelativa(materias.get(3));
		materias.get(5).agregarCorrelativa(materias.get(4));
		
		materias.get(4).agregarCorrelativa(materias.get(3));
		
		
		//Inicializacion alumnos
		List<Alumno> alumnos = new ArrayList<Alumno>();
		
		alumnos.add(new Alumno("Jose Rodriguez", "25678"));
		alumnos.add(new Alumno("Vanesa Sosa", "31496"));
		alumnos.add(new Alumno("Lucia Perez", "19620"));
		
		alumnos.get(0).agregarMatAprobada(materias.get(0));
		alumnos.get(0).agregarMatAprobada(materias.get(3));
		
		alumnos.get(2).agregarMatAprobada(materias.get(3));
		
		
		//Leer Archivo de Inscripciones
		try {
			CSVReader lector = new CSVReader(new FileReader(args[0]));

			String[] inscCSV;
			String[] arrayInscripciones;
			List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
			
			while((inscCSV = lector.readNext()) != null) {
				arrayInscripciones = inscCSV[0].split(";");
				
				String alumno = "";
				String materia = "";
				
				int i = 0;
				while(arrayInscripciones[0].compareTo(alumnos.get(i).getNombre()) != 0 && i < alumnos.size()) {
					i++;
					if(i == alumnos.size()) {
						break;
					}
				}
				
				boolean alumExist;
				
				if(i < alumnos.size()) {
					alumno = alumnos.get(i).getNombre();
					alumExist = true;
				} else {
					alumno = arrayInscripciones[0];
					alumExist = false;
				}
				
				int j = 0;
				while(arrayInscripciones[1].compareTo(materias.get(j).getNombre()) != 0 && j < materias.size()) {
					j++;
					if(j == materias.size()) {
						break;
					}
				}
				
				boolean matExist;
				
				if(j < materias.size()) {
					materia = materias.get(j).getNombre();
					matExist = true;
				} else {
					materia = arrayInscripciones[1];
					matExist = false;
				}
				
				System.out.printf("  |  %-20s|  %-20s|  ", alumno, materia);
				
				String mensaje = "";
				
				if(!alumExist) {
					mensaje = "No existe el/la alumno/a";
					csvManage.writeCSV("src/main/resources/resultados.csv", alumno, materia, mensaje);
					System.out.println(mensaje);
				} else if(!matExist) {
					mensaje = "No existe la materia";
					csvManage.writeCSV("src/main/resources/resultados.csv", alumno, materia, mensaje);
					System.out.println(mensaje);
				} else {
					
					int c = 0;
					for(Inscripcion inscripcion : inscripciones) {
						if(inscripcion.getAlumno().getNombre().equals(alumno)) {
							if(inscripcion.getMateria().getNombre().equals(materia)) {
								if(inscripcion.isValida()) {
									c++;
								}
							}
						}
					}
					
					
					if(c == 0) {
						
						inscripciones.add(new Inscripcion(alumnos.get(i), materias.get(j)));
																	
						try {
							if(inscripciones.get(inscripciones.size() - 1).aprobada()) {
								mensaje = "Aprobado";
								csvManage.writeCSV("src/main/resources/resultados.csv", alumno, materia, mensaje);
								System.out.println(mensaje);
							}
						} catch (MateriaAprobadaException e) {
							mensaje = "Rechazado (Materia Aprobada)";
							csvManage.writeCSV("src/main/resources/resultados.csv", alumno, materia, mensaje);
							System.out.println(mensaje);
						} catch (CorrelativaNoAprobadaException e) {
							mensaje = "Rechazado (Correlativas No Aprobadas)";
							csvManage.writeCSV("src/main/resources/resultados.csv", alumno, materia, mensaje);
							System.out.println(mensaje);
						}
								
					} else {
						mensaje = "Rechazado (Inscripcion Ya Realizada)";
						csvManage.writeCSV("src/main/resources/resultados.csv", alumno, materia, mensaje);
						System.out.println(mensaje);
					}

					}
				
			} 
			
			System.out.println("\n ------------------------ Información Cargada en el Archivo CSV! ------------------------ ");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CsvValidationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}