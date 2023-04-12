/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.callmanageapp;
import java.sql.*;

/**
 *
 * 
 */
public class Callmanageapp {

    public static void main(String[] args) {System.out.println("**************Welcome to Call Management App*************");
		System.out.println("-------------Below are the call summary----------------------");
		
		try
	    {
	      // create our mysql database connection
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://LAPTOP-16K1EL78:3306/call_manage";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "Aditi@7905780656");
	      
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT * FROM call_vw";
	      

	      // create the java statement
	      Statement st = conn.createStatement();
	      
	      // execute the query, and get a java resultset
	      ResultSet rs = st.executeQuery(query);
	      
	      // iterate through the java resultset
	      while (rs.next())
	      {
	        String call_vol_hour = rs.getString("call_vol_hour");
	        String call_duration_hour = rs.getString("call_duration_hour");
	        String call_vol_weekday = rs.getString("call_vol_weekday");
	        String call_duration_weekday = rs.getString("call_duration_weekday");

	        
	        
	        // print the results
	        System.out.format("Hour of the day when the call volume is highest : %s\n",call_vol_hour);
	        System.out.format("Hour of the day when the calls are longest : %s\n",call_duration_hour);
	        System.out.format("Day of the week when the call volume is highest : %s\n",call_vol_weekday);
	        System.out.format("Day of the week when the calls are longest : %s\n",call_duration_weekday);
	      }
	      st.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
        
    }
}
