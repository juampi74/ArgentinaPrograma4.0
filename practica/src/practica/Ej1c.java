package practica;

public class Ej1c {

	public static void main(String[] args) {
		
		int numeroInicio = 5;
		int numeroFin = 14;
			
		int num = numeroInicio;
		String mostrar = "H"; 
			
		while(num <= numeroFin) {
			if (mostrar == "P") {
				if(num % 2 == 0) {
					System.out.println(num);
				}
			}else {
				if(num % 2 != 0) {
					System.out.println(num);
				}
			}
			num++;
		}	
	}
}
