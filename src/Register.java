import java.util.Scanner;


public class Register {


    public void Registry(String setName, String setPassword) {
        UserContainer.map.put(setName, setPassword);
        System.out.println("Registration was successful");

    }
}

