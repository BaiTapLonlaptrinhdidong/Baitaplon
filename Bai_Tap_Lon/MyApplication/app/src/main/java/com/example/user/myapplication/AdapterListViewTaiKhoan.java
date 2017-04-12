package com.example.user.myapplication;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11/04/2017.
 */

public class AdapterListViewTaiKhoan extends ArrayAdapter {

    private Activity activity;
    private int layID;
    private ArrayList<CustomListViewTaiKhoan> arrayList;

    public AdapterListViewTaiKhoan(Activity context, int resource, ArrayList objects) {
        super(context, resource, objects);

        this.activity= context;
        this.layID= resource;
        this.arrayList= objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater= activity.getLayoutInflater();
        convertView= inflater.inflate(R.layout.layout_customlistview_tai_khoan, null);

        EditText editTai_khoan= (EditText) convertView.findViewById(R.id.edtTai_khoan);
        TextView  txtTai_khoan= (TextView) convertView.findViewById(R.id.txtTien_con_lai);

        CustomListViewTaiKhoan custom= arrayList.get(position);

        editTai_khoan.setText(custom.getTentaikhoan());
        txtTai_khoan.setText(custom.getTienconlai());

        return convertView;
    }
}
