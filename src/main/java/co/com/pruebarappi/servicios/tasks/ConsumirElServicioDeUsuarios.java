package co.com.pruebarappi.servicios.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumirElServicioDeUsuarios implements Task {
    private Map<String, String> queryParameters = new HashMap<>();

    public ConsumirElServicioDeUsuarios(Map<String, String> queryParameters) {
        this.queryParameters = queryParameters;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at("https://reqres.in"));
        actor.attemptsTo(Get.resource("/api/users")
                .with(request -> request.contentType(ContentType.JSON).queryParams(queryParameters)
                        .log().all()
                        .relaxedHTTPSValidation()));
        actor.remember("RespuestaDeServicio", lastResponse());
    }

    public static ConsumirElServicioDeUsuarios usandoLosParametrosDeConsulta(Map<String, String> queryParameters) {
        return instrumented(ConsumirElServicioDeUsuarios.class, queryParameters);
    }
}
