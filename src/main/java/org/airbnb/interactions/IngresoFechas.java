package org.airbnb.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresoFechas implements Interaction {

    private final int cantidadDias;

    public IngresoFechas(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public static Target BTN_FECHAS = Target.the("Boton para seleccionar las fechas")
            .locatedBy("//button[@data-state--date-string='{0}']");


    @Override
    public <T extends Actor> void performAs(T actor) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaFinal = fechaActual.plusDays(cantidadDias);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String fechaIngreso = fechaActual.format(formatter);
        String fechaSalida = fechaFinal.format(formatter);

        actor.attemptsTo(
                WaitUntil.the(BTN_FECHAS.of(fechaIngreso), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_FECHAS.of(fechaIngreso)),
                Click.on(BTN_FECHAS.of(fechaSalida))
        );

    }

    public static IngresoFechas conDias(int cantidadDias) {
        return instrumented(IngresoFechas.class, cantidadDias);
    }
}
