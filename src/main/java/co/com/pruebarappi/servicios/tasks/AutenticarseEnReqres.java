package co.com.pruebarappi.servicios.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AutenticarseEnReqres implements Task {
    //private String usuario;
    //private String clave;
    private Map<String, String> body = new LinkedHashMap<>();

    public AutenticarseEnReqres(String usuario, String clave) {
        //this.usuario = usuario;
        //this.clave = clave;
        body.put("email", usuario);
        body.put("password", clave);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at("https://reqres.in"));
        actor.attemptsTo(Post.to("/api/login")
                .with(request -> request.contentType(ContentType.JSON)
                        .body(body)
                        .log().all()
                        .relaxedHTTPSValidation()));
    }

    public static AutenticarseEnReqres conElUsuarioYLaClave(String usuario, String clave) {
        return instrumented(AutenticarseEnReqres.class, usuario, clave);
    }
}
