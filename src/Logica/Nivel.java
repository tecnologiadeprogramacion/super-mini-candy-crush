package Logica;

/**
 * Modela la clase nivel. Se espera que el mismo permita observar los objetivos esperados para el nivel.
 * También se espera que permita mantener cuenta de los objetivos cumplidos y no, y que permita que el juego pueda consultar si
 * los objetivos fueron cumplimentados, para transicionar de nivel.
 * @author FJoaquin (federico.joaquin@cs.uns.edu.ar)
 *
 */
public class Nivel {
	
	protected int fila_inicial_jugador;
	protected int columna_inicial_jugador;
	
	public Nivel(int f, int c) {
		fila_inicial_jugador = f;
		columna_inicial_jugador = c;
	}
	
	public int get_fila_inicial_jugador() {
		return fila_inicial_jugador;
	}
	
	public int get_columna_inicial_jugador() {
		return columna_inicial_jugador;
	}
}
