package com.example.alergant.activities;

import java.util.ArrayList;

import com.example.alergant.other.Affections;
import com.example.alergant.other.Constantes;
import com.example.inicio.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Alergias extends ActionBarActivity implements OnClickListener{

	 private MyCustomAdapter dataAdapter = null;
	 private Button cont;
	 public static int result;

	 @Override
	 public void onCreate(Bundle savedInstanceState) {
		 
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.alergias);

		 this.cont = (Button)findViewById(R.id.con);
		 this.cont.setOnClickListener(this);
		 
		 // Generate list View from ArrayList
		 
		 displayListView();
		 
	 }
	 
	 @Override
	 public void onClick(View v) {
	
	    ArrayList <Affections> affections = dataAdapter.affections;
	    int result = 0;
	    
		for (int i = 0; i < affections.size(); i++) {
			 
			Affections state = affections.get(i);		
			if (state.isSelected()) 
				result += (int) Math.pow(2, Integer.parseInt(state.getCode()));
		    
		}
		
		 if (result > 0)
			 startActivity(new Intent (this, Busqueda.class));
		
	 }
	 
	 private void displayListView() {

		  ArrayList <Affections> affections = new ArrayList <Affections> ();
		  
		  affections.add(new Affections("" + Constantes.GLUTEN, "Gluten", false));
		  affections.add(new Affections("" + Constantes.LACTOSA, "Lactosa", false));
		  affections.add(new Affections("" + Constantes.PESCADO, "Pescado", false));
		  affections.add(new Affections("" + Constantes.MARISCO, "Marisco", false));
		  affections.add(new Affections("" + Constantes.VEGETARIANO, "Vegetariano", false));
		  affections.add(new Affections("" + Constantes.VEGANO, "Vegano", false));
		  affections.add(new Affections("" + Constantes.HUEVO, "Huevo", false));
		  affections.add(new Affections("" + Constantes.SOJA, "Soja", false));
		  affections.add(new Affections("" + Constantes.FRUTOS_SECOS, "Frutos Secos", false));
		  affections.add(new Affections("" + Constantes.FRUTA, "Fruta", false));
		  affections.add(new Affections("" + Constantes.DIABETICOS, "Diabético", false));
		  affections.add(new Affections("" + Constantes.ECOLOGICOS, "Ecológico", false));
		  
		  this.dataAdapter = new MyCustomAdapter(this, R.layout.option, affections);
		  ListView listView = (ListView) findViewById(R.id.listView1);		  
		  listView.setAdapter((ListAdapter) dataAdapter);
		  
	 }

	 private class MyCustomAdapter extends ArrayAdapter <Affections> {

		 private ArrayList <Affections> affections;

		 public MyCustomAdapter(Context context, int textViewResourceId, ArrayList<Affections> affections) {
			 
			  super(context, textViewResourceId, affections);
			  this.affections = new ArrayList <Affections>();
			  this.affections.addAll(affections);
		   
		 }

		 private class ViewHolder {
			  
			  TextView code;
			  CheckBox check;
		   
		 }

		  @Override
		 public View getView(int position, View convertView, ViewGroup parent) {
	
			  ViewHolder holder = null;
	
			  Log.v("ConvertView", String.valueOf(position));
	
			  if (convertView == null) {
	
			    LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
			    convertView = vi.inflate(R.layout.option, null);
		
			    holder = new ViewHolder();
			    holder.code = (TextView) convertView.findViewById(R.id.code);
			    holder.check = (CheckBox) convertView.findViewById(R.id.checkBox);
		
			    convertView.setTag(holder);
		
			    holder.check.setOnClickListener(new View.OnClickListener() {
			    	
				     public void onClick(View v) {
				    	 
					      CheckBox cb = (CheckBox) v;
					      Affections state = (Affections) cb.getTag();
					      state.setSelected(cb.isChecked());
					      
				     }
			    });
			  } 
			  
			  else 
				  holder = (ViewHolder) convertView.getTag();			  
		
			  Affections state = affections.get(position);
		
			  holder.code.setText("");
			  holder.check.setText(state.getAffection());
			  holder.check.setChecked(state.isSelected());
		
			  holder.check.setTag(state);
		
			  return convertView;
		   
		 }
	 }
}
