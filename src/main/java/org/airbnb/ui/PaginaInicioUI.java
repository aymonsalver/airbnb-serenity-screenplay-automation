package org.airbnb.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaInicioUI {

    public static final Target INPUT_DESTINO = Target.the("Input para ingresar el destino")
            .located(By.id("bigsearch-query-location-input"));

    public static final Target BTN_AGREGAR_FECHAS = Target.the("Botón para agregar las fechas")
            .located(By.xpath("//div[text()='Agrega fechas']"));

    public static final Target BTN_HUESPEDES = Target.the("Botón para agregar los huéspedes")
            .located(By.xpath("//div[text()='¿Cuántos?']"));

    public static final Target BTN_AGG_ADULTO = Target.the("Botón para agregar adultos")
            .located(By.xpath("(//button[@data-testid='stepper-adults-increase-button'])[1]"));

    public static final Target BTN_AGG_NINO = Target.the("Botón para agregar niños")
            .located(By.xpath("(//button[@data-testid='stepper-children-increase-button'])[1]"));

    public static final Target BTN_AGG_MASCOTA = Target.the("Botón para agregar mascotas")
            .located(By.xpath("(//button[@data-testid='stepper-pets-increase-button'])[1]"));

    public static final Target BTN_BUSCAR = Target.the("Botón para buscar alojamiento")
            .located(By.xpath("//button[@data-testid='structured-search-input-search-button']"));

    public static final Target BTN_MENSAJE_POPUP = Target.the("Boton de entendido del popup")
            .located(By.xpath("//button[text()='Entendido']"));

    public static final Target BTN_FILTROS = Target.the("Botón para mostrar los filtros")
            .located(By.xpath("//button[@data-testid='category-bar-filter-button']"));

    public static final Target INPUT_PRECIO_MAX = Target.the("Input para filtrar el precio máximo")
            .located(By.id("price_filter_max"));

    public static final Target BTN_MOSTRAR_MAS_SERVICIOS = Target.the("Botón para mostrar más servicios")
            .located(By.xpath("//button[@aria-label='Muestra más comodidades']"));

    public static final Target BTN_FILTRAR = Target.the("Botón para filtrar la búsqueda")
            .located(By.xpath("//a[contains(normalize-space(), 'Mostrar')]"));

    public static final Target LBL_RESULTADOS_FILTRO = Target.the("Label de resultados de filtros")
            .located(By.xpath("//span[@data-testid='stays-page-heading']"));

    public static final Target IMG_PRIMER_RESULTADO = Target.the("Imagen del primer resultado")
            .located(By.xpath("(//div[@data-testid='card-container']//img)[1]"));

    public static Target BTN_SERVICIO = Target.the("Botón para filtrar por servicio")
            .locatedBy("//button[.//span[normalize-space()='{0}']]");

    public static Target LocalizadorPorTexto(String nombre) {
        return Target.the("Opcion de tab " + nombre)
                .located(By.xpath("//*[contains(text(), '" + nombre + "']"));
    }
}
