package desprogramacion.sistema;

public class Clave {

	private int posicion, valor;

	public Clave(int posicion, int valor) {
		this.posicion = posicion;
		this.valor = valor;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
}