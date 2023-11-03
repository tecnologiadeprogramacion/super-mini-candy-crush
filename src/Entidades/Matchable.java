package Entidades;

public interface Matchable {
	
	public boolean se_produce_match_con(Entidad e);
	
	public boolean aplica_match_con(Caramelo c);
	
	public boolean aplica_match_con(Potenciador p);
	
	public boolean aplica_match_con(Glaseado g);
	
	public boolean aplica_match_con(Gelatina g);
	
}
