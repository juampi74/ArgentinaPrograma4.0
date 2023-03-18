package practica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import practica.entCarrito2.Producto;
import practica.entCarrito2.ItemCarrito;
import practica.entCarrito2.MediosDePago;
import practica.entCarrito2.Carrito;
import practica.entCarrito2.Descuento;
import practica.entCarrito2.DescuentoFijo;
import practica.entCarrito2.DescuentoPorcentaje;
import practica.entCarrito2.DescuentoPorcentajeConTope;


public class EjemploCarrito2 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		
		String archivoProductos = "recursos/ArchivoProductos.txt";
		Path pathRelativoProductos = Paths.get(archivoProductos);
		String prod[] = new String[3];
		int i = 0;
		
		try {
			for(String linea : Files.readAllLines(pathRelativoProductos)) {
				 prod[i] = linea;
				 i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Producto prod1 = new Producto(prod[0], 250.3);
		Producto prod2 = new Producto(prod[1], 299.9);
		Producto prod3 = new Producto(prod[2], 650.5);
		
		int cant[] = new int[3];
		String cantP = "";
		
		for(int j = 0; j < cant.length; j++) {
			System.out.println("¿Cuántos items de " + prod[j] + " va a comprar?");
			cantP = scn.nextLine();
			cant[j] = Integer.parseInt(cantP);
		}
		
		ItemCarrito item1 = new ItemCarrito(prod1, cant[0]);
		ItemCarrito item2 = new ItemCarrito(prod2, cant[1]);
		ItemCarrito item3 = new ItemCarrito(prod3, cant[2]);
		
		System.out.println("¿Cómo va a abonar?");
		System.out.println("MU (Banco Municipal) - MA (Banco Macro)- SF (Banco Santa Fe)");
		String formaPago = scn.nextLine().toLowerCase();
		
		while(formaPago.compareTo("mu") != 0 && formaPago.compareTo("ma") != 0 && formaPago.compareTo("sf") != 0) {
			System.out.println("Error! Ingrese MU - MA - SF:");
			formaPago = scn.nextLine().toLowerCase();
		}
		
		Carrito carrito = new Carrito(item1, item2, item3);
		
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
		
		if(medioDePago.getTipoDescuento().equals("%")) {
		
			DescuentoPorcentaje dp = new DescuentoPorcentaje(medioDePago.getValor());
			carrito.setDescuento(dp);
			
			System.out.println("El precio total del Carrito es: " + Math.round(carrito.precio() * 100.0) / 100.0);
			
		} else if(medioDePago.getTipoDescuento().equals("F")) {
			
			DescuentoFijo df = new DescuentoFijo(medioDePago.getValor());
			carrito.setDescuento(df);
			
			System.out.println("El precio total del Carrito es: " + Math.round(carrito.precio() * 100.0) / 100.0);
			
		} else if(medioDePago.getTipoDescuento().equals("%TF")) {
		
			DescuentoPorcentajeConTope dpct = new DescuentoPorcentajeConTope(medioDePago.getValor());
			carrito.setDescuento(dpct);
			
			System.out.println("El precio total del Carrito es: " + Math.round(carrito.precio() * 100.0) / 100.0);
			
		}
		
		
	}

}