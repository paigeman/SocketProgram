package cn.edu.swjtu;

import cn.edu.swjtu.enity.Client;
import cn.edu.swjtu.enity.Server;
import cn.edu.swjtu.pane.IndexPane;
import cn.edu.swjtu.pane.ResultPane;
import cn.edu.swjtu.pane.UserNamePane;
import cn.edu.swjtu.pane.UserPwdPane;
import cn.edu.swjtu.utils.DBUtil;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Main extends Application {

    private IndexPane index;

    private Client client;

    private Server server;

    private UserNamePane name;

    private UserPwdPane pwd;

    private ResultPane result;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        index = new IndexPane();
        Scene scene = new Scene(index,300,125);
        index.getSubmit().setOnAction(e->{
            int port = Integer.parseInt(index.getTfPort().getText());
            new Thread(()->{
                if(server==null){
                    startServer(port);
                }
            }).start();
            new Thread(()->{
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                startClient(port,primaryStage);
            }).start();
            new Thread(()->{
//                System.out.println("enter");
                Platform.runLater(()->{
                    name = new UserNamePane();
                    primaryStage.setScene(new Scene(name,500,125));
                    primaryStage.show();
                });
            }).start();
//            name = new UserNamePane();
//            primaryStage.setScene(new Scene(name,500,125));
//            primaryStage.show();
        });
        primaryStage.setTitle("SocketProgram");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    void startServer(int port){
        Server server = new Server(port);
        System.out.println("start server");
        while(true){
            server.initial();
            DataInputStream in = server.getIn();
            DataOutputStream out = server.getOut();
            String username = null;
            try {
                username = in.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(username!=null){
                try {
                    out.writeUTF("receive");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String userpwd = null;
            try {
                userpwd = in.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            DBUtil dbUtil = new DBUtil();
            dbUtil.initializeDB();
            boolean flag = dbUtil.executeQuery(username,userpwd);
            if(flag){
                try {
                    out.writeUTF("login succeed");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                try {
                    out.writeUTF("login fail");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void startClient(int port,Stage primaryStage){
        Client client = new Client(index.getTfHost().getText(),port);
        DataInputStream in = client.getIn();
        DataOutputStream out = client.getOut();
        name.getSubmit().setOnAction(e->{
            String username = name.getTfName().getText();
            try {
                out.writeUTF(username);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                if(in.readUTF().equals("receive")){
                    Platform.runLater(()->{
                        pwd = new UserPwdPane();
                        primaryStage.setScene(new Scene(pwd,500,125));
                        primaryStage.show();
                    });
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Platform.runLater(()->{
                pwd.getSubmit().setOnAction(ex->{
                    String userpwd = pwd.getTfPwd().getText();
                    try {
                        out.writeUTF(userpwd);
                    } catch (IOException exc) {
                        exc.printStackTrace();
                    }
                    Platform.runLater(()->{
                        result = new ResultPane();
                        try {
                            result.getResult().setText(in.readUTF());
                        } catch (IOException exc) {
                            exc.printStackTrace();
                        }
                        primaryStage.setScene(new Scene(result,500,125));
                        primaryStage.show();
                    });
                });
            });
        });

    }

}
