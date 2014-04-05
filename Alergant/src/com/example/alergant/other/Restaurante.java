package com.example.alergant.other;


import java.util.HashMap;

import org.json.JSONObject;

public class Restaurante {
	
	public static String[] camposEnviar = {"username", "password","correo","nombre","apellidos",
		"lat","lng","dst","id","idalergia","nombre","poblacion"};
	
	
	public static String[] camposRecibir = {"Status", "Nombre","Tipo", "Direccion", "CP","Poblacion","Provincia","Pais","Lat","Lng","PrecioMedio","Web",
			"WebReserva","Foto","Distancia","Descripcion","Telefono","Alergant","IDAlergia",
			"AcuerdoAsociacion","Puntuacion","Precio","Ambiente","Calidad",
			"Variedad","ID"}; 
	
	public static String[] direcciones = {"establecimientos","registro","coordenadas","ciudad","recomendacion","detalles","poblacion"};
	/*
	private int acuerdoAsociacion;
	private int cp;
	private int idalergia;
	private int puntuacion;
	private int precio;
	private int ambiente;
	private int calidad;
	private int variedad;
	private int id;
	
	private double lat;
	private double lng;
	private double preciomedio;
	
	private String tipo;
	private String direccion;
	private String pais;
	private String web;
	private String webreserva;
	private String descripcion;
	private String telefono;
	private String alergant;
	private String nombre;
	private String poblacion;
	private String provincia;
	*/
	
	private HashMap<String,String> datos = new HashMap<String,String>();
	
	public Restaurante(JSONObject jsonObject){
		/*this.acuerdoAsociacion = this.cp = this.idalergia = this.puntuacion = 
				this.precio = this.ambiente = this.calidad = this.variedad = this.id = -1;
		
		this.lat = this.lng = this.preciomedio = -1.0;
		
		this.tipo = this.direccion = this.pais = this.web = this.webreserva = this.descripcion = 
				this.telefono = this.alergant = this.nombre = this.poblacion = this.provincia = null;
	*/
		parseFromJSON(jsonObject);
	
	}
	
	private void parseFromJSON (JSONObject jsonObject){
		
		try {
			for (int j=0; j<Restaurante.camposRecibir.length; j++){
				try{
					this.datos.put(Restaurante.camposRecibir[j],jsonObject.getString(Restaurante.camposRecibir[j]));
					
				}catch(Exception e){}
			}
		}catch(Exception e){}
	}
	
	public HashMap<String,String> getMap(){
		
		return this.datos;
	
	}
	
	@Override
	public String toString (){
		String resultado="";
		
		for(String s: Restaurante.camposRecibir){
			if (this.datos.get(s) != null) {
				resultado += s+":" + this.datos.get(s) + "\n"; 
			}
		}
		
		return resultado;
	}
	
	
	
	
}
