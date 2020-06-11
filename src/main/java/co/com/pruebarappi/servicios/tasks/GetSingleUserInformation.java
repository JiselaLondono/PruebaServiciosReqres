package co.com.pruebarappi.servicios.tasks;

import co.com.pruebarappi.servicios.models.User;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetSingleUserInformation implements Task {
    private Response response;

    public GetSingleUserInformation(Response response) {
        this.response = response;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        User user = new User(Integer.parseInt(response.jsonPath().getJsonObject("data.id").toString()),
                response.jsonPath().getJsonObject("data.email").toString(), response.jsonPath().getJsonObject("data.first_name").toString(),
                response.jsonPath().getJsonObject("data.last_name").toString(), response.jsonPath().getJsonObject("data.avatar").toString());

        actor.remember("User", user);
    }

    public static GetSingleUserInformation fromServiceResponse(Response response) {
        return instrumented(GetSingleUserInformation.class, response);
    }
}
