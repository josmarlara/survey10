package com.tutosoftware.survey10.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tutosoftware.survey10.entity.Encuesta;
import com.tutosoftware.survey10.entity.RegistrarEncuesta;
import com.tutosoftware.survey10.util.DBConection;

public class EncuestaDAO {
	
	private DBConection connector;
    private Connection connection;
    
    
    public boolean comprobarEncuestaActiva(){
    	
    	String sql="Select * from registroencuesta where activarEncuesta=1";
    	boolean resultado=false;
    	
    	
    	
    	
    	
    	try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
           
            
            resultado=rs.first();
            
            
            
            
            st.close();
            rs.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	
    	
    	
    	return resultado;
    	
    }
    
    public void desactivarEncuesta() {
    	
    	try {
            Statement st = this.getConnection().createStatement();
            
            String sql="UPDATE registroencuesta SET activarEncuesta=0  ";           
                    sql+="WHERE  activarEncuesta=1 ";
            
            
            st.executeUpdate(sql);
            
            
           
            st.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	
    }
    
    public void crearEncuesta(RegistrarEncuesta re) {
    	
    	try {
            Statement st = this.getConnection().createStatement();
            
            String sql="INSERT INTO registroencuesta VALUES (null,'"+re.getNombreEncuesta()+"','"+re.getTablaEncuesta()+
            		"','"+re.getPregunta1SiNo()+"','"+re.getPregunta2SiNo()+"','";
            sql+=re.getPregunta3SiNo()+"','";
            sql+=re.getPregunta4SiNo()+"','";
            sql+=re.getPregunta5SiNo()+"','";
            sql+=re.getPregunta6SiNo()+"','";
            sql+=re.getPregunta7SiNo()+"','";
            sql+=re.getPregunta8Texto()+"','";
            sql+=re.getPregunta9Calif()+"','";
            sql+=re.getPregunta10Calif()+"',"+re.getActivarEncuesta()+")";
            
            st.execute(sql);
            
            String sqlt=" CREATE TABLE surveydb."+re.getTablaEncuesta()+"(";
                  sqlt+="idEncuesta INT NOT NULL AUTO_INCREMENT,";	
                  sqlt+="respuesta1sino VARCHAR(50) NOT NULL,";          
                  sqlt+="respuesta2sino VARCHAR(50) NOT NULL,";
                  sqlt+="respuesta3sino VARCHAR(50) NOT NULL,";
                  sqlt+="respuesta4sino VARCHAR(50) NOT NULL,";
                  sqlt+="respuesta5sino VARCHAR(50) NOT NULL,";
                  sqlt+="respuesta6sino VARCHAR(50) NOT NULL,";
                  sqlt+="respuesta7sino VARCHAR(50) NOT NULL,";
                  sqlt+="respuesta8texto VARCHAR(500) NOT NULL,";
                  sqlt+="respuesta9calif VARCHAR(50) NOT NULL,";
                  sqlt+="respuesta10calif VARCHAR(50) NOT NULL,";
            	  sqlt+="PRIMARY KEY (idEncuesta))";
                 
            	  
            	  
            st.executeUpdate(sqlt);
            
            
           
            st.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	
    	
    	
    	
    	
    }
    
    public void insertarEncuesta(Encuesta e) {
    	
    	
    	try {
            Statement st = this.getConnection().createStatement();
            
            String sql="INSERT INTO surveydb."+e.getNombreTabla()+" VALUES (null,'"+e.getRespuesta1SiNo()+"','"+e.getRespuesta2SiNo()+
            		"','"+e.getRespuesta3SiNo()+"','"+e.getRespuesta4SiNo()+"','";
            sql+=e.getRespuesta5SiNo()+"','";
            sql+=e.getRespuesta6SiNo()+"','";
            sql+=e.getRespuesta7SiNo()+"','";
            sql+=e.getRespuesta8Texto()+"','";
            sql+=e.getRespuesta9Calif()+"','";
            sql+=e.getRespuesta10Calif()+"')";
            
            
            st.executeUpdate(sql);
            
           
            
            
           
            st.close();
            
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    	
    	
    	
    	
    }
public  RegistrarEncuesta mostrarEncuesta(String tablaEncuesta) {
    	
    	String sql="Select * from registroencuesta where tablaEncuesta='"+tablaEncuesta+"'";
    	RegistrarEncuesta re = new RegistrarEncuesta();
    	
    	
    	
    	try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
           
            while (rs.next()){
                
            	
                re.setIdRegistroEncuesta(rs.getInt("idRegistroEncuesta"));
                re.setNombreEncuesta(rs.getString("nombreEncuesta"));
                re.setTablaEncuesta(rs.getString("tablaEncuesta"));
                re.setPregunta1SiNo(rs.getString("pregunta1sino"));
                re.setPregunta2SiNo(rs.getString("pregunta2sino"));
                re.setPregunta3SiNo(rs.getString("pregunta3sino"));
                re.setPregunta4SiNo(rs.getString("pregunta4sino"));
                re.setPregunta5SiNo(rs.getString("pregunta5sino"));
                re.setPregunta6SiNo(rs.getString("pregunta6sino"));
                re.setPregunta7SiNo(rs.getString("pregunta7sino"));
                re.setPregunta8Texto(rs.getString("pregunta8texto"));
                re.setPregunta9Calif(rs.getString("pregunta9calif"));
                re.setPregunta10Calif(rs.getString("pregunta10calif"));
                re.setActivarEncuesta(rs.getInt("activarEncuesta"));
             	
             	
             	
             }
            
            
            
            
            
            st.close();
            rs.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	
    	
    	
    	
    	
    	
    	return re;
    }
    
    public  RegistrarEncuesta mostrarEncuestaActiva() {
    	
    	String sql="Select * from registroencuesta where activarEncuesta=1";
    	RegistrarEncuesta re = new RegistrarEncuesta();
    	
    	
    	
    	try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
           
            while (rs.next()){
                
            	
                re.setIdRegistroEncuesta(rs.getInt("idRegistroEncuesta"));
                re.setNombreEncuesta(rs.getString("nombreEncuesta"));
                re.setTablaEncuesta(rs.getString("tablaEncuesta"));
                re.setPregunta1SiNo(rs.getString("pregunta1sino"));
                re.setPregunta2SiNo(rs.getString("pregunta2sino"));
                re.setPregunta3SiNo(rs.getString("pregunta3sino"));
                re.setPregunta4SiNo(rs.getString("pregunta4sino"));
                re.setPregunta5SiNo(rs.getString("pregunta5sino"));
                re.setPregunta6SiNo(rs.getString("pregunta6sino"));
                re.setPregunta7SiNo(rs.getString("pregunta7sino"));
                re.setPregunta8Texto(rs.getString("pregunta8texto"));
                re.setPregunta9Calif(rs.getString("pregunta9calif"));
                re.setPregunta10Calif(rs.getString("pregunta10calif"));
                re.setActivarEncuesta(rs.getInt("activarEncuesta"));
             	
             	
             	
             }
            
            
            
            
            
            st.close();
            rs.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	
    	
    	
    	
    	
    	
    	return re;
    }
    
    public List<RegistrarEncuesta> mostrarEncuestas(){
    	
    	String sql="Select * from registroencuesta";
    	
    	List<RegistrarEncuesta> listEncuesta= new ArrayList<RegistrarEncuesta>();
    	
    	try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
           
            while (rs.next()){
                
            	RegistrarEncuesta re = new RegistrarEncuesta();
                re.setIdRegistroEncuesta(rs.getInt("idRegistroEncuesta"));
                re.setNombreEncuesta(rs.getString("nombreEncuesta"));
                re.setTablaEncuesta(rs.getString("tablaEncuesta"));
                re.setPregunta1SiNo(rs.getString("pregunta1sino"));
                re.setPregunta2SiNo(rs.getString("pregunta2sino"));
                re.setPregunta3SiNo(rs.getString("pregunta3sino"));
                re.setPregunta4SiNo(rs.getString("pregunta4sino"));
                re.setPregunta5SiNo(rs.getString("pregunta5sino"));
                re.setPregunta6SiNo(rs.getString("pregunta6sino"));
                re.setPregunta7SiNo(rs.getString("pregunta7sino"));
                re.setPregunta8Texto(rs.getString("pregunta8texto"));
                re.setPregunta9Calif(rs.getString("pregunta9calif"));
                re.setPregunta10Calif(rs.getString("pregunta10calif"));
                re.setActivarEncuesta(rs.getInt("activarEncuesta"));
             	
                listEncuesta.add(re);    	
             	
             }
            
            
            
            
            
            st.close();
            rs.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	
    	
    	
    	
    	return listEncuesta;
    	
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
