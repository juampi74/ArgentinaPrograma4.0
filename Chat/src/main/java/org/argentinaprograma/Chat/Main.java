package org.argentinaprograma.Chat;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import modelo.Mensaje;
import modelo.CSVManage;

public class Main {
    
	public static void main(String[] args) throws CsvValidationException, IOException {

		boolean continuar = true;
		
		while(continuar) {
			
			Scanner scn = new Scanner(System.in);
			
			try {
					
				System.out.println("Ingrese su nombre: ");
				String nombre = scn.nextLine();
				
				System.out.println("Hola " + nombre + "!");
				
				CSVReader lector = new CSVReader(new FileReader("src/main/resources/chat.csv"));
				String[] mensajesCSV;
				String[] mensajes;
				ArrayList<Mensaje> contenedor = new ArrayList<Mensaje>();
				int i = 0;
				
				while((mensajesCSV = lector.readNext()) != null) {
					mensajes = mensajesCSV[0].split(";");
							
					contenedor.add(new Mensaje(mensajes[0], mensajes[1]));
					
					i++;
				}
				
				
				System.out.println("Quiere leer todos los mensajes? <Si - No>");
				String leerMensajes = scn.nextLine();
				
				while(leerMensajes.compareToIgnoreCase("SI") != 0 && leerMensajes.compareToIgnoreCase("NO") != 0) {
					System.out.println("Error! <Si - No>");
					leerMensajes = scn.nextLine();
				}
				
				if(leerMensajes.equalsIgnoreCase("SI")) {
					for(Mensaje mensaje : contenedor) {
						System.out.println(" - " + mensaje.getUsuario() + ": " + mensaje.getMensaje());
					}
				}
				
				
				
				System.out.println("Quiere escribir un mensaje? <Si - No>");
				String escribirMensaje = scn.nextLine();
				
				while(escribirMensaje.compareToIgnoreCase("SI") != 0 && escribirMensaje.compareToIgnoreCase("NO") != 0) {
					System.out.println("Error! <Si - No>");
					escribirMensaje = scn.nextLine();
				}
				
				if(escribirMensaje.equalsIgnoreCase("SI")) {
				
					System.out.println("Ingrese mensaje: ");
					String msj = scn.nextLine();
					
					
					escribirMensaje(nombre, msj);
					
				}
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
		
			System.out.println("Quiere continuar? <Si - No>");
			String c = scn.nextLine();
			
			while(c.compareToIgnoreCase("SI") != 0 && c.compareToIgnoreCase("NO") != 0) {
				System.out.println("Error! <Si - No>");
				c = scn.nextLine();
			}
		
			if(c.equalsIgnoreCase("NO")) {
				continuar = false; 
			}
		
		}
    
		System.out.println("Programa Finalizado");
		
	}

	private static void escribirMensaje(String nombre, String msj) {
		
		CSVManage csvManage = new CSVManage();
		
		csvManage.writeCSV("src/main/resources/chat.csv", nombre, msj);
		
	}	
    
	
}
