package Animadores;

import java.util.Comparator;

public class ComparadorAnimadores implements Comparator<Animador>{

	public int compare(Animador animador_1, Animador animador_2) {
		int valor_comparacion_retorno = 0;
		int prioridad_1 = animador_1.get_prioridad();
		int prioridad_2 = animador_2.get_prioridad();
		
		if (prioridad_1 < prioridad_2) {
			valor_comparacion_retorno = -1;
		}else {
			if (prioridad_1 > prioridad_2) {
				valor_comparacion_retorno = 1;
			}
		}
		return valor_comparacion_retorno;
	}
}
