package com.example.alergant.activities;

import java.util.ArrayList;

import com.example.alergant.other.Peticiones;
import com.example.alergant.other.Restaurante;
import com.example.inicio.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Inicio extends ActionBarActivity implements OnClickListener{

	private final static int LOGIN = 0;
	private final static int SKIP = 1;
	private final static int REGISTER = 2;
	
	private final static String AUTHCHECK = "authcheck";
	
	private Button login;
	private Button skip;
	private Button register;
	private TextView usuario;
	private TextView password;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        
        this.usuario = (TextView) findViewById(R.id.user);
        this.password = (TextView) findViewById(R.id.pass);

        this.login = (Button) findViewById(R.id.login);
        this.skip = (Button) findViewById(R.id.skip);
        this.register = (Button) findViewById(R.id.register);
        
        this.login.setOnClickListener(this);
        this.skip.setOnClickListener(this);
        this.register.setOnClickListener(this);
        
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
	public void onClick(View view) {
		
		switch (view.getId()){
		
			case R.id.login:
				load(view, Inicio.LOGIN);
				break;
				
			case R.id.skip:
				load(view, Inicio.SKIP);
				break;
				
			case R.id.register:
				load(view, Inicio.REGISTER);
				break;
		}
	}
	
	public void load (View view, int activity){
		
		switch (activity){
		
			case Inicio.LOGIN:
				//if (checkUser())
					startActivity(new Intent(this, Alergias.class));
				break;
				
			case Inicio.SKIP:
				startActivity(new Intent(this, Alergias.class));
				break;
				
			case Inicio.REGISTER:
				startActivity(new Intent(this, Registro.class));
				break;
				
			default:
				break;
				
		}
	}
	
	/*private boolean checkUser (){
		
		String usuario = this.usuario.getText().toString();
		String password = this.password.getText().toString();
		
		Toast.makeText(getApplicationContext(),"User: " + usuario + "\nPass: " + password, Toast.LENGTH_LONG) .show();
		
		Peticiones peticiones = new Peticiones (Inicio.AUTHCHECK, new String [] {usuario, password});
		if (peticiones.realizarPeticion() == null)
			Toast.makeText(getApplicationContext(), "true", Toast.LENGTH_LONG) .show();
		else
			Toast.makeText(getApplicationContext(), "false", Toast.LENGTH_LONG) .show();
		
		ArrayList <Restaurante> restaurante = peticiones.realizarPeticion();
		
		//if (restaurante.get(0) == null)
			return false;
		else
			return true;
		
	}*/
}
