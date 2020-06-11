package co.com.pruebarappi.servicios.stepdefinitions;

import co.com.pruebarappi.servicios.exceptions.LoginError;
import co.com.pruebarappi.servicios.questions.ObtainedToken;
import co.com.pruebarappi.servicios.questions.LastResponseStatusCode;
import co.com.pruebarappi.servicios.tasks.LogIntoReqres;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class AutenticacionEnReqresStepDefinition {

    @Dado("^que (.*) quiere autenticarse en el aplicativo reqres con el correo (.*) y la clave (.*)$")
    public void loginInTheApplication(String actor, String email, String password) {
        theActorCalled(actor).wasAbleTo(LogIntoReqres.withEmailAndPassword(email, password));
    }

    @Cuando("^se obtiene el código de respuesta (\\d+)$")
    public void validateResponseCode(int statusCode) {
        theActorInTheSpotlight().should(seeThat(LastResponseStatusCode.is(), equalTo(statusCode)));
    }

    @Entonces("^Jisela debería obtener el token (.*)$")
    public void validateToken(String token) {
        theActorInTheSpotlight().should(seeThat(ObtainedToken.fromServiceResponse(lastResponse()).isEqualsTo(token))
                .orComplainWith(LoginError.class, "El token obtenido de la respuesta del servicio no es el esperado."));
    }
}
