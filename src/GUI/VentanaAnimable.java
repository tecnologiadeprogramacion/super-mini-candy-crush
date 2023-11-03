package GUI;

public interface VentanaAnimable {
	
	public void animar_intercambio(Celda celda);
	
	public void animar_cambio_foco(Celda celda);
	
	public void animar_detonacion(Celda celda);
	
	public void animar_caida(Celda celda);
	
	public void animar_cambio_visibilidad(Celda celda);
	
	public void eliminar_celda(Celda celda);
}
