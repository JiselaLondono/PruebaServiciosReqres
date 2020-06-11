package co.com.pruebarappi.servicios.util.enums;

public enum EndPoints {
    REQRES_HOMEPAGE("https://reqres.in"),
    REQRES_API_USERS("/api/users"),
    REQRES_API_LOGIN("/api/login");

    private String path;

    EndPoints(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
