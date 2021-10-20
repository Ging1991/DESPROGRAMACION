package desprogramacion.jugadores;

import java.util.List;

import desprogramacion.sistema.Clave;
import desprogramacion.sistema.Jugador;
import desprogramacion.sistema.Movimiento;

public class JugadorLineal implements Jugador {
	private int posicion;
	
	public JugadorLineal() {
		posicion = 0;
	}

	@Override
	public String getNombre() {
		return "Jugador Lineal";
	}

	@Override
	public Movimiento jugar() {
		return Movimiento.PROBAR;
	}

	@Override
	public void aceptarClave(Clave clave) {}

	@Override
	public void aceptarClaveFalsa(Clave clave) {}

	@Override
	public int brindarClave() {
		posicion++;
		return posicion;
	}

	@Override
	public int brindarPosicion() {
		return 0;
	}

	@Override
	public void aceptarHistorial(List<Integer> claves) {}

}