package com.example.alergant.activities;

import com.example.alergant.other.Usuario;
import com.example.inicio.R;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends ActionBarActivity implements OnClickListener{
	
	private Button continuar;
	private TextView nombre;
	private EditText en_nombre, en_pwd, en_cpwd, en_correo, en_user;
	private Usuario usuario;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registro);
		
		this.continuar = (Button) findViewById(R.id.continuar);
		this.en_nombre = (EditText) findViewById(R.id.en_nombre);
		this.en_pwd = (EditText) findViewById(R.id.en_pwd);
		this.en_cpwd = (EditText) findViewById(R.id.en_cpwd);
		this.en_correo = (EditText) findViewById(R.id.en_correo);
		this.en_user = (EditText) findViewById(R.id.en_usuario);
		
		//Escuchas
		
		this.continuar.setOnClickListener(this);
		//en_user.setFocusable(false);

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
		
		String nombre, apellidos, user, pwd, cpwd, correo;
		nombre=apellidos=user=pwd=cpwd=correo=null;
		
		nombre = this.en_nombre.getText().toString();
		user = this.en_user.getText().toString();
		pwd = this.en_pwd.getText().toString();
		cpwd = this.en_cpwd.getText().toString();
		correo = this.en_correo.getText().toString();
		
		if (pwd.equals(cpwd) && !nombre.equals("") && !user.equals("") && !pwd.equals("") && !correo.equals("")){
			//Toast toast = Toast.makeText(this, "Llego", Toast.LENGTH_SHORT);
			this.usuario = new Usuario (nombre, apellidos, user, pwd, correo);
			acierto();
		}
			
		//Error
		else
			mostrarError();
		
	}

	private void mostrarError() {
		
        Toast toast = Toast.makeText(this, "Oops, hay algún error", Toast.LENGTH_SHORT);
        toast.show(); 
    }
	
	private void acierto() {
		
		super.finish();
        
	}
}
