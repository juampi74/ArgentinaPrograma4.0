package practica;

public class Ej1b {

	public static void main(String[] args) {
		
		int numeroInicio = 9;
		int numeroFin = 11;

			
		int num = numeroInicio;
			
		while(num <= numeroFin) {
			if(num % 2 == 0) {
				System.out.println(num);
			}
			num++;
		}
	}
}
