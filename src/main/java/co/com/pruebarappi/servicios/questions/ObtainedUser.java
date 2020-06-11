package co.com.pruebarappi.servicios.questions;

import co.com.pruebarappi.servicios.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ObtainedUser implements Question<Boolean> {
    private User obtainedUser;
    private User expectedUser;

    public ObtainedUser(User obtainedUser) {
        this.obtainedUser = obtainedUser;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return expectedUser.equals(obtainedUser);
    }

    public static ObtainedUser fromServiceResponse(User obtainedUser) {
        return new ObtainedUser(obtainedUser);
    }

    public ObtainedUser isEqualsTo(User expectedUser) {
        this.expectedUser = expectedUser;
        return this;
    }
}
