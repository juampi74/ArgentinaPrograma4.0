package practica.entCarrito2;

public class DescuentoPorcentaje extends Descuento {
	
	public DescuentoPorcentaje(double valor) {
		super.valor = valor;				
	}
	
	public double calcularDescuento(double precioTotal) {
		double desc = precioTotal * valor / 100;
		
		return desc;
	}
	
}
