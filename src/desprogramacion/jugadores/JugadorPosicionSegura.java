package desprogramacion.jugadores;

import java.util.List;

import desprogramacion.sistema.Clave;
import desprogramacion.sistema.Jugador;
import desprogramacion.sistema.Movimiento;

public class JugadorPosicionSegura implements Jugador {
	private Integer clave;
	private Integer posicion;
	
	public JugadorPosicionSegura() {
		clave = -1;
		posicion = 0;
	}

	public Movimiento jugar() {
		if (clave == -1)
			return Movimiento.OBTENER_SEGURO;
		return Movimiento.PROBAR;
	}
	
	public void aceptarClave(Clave c) {
		clave = c.getValor();
	}

	public int brindarClave() {
		int ret = clave;
		clave = -1;
		return ret;
	}
	
	@Override
	public String getNombre() {
		return "JugadorPosicionSegura";
	}

	@Override
	public int brindarPosicion() {
		posicion++;
		return posicion;
	}

	@Override
	public void aceptarClaveFalsa(Clave clave) {}

	@Override
	public void aceptarHistorial(List<Integer> claves) {}
	
}