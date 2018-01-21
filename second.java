package com.example.lenovo.login_demo;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
public class second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button sign = (Button) findViewById(R.id.sign);
        final Intent in = new Intent(this,Main2Activity.class);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText fname = (EditText) findViewById(R.id.fname);
                EditText lname = (EditText) findViewById(R.id.lname);
                EditText email = (EditText) findViewById(R.id.email);
                EditText pass = (EditText) findViewById(R.id.pass);
                EditText add = (EditText) findViewById(R.id.add);
                EditText cpass = (EditText) findViewById(R.id.cpass);
                EditText mob = (EditText) findViewById(R.id.mob);
                Spinner s = (Spinner)findViewById(R.id.blood);
                String sblood = String.valueOf(s.getSelectedItem());
                String sfname = fname.getText().toString();
                String spass = pass.getText().toString();
                String scpass = cpass.getText().toString();
                String slname = lname.getText().toString();
                String semail = email.getText().toString();
                String sadd = add.getText().toString();
                String smob = mob.getText().toString();

                int a =0;
                int b =0;
                int c =0;
                Toast toast = new Toast(getApplicationContext());
                int len = spass.length();
                for(int i =0;i<len;i++){
                    char d = spass.charAt(i);
                    if(d>=48 && d<=57){
                        a++;
                    }
                    if(d>=65 && d<=90){
                        b++;
                    }
                    if(d>=33 && d<=47){
                        c++;
                    }
                }
                if(a==0 || b==0 || c==0){
                    Toast t = new Toast(getApplicationContext()).makeText(getApplicationContext(),"Password should contain at least one capital letter,one special character and one number",Toast.LENGTH_LONG);
                    t.show();
                } else {
                    if(spass.equals(scpass)){
                        Back back = new Back(getApplicationContext());
                        back.execute(sfname,slname,sadd,semail,smob,sblood,spass);
                        //startActivity(in);
                    } else {
                        toast.makeText(getApplicationContext(),"Passwords dont match !",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        TextView text = (TextView)findViewById(R.id.text);
        final Intent intent = new Intent(this,MainActivity.class);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
    }

