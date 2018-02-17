package com.example.ktz.algorithm.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Contacts {
    public static List<String> words = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
        }
    }

    public static void operateWord(String op, String contact) {
        switch(op) {
     case "add":
            addContact(contact);
            break;
     case "find":
            printNOfContact(contact);
            break;
        }
    }

    public static void addContact(String contact) {
        words.add(contact);
    }

    public static void printNOfContact(String contact) {
        Integer nOfContact = words.stream().filter(word -> word.startsWith(contact)).collect(Collectors.toList()).size();
        System.out.println(nOfContact);
    }

}
