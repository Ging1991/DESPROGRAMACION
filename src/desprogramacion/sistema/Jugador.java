package desprogramacion.sistema;

import java.util.List;

public interface Jugador {
	
	public String getNombre();
	
	public Movimiento jugar();

	public void aceptarClave(Clave clave);

	public void aceptarClaveFalsa(Clave clave);
	
	public void aceptarHistorial(List<Integer> claves);
	
	public int brindarClave();
	
	public int brindarPosicion();
		
}