package model;

import java.util.Scanner;

public class Employee extends Person{

    private String post;

    public String getPost() {
        return post;
    }

    public void setPost() {
        System.out.print("Post: ");
        this.post = new Scanner(System.in).nextLine();
    }
}
