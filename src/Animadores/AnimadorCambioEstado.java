package Animadores;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import GUI.Celda;

/**
 * Modela el comportamiento de un animador que permite visualizar el cambio de estado de una entidad.
 * Cuando el animador comienza su animación, modifica la imagen asociada a la celda animada.
 * La imagen que se considerará para efectivizar el cambio de estado, será la que se encontraba asociada a la celda lógica al momento
 * de crear el animador.
 * Una vez finalizada la animación, el animador notificará a su manager de esta situación.
 * @author FJoaquin (federico.joaquin@cs.uns.edu.ar)
 *
 */
public class AnimadorCambioEstado implements Animador {

	protected ManejadorAnimaciones mi_manager;
	protected Celda mi_celda_animada;
	
	protected String path_img;
	
	/**
	 * Inicializa el estado interno del animador, considerando:
	 * @param m El manejador de animaciones al que le notificará el fin de la animación, cuando corresponda.
	 * @param c La celda animada.
	 */
	public AnimadorCambioEstado(ManejadorAnimaciones m, Celda c) {
		mi_manager = m;
		mi_celda_animada = c;
		
		path_img = c.get_entidad_logica().get_imagen_representativa();
	}
	
	
	@Override
	public Celda get_celda_asociada() {
		return mi_celda_animada;
	}

	@Override
	public void comenzar_animacion() {
		int size_label = mi_celda_animada.get_size_label();
		ImageIcon imgIcon = new ImageIcon(this.getClass().getResource(path_img));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(size_label, size_label, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		mi_celda_animada.setIcon(iconoEscalado);
		mi_manager.notificarse_finalizacion_animacion(this);
	}

}
