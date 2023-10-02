package Entidades;

/**
 * Define los mensaje posibles de solicitar por sobre las entidades de la aplicación, 
 * respecto de su capacidad de matchear con otras entidades en el tablero ante un posible intercambio.
 * @author FJoaquin
 *
 */
public interface Matchable {
	
	/**
	 * Indica si la entidad receptora pueda permite generar un match con la entidad parametrizada.
	 * @param e Entidad con la que se analiza el match.
	 * @return True, en caso de match; false, en caso contrario.
	 */
	public boolean machea(Entidad e);
	
	/**
	 * Indica si la entidad receptora pueda permite generar un match con un caramelo parametrizado.
	 * @param c Caramelo con el que se analiza el match.
	 * @return True, en caso de match; false, en caso contrario.
	 */
	public boolean match_con(Caramelo c);
	
	/**
	 * Indica si la entidad receptora pueda permite generar un match con un potenciador parametrizado.
	 * @param p Potenciador con el que se analiza el match.
	 * @return True, en caso de match; false, en caso contrario.
	 */
	public boolean match_con(Potenciador p);
	
	/**
	 * Indica si la entidad receptora pueda permite generar un match con un glaseado parametrizado.
	 * @param g Glaseado con el que se analiza el match.
	 * @return True, en caso de match; false, en caso contrario.
	 */
	public boolean match_con(Glaseado g);
	
}
