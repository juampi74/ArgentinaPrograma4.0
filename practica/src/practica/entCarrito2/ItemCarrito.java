package practica.entCarrito2;

public class ItemCarrito {

	private Producto producto;
	private int cantidad;
	
	public ItemCarrito(Producto producto, int cantidad) {
		this.setProducto(producto);
		this.setCantidad(cantidad);
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public Producto getProducto() {
		return this.producto;
	}

	public void setCantidad(int cantidad2) {
		this.cantidad = cantidad2;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
}
