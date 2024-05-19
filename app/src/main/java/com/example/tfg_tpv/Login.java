package com.example.tfg_tpv;

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

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        EditText username = findViewById(R.id.txtUser);
        EditText password = findViewById(R.id.txtpwd);
        Button login = findViewById(R.id.login);

        login.setOnClickListener(v -> {
            String inputUsername = username.getText().toString();
            String inputPassword = password.getText().toString();

            if (inputUsername.equals("1") && inputPassword.equals("1")) {
                // Login successful
                Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();

                // Navigate to MainActivity
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                finish(); // This will finish the current activity (Login)
            } else {
                // Login failed
                Toast.makeText(Login.this, "Login failed", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}