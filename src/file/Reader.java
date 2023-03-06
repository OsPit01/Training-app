package file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Reader {

    final File file; // если я поставлю здесь прайвит то файл подчеркивается: Field 'file' may be 'final'
    private final Scanner scanner;

    public Reader() throws IOException {
        file = new File("Information_about_users");
        scanner = new Scanner(file);
    }

    public void readFromFile() {
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            new UserFromFileToContainer().transferToFile(line);
        }
        scanner.close();
    }
}
