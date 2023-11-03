package Animadores;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import GUI.Celda;
import ManejadorAnimaciones.CentralAnimaciones;

public class AnimadorVisibilidad extends Thread implements Animador {

	protected CentralAnimaciones manager;
	protected Celda celda_animada;
	protected boolean debe_aparecer;
	protected int delay;
	protected int prioridad;
	protected String path_imagen_destello;
	protected String path_imagen_estado;

	public AnimadorVisibilidad(CentralAnimaciones manager, Celda celda, int delay) {
		this.manager = manager;
		this.celda_animada = celda;
		this.delay = delay;
		this.debe_aparecer = celda.get_entidad_logica().get_visibilidad();
		path_imagen_destello = "/imagenes/destello/destello.gif";
		path_imagen_estado = celda.get_entidad_logica().get_imagen_representativa();
	}
	
	public Celda get_celda_asociada() {
		return celda_animada;
	}
	
	public int get_prioridad() {
		return prioridad;
	}

	public void comenzar_animacion() {
		celda_animada.setVisible(true);
		this.start();
	}
	
	public void run() {
		if (debe_aparecer) {
			animar_mostrar();
		}else {
			animar_ocultar();
		}
		manager.notificarse_finalizacion_animador(this);
	}
	
	protected void animar_mostrar() {
		int size_label = celda_animada.get_size_label();
		ImageIcon icono_destello = new ImageIcon(this.getClass().getResource(path_imagen_destello));
		ImageIcon icono_imagen = new ImageIcon(this.getClass().getResource(path_imagen_estado));
		Image imagen_destello_escalada = icono_destello.getImage().getScaledInstance(size_label, size_label, Image.SCALE_REPLICATE);
		Image imagen_escalada = icono_imagen.getImage().getScaledInstance(size_label, size_label, Image.SCALE_REPLICATE);
		Icon icono_destello_escalado = new ImageIcon(imagen_destello_escalada);
		Icon icono_escalado = new ImageIcon(imagen_escalada);
		
		celda_animada.setIcon(icono_destello_escalado);
		
		try {
			sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		celda_animada.setIcon(icono_escalado);
	}
	
	protected void animar_ocultar() {
		celda_animada.setVisible(false);
	}
}
