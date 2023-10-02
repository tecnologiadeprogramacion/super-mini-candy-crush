package GUI;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.EntidadLogica;

/**
 * Modela el comportamiento de las celdas que formarán parte de la ventana y que permitirán visualizar gráficamente a una EntidadLogica.
 * @author FJoaquin (federico.joaquin@cs.uns.edu.ar)
 *
 */
@SuppressWarnings("serial")
public class Celda extends JLabel implements EntidadGrafica {
	
	protected VentanaAnimable mi_ventana;
	protected EntidadLogica entidad_logica;
	protected int size_label;
	
	/**
	 * Incicializa el estado interno de una celda, considerando
	 * @param v La ventana a la que le solcitará animar cambios de estados o de posición, cuando la entidad lógica sí lo indique. 
	 * @param e La entidad lógica que será representada con este elemento, y que notificará de cualquier cambio que requiera una actualización
	 * desde la visión gráfica del mismo.
	 * @param s El tamaño asociado a las JLabels que contienen las imágenes de todas las entidades lógicas de la aplicación.
	 */
	public Celda(VentanaAnimable v, EntidadLogica e, int s) {
		super();
		mi_ventana = v;
		entidad_logica = e;
		size_label = s;
		setBounds(e.get_columna()*size_label, e.get_fila()*size_label, size_label, size_label);
		cambiar_imagen(e.get_imagen_representativa());	
	}
	
	@Override
	public void notificarse_cambio_estado() {
		mi_ventana.animar_cambio_estado(this);
	}
	
	@Override
	public void notificarse_cambio_posicion(){
		mi_ventana.animar_movimiento(this);
	}
	
	/**
	 * Obtiene la entidad lógica asociada a la entidad gráfica.
	 * @return La entidad lógica asociada.
	 */
	public EntidadLogica get_entidad_logica() {
		return entidad_logica;
	}
	
	/**
	 * Obtiene el tamaño asociado a la JLabel que representa la celda.
	 * @return El tamaño asociado.
	 */
	public int get_size_label() {
		return size_label;
	}
	
	/**
	 * Permite cambiar la imagen asociada a la celda, a partir de una ruta que especifica la ubicación de la nueva imagen.
	 * @param i Ruta hacia la nueva imagen a establecer por sobre la celda.
	 */
	protected void cambiar_imagen(String i) {
		ImageIcon imgIcon = new ImageIcon(this.getClass().getResource(i));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(size_label, size_label, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		setIcon(iconoEscalado);
	}
}
