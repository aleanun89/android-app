package com.example.alergant.activities;

import com.example.inicio.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Busqueda extends Activity implements OnClickListener {
	
	private ImageView circulo;
	private Bitmap bitmap;
	private ImageButton btn;
	private Button recomendar;
	private EditText parametro;
	private Button restaurante;
	private Button comercio;
	private Button hotel;
	private Button other;
	private Button bar;
	private Button tienda;
	private String param2;
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.busq);
		
		circulo = (ImageView) findViewById(R.id.circulo);
		bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.buscar);
		recomendar = (Button) findViewById(R.id.recom);
		recomendar=(Button)findViewById(R.id.recom);
		restaurante=(Button)findViewById(R.id.tp1);
		comercio=(Button)findViewById(R.id.tp2);
		hotel=(Button)findViewById(R.id.tp3);
		bar=(Button)findViewById(R.id.tp4);
		tienda=(Button)findViewById(R.id.tp5);
		other=(Button)findViewById(R.id.tp6);
		
		circulo.setOnClickListener(this);
		restaurante.setOnClickListener(this);
		comercio.setOnClickListener(this);
		hotel.setOnClickListener(this);
		bar.setOnClickListener(this);
		tienda.setOnClickListener(this);
		other.setOnClickListener(this);
		
		/*circulo.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				int eventPadTouch = event.getAction();
			    int iX = (int) event.getX();
			    int iY = (int) event.getY();
			    
			    switch (eventPadTouch) {
	
			        case MotionEvent.ACTION_DOWN:
			        	if (!isPixelTransparent(iX,iY)){
			        		listaBusq(v);
			        	}
			    }      
			    return true;
			}
		});*/
	}
	public void listaBusq(View view){
		
		startActivity(new Intent(this, Lista.class));
		
	}
	
	@Override
	public void onClick(View view) {
	
		switch(view.getId()){
		
			case R.id.tp1: param2="hotel";
				break;
				
			case R.id.tp2: param2="restaurante";
				break;
			
			case R.id.tp3: param2="hotel";
				break;
			
			case R.id.tp4:param2="comercio";
				break;
			
			case R.id.tp5:param2="tienda";
				break;
			
			case R.id.tp6:param2="other";
				break;
			
			default:				
				break;
		}
		
		listaBusq(view);
		
	}
			
	private boolean isPixelTransparent(int x, int y) {
		
        int color = Color.TRANSPARENT;
        try {
            color = bitmap.getPixel(x, y);
        } catch (IllegalArgumentException e) {}
        if (color == Color.TRANSPARENT)
            return true;
        else
            return false;
    }
}