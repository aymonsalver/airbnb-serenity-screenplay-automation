package org.airbnb.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.airbnb.ui.PaginaInicioUI.LBL_RESULTADOS_FILTRO;

public class ExistenResultados implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(WaitUntil.the(LBL_RESULTADOS_FILTRO, isVisible()).forNoMoreThan(10).seconds());
        return LBL_RESULTADOS_FILTRO.resolveFor(actor).isDisplayed();
    }

    public static ExistenResultados resultados() {
        return new ExistenResultados();
    }

}
