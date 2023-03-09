package practica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ej3Clase4 {

	public static void main(String[] args) throws IOException {

		Scanner scn = new Scanner(System.in);
		
		String archivoEntrada = "recursos/ArchivoEntrada.txt";
		String archivoSalida = "recursos/ArchivoSalida.txt";

		
		System.out.println("Ingrese C para Codificar o D para Decodificar:");
		char op = scn.nextLine().toLowerCase().charAt(0);
		while(op != 'c' && op != 'd') {
			System.out.println("Error! Ingrese C o D:");
			op = scn.nextLine().toLowerCase().charAt(0);
		}
		
		System.out.println("Ingrese valor de desplazamiento:");
		int desplazamiento = Integer.parseInt(scn.nextLine());
		
		if(op == 'c') {
			codifica(archivoEntrada, archivoSalida, desplazamiento);
		} else {
			decodifica(archivoEntrada, archivoSalida, desplazamiento);
		}

	}

	public static void codifica(String archivoEntrada, String archivoSalida, int desplazamiento) throws IOException {
		
		Path pathRelativoEntrada = Paths.get(archivoEntrada);
		
		String texto = "";
		
		try {
			for(String linea : Files.readAllLines(pathRelativoEntrada)) {
				texto = texto + linea;
			}
			texto = texto.toLowerCase();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		String abecedario = "abcdefghijklmnñopqrstuvwxyz";
		char stringCodificado[] = new char[texto.length()];
		char letra;
		int pos;
		char letraCod;
		int posCod;
		
		
		for(int i = 0 ; i < stringCodificado.length ; i++) {
			
			letra = texto.charAt(i);
			pos = abecedario.indexOf(letra);
			posCod = pos + desplazamiento;
			
			if(posCod >= 27) {
				posCod = posCod - 27;
			}
			
			letraCod = abecedario.charAt(posCod);
			
			stringCodificado[i] = letraCod;
		}
		
		StringBuffer cadena = new StringBuffer();
		for(int k = 0 ; k < stringCodificado.length ; k++) {
			cadena = cadena.append(stringCodificado[k]);
		}
		String mensaje = cadena.toString();
		
		Files.writeString(Paths.get(archivoSalida), mensaje);
		
		System.out.println("Archivo codificado correctamente.");
		
	}
	
	static void decodifica(String archivoEntrada, String archivoSalida, int desplazamiento) throws IOException {
		
		Path pathRelativoEntrada = Paths.get(archivoEntrada);
		
		String texto = "";
		
		try {
			for(String linea : Files.readAllLines(pathRelativoEntrada)) {
				texto = texto + linea;
			}
			texto = texto.toLowerCase();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		String abecedario = " abcdefghijklmnñopqrstuvwxyz";
		char stringDecodificado[] = new char[texto.length()];
		char letra;
		int pos;
		char letraDecod;
		int posDecod;
		
		
		for(int i = 0 ; i < stringDecodificado.length ; i++) {
			
			letra = texto.charAt(i);
			//System.out.println(letra);
			pos = abecedario.indexOf(letra);
			//System.out.println(pos);
			posDecod = pos - desplazamiento;
			//System.out.println(posDecod);
			
			if(posDecod < 0) {
				posDecod = posDecod + 27;
			}
			
			letraDecod = abecedario.charAt(posDecod);
			
			stringDecodificado[i] = letraDecod;
		}
		
		StringBuffer cadena = new StringBuffer();
		for(int k = 0 ; k < stringDecodificado.length ; k++) {
			cadena = cadena.append(stringDecodificado[k]);
		}
		String mensaje = cadena.toString();
		
		Files.writeString(Paths.get(archivoSalida), mensaje);
		
		System.out.println("Archivo decodificado correctamente.");
		
	}
	
}
