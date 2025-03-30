import java.util.ArrayList;

public class Users {
    protected String name;
    protected String surname;
    protected String id;
    protected String password;
    protected double accountBalance;
    protected static ArrayList<Users> userList = new ArrayList<>();

    public Users(String name, String surname, String id, String password, double accountBalance) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.password = password;
        this.accountBalance = accountBalance;
    }

    //----------------------GETTER FUNCTIONS--------------------//
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public static void increaseBalance(Users user, double amount) {
        user.accountBalance += amount;
    }

    public static void decreaseBalance(Users user, double amount) {
        user.accountBalance -= amount;
    }


    public static void addUser(Users user) {
        userList.add(user);
    }


}
