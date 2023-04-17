package org.argentinaprograma.Reg_Exp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    
	public static void main(String[] args) {

		if(args.length != 2){
            System.out.println("ERROR: No ingresaste los archivos correspondientes!");
            System.exit(88);
        }
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Qué archivo ingresaste? <1 - 2>: ");
		String archivo = scn.nextLine();
		
		while(archivo.compareTo("1") != 0 && archivo.compareTo("2") != 0) {
			System.out.println("Error! <1 - 2>: ");
			archivo = scn.nextLine();
		}
		
		System.out.println("\n");
		
		ArrayList<String> lineas = leerLineasArchivo(args[0]);
		
		String regexp = args[1];
		
		int i = 0;
		
		for(String linea : lineas) {
			
			
			if(archivo.equals("1")) {
			
				if(linea.matches(regexp)) {
					
					System.out.println("Linea " + (i + 1) + " (" + lineas.get(i) + "): Se corresponde con la Expresión Regular");
					
				} else {
					
					System.out.println("Linea " + (i + 1) + " (" + lineas.get(i) + "): NO se corresponde con la Expresión Regular");
					
				}
				
			} else {
				
				final Pattern pattern = Pattern.compile(regexp, Pattern.MULTILINE);
				final Matcher matcher = pattern.matcher(linea);
				
				while(matcher.find()) {
					System.out.println("Full match: " + matcher.group(0));

					for(int j = 1; j <= matcher.groupCount(); j++) {
						System.out.println("Group " + j + ": " + matcher.group(j));
					}
					
					System.out.println("\n");
					
				}
				
			}
						
			i++;
			
		}	
		
    }

	private static ArrayList<String> leerLineasArchivo(String rutaArchivo) {

		Path pathRelativoArchivo = Paths.get(rutaArchivo);
		
		ArrayList<String> lineas = new ArrayList<>();
		
		try {
			for(String linea : Files.readAllLines(pathRelativoArchivo)) {
				lineas.add(linea);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return lineas;

	}
}
