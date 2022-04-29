package com.tutosoftware.survey10.view;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.tutosoftware.survey10.dao.LoginDAO;
import com.tutosoftware.survey10.entity.Usuario;
import com.tutosoftware.survey10.util.SessionUtils;

@ManagedBean
@SessionScoped
public class LoginView {
	
	private String email;
	private String password;
	private Usuario usuario;
	private String userAdmin;
	private MenuModel model;
	
	


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
        DefaultSubMenu secondSubmenu = DefaultSubMenu.builder()
                .label("Dynamic Actions")
                .build();

        item = DefaultMenuItem.builder()
                .value("Save")
                .icon("pi pi-save")
                .command("#{encuestaView.save}")
                .update("messages")
                .build();
        secondSubmenu.getElements().add(item);

        item = DefaultMenuItem.builder()
                .value("Delete")
                .icon("pi pi-times")
                .command("#{encuestaView.delete}")
                .ajax(false)
                .build();
        secondSubmenu.getElements().add(item);

        item = DefaultMenuItem.builder()
                .value("Redirect")
                .icon("pi pi-search")
                .command("#{encuestaView.redirect}")
                .build();
        secondSubmenu.getElements().add(item);

        model.getElements().add(secondSubmenu);
    }

	
	
    public MenuModel getModel() {
        return model;
    }

    public void save() {
        addMessage("Success", "Data saved");
    }

    public void update() {
        addMessage("Success", "Data updated");
    }

    public void delete() {
        addMessage("Success", "Data deleted");
    }

	
	
	
	
	
	
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getUserAdmin() {
		return userAdmin;
	}
	public void setUserAdmin(String userAdmin) {
		this.userAdmin = userAdmin;
	}
	public String loginSurvey() {
		
	    LoginDAO loginDAO = new LoginDAO();
		
		usuario = loginDAO.obtenerUsuario(email);
		
		
		if(usuario == null) {
			
			addMessage("Success", "Usuario o pasword incorrectos");
			
			
			return "login";
			
		}
		
       if(usuario.getPassword().equals(password)) {
			
			
			HttpSession session = SessionUtils.getSession();
			userAdmin=usuario.getNombre()+" "+usuario.getApellidoPaterno()+" "+usuario.getApellidoMaterno();
			session.setAttribute("username",userAdmin);
			
			return "admin";
		}else {
			
			addMessage("Success", "Usuario o password incorrectos");
			
			return "login";
			
		}
		
		
		
		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	
	
	
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
}
	
	
	


