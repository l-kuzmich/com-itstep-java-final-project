import model.Book;
import model.BookGenre;

import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;
import java.util.Scanner;

public class MenuController {
    Menu menu = new Menu();

    public void controller() throws Exception {
        menu.showUserMenu();
        int menuPoint = menu.getMenuPointer();

        switch (menuPoint){
            case 1 : {
                System.out.println("show data");
            }
            case 2: {
                System.out.println("Enter password: ");
                if (Objects.equals(new Scanner(System.in).nextLine(), "root")){
                    menu.showAdminMenu();
                    int adminMenuPoint = menu.getMenuPointer();
                    switch (adminMenuPoint){
                        case 1 :{
                            Book g = new Book(1, "Gone with the wind", "Margaret Mitchell", LocalDate.of(1936, Month.JUNE, 30), BookGenre.Novel, 1037, 300);

                            DBManager dbManager = new DBManager();
                            dbManager.insertBook(g);

                            break;
                        }
                        case 2 :{

                        }
                        default: {
                            System.out.println("Not a menu point");
                        }
                    }
                } else {
                    System.out.println("Wrong password");
                }
            }
            default: {
                System.out.println("Not a menu point");
            }
        }
    }
}
