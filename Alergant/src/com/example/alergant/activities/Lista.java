package com.example.alergant.activities;

import com.example.inicio.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Lista extends ActionBarActivity implements OnClickListener{

	Button b1,b2,b3,b4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista);
		
		b1 = (Button)findViewById(R.id.b1);
		b2 = (Button)findViewById(R.id.b2);
		b3 = (Button)findViewById(R.id.b3);
		b4 = (Button)findViewById(R.id.b4);

		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
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
	public void onClick(View v) {
		int id = 0;
		switch (v.getId()){
			case (R.id.b1):
				//Lanzar petici�n a javi
				id=1;
				//Salto de activity
			break;
			case (R.id.b2):
				//Lanza peticion
				//salto de activity
				id=2;
			break;
			case (R.id.b3):
				id=3;
			break;
			case(R.id.b4):
				id=4;
			break;
		}
		pasoAc(v, id);	
		
		
	}
	public void pasoAc(View v , int id){
		
		Bundle bolsa = new Bundle();
		bolsa.putString("id", id+"");
		
		startActivity(new Intent());
		
	}
}

