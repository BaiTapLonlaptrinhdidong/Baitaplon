package com.example.user.myapplication;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 10/04/2017.
 */

public class AdapterListViewGhiChep extends ArrayAdapter {

    private Activity activity;
    private int LayoutID;
    private ArrayList<CustomListViewGhiChep> arrayList;

    public AdapterListViewGhiChep(Activity context, int resource, ArrayList objects) {
        super(context, resource, objects);

        this.activity= context;
        this.LayoutID= resource;
        this.arrayList= objects;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater= activity.getLayoutInflater();
        convertView= layoutInflater.inflate(R.layout.layout_customlistview_ghi_chep, null);

        ImageView imgTitle_ghi_chep= (ImageView) convertView.findViewById(R.id.imgTitle_listview_ghichep);
        ImageView imgGhi_chep=(ImageView) convertView.findViewById(R.id.img_listview_ghichep);

        TextView txtTieu_de= (TextView) convertView.findViewById(R.id.txtTitle_listvew_ghichep);
        TextView txtGiai_thich=(TextView) convertView.findViewById(R.id.txtLisview_chuthich_ghichep);

        CustomListViewGhiChep custom= arrayList.get(position);

        txtTieu_de.setText(custom.getTieude().toString());
        txtGiai_thich.setText(custom.getGiaithich().toString());


        return convertView;
    }
}
