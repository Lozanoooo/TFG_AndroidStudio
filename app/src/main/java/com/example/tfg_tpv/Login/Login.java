package com.example.tfg_tpv.Login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tfg_tpv.Api.ApiInterface;
import com.example.tfg_tpv.Api.LoginData;
import com.example.tfg_tpv.Api.RetrofitClient;
import com.example.tfg_tpv.MainActivity;
import com.example.tfg_tpv.R;
import com.example.tfg_tpv.Registro.Registro;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        EditText username = findViewById(R.id.txtUser);
        EditText password = findViewById(R.id.txtpwd);
        Button login = findViewById(R.id.login);
        Button register = findViewById(R.id.Register);

        login.setOnClickListener(v -> {
            String ID_Cliente = username.getText().toString();
            String contrasena = password.getText().toString();

            if (ID_Cliente.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(Login.this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show();
                return;
            }

            Map<String, String> loginData = new HashMap<>();
            loginData.put("idCliente", ID_Cliente);
            loginData.put("contrasena", contrasena);

            ApiInterface apiInterface = RetrofitClient.getClient("http://10.0.2.2:9090/").create(ApiInterface.class);            Call<ResponseBody> call = apiInterface.loginUser(loginData);

            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(Login.this, "Login failed: " + response.message(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(Login.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });

        register.setOnClickListener(v -> irRegistro());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void irRegistro() {
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }
}
