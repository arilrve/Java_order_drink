import java.io.*;
import java.net.*;
public class Client extends Thread{

    
    private ClientFrame clientframe;

    private Socket s;
    private OutputStream ops;

    public Client(ClientFrame cfrm){
            this.setDaemon(true);
            clientframe=cfrm;
        }

    public void run() {
            try {
                s = new Socket("127.0.0.1",5300);
                ops = s.getOutputStream();
                } catch (Exception e) {
                    // JOptionPane.showMessageDialog(ClientFrame, e.toString(), "Error", 1);
            } 
        }
        public void sendMsg(String msg){
            if(s != null){
                try{
                    ops.write(msg.getBytes());
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
        }
    
}