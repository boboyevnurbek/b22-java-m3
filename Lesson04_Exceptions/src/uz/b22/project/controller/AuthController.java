package uz.b22.project.controller;

import uz.b22.project.entity.User;
import uz.b22.project.service.UserService;

import java.util.List;

public class AuthController {
    public static String register(String fullName, String email, String password) {
        return UserService.register(fullName, email, password);
    }

    public static List<User> getUsers() {
        return UserService.allUsers();
    }
}
