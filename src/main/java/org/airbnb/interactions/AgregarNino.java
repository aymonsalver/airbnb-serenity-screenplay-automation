package org.airbnb.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.airbnb.ui.PaginaInicioUI.BTN_AGG_NINO;

public class AgregarNino implements Interaction {

    private int cantidadNinos;

    public AgregarNino(int cantidadNinos) {
        this.cantidadNinos = cantidadNinos;
    }

    @Override
    public <T extends Actor> void performAs(T actor){

        for (int i = 0; i < cantidadNinos; i++) {
            actor.attemptsTo(Click.on(BTN_AGG_NINO));
        }
    }

    public static AgregarNino agregar(int cantidadNinos) {
        return instrumented(AgregarNino.class, cantidadNinos);
    }
}
