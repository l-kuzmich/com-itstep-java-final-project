import model.Book;
import model.BookGenre;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class MenuController implements CheckRole {
    Menu menu = new Menu();
    Scanner scanner = new Scanner(System.in);

    Role role;

    public void userMenuController() {
        menu.showUserMenu();
        int menuPoint = menu.getMenuPointer();
        switch (menuPoint) {
            case 1: {
                DBManager dbManager = new DBManager();
                dbManager.showBooks();
                userMenuController();
            }
            case 2: {

            }
            case 3: {

            }
            case 4: {
                checkRole();
            }
            case 5: {
                System.exit(0);
            }
            default: {
                System.out.println("Not a menu point");
            }
        }
    }

    public void adminMenuController() throws Exception {
        menu.showAdminMenu();
        int adminMenuPoint = menu.getMenuPointer();
        switch (adminMenuPoint) {
            case 1: {
                Book g = new Book(1, "Gone with the wind", "Margaret Mitchell", 1936, BookGenre.Novel, 1037, 300);

                DBManager dbManager = new DBManager();
                dbManager.insertBook(g);

                adminMenuController();
            }
            case 2: {

            }
            default: {
                System.out.println("Not a menu point");
            }
        }
    }

    @Override
    public void checkRole() {
        checkLogin();
        checkPassword();
        switch (role) {
            case USER: {
                userMenuController();
            }
            case ADMIN: {
                try {
                    adminMenuController();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            default: {
                System.out.println("Something was wrong");
            }
        }
    }

    public void checkLogin() {
        System.out.print("login: ");
        String login = scanner.nextLine();

        switch (login) {
            case "admin" -> role = Role.ADMIN;
            case "user" -> role = Role.USER;
            default -> {
                System.out.println("wrong login");
                checkLogin();
            }
        }
    }

    public void checkPassword() {
        System.out.print("password: ");
        String password = scanner.nextLine();

        if (role == Role.ADMIN) {
            if (password.equals("admin")) {
                System.out.println("login successful\n");
            } else {
                System.out.println("wrong password");
                checkPassword();
            }
        } else {
            if (password.equals("user")) {
                System.out.println("login successful\n");
            } else {
                System.out.println("wrong password");
                checkPassword();
            }
        }

    }
}
