 package com.example.springclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.springclient.properties.Credentials;
import com.example.springclient.properties.Liquor;
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

    public String isSanitaryChecked(RadioButton sanitaryYes, RadioButton sanitaryNo){


        if (sanitaryYes.isChecked()){
            return  "YES";
        }else if (sanitaryNo.isChecked()){
            return "NO";
        }else{
            return "NAN";
        }

    }

    public boolean checkEmpty(EditText idCredentials, EditText productName, EditText productPrice, EditText productYear, EditText clientAge){

        return !idCredentials.getText().toString().equals("")&& !productName.getText().toString().equals("") && !productPrice.getText().toString().equals("") &&
                !productYear.getText().toString().equals("") && !clientAge.getText().toString().equals("");
    }

    public void clearFields(EditText idCredentials, EditText productName, EditText productPrice, EditText productYear, EditText clientAge){


        idCredentials.setText("");
        productName.setText("");
        productPrice.setText("");
        productYear.setText("");
        clientAge.setText("");
    }



    public void initButton(View view){
        Credentials credential = new Credentials();
        String value = idCredentials.getText().toString();

        if (checkEmpty(idCredentials, productName, productPrice, productYear, clientAge)){
            if (credential.verifyCredential(value)){
                Toast.makeText(this, "cedula correcta", Toast.LENGTH_SHORT).show();

                /*
                *
                    * public Liquor(String productName, String productType, String productMade,
                      String productCategory, int productPrice, String productYear,
                      String productSanitaryRegister, String credentialsClient, int ageClient) {
                    this.productName = productName;
                    this.productType = productType;
                    this.productMade = productMade;
                    this.productCategory = productCategory;
                    this.productPrice = productPrice;
                    this.productYear = productYear;
                    this.productSanitaryRegister = productSanitaryRegister;
                    this.credentialsClient = credentialsClient;
                    this.ageClient = ageClient;
    }
                * */

                /*ProductList.liquorList.add(new Liquor(productName.getText().toString(), productType.getSelectedItem().toString(),
                        productMade.getSelectedItem().toString(), productCategory.getSelectedItem().toString(),
                        Integer.parseInt(productPrice.getText().toString()),productYear.getText().toString(),
                        "YES",value,
                        Integer.parseInt(clientAge.getText().toString())));*/

                ProductList.liquorList.add(new Liquor("Club verde", "Nacional", "Ecuador", "grande",
                        25, "2018", "YES", "0918237421", 28));

                Toast.makeText(this, "Saved successfully", Toast.LENGTH_SHORT).show();
                clearFields(idCredentials, productName, productPrice, productYear, clientAge);

            }else{
                Toast.makeText(this, "Cedula incorrecta", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "The fields cannot be empty", Toast.LENGTH_SHORT).show();
        }




    }

    public void onViewList(View view){

        if (ProductList.liquorList.size() < 1){
            Toast.makeText(this, "The product list it's empty", Toast.LENGTH_SHORT).show();
        }else{

            Toast.makeText(this, ProductList.liquorList.size(), Toast.LENGTH_SHORT).show();
            /*Intent intent = new Intent(MainActivity.this, ListProductsItems.class);
            startActivity(intent);*/
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