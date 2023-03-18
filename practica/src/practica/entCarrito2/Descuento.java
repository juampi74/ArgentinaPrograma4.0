package practica.entCarrito2;

public class Descuento {

	protected double valor;
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public double calcularDescuento(double precioTotal) {
		return precioTotal * valor / 100;
	}
	
}
