import java.util.Scanner;

public class Solution {

        public static void main(String[] args) {
            String userName = "";
            String password = "";
            Scanner scanner = new Scanner(System.in);


            while (true) {

                System.out.println("******** Register *********");
                System.out.println("1.Login 2.Register 3.exit 4.showMe list");
                System.out.println("please do choice");
                String choice = scanner.nextLine();

                switch (choice) {
                    case Command.LOGIN_CODE:
                        System.out.println("######## Enter for registered username ########");
                        userName = scanner.nextLine();
                        System.out.println("######## Inter for password #########");
                        password = scanner.nextLine();
                        new Login(userName, password);
                        break;
                    case Command.REGISTER_CODE:
                        System.out.println("############# Register ###############");
                        System.out.println("enter UserName");
                        userName = scanner.nextLine();
                        System.out.println("enter password ");
                        password = scanner.nextLine();
                        new Register(userName, password);
                        break;
                    case Command.EXIT_CODE:
                        new Exit();
                        break;
                    case Command.SHOW_ME_LIST_CODE:
                        new UserContainer().getList();
                        System.out.println("delet");
                        break;
                }
            }
        }
    }

