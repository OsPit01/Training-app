import java.util.ArrayList;

public class User {
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> surname = new ArrayList<>();

    public User(String name, String surname) {
        this.name.add(name);
        this.surname.add(surname);
    }
}
