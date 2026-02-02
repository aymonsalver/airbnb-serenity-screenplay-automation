package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.airbnb.interactions.BuscarDestino;
import org.airbnb.interactions.IngresoFechas;
import org.airbnb.interactions.SeleccionarAlojamiento;
import org.airbnb.questions.DestinoCoincide;
import org.airbnb.questions.ExistenResultados;
import org.airbnb.tasks.AbrirNavegadorTask;
import org.airbnb.tasks.ExtraerInformacionTask;
import org.airbnb.tasks.FiltroCantidadHuespedesTask;
import org.airbnb.tasks.FiltroServiciosTask;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.Matchers.equalTo;

public class BusquedaAlojamientoStepDefinition {

    @Before
    public void setUp() {
        setTheStage(new OnlineCast());
    }

    @Given("que el usuario esta en la pagina principal de Airbnb")
    public void queElUsuarioEstaEnLaPaginaPrincipalDeAirbnb() {
        theActorCalled("Tester").wasAbleTo(
                AbrirNavegadorTask.open()
        );
    }

    @When("ingresa {string} como destino")
    public void ingresaComoDestino(String destino) {
        OnStage.theActorInTheSpotlight().remember("destinoBuscado", destino);
        OnStage.theActorInTheSpotlight().attemptsTo(
                BuscarDestino.buscar(destino)
        );
    }

    @When("selecciona su tiempo de estadia desde la fecha actual hasta {int} dias despues")
    public void seleccionaSuTiempoDeEstadiaDesdeLaFechaActualHastaDiasDespues(Integer dias) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresoFechas.conDias(dias)
        );
    }

    @When("selecciona en los huespedes {int} adultos, {int} nino y {int} mascota")
    public void seleccionaEnLosHuespedesAdultosNinoYMascota(Integer adulto, Integer nino, Integer mascota) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FiltroCantidadHuespedesTask.filtrar(adulto, nino, mascota)
        );
    }

    @When("aplica filtros de comodidades para {string}, {string} y {string} y ajusta el precio maximo a {int} antes de hacer clic en Mostrar")
    public void aplicaFiltrosDeComodidadesParaYYAjustaElPrecioMaximoAAntesDeHacerClicEnMostrar(String comodidad1, String comodidad2, String comodidad3, int precioMax) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FiltroServiciosTask.filtrar(comodidad1, comodidad2, comodidad3, String.valueOf(precioMax))
        );
    }

    @Then("deberia ver una lista de alojamientos que cumplen con esos filtros")
    public void deberiaVerUnaListaDeAlojamientosQueCumplenConEsosFiltros() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ExistenResultados.resultados(), equalTo(true))
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat(DestinoCoincide.conDestino(), equalTo(true))
        );
    }

    @When("selecciona el primer resultado")
    public void seleccionaElPrimerResultado() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarAlojamiento.seleccionar()
        );
    }

    @Then("deberia visualizarse los detalles en un archivo de excel")
    public void deberiaVisualizarseLosDetallesEnUnArchivoDeExcel() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ExtraerInformacionTask.extraer("src/test/resources/data/AlojamientoSeleccionado.xlsx")
        );
    }


}
