package com.JSH.ChasquillApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MasterAdapter extends ArrayAdapter<String> {

    public MasterAdapter(Context context, ArrayList<String> masters) {
        super(context, 0, masters);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String masterName=getItem(position);

        if (convertView==null) {
            convertView=LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);
        }

        TextView textViewMasterName=convertView.findViewById(android.R.id.text1);
        textViewMasterName.setText(masterName);

        return convertView;
    }
}