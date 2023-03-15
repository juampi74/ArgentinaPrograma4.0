package practica.Entidades;

public class BancoMunicipal extends Descuento {
	
	private static final double tope = 500.0;
	
	public BancoMunicipal(double porcentaje) {
		super.porcentaje = porcentaje;				
	}

	public double calcularDescuento(double precioTotal) {
		double desc =  precioTotal * porcentaje / 100;
		
		if(desc > tope) {
			desc = tope;
		}
		
		return precioTotal - desc;
	}
	
}
