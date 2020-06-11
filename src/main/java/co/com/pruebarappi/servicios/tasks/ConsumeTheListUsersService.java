package co.com.pruebarappi.servicios.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.Map;

import static co.com.pruebarappi.servicios.util.enums.EndPoints.REQRES_API_USERS;
import static co.com.pruebarappi.servicios.util.enums.EndPoints.REQRES_HOMEPAGE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeTheListUsersService implements Task {
    private Map<String, String> queryParameters;

    public ConsumeTheListUsersService(Map<String, String> queryParameters) {
        this.queryParameters = queryParameters;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(REQRES_HOMEPAGE.getPath()));
        actor.attemptsTo(Get.resource(REQRES_API_USERS.getPath())
                .with(request -> request.contentType(ContentType.JSON).queryParams(queryParameters)
                        .log().all()));
    }

    public static ConsumeTheListUsersService usingTheQueryParameters(Map<String, String> queryParameters) {
        return instrumented(ConsumeTheListUsersService.class, queryParameters);
    }
}
