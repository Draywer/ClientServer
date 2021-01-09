package ru.idcore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private BufferedReader reader;

    public void startConnection(String ip, int port) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void sendMessage() throws IOException {
        out.println("hello server");
        System.out.println(in.readLine());
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            if ("good bye".equals(inputLine)) {
                //out.println("good bye");
                break;
            } else if (inputLine.startsWith("Welcome")) {
                System.out.println(inputLine);
                out.println("thanks");
            } else {
                System.out.println(inputLine);
                out.println(reader.readLine());
            }
        }
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        System.out.println("connection is closed");
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.startConnection("127.0.0.1", 80);
        client.sendMessage();
        client.stopConnection();
    }
}
