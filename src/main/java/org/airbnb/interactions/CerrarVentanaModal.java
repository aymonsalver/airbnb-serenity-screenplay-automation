package org.airbnb.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CerrarVentanaModal implements Interaction {

    private final Target botonCerrar;
    private final int tiempoEspera;

    public CerrarVentanaModal(Target botonCerrar, int tiempoEspera) {
        this.botonCerrar = botonCerrar;
        this.tiempoEspera = tiempoEspera;
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        long tiempoFinal = System.currentTimeMillis() + Duration.ofSeconds(tiempoEspera).toMillis();

        while(System.currentTimeMillis() < tiempoFinal){
            if (!botonCerrar.resolveAllFor(actor).isEmpty()){
                actor.attemptsTo(Click.on(botonCerrar));
                System.out.println("Modal cerrado correctamente");
                return;
            }
        }

        System.out.println("Modal no apareció dentro del tiempo esperado. Se continúa el flujo.");

    }

    public static CerrarVentanaModal cerrar(Target botonCerrar, int tiempoEspera){
        return instrumented(CerrarVentanaModal.class, botonCerrar, tiempoEspera);
    }
}
