package model;

public class User {

    private String username;
    private String password;
    private String name;
    private String surname;

    private UserRole role;

    private UserStatus status;

    private String email;
    private long id;

    public User(String login, String password, String name, String surname, UserRole role, UserStatus status, String email,long id) {
        this.username = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.status = status;
        this.email = email;
        this.id = id;
    }

    public User(String login, String name, String surname, UserRole role, UserStatus status, String email,long id) {
        this.username = login;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.status = status;
        this.email = email;
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }


    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User:" + " " + username + " " +
                "password:" + " " + password + " " +
                "name:" + " " + name + " " +
                "surname:" + " " + surname + " " +
                "role:" + " " + role + " " +
                "status:" + " " + status + " " +
                "email:" + " " + email + " " +
                "Id:" + " " + id;
    }
}
