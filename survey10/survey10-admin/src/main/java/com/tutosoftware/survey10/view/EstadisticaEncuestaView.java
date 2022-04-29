package com.tutosoftware.survey10.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.charts.bar.*;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.animation.Animation;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.primefaces.model.charts.optionconfig.title.Title;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;

import com.tutosoftware.survey10.dao.EncuestaDAO;
import com.tutosoftware.survey10.dao.EstadisticaDAO;
import com.tutosoftware.survey10.entity.Estadistica;
import com.tutosoftware.survey10.entity.RegistrarEncuesta;

@ManagedBean
@SessionScoped
public class EstadisticaEncuestaView {

	private RegistrarEncuesta re;
	private Estadistica estadistica;
	private List<String> listaRespuestas = new ArrayList<>();
	private PieChartModel pieModel1;
	private PieChartModel pieModel2;
	private PieChartModel pieModel3;
	private PieChartModel pieModel4;
	private PieChartModel pieModel5;
	private PieChartModel pieModel6;
	private PieChartModel pieModel7;
	private BarChartModel barModel;
	private BarChartModel barModel2;
	
	public RegistrarEncuesta getRe() {
		return re;
	}



	public void setRe(RegistrarEncuesta re) {
		this.re = re;
	}



	public Estadistica getEstadistica() {
		return estadistica;
	}



	public void setEstadistica(Estadistica estadistica) {
		this.estadistica = estadistica;
	}



	



	public List<String> getListaRespuestas() {
		return listaRespuestas;
	}



	public void setListaRespuestas(List<String> listaRespuestas) {
		this.listaRespuestas = listaRespuestas;
	}



	public PieChartModel getPieModel1() {
		return pieModel1;
	}



	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}



	public PieChartModel getPieModel2() {
		return pieModel2;
	}



	public void setPieModel2(PieChartModel pieModel2) {
		this.pieModel2 = pieModel2;
	}



	public PieChartModel getPieModel3() {
		return pieModel3;
	}



	public void setPieModel3(PieChartModel pieModel3) {
		this.pieModel3 = pieModel3;
	}



	public PieChartModel getPieModel4() {
		return pieModel4;
	}



	public void setPieModel4(PieChartModel pieModel4) {
		this.pieModel4 = pieModel4;
	}



	public PieChartModel getPieModel5() {
		return pieModel5;
	}



	public void setPieModel5(PieChartModel pieModel5) {
		this.pieModel5 = pieModel5;
	}



	public PieChartModel getPieModel6() {
		return pieModel6;
	}



	public void setPieModel6(PieChartModel pieModel6) {
		this.pieModel6 = pieModel6;
	}



	public PieChartModel getPieModel7() {
		return pieModel7;
	}



	public void setPieModel7(PieChartModel pieModel7) {
		this.pieModel7 = pieModel7;
	}



	public BarChartModel getBarModel() {
		return barModel;
	}



	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}



	public BarChartModel getBarModel2() {
		return barModel2;
	}



	public void setBarModel2(BarChartModel barModel2) {
		this.barModel2 = barModel2;
	}



	public String mostrarEstadisticoEncuesta(String tabla){
		EncuestaDAO encuestaDAO = new EncuestaDAO();
		EstadisticaDAO estadisticaDAO = new EstadisticaDAO();
		
		
		re=encuestaDAO.mostrarEncuesta(tabla);
		estadistica=estadisticaDAO.mostrarEstadisticaEncuesta(tabla);
		createPieModelRespuesta1(estadistica.getRespuesta1Si(),estadistica.getRespuesta1No());
		createPieModelRespuesta2(estadistica.getRespuesta2Si(),estadistica.getRespuesta2No());
		createPieModelRespuesta3(estadistica.getRespuesta3Si(),estadistica.getRespuesta3No());
		createPieModelRespuesta4(estadistica.getRespuesta4Si(),estadistica.getRespuesta4No());
		createPieModelRespuesta5(estadistica.getRespuesta5Si(),estadistica.getRespuesta5No());
		createPieModelRespuesta6(estadistica.getRespuesta6Si(),estadistica.getRespuesta6No());
		createPieModelRespuesta7(estadistica.getRespuesta7Si(),estadistica.getRespuesta7No());
		createBarModelRespuesta9(estadistica.getRespuest9Malo(),estadistica.getRespuesta9Regular(),
				estadistica.getRespuesta9Bueno(),estadistica.getRespuesta9MuyBueno(),
				estadistica.getRespuesta9Excelente(),re.getPregunta9Calif());
		
		createBarModelRespuesta10(estadistica.getRespuest10Malo(),estadistica.getRespuesta10Regular(),
				estadistica.getRespuesta10Bueno(),estadistica.getRespuesta10MuyBueno(),
				estadistica.getRespuesta10Excelente(),re.getPregunta10Calif());
		
		
		return "grafico";
	}
	
	
	
	
	public String mostrarRespuestaAbiertas(String tabla){
		EncuestaDAO encuestaDAO = new EncuestaDAO();
		EstadisticaDAO estadisticaDAO = new EstadisticaDAO();
		
		
		re=encuestaDAO.mostrarEncuesta(tabla);
		
		listaRespuestas=estadisticaDAO.mostrarRespuestasAbiertas(tabla);
		
		
		
		
		return "texto";
	}
	
	
	
	
	
     public  void createPieModelRespuesta1(int si,int no) {
		
		pieModel1 = new PieChartModel();
        ChartData data = new ChartData();
        
        PieChartDataSet dataSet = new PieChartDataSet();
        List<Number> values = new ArrayList<>();
        values.add(si);
        values.add(no);
        dataSet.setData(values);
        
        
        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(255, 99, 132)");
        bgColors.add("rgb(54, 162, 235)");
        dataSet.setBackgroundColor(bgColors);
        
        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Si");
        labels.add("No");
        
        
        data.setLabels(labels);

        pieModel1.setData(data);
        
		
	 }
     public  void createPieModelRespuesta2(int si,int no) {
 		
 		pieModel2 = new PieChartModel();
         ChartData data = new ChartData();
         
         PieChartDataSet dataSet = new PieChartDataSet();
         List<Number> values = new ArrayList<>();
         values.add(si);
         values.add(no);
         dataSet.setData(values);
         
         
         List<String> bgColors = new ArrayList<>();
         bgColors.add("rgb(255, 99, 132)");
         bgColors.add("rgb(54, 162, 235)");
         dataSet.setBackgroundColor(bgColors);
         
         data.addChartDataSet(dataSet);
         List<String> labels = new ArrayList<>();
         labels.add("Si");
         labels.add("No");
         
         
         data.setLabels(labels);

         pieModel2.setData(data);
         
 		
 	 }
     public  void createPieModelRespuesta3(int si,int no) {
 		
 		pieModel3 = new PieChartModel();
         ChartData data = new ChartData();
         
         PieChartDataSet dataSet = new PieChartDataSet();
         List<Number> values = new ArrayList<>();
         values.add(si);
         values.add(no);
         dataSet.setData(values);
         
         
         List<String> bgColors = new ArrayList<>();
         bgColors.add("rgb(255, 99, 132)");
         bgColors.add("rgb(54, 162, 235)");
         dataSet.setBackgroundColor(bgColors);
         
         data.addChartDataSet(dataSet);
         List<String> labels = new ArrayList<>();
         labels.add("Si");
         labels.add("No");
         
         
         data.setLabels(labels);

         pieModel3.setData(data);
         
 		
 	 }
     public  void createPieModelRespuesta4(int si,int no) {
 		
 		pieModel4 = new PieChartModel();
         ChartData data = new ChartData();
         
         PieChartDataSet dataSet = new PieChartDataSet();
         List<Number> values = new ArrayList<>();
         values.add(si);
         values.add(no);
         dataSet.setData(values);
         
         
         List<String> bgColors = new ArrayList<>();
         bgColors.add("rgb(255, 99, 132)");
         bgColors.add("rgb(54, 162, 235)");
         dataSet.setBackgroundColor(bgColors);
         
         data.addChartDataSet(dataSet);
         List<String> labels = new ArrayList<>();
         labels.add("Si");
         labels.add("No");
         
         
         data.setLabels(labels);

         pieModel4.setData(data);
         
 		
 	 }
     public  void createPieModelRespuesta5(int si,int no) {
 		
 		pieModel5 = new PieChartModel();
         ChartData data = new ChartData();
         
         PieChartDataSet dataSet = new PieChartDataSet();
         List<Number> values = new ArrayList<>();
         values.add(si);
         values.add(no);
         dataSet.setData(values);
         
         
         List<String> bgColors = new ArrayList<>();
         bgColors.add("rgb(255, 99, 132)");
         bgColors.add("rgb(54, 162, 235)");
         dataSet.setBackgroundColor(bgColors);
         
         data.addChartDataSet(dataSet);
         List<String> labels = new ArrayList<>();
         labels.add("Si");
         labels.add("No");
         
         
         data.setLabels(labels);

         pieModel5.setData(data);
         
 		
 	 }
     public  void createPieModelRespuesta6(int si,int no) {
 		
 		pieModel6 = new PieChartModel();
         ChartData data = new ChartData();
         
         PieChartDataSet dataSet = new PieChartDataSet();
         List<Number> values = new ArrayList<>();
         values.add(si);
         values.add(no);
         dataSet.setData(values);
         
         
         List<String> bgColors = new ArrayList<>();
         bgColors.add("rgb(255, 99, 132)");
         bgColors.add("rgb(54, 162, 235)");
         dataSet.setBackgroundColor(bgColors);
         
         data.addChartDataSet(dataSet);
         List<String> labels = new ArrayList<>();
         labels.add("Si");
         labels.add("No");
         
         
         data.setLabels(labels);

         pieModel6.setData(data);
         
 		
 	 }
     public  void createPieModelRespuesta7(int si,int no) {
 		
 		pieModel7 = new PieChartModel();
         ChartData data = new ChartData();
         
         PieChartDataSet dataSet = new PieChartDataSet();
         List<Number> values = new ArrayList<>();
         values.add(si);
         values.add(no);
         dataSet.setData(values);
         
         
         List<String> bgColors = new ArrayList<>();
         bgColors.add("rgb(255, 99, 132)");
         bgColors.add("rgb(54, 162, 235)");
         dataSet.setBackgroundColor(bgColors);
         
         data.addChartDataSet(dataSet);
         List<String> labels = new ArrayList<>();
         labels.add("Si");
         labels.add("No");
         
         
         data.setLabels(labels);

         pieModel7.setData(data);
         
 		
 	 }
     
     
     public void createBarModelRespuesta9(int malo,int regular,int bueno,int muyBueno,int excelente,String pregunta) {
         barModel = new BarChartModel();
         ChartData data = new ChartData();

         BarChartDataSet barDataSet = new BarChartDataSet();
         barDataSet.setLabel("Survey 10");

         List<Number> values = new ArrayList<>();
         values.add(malo);
         values.add(regular);
         values.add(bueno);
         values.add(muyBueno);
         values.add(excelente);
         barDataSet.setData(values);

         List<String> bgColor = new ArrayList<>();
         bgColor.add("rgba(255, 99, 132, 0.2)");
         bgColor.add("rgba(255, 159, 64, 0.2)");
         bgColor.add("rgba(255, 205, 86, 0.2)");
         bgColor.add("rgba(75, 192, 192, 0.2)");
         bgColor.add("rgba(54, 162, 235, 0.2)");
         barDataSet.setBackgroundColor(bgColor);

         List<String> borderColor = new ArrayList<>();
         borderColor.add("rgb(255, 99, 132)");
         borderColor.add("rgb(255, 159, 64)");
         borderColor.add("rgb(255, 205, 86)");
         borderColor.add("rgb(75, 192, 192)");
         borderColor.add("rgb(54, 162, 235)");
         barDataSet.setBorderColor(borderColor);
         barDataSet.setBorderWidth(1);

         data.addChartDataSet(barDataSet);

         List<String> labels = new ArrayList<>();
         labels.add("Malo");
         labels.add("Regular");
         labels.add("Bueno");
         labels.add("Muy Bueno");
         labels.add("Excelente");
         
         data.setLabels(labels);
         barModel.setData(data);

         //Options
         BarChartOptions options = new BarChartOptions();
         CartesianScales cScales = new CartesianScales();
         CartesianLinearAxes linearAxes = new CartesianLinearAxes();
         linearAxes.setOffset(true);
         CartesianLinearTicks ticks = new CartesianLinearTicks();
         ticks.setBeginAtZero(true);
         linearAxes.setTicks(ticks);
         cScales.addYAxesData(linearAxes);
         options.setScales(cScales);

         Title title = new Title();
         title.setDisplay(true);
         title.setText(pregunta);
         options.setTitle(title);

         Legend legend = new Legend();
         legend.setDisplay(true);
         legend.setPosition("top");
         LegendLabel legendLabels = new LegendLabel();
         legendLabels.setFontStyle("bold");
         legendLabels.setFontColor("#2980B9");
         legendLabels.setFontSize(24);
         legend.setLabels(legendLabels);
         options.setLegend(legend);

         // disable animation
         Animation animation = new Animation();
         animation.setDuration(0);
         options.setAnimation(animation);

         barModel.setOptions(options);
     }

     
     public void createBarModelRespuesta10(int malo,int regular,int bueno,int muyBueno,int excelente,String pregunta) {
         barModel2 = new BarChartModel();
         ChartData data = new ChartData();

         BarChartDataSet barDataSet = new BarChartDataSet();
         barDataSet.setLabel("Survey 10");

         List<Number> values = new ArrayList<>();
         values.add(malo);
         values.add(regular);
         values.add(bueno);
         values.add(muyBueno);
         values.add(excelente);
         barDataSet.setData(values);

         List<String> bgColor = new ArrayList<>();
         bgColor.add("rgba(255, 99, 132, 0.2)");
         bgColor.add("rgba(255, 159, 64, 0.2)");
         bgColor.add("rgba(255, 205, 86, 0.2)");
         bgColor.add("rgba(75, 192, 192, 0.2)");
         bgColor.add("rgba(54, 162, 235, 0.2)");
         barDataSet.setBackgroundColor(bgColor);

         List<String> borderColor = new ArrayList<>();
         borderColor.add("rgb(255, 99, 132)");
         borderColor.add("rgb(255, 159, 64)");
         borderColor.add("rgb(255, 205, 86)");
         borderColor.add("rgb(75, 192, 192)");
         borderColor.add("rgb(54, 162, 235)");
         barDataSet.setBorderColor(borderColor);
         barDataSet.setBorderWidth(1);

         data.addChartDataSet(barDataSet);

         List<String> labels = new ArrayList<>();
         labels.add("Malo");
         labels.add("Regular");
         labels.add("Bueno");
         labels.add("Muy Bueno");
         labels.add("Excelente");
         
         data.setLabels(labels);
         barModel2.setData(data);

         //Options
         BarChartOptions options = new BarChartOptions();
         CartesianScales cScales = new CartesianScales();
         CartesianLinearAxes linearAxes = new CartesianLinearAxes();
         linearAxes.setOffset(true);
         CartesianLinearTicks ticks = new CartesianLinearTicks();
         ticks.setBeginAtZero(true);
         linearAxes.setTicks(ticks);
         cScales.addYAxesData(linearAxes);
         options.setScales(cScales);

         Title title = new Title();
         title.setDisplay(true);
         title.setText(pregunta);
         options.setTitle(title);

         Legend legend = new Legend();
         legend.setDisplay(true);
         legend.setPosition("top");
         LegendLabel legendLabels = new LegendLabel();
         legendLabels.setFontStyle("bold");
         legendLabels.setFontColor("#2980B9");
         legendLabels.setFontSize(24);
         legend.setLabels(legendLabels);
         options.setLegend(legend);

         // disable animation
         Animation animation = new Animation();
         animation.setDuration(0);
         options.setAnimation(animation);

         barModel2.setOptions(options);
     }
     
     
     
     
     
     
     
     
     
     
     
}
