package practica.entCarrito2;

public class DescuentoFijo extends Descuento {

	public DescuentoFijo(double valor) {
		super.valor = valor;				
	}
	
	public double calcularDescuento(double precioTotal) {
		double desc = valor;
		
		return desc;
	}
	
}
