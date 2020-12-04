package com.example.proyectoandroid;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.proyectoandroid.model.Cliente;
import com.example.proyectoandroid.util.Apis;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    public static int IDCLIENTE;
    Apis apis;

    EditText txEmail;
    EditText txPassword;
    Button btRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txEmail = (EditText) findViewById(R.id.email);
        txPassword = (EditText) findViewById(R.id.password);
        btRegistro = (Button) findViewById(R.id.login);
        btRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logearUsuario();
            }
        });


    }

    private void logearUsuario() {
        String Email = txEmail.getText().toString();
        String Password = txPassword.getText().toString();

        if (TextUtils.isEmpty(Email) || TextUtils.isEmpty(Password) ) {
            Toast.makeText(this, "no debe existir campos vacios", Toast.LENGTH_LONG).show();
        } else {
            Cliente nuevoCliente = new Cliente(Email, Password);
            Call<Integer> call = apis.clienteService().logincliente(nuevoCliente);
            call.enqueue(new Callback<Integer>() {

                @Override
                public void onResponse(Call<Integer> call, Response<Integer> response) {
                    if(response.body()==(-1)){
                        Toast.makeText(LoginActivity.this,"Clave o correo incorrectos ",Toast.LENGTH_LONG).show();
                    }else{
                        IDCLIENTE = response.body();
                        Toast.makeText(LoginActivity.this,"Correcto ",Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(Call<Integer> call, Throwable t) {
                    Log.e( "Error ",t.getMessage());
                }
            });

        }

    }

}