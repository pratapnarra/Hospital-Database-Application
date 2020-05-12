
package hospital_database;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;





 public class Hospital_Database extends JFrame implements ActionListener {
      
     String docname;
     appointmentframe af = new appointmentframe();
     PatientFrame     pf = new PatientFrame();
     DoctorFrame      df = new DoctorFrame();
     doc_enter de;
     
    JButton book = new   JButton("BOOK AN APPOINTMENT");
    JButton palog = new  JButton("  PATIENT    LOGIN             ");
    JButton doclog = new JButton("  DOCTOR     LOGIN            ");
    
   
    
    
    Hospital_Database(){
        
        
        JPanel f = new JPanel();
        JPanel p1 = new JPanel();
         p1.setBackground(Color.WHITE);
         p1.setBounds(200, 200, 100, 400);
        
         book.addActionListener(this);
        
         book.setBounds(200, 200, 100, 50);
         palog.addActionListener(this);
         
         palog.setBounds(200, 280, 100, 50);
         doclog.addActionListener(this);
         
         doclog.setBounds(200, 360, 100, 50);
        
          ImageIcon background=new ImageIcon("D:\\bk.jpeg"); //Change the location of Image
         Image img=background.getImage();
         Image temp=img.getScaledInstance(500,600,Image.SCALE_SMOOTH);
         background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
         back.setLayout(null);
       back.setBounds(0,0,500,600);
        f.add(back);
        
        p1.add(book);
        p1.add(palog);
        p1.add(doclog);
        
          
     this.add(back);
     this.add(p1);
      
         
         
      
     
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand() == "BOOK AN APPOINTMENT"){
            af.setSize(400,300);
            af.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            af.setLocationRelativeTo(null);
            af.setVisible(true);
        }
        
        else if(e.getActionCommand() == "  PATIENT    LOGIN             "){
            pf.setSize(400, 400);
            pf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pf.setLocationRelativeTo(null);
            pf.setVisible(true);
        }
        
        else if(e.getActionCommand() == "  DOCTOR     LOGIN            "){
            df.setSize(300, 400);
            df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            df.setLocationRelativeTo(null);
            df.setVisible(true);
        }
    }
    
    
    
   
    public static void main(String[] args) {
        Hospital_Database hd = new Hospital_Database();
        hd.setSize(500, 600);
        hd.setLocationRelativeTo(null);
        hd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hd.setVisible(true);
    }

    class appointmentframe extends JFrame implements ActionListener {
        
        String[] b = {"MG Road", "Mugalraj Puram" ,"SeethaRam Puram" , "Patamata" };
        String[] s = {"Cardiology" ,"ENT Specialist" ,"General Physician","Pediatrician" ,"Psychiatrist"  };
        
        JLabel name = new JLabel("Name :");
        JTextField namef = new JTextField(20);
        JLabel pno = new JLabel("Phone Number :");
        JTextField pnof = new JTextField(20);
        JLabel city = new JLabel("City :");
        JTextField cityf = new JTextField(20);
        JLabel branch = new JLabel("Branch :");
        JComboBox branchb = new JComboBox(b);
        JLabel spec = new JLabel("Specialization :");
        JComboBox specb = new JComboBox(s);
        JLabel date = new JLabel("Date :");
        JTextField datef = new JTextField("yyyy-mm-dd");
        
        JButton ok = new JButton("OK");
       
        appointmentframe(){
            JPanel p1 = new JPanel(); // creating a panel to add some components
     
        GroupLayout layout = new GroupLayout(p1); //creating a group layout for the panel
        p1.setLayout(layout); //setting the layout
        layout.setAutoCreateGaps(true);  //make sure to automatically fill gaps
        layout.setAutoCreateContainerGaps(true);
        
     layout.setHorizontalGroup(                                // grouping the components horizontally
             layout.createSequentialGroup()
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addComponent(name) .addComponent(pno) .addComponent(city)
             .addComponent(branch) .addComponent(spec) .addComponent(date) )
             
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addComponent(namef) .addComponent(pnof) .addComponent(cityf)
             .addComponent(branchb) .addComponent(specb) .addComponent(datef))
             
            
     );
     
     
     layout.setVerticalGroup(                            // grouping the components horizontally
         layout.createSequentialGroup()
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
             .addComponent(name) .addComponent(namef))
     
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
             .addComponent(pno) .addComponent(pnof))
             
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
             .addComponent(city) .addComponent(cityf))
             
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
             .addComponent(branch) .addComponent(branchb))
     
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
             .addComponent(spec) .addComponent(specb))
             
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
             .addComponent(date) .addComponent(datef))
             
     );
       
     ok.addActionListener(this);
     JPanel p2 = new JPanel();
     p2.add(ok);
     
     JPanel p3 = new JPanel();
     p3.add(p1);
     p3.add(p2);
     
     add(p3);
       
            
        }
        
        
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand() == "OK"){
           
            try{
                Class.forName("java.sql.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hos_database", "root" , "pratap");
                
                Statement st1 =   con.createStatement();
                Statement st2 = con.createStatement();
                Statement st3 = con.createStatement();
                Statement st4 = con.createStatement();
                
                String query1,query2,query3,query4;
                
                String na = namef.getText();
                BigInteger pho = new BigInteger(pnof.getText());
                String cy = cityf.getText();
                String da = datef.getText();
                String br = branchb.getSelectedItem().toString() ;
                String sp = String.valueOf(specb.getSelectedItem());
              
                  query2 = "insert into patient_new (p_n_name,pno,city,branch,specialization,appoint_date) values (  '"+na+"', "+ pho +", '" +cy+"', '"+br+"' ,'"+sp+"', '"+da+"' );";
                  
                  st2.executeUpdate(query2);
             query1 = "Select doc_name from doctor where branch =\"" + br +"\"and specialization= \"" + sp+"\";";
      
                   
               ResultSet rs = st1.executeQuery(query1);
               
               
               String d1 = null ,d2 = null;
               int i=0;
               
                while(rs.next()){
                    if(i==0){
                    d1 = rs.getString(1);
                   i=1;
                }
                    else
                      d2 = rs.getString(1);   
                }
                
                
              String ds =  JOptionPane.showInputDialog("Select your preffered doctor based on his/her timings. Enter 1 to select \"" +d1+ "\" timings - 9am to 1pm OR Enter 2 to select \""+d2+"\" timings - 5pm to 9pm"  );
                int dsi = Integer.parseInt(ds);
                
                if(dsi ==1 ){
                    query3 = "Update patient_new SET ref_doc = \"" +d1+"\"where pno = "+ pho +";";
                    st3.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null, "Your appointment with \"" + d1+ "\" is succesful :)) " );
                    af.setVisible(false);
                }
                else{
                    query3 = "Update patient_new SET ref_doc = \"" +d2+"\"where pno = "+ pho +";";
                    st3.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null, "Your appointment with \"" + d2+ "\" is succesful :)) " );
                     af.setVisible(false);
                }
                
                
                rs.close();
                st1.close();
                st2.close();
                st3.close();
                con.close();
                
                
              }
            catch(Exception ex){
                System.out.println("Enter Valid data" + ex);
            }
            
            
                  
        }
        
            
            
        }
    
    }
    
    
    
    
    class PatientFrame extends JFrame implements ActionListener{
        JLabel pname = new JLabel("Name :");
        JTextField pnamef = new JTextField("Enter your name",20);
         JLabel ppno = new JLabel("Phone Number :");
        JTextField ppnof = new JTextField("Enter your phoneno.",20);
        JButton plogin = new JButton("Login");
        
        PatientFrame(){
            plogin.addActionListener(this);
            
           pname.setBackground(Color.white);
            
            ImageIcon background=new ImageIcon("D:\\patient.jpg"); //Change the location of image
         Image img=background.getImage();
         Image temp=img.getScaledInstance(400,400,Image.SCALE_SMOOTH);
         background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
         back.setLayout(null);
       back.setBounds(0,0,400,400);
            
            JPanel p1 = new JPanel(); // creating a panel to add some components
     
        GroupLayout layout = new GroupLayout(p1); //creating a group layout for the panel
        p1.setLayout(layout); //setting the layout
        layout.setAutoCreateGaps(true);  //make sure to automatically fill gaps
        layout.setAutoCreateContainerGaps(true);
        
     layout.setHorizontalGroup(                                // grouping the components horizontally
             layout.createSequentialGroup()
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addComponent(pname) .addComponent(ppno)) 
             
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addComponent(pnamef) .addComponent(ppnof))            
            
              );
     
     
     layout.setVerticalGroup(                            // grouping the components horizontally
         layout.createSequentialGroup()
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
             .addComponent(pname) .addComponent(pnamef))
     
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
             .addComponent(ppno) .addComponent(ppnof))
             
     );
     
     JPanel p2 = new JPanel();
     p2.add(plogin);
     
     JPanel p3 = new JPanel();
     p3.add(p1);
     p3.add(p2);
     
     this.add(back);
     this.add(p3);
            
        }
        
        public void actionPerformed(ActionEvent e){
           
            if(e.getActionCommand()== "Login"){
                
                try{
                Class.forName("java.sql.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hos_database", "root" , "pratap");
                
                Statement st1 =   con.createStatement();
                 String query1;
                
                 
               BigInteger p = new BigInteger(ppnof.getText());
            String pn = pnamef.getText();
             query1 = "Select p_o_name from patient_old where pno = " + p + ";";
             ResultSet rs = st1.executeQuery(query1);
             
             
             
                System.out.println(pn);
               if(rs.next()){
                   System.out.println(rs.getString(1));
                   if(rs.getString(1).equals(pn) ){
                 patientrecords pr = new patientrecords(pn,p);                
                pr.setSize(1000,800);
                pr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
                pr.setVisible(true);
                System.out.println("a");
                   }
                  
               }
                else{
                       JOptionPane.showMessageDialog(null, "Enter Valid data");
                       
                   }
              
                 
                
             
                
                rs.close();
                st1.close();
                con.close();
              }
            catch(Exception ex){
                System.out.println("Enter Valid data" + ex);
            }
            
        
        
    }
        }
    }
    
    class patientrecords extends JFrame {
         JLabel[] pr1,pr2,pr3,pr4,pr5,pr6,pr7,pr8;
         
         
                
        JLabel pname1 = new JLabel("Patient Name");
        JLabel pno1 = new JLabel("Contact Number"); 
        JLabel medi = new JLabel("Medication");
        JLabel ph = new JLabel("Previous Records");
        JLabel sign = new JLabel("Signs and Symptoms");
        JLabel dn = new JLabel("Doctor Name");
        JLabel rdate = new JLabel("Record Date");
        JLabel comp = new JLabel("Compliant");
        int n;
        int flag =0;
        String query3;
        

       
        
        
        patientrecords(String s , BigInteger pnum){
           
            JLabel wel = new JLabel("WELCOME  "+ s  );
             wel.setBounds(300, 10, 200, 50);
             this.add(wel);
       JLabel buf = new JLabel(";");
             
        
       pname1.setBounds(5, 70,80 , 30);
       this.add(pname1);
       
       pno1.setBounds(95, 70, 120, 30);
       this.add(pno1);
       
       medi.setBounds(225, 70, 100, 30);
       this.add(medi);
       
       ph.setBounds(335, 70, 120, 30);
       this.add(ph);
       
       sign.setBounds(465, 70, 120, 30);
       this.add(sign);
       
       dn.setBounds(595, 70, 80, 30);
       this.add(dn);
       
       rdate.setBounds(695, 70, 120, 30);
       this.add(rdate);
       
       comp.setBounds(815, 70, 120, 30);
       this.add(comp);
       
       
            try{
                Class.forName("java.sql.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hos_database", "root" , "pratap");
                
                Statement st1 =   con.createStatement();
                Statement st2 = con.createStatement();
                Statement st3 = con.createStatement();
                String query1,query2;
                query2 = "Select * from patient_records where pname =\"" + s +"\" and pno = " + pnum + " ;" ;
                  
                  
                query1 = "Select count(*) from patient_records where pname =\"" + s +"\" and pno = " + pnum + " ;" ;
                System.out.println(docname);
               
                   
               ResultSet rs1 = st1.executeQuery(query1);              
               ResultSet rs2 = st2.executeQuery(query2);
               
               if(rs1.next())
               n = rs1.getInt(1);
               System.out.println(n);
               
              
              int y1 = 110; 
            pr1 = new JLabel[n];
            pr2 = new JLabel[n];
            pr3 = new JLabel[n];
            pr4 = new JLabel[n];
            pr5 = new JLabel[n];
            pr6 = new JLabel[n];
            pr7 = new JLabel[n];
            pr8 = new JLabel[n];
            
              int i=0;
              while(rs2.next()){
                  
                    pr1[i] = new JLabel(rs2.getString(1));
                    pr1[i].setBounds(5, y1, 80, 30);
                    this.add(pr1[i]);
                    
                    pr2[i] = new JLabel(rs2.getString(2));
                    pr2[i].setBounds(95, y1, 120, 30);
                    this.add(pr2[i]);
                    
                    pr3[i] = new JLabel(rs2.getString(3));
                    pr3[i].setBounds(225, y1, 100, 30);
                    this.add(pr3[i]);
                    
                    pr4[i] = new JLabel(rs2.getString(4));
                    pr4[i].setBounds(335, y1, 120, 30);
                    this.add(pr4[i]);
                    
                    pr5[i] = new JLabel(rs2.getString(5));
                    pr5[i].setBounds(465, y1, 120, 30);
                    this.add(pr5[i]);
                    
                    pr6[i] = new JLabel(rs2.getString(6));
                    pr6[i].setBounds(595, y1, 80, 30);
                    this.add(pr6[i]);
                    
                    pr7[i] = new JLabel(rs2.getString(7));
                    pr7[i].setBounds(695, y1, 120, 30);
                    this.add(pr7[i]);
                    
                    pr8[i] = new JLabel(rs2.getString(8));
                    pr8[i].setBounds(815, y1, 120, 30);
                    this.add(pr8[i]);
                    
                    
                   
                  
                 
                
                  
                  i++;
                  y1=y1+40;
              }
              
              
              
             this.add(buf);
                  
             
                rs1.close();
                rs2.close();
                st1.close();
                st2.close();
                st3.close();
                con.close();
              }
            
            
            catch(Exception ex){
                System.out.println("Enter Valid data" + ex);
            }
            
            
            
        }

        
    }
    
    
    class DoctorFrame extends JFrame implements ActionListener{
        JLabel did = new JLabel("ID :");
        JTextField didf = new JTextField("Enter your ID",20);
         JButton dlogin = new JButton("Login");
        
        DoctorFrame(){
            dlogin.addActionListener(this);
            
             ImageIcon background=new ImageIcon("D:\\Doctor.jpg");
         Image img=background.getImage();
         Image temp=img.getScaledInstance(300,400,Image.SCALE_SMOOTH);
         background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
         back.setLayout(null);
       back.setBounds(0,0,300,400);
            
            JPanel p1 = new JPanel(); // creating a panel to add some components
     
        GroupLayout layout = new GroupLayout(p1); //creating a group layout for the panel
        p1.setLayout(layout); //setting the layout
        layout.setAutoCreateGaps(true);  //make sure to automatically fill gaps
        layout.setAutoCreateContainerGaps(true);
        
     layout.setHorizontalGroup(                                // grouping the components horizontally
             layout.createSequentialGroup()
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addComponent(did) ) 
             
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addComponent(didf) )            
            );
     
     
     layout.setVerticalGroup(                            // grouping the components horizontally
         layout.createSequentialGroup()
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
             .addComponent(did) .addComponent(didf))
            );
     
     JPanel p2 = new JPanel();
     p2.add(dlogin);
     
     JPanel p3 = new JPanel();
     p3.add(p1);
     p3.add(p2);
     
     this.add(back);
     add(p3);
            
        }
        
        public void actionPerformed(ActionEvent e){
            if(e.getActionCommand()== "Login"){
                try{
                Class.forName("java.sql.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hos_database", "root" , "pratap");
                
                Statement st1 =   con.createStatement();
                 String query1;
                
                int id = Integer.parseInt(didf.getText());
             
             query1 = "Select doc_name from doctor where id = " + id + ";";
             ResultSet rs = st1.executeQuery(query1);
             
             if(rs.next()==true){
                docname = rs.getString(1);
                docsel ds = new docsel();
                ds.setSize(500,600);
                ds.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ds.setLocationRelativeTo(null);
                ds.setVisible(true);
             }
             else{
                 JOptionPane.showMessageDialog(null, "Please enter correct id");
             }
              
                
                
             
                
                rs.close();
                st1.close();
                con.close();
              }
            catch(Exception ex){
                System.out.println("Enter Valid data" + ex);
            }
                
                
                
            }
            
            
        }
        
    }
    
    class docsel extends JFrame implements ActionListener{
        JButton[] but , butc ;
        JLabel[] pna,pdat;
        JLabel pname1 = new JLabel("Patient Name");
        JLabel buf = new JLabel(";");
        int n;
        int flag =0;
        String query3;
        

        JPanel p1 = new JPanel();
        
        
        docsel(){
           
       
        p1.setLayout(null);
        
       pname1.setSize(100, 15);
        pname1.setLocation(20 ,05 );
        p1.add(pname1);
        
            try{
                Class.forName("java.sql.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hos_database", "root" , "pratap");
                
                Statement st1 =   con.createStatement();
                Statement st2 = con.createStatement();
                Statement st3 = con.createStatement();
                String query1,query2,query3;
                
                query3 = "Select appoint_date from patient_new where ref_doc =\"" + docname +"\"; ";
                query2 = "Select p_n_name from patient_new where ref_doc =\"" + docname +"\";" ;
                  
                  
                query1 = "Select count(*) from patient_new where ref_doc =\"" + docname +"\";";
                System.out.println(docname);
               
                
                   
               ResultSet rs1 = st1.executeQuery(query1);              
               ResultSet rs2 = st2.executeQuery(query2);
               ResultSet rs3 = st3.executeQuery(query3);
               
               if(rs1.next())
               n = rs1.getInt(1);
               System.out.println(n);
               
               
               if(n==0){
                    JLabel na = new JLabel("NO APPOINTMENTS");
                    na.setBounds(150, 100, 120, 30);
                    this.add(na);
                }
              
               JLabel we =new JLabel("Welcome DR. "+docname);
               we.setBounds(120, 10, 200, 30);
               this.add(we);
               
               JLabel nae = new JLabel("NAME");
               nae.setBounds(10, 50, 90, 30);
               this.add(nae);
               
               JLabel tr = new JLabel("TREATMENT");
               tr.setBounds(120, 50, 120, 30);
               this.add(tr);
               
               JLabel da = new JLabel("DATE");
               da.setBounds(300, 50, 120, 30);
               this.add(da);
               
              int y1 = 100; 
              
              
              
              JPanel p1 = new JPanel();
              
              but = new JButton[n];
              butc = new JButton[n];
              pna = new JLabel[n];
              pdat = new JLabel[n];
              int i=0;
              while(rs2.next()){
                 if( rs3.next())
                 {
                     pdat[i] = new JLabel(rs3.getString(1));
                System.out.println(rs3.getString(1));
                pdat[i].setBounds(300, y1, 120, 30);
                  
                  this.add(pdat[i]);
                 }
                   String pname = rs2.getString(1);
                  but[i] = new JButton("OK");
                 but[i].setBounds(120, y1, 60, 30);
                  
                  but[i].addActionListener(new ActionListener(){
                      public void actionPerformed(ActionEvent e ){
                          enter(pname);
                           de = new doc_enter(pname);
                          de.setSize(500,500);
                          de.setLocationRelativeTo(null);
                         de.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                          de.setVisible(true);
                      }
                  });
                  this.add(but[i]);
                  
                 
                  butc[i] = new JButton("cancel");
                  
                 butc[i].setBounds(200, y1, 80, 30);
                
                  butc[i].addActionListener(new ActionListener(){
                      public void actionPerformed(ActionEvent e ){            
                      
                          System.out.println("a");
                         flag =  delete(5,pname);
                         
                         if(flag==1){
                             JOptionPane.showMessageDialog(null, "Successfully deleted");
                         }
                    }
                  });
                  
                  
                  this.add(butc[i]);
                 pna[i] = new JLabel(rs2.getString(1));
                System.out.println(rs2.getString(1));
                pna[i].setBounds(10, y1, 90, 30);
                  
                  this.add(pna[i]);
                  
                  
                  i++;
                  y1=y1+30;
              }
              
              this.add(buf);
              
             
                  
             
                rs1.close();
                rs2.close();
                st1.close();
                st2.close();
                st3.close();
                con.close();
              }
            
            
            catch(Exception ex){
                System.out.println("Enter Valid data" + ex);
            }
            
            
            
        }
        
       public int delete(int f,String s){
           int j=0;
            try{
                Class.forName("java.sql.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hos_database", "root" , "pratap");
                
                Statement st1 =   con.createStatement();
                String query = "Delete from patient_new where p_n_name =\""+s+"\";";
                st1.executeUpdate(query);
                 j =1;
            }
            
             catch(Exception ex){
                System.out.println("Enter Valid data" + ex);
            }
            return j;
        }
       
       public void enter(String s){
           try{
                Class.forName("java.sql.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hos_database", "root" , "pratap");
                
                Statement st1 =   con.createStatement();
                Statement st2 = con.createStatement();
                Statement st3 = con.createStatement();
                 String query2 = "Delete from patient_new where p_n_name =\""+s+"\";";
                 String query = "insert into patient_old select * from patient_new where p_n_name =\""+s+"\";";
                
                String query3 = "Select p_o_name from patient_old where p_o_name =\""+s+"\"; ";
                ResultSet rs = st3.executeQuery(query3);
                rs.next();
              
                 st1.executeUpdate(query);
                 st2.executeUpdate(query2);
              
               
                
            }
            
             catch(Exception ex){
                System.out.println("Enter Valid data" + ex);
            }
           
           
       }

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

      
        
    }
    
    class doc_enter extends JFrame implements ActionListener{
       JLabel med = new JLabel("Medication :");
       JTextField medf = new JTextField();
       JLabel p_his = new JLabel("Previous Medical History :");
       JTextField p_hisf = new JTextField();
       JLabel ss = new JLabel("Signs and Symptoms :");
       JTextField ssf = new JTextField();
       JLabel com = new JLabel("Compliant :");
       JTextField comf = new JTextField();
       JLabel dat = new JLabel("Date");
       JTextField datf = new JTextField("yyyy-mm-dd");
       JButton ok1 = new JButton("OK");
       String patient;
       
       
       doc_enter(String p){
           
           patient = p;
           
           JPanel p1 = new JPanel(); // creating a panel to add some components
     
        GroupLayout layout = new GroupLayout(p1); //creating a group layout for the panel
        p1.setLayout(layout); //setting the layout
        layout.setAutoCreateGaps(true);  //make sure to automatically fill gaps
        layout.setAutoCreateContainerGaps(true);
        
     layout.setHorizontalGroup(                                // grouping the components horizontally
             layout.createSequentialGroup()
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addComponent(med) .addComponent(p_his) .addComponent(ss)
             .addComponent(com) .addComponent(dat)  )
             
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addComponent(medf) .addComponent(p_hisf) .addComponent(ssf)
             .addComponent(comf) .addComponent(datf) )
             
            
     );
     
     
     layout.setVerticalGroup(                            // grouping the components horizontally
         layout.createSequentialGroup()
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
             .addComponent(med) .addComponent(medf))
     
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
             .addComponent(p_his) .addComponent(p_hisf))
             
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
             .addComponent(ss) .addComponent(ssf))
             
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
             .addComponent(com) .addComponent(comf))
     
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
             .addComponent(dat) .addComponent(datf))
             
             
             
     );
     
     ok1.addActionListener(this);
     JPanel p2 = new JPanel();
     p2.add(ok1);
     
     JPanel p3 = new JPanel();
     p3.add(p1);
     p3.add(p2);
     
     add(p3);
     
       }
       
    
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand() == "OK"){
                try{
                Class.forName("java.sql.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hos_database", "root" , "pratap");
                
                Statement st1 = con.createStatement();
                Statement st2 = con.createStatement();
                
                
                String query2,query1;
                
                query1 = "Select pno from patient_old where p_o_name = \"" +patient+"\"and ref_doc =\""+ docname+"\" ;";
                ResultSet rs = st1.executeQuery(query1);
                
                rs.next();
                BigDecimal pno = rs.getBigDecimal(1);
                
                String me = medf.getText();
                String ph = p_hisf.getText();
                String s = ssf.getText();
                String d = datf.getText();
                String c = comf.getText();
               
              
                  query2 = "insert into patient_records  values (  '"+patient+"', " +pno + ", '"+ me +"', '" +ph+"', '"+s+"' , '"+docname+"' , '"+d+"' ,'"+c+"' );";
                  
                  st2.executeUpdate(query2);
            JOptionPane.showMessageDialog(null, "Entered Successfully");
            de.setVisible(false);
            
                st2.close();
                con.close();
              }
            catch(Exception ex){
                System.out.println("Enter Valid data" + ex);
            }
            }
        }
        
 } 
    
    
    
}
