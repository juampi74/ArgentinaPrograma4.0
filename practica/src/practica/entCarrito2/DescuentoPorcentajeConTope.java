package practica.entCarrito2;

public class DescuentoPorcentajeConTope extends Descuento {
	
	private static final double tope = 600.0;
	
	public DescuentoPorcentajeConTope(double valor) {
		super.valor = valor;				
	}
		
	public double calcularDescuento(double precioTotal) {
		double desc =  precioTotal * valor / 100;
		
		if(desc > tope) {
			desc = tope;
		}
		
		return desc;
	}
		
}