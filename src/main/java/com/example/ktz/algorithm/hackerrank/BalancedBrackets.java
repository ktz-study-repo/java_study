package com.example.ktz.algorithm.hackerrank;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedBrackets {

    public static boolean isBalanced(String expression) {
        Stack<Character> brackets = new Stack<Character>();
        for (char bracket : expression.toCharArray()) {
            if(isBegin(bracket)) {
                brackets.push(bracket);
            } else if(brackets.isEmpty()) {
                return false;
            } else if(isMatch(brackets.peek(), bracket)){
                brackets.pop();
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isBegin(Character bracket) {
        return (bracket == '[' || bracket == '{' || bracket == '(');
    }

    public static boolean isMatch(Character pivot, Character bracket) {
        switch(bracket) {
            case ']':
                return pivot == '[';
            case '}':
                return pivot == '{';
            case ')':
                return pivot == '(';
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
