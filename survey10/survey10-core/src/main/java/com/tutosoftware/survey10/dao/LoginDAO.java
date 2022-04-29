package com.tutosoftware.survey10.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tutosoftware.survey10.entity.Usuario;
import com.tutosoftware.survey10.util.DBConection;

public class LoginDAO {
	
	private DBConection connector;
    private Connection connection;
    
    
    public Usuario  obtenerUsuario(String email) {
    	
    	    Usuario userSurvey = new Usuario();
    	
    	try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuario where email='"+email+"'");
            while (rs.next()){
               
            	
               userSurvey.setIdUsuario(rs.getInt("idUsuario"));
               userSurvey.setNombre(rs.getString("nombre"));
               userSurvey.setApellidoPaterno(rs.getString("apellidoPaterno"));
               userSurvey.setApellidoMaterno(rs.getString("apellidoMaterno"));
               userSurvey.setEmail(rs.getString("email"));
               userSurvey.setPassword(rs.getString("password"));
            	
            	
            	
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	
    	
    	return userSurvey;
    }
    
    
    
    
    
    
    private DBConection getConnector() {
        if(this.connector == null)
            this.connector = new DBConection();
        return connector;
    }

    private Connection getConnection() {
        if(this.connection == null)
            this.connection = this.getConnector().connect();
        return connection;
    }

}
