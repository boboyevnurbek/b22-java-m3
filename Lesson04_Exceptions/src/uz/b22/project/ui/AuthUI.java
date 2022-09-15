package uz.b22.project.ui;

import uz.b22.project.controller.AuthController;
import uz.b22.project.entity.User;
import uz.b22.project.util.ScannerUtil;

import java.util.List;

public class AuthUI {

    public static void register() {
        System.out.print("Full name: ");
        String fullName = ScannerUtil.SCANNER_STR.nextLine();
        System.out.print("Email: ");
        String email = ScannerUtil.SCANNER_STR.nextLine();
        System.out.print("Pasword: ");
        String password = ScannerUtil.SCANNER_STR.nextLine();

        String response = AuthController.register(fullName, email, password);
        System.out.println(response);
    }

    public static void showUserList() {
        List<User> users = AuthController.getUsers();
        if(users.isEmpty()){
            System.out.println("No users");
            return;
        }

        users.forEach(System.out::println);
    }
}

