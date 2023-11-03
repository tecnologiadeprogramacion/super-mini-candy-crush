package Entidades;

import Logica.TableroNotificable;

public class PotenciadorVertical extends Potenciador {
	
	public PotenciadorVertical(TableroNotificable tablero, int fila, int columna, int color) {
		super(tablero, fila, columna, color, "/imagenes/potenciador/vertical/", true);
	}
	
	public PotenciadorVertical(TableroNotificable tablero, int fila, int columna, int color, boolean visible) {
		super(tablero, fila, columna, color, "/imagenes/potenciador/vertical/", visible);
	}
}
