package file;

import converter.StringToUserConverterSaveContainer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UserToRead {

    private static final File file = new File("Information_about_users");
    FileReader fileReader;
    BufferedReader reader;

    public UserToRead() throws IOException {
        fileReader = new FileReader(file);
        reader = new BufferedReader(fileReader);
    }


    public void readUserFromFile() throws IOException {
        String s = reader.readLine();
        while (s != null) {
            System.out.println(s);
            s = reader.readLine();
            new StringToUserConverterSaveContainer().convert(s);
        }
    }
}
