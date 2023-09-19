package Entidades;

import GUI.EntidadGrafica;
import Logica.EntidadLogica;

/**
 * Generaliza el comportamiento standar de todas las entidades que forman parte del tablero.
 * Asume por defecto que las entidades son enfocables.
 * @author FJoaquin (federico.joaquin@cs.uns.edu.ar)
 *
 */
public abstract class Entidad implements EntidadLogica, Intercambiable, Enfocable {
	protected int fila;
	protected int columna;
	protected int color;
	
	protected boolean enfocada;
	
	protected String [] imagenes_representativas;
	protected EntidadGrafica entidad_grafica;
	
	protected Entidad(int f, int c, int col, String path_img) {
		fila = f;
		columna = c;
		color = col;
		enfocada = false;
		cargar_imagenes_representativas(path_img);
	}
		
	public void set_entidad_grafica(EntidadGrafica e) {
		entidad_grafica = e;
	}
	
	public int get_fila() {
		return fila;
	}
	
	public int get_columna() {
		return columna;
	}
	
	public int get_color() {
		return color;
	}
	
	public String get_imagen_representativa() {
		int indice = 0;
		indice += (enfocada ? 1 : 0);
		return imagenes_representativas[indice];
	}
	
	@Override
	public boolean enfocar() {
		enfocada = true;
		entidad_grafica.notificarse_cambio_estado();
		return true;
	}
	
	@Override
	public void desenfocar() {
		enfocada = false;
		entidad_grafica.notificarse_cambio_estado();
	}
	
	@Override
	public void intercambiar_posicion(int nf, int nc) {
		fila = nf;
		columna = nc;
		entidad_grafica.notificarse_intercambio_posicion();
	}
	
	private void cargar_imagenes_representativas(String path_img) {
		imagenes_representativas = new String [2];
		imagenes_representativas[0] = path_img + color +".png";
		imagenes_representativas[1] = path_img + color +"-resaltado.png";
	}
}
