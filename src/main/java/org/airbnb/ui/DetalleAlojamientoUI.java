package org.airbnb.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DetalleAlojamientoUI {

    public static final Target TITULO_ALOJAMIENTO = Target.the("Titulo del alojamiento seleccionado")
            .located(By.xpath("//h1"));

    public static final Target LBL_ANFITRION = Target.the("Label del anfitrión" )
            .located(By.xpath("//div[contains(text(), 'Anfitrión:')]"));

    public static final Target BTN_PRECIO = Target.the("boton del precio")
            .located(By.xpath("(//button//span[contains(text(), 'COP')])[2]"));

    public static final Target LBL_PRECIO = Target.the("Label del precio")
            .located(By.xpath("((//div[@role='dialog'])[2]//span[contains(text(), 'COP')])[1]"));

    public static final Target BTN_CERRAR_TRADUCCION = Target.the("Botón para cerrar la ventana de traducción")
            .located(By.xpath("//button[@aria-label='Cerrar']"));

    public static final Target BTN_RESERVAR = Target.the("Botón para reservar el alojamiento")
            .located(By.xpath("(//button[@data-testid='homes-pdp-cta-btn'])[2]"));
}
