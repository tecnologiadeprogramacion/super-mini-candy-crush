package Entidades;

import GUI.EntidadGrafica;
import Logica.EntidadLogica;

/**
 * Generaliza el comportamiento estándar de todas las entidades que forman parte del tablero.
 * @author FJoaquin (federico.joaquin@cs.uns.edu.ar)
 *
 */
public abstract class Entidad implements EntidadLogica, Enfocable, Intercambiable, Matchable, Detonable {
	protected int fila;
	protected int columna;
	protected int color;
	
	protected boolean enfocada;
	protected boolean detonada;
	
	protected String [] imagenes_representativas;
	protected EntidadGrafica entidad_grafica;
	
	/**
	 * Inicializa el estado interno de una entidad, considerando
	 * @param f La fila donde se ubica la entidad.
	 * @param c La columna donde se ubica la entidad.
	 * @param col El color asociado a la entidad. Se asume constante de la clase Color.
	 * @param path_img Ruta donde se encuentran todas las imágenes asociadas a la entidad creada.
	 */
	protected Entidad(int f, int c, int col, String path_img) {
		fila = f;
		columna = c;
		color = col;
		enfocada = false;
		detonada = false;
		cargar_imagenes_representativas(path_img);
	}
	
	/**
	 * Vincula el elemento con su entidad gráfica asociada.
	 * @param e Entidad gráfica que se encuentra asociada al elemento.
	 */
	public void set_entidad_grafica(EntidadGrafica e) {
		entidad_grafica = e;
	}
	
	/**
	 * Retorna la fila donde se ubica la entidad.
	 */
	public int get_fila() {
		return fila;
	}
	
	/**
	 * Retorna la columna donde se ubica la entidad.
	 */
	public int get_columna() {
		return columna;
	}
	
	/**
	 * Retorna el color asociado a la entidad.
	 * @return Constante numérica que representa el color de la entidad. Se asume un valor declarado en clase Color.
	 */
	public int get_color() {
		return color;
	}
	
	public String get_imagen_representativa() {
		int indice = 0;
		indice += (enfocada ? 1 : 0);
		indice += (detonada ? 2 : 0);
		return imagenes_representativas[indice];
	}
	
	@Override
	public void enfocar() {
		enfocada = true;
		entidad_grafica.notificarse_cambio_estado();
	}
	
	@Override
	public void desenfocar() {
		enfocada = false;
		entidad_grafica.notificarse_cambio_estado();
	}
	
	@Override
	public void cambiar_posicion(int nf, int nc) {
		fila = nf;
		columna = nc;
		entidad_grafica.notificarse_cambio_posicion();
	}
	
	@Override
	public void detonar() {
		detonada = true;
		entidad_grafica.notificarse_cambio_estado();
	}
	
	/**
	 * Inicializa el arreglo de paths que establecen las imágenes asociadas a los diferentes estados de la entidad.
	 * @param path_img Ruta donde se encuentran todas las imágenes asociadas a la entidad creada.
	 */
	private void cargar_imagenes_representativas(String path_img) {
		imagenes_representativas = new String [4];
		imagenes_representativas[0] = path_img + color +".png";
		imagenes_representativas[1] = path_img + color +"-enfocado.png";
		imagenes_representativas[2] = path_img + color +"-detonado.png";
		imagenes_representativas[3] = path_img + color +"-enfocado-detonado.png";
	}
}
