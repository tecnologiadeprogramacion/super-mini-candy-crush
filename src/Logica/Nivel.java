package Logica;

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
