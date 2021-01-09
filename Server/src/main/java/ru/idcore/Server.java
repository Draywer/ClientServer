package ru.idcore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;

    public void start(int port) throws IOException {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("server is started. new connection accepted");
            clientSocket = serverSocket.accept();
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            //System.out.println("Сервер запущен!" + serverSocket.toString());
            String greeting = in.readLine();
            if ("hello server".equals(greeting)) {
                out.println(String.format("hi client, your port is %d", clientSocket.getPort()));
            } else {
                out.println("unrecognised greeting");
            }
        } finally {
            stop();
        }

    }

    public void stop() throws IOException {
        serverSocket.close();
        clientSocket.close();
        in.close();
        out.close();
        System.out.println("Server is stopped");
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(80);
    }
}
