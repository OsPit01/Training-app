import java.util.ArrayList;
import java.util.List;

public class User {

 static List<String> infoUser = new ArrayList<>();
    String name;
    String surname;
    String login;
    String password;

    public void addInfo(String name, String surname, String login, String password) {
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



    public void addInArray() {
        String result = "username:" + " " + getName() + " " + "surname:" + " " + getSurname() + " " + "login:" + getLogin() + " " + "password:" + getPassword();
         infoUser.add(result);
        System.out.println(infoUser);

       }
    }

