package com.example.mdecinenotofication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    database db;
EditText e_name,e_pass;
Button b_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new database(this);
        e_name=(EditText)findViewById(R.id.editTextName);
        e_pass=(EditText)findViewById(R.id.editTextpassword);
        b_login=(Button)findViewById(R.id.buttonlogin);
    }

    public void notfica(View view) {
        String s1=e_name.getText().toString();
        String s2=e_pass.getText().toString();
        if (s1.equals("")||s2.equals("")) {
             e_name.setText("");
            e_pass.setText("");
            Toast.makeText(this, "fileds are empty", Toast.LENGTH_LONG).show();
        }
        else {
                Boolean insert=db.insert(s1,s2);
                if(insert==true)
                    Toast.makeText(this,"login sucess",Toast.LENGTH_LONG).show();
            e_name.setText("");
            e_pass.setText("");
            Intent intent=new Intent(this,notifccat.class);
            startActivity(intent);
        }

    }
}
