import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Map <Integer, String> adminMenu = new HashMap<>();

    private final Map<Integer,String> adminAddSubmenu = new HashMap<>();
    private final Map<Integer,String> adminChangeSubmenu = new HashMap<>();
    private final Map<Integer,String> adminDeleteSubmenu = new HashMap<>();
    private final Map <Integer, String> userMenu = new HashMap<>();

    public Map<Integer, String> generateAdminAddSubmenu(){
        adminAddSubmenu.put(1, "Add book");
        adminAddSubmenu.put(2, "Add customer");
        adminAddSubmenu.put(3, "Add employee");
        adminAddSubmenu.put(4, "Add order");
        adminAddSubmenu.put(5, "Back to menu");
        return adminAddSubmenu;
    }

    public Map<Integer, String> generateAdminChangeSubmenu(){
        adminChangeSubmenu.put(1, "Change book");
        adminChangeSubmenu.put(2, "Change customer");
        adminChangeSubmenu.put(3, "Change employee");
        adminChangeSubmenu.put(4, "Change order");
        adminChangeSubmenu.put(5, "Back to menu");
        return adminChangeSubmenu;
    }

    public Map<Integer, String> generateAdminDeleteSubmenu(){
        adminDeleteSubmenu.put(1, "Delete book");
        adminDeleteSubmenu.put(2, "Delete customer");
        adminDeleteSubmenu.put(3, "Delete employee");
        adminDeleteSubmenu.put(4, "Delete order");
        adminDeleteSubmenu.put(5, "Back to menu");
        return adminDeleteSubmenu;
    }

    public void showMenu(Map<Integer, String> menu){
        for (int i = 1; i < menu.size() + 1; i++){
            System.out.println(i + ". " + menu.get(i));
        }
    }

    public Map<Integer, String> generateAdminMenu(){
        adminMenu.put(1, "Add in db");
        adminMenu.put(2, "Change in db");
        adminMenu.put(3, "Delete by id");
        adminMenu.put(4, "Log out");
        adminMenu.put(5, "Close program");

        return adminMenu;
    }

    public Map<Integer, String > generateUserMenu(){
        userMenu.put(1, "Show book db");
        userMenu.put(2, "Show customer db");
        userMenu.put(3, "Search book");
        userMenu.put(4, "Log out");
        userMenu.put(5, "Close program");

        return userMenu;
    }


    public int getMenuPointer() {
        System.out.println("\nEnter menu point");
        return new Scanner(System.in).nextInt();
    }
}
