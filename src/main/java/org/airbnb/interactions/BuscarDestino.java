package org.airbnb.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.airbnb.ui.PaginaInicioUI.INPUT_DESTINO;

public class BuscarDestino implements Interaction {

    private String destino;

    public BuscarDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(destino).into(INPUT_DESTINO),
                SendKeys.of(Keys.ENTER).into(INPUT_DESTINO)
        );
    }

    public static BuscarDestino buscar(String destino) {
        return instrumented(BuscarDestino.class, destino);
    }
}
