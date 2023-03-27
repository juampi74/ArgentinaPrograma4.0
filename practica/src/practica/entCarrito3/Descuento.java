package practica.entCarrito3;

import practica.exceptions.DescuentoNegativoException;

public class Descuento {

	protected double valor;
	protected double precioTotal;
	

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public double calcularDescuento(double precioTotal) throws DescuentoNegativoException {
		return precioTotal * valor / 100;
	}
	
}
