package Logica;

import Entidades.Entidad;
import Entidades.Gelatina;

public interface TableroJuego extends TableroNotificable{
	
	public int get_filas();
	
	public int get_columnas();
	
	public void asociar_entidades_logicas_y_graficas();
	
	public void resetar_tablero(int cant_filas, int cant_columnas);
	
	public void agregar_entidad(Entidad e);
	
	public void agregar_entidad_y_asociada(Gelatina g);
	
	public void fijar_jugador(int fila_destino, int columna_destino);
	
	public void mover_jugador(int direccion);
	
	public void intercambiar_entidades(int direccion);
}
