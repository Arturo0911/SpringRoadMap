package com.example.springclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.springclient.properties.Liquor;
import com.example.springclient.properties.ProductList;

import java.util.ArrayList;

public class ListProductsItems extends Activity {

    private ListView listItemsProduct;
    private ListProductCustomized listProductCustomized;
    Intent intentCustomized;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_product_items);
        listItemsProduct = (ListView) findViewById(R.id.listItemsProduct);
        //ArrayList<Liquor> liquorsListed = ProductList.liquorList;
        //liquorsListed = ProductList.liquorList;

        try{
            listProductCustomized = new ListProductCustomized(this, ProductList.liquorList);
            listItemsProduct.setAdapter(listProductCustomized);
        }catch (Exception e ){
            e.printStackTrace();
            Toast.makeText(this, "Someting happend", Toast.LENGTH_SHORT).show();
        }

    }


    public void returnMain(View view){
        Intent intent = new Intent(ListProductsItems.this, MainActivity.class);
        startActivity(intent);
    }


}
