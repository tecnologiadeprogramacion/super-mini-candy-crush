package GUI;

import Entidades.EntidadLogica;
import Logica.Juego;

public interface VentanaJuego {

	public EntidadGrafica agregar_entidad(EntidadLogica entidad_logica);

	public void ocultar();

	public void mostrar();

	public void resetear(Juego juego, int filas, int columnas);

	public void transicionar();

}
