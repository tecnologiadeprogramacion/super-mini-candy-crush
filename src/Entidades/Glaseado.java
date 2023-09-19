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
	
	public boolean enfocar() {
		return false;
	}
	
	public boolean es_posible_intercambiar(Entidad e) {
		return false;
	}
	
	public boolean puede_recibir(Caramelo c) {
		return false;
	}
	
	public boolean puede_recibir(Glaseado g) {
		return false;
	}
	
	public boolean puede_recibir(Potenciador p) {
		return false;
	}
	
}
