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
                userShowSubmenuController();
                userMenuController();
            }
            case 2: {
                userSearchSubmenuController();
                userMenuController();
            }
            case 3: {
                checkRole();
            }
            case 4: {
                System.exit(0);
            }
            default: {
                System.out.println("Not a menu point");
            }
        }
    }

    public void userShowSubmenuController(){
        menu.showMenu(menu.generateUserShowSubmenu());
        int userShowSubmenuPoint = menu.getMenuPointer();

        switch (userShowSubmenuPoint){
            case 1: {
                dbManager.showBooks();
                userShowSubmenuController();
            }
            case 2: {
                dbManager.showCustomers();
                userShowSubmenuController();
            }
            case 3: {
                dbManager.showEmployee();
                userShowSubmenuController();
            }
            case 4: {
                dbManager.showOrders();
                userShowSubmenuController();
            }
            case 5: {
                userMenuController();
            }
            default: {
                System.out.println("Not a menu point");
            }
        }
    }

    public void userSearchSubmenuController(){
        menu.showMenu(menu.generateUserSearchSubmenu());
        int userSearchSubmenuPoint = menu.getMenuPointer();

        switch (userSearchSubmenuPoint){
            case 1: {
                System.out.print("Author: ");
                dbManager.searchBookByAuthor(scanner.nextLine());
                userSearchSubmenuController();
            }
            case 2: {
                System.out.print("Maximum price: ");
                dbManager.filterBookByPrice(scanner.nextInt());
                userSearchSubmenuController();
            }
            case 3: {
                userMenuController();
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
                adminChangeSubmenuController();
                adminMenuController();
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
            default: {
                System.out.println("Not a menu point");
            }
        }
    }

    public void adminChangeSubmenuController(){
        menu.showMenu(menu.generateAdminChangeSubmenu());
        int adminChangeSubmenuPoint = menu.getMenuPointer();
        switch (adminChangeSubmenuPoint) {
            case 1: {
                System.out.print("id: ");
                int id = scanner.nextInt();

                Book newBook = new Book();
                newBook.setTitle();
                newBook.setAuthor();
                newBook.setYearOfRelease();
                newBook.setGenre();
                newBook.setCountOfPages();
                newBook.setPrice();

                dbManager.changeBook(newBook, id);
                adminChangeSubmenuController();
            }
            case 2: {
                System.out.print("id: ");
                int id = scanner.nextInt();

                Customer newCustomer = new Customer();
                newCustomer.setName();
                newCustomer.setAge();

                dbManager.changeCustomer(newCustomer, id);
                adminChangeSubmenuController();
            }
            case 3: {
                System.out.print("id: ");
                int id = scanner.nextInt();

                Employee newEmployee = new Employee();
                newEmployee.setName();
                newEmployee.setAge();
                newEmployee.setPost();

                dbManager.changeEmployee(newEmployee, id);
                adminChangeSubmenuController();
            }
            case 4: {
                System.out.print("id: ");
                int id = scanner.nextInt();

                Order newOrder = new Order();
                newOrder.setEmployeeId();
                newOrder.setCustomerId();
                newOrder.setBookId();
                newOrder.setPurchaseDate();
                newOrder.setBookCount();
                newOrder.setPrice();

                dbManager.changeOrder(newOrder, id);
                adminChangeSubmenuController();
            }
            case 5: {
                adminMenuController();
            }
            default: {
                System.out.println("Not a menu point");
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
