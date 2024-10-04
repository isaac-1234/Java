package com.mycompany.javaapplication0;

import java.util.Scanner;

public class bienvenido {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Ask for the user's name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Ask for the user's age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Display a welcome message
        System.out.println("Welcome, " + name + "! You are " + age + " years old.");

        // Close the scanner
        scanner.close();
    }
}
