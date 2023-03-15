package practica.Entidades;

public class BancoMacro extends Descuento {

	private static final int cuotas = 6;
	
	public BancoMacro(double porcentaje) {
		super.porcentaje = porcentaje;				
	}

	public double calcularDescuento(double precioTotal) {
		
		return (precioTotal - precioTotal * porcentaje / 100) / cuotas;
		
	}
	
}
