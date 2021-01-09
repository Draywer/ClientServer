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
    private User user;

    public void start(int port) throws IOException {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("server is started. new connection accepted");
            clientSocket = serverSocket.accept();
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            //ждем подключения клиента
            String greeting = in.readLine();
            if ("hello server".equals(greeting)) {
                out.println("hi client!");
            } else {
                out.println("unrecognised greeting");
            }

            //регистрация пользователя
            if(registerUser()) {
                System.out.println("new user: " + user + " is registered");
            }
            System.out.println("client answer: " + in.readLine());


            //диалог с клиентом: тест получения сервером сообщений от клиента
            out.println("let's test connection! input your message or end to exit");

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if ("end".equals(inputLine)) {
                    out.println("good bye");
                    break;
                }
                out.println("server answer: your message is: " + inputLine);
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
        System.out.println("server is stopped");
    }


    public boolean registerUser() throws IOException {
        boolean result = false;
        try{
            out.println("what is your name?");
            String name = in.readLine();
            out.println("are you child?(yes/no)");
            boolean adult = !in.readLine().equals("yes");

            user = new User(name, adult, clientSocket.getRemoteSocketAddress().toString(), clientSocket.getPort());

            if (!user.isAdult()) {
                out.println(String.format("Welcome to the kids area, %s! Let's play! ", user.getName()));
            } else {
                out.println(String.format("Welcome to the adult area, %s! Let's play! ", user.getName()));
            }
            result  = true;
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(80);
    }


}
