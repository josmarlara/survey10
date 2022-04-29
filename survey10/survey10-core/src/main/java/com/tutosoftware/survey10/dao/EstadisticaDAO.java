package com.tutosoftware.survey10.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tutosoftware.survey10.entity.Estadistica;
import com.tutosoftware.survey10.util.DBConection;

public class EstadisticaDAO {
	
	private DBConection connector;
    private Connection connection;
	
	
    public Estadistica mostrarEstadisticaEncuesta(String tabla) {
    	
    	Estadistica estadistica =new Estadistica();
    	String sql ="SELECT count(*)  from surveydb."+tabla;
    	String sql1="SELECT count(*)  from surveydb."+tabla+" where respuesta1sino='Si' ";
    	String sql2="SELECT count(*)  from surveydb."+tabla+" where respuesta1sino='No' ";
    	String sql3="SELECT count(*)  from surveydb."+tabla+" where respuesta2sino='Si' ";
    	String sql4="SELECT count(*)  from surveydb."+tabla+" where respuesta2sino='No' ";
    	String sql5="SELECT count(*)  from surveydb."+tabla+" where respuesta3sino='Si' ";
    	String sql6="SELECT count(*)  from surveydb."+tabla+" where respuesta3sino='No' ";
    	String sql7="SELECT count(*)  from surveydb."+tabla+" where respuesta4sino='Si' ";
    	String sql8="SELECT count(*)  from surveydb."+tabla+" where respuesta4sino='No' ";
    	String sql9="SELECT count(*)  from surveydb."+tabla+" where respuesta5sino='Si' ";
    	String sql10="SELECT count(*)  from surveydb."+tabla+" where respuesta5sino='No' ";
    	String sql11="SELECT count(*)  from surveydb."+tabla+" where respuesta6sino='Si' ";
    	String sql12="SELECT count(*)  from surveydb."+tabla+" where respuesta6sino='No' ";
    	String sql13="SELECT count(*)  from surveydb."+tabla+" where respuesta7sino='Si' ";
    	String sql14="SELECT count(*)  from surveydb."+tabla+" where respuesta7sino='No' ";
    	String sql15="SELECT count(*)  from surveydb."+tabla+" where respuesta9calif='malo' ";
    	String sql16="SELECT count(*)  from surveydb."+tabla+" where respuesta9calif='regular' ";
    	String sql17="SELECT count(*)  from surveydb."+tabla+" where respuesta9calif='bueno' ";
    	String sql18="SELECT count(*)  from surveydb."+tabla+" where respuesta9calif='muy bueno' ";
    	String sql19="SELECT count(*)  from surveydb."+tabla+" where respuesta9calif='excelente' ";
    	String sql20="SELECT count(*)  from surveydb."+tabla+" where respuesta10calif='malo' ";
    	String sql21="SELECT count(*)  from surveydb."+tabla+" where respuesta10calif='regular' ";
    	String sql22="SELECT count(*)  from surveydb."+tabla+" where respuesta10calif='bueno' ";
    	String sql23="SELECT count(*)  from surveydb."+tabla+" where respuesta10calif='muy bueno' ";
    	String sql24="SELECT count(*)  from surveydb."+tabla+" where respuesta10calif='excelente' ";
    	try {
    		Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()) {
            	estadistica.setTotalRespuesta(rs.getInt(1));
            }
            
            rs=st.executeQuery(sql1);
            
            if(rs.next()) {
            	estadistica.setRespuesta1Si(rs.getInt(1));
            }
            
            rs=st.executeQuery(sql2);
            if(rs.next()) {
            	estadistica.setRespuesta1No(rs.getInt(1));
            }
            
           
           rs=st.executeQuery(sql3);
            
            if(rs.next()) {
            	estadistica.setRespuesta2Si(rs.getInt(1));
            }
            
            
            rs=st.executeQuery(sql4);
            if(rs.next()) {
            	estadistica.setRespuesta2No(rs.getInt(1));
            }
            
           
            
             rs=st.executeQuery(sql5);
            
            if(rs.next()) {
            	estadistica.setRespuesta3Si(rs.getInt(1));
            }
            
            rs=st.executeQuery(sql6);
            if(rs.next()) {
            	estadistica.setRespuesta3No(rs.getInt(1));
            }
            
            rs=st.executeQuery(sql7);
            
            if(rs.next()) {
            	estadistica.setRespuesta4Si(rs.getInt(1));
            }
            
            rs=st.executeQuery(sql8);
            if(rs.next()) {
            	estadistica.setRespuesta4No(rs.getInt(1));
            }
            
           rs=st.executeQuery(sql9);
            
            if(rs.next()) {
            	estadistica.setRespuesta5Si(rs.getInt(1));
            }
            
            rs=st.executeQuery(sql10);
            if(rs.next()) {
            	estadistica.setRespuesta5No(rs.getInt(1));
            }
            
            rs=st.executeQuery(sql11);
            
            if(rs.next()) {
            	estadistica.setRespuesta6Si(rs.getInt(1));
            }
            
            rs=st.executeQuery(sql12);
            if(rs.next()) {
            	estadistica.setRespuesta6No(rs.getInt(1));
            }
            
            
            rs=st.executeQuery(sql13);
            
            if(rs.next()) {
            	estadistica.setRespuesta7Si(rs.getInt(1));
            }
            
            rs=st.executeQuery(sql14);
            if(rs.next()) {
            	estadistica.setRespuesta7No(rs.getInt(1));
            }
            
            rs=st.executeQuery(sql15);
            
            if(rs.next()) {
            	estadistica.setRespuest9Malo(rs.getInt(1));
            }
           
            rs=st.executeQuery(sql16);
            
            if(rs.next()) {
            	estadistica.setRespuesta9Regular(rs.getInt(1));
            }
            
            rs=st.executeQuery(sql17);
            
            if(rs.next()) {
            	estadistica.setRespuesta9Bueno(rs.getInt(1));
            }
             
            rs=st.executeQuery(sql18);
            
            if(rs.next()) {
            	estadistica.setRespuesta9MuyBueno(rs.getInt(1));
            }
            rs=st.executeQuery(sql19);
            
            if(rs.next()) {
            	estadistica.setRespuesta9Excelente(rs.getInt(1));
            }
            
            
            rs=st.executeQuery(sql20);
            
            if(rs.next()) {
            	estadistica.setRespuest10Malo(rs.getInt(1));
            }
           
            rs=st.executeQuery(sql21);
            
            if(rs.next()) {
            	estadistica.setRespuesta10Regular(rs.getInt(1));
            }
            
            rs=st.executeQuery(sql22);
            
            if(rs.next()) {
            	estadistica.setRespuesta10Bueno(rs.getInt(1));
            }
             
            rs=st.executeQuery(sql23);
            
            if(rs.next()) {
            	estadistica.setRespuesta10MuyBueno(rs.getInt(1));
            }
            rs=st.executeQuery(sql24);
            
            if(rs.next()) {
            	estadistica.setRespuesta10Excelente(rs.getInt(1));
            }
            
            
            st.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	
    	
    	
    	
    	
    	return estadistica;
    }
    
	public List<String> mostrarRespuestasAbiertas(String tabla){
		String sql ="SELECT respuesta8texto  from surveydb."+tabla;
		
		List<String> listaRespuestas= new ArrayList<>();
		
		try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
           
            while (rs.next()){
                
            	
             	
                listaRespuestas.add(rs.getString(1));   	
             	
             }
            
            
            
            
            
            st.close();
            rs.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	
		
		
		return listaRespuestas;
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
