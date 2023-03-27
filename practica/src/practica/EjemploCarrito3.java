package practica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import practica.entCarrito3.Producto;
import practica.exceptions.CarritoSinPrecioException;
import practica.exceptions.DescuentoNegativoException;
import practica.entCarrito3.ItemCarrito;
import practica.entCarrito3.MediosDePago;
import practica.entCarrito3.Carrito;
import practica.entCarrito3.Descuento;
import practica.entCarrito3.DescuentoFijo;
import practica.entCarrito3.DescuentoPorcentaje;
import practica.entCarrito3.DescuentoPorcentajeConTope;


public class EjemploCarrito3 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		
		String archivoProductos = "recursos/ArchivoProductos3.txt";
		Path pathRelativoProductos = Paths.get(archivoProductos);
		
		
		List<String> nomProd = new ArrayList<String>();
		List<Double> precioProd = new ArrayList<Double>();
		List<ItemCarrito> items = new ArrayList<ItemCarrito>();
		
	
		try {
			for(String linea : Files.readAllLines(pathRelativoProductos)) {
				
				String arrayProd[] = linea.split(",");
				nomProd.add(arrayProd[0]);
				precioProd.add(Double.parseDouble(arrayProd[1]));
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Producto prod[] = new Producto[nomProd.size()];
		
		for(int i = 0; i < prod.length; i++) {
			prod[i] = new Producto(nomProd.get(i), precioProd.get(i));
		}
		
		int cant[] = new int[prod.length];
		String cantP = "";
		
		for(int j = 0; j < cant.length; j++) {
			System.out.println("¿Cuántos items de " + nomProd.get(j) + " va a comprar?");
			cantP = scn.nextLine();
			cant[j] = Integer.parseInt(cantP);
		}
		
		ItemCarrito arrayItems[] = new ItemCarrito[prod.length];
		
		for(int k = 0; k < prod.length; k++) {
			arrayItems[k] = new ItemCarrito(prod[k], cant[k]);
			items.add(arrayItems[k]);
		}
		
		System.out.println("¿Cómo va a abonar?");
		System.out.println("MU (Banco Municipal) - MA (Banco Macro)- SF (Banco Santa Fe)");
		String formaPago = scn.nextLine().toLowerCase();
		
		while(formaPago.compareTo("mu") != 0 && formaPago.compareTo("ma") != 0 && formaPago.compareTo("sf") != 0) {
			System.out.println("Error! Ingrese MU - MA - SF:");
			formaPago = scn.nextLine().toLowerCase();
		}
		
		
		Carrito carrito = new Carrito();
		
		for(int l = 0; l < prod.length; l++) {
			carrito.agregarItem(items.get(l));
		}
		
		String[] datosMP = new String[3];
		
		if(formaPago.equals("mu")) {
			datosMP[0] = "Banco Municipal";
			datosMP[1] = "%";
			datosMP[2] = "25";
		} else if(formaPago.equals("ma")) {
			datosMP[0] = "Banco Macro";
			datosMP[1] = "F";
			datosMP[2] = "500";
		} else if(formaPago.equals("sf")) {
			datosMP[0] = "Banco Santa Fe";
			datosMP[1] = "%TF";
			datosMP[2] = "20";
		}

		MediosDePago medioDePago = new MediosDePago(datosMP[0], datosMP[1], Integer.parseInt(datosMP[2]));
		
		//System.out.println(medioDePago.getTipoDescuento());
		
		try {
			if(medioDePago.getTipoDescuento().equals("%")) {
			
				DescuentoPorcentaje dp = new DescuentoPorcentaje(medioDePago.getValor(), carrito.precioSinDescuento());
				carrito.setDescuento(dp);
				
				System.out.println("El precio total del Carrito es: " + Math.round(carrito.precio() * 100.0) / 100.0);
	
			} else if(medioDePago.getTipoDescuento().equals("F")) {
				
				DescuentoFijo df = new DescuentoFijo(medioDePago.getValor(), carrito.precioSinDescuento());
				carrito.setDescuento(df);
				
				System.out.println("El precio total del Carrito es: " + Math.round(carrito.precio() * 100.0) / 100.0);
				
			} else if(medioDePago.getTipoDescuento().equals("%TF")) {
			
				DescuentoPorcentajeConTope dpct = new DescuentoPorcentajeConTope(medioDePago.getValor(), carrito.precioSinDescuento());
				carrito.setDescuento(dpct);
				
				System.out.println("El precio total del Carrito es: " + Math.round(carrito.precio() * 100.0) / 100.0);
				
			}
		}catch (CarritoSinPrecioException e) {
			System.out.println("Error! El carrito no tiene precio ($0)");
		}catch (DescuentoNegativoException e) {
			System.out.println("Error! Al aplicar el descuento, el valor final es negativo");
		}
	}

}