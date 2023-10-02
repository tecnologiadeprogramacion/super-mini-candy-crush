package Animadores;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import GUI.Celda;
import GUI.Ventana;

/**
 * Modela el manager de animaciones requerido para efectivizar las mismas en función al orden en el que fueron solicitadas desde la ventana.
 * Ante cada nueva animación solicitada por ventana y que se debe realizar por sobre una celda, se encarga de efectivizar estas animaciones 
 * en el orden que corresponda a su arriba (FIFO).
 * Permite que dos o más animaciones por sobre una misma celda se realicen efectivamente en orden secuencial, sin solapamientos.
 * Las animaciones entre entidades diferentes se resolverán, recurrentemente, considerando que algunos animadores se efectivizarán mediante Threads.
 * @author FJoaquin (federico.joaquin@cs.uns.edu.ar)
 *
 */
public class CentralAnimaciones implements ManejadorAnimaciones{
	
	protected Ventana ventana;
	protected HashMap<Celda, List<Animador>> mapeo_celda_animaciones;
	protected int size_label;
	
	public CentralAnimaciones(Ventana v) {
		ventana = v;
		mapeo_celda_animaciones = new HashMap<Celda, List<Animador>>();
	}
	
	/**
	 * Indica que la celda parametrizada debe ser animada a partir de un cambio de posición.
	 * La animación será lanzada de inmediato, siempre que no existan animaciones en progreso sobre c.
	 * La animación será encolada para efectivizarse en el futuro, a la espera de que las animaciones solicitadas previamente sobre c
	 * se realicen primero.
	 * @param c Celda que debe animarse, en relación a la posición que ubica la JLabel y la ubicación indicada por la entidad lógica
	 * referenciada por c.
	 */
	public void animar_cambio_posicion(Celda c) {
		Animador animador = new AnimadorMovimiento(this, 10, 50, c);
		ventana.notificarse_animacion_en_progreso();
		
		if (tiene_animaciones_en_progreso (c) ) {
			mapeo_celda_animaciones.get(c).add(animador);
		}else {
			mapeo_celda_animaciones.put(c, new LinkedList<Animador>());
			mapeo_celda_animaciones.get(c).add(animador);
			animador.comenzar_animacion();
		}
	}
	
	/**
	 * Indica que la celda parametrizada debe ser animada a partir de un cambio de estado.
	 * La animación será lanzada de inmediato, siempre que no existan animaciones en progreso sobre c.
	 * La animación será encolada para efectivizarse en el futuro, a la espera de que las animaciones solicitadas previamente sobre c
	 * se realicen primero.
	 * @param c Celda que debe animarse, en relación a la imagen actual que la representa.
	 */
	public void animar_cambio_estado(Celda c) {
		Animador animador = new AnimadorCambioEstado(this, c);
		ventana.notificarse_animacion_en_progreso();
		
		if (tiene_animaciones_en_progreso (c) ) {
			mapeo_celda_animaciones.get(c).add(animador);
		}else {
			mapeo_celda_animaciones.put(c, new LinkedList<Animador>());
			mapeo_celda_animaciones.get(c).add(animador);
			animador.comenzar_animacion();
		}
		
	}

	@Override
	public void notificarse_finalizacion_animacion(Animador a) {
		Animador animador;
		List<Animador> animaciones_para_celda;
		
		ventana.notificarse_animacion_finalizada();
		
		animaciones_para_celda = mapeo_celda_animaciones.get(a.get_celda_asociada());
		animaciones_para_celda.remove(a);
		
		if (!animaciones_para_celda.isEmpty()) {
			animador = animaciones_para_celda.get(0);
			animador.comenzar_animacion();
		}
	}
	
	/**
	 * Estima si la celda parametrizada actualmente cuenta con animaciones en progreso. 
	 * @param c Celda que se desea considerar para el chequeo de animaciones en progreso.
	 * @return True si la celda tiene animaciones actualmente en progreso; false en caso contrario.
	 */
	private boolean tiene_animaciones_en_progreso(Celda c) {
		boolean retorno = false;
		if (mapeo_celda_animaciones.get(c) != null) {
			retorno = !mapeo_celda_animaciones.get(c).isEmpty();
		}
		return retorno;
	}
}
