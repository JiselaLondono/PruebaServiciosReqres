package co.com.pruebarappi.servicios.stepdefinitions;

import co.com.pruebarappi.servicios.exceptions.AutenticacionError;
import co.com.pruebarappi.servicios.questions.ElTokenObtenido;
import co.com.pruebarappi.servicios.questions.LastResponseStatusCode;
import co.com.pruebarappi.servicios.tasks.AutenticarseEnReqres;
import co.com.pruebarappi.servicios.tasks.ObtenerInformacionDeUsuarios;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class AutenticacionEnReqresStepDefinition {

    @Dado("^que (.*) quiere autenticarse en el aplicativo reqres con el correo (.*) y la clave (.*)$")
    public void autenticacionEnAplicativo(String actor, String usuario, String clave) {
        theActorCalled(actor).wasAbleTo(AutenticarseEnReqres.conElUsuarioYLaClave(usuario, clave));

    }

    @Cuando("^Jisela obtiene el código de respuesta (\\d+)$")
    public void evaluarCodigoDeRespuesta(int statusCode) {
        theActorInTheSpotlight().should(seeThat(LastResponseStatusCode.is(), equalTo(statusCode)));
    }

    @Entonces("^Jisela debería obtener el token (.*)$")
    public void jiselaDeberíaObtenerElTokenQpwLTkePnpjaX(String token) {
        theActorInTheSpotlight().should(seeThat(ElTokenObtenido.deLaRespuestaDelServicio(lastResponse()).esIgualA(token)).orComplainWith(AutenticacionError.class, "El token obtenido de la respuesta del servicio no es el esperado."));

    }
}
