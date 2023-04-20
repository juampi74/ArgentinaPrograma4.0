package modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Descuento {

	private String tipo;
	private float cantidad; 
	private int tope;
	
	public Descuento(String tipo, float cantidad, int tope) {
		
		this.setTipo(tipo);
		this.setCantidad(cantidad);
		this.setTope(tope);
		
	}
	
}
