package co.com.pruebarappi.servicios.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import java.util.LinkedHashMap;
import java.util.Map;

import static co.com.pruebarappi.servicios.util.enums.EndPoints.REQRES_API_LOGIN;
import static co.com.pruebarappi.servicios.util.enums.EndPoints.REQRES_HOMEPAGE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LogIntoReqres implements Task {
    private Map<String, String> body = new LinkedHashMap<>();

    public LogIntoReqres(String email, String password) {
        body.put("email", email);
        body.put("password", password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(REQRES_HOMEPAGE.getPath()));
        actor.attemptsTo(Post.to(REQRES_API_LOGIN.getPath())
                .with(request -> request.contentType(ContentType.JSON)
                        .body(body)
                        .log().all()));
    }

    public static LogIntoReqres withEmailAndPassword(String email, String password) {
        return instrumented(LogIntoReqres.class, email, password);
    }
}
