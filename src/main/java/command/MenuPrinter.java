package command;

import model.UserRole;

public class MenuPrinter {

    public void execute(UserRole userRole) {
        if (UserRole.GHOST == userRole) {
            System.out.println("******** Register *********");
            System.out.println("please do choice");
            System.out.println("1.Login 2.Register 3.exit 4.showMe list");
        }
        if (UserRole.ADMIN == userRole) {
            System.out.println("1010 ---> choice user for ban" + '\n' + "1011 ---> choice user for unban");
            System.out.println("0 ---> show users in ban");
        }
    }
}
