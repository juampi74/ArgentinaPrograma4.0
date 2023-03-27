package practica.entCarrito3;

public class MediosDePago {
	
	private String nombreBanco;
	private String tipoDescuento;
	private int valor;
	
	public MediosDePago(String nombreBanco, String tipoDescuento, int valor) {
		this.setNombreBanco(nombreBanco);
		this.setTipoDescuento(tipoDescuento);
		this.setValor(valor);
	}
	
	public String getNombreBanco() {
		return nombreBanco;
	}
	
	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}
	
	public String getTipoDescuento() {
		return tipoDescuento;
	}
	
	public void setTipoDescuento(String tipoDescuento) {
		this.tipoDescuento = tipoDescuento;
	}
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
