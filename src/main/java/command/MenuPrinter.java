package command;

public class MenuPrinter {

    public void ghost() {
        System.out.println("******** Register *********");
        System.out.println("please do choice");
        System.out.println("1.Login 2.Register 3.exit 4.showMe list");
    }

    public void admin() {
        System.out.println("1010 ---> choice user for ban" + '\n' + "1011 ---> choice user for unban");
        System.out.println("0 ---> show users in ban");
    }
}
