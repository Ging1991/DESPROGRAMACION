package desprogramacion.sistema;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sistema {
	
	private int claveSecreta;
	private boolean terminado; 
	private List<Integer> claves;
	private List<Integer> historialClaves;
	private List<Jugador> jugadores;
	
	public Sistema() {
		terminado = false;
		claveSecreta = azar();
		System.out.println("Sistema iniciado, la clave secreta es " + claveSecreta);
		claves = new ArrayList<Integer>();
		historialClaves = new ArrayList<Integer>();
		jugadores = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			claves.add(azar());
		claves.set(azar()-1, claveSecreta);
	}
	
	public void agregarJugador(Jugador jugador) {
		jugadores.add(jugador);
	}

	public void comenzar() {
		for (int i = 1; i < 201; i++) {
			System.out.println("Turno " + i);
			for (Jugador jugador : jugadores) {
				jugar(jugador);
				if (terminado)
					break;
			}
			if (terminado)
				break;
		}
		if (!terminado)
			System.out.println("El ha terminado sin ganadores");
	}
	
	public void jugar(Jugador jugador) {
		Movimiento movimiento = jugador.jugar();
		System.out.println("-> " +jugador.getNombre());
		System.out.println("	- Movimiento elegido " + movimiento);
		
		// Prerrequisito: Brindar clave devuelve la clave que va a probar
		if (movimiento == Movimiento.PROBAR) {
			Integer clave = jugador.brindarClave();
			System.out.println("	- Prueba con el codigo " + clave);
			if (probarCodigo(clave)) {
				System.out.println("El codigo es correcto, " +jugador.getNombre() + " ha ganado.");
				terminado = true;
			}
		}
		
		// Prerrequisitos:
		// - Brindar posicion devuelve la posicion en lalista 1-100 de la clave que le esta pidiendo
		// - Aceptar clave: recibe la clave que contenida en la posicion brindada por el metodo anterior
		
		if (movimiento == Movimiento.OBTENER_SEGURO) {
			Integer posicion = jugador.brindarPosicion();
			System.out.println("	- Clave segura obtenida " + getValor(posicion));
			jugador.aceptarClave(new Clave(posicion, getValor(posicion)));
		}
		
		// Prerrequisitos: aceptar clave falsa recibe una clave de la lista que no es la clave correcta
		if (movimiento == Movimiento.OBTENER_FALSO) {
			Clave clave = getClaveFalsa();
			jugador.aceptarClaveFalsa(clave);
			if (clave != null)
				System.out.println("	- Clave falsa obtenida " + clave.getValor());
		}
		
		// Prerrequisitos: aceptar historial recibe una lista de claves que se han intentado anteriormente
		if (movimiento == Movimiento.OBTENER_HISTORIAL) {
			jugador.aceptarHistorial(historialClaves);
		}
	}
	
	private boolean probarCodigo(Integer codigo) {
		historialClaves.add(codigo);
		return codigo == claveSecreta;
	}
	
	public Integer getValor(int posicion) {
		return claves.get(posicion);
	}
	
	public Clave getClaveFalsa() {
		int azar = azar();
		Clave clave = null;
		for (int i = azar; i < claves.size(); i++) {
			if (!probarCodigo(claves.get(i))) {
				clave = new Clave(i, claves.get(i));
				break;
			}
		}
		return clave;
	}
	
	// Devuelve valores entre 1 y 100 incluidos
	public static int azar() {
		Random random = new Random();
		return random.nextInt(100)+1;
	}

}