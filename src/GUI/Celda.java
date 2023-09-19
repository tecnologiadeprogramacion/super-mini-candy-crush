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
	
	protected Ventana mi_ventana;
	protected EntidadLogica entidad_logica;
	protected int size_label;
	
	public Celda(Ventana v, EntidadLogica e, int s) {
		super();
		mi_ventana = v;
		entidad_logica = e;
		size_label = s;
		setBounds(e.get_columna()*size_label, e.get_fila()*size_label, size_label, size_label);
		cambiar_imagen(e.get_imagen_representativa());	
	}
	
	@Override
	public void notificarse_cambio_estado() {
		cambiar_imagen(entidad_logica.get_imagen_representativa());
	}
	
	@Override
	public void notificarse_intercambio_posicion(){
		mi_ventana.considerar_para_intercambio_posicion(this);
	}
	
	public EntidadLogica get_entidad_logica() {
		return entidad_logica;
	}
	
	protected void cambiar_imagen(String i) {
		ImageIcon imgIcon = new ImageIcon(this.getClass().getResource(i));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(size_label, size_label, Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		setIcon(iconoEscalado);
	}
}
