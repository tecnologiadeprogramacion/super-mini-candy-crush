package Logica;

import java.util.LinkedList;
import java.util.List;

import Entidades.Entidad;

public class EfectosDeTransicion {
	
	protected List<Entidad> entidades_a_detonar;
	protected List<Entidad> entidades_a_incorporar;
	protected List<Entidad> entidades_a_reemplazar;
	
	public EfectosDeTransicion() {
		entidades_a_detonar = new LinkedList<>();
		entidades_a_incorporar = new LinkedList<Entidad>();
		entidades_a_reemplazar = new LinkedList<Entidad>();
	}
	
	public void agregar_entidad_a_detonar_y_reemplazar(Entidad entidad) {
		entidades_a_detonar.add(entidad);
		entidades_a_reemplazar.add(entidad);
	}
	
	public void agregar_entidad_de_reemplazo(Entidad entidad) {
		entidades_a_incorporar.add(entidad);
	}
	
	public boolean existen_entidades_a_detonar() {
		return !entidades_a_detonar.isEmpty();
	}
	
	public boolean existen_entidades_a_incorporar() {
		return !entidades_a_incorporar.isEmpty();
	}
	
	public boolean existen_entidades_a_reemplazar() {
		return !entidades_a_reemplazar.isEmpty();
	}
	
	public List<Entidad> entidades_a_detonar(){
		return entidades_a_detonar;
	}

	public List<Entidad> entidades_a_incorporar(){
		return entidades_a_incorporar;
	}
	
	public List<Entidad> entidades_a_reemplazar(){
		return entidades_a_reemplazar;
	}
}
