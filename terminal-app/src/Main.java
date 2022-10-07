import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // may run this program in console
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = String.valueOf(System.console().readPassword());

        System.out.printf("Your username: %s, password: %s \n",
                username, password);
    }
}
