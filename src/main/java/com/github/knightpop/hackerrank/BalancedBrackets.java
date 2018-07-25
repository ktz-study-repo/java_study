package com.github.knightpop.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BalancedBrackets {

    public static boolean isBalanced(String brackets) {
        Stack<Character> bracketStack = new Stack<Character>();

        if(!isFirstOpened(brackets) || !isLastClosed(brackets) || brackets.length() % 2  != 0) {
            return false;
        }

        for(int idx = 0; idx < brackets.length(); idx++) {
            char c = brackets.charAt(idx);
            if(isOpened(c)) {
                bracketStack.push(c);
            } else if(bracketStack.isEmpty()) {
                return false;
            } else {
                Character opend = bracketStack.pop();
                if(!isMatched(opend, c))
                    return false;
            }
        }
        return bracketStack.isEmpty();
    }

    public static boolean isFirstOpened(String brackets) {
        return brackets.length() == 0 || isOpened(brackets.charAt(0));
    }

    public static boolean isLastClosed(String brackets) {
        return brackets.length() == 0 || !isOpened(brackets.charAt(brackets.length() - 1));
    }

    public static boolean isOpened(char c) {
        return c == '{' || c == '[' || c == '(';
    }

    public static boolean isMatched(char opened, char closed) {
        switch(opened) {
            case '{':
                return closed == '}';
            case '[':
                return closed == ']';
            case '(':
                return closed == ')';
            default:
                return false;
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String expression = scanner.nextLine();
            if(isBalanced(expression)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}