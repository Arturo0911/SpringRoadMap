 package com.example.springclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.springclient.properties.Credentials;

import java.util.ArrayList;
import java.util.Arrays;

 public class MainActivity extends AppCompatActivity {

     private EditText idCredentials;


    public void initButton(View view){
        Credentials credential = new Credentials();
        String value = idCredentials.getText().toString();

        if (credential.verifyCredential(value)){
            Toast.makeText(this, "cedula correcta", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Cedula incorrecta", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idCredentials = (EditText) findViewById(R.id.idCredentials);


    }
}