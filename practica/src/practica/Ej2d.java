package practica;

public class Ej2d {

	public static void main(String[] args) {

		String nombre = "Juan Perez";
		float ingresos = 485000;
		int vehiculos_nuevos = 2;
		int inmuebles = 2;
		boolean lujo = false;
		
		if((ingresos >= 489083)||(vehiculos_nuevos >= 3)||(inmuebles >= 3)||(lujo)) {
			System.out.println(nombre + " PERTENECE al segmento de ingresos altos.");
		} else {
			System.out.println(nombre + " NO PERTENECE al segmento de ingresos altos.");
		}
	}
}