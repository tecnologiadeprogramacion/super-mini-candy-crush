package GUI;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidades.EntidadLogica;

@SuppressWarnings("serial")
public class Celda extends JLabel implements EntidadGrafica {
	
	protected VentanaAnimable ventana;
	protected EntidadLogica entidad_logica;
	
	protected int size_label;
	
	public Celda(VentanaAnimable ventana, EntidadLogica entidad_logica, int size_label, boolean visible) {
		super();
		
		this.ventana = ventana;
		this.entidad_logica = entidad_logica;
		this.size_label = size_label;
		this.setVisible(visible);
		
		int ubicacion_eje_x = entidad_logica.get_columna() * size_label;
		int ubicacion_eje_y = entidad_logica.get_fila() * size_label;
		int alto = size_label;
		int ancho = size_label;
		
		setBounds(ubicacion_eje_x, ubicacion_eje_y, ancho, alto);
		fijar_imagen_escalada_para_celda(entidad_logica.get_imagen_representativa());	
	}
	
	public EntidadLogica get_entidad_logica() {
		return entidad_logica;
	}
	
	public int get_size_label() {
		return size_label;
	}
	
	public void eliminar_de_ventana() {
		ventana.eliminar_celda(this);
	}
	
	// Operaciones para Entidad Grafica (Celda <-- Entidad Lógica)
	
	public void notificarse_intercambio(){
		ventana.animar_intercambio(this);
	}
	
	public void notificarse_cambio_foco() {
		ventana.animar_cambio_foco(this);
	}
	
	public void notificarse_detonacion() {
		ventana.animar_detonacion(this);
	}
	
	public void notificarse_caida() {
		ventana.animar_caida(this);
	}
	
	public void notificarse_cambio_visibilidad() {
		ventana.animar_cambio_visibilidad(this);
	}
	
	// Operaciones locales a celda
	
	protected void fijar_imagen_escalada_para_celda(String path_imagen) {
		ImageIcon icono_imagen = new ImageIcon(this.getClass().getResource(path_imagen));
		Image imagen_escalada = icono_imagen.getImage().getScaledInstance(size_label, size_label, Image.SCALE_SMOOTH);
		Icon icono_imagen_escalado = new ImageIcon(imagen_escalada);
		setIcon(icono_imagen_escalado);
	}
	
}
