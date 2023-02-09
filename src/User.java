import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    String surname;
    int id;
    String login;
    String password;

    public void addUser(String name, String surname, String login, String password) {
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
   // public void call() {
    //    System.out.printf("name: %s; surname: %s; id: %d; login: %s \n",name,surname,id,login,password);
  //  }
}

