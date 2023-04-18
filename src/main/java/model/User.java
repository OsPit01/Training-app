package model;

public class User {
    private final String username;
    private final String password;
    private final String name;
    private final String surname;
    private final String role;

    public User(String login, String password, String name, String surname, String role) {
        this.username = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User:" + " " + username + " " +
                "password:" + " " + password + " " +
                "name:" + " " + name + " " +
                "surname:" + " " + surname + " " +
                "role:" + " " + role;
    }
}
