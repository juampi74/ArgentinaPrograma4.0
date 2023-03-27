package org.argentinaprograma.datosPersonas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.argentinaprograma.datosPersonas.entidades.Persona;

public class Main {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		List<Persona> personas = new ArrayList<Persona>();
		
		Boolean cargarOtra = true;
		
		while(cargarOtra) {
			
			System.out.println("Ingrese Nombre:");
			String nombre = scn.nextLine();
			
			System.out.println("Ingrese Apellido:");
			String apellido = scn.nextLine();
			
			System.out.println("--Fecha de Nacimiento--");
			System.out.println("Ingrese Dia:");
			String dia = scn.nextLine();
			System.out.println("Ingrese Mes:");
			String mes = scn.nextLine();
			System.out.println("Ingrese Año:");
			String anio = scn.nextLine();
			
			SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
			
			Date fecha;
			
			try {
				fecha = formato.parse(anio + "/" + mes + "/" + dia);
				personas.add(new Persona(nombre, apellido, fecha));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			System.out.println("¿Desea cargar los datos de otra Persona? <Si o No>");
			String cargar = scn.nextLine().toLowerCase();
			while(cargar.compareTo("si") != 0 && cargar.compareTo("no") != 0) {
				System.out.println("Error! <Si o No>");
				cargar = scn.nextLine();
			}
			
			if(cargar.equals("no")) {
				cargarOtra = false;
				
				System.out.println("¿Desea listar los datos de las personas cargadas? <Si o No>");
				String listar = scn.nextLine().toLowerCase();
				while(listar.compareTo("si") != 0 && listar.compareTo("no") != 0) {
					System.out.println("Error! <Si o No>");
					listar = scn.nextLine();
				}
				
				if(listar.equals("si")) {
					
					System.out.println("\n--Listado de Personas--");
					
					for(Persona persona : personas) {
						System.out.println(persona.toString());
					}
					
				}
				
			} 
			
		}
		
		
	}

}
