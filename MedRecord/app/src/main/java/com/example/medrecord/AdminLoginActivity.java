package com.example.medrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AdminLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
    }
    public void onLoginClick(View view){
        TextView errorText = findViewById(R.id.error_text_view);
        EditText username = findViewById(R.id.username_edit_text);
        EditText password = findViewById(R.id.password_edit_text);
        String userText = username.getText().toString();
        String passText = password.getText().toString();
        if(userText.equals("admin") && passText.equals("admin")) {
            openAdminActivity();
        }
        else {
            errorText.setVisibility(view.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    errorText.setVisibility(View.INVISIBLE);
                }
            }, 2000);
        }


    }
    public void openAdminActivity() {
        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
    }
}