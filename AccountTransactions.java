import java.util.Scanner;

public class AccountTransactions extends Users {
    public AccountTransactions(String name, String surname, String id, String password, double accountBalance) {
        super(name, surname, id, password, accountBalance);
    }

    static Scanner scanner = new Scanner(System.in);
    Users loggedUser = null;

    public static void moneyTransfer(Users loggedUser) {
        loggedUser = loggedUser;
        Users receiverAcoount = null;
        String receiverId;
        int tryCount = 0;
        double sentAmount;
        boolean isTransfered = false;
        while (receiverAcoount == null && tryCount < 3 && !isTransfered) {
            System.out.println("Enter receiver id (!c for cancel)");
            receiverId = scanner.nextLine();

            if (receiverId.equals("!c")) {
                System.out.println("Transaction cancelled.");
                return;
            }

            for (Users user : Users.userList) {

                if (receiverId.equals(user.id)) {
                    receiverAcoount = user;
                    break;
                }
            }
            if (receiverAcoount == null) {
                System.out.println("Receiver id is incorrect, try again");
                tryCount++;
                continue;
            }
            if (receiverId.equals(loggedUser.id)) {
                System.out.println("You cannot send money to yourself. Try again");
                tryCount++;
                continue;
            }
            tryCount = 0;
            while (receiverAcoount != null && tryCount < 3) {
                System.out.println("Receiver found" + receiverAcoount.name + " " + receiverAcoount.surname + " ");
                System.out.println("Enter the amount to be sent");
                String amountInput = scanner.nextLine().trim();
                if (amountInput.equals("!c")) {
                    System.out.println("Transaction cancelled.");
                    return;
                }
                try {
                    sentAmount = Double.parseDouble(amountInput);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount. Please enter a valid number.");
                    tryCount++;
                    continue;
                }
                if (sentAmount > loggedUser.accountBalance) {
                    System.out.println("You have not enough money for this transfer");
                    tryCount++;
                    continue;
                } else if (sentAmount <= 0) {
                    System.out.println("Please enter a valid amount\n");
                    tryCount++;
                    continue;

                } else if (0 < sentAmount && sentAmount <= loggedUser.accountBalance) {
                    Users.increaseBalance(receiverAcoount, sentAmount);
                    Users.decreaseBalance(loggedUser, sentAmount);
                    System.out.println(sentAmount + "dollars sent to " + receiverAcoount.name + " " + receiverAcoount.surname);
                    System.out.println("Your new account balance is : " + loggedUser.accountBalance);
                    tryCount = 0;
                    isTransfered = true;
                    break;


                }

            }

        }

    }

    public static void moneyDeposit(Users loggedUser) {
        loggedUser=loggedUser;
        double depositAmount=0;
        int tryCount = 0;
        while (tryCount < 3) {
            System.out.println("Enter amount to deposit into the account or !c for cancel");
            String amountInput = scanner.nextLine().trim();
            if (amountInput.equals("!c")) {
                System.out.println("The proccess cancelled");
                break;
            }
            try {
                depositAmount = Double.parseDouble(amountInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a valid number.");
                tryCount++;
                continue;

            }


            if (depositAmount <= 0) {
                System.out.println("Please enter a valid number :");
                tryCount++;
                continue;
            } else if (depositAmount>0) {
                Users.increaseBalance(loggedUser,depositAmount);
                System.out.println("Your new account balance is "+loggedUser.accountBalance+" dollars");
                break;
            }


        }
    }

    public static void withdrawMoney(Users loggedUser) {
        loggedUser=loggedUser;
        double withdrawAmount=0;
        int tryCount = 0;
        while (tryCount < 5) {
            System.out.println("Enter amount to deposit into the account or !c for cancel");
            String amountInput = scanner.nextLine().trim();
            if (amountInput.equals("!c")) {
                System.out.println("The proccess cancelled");
                break;
            }
            try {
                withdrawAmount = Double.parseDouble(amountInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a valid number.");
                tryCount++;
                continue;

            }


            if (withdrawAmount <= 0) {
                System.out.println("Please enter a valid number ");
                tryCount++;
                continue;
            }else if(withdrawAmount>loggedUser.accountBalance){
                System.out.println("You have not enough money for take it ");
                System.out.println("Your account balance is "+loggedUser.accountBalance);

                tryCount++;
                continue;

            }else if (withdrawAmount>0) {
                Users.decreaseBalance(loggedUser,withdrawAmount);
                System.out.println("Money withdrawn successfully");
                System.out.println("Your new account balance is "+loggedUser.accountBalance+" dollars");
                break;
            }


        }

    }
    public static void showBalance(Users loggeduser){
        loggeduser=loggeduser;
        System.out.println("Your account balance is : "+loggeduser.accountBalance+" dollars");
    }
    public static void allUserInformations(){
        for (Users user : Users.userList) {
            System.out.println("Name :"+user.name+" Surname :"+user.surname+" Id and password :"+user.id+" Account balance :"+user.accountBalance);
        }
    }

}
