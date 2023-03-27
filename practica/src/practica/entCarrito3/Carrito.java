package practica.entCarrito3;

import java.util.ArrayList;
import java.util.List;

import practica.exceptions.CarritoSinPrecioException;
import practica.exceptions.DescuentoNegativoException;

public class Carrito {

	private List<ItemCarrito> items;
	private Descuento descuento;
	
	public Carrito() {
		this.items = new ArrayList<ItemCarrito>();
	}
	
	public double precio() throws CarritoSinPrecioException, DescuentoNegativoException{
		
		double precioTotal = 0.0;
		
		for(ItemCarrito item : this.getItems()) {
			precioTotal = precioTotal + item.getProducto().getPrecio() * item.getCantidad();
		}
		
		if(precioTotal == 0.0) {
			throw new CarritoSinPrecioException();
		}
		
		double precioDesc = descuento.calcularDescuento(precioTotal);
		
		return precioTotal - precioDesc;
		
	}
	
	public double precioSinDescuento() {
		
		double precioTotal = 0.0;
		
		for(ItemCarrito item : this.getItems()) {
			precioTotal = precioTotal + item.getProducto().getPrecio() * item.getCantidad();
		}
		
		return precioTotal;
	}
	
	public void agregarItem(ItemCarrito ic) {
		this.items.add(ic);
	}
	
	public void quitarItem(ItemCarrito ic) {
		this.items.remove(ic);
	}
	
	public List<ItemCarrito> getItems() {
		return this.items;
	}
	
	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}

	public Descuento getDescuento() {
		return this.descuento;
	}
}
