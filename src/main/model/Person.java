package model;

import java.util.Scanner;

public class Person {
    private String name;
    private int age;

    Scanner scanner= new Scanner(System.in);
    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName() {
        System.out.print("Name: ");
        this.name = scanner.nextLine();
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        System.out.print("Age: ");
        this.age = scanner.nextInt();
    }
}
