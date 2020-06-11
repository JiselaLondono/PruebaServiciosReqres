package co.com.pruebarappi.servicios.questions;

import co.com.pruebarappi.servicios.exceptions.NonExistentUserError;
import co.com.pruebarappi.servicios.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class ObtainedUserList implements Question<Boolean> {
    private List<User> usersFromServiceResponse;
    private List<User> usersToCompare;

    public ObtainedUserList(List<User> usersFromServiceResponse) {
        this.usersFromServiceResponse = usersFromServiceResponse;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean flag;

        for (User userToCompare : usersToCompare) {
            flag = false;
            for (User userFromServiceResponse: usersFromServiceResponse) {
                if(userFromServiceResponse.equals(userToCompare)) {
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                throw new NonExistentUserError("El usuario con id " + userToCompare.getId() + " no fue encontrado en la respuesta del servicio.");
            }
        }
        return true;
    }

    public static ObtainedUserList fromServiceResponse(List<User> usersFromServiceResponse) {
        return new ObtainedUserList(usersFromServiceResponse);
    }

    public ObtainedUserList containsUsers(List<User> usersToCompare) {
        this.usersToCompare = usersToCompare;
        return this;
    }
}
