package Objectives;

import Entidades.Entidad;

public class ObjetivoDestruirEntidad implements CarameloTrackerListener{
    Class<? extends Entidad> claseEntidad;
    int color;
    CarameloTracker tracker;
    int objetivo;

    public ObjetivoDestruirEntidad(Class<? extends Entidad> clase, int color, CarameloTracker tracker, int objetivo) {
        claseEntidad = clase;
        this.color = color;
        this.tracker = tracker;
        this.objetivo = objetivo;

        tracker.subscribir(this);
    }

    @Override
    public void notify(CarameloTracker tracker) {
        System.out.println("destruidos: " + tracker.getCantidadEntidad(claseEntidad, color) + " de " + objetivo);
    }
}
