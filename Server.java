import java.io.*;
import java.net.*;
public class Server extends Thread{
        private serverframe sf;
        private Socket server;
    //SQL
    public Server(serverframe sfrm){
            this.setDaemon(true);
            sf=sfrm;
        }

    public  void run() {
            byte data[]=new byte[4096];
            
        try {
//Socket
                ServerSocket svs = new ServerSocket(5300);
                Socket server = svs.accept();
                System.out.println("success");
                BufferedInputStream Bufinp;
//SQL
            while(true){ 
                Bufinp = new BufferedInputStream(server.getInputStream());
                // int n = ips.read();
                int n = Bufinp.read(data);
                String str  = new String(data,0,n);
                // System.out.println(str);
                String[] menu=str.split(";");

                // System.out.println(menu[0]);

                String[] menu1;
                for(int i =0;i<menu.length;i++){
                        menu1=menu[i].split(",");
                        // System.out.println(menu1.length);
                        // System.out.println(menu1[i]);
                        
                        String str2 = new String("Date:"+menu1[0]+" , "+"Type:"+menu1[1]+" , "
                        +"Item:"+menu1[2]+" , "+"Ice:"+menu1[3]+" , "+"Sugar:"+menu1[4]+" , "
                        +"Mount:"+menu1[5]+" , "+"Price:"+menu1[6]);
                        // System.out.println(str2);
                        sf.appendmsg(new String(str2)+"\n------------------------------------------------------------------------------------------------\n");       
                    }
                }                    
            } catch (Exception e) {
                System.out.println("Error2");
            }
            
        }
    }
