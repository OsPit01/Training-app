package model;

public class User {
    private final String username;
    private final String password;
    private final String name;
    private final String surname;

    private final UserRole role;

    private UserStatus status;

    public User(String login, String password, String name, String surname, UserRole role, UserStatus active) {
        this.username = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.status = active;
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

    public UserRole getRole() {
        return role;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public UserStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "User:" + " " + username + " " +
                "password:" + " " + password + " " +
                "name:" + " " + name + " " +
                "surname:" + " " + surname + " " +
                "role:" + " " + role + " " +
                "status:" + " " + status;
    }
}
