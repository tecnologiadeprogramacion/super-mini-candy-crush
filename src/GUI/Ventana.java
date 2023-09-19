package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logica.EntidadLogica;
import Logica.Juego;
import Threads.AnimadorIntercambio;

/**
 * Modela el comportamiento de la Ventana de la aplicación.
 * Ofrece servicios para comunicar los diferentes elementos que conforman la gráfica de la aplicación con la lógica de la misma.
 * @author FJoaquin
 *
 */
@SuppressWarnings("serial")
public class Ventana extends JFrame {
	
	protected Juego mi_juego;
	protected int filas;
	protected int columnas;
	
	protected Celda celda_1_pendiente_animacion;
	protected Celda celda_2_pendiente_animacion;
	
	protected JLabel texto_superior;
	protected JPanel panel_principal;
	private int size_label = 60;
	
	public Ventana(Juego j, int f, int c) {
		mi_juego = j;
		filas = f;
		columnas = c;
		inicializar();
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
					case KeyEvent.VK_W:		{ mi_juego.intercambiar(Juego.ARRIBA); break; }
					case KeyEvent.VK_S:		{ mi_juego.intercambiar(Juego.ABAJO); break; }
					case KeyEvent.VK_A:		{ mi_juego.intercambiar(Juego.IZQUIERDA); break; }
					case KeyEvent.VK_D:		{ mi_juego.intercambiar(Juego.DERECHA); break; } 
				}
			}
		});
		
		getContentPane().add(panel_principal, BorderLayout.CENTER);
		getContentPane().add(texto_superior, BorderLayout.NORTH);
		
		panel_principal.setFocusable(true);
	}
	
	public EntidadGrafica agregar_entidad(EntidadLogica e) {
		Celda celda = new Celda(this, e, size_label);
		panel_principal.add(celda);
		return celda;
	}
	
	public void considerar_para_intercambio_posicion(Celda c) {
		if (celda_1_pendiente_animacion == null) {
			celda_1_pendiente_animacion = c;
		}else {
			celda_2_pendiente_animacion = c;
			AnimadorIntercambio mi_animador_intercambio = new AnimadorIntercambio(size_label, 10, 50, celda_1_pendiente_animacion, celda_2_pendiente_animacion);
			celda_1_pendiente_animacion = null;
			celda_2_pendiente_animacion = null;
			mi_animador_intercambio.start();
		}
	}
}
