package co.com.pruebarappi.servicios.stepdefinitions;

import co.com.pruebarappi.servicios.models.User;
import co.com.pruebarappi.servicios.questions.LaInformacionDeLosUsuarios;
import co.com.pruebarappi.servicios.questions.LastResponseStatusCode;
import co.com.pruebarappi.servicios.tasks.ConsumirElServicioDeUsuarios;
import co.com.pruebarappi.servicios.tasks.ObtenerInformacionDeUsuarios;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.equalTo;

public class ConsultaUsuariosStepDefinition {

    @Before
    public void setStage() {
        setTheStage(new OnlineCast());
    }

    @Dado("^que (.*) quiere consultar el listado de usuarios, usando el parámetro de consulta$")
    public void getUserInformation(String actor, Map<String, String> queryParameters) {
        theActorCalled(actor).wasAbleTo(ConsumirElServicioDeUsuarios.usandoLosParametrosDeConsulta(queryParameters));
    }

    @Cuando("^Jisela obtiene el código de respuesta (\\d+) y recuerda el listado de usuarios$")
    public void evaluarCodigoDeRespuesta(int statusCode) {
        Response response = theActorInTheSpotlight().recall("RespuestaDeServicio");

        theActorInTheSpotlight().should(seeThat(LastResponseStatusCode.is(), equalTo(statusCode)));
        theActorInTheSpotlight().wasAbleTo(ObtenerInformacionDeUsuarios.deLaRespuestaDelServicio(response));
    }

    @Entonces("^Jisela debería ver que los siguientes usuarios existen en el listado de respuesta$")
    public void validarRespuestaDeServicio(List<User> users) {
        List<User> listaDeUsuariosDeRespuesta = theActorInTheSpotlight().recall("UsuariosDeRespuestaDelServicio");
        theActorInTheSpotlight().should(seeThat(LaInformacionDeLosUsuarios.deLaRespuestaDelServicio(listaDeUsuariosDeRespuesta)
                .contieneLosUsuarios(users)));
    }
}
