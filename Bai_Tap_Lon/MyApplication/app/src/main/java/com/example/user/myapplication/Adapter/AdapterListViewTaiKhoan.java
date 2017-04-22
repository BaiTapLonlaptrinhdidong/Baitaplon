package com.example.user.myapplication.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.myapplication.CustomList.CustomListViewTaiKhoan;
import com.example.user.myapplication.R;

import java.util.ArrayList;

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

        TextView txtTai_khoan_ten= (TextView) convertView.findViewById(R.id.txtTai_khoan_ten);
        TextView  txtTai_khoan= (TextView) convertView.findViewById(R.id.txtTien_con_lai);

        CustomListViewTaiKhoan custom= arrayList.get(position);

        txtTai_khoan_ten.setText(custom.getTentaikhoan());
        txtTai_khoan.setText(custom.getTienconlai());

        return convertView;
    }
}
