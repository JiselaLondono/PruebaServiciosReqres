package co.com.pruebarappi.servicios.stepdefinitions;

import co.com.pruebarappi.servicios.exceptions.NonExistentUserError;
import co.com.pruebarappi.servicios.models.User;
import co.com.pruebarappi.servicios.questions.ObtainedUser;
import co.com.pruebarappi.servicios.tasks.ConsumeTheSingleUserService;
import co.com.pruebarappi.servicios.tasks.GetSingleUserInformation;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultarUsuarioPorIdStepDefinition {

    @Dado("^que (.*) quiere consultar un usuario, usando el id (.*)$")
    public void consumeTheSingleUserService(String actor, int userId) {
        theActorCalled(actor).wasAbleTo(ConsumeTheSingleUserService.usingTheUserId(userId));
    }

    @Cuando("^se obtiene el usuario de la respuesta del servicio$")
    public void getUserFromServiceResponse() {
        theActorInTheSpotlight().wasAbleTo(GetSingleUserInformation.fromServiceResponse(lastResponse()));
    }

    @Entonces("^Jisela debería ver que el siguiente usuario existe en la respuesta$")
    public void validateResultsFromServiceResponse(List<User> users) {
        User user = theActorInTheSpotlight().recall("User");
        theActorInTheSpotlight().should(seeThat(ObtainedUser.fromServiceResponse(user).isEqualsTo(users.get(0))).orComplainWith(NonExistentUserError.class, "El usuario obtenido en el servicio es diferente al usuario esperado."));
    }
}
