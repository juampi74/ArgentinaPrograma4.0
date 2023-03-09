package practica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ej2aClase4 {

	public static void main(String[] args) {
		
		String rutaArchivo = "recursos/ArchivoTexto.txt";
		char operacion = 'M';
		
		numerosArchivo(rutaArchivo, operacion);
	
	}
	
	public static void numerosArchivo(String rutaArchivo, char operacion) {
		
		Path pathRelativo = Paths.get(rutaArchivo);
		int suma = 0;
		int mult = 0;
		int c = 0;
		
		try {
			
			for(String linea : Files.readAllLines(pathRelativo)) {
				
				if(operacion == 'S') {
				
					suma = suma + Integer.parseInt(linea);
				
				} else {
					
					if(c == 0) {
						
						mult = Integer.parseInt(linea);
						
					} else {
						
						mult = mult * Integer.parseInt(linea);
					
					}
					
				}
				
				c++;
			}
			
			if(operacion == 'S') {
				
				System.out.println("El resultado de la suma de los números del archivo de texto es: " + suma);
				
			} else {
				
				System.out.println("El resultado de la multiplicación de los números del archivo de texto es: " + mult);
				
			}
			
		} catch(IOException e) {
			
			e.printStackTrace();
		
		}
		
	}

}