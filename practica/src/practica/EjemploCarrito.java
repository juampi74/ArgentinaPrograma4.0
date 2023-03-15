package practica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import practica.Entidades.Producto;
import practica.Entidades.ItemCarrito;
import practica.Entidades.Carrito;
import practica.Entidades.Descuento;
import practica.Entidades.BancoMacro;
import practica.Entidades.BancoMunicipal;


public class EjemploCarrito {

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
		System.out.println("MU (Banco Municipal) - MA (Banco Macro)");
		String formaPago = scn.nextLine();
		
		while(formaPago.compareTo("mu") != 0 && formaPago.compareTo("ma") != 0) {
			System.out.println("Error! Ingrese MU - MA:");
			formaPago = scn.nextLine().toLowerCase();
		}
		
		Carrito carrito = new Carrito(item1, item2, item3);
		
		if(formaPago.equals("mu")) {
			BancoMunicipal bmu  = new BancoMunicipal(25.0);
			carrito.setDescuento(bmu);
			System.out.println("El precio total del Carrito es: " + Math.round(carrito.precio() * 100.0) / 100.0);
		} else if(formaPago.equals("ma")) {
			BancoMacro bma = new BancoMacro(20.0);
			carrito.setDescuento(bma);
			System.out.println("El precio total del Carrito es: " + Math.round((carrito.precio() * 6) * 100.0) / 100.0);
			System.out.println("Cada una de las 6 cuotas tiene un precio de: " + Math.round(carrito.precio() * 100.0) / 100.0);
		}
	
	}

}
