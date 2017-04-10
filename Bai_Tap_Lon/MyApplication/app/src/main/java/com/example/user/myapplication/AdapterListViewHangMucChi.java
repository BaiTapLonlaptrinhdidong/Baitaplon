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

public class AdapterListViewHangMucChi  extends ArrayAdapter {

    private Activity activity;
    private int layout;
    private ArrayList<CustomListViewHangMucChi>  arrayList;

    public AdapterListViewHangMucChi(Activity context, int resource, ArrayList objects) {
        super(context, resource, objects);

        this.activity= context;
        this.layout= resource;
        this.arrayList= objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater= activity.getLayoutInflater();
        convertView= inflater.inflate(R.layout.layout_customlistview_hang_muc_chi, null);

        ImageView imgTitle_hang_muc_chi= (ImageView) convertView.findViewById(R.id.imgTitle_listview_hang_muc_chi);
        ImageView imgListview_hang_muc_chi= (ImageView) convertView.findViewById(R.id.imgListview_hang_muc_chi);

        TextView txtTitle_hang_muc_chi= (TextView) convertView.findViewById(R.id.txtLisview_title_hang_muc_chi);

        CustomListViewHangMucChi custom= arrayList.get(position);

        txtTitle_hang_muc_chi.setText(custom.getTieude());

        return convertView;

    }
}
