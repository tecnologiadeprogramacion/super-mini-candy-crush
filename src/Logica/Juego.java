package Logica;
import java.awt.EventQueue;
import java.util.ArrayList;

import Entidades.Caramelo;
import Entidades.Entidad;
import Entidades.Glaseado;
import Entidades.Potenciador;
import GUI.EntidadGrafica;
import GUI.Ventana;
import Objectives.CarameloTracker;
import Objectives.ObjetivoDestruirEntidad;

/**
 * Modela el comportamiento del Juego.
 * Ofrece servicios para comunicar los diferentes elementos que conforman la lógica de la aplicación con la gráfica de la misma.
 * @author FJoaquin (federico.joaquin@cs.uns.edu.ar)
 *
 */
public class Juego {
	
	public static final int ARRIBA = 15000;
	public static final int ABAJO = 15001;
	public static final int IZQUIERDA = 15002;
	public static final int DERECHA = 15003;
	
	protected Tablero mi_tablero;
	protected Ventana mi_ventana;
	protected Nivel mi_nivel;
	
	public Juego() {
		mi_tablero = new Tablero(this);
		mi_nivel = GeneradorNivel.cargar_nivel_y_tablero(1, mi_tablero);
		mi_ventana = new Ventana(this, mi_tablero.get_filas(), mi_tablero.get_columnas());
		asociar_entidades_logicas_graficas();
		mi_tablero.fijar_jugador(mi_nivel.get_fila_inicial_jugador(), mi_nivel.get_columna_inicial_jugador());
	}
	
	/**
	 * Recibe la indicación de que el jugador desea moverse en la dirección indicada.
	 * Delega la resolución de movimiento y el correspondiente cambio de estado en el tablero.
	 * @param d Dirección a la que el jugador desea moverse. Se asume una constante de la clase Juego.
	 */
	public void mover_jugador(int d) {
		mi_tablero.mover_jugador(d);
	}
	
	/**
	 * Recibe la indicación de que el jugador desea intercambios dos elementos, considerando la posición del jugador y la dirección indicada.
	 * Delega la resolución del intercambio y el correspondiente cambio de estado en el tablero.
	 * @param d Dirección que el jugador desea considerar para el intercambio. Se asume una constante de la clase Juego.
	 */
	public void intercambiar(int d) {
		mi_tablero.intercambiar(d);
	}
	
	/**
	 * Asocia todas las entidades lógicas creadas a partir del generador de nivel, con las entidades gráficas que deberá crear la ventana
	 * y visualizar gráficamente.
	 */
	private void asociar_entidades_logicas_graficas() {
		Entidad e;
		EntidadGrafica eg;
		
		for (int f=0; f<mi_tablero.get_filas(); f++) {
			for (int c=0; c<mi_tablero.get_columnas(); c++) {
				e = mi_tablero.get_entidad(f, c);
				eg = mi_ventana.agregar_entidad(e);
				e.set_entidad_grafica(eg);
			}
		}
		mi_ventana.setVisible(true);
	}
	
	/**
	 * Método MAIN de lanzamiento de la APP.
	 * @param args
	 */
	public static void main(String [] args) {
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	new Juego();
					trackerTest();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}

	private static void trackerTest() {
		CarameloTracker tracker = new CarameloTracker();
		ObjetivoDestruirEntidad objetivoDestruirRojos = 
		new ObjetivoDestruirEntidad(Caramelo.class, Color.ROJO, tracker, 5);

		var lista = new ArrayList<Entidad>();
		lista.add(new Caramelo(0, 0, Color.ROJO));
		lista.add(new Caramelo(0, 0, Color.ROJO));
		lista.add(new Caramelo(0, 0, Color.ROJO));
		lista.add(new Glaseado(0, 0, Color.ROJO));
		lista.add(new Potenciador(0, 0, Color.ROJO));

		tracker.trackDestruction(lista);
		tracker.trackDestruction(lista);
	}
}
