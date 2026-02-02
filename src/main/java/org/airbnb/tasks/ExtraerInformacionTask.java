package org.airbnb.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.airbnb.interactions.CambiarAPestanaNueva;
import org.airbnb.utils.ExcelRedactorUtils;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.airbnb.ui.DetalleAlojamientoUI.*;

public class ExtraerInformacionTask implements Task {

    private final String rutaArchivo;

    public ExtraerInformacionTask(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(CambiarAPestanaNueva.cambiar());
        actor.attemptsTo(WaitUntil.the(BTN_CERRAR_TRADUCCION, isVisible() ).forNoMoreThan(15).seconds());
        actor.attemptsTo(Click.on(BTN_CERRAR_TRADUCCION));
        actor.attemptsTo(WaitUntil.the(TITULO_ALOJAMIENTO, isVisible() ).forNoMoreThan(15).seconds());
        actor.attemptsTo(WaitUntil.the(BTN_PRECIO, isClickable() ).forNoMoreThan(15).seconds());
        actor.attemptsTo(Click.on(BTN_PRECIO));
        actor.attemptsTo(WaitUntil.the(LBL_PRECIO, isVisible() ).forNoMoreThan(15).seconds());


        String nombreAlojamientoTexto = TITULO_ALOJAMIENTO.resolveFor(actor).getText();
        String anfitrionAlojamientoTexto = LBL_ANFITRION.resolveFor(actor).getText().split(":")[1].trim();
        String precioAlojamientoTexto = LBL_PRECIO.resolveFor(actor).getText();

        ExcelRedactorUtils.escribirExcel(rutaArchivo, nombreAlojamientoTexto, anfitrionAlojamientoTexto, precioAlojamientoTexto);

        System.out.println("✅ Datos del alojamiento:");
        System.out.println("   Nombre: " + nombreAlojamientoTexto);
        System.out.println("   Anfitrión: " + anfitrionAlojamientoTexto);
        System.out.println("   Precio: " + precioAlojamientoTexto);
    }

    public static ExtraerInformacionTask extraer(String rutaArchivo) {
        return instrumented(ExtraerInformacionTask.class, rutaArchivo);
    }
}
