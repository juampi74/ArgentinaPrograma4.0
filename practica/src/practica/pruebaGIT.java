package practica;

import java.util.Scanner;

public class pruebaGIT {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		float precio; 
		
		char ivaSiONo;
		boolean aplicarIva = false;
		boolean correcta = false;
		
		int iva = 21;

		System.out.println("Precio?");
		precio = scanner.nextFloat();
		
		System.out.println("Agregar IVA? <S-N>");
		
		while (!correcta) {
			ivaSiONo = scanner.next().charAt(0);
			if(ivaSiONo == 'S' || ivaSiONo == 's') {
				aplicarIva = true;
				correcta = true;
			} else if(ivaSiONo == 'N' || ivaSiONo == 'n') {
				aplicarIva = false;
				correcta = true;
			} else {
				System.out.println("Opción incorrecta. Ingrese S-N:");		
			}
		}	
		if(aplicarIva) {
			precio = precio + precio * iva / 100;
		}
		
		System.out.println("El precio final es: " + precio);
		
		
		
		

	}

}
