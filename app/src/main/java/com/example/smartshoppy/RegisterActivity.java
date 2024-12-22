package com.example.smartshoppy;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText regUser, regPass, regChkpass;

    TextView loginTv;
    Button regBtn;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loginTv = (TextView) findViewById(R.id.tv_log);
        regBtn = (Button) findViewById(R.id.button_reg);
        regUser = (EditText) findViewById(R.id.name_reg);
        regPass = (EditText) findViewById(R.id.pass_reg);
        regChkpass = (EditText) findViewById(R.id.chk_reg);
        DB=new DBHelper(this);

        loginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=regUser.getText().toString();
                String pass= regPass.getText().toString();
                String chkpass= regChkpass.getText().toString();

                if(user.equals("")||pass.equals("")||chkpass.equals(""))
                    Toast.makeText(RegisterActivity.this,"Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    if(pass.equals(chkpass)){
                        Boolean checkuser=DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(RegisterActivity.this,"Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(RegisterActivity.this,"Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(RegisterActivity.this,"User already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegisterActivity.this,"Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
}