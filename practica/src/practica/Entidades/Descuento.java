package practica.Entidades;

public class Descuento {

	protected double porcentaje;
	
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	public double getPorcentaje() {
		return this.porcentaje;
	}
	
	public double calcularDescuento(double precioTotal) {
		return precioTotal * porcentaje / 100;
	}
	
}
