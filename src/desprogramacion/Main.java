package desprogramacion;

import desprogramacion.jugadores.JugadorAleatorio;
import desprogramacion.jugadores.JugadorHistorial;
import desprogramacion.jugadores.JugadorInseguro;
import desprogramacion.jugadores.JugadorLineal;
import desprogramacion.jugadores.JugadorPosicionSegura;
import desprogramacion.sistema.Sistema;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Inicio del juego");
		Sistema sistema = new Sistema();
		sistema.agregarJugador(new JugadorPosicionSegura());
		sistema.agregarJugador(new JugadorInseguro());
		sistema.agregarJugador(new JugadorLineal());
		sistema.agregarJugador(new JugadorAleatorio());
		sistema.agregarJugador(new JugadorHistorial());
		sistema.comenzar();
		System.out.println("Fin del juego");
	}

}