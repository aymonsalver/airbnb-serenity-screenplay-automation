package org.airbnb.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.airbnb.ui.PaginaInicioUI.LBL_RESULTADOS_FILTRO;

public class DestinoCoincide implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String destinoRecordado = actor.recall("destinoBuscado");

        if (destinoRecordado == null || destinoRecordado.isEmpty()) {
            throw new IllegalStateException("No se ha almacenado ningún destino en la memoria del actor.");
        }

        String destinoEsperado = destinoRecordado.split(",")[0].trim();

        WaitUntil.the(LBL_RESULTADOS_FILTRO, isVisible()).forNoMoreThan(10).seconds();
        String textoLabel = LBL_RESULTADOS_FILTRO.resolveFor(actor).getText();

        System.out.println("Destino recordado: " + destinoRecordado);
        System.out.println("Destino esperado: " + destinoEsperado);
        System.out.println("Texto label: " + textoLabel);

        return textoLabel.contains(destinoEsperado);
    }

    public static DestinoCoincide conDestino() {
        return new DestinoCoincide();
    }
}
