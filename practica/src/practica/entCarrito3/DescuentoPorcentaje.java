package practica.entCarrito3;

import practica.exceptions.DescuentoNegativoException;

public class DescuentoPorcentaje extends Descuento {
	
	public DescuentoPorcentaje(double valor, double precioTotal) {
		super.valor = valor;
		super.precioTotal = precioTotal;
	}
	
	public double calcularDescuento(double precioTotal) throws DescuentoNegativoException {
		double desc = precioTotal * valor / 100;
		
		if((precioTotal - desc) < 0) {
			throw new DescuentoNegativoException();
		}
		
		return desc;
	}
	
}
