package modelo;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@XmlRootElement
public class Oferta {

	private Producto producto;
	private Descuento descuento;
	private String fechaDesde;
	private String fechaHasta;
	
	public Oferta() {
		
	}
	
	public Oferta(Producto producto, Descuento descuento, String fechaDesde, String fechaHasta) {
		
		this.setProducto(producto);
		this.setDescuento(descuento);
		this.setFechaDesde(fechaDesde);
		this.setFechaHasta(fechaHasta);
		
	}
	
}
