package com.example.proyectoandroid;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.proyectoandroid.model.Cliente;
import com.example.proyectoandroid.util.Apis;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class RegistroActivity extends AppCompatActivity {

    Apis apis;


    EditText txName;
    EditText txApellido;
    EditText txNacimiento;
    EditText txEmail;
    EditText txPassword;
    Button btRegistro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        txName = (EditText) findViewById(R.id.name);
        txApellido = (EditText) findViewById(R.id.apellido);
        txNacimiento = (EditText) findViewById(R.id.nacimiento);
        txEmail = (EditText) findViewById(R.id.email);
        txPassword = (EditText) findViewById(R.id.password);
        btRegistro = (Button) findViewById(R.id.registro);


        btRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    registrarCliente();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }



    private void registrarCliente() throws ParseException {

//"1992-10-10",
      //  Date Nacimiento = Date.valueOf(txNacimiento.getText().toString());

        String Name = txName.getText().toString();
        String Apellido = txApellido.getText().toString();
        String Email = txEmail.getText().toString();
        String Password = txPassword.getText().toString();

        if  ( TextUtils.isEmpty(Name) || TextUtils.isEmpty(Apellido) ||  /* TextUtils.isEmpty(txNacimiento.getText().toString()) ||*/
                TextUtils.isEmpty(Email) || TextUtils.isEmpty(Password) ) {
            Toast.makeText(this, "no debe existir campos vacios", Toast.LENGTH_LONG).show();
        } else {
            Cliente nuevoCliente = new Cliente(Name, Apellido/*,Nacimiento*/, Email, Password);
            Call<String> call = apis.clienteService().registrarcliente(nuevoCliente);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Log.i("User............................ ", "Creado " + response.body());
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.i("User............................ ", "Error "+ t.toString());

                }
            });
        }
    }

}