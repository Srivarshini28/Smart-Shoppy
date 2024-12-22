package com.example.smartshoppy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WalletActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    String[] items={"cash on Delivery","Gpay"};

    EditText sp,amt;

    Button payBtn;

    AutoCompleteTextView autoCompleteTxt;

    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        autoCompleteTxt=findViewById(R.id.auto_complete_txt);
        adapterItems=new ArrayAdapter<String >(this,R.layout.list_item,items);
        autoCompleteTxt.setAdapter(adapterItems);

        payBtn=(Button)findViewById(R.id.btn_pay);
        sp=(EditText) findViewById(R.id.salesperson);
        amt=(EditText) findViewById(R.id.amt);


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.Wallet);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.Wallet:
                        return true;

                    case R.id.cart:
                        startActivity(new Intent(getApplicationContext(), CartActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;


                }
                return false;

            }

        });
        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item=parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Payment Mode Selected", Toast.LENGTH_SHORT).show();
            }
        });

        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String salesperson=sp.getText().toString();
                String amount=amt.getText().toString();

                if(salesperson.equals("")&&amount.equals(""))
                    Toast.makeText(WalletActivity.this,"Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Toast.makeText(WalletActivity.this, "Payment Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.logoutmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.about:
                aboutinfo();
                break;

            case R.id.help:
                help();
                break;

            case R.id.signout:
                signout();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void help() {

        Intent i = new Intent(this,HelpActivity.class);
        startActivity(i);
    }

    private void aboutinfo() {
        Intent i = new Intent(this,AboutActivity.class);
        startActivity(i);
    }

    private void signout() {

        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
        finish();
        Toast.makeText(this, "Successfully Logout", Toast.LENGTH_SHORT).show();
    }
}
