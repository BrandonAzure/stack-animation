/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brandon.stack.conversation;

import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author brand
 */
public class Conversation {

    public static StringBuilder[] prefixConversion(
            String arithmeticExpression) {
        StringBuilder prefix = new StringBuilder();
        StringBuilder infix = new StringBuilder(arithmeticExpression);
        String number = "";
        StringBuilder operatorStack = new StringBuilder();
        int index = 0;
        infix.reverse();
        Stack<String> stack = new Stack<String>();
        String expressionCharacters[] = new String[infix.length()];

        for (int i = 0; i < infix.length(); i++) {
            if (Character.isDigit(infix.charAt(i))) {
                number += infix.charAt(i);
            } else {
                if (!number.equals("")) {
                    expressionCharacters[index] = number;
                    number = "";
                    index++;
                }

                expressionCharacters[index] = String.valueOf(infix.charAt(i));
                index++;
            }

            if (i == infix.length() - 1 && !number.equals("")) {
                expressionCharacters[index] = number;
            }
        }

        for (int i = 0; i < expressionCharacters.length; i++) {
            if (expressionCharacters[i] != null) {
                if (expressionCharacters[i].equals("(")) {
                    expressionCharacters[i] = ")";
                } else if (expressionCharacters[i].equals(")")) {
                    expressionCharacters[i] = "(";
                }
            }

        }

        for (int i = 0; i < expressionCharacters.length; i++) {
            String character = expressionCharacters[i];
            
            if (character != null && !character.equals("")) {
                if (evaluateHierarchyLevel(character) > 0) {
                    while (stack.empty() == false
                            && evaluateHierarchyLevel(stack.peek())
                            >= evaluateHierarchyLevel(character)) {
                        prefix.append(stack.pop() + " ");
                    }
                    
                    
                    operatorStack.append(character + "  ");
                    stack.push(character);
                }

                if (character.equals(")")) {
                    String aux = stack.pop();
                    while (aux != "(") {
                        prefix.append(aux);
                        aux = stack.pop();
                    }
                }

                if (character.equals("(")) {
                    operatorStack.append(character + "  ");
                    stack.push(character);
                }

                try {
                    Integer.parseInt(character);
                    prefix.append(character + " ");
                } catch (Exception ex) {

                }
            }
        }

        for (int i = 0; i <= stack.size(); i++) {
            String aux = stack.pop();
            prefix.append(aux);
        }

        StringBuilder stacks[] = {prefix.reverse(), operatorStack};
        return stacks;
    }

    public static int evaluateHierarchyLevel(String character) {
        switch (character) {
            case "-":
            case "+":
                return 1;

            case "*":
            case "/":
                return 2;

            case "^":
                return 3;

        }
        return -1;
    }
}
