package Entidades;

import Logica.TableroNotificable;

public class Gelatina extends Entidad {
	
	protected Caramelo caramelo_interno;
	
	public Gelatina(TableroNotificable tablero, Caramelo caramelo, int fila, int columna, int color) {
		super(tablero, fila, columna, color, "/imagenes/gelatina/", true);
		caramelo_interno = caramelo;
	}
	
	public Gelatina(TableroNotificable tablero, Caramelo caramelo, int fila, int columna, int color, boolean visible) {
		super(tablero, fila, columna, color, "/imagenes/gelatina/", visible);
		caramelo_interno = caramelo;
	}
	
	public void set_caramelo_interno(Caramelo caramelo) {
		caramelo_interno = caramelo;
	}
	
	public Caramelo get_caramelo_interno() {
		return caramelo_interno;
	}
		
	public void enfocar() {
		caramelo_interno.enfocar();
	}
	
	public void desenfocar() {
		caramelo_interno.desenfocar();
	}

	public boolean es_posible_intercambiar(Entidad entidad) {
		return entidad.puede_recibir(this);
	}

	public boolean puede_recibir(Caramelo caramelo) {
		return true;
	}

	public boolean puede_recibir(Glaseado glaseado) {
		return false;
	}

	public boolean puede_recibir(Potenciador potenciador) {
		return false;
	}

	public boolean puede_recibir(Gelatina gelatina) {
		return true;
	}

	public void intercambiar(Entidad entidad) {
		entidad.intercambiar_con(this);
	}

	public void intercambiar_con(Caramelo caramelo) {
		intercambiar_caramelo_y_gelatina(caramelo, this);		
	}

	public void intercambiar_con(Glaseado glaseado) {
				
	}

	public void intercambiar_con(Potenciador potenciador) {
		
	}

	public void intercambiar_con(Gelatina gelatina) {
		Caramelo caramelo_interno_this = caramelo_interno;
		Caramelo caramelo_interno_gelatina = gelatina.get_caramelo_interno();
		this.caramelo_interno = caramelo_interno_gelatina;
		gelatina.set_caramelo_interno(caramelo_interno_this);
		intercambiar_entidad_y_entidad(caramelo_interno_this, caramelo_interno_gelatina);
	}

	public boolean se_produce_match_con(Entidad e) {
		return false;
	}

	public boolean aplica_match_con(Caramelo c) {
		return false;
	}

	public boolean aplica_match_con(Potenciador p) {
		return false;
	}

	public boolean aplica_match_con(Glaseado g) {
		return false;
	}

	public boolean aplica_match_con(Gelatina g) {
		return false;
	}
}
