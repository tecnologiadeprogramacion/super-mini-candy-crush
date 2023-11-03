package Entidades;

import Logica.TableroNotificable;

public class Caramelo extends Entidad {
	
	public Caramelo(TableroNotificable tablero, int fila, int columna, int color) {
		super(tablero, fila, columna, color, "/imagenes/caramelo/", true);
	}
	
	public Caramelo(TableroNotificable tablero, int fila, int columna, int color, boolean visible) {
		super(tablero, fila, columna, color, "/imagenes/caramelo/", visible);
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
		return true;
	}

	public boolean puede_recibir(Gelatina gelatina) {
		return gelatina.get_caramelo_interno().puede_recibir(this);
	}
	
	public void intercambiar(Entidad entidad) {
		entidad.intercambiar_con(this);
	}
	
	public void intercambiar_con(Caramelo caramelo) {
		intercambiar_entidad_y_entidad(this, caramelo);
	}

	public void intercambiar_con(Potenciador potenciador) {
		intercambiar_entidad_y_entidad(this, potenciador);
	}
	
	public void intercambiar_con(Glaseado glaseado) {
		
	}

	public void intercambiar_con(Gelatina gelatina) {
		intercambiar_caramelo_y_gelatina(this, gelatina);
	}
	
	public boolean se_produce_match_con(Entidad e) {
		return e.aplica_match_con(this);
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