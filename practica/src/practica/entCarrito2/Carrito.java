package practica.entCarrito2;

public class Carrito {

	private ItemCarrito item1;
	private ItemCarrito item2;
	private ItemCarrito item3;
	private Descuento descuento;
	
	public Carrito(ItemCarrito item1, ItemCarrito item2, ItemCarrito item3) {
		this.setItem1(item1);
		this.setItem2(item2);
		this.setItem3(item3);
	}
	
	public double precio() {
		double precioTotal = this.getItem1().getProducto().getPrecio() * this.getItem1().getCantidad() + this.getItem2().getProducto().getPrecio() * this.getItem2().getCantidad() + this.getItem3().getProducto().getPrecio() * this.getItem3().getCantidad();
		
		double precioDesc = descuento.calcularDescuento(precioTotal);
		
		return precioTotal - precioDesc;
		
	}
	
	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}

	public Descuento getDescuento() {
		return this.descuento;
	}
	
	public void setItem1(ItemCarrito item1) {
		this.item1 = item1;
	}
	
	public ItemCarrito getItem1() {
		return this.item1;
	}

	public void setItem2(ItemCarrito item2) {
		this.item2 = item2;
	}
	
	public ItemCarrito getItem2() {
		return this.item2;
	}
	
	public void setItem3(ItemCarrito item3) {
		this.item3 = item3;
	}
	
	public ItemCarrito getItem3() {
		return this.item3;
	}
}
