package Entidades;

/**
 * Modela el comportamiento de los Caramelos.
 * @author FJoaquin (federico.joaquin@cs.uns.edu.ar)
 *
 */
public class Caramelo extends Entidad {
	
	public Caramelo(int f, int c, int col) {
		super(f, c, col, "/imagenes/caramelos/");
	}
	
	public boolean es_posible_intercambiar(Entidad e) {
		return e.puede_recibir(this);
	}
	
	public boolean puede_recibir(Caramelo c) {
		// To Do: programar la lógica para chequear match 3
		return true;
	}
	
	public boolean puede_recibir(Glaseado g) {
		return false;
	}
	
	public boolean puede_recibir(Potenciador p) {
		// To Do: programar la lógica para chequear match 3
		return true;
	}

}
