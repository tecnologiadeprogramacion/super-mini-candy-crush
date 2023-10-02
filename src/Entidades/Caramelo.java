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
	
	// Implementación comportamiento para intercambiable
	
	public boolean es_posible_intercambiar(Entidad e) {
		return e.puede_recibir(this);
	}
	
	public boolean puede_recibir(Caramelo c) {
		return true;
	}
	
	public boolean puede_recibir(Glaseado g) {
		return false;
	}
	
	public boolean puede_recibir(Potenciador p) {
		return true;
	}
	
	// Implementación comportamiento para matchable
	
	public boolean machea(Entidad e) {
		return e.match_con(this);
	}
	
	public boolean match_con(Potenciador p) {
		// To DO: implementar la funcionalidad que chequea el match
		return false;
	}
	
	public boolean match_con(Glaseado g) {
		// To DO: implementar la funcionalidad que chequea el match
		return false;
	}
	
	public boolean match_con(Caramelo c) {
		// To DO: implementar la funcionalidad que chequea el match
		return false;
	}

}
