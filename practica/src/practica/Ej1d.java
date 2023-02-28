package practica;

public class Ej1d {

	public static void main(String[] args) {

		int numeroInicio = 5;
		int numeroFin = 14;
				
		for(int num = numeroFin; num >= numeroInicio; num--) {
			if(num % 2 == 0) {
				System.out.println(num);
			}
		}
	}
}
