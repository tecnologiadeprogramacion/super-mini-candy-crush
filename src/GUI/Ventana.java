package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Animadores.CentralAnimaciones;
import Logica.EntidadLogica;
import Logica.Juego;

/**
 * Modela el comportamiento de la Ventana de la aplicación.
 * Ofrece servicios para comunicar los diferentes elementos que conforman la gráfica de la aplicación con la lógica de la misma.
 * @author FJoaquin (federico.joaquin@cs.uns.edu.ar)
 *
 */
@SuppressWarnings("serial")
public class Ventana extends JFrame implements VentanaAnimable, VentanaNotificable{
	
	protected Juego mi_juego;
	protected CentralAnimaciones mi_animador;
	protected int filas;
	protected int columnas;
	
	protected int animaciones_pendientes;
	protected boolean bloquear_intercambios;
	
	protected JLabel texto_superior;
	protected JPanel panel_principal;
	private int size_label = 60;
	
	/**
	 * Inicializa la ventana asociada al juego en progreso, considerando
	 * @param j El juego que controlará la lógica de la aplicación, y con quien comunicará los movimientos del jugador.
	 * @param f La cantidad de filas del tablero.
	 * @param c La cantidad de columnas del tablero.
	 */
	public Ventana(Juego j, int f, int c) {
		mi_juego = j;
		mi_animador = new CentralAnimaciones(this);
		
		filas = f;
		columnas = c;
		
		animaciones_pendientes = 0;
		bloquear_intercambios = false;
		
		inicializar();
	}
	
	/**
	 * Crea una nueva celda, que quedará asociada a la entidad lógica parametrizada, a partir de la ubicación de esta.
	 * Agrega y deja visible la celda creada, por sobre la pantalla.
	 * @param e Entidad lógica con la que quedará asociada la celda.
	 * @return La entidad gráfica creada.
	 */
	public EntidadGrafica agregar_entidad(EntidadLogica e) {
		Celda celda = new Celda(this, e, size_label);
		panel_principal.add(celda);
		return celda;
	}
	
	@Override
	public void notificarse_animacion_en_progreso() {
		synchronized(this){
			animaciones_pendientes ++;
			bloquear_intercambios = true;
		}
	}
	
	@Override
	public void notificarse_animacion_finalizada() {
		synchronized(this){
			animaciones_pendientes --;
			bloquear_intercambios = animaciones_pendientes > 0;
		}
	}
	
	@Override
	public void animar_movimiento(Celda c) {
		mi_animador.animar_cambio_posicion(c);
	}
	
	@Override
	public void animar_cambio_estado(Celda c) {
		mi_animador.animar_cambio_estado(c);
	}
	
	protected void inicializar() {
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
					case KeyEvent.VK_LEFT: 	{ mi_juego.mover_jugador(Juego.IZQUIERDA); break; }
					case KeyEvent.VK_RIGHT: { mi_juego.mover_jugador(Juego.DERECHA); break; }
					case KeyEvent.VK_UP: 	{ mi_juego.mover_jugador(Juego.ARRIBA);break; }
					case KeyEvent.VK_DOWN: 	{ mi_juego.mover_jugador(Juego.ABAJO); break; }
					case KeyEvent.VK_W:		{ if (!bloquear_intercambios) mi_juego.intercambiar(Juego.ARRIBA); break; }
					case KeyEvent.VK_S:		{ if (!bloquear_intercambios) mi_juego.intercambiar(Juego.ABAJO); break; }
					case KeyEvent.VK_A:		{ if (!bloquear_intercambios) mi_juego.intercambiar(Juego.IZQUIERDA); break; }
					case KeyEvent.VK_D:		{ if (!bloquear_intercambios) mi_juego.intercambiar(Juego.DERECHA); break; } 
				}
			}
		});
		
		getContentPane().add(panel_principal, BorderLayout.CENTER);
		getContentPane().add(texto_superior, BorderLayout.NORTH);
		
		panel_principal.setFocusable(true);
	}
}
