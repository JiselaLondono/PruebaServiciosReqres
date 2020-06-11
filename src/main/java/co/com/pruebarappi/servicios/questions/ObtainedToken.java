package co.com.pruebarappi.servicios.questions;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ObtainedToken implements Question<Boolean> {
    private Response response;
    private String expectedToken;

    public ObtainedToken(Response response) {
        this.response = response;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return response.jsonPath().getJsonObject("token").toString().equals(expectedToken);
    }

    public static ObtainedToken fromServiceResponse(Response response) {
        return new ObtainedToken(response);
    }

    public ObtainedToken isEqualsTo(String expectedToken) {
        this.expectedToken = expectedToken;
        return this;
    }
}
