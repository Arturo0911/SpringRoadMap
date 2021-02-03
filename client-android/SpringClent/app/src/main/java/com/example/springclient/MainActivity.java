 package com.example.springclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.springclient.properties.Credentials;
import com.example.springclient.properties.ProductList;

import java.util.ArrayList;
import java.util.Arrays;

 public class MainActivity extends AppCompatActivity {

     private EditText idCredentials;
     private EditText productName;
     private Spinner productType;
     private Spinner productMade;
     private Spinner productCategory;
     private EditText productPrice;
     private EditText productYear;
     private RadioButton sanitaryRegisterYes;
     private RadioButton sanitaryRegisterNo;
     private EditText clientAge;


    public void initButton(View view){
        Credentials credential = new Credentials();
        String value = idCredentials.getText().toString();

        if (credential.verifyCredential(value)){
            Toast.makeText(this, "cedula correcta", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Cedula incorrecta", Toast.LENGTH_SHORT).show();
        }
    }

    public void onViewList(View view){

        if (ProductList.liquorList.size() < 1){
            Toast.makeText(this, "The product list it's empty", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Got it", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idCredentials = (EditText) findViewById(R.id.idCredentials);
        productName = (EditText) findViewById(R.id.productName);
        productPrice = (EditText) findViewById(R.id.productPrice);
        productYear = (EditText) findViewById(R.id.productYear);
        clientAge = (EditText) findViewById(R.id.clientAge);

        sanitaryRegisterYes = (RadioButton) findViewById(R.id.sanitaryRegisterYes);
        sanitaryRegisterNo = (RadioButton) findViewById(R.id.sanitaryRegisterNo);


        productType = (Spinner) findViewById(R.id.productType);
        productMade = (Spinner) findViewById(R.id.productMade);
        productCategory = (Spinner) findViewById(R.id.productCategory);

        ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(this, R.array.ProductTypes, R.layout.support_simple_spinner_dropdown_item);
        adapterType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        productType.setAdapter(adapterType);



        ArrayAdapter<CharSequence> adapterMade = ArrayAdapter.createFromResource(this, R.array.ProductMades, R.layout.support_simple_spinner_dropdown_item);
        adapterMade.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        productMade.setAdapter(adapterMade);


        ArrayAdapter<CharSequence> adapterCategory = ArrayAdapter.createFromResource(this, R.array.ProductCategories, R.layout.support_simple_spinner_dropdown_item);
        adapterCategory.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        productCategory.setAdapter(adapterCategory);


    }




}