package org.airbnb.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.airbnb.ui.PaginaInicioUI.BTN_AGG_ADULTO;

public class AgregarAdulto implements Interaction {

    private int cantidadAdultos;

    public AgregarAdulto(int cantidadAdultos) {
        this.cantidadAdultos = cantidadAdultos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        for (int i = 0; i < cantidadAdultos; i++) {
            actor.attemptsTo(Click.on(BTN_AGG_ADULTO));
        }
    }

    public static AgregarAdulto agregar(int cantidadAdultos) {
        return instrumented(AgregarAdulto.class, cantidadAdultos);
    }
}
