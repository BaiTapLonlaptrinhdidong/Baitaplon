package com.example.user.myapplication.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.myapplication.CustomList.CustomSpinnerHangMuc;
import com.example.user.myapplication.R;

import java.util.ArrayList;

/**
 * Created by user on 10/04/2017.
 */

public class AdapterSpinnerHangMuc extends BaseAdapter {

    private Activity activity;
    private int layoutId;
    private ArrayList<CustomSpinnerHangMuc> arrayList;

    public AdapterSpinnerHangMuc(Activity activity, int layout, ArrayList<CustomSpinnerHangMuc> arrayList) {
        this.activity = activity;
        this.layoutId = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater= activity.getLayoutInflater();
        convertView= layoutInflater.inflate(R.layout.layout_custom_hang_muc, null);

        TextView txtTenHangmuc=(TextView) convertView.findViewById(R.id.txtTen_hang_muc);
        ImageView imgHang_muc= (ImageView) convertView.findViewById(R.id.imgIcon_hang_muc);

        CustomSpinnerHangMuc custom= arrayList.get(position);

        txtTenHangmuc.setText(custom.getTenHangMuc().toString());
        imgHang_muc.setImageResource(custom.getImg());

        return convertView;
    }
}
