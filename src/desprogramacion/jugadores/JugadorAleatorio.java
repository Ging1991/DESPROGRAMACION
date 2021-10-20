package desprogramacion.jugadores;

import java.util.List;

import desprogramacion.sistema.Clave;
import desprogramacion.sistema.Jugador;
import desprogramacion.sistema.Movimiento;
import desprogramacion.sistema.Sistema;

public class JugadorAleatorio implements Jugador {

	@Override
	public String getNombre() {
		return "Jugador Aleatorio";
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
		return Sistema.azar();
	}

	@Override
	public int brindarPosicion() {
		return 0;
	}

	@Override
	public void aceptarHistorial(List<Integer> claves) {}

}