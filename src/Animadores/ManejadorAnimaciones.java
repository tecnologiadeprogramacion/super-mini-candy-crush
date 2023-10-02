package Animadores;

/**
 * Define las operaciones esperables por sobre un Manejador de Animaciones.
 * @author FJoaquin (federico.joaquin@cs.uns.edu.ar)
 *
 */
public interface ManejadorAnimaciones {
	
	/**
	 * Permite notificar la finalización de una animación llevada a cabo por el animador parametrizado, que se encontraba en curso.
	 * Notifica a la ventana asociada al manejador que se finalizó con una de las animaciones pendientes.
	 * @param a Animador que se encontraba en progreso y finalizó su actividad
	 */
	public void notificarse_finalizacion_animacion(Animador a);
	
}
