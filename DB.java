import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.*;

public class DB extends Thread{
        static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        static final String DB_URL= "jdbc:mysql://210.70.80.21:3306/s107021039";

        static final String UID = "s107021039";
        static final String PWD = "Xoofo3ab";
        private ClientFrame clientframedb;
        // Date dnow = new Date();
        // SimpleDateFormat ft = new SimpleDateFormat ("MM-dd");
        // String today = new String(ft.format(dnow));
    public DB(ClientFrame cfrm2){
        this.setDaemon(true);
        clientframedb = cfrm2;
    }
     public void run(String infor){
         Connection conn = null;
         Statement stmt = null ;
         try {
            

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, UID, PWD);
            stmt = conn.createStatement();
            // System.out.println(create);//
            
            String menu[]=infor.split(",");
            // String str = "INSERT INTO `DrinkMenu`(ID,Items,Mount,Price)" +
            // "VALUES ("+menu[0]+","+menu[1]+","+menu[2]+","+menu[3]+menu[4]+")";
            // System.out.println(str);
            String sql = "INSERT INTO `DrinkMenu` VALUES('"+menu[0]+"','"+menu[1]+"','"+menu[2]+"','"+menu[3]+"','"+menu[4]+"','"+menu[5]+"',"+menu[6]+")";
            System.out.println(sql);
            stmt.executeUpdate(sql);

            } catch (SQLException se) {
                se.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                try{
                    if (stmt != null)
                    stmt.close();
                }catch(SQLException se2){
                }
                    try {
                        if(conn != null)
                        conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } 
        }
     }
//END
}
