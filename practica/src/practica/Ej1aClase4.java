package practica;

import java.util.Arrays;
import java.util.Collections;

public class Ej1aClase4 {

	public static void main(String[] args) {
		int num1 = 3;
		int num2 = 6;
		int num3 = 4;
		char orden = 'D';
			
		ordena(num1, num2, num3, orden);
	}

	public static void ordena(int num1, int num2, int num3, char orden) {
		Integer numeros[] = {num1, num2, num3};
		
		if(orden == 'A') {
			System.out.println("Números ordenados de manera Ascendente:");
			Arrays.sort(numeros);		
		} else if(orden == 'D') {
			System.out.println("Números ordenados de manera Descendente:");
			Arrays.sort(numeros, Collections.reverseOrder());
		}
			
		for(int num : numeros) {
			System.out.println(num);
		}
	}
		
}


