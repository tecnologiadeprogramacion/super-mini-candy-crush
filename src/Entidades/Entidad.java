package Entidades;

import GUI.EntidadGrafica;
import Logica.TableroNotificable;

public abstract class Entidad implements EntidadLogica, Enfocable, Intercambiable, Matchable, Detonable, Ocultable {
	protected TableroNotificable tablero;
	protected EntidadGrafica entidad_grafica;
	
	protected int fila;
	protected int columna;
	protected int color;
	
	protected boolean enfocada;
	protected boolean detonada;
	protected boolean visible;
	
	protected String [] imagenes_representativas;
	
	protected Entidad(TableroNotificable tablero, int fila, int columna, int color, String path_imagenes, boolean visible) {
		this.tablero = tablero;
		this.fila = fila;
		this.columna = columna;
		this.color = color;
		this.enfocada = false;
		this.detonada = false;
		this.visible = visible;
		cargar_imagenes_representativas(path_imagenes);
	}
	
	private void cargar_imagenes_representativas(String path_img) {
		imagenes_representativas = new String [4];
		imagenes_representativas[0] = path_img + color +".png";
		imagenes_representativas[1] = path_img + color +"-enfocado.png";
		imagenes_representativas[2] = path_img + color +"-detonado.gif";
		imagenes_representativas[3] = path_img + color +"-enfocado-detonado.gif";
	}
	
	// Operaciones Entidad Logica (Entidad <-- Celda)
	
	public int get_fila() {
		return fila;
	}
	
	public int get_columna() {
		return columna;
	}
	
	public boolean get_visibilidad() {
		return visible;
	}
	
	public String get_imagen_representativa() {
		int indice = 0;
		indice += (enfocada ? 1 : 0);
		indice += (detonada ? 2 : 0);
		return imagenes_representativas[indice];
	}
	
	// Operaciones Enfocable (Entidad <-- Juego)
	
	public void enfocar() {
		enfocada = true;
		entidad_grafica.notificarse_cambio_foco();
	}
	
	public void desenfocar() {
		enfocada = false;
		entidad_grafica.notificarse_cambio_foco();
	}
	
	// Operaciones Detonable (Entidad <-- Juego)
	
	public void detonar() {
		detonada = true;
		entidad_grafica.notificarse_detonacion();
	}
	
	// Operaciones Ocultable (Entidad <-- Tablero)
	
	public void mostrar() {
		visible = true;
		entidad_grafica.notificarse_cambio_visibilidad();
	}
	
	public void ocultar() {
		visible = false;
		entidad_grafica.notificarse_cambio_visibilidad();
	}
	
	// Operaciones para cambio de posiciones
	
	public void cambiar_posicion(int nueva_fila, int nueva_columna) {
		fila = nueva_fila;
		columna = nueva_columna;
		entidad_grafica.notificarse_intercambio();
	}
	
	// TO DO: Completar con su correcta definición
	// Hardcodeada para mostrar caida simple y sin ningun tipo de control.
	public void caer() {
		fila ++;
		entidad_grafica.notificarse_caida();
	}
	
	// Operaciones para comandos y consulta de atributos 
	
	public void set_entidad_grafica(EntidadGrafica e) {
		entidad_grafica = e;
	}
	
	public int get_color() {
		return color;
	}
	
	// Operaciones locales a Entidad
	
	protected void intercambiar_entidad_y_entidad(Entidad origen, Entidad destino) {
		int nueva_fila_origen = destino.get_fila();
		int nueva_columna_origen = destino.get_columna();
		destino.cambiar_posicion(origen.get_fila(), origen.get_columna());
		origen.cambiar_posicion(nueva_fila_origen, nueva_columna_origen);
		tablero.reubicar(origen);
		tablero.reubicar(destino);
	}
	
	protected void intercambiar_caramelo_y_gelatina(Caramelo caramelo, Gelatina gelatina) {
		Caramelo caramelo_interno_gelatina = gelatina.get_caramelo_interno();
		int nueva_fila_caramelo = gelatina.get_fila();
		int nueva_columna_caramelo = gelatina.get_columna();
		int nueva_fila_caramelo_interno = caramelo.get_fila();
		int nueva_columna_caramelo_interno = caramelo.get_columna();
		
		caramelo_interno_gelatina.cambiar_posicion(nueva_fila_caramelo_interno, nueva_columna_caramelo_interno);
		caramelo.cambiar_posicion(nueva_fila_caramelo, nueva_columna_caramelo);
		gelatina.set_caramelo_interno(caramelo);
		tablero.reubicar(caramelo_interno_gelatina);
	}
}
