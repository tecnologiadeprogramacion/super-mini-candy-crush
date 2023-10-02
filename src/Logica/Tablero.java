package Logica;

import Entidades.Entidad;

/**
 * Modela el tablero de la aplicación. 
 * Mantiene control sobre las entidades, y provee acceso a ellas.
 * Se responsabiliza por desatar los intercambios entre entidades, y retrotrae los mismos cuando estos no provocan matchs. 
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
		entidades[f][c].enfocar();
		entidades[pos_f_jugador][pos_c_jugador].desenfocar();
		pos_f_jugador = f;
		pos_c_jugador = c;
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
		if ( en_rango(nf,nc) ) {
			entidades[nf][nc].enfocar();
			entidades[pos_f_jugador][pos_c_jugador].desenfocar();
			pos_f_jugador = nf;
			pos_c_jugador = nc;
		}
	}
	
	private void intercambiar_auxiliar(int nf, int nc) {
		int af = pos_f_jugador;
		int ac = pos_c_jugador;
		
		if ( en_rango(nf, nc) ) {	
			if (entidades[af][ac].es_posible_intercambiar( entidades[nf][nc] )) {
				// Anima el posible intercambio de entidades
				aplicar_intercambio(af, ac, nf, nc);
				
				// Si el intercambio provoca un match de 2 o 3 entidades, chequea las combinaciones y detona lo necesario
				// De lo contrario, retrotae el intercambio anterior que no fue válido
				if (entidades[af][ac].machea(entidades[nf][nc])) {
					entidades[af][ac].detonar();
					entidades[nf][nc].detonar();
				}else {
					aplicar_intercambio(nf, nc, af, ac);
				}
				
			}
		}
	}
	
	private void aplicar_intercambio(int af, int ac, int nf, int nc) {
		Entidad entidad_aux = entidades[af][ac];
		
		entidades[af][ac].cambiar_posicion(nf, nc);
		entidades[nf][nc].cambiar_posicion(af, ac);
		
		entidades[af][ac] = entidades[nf][nc];
		entidades[nf][nc] = entidad_aux;
		
		pos_f_jugador = nf;
		pos_c_jugador = nc;
	}
	
	private boolean en_rango(int nf, int nc){
		return ((0 <= nf) && (nf < filas) && (0 <= nc) && (nc < columnas));
	}
	
}
