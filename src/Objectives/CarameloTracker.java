package Objectives;

import java.util.*;

import Entidades.Entidad;

/**
 * CarameloTracker
 */
public class CarameloTracker {

    Map<Class<? extends Entidad>, Map<Integer, Integer>> contadorCaramelos;
    List<CarameloTrackerListener> listeners;

     public CarameloTracker() {
        contadorCaramelos = new HashMap<>();
        listeners = new ArrayList<CarameloTrackerListener>();
    }

    public void trackDestruction(List<Entidad> entidadesDestruidas) {
        for (Entidad entidad : entidadesDestruidas) {
            Class<? extends Entidad> claseEntidad = entidad.getClass();
            Integer color = entidad.get_color();

            contadorCaramelos.putIfAbsent(claseEntidad, new HashMap<>());
            Map<Integer, Integer> cantidadColor = contadorCaramelos.get(claseEntidad);
            cantidadColor.put(color, cantidadColor.getOrDefault(color, 0) + 1);
        }

        notificarListeners();
    }

    public int getCantidadEntidad(Class<? extends Entidad> claseEntidad, int color) {
        if (contadorCaramelos.containsKey(claseEntidad)) {
            Map<Integer, Integer> colorCount = contadorCaramelos.get(claseEntidad);
            return colorCount.getOrDefault(color, 0);
        }
        return 0;
    }

    public void subscribir(CarameloTrackerListener listener) {
        listeners.add(listener);
    } 

    private void notificarListeners() {
        for (CarameloTrackerListener carameloTrackerListener : listeners) {
            carameloTrackerListener.notify(this);
        }
    }
}