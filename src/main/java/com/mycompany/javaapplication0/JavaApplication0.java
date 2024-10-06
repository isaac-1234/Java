/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javaapplication0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaApplication0 extends JFrame implements ActionListener {

    // Components of the calculator
    private final JTextField inputField;
    private String operator;
    private double num1, num2, result;

    // Constructor
    public JavaApplication0() {
        // Create the frame
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input field
        inputField = new JTextField();
        inputField.setEditable(false);
        inputField.setHorizontalAlignment(SwingConstants.RIGHT);
        inputField.setFont(new Font("Arial", Font.BOLD, 30));
        add(inputField, BorderLayout.NORTH);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(); 
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

        // Button labels
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        // Create buttons and add them to the panel
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 30));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        // Display the frame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // If it's a number or decimal point
        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".")) {
            inputField.setText(inputField.getText() + command);
        }
        // If it's an operator
        else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            num1 = Double.parseDouble(inputField.getText());
            operator = command;
            inputField.setText("");
        }
        // If it's the equals sign
        else if (command.equals("=")) {
            num2 = Double.parseDouble(inputField.getText());
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            inputField.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        // Create and run the calculator
        new JavaApplication0();
    }
}
