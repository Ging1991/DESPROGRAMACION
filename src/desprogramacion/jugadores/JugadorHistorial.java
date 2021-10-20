package desprogramacion.jugadores;

import java.util.ArrayList;
import java.util.List;

import desprogramacion.sistema.Clave;
import desprogramacion.sistema.Jugador;
import desprogramacion.sistema.Movimiento;

public class JugadorHistorial implements Jugador {
	private List<Integer> historialUnico;
	
	public JugadorHistorial() {
		historialUnico = new ArrayList<>();
	}

	@Override
	public String getNombre() {
		return "Jugador Historial";
	}

	@Override
	public Movimiento jugar() {
		if (historialUnico.size() < 50)
			return Movimiento.OBTENER_HISTORIAL;
		return Movimiento.PROBAR;
	}

	@Override
	public void aceptarClave(Clave clave) {}

	@Override
	public void aceptarClaveFalsa(Clave clave) {}

	@Override
	public void aceptarHistorial(List<Integer> claves) {
		for (Integer clave : claves)
			if (!historialUnico.contains(clave))
				historialUnico.add(clave);
	}

	@Override
	public int brindarClave() {
		Integer clave = 1;
		for (int i = 1; i < 101; i++) {
			if (!historialUnico.contains(i))
				clave = i;
		}
		return clave;
	}

	@Override
	public int brindarPosicion() {
		return 0;
	}

}