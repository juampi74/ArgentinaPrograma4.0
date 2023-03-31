package modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mensaje {

	private String usuario;
	private String mensaje;
	
	public Mensaje(String usuario, String mensaje) {
		this.setUsuario(usuario);
		this.setMensaje(mensaje);
	}
	
}
