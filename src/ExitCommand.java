import java.io.FileWriter;
import java.io.IOException;

public class ExitCommand {
    public void exit() {
        try {
            FileWriter writer = new FileWriter("informationAboutUsers", true);
            writer.write(UserContainer.getUsers().toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
