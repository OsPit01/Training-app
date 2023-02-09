public class User {
    private String name;
    private String surname;
    private int id = Integer.MAX_VALUE;
    private String login;
    private String password;

    public User(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User:" + "\n" +
                "name:" + name +
                ", surname:" + surname +
                ", id:" + id +
                ", login:" + login +
                ", password:" + password + "\n";
    }
}
