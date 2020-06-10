package co.com.pruebarappi.servicios.questions;

import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class LastResponseStatusCode {

    private LastResponseStatusCode() {
    }

    public static Question<Integer> is() {
        lastResponse().prettyPrint();
        return a -> lastResponse().statusCode();
    }
}
