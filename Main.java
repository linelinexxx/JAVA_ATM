import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //-------------We are creating 10 users on here------------------//
        Users.addUser(new Users("Alex", "Alpha", "1111", "1111", 10000));
        Users.addUser(new Users("Brod", "Beta", "2222", "2222", 20000));
        Users.addUser(new Users("Chris", "Charlie", "3333", "3333", 30000));
        Users.addUser(new Users("David", "Delta", "4444", "4444", 40000));
        Users.addUser(new Users("Ethan", "Echo", "5555", "5555", 50000));
        Users.addUser(new Users("Frank", "Foxtrot", "6666", "6666", 60000));
        Users.addUser(new Users("George", "Golf", "7777", "7777", 70000));
        Users.addUser(new Users("Henry", "Hotel", "8888", "8888", 80000));
        Users.addUser(new Users("Isaac", "India", "9999", "9999", 90000));
        Users.addUser(new Users("Jack", "Juliet", "1010", "1010", 100000));


        //----------------Calling Menu ----------------------//

        String firstDecision;
        String secondDecision;
        Users loggedUser = null;


        //--------------Scan Decision-----------------------------//

        Scanner scanner = new Scanner(System.in);
        int tryCount = 0;

        //--------------Manage First Decision---------------------//
        while (loggedUser == null && tryCount < 3) {
            Menu.menu();
            firstDecision = scanner.nextLine();
            switch (firstDecision) {
                case "!l":

                    loggedUser = Login.login();//call login method
                    tryCount = 0;
                    break;
                case "!information":
                    AccountTransactions.allUserInformations();
                    System.out.println("\n\n");
                    tryCount=0;
                    continue;

                case "!q":
                    System.exit(0);

                default:
                    System.out.println("Please enter valid command :");
                    tryCount++;

            }


            while (loggedUser != null) {
                Menu.menuLogged();
                secondDecision = scanner.nextLine();
                switch (secondDecision) {
                    case "!t":
                        AccountTransactions.moneyTransfer(loggedUser);
                        break;
                    case "!d":
                        AccountTransactions.moneyDeposit(loggedUser);
                        break;
                    case "!w":
                        AccountTransactions.withdrawMoney(loggedUser);
                        break;
                    case "!s":
                        AccountTransactions.showBalance(loggedUser);
                        break;
                    case "!o":
                        System.out.println("User " + loggedUser.name + " logged out ");
                        loggedUser = null;

                    default:
                }

            }
        }


    }
}