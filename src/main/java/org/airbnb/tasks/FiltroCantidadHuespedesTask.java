package org.airbnb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.airbnb.interactions.AgregarAdulto;
import org.airbnb.interactions.AgregarMascota;
import org.airbnb.interactions.AgregarNino;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.airbnb.ui.PaginaInicioUI.*;

public class FiltroCantidadHuespedesTask implements Task {

    private int cantidadAdultos;
    private int cantidadNinos;
    private int cantidadMascotas;

    public FiltroCantidadHuespedesTask(int cantidadAdultos, int cantidadNinos, int cantidadMascotas) {
        this.cantidadAdultos = cantidadAdultos;
        this.cantidadNinos = cantidadNinos;
        this.cantidadMascotas = cantidadMascotas;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(Click.on(BTN_HUESPEDES));
        actor.attemptsTo(AgregarAdulto.agregar(cantidadAdultos));
        actor.attemptsTo(AgregarNino.agregar(cantidadNinos));
        actor.attemptsTo(AgregarMascota.agregar(cantidadMascotas));
        actor.attemptsTo(
                Click.on(BTN_BUSCAR),
                WaitUntil.the(BTN_MENSAJE_POPUP, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_MENSAJE_POPUP)
        );
    }

    public static FiltroCantidadHuespedesTask filtrar(int cantidadAdultos, int cantidadNinos, int cantidadMascotas) {
        return instrumented(FiltroCantidadHuespedesTask.class, cantidadAdultos, cantidadNinos, cantidadMascotas);
    }
}
