package practica.entCarrito3;

public class Producto {

	private String nombre;
	private Double precio;
	
	public Producto(String nombre, Double precio) {
		this.setNombre(nombre);
		this.setPrecio(precio);
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public Double getPrecio() {
		return precio;
	}
}