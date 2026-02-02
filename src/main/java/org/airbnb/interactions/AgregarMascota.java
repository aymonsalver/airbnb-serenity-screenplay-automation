package org.airbnb.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.airbnb.ui.PaginaInicioUI.BTN_AGG_MASCOTA;

public class AgregarMascota implements Interaction {

    private int cantidadMascotas;

    public AgregarMascota(int cantidadMascotas) {
        this.cantidadMascotas = cantidadMascotas;
    }

    @Override
    public <T extends Actor> void performAs(T actor){

        for (int i = 0; i < cantidadMascotas; i++) {
            actor.attemptsTo(Click.on(BTN_AGG_MASCOTA));
        }
    }

    public static AgregarMascota agregar(int cantidadMascotas) {
        return instrumented(AgregarMascota.class, cantidadMascotas);
    }
}
