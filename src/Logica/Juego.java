package Logica;
import java.awt.EventQueue;

import Entidades.Entidad;
import GUI.EntidadGrafica;
import GUI.Ventana;

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
	
	public void mover_jugador(int d) {
		mi_tablero.mover_jugador(d);
	}
	
	public void intercambiar(int d) {
		mi_tablero.intercambiar(d);
	}
	
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
	
	public static void main(String [] args) {
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	new Juego();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}

}
