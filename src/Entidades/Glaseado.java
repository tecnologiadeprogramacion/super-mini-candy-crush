package Entidades;

/**
 * Modela el comportamiento de los Glaseados.
 * @author FJoaquin (federico.joaquin@cs.uns.edu.ar)
 *
 */
public class Glaseado extends Entidad {

	public Glaseado(int f, int c, int col) {
		super(f, c, col, "/imagenes/glaseados/");
	}
	
	// Implementación comportamiento para intercambiable
	
	@Override
	public boolean es_posible_intercambiar(Entidad e) {
		return false;
	}
	
	@Override
	public boolean puede_recibir(Caramelo c) {
		return false;
	}
	
	@Override
	public boolean puede_recibir(Glaseado g) {
		return false;
	}
	
	@Override
	public boolean puede_recibir(Potenciador p) {
		return false;
	}
	
	// Implementación comportamiento para matchable
	
	@Override
	public boolean machea(Entidad e) {
		return false;
	}
	
	@Override
	public boolean match_con(Potenciador p) {
		return false;
	}
	
	@Override
	public boolean match_con(Glaseado g) {
		return false;
	}
	
	@Override
	public boolean match_con(Caramelo c) {
		return false;
	}

}
