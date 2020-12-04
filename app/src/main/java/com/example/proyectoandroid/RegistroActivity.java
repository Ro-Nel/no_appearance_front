package com.example.proyectoandroid;

import android.app.DatePickerDialog;
import android.app.Dialog;
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
import java.util.Calendar;


public class RegistroActivity extends AppCompatActivity {

    Apis apis;


    EditText txName;
    EditText txApellido;
    EditText txNacimiento;
    EditText txEmail;
    EditText txPassword;
    Button btRegistro;
    Button btCalendario;

    int anio=0,ani=0;
    int mes=0,me=0;
    int dia=0,di=0;
    static final int DATE_ID = 0;
    Calendar c =Calendar.getInstance();

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
        //btCalendario = (Button) findViewById(R.id.calendario);
        mes = c.get(Calendar.MONDAY);
        dia = c.get(Calendar.DAY_OF_MONTH);
        anio = c.get(Calendar.YEAR);

        txNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_ID);
                //showDialog(DATE_ID);
            }
        });

        /*btCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerFecha();
            }
        });*/


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
/*
    private void colocar_fecha() {
        txNacimiento.setText((me + 1) + "-" + di + "-" + ani+" ");
    }
*/
    private void colocar_fecha() {
        txNacimiento.setText(ani + "-" + (me + 1) + "-" + di);
    }



    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    ani = year;
                    me = monthOfYear;
                    di = dayOfMonth;
                    colocar_fecha();

                }

            };


    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDateSetListener, anio, mes, dia);


        }


        return null;
    }




/*    @Override
    public void onClick(View v) {
        obtenerFecha();
    }*/
    /*private void obtenerFecha() {
        final DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            //final DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            //final DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int año, int mesi, int diaa) {
                final int mesActual = mesi + 1;
                String diaFormateado = (diaa < 10) ? "0" + String.valueOf(diaa) : String.valueOf(diaa);
                String mesFormateado = (mesActual < 10) ? "0" + String.valueOf(mesActual) : String.valueOf(mesActual);
                txNacimiento.setText(diaFormateado + "-" + mesFormateado + "-" + año);
            }
        }, anio, mes, dia);recogerFecha.getDatePicker().setMinDate(30);
        recogerFecha.getDatePicker().setMaxDate(30);
        recogerFecha.show();
    }*/

    private void registrarCliente() throws ParseException {

//"1992-10-10",
        Date Nacimiento = Date.valueOf(txNacimiento.getText().toString());

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