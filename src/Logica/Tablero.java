package Logica;

import Entidades.Entidad;

/**
 * Modela el tablero de la aplicación. Mantiene control sobre las entidades, y provee acceso a ellas.
 * @author FJoaquin (federico.joaquin@cs.uns.edu.ar)
 *
 */
public class Tablero {
	
	protected Juego mi_juego;
	protected Entidad [][] entidades;
	protected int filas;
	protected int columnas;
	
	protected int pos_f_jugador;
	protected int pos_c_jugador;
	
	public Tablero(Juego j) {
		mi_juego = j;
		filas = 0;
		columnas = 0;
	}
	
	public int get_filas() {
		return filas;
	}
	
	public int get_columnas() {
		return columnas;
	}
	
	public Entidad get_entidad(int f, int c) {
		return entidades[f][c];
	}
	
	public void resetar_tablero(int f, int c) {
		filas = f;
		columnas = c;
		pos_f_jugador = 0;
		pos_c_jugador = 0;
		entidades = new Entidad[f][c];
	}
	
	public void agregar_entidad(Entidad e) {
		entidades[e.get_fila()][e.get_columna()] = e;
	}
	
	public void fijar_jugador(int f, int c) {
		if (entidades[f][c].enfocar()) {
			entidades[pos_f_jugador][pos_c_jugador].desenfocar();
			pos_f_jugador = f;
			pos_c_jugador = c;
		}
	}
	
	public void mover_jugador(int d) {
		switch(d) {
			case Juego.ABAJO:{
				mover_jugador_auxiliar(pos_f_jugador + 1, pos_c_jugador);
				break;
			}
			case Juego.ARRIBA:{
				mover_jugador_auxiliar(pos_f_jugador - 1, pos_c_jugador);
				break;
			}
			case Juego.IZQUIERDA:{
				mover_jugador_auxiliar(pos_f_jugador, pos_c_jugador - 1);
				break;
			}
			case Juego.DERECHA:{
				mover_jugador_auxiliar(pos_f_jugador, pos_c_jugador + 1);
				break;
			}
		}
	}
	
	public void intercambiar(int d) {
		switch(d) {
		case Juego.ABAJO:{
			intercambiar_auxiliar(pos_f_jugador + 1, pos_c_jugador);
			break;
		}
		case Juego.ARRIBA:{
			intercambiar_auxiliar(pos_f_jugador - 1, pos_c_jugador);
			break;
		}
		case Juego.IZQUIERDA:{
			intercambiar_auxiliar(pos_f_jugador, pos_c_jugador - 1);
			break;
		}
		case Juego.DERECHA:{
			intercambiar_auxiliar(pos_f_jugador, pos_c_jugador + 1);
			break;
		}
	}
	}
	
	private void mover_jugador_auxiliar(int nf, int nc) {
		if ( (0 <= nf) && (nf < filas) && (0 <= nc) && (nc < columnas)) {
			if (entidades[nf][nc].enfocar()) {
				entidades[pos_f_jugador][pos_c_jugador].desenfocar();
				pos_f_jugador = nf;
				pos_c_jugador = nc;
			}
		}
	}
	
	private void intercambiar_auxiliar(int nf, int nc) {
		if ( (0 <= nf) && (nf < filas) && (0 <= nc) && (nc < columnas)) {
			if (entidades[nf][nc].es_posible_intercambiar( entidades[pos_f_jugador][pos_c_jugador] )) {
				// To DO: Observar cómo sincronizar este intercambio y los eventos concurrentes 
				// que el usuario puede generar para intercambiar la entidad apuntada por el jugador.
				entidades[nf][nc].intercambiar_posicion(pos_f_jugador, pos_c_jugador);
				entidades[pos_f_jugador][pos_c_jugador].intercambiar_posicion(nf, nc);
				Entidad aux =  entidades[nf][nc];
				entidades[nf][nc] = entidades[pos_f_jugador][pos_c_jugador];
				entidades[pos_f_jugador][pos_c_jugador] = aux;
				pos_f_jugador = nf;
				pos_c_jugador = nc;
			}else {
				// To DO: No se pudo efectivizar el intercambio de entidades; animar el intercambio fallido.
			}
		}
	}
	
}
