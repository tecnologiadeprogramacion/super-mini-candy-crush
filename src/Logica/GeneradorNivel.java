package Logica;

import java.util.Random;

import Entidades.Caramelo;
import Entidades.Color;
import Entidades.Gelatina;
import Entidades.Glaseado;
import Entidades.PotenciadorHorizontal;
import Entidades.PotenciadorVertical;

public class GeneradorNivel {

	public static Nivel cargar_nivel_y_tablero(int nivel, TableroJuego tablero) {
		Random random = new Random(System.currentTimeMillis());
		Caramelo caramelo_random;
		int color_random;
		
		tablero.resetar_tablero(6, 6);
		
		for(int y=0; y<4; y++) {
			tablero.agregar_entidad(new Caramelo(tablero, 0, y, Color.AZUL));
			tablero.agregar_entidad(new Glaseado(tablero, 1, y, Color.NEGRO));
			tablero.agregar_entidad(new Caramelo(tablero, 2, y, Color.VERDE));
			tablero.agregar_entidad(new Caramelo(tablero, 3, y, Color.NARANJA));
			tablero.agregar_entidad(new PotenciadorHorizontal(tablero, 4, y, Color.VIOLETA));
			
			color_random = random.nextInt(3) + 1; // colores disponibles para caramelos 1-2-3
			caramelo_random = new Caramelo(tablero, 5, y, color_random);
			tablero.agregar_entidad_y_asociada(new Gelatina(tablero, caramelo_random, 5, y, Color.TRANSPARENTE));
		}
		
		for(int y=4; y<6; y++) {
			tablero.agregar_entidad(new PotenciadorVertical(tablero, 0, y, Color.AZUL));
			tablero.agregar_entidad(new Caramelo(tablero, 1, y, Color.ROJO));
			tablero.agregar_entidad(new Caramelo(tablero, 2, y, Color.VERDE));
			tablero.agregar_entidad(new Glaseado(tablero, 3, y, Color.NEGRO));
			tablero.agregar_entidad(new Caramelo(tablero, 4, y, Color.VIOLETA));
			tablero.agregar_entidad(new Caramelo(tablero, 5,y, Color.NARANJA));
		}
		
		return new Nivel(3,2);
	}
	
}
