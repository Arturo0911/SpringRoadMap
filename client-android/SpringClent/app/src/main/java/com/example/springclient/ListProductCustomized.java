package com.example.springclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.example.springclient.properties.Liquor;

import java.util.ArrayList;

public class ListProductCustomized extends BaseAdapter {

    private EditText productNameSet;
    private EditText productTypeSet;
    private EditText productMadeSet;

    private Context context;
    private ArrayList<Liquor> liquorSets;

    public ListProductCustomized(Context context,ArrayList<Liquor> liquorSets ){
        this.context = context;
        this.liquorSets = liquorSets;
    }

    @Override
    public int getCount() {
        return liquorSets.size();
    }

    @Override
    public Object getItem(int position) {
        return liquorSets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_product_customized, null);
        }

        productNameSet = (EditText) convertView.findViewById(R.id.productNameSet);
        productTypeSet = (EditText) convertView.findViewById(R.id.productTypeSet);
        productMadeSet = (EditText) convertView.findViewById(R.id.productMadeSet);

        productNameSet.setText(liquorSets.get(position).getProductName());
        productTypeSet.setText(liquorSets.get(position).getProductType());
        productMadeSet.setText(liquorSets.get(position).getProductMade());

        return convertView;

    }
}
