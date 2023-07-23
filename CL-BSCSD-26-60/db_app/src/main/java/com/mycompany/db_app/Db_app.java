/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.db_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author nuwan.athukorala
 */
public class Db_app {
    
   static final String DB_URL = "jdbc:mysql://localhost:3307/icbt";
   static final String USER = "root";
   static final String PASS = "root";
   static final String QUERY = "SELECT * FROM students";


    public static void main(String[] args) {
        // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);
      ) {		      
         while(rs.next()){
            //Display values
            System.out.print("ID : " + rs.getInt("id"));
            System.out.print("Name : " + rs.getString("name"));
            System.out.print("Date of Birth : " + rs.getString("dob"));
            System.out.print("******************************************");
         }
      } catch (SQLException e) {
          System.out.print(e);
      } 
       
    }
}
