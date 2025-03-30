import java.util.Scanner;

public class Login extends Users {


    public Login(String name, String surname, String id, String password, double accountBalance) {
        super(name, surname, id, password, accountBalance);
    }

    public static Users login() {
        Scanner scanner = new Scanner(System.in);
        String incomingId;
        String incomingPassword;
        boolean idFound = false;
        boolean logged = false;
        int tryCount = 0;


        while (!logged && tryCount < 3) {
            System.out.println("Enter id : ");
            incomingId = scanner.nextLine();
            Users foundUser = null;
            if (tryCount == 2) {
                System.out.println("You have logged in incorrectly 3 times ");
                System.out.println("You are being returned to the menu....");
                Menu.menu();
                break;
            }

            for (Users user : Users.userList) {

                if (incomingId.equals(user.id)) {
                    foundUser = user;
                    break;
                }
            }
            if (foundUser == null) {
                System.out.println("User cannot found try again :");
                tryCount++;
                continue;
            }
            System.out.println("Enter password : ");
            incomingPassword = scanner.nextLine();

            if (incomingPassword.equals(foundUser.password)) {
                System.out.println("User " + foundUser.name + " successfully logged in :");
                logged = true;
                tryCount = 0;
                return foundUser;

            } else {
                System.out.println("Wrong password try again : ");
                tryCount++;
            }
            if (tryCount == 2) {
                System.out.println("You have logged in incorrectly 3 times ");
                System.out.println("You are being returned to the menu....");
                Menu.menu();
            }

        }


        return null;
    }
}
