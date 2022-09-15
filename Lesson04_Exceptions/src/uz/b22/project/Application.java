package uz.b22.project;

import uz.b22.project.ui.AuthUI;
import uz.b22.project.util.ScannerUtil;

public class Application {
    public static void main(String[] args) {

        try {

            while (true) {
                System.out.println("\n1. Register");
                System.out.println("2. Show user list");
                System.out.println("0. Exit");
                System.out.print("Choose: ");

                String choice = ScannerUtil.SCANNER_STR.nextLine();

                if (choice.equals("0")) break;

                switch (choice) {
                    case "1":
                        AuthUI.register();
                        break;
                    case "2":
                        AuthUI.showUserList();
                        break;
                }
            }

        } catch (Exception e) {

        }

    }
}
