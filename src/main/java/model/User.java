package model;

public class User {
    private final String username;
    private final String password;
    private final String name;
    private final String surname;

    private final UserRole role;

    private String ban;

    public User(String login, String password, String name, String surname, UserRole role,String ban) {
        this.username = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.ban = ban;
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

    public void setBan(String ban) {
        this.ban = ban;
    }

    public String getBan() {
        return ban;
    }

    @Override
    public String toString() {
        return "User:" + " " + username + " " +
                "password:" + " " + password + " " +
                "name:" + " " + name + " " +
                "surname:" + " " + surname + " " +
                "role:" + " " + role + " " +
                "ban:" +  " " + ban;
    }
}
