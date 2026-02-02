package org.airbnb.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static org.airbnb.ui.PaginaInicioUI.IMG_PRIMER_RESULTADO;

public class SeleccionarAlojamiento implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(IMG_PRIMER_RESULTADO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(IMG_PRIMER_RESULTADO)
        );
    }

    public static SeleccionarAlojamiento seleccionar() {
        return instrumented(SeleccionarAlojamiento.class);
    }
}
