package com.tutosoftware.survey10.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.tutosoftware.survey10.entity.RegistrarEncuesta;



import com.tutosoftware.survey10.dao.EncuestaDAO;

@ManagedBean
@SessionScoped
public class HistorialEncuestaView {
	
	
	private List<RegistrarEncuesta> listaEncuesta = new ArrayList<RegistrarEncuesta>();
	
	
	public List<RegistrarEncuesta> getListaEncuesta() {
		return listaEncuesta;
	}


	public void setListaEncuesta(List<RegistrarEncuesta> listaEncuesta) {
		this.listaEncuesta = listaEncuesta;
	}


	@PostConstruct
    public void init() {
		
		
		EncuestaDAO encuestaDAO = new EncuestaDAO();
		
		listaEncuesta = encuestaDAO.mostrarEncuestas();
	}
	
	
	

}
