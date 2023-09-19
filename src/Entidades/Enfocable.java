package Entidades;

/**
 * Define las operaciones esperables por sobre las entidades enfocables.
 * @author FJoaquin (federico.joaquin@cs.uns.edu.ar)
 *
 */
public interface Enfocable {
	/**
	 * Fija el foco sobre el elemento que recibe el mensaje, en caso de ser posible.
	 * @return true si es posible aplicar el foco, false en caso contrario.
	 */
	public boolean enfocar();
	/**
	 * Quita el foco sobre el elemento que recibe el mensaje.
	 */
	public void desenfocar();
}
