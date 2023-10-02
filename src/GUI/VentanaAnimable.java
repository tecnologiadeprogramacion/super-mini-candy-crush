package GUI;

/**
 * Define las operaciones esperables por sobre una ventana que permite animar los cambios de sus entidades.
 * Un ventana animable podrá llevar adelante la animación de movimiento o de cambio de estado, de una entidad.
 * @author FJoaquin (federico.joaquin@cs.uns.edu.ar)
 *
 */
public interface VentanaAnimable {
	
	/**
	 * Solicita se anime el movimiento entre la posición actual de una celda, y la posición nueva que tendrá a partir de una 
	 * modificación de la posición de la entidad lógica asociada.
	 * @param c La celda que debe modificar su posición, de forma animada.
	 */
	public void animar_movimiento(Celda c);
	
	/**
	 * Solicita se anime el cambio de estado entre la imagen actual de una celda, y la nueva imagen que tendrá a partir de una 
	 * modificación del estado de la entidad lógica asociada.
	 * @param c La celda que debe modificar su imagen asociada, de forma animada.
	 */
	public void animar_cambio_estado(Celda c);
}
