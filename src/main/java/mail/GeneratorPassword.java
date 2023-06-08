package mail;

import java.util.Random;

public class GeneratorPassword {

    public String generatedPassword() {

        String upperWords = "QWERTYUIOPASDFGHJKL";
        String lower = "qwertyuiopasdfghjkl";
        String num = "0123456789";
        String specialChars = "{}*&^%#@:<>";
        String combination = upperWords + lower + num + specialChars;
        int len = 8;
        char[] password = new char[len];
        Random r = new Random();
        for (int i = 0; i < len; i++) {
            password[i] = combination.charAt(r.nextInt(combination.length()));
        }
        return new String(password);
    }
}
