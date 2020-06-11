package co.com.pruebarappi.servicios.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.pruebarappi.servicios.util.enums.EndPoints.REQRES_API_USERS;
import static co.com.pruebarappi.servicios.util.enums.EndPoints.REQRES_HOMEPAGE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeTheSingleUserService implements Task {
    private int userId;

    public ConsumeTheSingleUserService(int userId) {
        this.userId = userId;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(REQRES_HOMEPAGE.getPath()));
        actor.attemptsTo(Get.resource(REQRES_API_USERS.getPath() + "/" + userId)
                .with(request -> request.contentType(ContentType.JSON)
                        .log().all()));
    }

    public static ConsumeTheSingleUserService usingTheUserId(int userId) {
        return instrumented(ConsumeTheSingleUserService.class, userId);
    }
}
