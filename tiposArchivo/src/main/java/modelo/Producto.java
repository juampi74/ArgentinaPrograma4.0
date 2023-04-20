package modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producto {

	private String nombre;
	private float peso;
	private float precio;
	
	public Producto(String nombre, float peso, float precio) {
		
		this.setNombre(nombre);
		this.setPeso(peso);
		this.setPrecio(precio);
		
	}
	
}
