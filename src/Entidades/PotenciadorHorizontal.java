package Entidades;

import Logica.TableroNotificable;

public class PotenciadorHorizontal extends Potenciador {
	
	public PotenciadorHorizontal(TableroNotificable tablero, int fila, int columna, int color) {
		super(tablero, fila, columna, color, "/imagenes/potenciador/horizontal/", true);
	}
	
	public PotenciadorHorizontal(TableroNotificable tablero, int fila, int columna, int color, boolean visible) {
		super(tablero, fila, columna, color, "/imagenes/potenciador/horizontal/", visible);
	}	
}