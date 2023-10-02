package Entidades;

/**
 * Modela el comportamiento de los Potenciadores.
 * @author FJoaquin (federico.joaquin@cs.uns.edu.ar)
 *
 */
public class Potenciador extends Entidad {

	public Potenciador(int f, int c, int col) {
		super(f, c, col, "/imagenes/potenciadores/");
	}

	@Override
	public boolean es_posible_intercambiar(Entidad e) {
		return e.puede_recibir(this);
	}

	@Override
	public boolean puede_recibir(Caramelo c) {
		// To Do: programar la lógica para chequear match 3
		return true; 
	}

	@Override
	public boolean puede_recibir(Glaseado g) {
		return false;
	}
	
	@Override
	public boolean puede_recibir(Potenciador p) {
		return true;
	}
	
	// Implementación comportamiento para matchable
	@Override
	public boolean machea(Entidad e) {
		return e.match_con(this);
	}
	
	@Override
	public boolean match_con(Potenciador p) {
		// To DO: implementar la funcionalidad que chequea el match
		return false;
	}
	
	@Override
	public boolean match_con(Glaseado g) {
		// To DO: implementar la funcionalidad que chequea el match
		return false;
	}
	
	@Override
	public boolean match_con(Caramelo c) {
		// To DO: implementar la funcionalidad que chequea el match
		return false;
	}

}
