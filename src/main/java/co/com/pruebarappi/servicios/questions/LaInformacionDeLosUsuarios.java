package co.com.pruebarappi.servicios.questions;

import co.com.pruebarappi.servicios.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.stream.Collectors;

public class LaInformacionDeLosUsuarios implements Question<Boolean> {
    private List<User> listaDeUsuariosDeRespuesta;
    private List<User> usuariosAComparar;

    public LaInformacionDeLosUsuarios(List<User> listaDeUsuariosDeRespuesta) {
        this.listaDeUsuariosDeRespuesta = listaDeUsuariosDeRespuesta;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<Boolean> areTheCorrectUsers;

        areTheCorrectUsers = usuariosAComparar.stream()
                .map(usuarioAComparar ->
                        listaDeUsuariosDeRespuesta.stream().anyMatch(usuarioDeListaDeRespuesta -> usuarioDeListaDeRespuesta.equals(usuarioAComparar)))
                .collect(Collectors.toList());

        for(Boolean isTheCorrectUser: areTheCorrectUsers) {
            if(!isTheCorrectUser) {
                return false;
            }
        }

        return true;
    }

    public static LaInformacionDeLosUsuarios deLaRespuestaDelServicio(List<User> listaDeUsuariosDeRespuesta) {
        return new LaInformacionDeLosUsuarios(listaDeUsuariosDeRespuesta);
    }

    public LaInformacionDeLosUsuarios contieneLosUsuarios(List<User> usuariosAComparar) {
        this.usuariosAComparar = usuariosAComparar;
        return this;
    }
}
