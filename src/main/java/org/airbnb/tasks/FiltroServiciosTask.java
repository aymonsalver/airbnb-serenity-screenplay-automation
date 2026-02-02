package org.airbnb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.airbnb.ui.PaginaInicioUI.*;

public class FiltroServiciosTask implements Task {

    private String servicio1;
    private String servicio2;
    private String servicio3;
    private String precioMax;

    public FiltroServiciosTask(String servicio1, String servicio2, String servicio3, String precioMax) {
        this.servicio1 = servicio1;
        this.servicio2 = servicio2;
        this.servicio3 = servicio3;
        this.precioMax = precioMax;
    }




    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_FILTROS),
                Click.on(INPUT_PRECIO_MAX),
                SendKeys.of(Keys.CONTROL,"a").into(INPUT_PRECIO_MAX),
                SendKeys.of(Keys.DELETE).into(INPUT_PRECIO_MAX),
                SendKeys.of(String.valueOf(precioMax)).into(INPUT_PRECIO_MAX),
                Click.on(BTN_MOSTRAR_MAS_SERVICIOS),
                Click.on(BTN_SERVICIO.of(servicio1)),
                Click.on(BTN_SERVICIO.of(servicio2)),
                Click.on(BTN_SERVICIO.of(servicio3)),
                Click.on(BTN_FILTRAR)
        );
    }

    public static FiltroServiciosTask filtrar(String servicio1, String servicio2, String servicio3, String precioMax) {
        return instrumented(FiltroServiciosTask.class , servicio1, servicio2, servicio3, precioMax);
    }
}
