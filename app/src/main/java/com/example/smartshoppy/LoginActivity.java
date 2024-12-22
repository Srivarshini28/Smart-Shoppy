package com.example.smartshoppy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;

    TextView regTv;
    Button loginBtn;

    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=(EditText)findViewById(R.id.et_username);
        password=(EditText)findViewById(R.id.et_password);
        DB=new DBHelper(this);
        regTv=(TextView) findViewById(R.id.tv_reg);
        loginBtn=(Button) findViewById(R.id.button_login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this,"Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass=DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true) {
                        Toast.makeText(LoginActivity.this, "login succesfully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this,"Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        regTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}