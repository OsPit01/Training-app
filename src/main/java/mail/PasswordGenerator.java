package mail;

import java.util.Random;

public class PasswordGenerator {
    private final String allowedLower = "qwertyuiopasdfghjklzxcvbnm";
    private final String allowedUpper = allowedLower.toUpperCase();
    private final String allowedNumbers = "0123456789";
    private final String allowedSpecialChars = "{}*&^%#@:<>";
    private final String allowedSymbols = allowedLower + allowedUpper + allowedNumbers + allowedSpecialChars;
    private final Random random = new Random();

    public String getRandomPassword(int first, int second) {
        int passwordLength = random.nextInt(first, second);
        char[] password = new char[passwordLength];

        for (int i = 0; i < passwordLength; i++) {
            password[i] = getRandomAllowedSymbol();
        }
        return new String(password);
    }

    public String getRandomPassword() {
        return getRandomPassword(12, 16);
    }

    private char getRandomAllowedSymbol() {
        int lastIndex = allowedSymbols.length() - 1;
        int randomIndex = random.nextInt(lastIndex);
        return allowedSymbols.charAt(randomIndex);
    }
}
