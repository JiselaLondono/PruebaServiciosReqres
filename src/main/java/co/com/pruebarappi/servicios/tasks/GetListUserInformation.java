package co.com.pruebarappi.servicios.tasks;

import co.com.pruebarappi.servicios.models.User;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetListUserInformation implements Task {
    private Response response;

    public GetListUserInformation(Response response) {
        this.response = response;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<HashMap> obtainedUsers = response.jsonPath().getJsonObject("data");
        List<User> users = new ArrayList<>();

        for (HashMap obtainedUser : obtainedUsers) {
            User user = new User(Integer.parseInt(obtainedUser.get("id").toString()),
                    obtainedUser.get("email").toString(), obtainedUser.get("first_name").toString(),
                    obtainedUser.get("last_name").toString(), obtainedUser.get("avatar").toString());
            users.add(user);
        }
        actor.remember("UsersFromServiceResponse", users);
    }

    public static GetListUserInformation fromServiceResponse(Response response) {
        return instrumented(GetListUserInformation.class, response);
    }
}
