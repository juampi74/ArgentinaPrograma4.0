package org.argentinaprograma.tiposArchivo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import modelo.Descuento;
import modelo.Oferta;
import modelo.Producto;

public class Main {
	
    public static void main(String[] args) throws CsvValidationException, IOException {
    	
    	if(args.length != 1){
            System.out.println("ERROR: No ingresaste los archivos correspondientes!");
            System.exit(88);
        }
    	
    	ArrayList<String[]> of = new ArrayList<String[]>();
    	
    	CSVReader lector = new CSVReader(new FileReader(args[0]));			
		String[] ofertasCSV;
		String[] ofertas;
		int i = 0;
		
		while((ofertasCSV = lector.readNext()) != null) {
			ofertas = ofertasCSV[0].split(";");
			
			if(i > 0) {
				
				String nroOferta = ofertas[0];
				
				String[] producto = ofertas[1].split(": ");
				String nombreProducto = producto[0];
				String pesoProducto = producto[1];
				String precioProducto = producto[2];
				
				String[] descuento = ofertas[2].split(": ");
				String tipoDescuento = descuento[0];
				String cantidadDescuento = descuento[1];
				String topeDescuento = descuento[2];
				
				String fechaDesde = ofertas[3];
				
				String fechaHasta = ofertas[4];
				
				String[] o = {nroOferta, nombreProducto, pesoProducto, precioProducto, tipoDescuento, cantidadDescuento, topeDescuento, fechaDesde, fechaHasta};
				
				of.add(o);
				
			}
		
			i++;
			
		}
		
		ArrayList<Oferta> ofert = new ArrayList<Oferta>();
		ArrayList<Producto> productos = new ArrayList<Producto>();
		ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
		
		int j = 0;
		
		for(String[] oferta : of) {
			
			productos.add(new Producto(oferta[1], Float.parseFloat(oferta[2]), Float.parseFloat(oferta[3])));
			descuentos.add(new Descuento(oferta[4], Float.parseFloat(oferta[5]), Integer.parseInt(oferta[2])));
			ofert.add(new Oferta(productos.get(j), descuentos.get(j), oferta[7], oferta[8]));
			
			j++;
			
		}
		
		System.out.println("\n-----------------------------");
		System.out.println("       FORMATO JSON");
		System.out.println("-----------------------------\n");
			
		ObjectMapper objectMapper = new ObjectMapper();
			
		for(Oferta oferta : ofert) {
			
			String jsonText = objectMapper.writeValueAsString(oferta);
			System.out.println("\n" + jsonText + "\n");
					
		}
			
	}

}