package com.tutosoftware.survey10.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.tutosoftware.survey10.dao.EncuestaDAO;
import com.tutosoftware.survey10.entity.Encuesta;
import com.tutosoftware.survey10.entity.RegistrarEncuesta;

@ManagedBean
@SessionScoped
public class EncuestaView {
	
	
	private MenuModel model;
	private RegistrarEncuesta re;
	private String respuesta1SiNo;
	private String respuesta2SiNo;
	private String respuesta3SiNo;
	private String respuesta4SiNo;
	private String respuesta5SiNo;
	private String respuesta6SiNo;
	private String respuesta7SiNo;
	private String respuesta8Texto;
	private String respuesta9Calif;
	private String respuesta10Calif;
	
	
	

    public String getRespuesta1SiNo() {
		return respuesta1SiNo;
	}

	public void setRespuesta1SiNo(String respuesta1SiNo) {
		this.respuesta1SiNo = respuesta1SiNo;
	}

	public String getRespuesta2SiNo() {
		return respuesta2SiNo;
	}

	public void setRespuesta2SiNo(String respuesta2SiNo) {
		this.respuesta2SiNo = respuesta2SiNo;
	}

	public String getRespuesta3SiNo() {
		return respuesta3SiNo;
	}

	public void setRespuesta3SiNo(String respuesta3SiNo) {
		this.respuesta3SiNo = respuesta3SiNo;
	}

	public String getRespuesta4SiNo() {
		return respuesta4SiNo;
	}

	public void setRespuesta4SiNo(String respuesta4SiNo) {
		this.respuesta4SiNo = respuesta4SiNo;
	}

	public String getRespuesta5SiNo() {
		return respuesta5SiNo;
	}

	public void setRespuesta5SiNo(String respuesta5SiNo) {
		this.respuesta5SiNo = respuesta5SiNo;
	}

	public String getRespuesta6SiNo() {
		return respuesta6SiNo;
	}

	public void setRespuesta6SiNo(String respuesta6SiNo) {
		this.respuesta6SiNo = respuesta6SiNo;
	}

	public String getRespuesta7SiNo() {
		return respuesta7SiNo;
	}

	public void setRespuesta7SiNo(String respuesta7SiNo) {
		this.respuesta7SiNo = respuesta7SiNo;
	}

	public String getRespuesta8Texto() {
		return respuesta8Texto;
	}

	public void setRespuesta8Texto(String respuesta8Texto) {
		this.respuesta8Texto = respuesta8Texto;
	}

	public String getRespuesta9Calif() {
		return respuesta9Calif;
	}

	public void setRespuesta9Calif(String respuesta9Calif) {
		this.respuesta9Calif = respuesta9Calif;
	}

	public String getRespuesta10Calif() {
		return respuesta10Calif;
	}

	public void setRespuesta10Calif(String respuesta10Calif) {
		this.respuesta10Calif = respuesta10Calif;
	}

	public RegistrarEncuesta getRe() {
		return re;
	}

	public void setRe(RegistrarEncuesta re) {
		this.re = re;
	}

	@PostConstruct
    public void init() {
        model = new DefaultMenuModel();

        //First submenu
        DefaultSubMenu firstSubmenu = DefaultSubMenu.builder()
                .label("Dynamic Submenu")
                .build();

        DefaultMenuItem item = DefaultMenuItem.builder()
                .value("External")
                .url("http://www.primefaces.org")
                .icon("pi pi-home")
                .build();
        firstSubmenu.getElements().add(item);

        model.getElements().add(firstSubmenu);

        //Second submenu
       
        
       EncuestaDAO encuestaDAO = new EncuestaDAO(); 
        
       re = encuestaDAO.mostrarEncuestaActiva();  
        
        
        
        
        
        
        
    }

    public MenuModel getModel() {
        return model;
    }
    
    
    public void insertarEncuesta() {
    	
    	EncuestaDAO encuestaDAO = new EncuestaDAO();
    	Encuesta e = new Encuesta();
    	
    	e.setNombreTabla(re.getTablaEncuesta());
    	e.setRespuesta1SiNo(respuesta1SiNo);
    	e.setRespuesta2SiNo(respuesta2SiNo);
    	e.setRespuesta3SiNo(respuesta3SiNo);
    	e.setRespuesta4SiNo(respuesta4SiNo);
    	e.setRespuesta5SiNo(respuesta5SiNo);
    	e.setRespuesta6SiNo(respuesta6SiNo);
    	e.setRespuesta7SiNo(respuesta7SiNo);
    	e.setRespuesta8Texto(respuesta8Texto);
    	e.setRespuesta9Calif(respuesta9Calif);
    	e.setRespuesta10Calif(respuesta10Calif);
    	
    	
    	encuestaDAO.insertarEncuesta(e);
    	
    	limpiarFormulario();
    	
    	
    	
    }
    
    public void limpiarFormulario() {
    	
    	respuesta1SiNo=" ";
    	respuesta2SiNo=" ";
    	respuesta3SiNo=" ";
    	respuesta4SiNo=" ";
    	respuesta5SiNo=" ";
    	respuesta6SiNo=" ";
    	respuesta7SiNo=" ";
    	respuesta8Texto=" ";
    	respuesta9Calif=" ";
    	respuesta10Calif=" ";
    	
    }
    
    
    
    
    
    

}
