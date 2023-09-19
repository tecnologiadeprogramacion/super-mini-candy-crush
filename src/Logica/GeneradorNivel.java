package Logica;

import Entidades.Caramelo;
import Entidades.Glaseado;
import Entidades.Potenciador;

/**
 * Simula el comportamiento real de un Generador de Nivel, cableando la generación de entidades de forma manual.
 * Se espera que la clase permita parsear el contenido de un archivo de texto, desde donde se generará efectivamente el nivel.
 * En esta versión, se permiten:
 * - Caramelos de todos los colores.
 * - Potenciadores de color Ladrillo
 * - Glaseados de color transparanete.
 * @author FJoaquin (federico.joaquin@cs.uns.edu.ar)
 *
 */
public class GeneradorNivel {

	public static Nivel cargar_nivel_y_tablero(int nivel, Tablero t) {
		t.resetar_tablero(5, 5);
		
		for(int y=0; y<3; y++) {
			t.agregar_entidad(new Caramelo(0,y, Color.AZUL));
			t.agregar_entidad(new Glaseado(1,y, Color.TRANSPARENTE));
			t.agregar_entidad(new Caramelo(2,y, Color.VERDE));
			t.agregar_entidad(new Potenciador(3,y, Color.LADRILLO));
			t.agregar_entidad(new Caramelo(4,y, Color.VIOLETA));
		}
		
		for(int y=3; y<5; y++) {
			t.agregar_entidad(new Caramelo(0,y, Color.AZUL));
			t.agregar_entidad(new Potenciador(1,y, Color.LADRILLO));
			t.agregar_entidad(new Caramelo(2,y, Color.VERDE));
			t.agregar_entidad(new Glaseado(3,y, Color.TRANSPARENTE));
			t.agregar_entidad(new Caramelo(4,y, Color.VIOLETA));
		}
		
		return new Nivel(2,2);
	}
	
}
