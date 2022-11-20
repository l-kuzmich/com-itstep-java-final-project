import model.Book;
import model.Customer;
import model.Employee;
import model.Order;

import java.util.Scanner;

public class MenuController implements CheckRole {
    Menu menu = new Menu();
    Scanner scanner = new Scanner(System.in);

    DBManager dbManager = new DBManager();

    Role role;

    public void userMenuController() {
        System.out.println("Welcome to user menu\n");
        menu.showMenu(menu.generateUserMenu());
        int menuPoint = menu.getMenuPointer();
        switch (menuPoint) {
            case 1: {
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

    public void adminMenuController() {
        System.out.println("Welcome to admin menu\n");
        menu.showMenu(menu.generateAdminMenu());
        int adminMenuPoint = menu.getMenuPointer();
        switch (adminMenuPoint) {
            case 1: {
               adminAddSubmenuController();
               adminMenuController();
            }
            case 2: {

            }
            case 3: {
                adminDeleteSubmenuController();
                adminMenuController();
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

    public void adminAddSubmenuController(){
        menu.showMenu(menu.generateAdminAddSubmenu());
        int adminAddSubmenuPoint = menu.getMenuPointer();
        switch (adminAddSubmenuPoint) {
            case 1: {
                Book newBook = new Book();
                newBook.setTitle();
                newBook.setAuthor();
                newBook.setYearOfRelease();
                newBook.setGenre();
                newBook.setCountOfPages();
                newBook.setPrice();

                dbManager.insertBook(newBook);
                adminAddSubmenuController();
            }
            case 2: {
                Customer newCustomer = new Customer();
                newCustomer.setName();
                newCustomer.setAge();

                dbManager.insertCustomer(newCustomer);
                adminAddSubmenuController();
            }
            case 3: {
                Employee newEmployee = new Employee();
                newEmployee.setName();
                newEmployee.setAge();
                newEmployee.setPost();

                dbManager.insertEmployee(newEmployee);
                adminAddSubmenuController();
            }
            case 4: {
                Order newOrder = new Order();
                newOrder.setEmployeeId();
                newOrder.setCustomerId();
                newOrder.setBookId();
                newOrder.setPurchaseDate();
                newOrder.setBookCount();
                newOrder.setPrice();

                dbManager.insertOrder(newOrder);
                adminAddSubmenuController();
            }
            case 5: {
                adminMenuController();
            }
        }
    }

    public void adminDeleteSubmenuController() {
        menu.showMenu(menu.generateAdminDeleteSubmenu());
        int adminDeleteSubmenuPoint = menu.getMenuPointer();
        switch (adminDeleteSubmenuPoint) {
            case 1: {
                System.out.print("Book id: ");
                dbManager.deleteBookById("book", scanner.nextInt());
                adminDeleteSubmenuController();
            }
            case 2:{
                System.out.print("Customer id: ");
                dbManager.deleteBookById("customer", scanner.nextInt());
                adminDeleteSubmenuController();
            }
            case 3:{
                System.out.print("Employee id: ");
                dbManager.deleteBookById("employee", scanner.nextInt());
                adminDeleteSubmenuController();
            }
            case 4:{
                System.out.print("Order id: ");
                dbManager.deleteBookById("order", scanner.nextInt());
                adminDeleteSubmenuController();
            }
            case 5:{
                adminMenuController();
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
