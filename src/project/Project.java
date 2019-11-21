/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.sql.*;
/**
 *
 * @author Mark
 */
public class Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        People p = new People("me",0);
        People p1 = new People("me",1);
        People p2 = new People("me",2);
        People p3 = new People("me1",0);
        People p4 = new People("me1",1);
        People p5 = new People("me1",2);
        People p6 = new People("me2",0);
        People p7 = new People("me2",1);
        People p8 = new People("me2",2);
        
        
        list list1= new list();
        
        
        list1.insertData(new People("med",1));

        list1.insertData(new People("me11",1)); 
        list1.insertData(new People("med",1));

        list1.insertData(new People("me11",1)); 
        list1.insertData(new People("med",1));

        list1.insertData(new People("me11",1)); 
        list1.insertData(new People("mez",2));
        list1.insertData(new People("mex",2));
        list1.insertData(new People("mez",2));
        list1.insertData(new People("mex",2));
        list1.insertData(new People("me22",0)); 
        list1.insertData(new People("mez",2));
        list1.insertData(new People("mex",2));
        list1.insertData(new People("med",1));

        
        list1.insertData(new People("me11",1)); 
        list1.insertData(new People("me22",0)); 
        list1.insertData(new People("me14",0)); 
        list1.insertData(new People("me23",0)); 
        

  
        list1.insertData(new People("mez",2));
        list1.insertData(new People("mex",2));

        
        list1.insertData(p);    
        list1.insertData(p1);
        list1.insertData(p2);
        list1.insertData(p3);
        list1.insertData(p4);
        list1.insertData(p5);
        list1.insertData(p6);
        list1.insertData(p7);
        list1.insertData(new People("mec",2));
        
        
        System.out.println("");
        System.out.println("---------------");
        
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String user = "root";
        String pass = "";

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", user, pass);

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query

              myRs = myStmt.executeQuery("insert into people values(1,'a','a','a','a',0)");
            
            // 4. Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
        
    }
    
}
