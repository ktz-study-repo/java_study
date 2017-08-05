package org.example.ktz.rxjava.chap5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThread {
    private static final byte[] RESPONSE = (
            "HTTP/1.1 200 OK\r\n" +
                    "Content-length: 2\r\n" +
                    "\r\n" +
                    "OK").getBytes();

    private static int n = 0;


    public static void main(String[] args) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(8080, 100);
        while (!Thread.currentThread().isInterrupted()) {
            final Socket client = serverSocket.accept();
            handle(client);
        }
    }

    private static void handle(Socket client) throws IOException {
        try {
            // 디버그를 찍어보자. Thread가 정말 하나다.
            // 만약 새로운 요청이 들어와도, 지금 것이 끝나지 않으면 다음것을 받을 수 없다.
            while (!Thread.currentThread().isInterrupted()) {
                readFullRequest(client);
                client.getOutputStream().write(RESPONSE);
                System.out.println("n: " + n);
                if(n % 2 != 0) {
                    System.out.println("Sleep 5 sec");
                    Thread.sleep(5000);
                }
                n += 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            client.close();
        }
    }

    private static void readFullRequest(Socket client) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(client.getInputStream()));
        String line = reader.readLine();
        while (line != null && !line.isEmpty()) {
            line = reader.readLine();
        }
    }
}
