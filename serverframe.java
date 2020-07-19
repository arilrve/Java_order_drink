import java.awt.*;
import java.awt.CardLayout;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.sql.*;
import java.text.*;
import java.util.Date;

public class serverframe extends JFrame{
    private Server server = new Server(serverframe.this);
    private serverSQL sersql = new serverSQL(serverframe.this);
    private Container cp;
    private JTextArea jta = new JTextArea();
    private JScrollPane jscp = new JScrollPane(jta);

    private JPanel jpnr = new JPanel();
    private JPanel jpnN = new JPanel();
    private JTextField Date = new JTextField("YYYY-MM-DD");
    // private JPanel jpnbut = new JPanel();
    private JButton analysis = new JButton("Analysis");
    private JButton clear = new JButton("Clear");
    // private JButton search = new JButton("Search");
    private JTextArea jta2 = new JTextArea();

        
        
    public static void main(String[] args){
        serverframe sf = new serverframe();
        sf.setVisible(true);
    }

    public serverframe(){
        init();
    }
    private void init(){
        server.start();
        cp=this.getContentPane();
        this.setBounds(100, 100, 700, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        cp.setLayout(new GridLayout(1,1));
        jta.setEditable(false);
        cp.add(jscp);
        cp.add(jpnr);
        jpnr.setLayout(new BorderLayout());
        jpnr.add(jta2,BorderLayout.CENTER);
        jpnr.add(jpnN,BorderLayout.NORTH);
        jpnr.add(clear,BorderLayout.SOUTH);
        jpnN.setLayout(new BorderLayout());
        jpnN.add(Date,BorderLayout.CENTER);
        jpnN.add(analysis,BorderLayout.EAST);

        analysis.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               String str =  Date.getText();
                sersql.run(str);
                
            }
        });

        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               jta2.setText("");
            }
        });

    }
    public void appendmsg(String msg){
            jta.append(msg+"\n");
    }
    public void appendInfo(String info){
        jta2.append(info+"\n");
    }
//END
}


