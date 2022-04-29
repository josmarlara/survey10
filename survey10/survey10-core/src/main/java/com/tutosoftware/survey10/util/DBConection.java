package com.tutosoftware.survey10.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConection {
	
	public Connection connect() {
        Connection connection = null;
        try {
            Class.forName ("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/surveydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=America/Mexico_City&verifyServerCertificate=false&allowPublicKeyRetrieval=true&useSSL=false&requireSSL=false","root","lara");
            System.out.println ("Database connection established");
        } catch (SQLException   e) {
            System.out.println(e.getMessage());
        }catch(ClassNotFoundException e) {
        	System.out.println(e.getMessage());
        }catch(InstantiationException e) {
        	System.out.println(e.getMessage());
        }catch(IllegalAccessException e) {
        	System.out.println(e.getMessage());
        }
        
        return connection;
    }

}
