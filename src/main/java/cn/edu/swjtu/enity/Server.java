package cn.edu.swjtu.enity;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket server;

    private int port;

    private DataInputStream in;

    private DataOutputStream out;

    private Socket client;

    public Server(int port){
        this.port = port;
//        try {
//            server = new ServerSocket(port);
//            client = server.accept();
//            in = new DataInputStream(client.getInputStream());
//            out = new DataOutputStream(client.getOutputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initial(){
        try {
            this.client = server.accept();
            this.in = new DataInputStream(client.getInputStream());
            this.out = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DataInputStream getIn() {
        return in;
    }

    public void setIn(DataInputStream in) {
        this.in = in;
    }

    public DataOutputStream getOut() {
        return out;
    }

    public void setOut(DataOutputStream out) {
        this.out = out;
    }

    public Socket getClient() {
        return client;
    }

    public void setClient(Socket client) {
        this.client = client;
    }
}
