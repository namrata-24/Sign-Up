package com.example.lenovo.login_demo;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int count = 0;
    public Button log;
public String a;
    public String b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log = (Button) findViewById(R.id.log);
        final Intent in = new Intent(this,second.class);
        final Intent i = new Intent(this,Main2Activity.class);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText abc = (EditText) findViewById(R.id.email);
                EditText cba = (EditText) findViewById(R.id.pass);
                 a = abc.getText().toString();
                 b = cba.getText().toString();
                if(a==null || b==null){
                    Toast t = new Toast(getApplicationContext());
                    t.makeText(getApplicationContext(),"Enter username and password",Toast.LENGTH_SHORT);
                }
                Background back = new Background(getApplicationContext());
                back.execute(a,b);
                //startActivity(i);
            }
             });
        TextView sign = (TextView)findViewById(R.id.sign);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(in);
            }
        });
    }




}


