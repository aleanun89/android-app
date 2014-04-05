package com.example.alergant.activities;

import com.example.alergant.other.Restaurant;
import com.example.alergant.other.DescrpAux.UrlImageViewHelper;
import com.example.inicio.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Descripcion extends ActionBarActivity implements OnRatingBarChangeListener, OnTouchListener{
	
	TextView nombre;
	TextView tipo;
	TextView direccion;
	TextView telefono;
	TextView reserva;
	RatingBar rating;
	TextView descripcion;
	ImageView imagen;
	TextView numeros;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.descripcion);
		
		//Aqui cogemos el objeto
		//
		try{
			
			Restaurant.nombre = "Eh Voila!";
			Restaurant.tipo="Restaurante";
			Restaurant.direccion="Calle Esgueva";
			Restaurant.telefono="Telefono";
			Restaurant.reserva="www.google.es";
			Restaurant.descripcion="Lugar agradable....";
			Restaurant.imagen="http://www.ehvoila.es/web/data/images/logo.png";
			Restaurant.valoracion="9";
			
			Bundle extras = getIntent().getExtras();
			
			Restaurant.nombre = extras.getString("nombre");
			Restaurant.tipo=extras.getString("tipo");
			Restaurant.direccion=extras.getString("direccion");
			Restaurant.telefono=extras.getString("telefono");
			Restaurant.reserva=extras.getString("urlReserva");
			Restaurant.descripcion=extras.getString("descripcion");
			Restaurant.imagen=extras.getString("urlImagen");
			Restaurant.valoracion=extras.getString("valoracion");
		}
		catch(Exception e){
			
		}
		
		if (Restaurant.reserva == null)
			Restaurant.reserva="";
		
		if (Restaurant.valoracion=="" || Restaurant.valoracion==null)
			Restaurant.valoracion="0";
		
		float ratio = (Float.parseFloat(Restaurant.valoracion));
		
		this.nombre = (TextView)findViewById(R.id.nombre);
		this.tipo = (TextView)findViewById(R.id.tipo);
		this.direccion = (TextView)findViewById(R.id.direccion);
		this.telefono = (TextView)findViewById(R.id.telefono);
		this.reserva = (TextView)findViewById(R.id.reserva);
		this.descripcion = (TextView)findViewById(R.id.descripcion);
		this.rating = (RatingBar) findViewById(R.id.rating);
		this.imagen = (ImageView) findViewById(R.id.imagen);
		this.numeros = (TextView)findViewById(R.id.numeros);
		
		this.nombre.setText(Restaurant.nombre);
		this.tipo.setText(Restaurant.tipo);
		this.direccion.setText(Restaurant.direccion);
		this.telefono.setText(Restaurant.telefono);
		this.reserva.setText("Reservar");
		SpannableString content = new SpannableString(reserva.getText().toString()); 
		content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
		this.reserva.setText(content);
		this.descripcion.setText(Restaurant.descripcion);
		this.rating.setRating(ratio/2);
		this.numeros.setText(ratio+"");
		UrlImageViewHelper.setUrlDrawable(imagen, Restaurant.imagen);
		
		//Escucha
		this.reserva.setOnTouchListener(this);
		this.rating.setOnRatingBarChangeListener(this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onRatingChanged(RatingBar ratingBar, float rating,
			   boolean fromTouch) {
		  //int puntuacion = (((int) ratingBar.getRating())*2);
		  this.numeros.setText((rating*2)+"");
		  enviar(rating*2);
		  }

	private void enviar(float puntuacion) {
		Toast toast = Toast.makeText(this, "Enviando: "+puntuacion, Toast.LENGTH_SHORT);
		toast.show(); 
		
		
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if(event.getAction() == MotionEvent.ACTION_DOWN){
		openWebURL(Restaurant.reserva);
		}
		return true;
	}
	
	public void openWebURL( String url ) {
		if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
     }

     Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
     startActivity(Intent.createChooser(intent, "Chose browser"));
	}
	
}
