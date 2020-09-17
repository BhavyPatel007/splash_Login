package com.example.splash_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {
    EditText Name,Password;
     TextView Info;
     Button Login;
    int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name=(EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        Login=(Button)findViewById(R.id.btnLogin);
        Info=(TextView)findViewById(R.id.tvInfo);
        Info.setText("Reminig Attempts: 5");
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    validate(Name.getText().toString(),Password.getText().toString());
            }
        });
    }

    private void validate(String userName,String userPassword){
        if(userName.equals("Admin")&&(userPassword.equals("123456"))){
            Intent intent=new Intent(login.this,welcome.class);
            startActivity(intent);
        }
        else {
            counter--;
            Info.setText("Reminig Attempts:  "+String.valueOf(counter));
            if(counter==0){
                Login.setEnabled(false);
            }
        }
    }
}
