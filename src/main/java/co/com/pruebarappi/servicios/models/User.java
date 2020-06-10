package co.com.pruebarappi.servicios.models;

import java.util.Objects;

public class User {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String avatar;

    public User(int id, String email, String firstName, String lastName, String avatar) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return id == user.id &&
                email.equals(user.email) &&
                firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                avatar.equals(user.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, firstName, lastName, avatar);
    }
}
