package practica.entCarrito3;

import practica.exceptions.DescuentoNegativoException;

public class DescuentoFijo extends Descuento {

	public DescuentoFijo(double valor, double precioTotal) {
		super.valor = valor;
		super.precioTotal = precioTotal;
	}
	
	public double calcularDescuento(double precioTotal) throws DescuentoNegativoException {
		double desc = valor;
		
		if((precioTotal - desc) < 0) {
			throw new DescuentoNegativoException();
		}
		
		return desc;
	}
	
}
