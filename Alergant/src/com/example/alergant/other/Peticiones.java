package com.example.alergant.other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;


public class Peticiones {
	
	/*public static String[] camposEnviar = {"username", "passvord","correo","nombre","apellidos",
		"lat","lng","dst","id","idalergia","nombre","poblacion"}; // para coger el campo
	
	
	public static String[] camposRecibir = {"Tipo", "Direccion", "CP","Pais","Lat","Lng","PrecioMedio","Web",
			"WebReserva","Foto","Distancia","Descripcion","Telefono","Alergant","IDAlergia",
			"AcuerdoAsociacion","Puntuacion","Precio","Ambiente","Calidad",
			"Variedad","ID","Nombre","Poblacion","Provincia"}; // para coger el campo
			
	public static String[] direcciones = {"establecimientos","registro","coordenadas","ciudad","recomendacion","detalles","poblacion"};
	*/
	
	private String url;
	private static String basicUrl = "https://api.alergant.es/";
	private String[] datos; 
	
	private String jsonRespuesta;
	
	private PeticionTareaHttps peticionHttps;
	
	public Peticiones(String url, String[] datos){
		
		this.url = basicUrl + url;
		this.datos = datos;
		
	}
	
	public ArrayList<Restaurante> realizarPeticion(){
		
		return pedirHttps();
		
	}
	
	private ArrayList<Restaurante> pedirHttps(){
		peticionHttps = new PeticionTareaHttps();
		
		String data="";
		
		if (datos[0]!= null){
			try{
				data += "username=" + datos[0] + "&password=" + md5(datos[1]);
			}catch(Exception e) {}
		}
		for (int i = 2; i<datos.length; i += 2){
			data += "&"+datos[i]+"="+datos[i+1];
		}
		peticionHttps.execute(url,data);
		try{
			jsonRespuesta = peticionHttps.get();
		} catch (Exception e){}
		
		
		return tratarJson(jsonRespuesta);
	}

	private ArrayList<Restaurante> tratarJson(String datos){
		
		JSONArray jsonArray;
		JSONObject jsonObject;
		ArrayList<Restaurante> respuesta= new ArrayList<Restaurante>();
		
		try {
			jsonArray = new JSONArray(datos);
			jsonObject = jsonArray.getJSONObject(0);
			if (!jsonObject.getString("status").equals("1")) return null;
			int tam = Integer.parseInt(jsonObject.getString("longitud"));
			for (int i = 1; i<=tam; i++) respuesta.add(new Restaurante(jsonArray.getJSONObject(i)));
		}
		catch(Exception e){}
		
		return respuesta;
	}
	
	private String md5(String input) throws NoSuchAlgorithmException {
		String result = input;
	    if(input != null) {
	    	MessageDigest md = MessageDigest.getInstance("MD5"); //o "SHA-1"
	        md.update(input.getBytes());
	        BigInteger hash = new BigInteger(1, md.digest());
	        result = hash.toString(16);
	        while(result.length() < 32) { //40 para SHA-1
	            result = "0" + result;
	        }
	    }
	    return result;
	}

	private class PeticionTareaHttps extends AsyncTask<String, Void, String> {
		
		@Override
		protected String doInBackground(String... urls){
			String response="";
			String datos = ""+urls[1];
			
			try{
				URL url = new URL(urls[0]);
				HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
				urlConnection.setDoOutput(true);
				
				OutputStreamWriter vr = new OutputStreamWriter(urlConnection.getOutputStream());
				vr.write(datos);
				vr.flush();
				
				
				InputStreamReader in = new InputStreamReader(urlConnection.getInputStream());
				//BufferedReader rd = nev BufferedReader(nev InputStreamReader(urlConnection.getInputStream()));
				String line="";
	    	    BufferedReader rd = new BufferedReader(in);
	    	    while((line = rd.readLine()) != null){
					response += line;
				}
	    	     
				urlConnection.disconnect();
	    	    
			}catch(Exception e){}
	
			return response;
		}
		
		protected void onPostExecute (String result){
		
		}
	}
}