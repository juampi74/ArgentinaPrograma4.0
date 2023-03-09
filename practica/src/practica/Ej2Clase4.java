package practica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ej2Clase4 {

	public static void main(String[] args) {
		
		String rutaArchivo = "recursos/ArchivoTexto.txt";

		
		numerosArchivo(rutaArchivo);
	
	}
	
	public static void numerosArchivo(String rutaArchivo) {
		
		Path pathRelativo = Paths.get(rutaArchivo);
		int suma = 0;
		
		try {
			for(String linea : Files.readAllLines(pathRelativo)) {
				suma = suma + Integer.parseInt(linea);
			}
			System.out.println("El resultado de la suma de los números del archivo de texto es: " + suma);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
