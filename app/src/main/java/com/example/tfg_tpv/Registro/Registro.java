package com.example.tfg_tpv.Registro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tfg_tpv.Api.ApiInterface;
import com.example.tfg_tpv.Api.RegisterData;
import com.example.tfg_tpv.Api.RetrofitClient;
import com.example.tfg_tpv.Login.Login;
import com.example.tfg_tpv.MainActivity;
import com.example.tfg_tpv.R;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        EditText nombre = findViewById(R.id.txtnom);
        EditText apellido = findViewById(R.id.txtApell);
        EditText txtPhone = findViewById(R.id.txtTLF);
        EditText direccion = findViewById(R.id.txtDireccion);
        EditText email = findViewById(R.id.txtEmail);
        EditText cif = findViewById(R.id.txtCIF);
        EditText password = findViewById(R.id.txtPass);
        Button register = findViewById(R.id.register);
        Button login = findViewById(R.id.login);

        register.setOnClickListener(v -> {
            if( nombre.getText().toString().isEmpty() || apellido.getText().toString().isEmpty() || txtPhone.getText().toString().isEmpty() || direccion.getText().toString().isEmpty() || email.getText().toString().isEmpty() || cif.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                Toast.makeText(Registro.this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show();
                return;
            }

            RegisterData registerData = new RegisterData(
                    nombre.getText().toString(),
                    apellido.getText().toString(),
                    txtPhone.getText().toString(),
                    direccion.getText().toString(),
                    email.getText().toString(),
                    cif.getText().toString(),
                    password.getText().toString()
            );

            Map<String, String> registerDataMap = new HashMap<>();
            registerDataMap.put("nombre", registerData.getNombre());
            registerDataMap.put("apellidos", registerData.getApellido());
            registerDataMap.put("telefono", registerData.getTelefono());
            registerDataMap.put("direccion", registerData.getDireccion());
            registerDataMap.put("email", registerData.getEmail());
            registerDataMap.put("cif", registerData.getCif());
            registerDataMap.put("contrasena", registerData.getContrasena());

            ApiInterface apiInterface = RetrofitClient.getClient("http://10.0.2.2:8080/").create(ApiInterface.class);

            Call<ResponseBody> call = apiInterface.registerUser(registerDataMap);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(Registro.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Registro.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(Registro.this, "Registro fallido: " + response.message(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(Registro.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });

        login.setOnClickListener(v -> {
            Intent intent = new Intent(Registro.this, Login.class);
            startActivity(intent);
        });
    }
}