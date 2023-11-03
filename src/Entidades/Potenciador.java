package Entidades;

import Logica.TableroNotificable;

public abstract class Potenciador extends Entidad {
	
	protected Potenciador(TableroNotificable tablero, int fila, int columna, int color, String path_imagenes, boolean visible) {
		super(tablero, fila, columna, color, path_imagenes, visible);
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
		return true;
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
		
	}
	
	public boolean se_produce_match_con(Entidad e) {
		return e.aplica_match_con(this);
	}
	
	public boolean aplica_match_con(Caramelo c) {
		return false;
	}
	
	public boolean aplica_match_con(Potenciador p) {
		return true;
	}
	
	public boolean aplica_match_con(Glaseado g) {
		return false;
	}
	
	public boolean aplica_match_con(Gelatina g) {
		return false;
	}
}