package com.example.DataStructures;



import java.util.Stack;

public class ReverseStringWithStack {
    public static void main(String[] args) {
        String original = "Hello World";
        Stack<Character> stack = new Stack<>();
        
        // Push all characters of the string onto the stack
        for (char c : original.toCharArray()) {
            stack.push(c);
        }
        
        // Pop all characters from the stack to get them in reverse order
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed.toString());
    }
}
