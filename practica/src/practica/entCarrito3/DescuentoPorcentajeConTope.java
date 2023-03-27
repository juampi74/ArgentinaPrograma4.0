package practica.entCarrito3;

import practica.exceptions.DescuentoNegativoException;

public class DescuentoPorcentajeConTope extends Descuento {
	
	private static final double tope = 600.0;
	
	public DescuentoPorcentajeConTope(double valor, double precioTotal) {
		super.valor = valor;
		super.precioTotal = precioTotal;
	}
		
	public double calcularDescuento(double precioTotal) throws DescuentoNegativoException {
		double desc =  precioTotal * valor / 100;
		
		if(desc > tope) {
			desc = tope;
		}
		
		if((precioTotal - desc) < 0) {
			throw new DescuentoNegativoException();
		}
		
		return desc;
	}
		
}