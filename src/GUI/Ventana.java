package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Entidades.EntidadLogica;
import Logica.Juego;
import ManejadorAnimaciones.CentralAnimaciones;

@SuppressWarnings("serial")
public class Ventana extends JFrame implements VentanaJuego, VentanaAnimable, VentanaNotificable{
	
	protected Juego juego;
	protected CentralAnimaciones central_animaciones;

	protected int filas;
	protected int columnas;
	protected int animaciones_pendientes;
	private final int size_label = 60;
	protected boolean bloquear_teclado;
	
	protected JLabel texto_superior;
	protected JPanel panel_principal;
	
	public Ventana(Juego juego, int filas, int columnas) {
		this.juego = juego;
		this.central_animaciones = new CentralAnimaciones(this);
		this.filas = filas;
		this.columnas = columnas;
		animaciones_pendientes = 0;
		bloquear_teclado = false;
		crear_componentes_graficos();
	}
	
	// Operaciones para Ventana Juego (Ventana <-- Juego)
	
	public EntidadGrafica agregar_entidad(EntidadLogica e) {
		Celda celda = new Celda(this, e, size_label, e.get_visibilidad());
		panel_principal.add(celda);
		return celda;
	}
	
	public void ocultar() {
		this.setVisible(false);
	}
	
	public void mostrar() {
		this.setVisible(true);
	}
	
	public void transicionar() {
		// To DO. Podría servir para mostrar información o carteles.
	}
	
	public void resetear(Juego juego, int filas, int columnas) {
		// To DO.
	}
	
	// Operaciones para Ventana Animable (Ventana <-- Celda)
	
	public void animar_intercambio(Celda celda) {
		central_animaciones.animar_intercambio(celda);
	}
	
	public void animar_cambio_foco(Celda celda) {
		central_animaciones.animar_cambio_foco(celda);
	}
	
	public void animar_detonacion(Celda celda) {
		central_animaciones.animar_detonacion(celda);
	}
	
	public void animar_caida(Celda celda) {
		central_animaciones.animar_caida(celda);
	}
	
	public void animar_cambio_visibilidad(Celda celda) {
		central_animaciones.animar_cambio_visibilidad(celda);
	}
	
	public void eliminar_celda(Celda celda) {
		panel_principal.remove(celda);
		panel_principal.repaint();
	}
	
	// Operaciones para Ventana Notificable (Ventana <-- CentralDeAnimaciones)
	
	public void notificarse_animacion_en_progreso() {
		synchronized(this){
			animaciones_pendientes ++;
			bloquear_teclado = true;
		}
	}
	
	public void notificarse_animacion_finalizada() {
		synchronized(this){
			animaciones_pendientes --;
			bloquear_teclado = animaciones_pendientes > 0;
		}
	}
	
	// Operaciones locales a ventana
	
	protected void crear_componentes_graficos() {
		setTitle("TdP 2023 :: Super mini Candy Crush");
		setSize(new Dimension(500, 500));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		texto_superior = new JLabel("Esta es una versión super simplificada del Candy-Crush");
		
		panel_principal = new JPanel();
		panel_principal.setSize(size_label * filas, size_label * columnas);
		panel_principal.setLayout(null);
		panel_principal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {	
				switch(e.getKeyCode()) {
					case KeyEvent.VK_LEFT: 	{ if (!bloquear_teclado) juego.mover_jugador(Juego.IZQUIERDA); break; }
					case KeyEvent.VK_RIGHT: { if (!bloquear_teclado) juego.mover_jugador(Juego.DERECHA); break; }
					case KeyEvent.VK_UP: 	{ if (!bloquear_teclado) juego.mover_jugador(Juego.ARRIBA);break; }
					case KeyEvent.VK_DOWN: 	{ if (!bloquear_teclado) juego.mover_jugador(Juego.ABAJO); break; }
					case KeyEvent.VK_W:		{ if (!bloquear_teclado) juego.intercambiar_entidades(Juego.ARRIBA); break; }
					case KeyEvent.VK_S:		{ if (!bloquear_teclado) juego.intercambiar_entidades(Juego.ABAJO); break; }
					case KeyEvent.VK_A:		{ if (!bloquear_teclado) juego.intercambiar_entidades(Juego.IZQUIERDA); break; }
					case KeyEvent.VK_D:		{ if (!bloquear_teclado) juego.intercambiar_entidades(Juego.DERECHA); break; } 
				}
			}
		});
		
		getContentPane().add(panel_principal, BorderLayout.CENTER);
		getContentPane().add(texto_superior, BorderLayout.NORTH);
		
		panel_principal.setFocusable(true);
	}
}
