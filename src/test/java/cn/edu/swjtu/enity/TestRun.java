package cn.edu.swjtu.enity;

import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * first run server()<br/>
 * then run client()
 * */
public class TestRun {

    @Test
    public void server(){
        Server server = new Server(8888);
        server.initial();
        DataInputStream in = server.getIn();
        DataOutputStream out = server.getOut();
        try {
            out.writeUTF("Server:connect succeed");
            String cts = in.readUTF();
            System.out.println(cts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void server1(){
        Server server = new Server(8888);
        while(true){
            server.initial();
            DataInputStream in = server.getIn();
            DataOutputStream out = server.getOut();
            try {
                out.writeUTF("Server:connect succeed");
            } catch (IOException e) {
                e.printStackTrace();
            }
//            while (true){
                String cts = null;
                try{
                    cts = in.readUTF();
                }catch (IOException e){
                    e.printStackTrace();
                }
                System.out.println(cts);
//            }
        }
    }

    @Test
    public void client(){
        Client client = new Client("127.0.0.1",8888);
        DataInputStream in = client.getIn();
        DataOutputStream out = client.getOut();
        try {
            String stc = in.readUTF();
            System.out.println(stc);
            out.writeUTF("client:copy that");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
