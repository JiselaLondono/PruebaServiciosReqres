package co.com.pruebarappi.servicios.tasks;

import co.com.pruebarappi.servicios.models.User;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ObtenerInformacionDeUsuarios implements Task {
    private Response response;

    public ObtenerInformacionDeUsuarios(Response response) {
        this.response = response;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<HashMap> usuariosObtenidosDeRespuesta = response.jsonPath().getJsonObject("data");
        List<User> users = new ArrayList<>();

        for (HashMap usuarioObtenido : usuariosObtenidosDeRespuesta) {
            User user = new User(Integer.parseInt(usuarioObtenido.get("id").toString()),
                    usuarioObtenido.get("email").toString(), usuarioObtenido.get("first_name").toString(),
                    usuarioObtenido.get("last_name").toString(), usuarioObtenido.get("avatar").toString());
            users.add(user);
        }
        actor.remember("UsuariosDeRespuestaDelServicio", users);
    }

    public static ObtenerInformacionDeUsuarios deLaRespuestaDelServicio(Response response) {
        return instrumented(ObtenerInformacionDeUsuarios.class, response);
    }
}
