package views;

import model.Role;
import model.User;
import utils.CSVUtils;


import java.util.List;
import java.util.Scanner;

public class Loginview {
    public User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        Role role = authenticate(username, password);
        return new User(username, password, role);
    }



    private Role authenticate(String username, String password) {
        try {
            List<String> lines = CSVUtils.read("D:\\Documents\\CodeGym\\CaseModule2\\Case\\src\\main\\java\\data\\login.csv");
            for (String line : lines) {
                String[] fields = line.split(",");
                if (fields.length == 3 && fields[0].equals(username) && fields[1].equals(password)) {
                    return Role.fromValue(fields[2]);
                }
            }
            throw new IllegalArgumentException("Sai tên đăng nhập hoặc mật khẩu");
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Kiểm tra file csv", e);
        }
    }
}
