package Animadores;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import GUI.Celda;
import ManejadorAnimaciones.CentralAnimaciones;

public class AnimadorCambioFoco implements Animador {

	protected CentralAnimaciones manager;
	protected Celda celda_animada;
	protected int prioridad;
	protected String path_imagen_estado;

	public AnimadorCambioFoco(CentralAnimaciones manager, Celda celda) {
		this.manager = manager;
		this.celda_animada = celda;
		this.prioridad = PrioridadAnimaciones.PRIORIDAD_FOCO;
		path_imagen_estado = celda.get_entidad_logica().get_imagen_representativa();
	}
	
	public Celda get_celda_asociada() {
		return celda_animada;
	}
	
	public int get_prioridad() {
		return prioridad;
	}

	public void comenzar_animacion() {
		int size_label = celda_animada.get_size_label();
		ImageIcon icono_imagen = new ImageIcon(this.getClass().getResource(path_imagen_estado));
		Image imagen_escalada = icono_imagen.getImage().getScaledInstance(size_label, size_label, Image.SCALE_REPLICATE);
		Icon icono_escalado = new ImageIcon(imagen_escalada);
		celda_animada.setIcon(icono_escalado);
		manager.notificarse_finalizacion_animador(this);
	}
}
