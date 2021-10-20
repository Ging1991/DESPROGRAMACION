package desprogramacion.jugadores;
import java.util.ArrayList;
import java.util.List;

import desprogramacion.sistema.Clave;
import desprogramacion.sistema.Jugador;
import desprogramacion.sistema.Movimiento;

public class JugadorInseguro implements Jugador{
	private List<Clave> clavesProbadas;
	private Integer proximaClave;
	private Integer posicion;
		
	public JugadorInseguro() {
		clavesProbadas = new ArrayList<>();
		proximaClave = -1;
		posicion = 1;
	}
	
	public Movimiento jugar() {
		if (clavesProbadas.size() < 20)
			return Movimiento.OBTENER_FALSO;
		if (proximaClave == -1)
			return Movimiento.OBTENER_SEGURO;
		return Movimiento.PROBAR;
	}
	
	public void aceptarClave(Clave clave) {
		proximaClave = clave.getValor();
		clavesProbadas.add(clave);
	}

	public void aceptarClaveFalsa(Clave clave) {
		if (clave == null)
			System.out.println("He recibido un null");
		else
			clavesProbadas.add(clave);
	}

	public int brindarClave() {
		int ret = proximaClave;
		proximaClave = -1;
		return ret;
	}
	
	@Override
	public String getNombre() {
		return "Jugador Inseguro";
	}

	@Override
	public int brindarPosicion() {
		List<Integer> posiciones = new ArrayList<>();
		for (Clave clave: clavesProbadas)
			posiciones.add(clave.getPosicion());
		for (int i = 1; i < 101; i++) {
			if (!posiciones.contains(i)) {
				posicion = i;
				break;
			}
		}
		return posicion;
	}

	@Override
	public void aceptarHistorial(List<Integer> claves) {}

}