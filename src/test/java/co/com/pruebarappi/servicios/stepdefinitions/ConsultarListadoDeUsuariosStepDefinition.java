package co.com.pruebarappi.servicios.stepdefinitions;

import co.com.pruebarappi.servicios.models.User;
import co.com.pruebarappi.servicios.questions.ObtainedUserList;
import co.com.pruebarappi.servicios.tasks.ConsumeTheListUsersService;
import co.com.pruebarappi.servicios.tasks.GetListUserInformation;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnlineCast;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class ConsultarListadoDeUsuariosStepDefinition {

    @Before
    public void setStage() {
        setTheStage(new OnlineCast());
    }

    @Dado("^que (.*) quiere consultar el listado de usuarios, usando el parámetro de consulta$")
    public void consumeTheListUsersService(String actor, Map<String, String> queryParameters) {
        theActorCalled(actor).wasAbleTo(ConsumeTheListUsersService.usingTheQueryParameters(queryParameters));
    }

    @Cuando("^se obtiene el listado de usuarios de la respuesta del servicio$")
    public void getUserList() {
        theActorInTheSpotlight().wasAbleTo(GetListUserInformation.fromServiceResponse(lastResponse()));
    }

    @Entonces("^Jisela debería ver que los siguientes usuarios existen en el listado de respuesta$")
    public void validateResultsFromServiceResponse(List<User> usersToCompare) {
        List<User> usersFromServiceResponse = theActorInTheSpotlight().recall("UsersFromServiceResponse");
        theActorInTheSpotlight().should(seeThat(ObtainedUserList.fromServiceResponse(usersFromServiceResponse)
                .containsUsers(usersToCompare)));
    }
}
