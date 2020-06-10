package co.com.pruebarappi.servicios.questions;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ElTokenObtenido implements Question<Boolean> {
    private Response response;
    private String tokenEsperado;

    public ElTokenObtenido(Response response) {
        this.response = response;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return response.jsonPath().getJsonObject("token").toString().equals(tokenEsperado);
    }

    public static ElTokenObtenido deLaRespuestaDelServicio(Response lastResponse) {
        return new ElTokenObtenido(lastResponse);
    }

    public ElTokenObtenido esIgualA(String tokenEsperado) {
        this.tokenEsperado = tokenEsperado;
        return this;
    }
}
