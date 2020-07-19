import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.lang.ProcessBuilder.Redirect.Type;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.*;

public class serverSQL extends Thread{
        static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        static final String DB_URL= "jdbc:mysql://210.70.80.21:3306/s107021039";

        static final String UID = "s107021039";
        static final String PWD = "Xoofo3ab";
        private serverframe sfr;
        // Date dnow = new Date();
        // SimpleDateFormat ft = new SimpleDateFormat ("YYYY-MM-dd");
        // String today = new String(ft.format(dnow));
    public serverSQL(serverframe sfrm){
        this.setDaemon(true);
         sfr = sfrm;
    }
     public void run(String infor){
         Connection conn = null;
         Statement stmt = null ;
         try {
            

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, UID, PWD);
            stmt = conn.createStatement();
            
            String selectST = "SELECT Item, SUM(Mount) FROM DrinkMenu WHERE Date ='"+infor+"' GROUP BY Item";
            // String selectMT = "SELECT Date,Type,Mount FROM DrinkMenu WHERE Date ='"+infor+"' AND Type = 'Milk Tea'";
            // String selectFMT = "SELECT Date,Type,Mount FROM DrinkMenu WHERE Date ='"+infor+"' AND Type = 'Fresh Milk Tea'";
            ResultSet rs = stmt.executeQuery(selectST);

             while(rs.next()){
                    // String Type = rs.getString("Type");
                    // String Type = rs.getString("Type");
                    // int Mount = rs.getInt("Mount");
                        sfr.appendInfo("品項:"+rs.getString(1)+"數量:"+rs.getString(2));
                        // System.out.println("品項:"+rs.getString(1)+"數量:"+rs.getString(2));
                }
                    rs.close();
                    stmt.close();
                    conn.close();

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
