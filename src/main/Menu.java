import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Map <Integer, String> adminMenu = new HashMap<>();
    private Map <Integer, String> userMenu = new HashMap<>();

    public Map<Integer, String> generateAdminMenu(){
        adminMenu.put(1, "Add book in db");
        adminMenu.put(2, "");


        return adminMenu;
    }

    public void generateUserMenu(){
        userMenu.put(1, "Show book db");
        userMenu.put(2, "Show customer db");
        userMenu.put(3, "Search book");
        userMenu.put(4, "Log out");
        userMenu.put(5, "Close program");
    }

    public void showAdminMenu(){
        generateAdminMenu();
        for (int i = 1; i < adminMenu.size() + 1; i++){
            System.out.println(i + ". " + adminMenu.get(i));
        }
    }

    public void showUserMenu(){
        generateUserMenu();
        for (int i = 1; i < userMenu.size() + 1; i++){
            System.out.println(i + ". " + userMenu.get(i));
        }
    }

    public int getMenuPointer() {
        System.out.println("Enter menu point");
        return new Scanner(System.in).nextInt();
    }
}
