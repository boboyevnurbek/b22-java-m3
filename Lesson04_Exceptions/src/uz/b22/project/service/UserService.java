package uz.b22.project.service;

import uz.b22.exceptions.InvalidParamException;
import uz.b22.project.db.Database;
import uz.b22.project.entity.User;

import java.util.List;

public class UserService {
    public static String register(String fullName, String email, String password) {


        try {
            checkParams(fullName, email, password);

            Database.userList.add(new User(fullName, email, password));

            return String.format("%s successfully register", fullName);

        } catch (InvalidParamException e) {
            return e.getMessage();
        }

    }

    private static void checkParams(String fullName, String email, String password)
            throws InvalidParamException {
        if (fullName == null || fullName.isBlank()) {
            throw new InvalidParamException("Full name is required");
        }

        if (email == null || email.isBlank()) {
            throw new InvalidParamException("Email is required");
        }

        if (!email.contains("@")) {
            throw new InvalidParamException("Invalid email");
        }

        if (password == null || password.isBlank()) {
            throw new InvalidParamException("Password is required");
        }
    }

    public static List<User> allUsers() {
        return (List<User>) Database.userList.clone();
    }
}
