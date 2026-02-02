package org.airbnb.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CambiarAPestanaNueva implements Interaction {

    @Override
    public <T extends Actor> void performAs (T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        String originalHandle = driver.getWindowHandle();

        Set<String> ventanas = driver.getWindowHandles();
        for (String ventana : ventanas) {
            if (!ventana.equals(originalHandle)) {
                driver.switchTo().window(ventana);
                break;
            }
        }
    }

    public static CambiarAPestanaNueva cambiar() {
        return instrumented(CambiarAPestanaNueva.class);
    }
}
