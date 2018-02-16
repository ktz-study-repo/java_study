package com.example.ktz.algorithm.hackerrank;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TaleOfTwoStack {
    public static class MyQueue<T> {
        Stack<T> inbox = new Stack<T>();
        Stack<T> outbox = new Stack<T>();

        public void enqueue(T input) {
            inbox.push(input);
        }

        public T dequeue() {
            migrateInboxToOutbox();
            return outbox.pop();
        }

        public T peek() {
            migrateInboxToOutbox();
            return outbox.peek();
        }

        private void migrateInboxToOutbox() {
            if(outbox.isEmpty()) {
                while(!inbox.isEmpty()) {
                    T valueToPush = inbox.pop();
                    outbox.push(valueToPush);
                }
            }
        }

    }



    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
