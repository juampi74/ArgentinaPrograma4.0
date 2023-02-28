package practica;

public class Ej1b {

	public static void main(String[] args) {
		
		int numeroInicio = 5;
		int numeroFin = 14;
			
		int num = numeroInicio;
			
		while(num <= numeroFin) {
			if(num % 2 == 0) {
				System.out.println(num);
			}
			num++;
		}
	}
}
