package practica;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ej1bClase4 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		int numeros[] = new int[3];
		
		for(int i = 0; i < 3; i++) {
			System.out.println("Ingrese el " + (i + 1) + "° número:");
			String num = scn.nextLine();
			int numero = Integer.parseInt(num);
			numeros[i] = numero;
		}
		
		System.out.println("Ingrese el orden <Ascendente(A) - Descendente(D)>:");
		String ord = scn.nextLine();
		while(ord.toLowerCase().compareTo("a") != 0 && ord.toLowerCase().compareTo("d") != 0) {
			System.out.println("Error! Ingrese A o D:");
			ord = scn.nextLine();
		}
		
		char orden = ord.charAt(0);
		
		ordena(numeros[0], numeros[1], numeros[2], orden);
	}

	public static void ordena(int num1, int num2, int num3, char orden) {
		Integer numeros[] = {num1, num2, num3};
		
		if(orden == 'A' || orden == 'a') {
			System.out.println("\nNúmeros ordenados de manera Ascendente:");
			Arrays.sort(numeros);		
		} else if(orden == 'D' || orden == 'd') {
			System.out.println("\nNúmeros ordenados de manera Descendente:");
			Arrays.sort(numeros, Collections.reverseOrder());
		}
		
		for(int num : numeros) {
			System.out.println(num);
		}
	}
		
}
