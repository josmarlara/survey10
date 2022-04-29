package com.tutosoftware.survey10.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class RegistrarEncuesta {
		
	private int idRegistroEncuesta;
	private String nombreEncuesta;
	private String tablaEncuesta;
	private String pregunta1SiNo;
	private String pregunta2SiNo;
	private String pregunta3SiNo;
	private String pregunta4SiNo;
	private String pregunta5SiNo;
	private String pregunta6SiNo;
	private String pregunta7SiNo;
	private String pregunta8Texto;
	private String pregunta9Calif;
	private String pregunta10Calif;
	private int activarEncuesta;

}
