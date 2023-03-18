package practica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import practica.entCarrito2.Carrito;
import practica.entCarrito2.DescuentoFijo;
import practica.entCarrito2.DescuentoPorcentaje;
import practica.entCarrito2.DescuentoPorcentajeConTope;
import practica.entCarrito2.ItemCarrito;
import practica.entCarrito2.MediosDePago;
import practica.entCarrito2.Producto;

class EjemploCarrito2Test {

	@DisplayName("Validar el funcionamiento del Método Precio de la clase Carrito y DescuentoPorcentaje")
	@Test
	void test() {
		
		Producto prod1 = new Producto("Leche", 250.3);
		Producto prod2 = new Producto("Chocolate", 299.9);
		Producto prod3 = new Producto("Vino", 650.5);
		
		ItemCarrito item1 = new ItemCarrito(prod1, 1);
		ItemCarrito item2 = new ItemCarrito(prod2, 2);
		ItemCarrito item3 = new ItemCarrito(prod3, 3);
		
		Carrito carrito = new Carrito(item1, item2, item3);
		
		MediosDePago medioDePago = new MediosDePago("Banco Municipal", "%", Integer.parseInt("25"));
		
		DescuentoPorcentaje dp = new DescuentoPorcentaje(medioDePago.getValor());
		
		carrito.setDescuento(dp);
		
		Assertions.assertEquals(Math.round(carrito.precio() * 100.0) / 100.0, 2101.2);	
	
	}
	
	@DisplayName("Validar el funcionamiento del Método Precio de la clase Carrito y DescuentoFijo")
	@Test
	void test2() {
		
		Producto prod1 = new Producto("Leche", 250.3);
		Producto prod2 = new Producto("Chocolate", 299.9);
		Producto prod3 = new Producto("Vino", 650.5);
		
		ItemCarrito item1 = new ItemCarrito(prod1, 1);
		ItemCarrito item2 = new ItemCarrito(prod2, 2);
		ItemCarrito item3 = new ItemCarrito(prod3, 3);
		
		Carrito carrito = new Carrito(item1, item2, item3);
		
		MediosDePago medioDePago = new MediosDePago("Banco Macro", "F", Integer.parseInt("500"));
		
		DescuentoFijo df = new DescuentoFijo(medioDePago.getValor());
		
		carrito.setDescuento(df);
		
		Assertions.assertEquals(Math.round(carrito.precio() * 100.0) / 100.0, 2301.6);
		
	}

	@DisplayName("Validar el funcionamiento del Método Precio de la clase Carrito y DescuentoPorcentajeConTope")
	@Test
	void test3() {
		
		Producto prod1 = new Producto("Leche", 250.3);
		Producto prod2 = new Producto("Chocolate", 299.9);
		Producto prod3 = new Producto("Vino", 650.5);
		
		ItemCarrito item1 = new ItemCarrito(prod1, 1);
		ItemCarrito item2 = new ItemCarrito(prod2, 2);
		ItemCarrito item3 = new ItemCarrito(prod3, 3);
		
		Carrito carrito = new Carrito(item1, item2, item3);
		
		MediosDePago medioDePago = new MediosDePago("Banco Santa Fe", "%TF", Integer.parseInt("20"));
		
		DescuentoPorcentajeConTope dpct = new DescuentoPorcentajeConTope(medioDePago.getValor());
		
		carrito.setDescuento(dpct);
		
		Assertions.assertEquals(Math.round(carrito.precio() * 100.0) / 100.0, 2241.28);
		
	}
	
}
