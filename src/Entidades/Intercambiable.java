package Entidades;

public interface Intercambiable {

	public boolean es_posible_intercambiar(Entidad entidad);
	
	public boolean puede_recibir(Caramelo caramelo);

	public boolean puede_recibir(Glaseado glaseado);

	public boolean puede_recibir(Potenciador potenciador);

	public boolean puede_recibir(Gelatina gelatina);
	
	public void intercambiar(Entidad entidad);
	
	public void intercambiar_con(Caramelo caramelo);

	public void intercambiar_con(Glaseado glaseado);

	public void intercambiar_con(Potenciador potenciador);

	public void intercambiar_con(Gelatina gelatina);
}
