package practica;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import practica.entCarrito3.Carrito;
import practica.entCarrito3.DescuentoFijo;
import practica.entCarrito3.DescuentoPorcentaje;
import practica.entCarrito3.ItemCarrito;
import practica.entCarrito3.MediosDePago;
import practica.entCarrito3.Producto;
import practica.exceptions.CarritoSinPrecioException;
import practica.exceptions.DescuentoNegativoException;

class EjemploCarrito3Test {

	@DisplayName("Validar el funcionamiento de CarritoSinPrecioException")
	@Test
	void test() throws CarritoSinPrecioException, DescuentoNegativoException {
		
		List<ItemCarrito> items = new ArrayList<ItemCarrito>();
		List<Producto> prod = new ArrayList<Producto>();
		
		prod.add(new Producto("Leche", 250.3));
		prod.add(new Producto("Chocolate", 299.9));
		prod.add(new Producto("Vino", 650.5));
		
		items.add(new ItemCarrito(prod.get(0), 0));
		items.add(new ItemCarrito(prod.get(1), 0));
		items.add(new ItemCarrito(prod.get(2), 0));
		
		Carrito carrito = new Carrito();
		
		for(int j = 0; j < 3; j++) {
			carrito.agregarItem(items.get(j));
		}
		
		MediosDePago medioDePago = new MediosDePago("Banco Municipal", "%", Integer.parseInt("25"));
		
		DescuentoPorcentaje dp = new DescuentoPorcentaje(medioDePago.getValor(), carrito.precioSinDescuento());
		
		carrito.setDescuento(dp);
		
		
		try {
			System.out.println("El precio del carrito es: " + Math.round(carrito.precio() * 100.0) / 100.0);
		}catch (CarritoSinPrecioException e) {
			System.out.println("Error! El carrito no tiene precio ($0)");
		}
	}
	
	@DisplayName("Validar el funcionamiento de DescuentoNegativoException")
	@Test
	void test2() throws CarritoSinPrecioException, DescuentoNegativoException {
		
		List<ItemCarrito> items = new ArrayList<ItemCarrito>();
		List<Producto> prod = new ArrayList<Producto>();
		
		prod.add(new Producto("Leche", 250.3));
		prod.add(new Producto("Chocolate", 299.9));
		prod.add(new Producto("Vino", 650.5));
		
		items.add(new ItemCarrito(prod.get(0), 1));
		items.add(new ItemCarrito(prod.get(1), 0));
		items.add(new ItemCarrito(prod.get(2), 0));
		
		Carrito carrito = new Carrito();
		
		for(int j = 0; j < 3; j++) {
			carrito.agregarItem(items.get(j));
		}
		
		MediosDePago medioDePago = new MediosDePago("Banco Macro", "F", Integer.parseInt("500"));
		
		DescuentoFijo df = new DescuentoFijo(medioDePago.getValor(), carrito.precioSinDescuento());
		
		carrito.setDescuento(df);
		
		
		try {
			System.out.println("El precio del carrito es: " + Math.round(carrito.precio() * 100.0) / 100.0);
		}catch (DescuentoNegativoException e) {
			System.out.println("Error! Al aplicar el descuento, el valor final es negativo");
		}
	}

}
