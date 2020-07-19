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
public class ClientFrame extends JFrame{
        private Client  client = new Client(ClientFrame.this);
        private DB dbconn = new DB(ClientFrame.this);
        private Date dnow = new Date();
        private SimpleDateFormat ft = new SimpleDateFormat ("YYYY-MM-dd");
        private String today = new String(ft.format(dnow));
        private Font f = new Font("Utopia",Font.BOLD,24);
        private Font f1 = new Font("Utopia",Font.PLAIN,24);
        
//Object
        // private JCheckBox jcb = new JCheckBox();
        private Container cp;
    //Left-Panel
        private JPanel jpnL = new JPanel();
        private JPanel jpnField = new JPanel();
    //Object--->Left
        private String [] dataTitle = {"Date","Type","items","ICE","Sugar","mount","price"};
        private Object [][] data ;
    //Table-cannot-edit
        private DefaultTableModel Dftb = new DefaultTableModel(data,dataTitle){
            public boolean isCellEditable(int row, int column) { 
                return false; 
              }
        };
    //--------------------------------------th15 15 fuck1ng hard........-----//////
        private JTable jtb = new JTable(Dftb);
        private JScrollPane jpnChatarea = new JScrollPane(jtb);
        private JButton delete = new JButton("Delete");
        private JButton Cancel = new JButton("Cancel");
        private JButton Checkout = new JButton("Checkout");
    //Add Sub
        private JPanel addsub = new JPanel();
        private JButton Add = new JButton("+");
        private JButton Sub = new JButton("-");
    //Right-Panel
        private JPanel jpnR = new JPanel();
        private CardLayout cards = new CardLayout();

        private JPanel jpnDrinkMain = new JPanel();
        private JPanel jpntmp = new JPanel();
        private JPanel jpnDrinkS = new JPanel();//single tea
        private JPanel jpnDrinkM = new JPanel();//milk tea
        private JPanel jpnDrinkFM = new JPanel();//Freshmilk tea
        private JPanel jpnDrinkFrt = new JPanel();//fruit tea
        private JPanel jpnDrinkSmo = new JPanel();//smoothis
        private JPanel jpnDrinkH = new JPanel();//Hot tea
    //CardLayout Container
        private JPanel Container = new JPanel();
    
        private JPanel jpnIcSu = new JPanel();
        private JButton Main = new JButton("MainPage");
    //Drink-MainPage-btn--->Right
        private JButton St = new JButton("Single Tea");
        private JButton Mt = new JButton("Milk Tea");
        private JButton FMT = new JButton("Fresh milk tea");
        private JButton FT = new JButton("Fruit Tea");
        private JButton Smoothie  = new JButton("Smoothie");
        private JButton HT = new JButton("Hot Tea");
    //Drink-Single tea-btn--->Right
        private JButton  RT = new JButton("Red Tea");
        private JButton  GT = new JButton("Green Tea");
        private JButton  OT = new JButton("Oolong Tea");
        private JButton  LT = new JButton("light oolong tea");
        private JButton  WT = new JButton("white goup tea");
        //milk tea
        private JButton RM = new JButton("Red Milk Tea");
        private JButton GM = new JButton("Green Milk Tea");
        private JButton OM = new JButton("Oolong Milk Tea");
        private JButton LM = new JButton("Light Oolong Milk Tea");
        private JButton WM = new JButton("White goup Milk Tea");
        
        //fresh milk tea
        private JButton RFM = new JButton("Red Tea With Fresh Milk");
        private JButton GFM = new JButton("Green Tea With Fresh Milk");
        private JButton OFM = new JButton("Oolong Tea With Fresh Milk");
        private JButton LFM = new JButton("Light Oolong Tea With Fresh Milk");
        private JButton WFM = new JButton("White goup Tea With Fresh Milk");

        //fruit tea
        private JButton AT = new JButton("Apple Tea");
        private JButton PT = new JButton("Pineapple Tea");
        private JButton HLT = new JButton("Honey Lemon Tea");
        private JButton GTa = new JButton("Grape Tea");
        private JButton LTa = new JButton("Lichi Tea");

        //smoothie
        private JButton AS = new JButton("Apple Smoothie");
        private JButton PS = new JButton("Pineapple Smoothie");
        private JButton MS = new JButton("Mango Smoothie");
        private JButton SS = new JButton("Strawberry Smoothie");
        private JButton BS = new JButton("Banana Smoothie");

        //hot tea
        private JButton GMT = new JButton("Ginger Milk Tea");
        private JButton O = new JButton("Ovaltine");
        private JButton LJT = new JButton("Logan Jujube Tea");
        private JButton OGT = new JButton("Osmanthus Ginger Tea");
        private JButton HJJ = new JButton("Honey Ginger juice");
    //Sugar
        private JButton NS = new JButton("No Sugar");
        private JButton Lows = new JButton("Light sugar");
        private JButton HS = new JButton("Half Sugar");
        private JButton Less = new JButton("Less Sugar");
        private JButton Regs = new JButton("Regulr Sugar");
    //Ice
        private JButton NI = new JButton("No ICE");
        private JButton LowI = new JButton("Light ICE");
        private JButton HI = new JButton("Half ICE");
        private JButton LI = new JButton("Less ICE");
        private JButton RI = new JButton("Regulr ICE");
    //
        
        
    public static void main(String[] args){
        ClientFrame cf = new ClientFrame();
        cf.setVisible(true);
    }
//

    public ClientFrame(){
        init();
    }
    private void init(){
        client.start();
        dbconn.start();
        cp = this.getContentPane();
        this.setBounds(100, 100, 600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        cp.setLayout(new GridLayout(1,1));
    //Left
        cp.add(jpnL);
        // jtb.setEnabled(false);
        jtb.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//TablColumnModel-getModle
        TableColumnModel tbcm = jtb.getColumnModel();
//Set-id-column-width
        TableColumn id = tbcm.getColumn(1);
        id.setPreferredWidth(30);
//item-width
        TableColumn item = tbcm.getColumn(2);
        item.setPreferredWidth(70);
//
        // TableColumn  = tbcm.getColumn(2);
        // item.setPreferredWidth(70);
//mount-width
        TableColumn mount = tbcm.getColumn(5);
        mount.setPreferredWidth(20);
//price-width
        TableColumn pricecol = tbcm.getColumn(6);
        pricecol.setPreferredWidth(20);
// TableColumnModel 
        
        jtb.setRowSelectionAllowed(true);
    // Table
        // jtb.addMouseListener(new MouseAdapter(){
        //     public void mouseClicked(MouseEvent e){
        //         int selectRow = jtb.getSelectedRow();
        //         boolean check ;
        //         if(jtb.isRowSelected(selectRow)==true){
        //             check=true;
        //             if(check == true){              
        //                 jtb.clearSelection();
        //                 check = false;
        //             }
        //         }
        //     }
        // });
//
    
//
        jpnL.setLayout(new BorderLayout());
        jpnL.add(jpnChatarea,BorderLayout.CENTER);
        jpnL.add(jpnField,BorderLayout.SOUTH);
//Checkout,+,-
        jpnField.setLayout(new GridLayout(1,5));
        
        jpnField.add(Checkout);
        jpnField.add(addsub);
        addsub.setLayout(new GridLayout(2,1));
        addsub.add(Add);
        addsub.add(Sub);
        jpnField.add(Cancel);
        jpnField.add(delete);
    //Right
        cp.add(jpnR);
        jpnR.setLayout(new GridLayout(3,1,5,5));

        jpnR.add(jpnDrinkMain);
        jpnR.add(Container);
        jpnR.add(jpnIcSu);

    //Drink-MainPage
        jpnDrinkMain.setBackground(Color.BLACK);
        jpnDrinkMain.setLayout(new GridLayout(2,3,2,2));
        jpnDrinkMain.add(St);
        jpnDrinkMain.add(Mt);
        jpnDrinkMain.add(FMT);
        jpnDrinkMain.add(FT);
        jpnDrinkMain.add(Smoothie);
        jpnDrinkMain.add(HT);
    //Drink-Single Tea
        jpnDrinkS.setBackground(Color.BLUE);
        jpnDrinkS.setLayout(new GridLayout(2,3,2,2));
        jpnDrinkS.add(RT);
        jpnDrinkS.add(GT);
        jpnDrinkS.add(OT);
        jpnDrinkS.add(LT);
        jpnDrinkS.add(WT);
        jpnDrinkS.add(Main);
    //Drink-Milk Tea
        jpnDrinkM.setBackground(Color.BLUE);
        jpnDrinkM.setLayout(new GridLayout(2,3,2,2));
        jpnDrinkM.add(RM);
        jpnDrinkM.add(GM);
        jpnDrinkM.add(OM);
        jpnDrinkM.add(LM);
        jpnDrinkM.add(WM);
        jpnDrinkM.add(Main);
     //Drink-Fresh Milk Tea
        jpnDrinkFM.setBackground(Color.BLUE);
        jpnDrinkFM.setLayout(new GridLayout(2,3,2,2));
        jpnDrinkFM.add(RFM);
        jpnDrinkFM.add(GFM);
        jpnDrinkFM.add(OFM);
        jpnDrinkFM.add(LFM);
        jpnDrinkFM.add(WFM);
        jpnDrinkFM.add(Main);
    //Drink-Fruit Tea
        jpnDrinkFrt.setBackground(Color.BLUE);
        jpnDrinkFrt.setLayout(new GridLayout(2,3,2,2));

        jpnDrinkFrt.add(AT);
        jpnDrinkFrt.add(PT);
        jpnDrinkFrt.add(HLT);
        jpnDrinkFrt.add(GTa);
        jpnDrinkFrt.add(LTa);
        jpnDrinkFrt.add(Main);
    //Drink-Smoothie
        jpnDrinkSmo.setBackground(Color.BLUE);
        jpnDrinkSmo.setLayout(new GridLayout(2,3,2,2));
        jpnDrinkSmo.add(AS);
        jpnDrinkSmo.add(PS);
        jpnDrinkSmo.add(MS);
        jpnDrinkSmo.add(SS);
        jpnDrinkSmo.add(BS);
        jpnDrinkSmo.add(Main);
    //Drink-Hot tea
        jpnDrinkH.setBackground(Color.BLUE);
        jpnDrinkH.setLayout(new GridLayout(2,3,2,2));
        jpnDrinkH.add(GMT);
        jpnDrinkH.add(O);
        jpnDrinkH.add(LJT);
        jpnDrinkH.add(OGT);
        jpnDrinkH.add(HJJ);
        jpnDrinkH.add(Main);
     //Setting cards(CardsLayout),Container
        Container.setLayout(cards);    
        Container.add(jpntmp,"1");
        Container.add(jpnDrinkS,"2");
        Container.add(jpnDrinkM,"3");
        Container.add(jpnDrinkFM,"4");
        Container.add(jpnDrinkFrt,"5");
        Container.add(jpnDrinkSmo,"6");
        Container.add(jpnDrinkH,"7");
        //Button color - ice
        NS.setBackground(new Color(60,0,100));
        NS.setForeground(Color.GRAY);
        NS.setOpaque(true);
        Lows.setBackground(new Color(60,0,100));
        Lows.setForeground(Color.GRAY);
        Lows.setOpaque(true);
        HS.setBackground(new Color(60,0,100));
        HS.setForeground(Color.GRAY);
        HS.setOpaque(true);
        Less.setBackground(new Color(60,0,100));
        Less.setForeground(Color.GRAY);
        Less.setOpaque(true);
        Regs.setBackground(new Color(60,0,100));
        Regs.setForeground(Color.GRAY);
        Regs.setOpaque(true);
    //Button color - ice
        NI.setBackground(new Color(0,40,100));
        NI.setForeground(Color.GRAY);
        NI.setOpaque(true);
        LowI.setBackground(new Color(0,40,100));
        LowI.setForeground(Color.GRAY);
        LowI.setOpaque(true);
        HI.setBackground(new Color(0,40,100));
        HI.setForeground(Color.GRAY);
        HI.setOpaque(true);
        LI.setBackground(new Color(0,40,100));
        LI.setForeground(Color.GRAY);
        LI.setOpaque(true);
        RI.setBackground(new Color(0,40,100));
        RI.setForeground(Color.GRAY);
        RI.setOpaque(true);

//Cards-single
        St.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                cards.show(Container,"2");
                jpnDrinkS.setBackground(new Color(135,51,36));
                RT.setFont(f);
                RT.setForeground(new Color(135,51,36));
                GT.setFont(f);
                GT.setForeground(new Color(135,51,36));
                OT.setFont(f);
                OT.setForeground(new Color(135,51,36));
                LT.setFont(f);
                LT.setForeground(new Color(135,51,36));
                WT.setFont(f);
                WT.setForeground(new Color(135,51,36));
            }
        });
//
Mt.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ae){
        cards.show(Container,"3");
        jpnDrinkM.setBackground(new Color(210,105,30));
        RM.setFont(f);
        RM.setForeground(new Color(210,105,30));
        GM.setFont(f);
        GM.setForeground(new Color(210,105,30));
        OM.setFont(f);
        OM.setForeground(new Color(210,105,30));
        LM.setFont(f);
        LM.setForeground(new Color(210,105,30));
        WM.setFont(f);
        WM.setForeground(new Color(210,105,30));
    }
});
//
FMT.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ae){
        cards.show(Container,"4");
        jpnDrinkFM.setBackground(new Color(244,164,96));
        RFM.setFont(f);
        RFM.setForeground(new Color(244,164,96));
        GFM.setFont(f);
        GFM.setForeground(new Color(244,164,96));
        OFM.setFont(f);
        OFM.setForeground(new Color(244,164,96));
        LFM.setFont(f);
        LFM.setForeground(new Color(244,164,96));
        WFM.setFont(f);
        WFM.setForeground(new Color(244,164,96));
    }
});
//          
FT.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ae){
        cards.show(Container,"5");
        jpnDrinkFrt.setBackground(new Color(176,23,31));
        AT.setFont(f);
        AT.setForeground(new Color(176,23,31));
        PT.setFont(f);
        PT.setForeground(new Color(176,23,31));
        HLT.setFont(f);
        HLT.setForeground(new Color(176,23,31));
        GTa.setFont(f);
        GTa.setForeground(new Color(176,23,31));
        LTa.setFont(f);
        LTa.setForeground(new Color(176,23,31));
    }
});
//
Smoothie.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ae){
        cards.show(Container,"6");
        jpnDrinkSmo.setBackground(new Color(0,199,140));
        AS.setFont(f);
        AS.setForeground(new Color(0,199,140));
        PS.setFont(f);
        PS.setForeground(new Color(0,199,140));
        MS.setFont(f);
        MS.setForeground(new Color(0,199,140));
        SS.setFont(f);
        SS.setForeground(new Color(0,199,140));
        BS.setFont(f);
        BS.setForeground(new Color(0,199,140));
    }
});
//
HT.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ae){
        cards.show(Container,"7");
        jpnDrinkH.setBackground(new Color(255,69,0));
        GMT.setFont(f);
        GMT.setForeground(new Color(255,69,0));
        O.setFont(f);
        O.setForeground(new Color(255,69,0));
        LJT.setFont(f);
        LJT.setForeground(new Color(255,69,0));
        OGT.setFont(f);
        OGT.setForeground(new Color(255,69,0));
        HJJ.setFont(f);
        HJJ.setForeground(new Color(255,69,0));

    }
});
        Main.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                cards.show(Container,"1");
            }
        });
//Single tea button
        RT.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object Redtea[] = {today,"Single Tea","RedTea","","","1","25"};
                Dftb.addRow(Redtea);
            }
        });
        GT.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object Greentea[] = {today,"Single Tea","GreenTea","","","1","25"};
                Dftb.addRow(Greentea);
            }
        });

        OT.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object Oolongtea[] = {today,"Single Tea","OolongTea","","","1","25"};
                Dftb.addRow(Oolongtea);
            }
        });

        LT.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object LightOolongtea[] = {today,"Single Tea","LightOolongTea","","","1","25"};
                Dftb.addRow(LightOolongtea);
            }
        });
        
        WT.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object WhiteGouptea[] = {today,"Single Tea","WhiteGoupTea","","","1","25"};
                Dftb.addRow(WhiteGouptea);
            }
        });

//milk tea button
        RM.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object RedMilktea[] = {today,"Milk Tea","Red Milk Tea","","","1","25"};
                Dftb.addRow(RedMilktea);  
            }
        });

        GM.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object GreenMilktea[] = {today,"Milk Tea","Green Milk Tea","","","1","25"};
                Dftb.addRow(GreenMilktea);  
            }
        });

        OM.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object OolongMilktea[] = {today,"Milk Tea","Oolong Milk Tea","","","1","25"};
                Dftb.addRow(OolongMilktea);  
            }
        });

        LM.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object LightOolongMilktea[] = {today,"Milk Tea","Light Oolong Milk Tea","","","1","25"};
                Dftb.addRow(LightOolongMilktea);  
            }
        });

        WM.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object WhiteGoupMilktea[] = {today,"Milk Tea","White Goup Milk Tea","","","1","25"};
                Dftb.addRow(WhiteGoupMilktea);  
            }
        });

//fresh milk tea
        RFM.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object RedFreshMilktea[] = {today,"Fresh Milk Tea","Red Tea With Fresh Milk","","","1","25"};
                Dftb.addRow(RedFreshMilktea);  
            }
        });

        GFM.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object GreenFreshMilktea[] = {today,"Fresh Milk Tea","Green Tea With Fresh Milk","","","1","25"};
                Dftb.addRow(GreenFreshMilktea);  
            }
        });

        OFM.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object OolongFreshMilktea[] = {today,"Fresh Milk Tea","Oolong Tea With Fresh Milk","","","1","25"};
                Dftb.addRow(OolongFreshMilktea);  
            }
        });

        LFM.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object LightOolongFreshMilktea[] = {today,"Fresh Milk Tea","Light Oolong Tea With Fresh Milk","","","1","25"};
                Dftb.addRow(LightOolongFreshMilktea);  
            }
        });

        WFM.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object WhiteGoupFreshMilktea[] = {today,"Fresh Milk Tea","White Goup Tea With Fresh Milk","","","1","25"};
                Dftb.addRow(WhiteGoupFreshMilktea);  
            }
        });

//fruit tea
        AT.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object Appletea[] = {today,"Fruit Tea","Apple Tea","","","1","25"};
                Dftb.addRow(Appletea);  
            }
        });

        PT.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object Pineappletea[] = {today,"Fruit Tea","Pineapple Tea","","","1","25"};
                Dftb.addRow(Pineappletea);  
            }
        });

        HLT.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object HoneyLemontea[] = {today,"Fruit Tea","Honey Lemon Tea","","","1","25"};
                Dftb.addRow(HoneyLemontea);  
            }
        });

        GTa.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object Grapetea[] = {today,"Fruit Tea","Grape Tea","","","1","25"};
                Dftb.addRow(Grapetea);  
            }
        });

        LTa.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object Lichitea[] = {today,"Fruit Tea","Lichi Tea","","","1","25"};
                Dftb.addRow(Lichitea);  
            }
        });

//smoothie
        AS.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object Applesmoothie[] = {today,"Smoothie","Apple Smoothie","","","1","25"};
                Dftb.addRow(Applesmoothie);  
            }
        });

        PS.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object Pineapplesmoothie[] = {today,"Smoothie","Pineapple Smoothie","","","1","25"};
                Dftb.addRow(Pineapplesmoothie);  
            }
        });

        MS.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object Mangosmoothie[] = {today,"Smoothie","Mango Smoothie","","","1","25"};
                Dftb.addRow(Mangosmoothie);  
            }
        });

        SS.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object Strawberrysmoothie[] = {today,"Smoothie","Strawberry Smoothie","","","1","25"};
                Dftb.addRow(Strawberrysmoothie);  
            }
        });

        BS.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object Bananasmoothie[] = {today,"Smoothie","Banana Smoothie","","","1","25"};
                Dftb.addRow(Bananasmoothie);  
            }
        });

//hot tea
        GMT.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object GingerMilktea[] = {today,"Hot tea","Ginger Milk Tea","","","1","25"};
                Dftb.addRow(GingerMilktea);  
            }
        });

        O.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object Ovaltine[] = {today,"Hot tea","Ovaltine","","","1","25"};
                Dftb.addRow(Ovaltine);  
            }
        });

        LJT.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object LoganJujubetea[] = {today,"Hot tea","Logan Jujube Tea","","","1","25"};
                Dftb.addRow(LoganJujubetea);  
            }
        });

        OGT.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object OsmanthusGingertea[] = {today,"Hot tea","Osmanthus Ginger Tea","","","1","25"};
                Dftb.addRow(OsmanthusGingertea);  
            }
        });

        HJJ.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object Pineapplesmoothie[] = {today,"Hot tea","Pineapple Smoothie","","","1","25"};
                Dftb.addRow(Pineapplesmoothie);  
            }
        });
//Add-Item
        Add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            try {
                int selectRow = jtb.getSelectedRow();
            //mount
                Object seledrink = jtb.getValueAt(selectRow,5);
                int count = Integer.parseInt(seledrink.toString());
                count++;
                Object c =Integer.toString(count);
            //price
                Object pricetmp =jtb.getValueAt(selectRow,6);
                int price = Integer.parseInt(pricetmp.toString()); 
                int onepri = price/(count-1);
                int totalprice = onepri*count;
                Object objpri =Integer.toString(totalprice);
                jtb.setValueAt(c,selectRow,5);
                jtb.setValueAt(objpri, selectRow,6);
            } catch (Exception e) {
                    System.out.println("Error");
                }
            }
        });
//Sub-Item
        Sub.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                int selectRow = jtb.getSelectedRow();
                Object seledrink = jtb.getValueAt(selectRow,5);
                int count = Integer.parseInt(seledrink.toString());
                count--;
                if(count >0){
                    Object pricetmp =jtb.getValueAt(selectRow,6);
                    int price = Integer.parseInt(pricetmp.toString()); 
                    int onepri = price/(count+1);
                    // System.out.println(price);
                    int totalprice =price-onepri;
                    Object c = Integer.toString(count);
                    Object objpri =Integer.toString(totalprice);
                    jtb.setValueAt(c,selectRow,5);
                    jtb.setValueAt(objpri, selectRow,6);
                }else{
                    Object c = 1;
                    jtb.setValueAt(c,selectRow,6);
                    // jtb.setValueAt(1, selectRow,4);
                }
            }
        });

//Cancel-Item
        Cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    int selectRow = jtb.getSelectedRow();
                    if(jtb.isRowSelected(selectRow)==true){
                        jtb.clearSelection();
                    }
                } catch (Exception e) {
                    System.out.println("Error");
                }
                 
            }
        });
//Delete-Item
        delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    int selectRow = jtb.getSelectedRow();
                    Dftb.removeRow(selectRow);
                } catch (Exception e) {
                    System.out.println("Error");
                }
                
            }
        });        
    //ICE
        jpnIcSu.setLayout(new GridLayout(2,4));
        jpnIcSu.add(NS);
        jpnIcSu.add(Lows);
        jpnIcSu.add(HS);
        jpnIcSu.add(Less);
        jpnIcSu.add(Regs);
    //Sugar
        jpnIcSu.add(NI);
        jpnIcSu.add(LowI);
        jpnIcSu.add(HI);
        jpnIcSu.add(LI);
        jpnIcSu.add(RI);
//SUgar-Button
        NS.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    int selectRow = jtb.getSelectedRow();
                    if(jtb.isRowSelected(selectRow) == true){
                        jtb.setValueAt("No Sugar",selectRow,4);
                        }else{
                            int rcount = jtb.getRowCount();
                            jtb.setValueAt("No Sugar", rcount-1,4);
                        } 
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                }     
            });

            Lows.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    try {
                        int selectRow = jtb.getSelectedRow();
                        if(jtb.isRowSelected(selectRow) == true){
                            jtb.setValueAt("Low Sugar",selectRow,4);
                            }else{
                                int rcount = jtb.getRowCount();
                                jtb.setValueAt("Low Sugar", rcount-1,4);
                            } 
                        } catch (Exception e) {
                            System.out.println("Error");
                        }
                    }     
                });
    
            HS.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    try {
                        int selectRow = jtb.getSelectedRow();
                        if(jtb.isRowSelected(selectRow) == true){
                            jtb.setValueAt("Half Sugar",selectRow,4);
                            }else{
                                int rcount = jtb.getRowCount();
                                jtb.setValueAt("Half Sugar", rcount-1,4);
                            } 
                        } catch (Exception e) {
                            System.out.println("Error");
                        }
                    }     
                });
    
            Less.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    try {
                        int selectRow = jtb.getSelectedRow();
                        if(jtb.isRowSelected(selectRow) == true){
                            jtb.setValueAt("Less Sugar",selectRow,4);
                            }else{
                                int rcount = jtb.getRowCount();
                                jtb.setValueAt("Less Sugar", rcount-1,4);
                            } 
                        } catch (Exception e) {
                            System.out.println("Error");
                        }
                    }     
                });
    
            Regs.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    try {
                        int selectRow = jtb.getSelectedRow();
                        if(jtb.isRowSelected(selectRow) == true){
                            jtb.setValueAt("Regular Sugar",selectRow,4);
                            }else{
                                int rcount = jtb.getRowCount();
                                jtb.setValueAt("Regular Sugar", rcount-1,4);
                            } 
                        } catch (Exception e) {
                            System.out.println("Error");
                        }
                    }     
                });
//Ice
        NI.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    int selectRow = jtb.getSelectedRow();
                    if(jtb.isRowSelected(selectRow) == true){
                        jtb.setValueAt("No Ice",selectRow,3);
                        }else{
                            int rcount = jtb.getRowCount();
                            jtb.setValueAt("No Ice", rcount-1,3);
                        } 
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                }     
            });

        LowI.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    int selectRow = jtb.getSelectedRow();
                    if(jtb.isRowSelected(selectRow) == true){
                        jtb.setValueAt("Low Ice",selectRow,3);
                        }else{
                            int rcount = jtb.getRowCount();
                            jtb.setValueAt("Low Ice", rcount-1,3);
                        } 
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                }     
            });

        HI.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    int selectRow = jtb.getSelectedRow();
                    if(jtb.isRowSelected(selectRow) == true){
                        jtb.setValueAt("Half Ice",selectRow,3);
                        }else{
                            int rcount = jtb.getRowCount();
                            jtb.setValueAt("Half Ice", rcount-1,3);
                        } 
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                }     
            });

        LI.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    int selectRow = jtb.getSelectedRow();
                    if(jtb.isRowSelected(selectRow) == true){
                        jtb.setValueAt("Less Ice",selectRow,3);
                        }else{
                            int rcount = jtb.getRowCount();
                            jtb.setValueAt("Less Ice", rcount-1,3);
                        } 
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                }     
            });

        RI.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    int selectRow = jtb.getSelectedRow();
                    if(jtb.isRowSelected(selectRow) == true){
                        jtb.setValueAt("Regular Ice",selectRow,3);
                        }else{
                            int rcount = jtb.getRowCount();
                            jtb.setValueAt("Regular Ice", rcount-1,3);
                        } 
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                }     
            });
//checkout
            Checkout.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    
                    cards.show(Container,"1");
                //
                    int colall =jtb.getColumnCount();
                // System.out.println(colall);
                    int rowall = jtb.getRowCount();
                // System.out.println(rowall);
                    String table[][] = new String[rowall][colall];
                    String dbtable[][] = new String[rowall][colall];
                    for(int i =0;i<rowall;i++){
                        for(int j=0;j<colall;j++){
                            table[i][j] = (String)jtb.getValueAt(i,j);
                           System.out.print(table[i][j]+"\t");
                        }
                       System.out.println();
                    }
                //client-->Server
                    if(client != null){
                        for(int i = 0;i<rowall;i++){
                            String manu ="";
                            for(int j =0;j<colall;j++){
                                manu=manu+table[i][j]+",";
                            }
                            client.sendMsg(manu+";");   
                        } 
                    }
                //DB
                    if(dbconn != null){
                        for(int i = 0;i<rowall;i++){
                            String dbmanu ="";
                            for(int j =0;j<colall;j++){
                                dbmanu=dbmanu+table[i][j]+",";
                            }
                            dbconn.run(dbmanu);
                            System.out.println(dbmanu); 
                        }
                        
                    }
                    for(int i = 0;i<rowall;i++){
                        Dftb.removeRow(0);
                    }
                }
            });
//END
        }
    }



