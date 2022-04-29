package com.tutosoftware.survey10.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idUsuario;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String email;
	private String password;
	
	
	public Usuario() {}
	
	
	
	public Usuario(Integer idUsuario,String nombre,String apellidoPaterno,String apellidoMaterno,String email,
			String password) {
		
		this.idUsuario=idUsuario;
		this.nombre=nombre;
		this.apellidoPaterno=apellidoPaterno;
		this.apellidoMaterno=apellidoMaterno;
		this.email=email;
		this.password=password;
	}
	
	

}
