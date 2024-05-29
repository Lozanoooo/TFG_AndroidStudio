package com.example.tfg_tpv.Registro;

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

import com.example.tfg_tpv.Login.Login;
import com.example.tfg_tpv.MainActivity;
import com.example.tfg_tpv.R;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);

        EditText username = findViewById(R.id.txtUser);
        EditText password = findViewById(R.id.txtpwd);
        EditText passwordConfirm = findViewById(R.id.txtpwdConfirm);
        Button register = findViewById(R.id.register);
        Button login = findViewById(R.id.login); // Obtén una referencia al botón de inicio de sesión

        register.setOnClickListener(v -> {
            String inputUsername = username.getText().toString();
            String inputPassword = password.getText().toString();
            String inputPasswordConfirm = passwordConfirm.getText().toString();

            if (inputUsername.isEmpty() || inputPassword.isEmpty() || inputPasswordConfirm.isEmpty()) {
                Toast.makeText(Registro.this, "Por favor, rellene todos los campos", Toast.LENGTH_SHORT).show();
            } else if (!inputPassword.equals(inputPasswordConfirm)) {
                Toast.makeText(Registro.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            } else {
                // Aquí es donde crearías la nueva cuenta de usuario
                Toast.makeText(Registro.this, "Cuenta creada con éxito", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Registro.this, MainActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(v -> {
            // Inicia la actividad Login cuando se hace clic en el botón de inicio de sesión
            Intent intent = new Intent(Registro.this, Login.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}