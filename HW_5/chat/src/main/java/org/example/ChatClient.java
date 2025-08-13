package org.example;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int PORT = 5555;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT)) {
            System.out.println("Подключено к чату.");

            new Thread(new ReceiveMessages(socket)).start();
            sendMessages(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendMessages(Socket socket) {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {
            String message;
            while (scanner.hasNextLine()) {
                message = scanner.nextLine();
                out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ReceiveMessages implements Runnable {
        private Socket socket;

        public ReceiveMessages(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
