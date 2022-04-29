package com.tutosoftware.survey10.view;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



import com.tutosoftware.survey10.dao.EncuestaDAO;
import com.tutosoftware.survey10.entity.RegistrarEncuesta;

@ManagedBean
@SessionScoped
public class GenerarEncuestaView {
	
	
	private RegistrarEncuesta registrarEncuesta;
    private String nombreEncuesta;
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
	
	
	
	
	public String getNombreEncuesta() {
		return nombreEncuesta;
	}

	public void setNombreEncuesta(String nombreEncuesta) {
		this.nombreEncuesta = nombreEncuesta;
	}

	public String getPregunta1SiNo() {
		return pregunta1SiNo;
	}

	public void setPregunta1SiNo(String pregunta1SiNo) {
		this.pregunta1SiNo = pregunta1SiNo;
	}

	public String getPregunta2SiNo() {
		return pregunta2SiNo;
	}

	public void setPregunta2SiNo(String pregunta2SiNo) {
		this.pregunta2SiNo = pregunta2SiNo;
	}

	public String getPregunta3SiNo() {
		return pregunta3SiNo;
	}

	public void setPregunta3SiNo(String pregunta3SiNo) {
		this.pregunta3SiNo = pregunta3SiNo;
	}

	public String getPregunta4SiNo() {
		return pregunta4SiNo;
	}

	public void setPregunta4SiNo(String pregunta4SiNo) {
		this.pregunta4SiNo = pregunta4SiNo;
	}

	public String getPregunta5SiNo() {
		return pregunta5SiNo;
	}

	public void setPregunta5SiNo(String pregunta5SiNo) {
		this.pregunta5SiNo = pregunta5SiNo;
	}

	public String getPregunta6SiNo() {
		return pregunta6SiNo;
	}

	public void setPregunta6SiNo(String pregunta6SiNo) {
		this.pregunta6SiNo = pregunta6SiNo;
	}

	public String getPregunta7SiNo() {
		return pregunta7SiNo;
	}

	public void setPregunta7SiNo(String pregunta7SiNo) {
		this.pregunta7SiNo = pregunta7SiNo;
	}

	public String getPregunta8Texto() {
		return pregunta8Texto;
	}

	public void setPregunta8Texto(String pregunta8Texto) {
		this.pregunta8Texto = pregunta8Texto;
	}

	public String getPregunta9Calif() {
		return pregunta9Calif;
	}

	public void setPregunta9Calif(String pregunta9Calif) {
		this.pregunta9Calif = pregunta9Calif;
	}

	public String getPregunta10Calif() {
		return pregunta10Calif;
	}

	public void setPregunta10Calif(String pregunta10Calif) {
		this.pregunta10Calif = pregunta10Calif;
	}

	public RegistrarEncuesta getRegistrarEncuesta() {
		return registrarEncuesta;
	}

	public void setRegistrarEncuesta(RegistrarEncuesta registrarEncuesta) {
		this.registrarEncuesta = registrarEncuesta;
	}
	

	
	
	public void crearEncuesta() {
		boolean activarEncuesta;
		EncuestaDAO encuestaDAO =new EncuestaDAO();
		
		activarEncuesta=encuestaDAO.comprobarEncuestaActiva();
		
		
		
		System.out.println("Hay encuestas activadas: "+activarEncuesta);
		
		if(!activarEncuesta) {
			int activo=1;
			String tablaEncuesta = uuid();
			
			
			System.out.println("Agregar encuesta");
			
			
			RegistrarEncuesta re= new RegistrarEncuesta();
			re.setNombreEncuesta(nombreEncuesta);
			re.setTablaEncuesta(tablaEncuesta);
			re.setPregunta1SiNo(pregunta1SiNo);
			re.setPregunta2SiNo(pregunta2SiNo);
			re.setPregunta3SiNo(pregunta3SiNo);
			re.setPregunta4SiNo(pregunta4SiNo);
			re.setPregunta5SiNo(pregunta5SiNo);
			re.setPregunta6SiNo(pregunta6SiNo);
			re.setPregunta7SiNo(pregunta7SiNo);
			re.setPregunta8Texto(pregunta8Texto);
			re.setPregunta9Calif(pregunta9Calif);
			re.setPregunta10Calif(pregunta10Calif);
			re.setActivarEncuesta(activo);
			
			encuestaDAO.crearEncuesta(re);
			limpiarEncuesta();
			
		}else {
			System.out.println("desactivar encuesta");
			encuestaDAO.desactivarEncuesta();
			int activo=1;
			String tablaEncuesta = uuid();
			
			
			System.out.println("Agregar encuesta");
			
			
			RegistrarEncuesta re= new RegistrarEncuesta();
			re.setNombreEncuesta(nombreEncuesta);
			re.setTablaEncuesta(tablaEncuesta);
			re.setPregunta1SiNo(pregunta1SiNo);
			re.setPregunta2SiNo(pregunta2SiNo);
			re.setPregunta3SiNo(pregunta3SiNo);
			re.setPregunta4SiNo(pregunta4SiNo);
			re.setPregunta5SiNo(pregunta5SiNo);
			re.setPregunta6SiNo(pregunta6SiNo);
			re.setPregunta7SiNo(pregunta7SiNo);
			re.setPregunta8Texto(pregunta8Texto);
			re.setPregunta9Calif(pregunta9Calif);
			re.setPregunta10Calif(pregunta10Calif);
			re.setActivarEncuesta(activo);
			
			encuestaDAO.crearEncuesta(re);
			limpiarEncuesta();
			
		}
		
		
		
	}
	
	public void limpiarEncuesta() {
		nombreEncuesta=" ";
		pregunta1SiNo=" ";
		pregunta2SiNo=" ";
		pregunta3SiNo=" ";
		pregunta4SiNo=" ";
		pregunta5SiNo=" ";
		pregunta6SiNo=" ";
		pregunta7SiNo=" ";
		pregunta8Texto=" ";
		pregunta9Calif=" ";
		pregunta10Calif=" ";
	}
	
	public String uuid() {
		
       Long numero = System.currentTimeMillis();
		
		String cadena=numero.toString();
		
		
		return cadena;
		
	}
	
	
	
	
}
