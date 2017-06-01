package com.example.user.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
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

    private Context context;
    private int layID;
    private ArrayList<CustomListViewTaiKhoan> arrayList;

    public AdapterListViewTaiKhoan(Context context, int resource, ArrayList<CustomListViewTaiKhoan> objects) {
        super(context, resource, objects);

        this.context= context;
        this.layID= resource;
        this.arrayList= objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView== null)
        {
            convertView= LayoutInflater.from(context).inflate(layID, null);
            viewHolder= new ViewHolder();

            viewHolder.txtTai_khoan_ten= (TextView) convertView.findViewById(R.id.txtTai_khoan_ten);
            viewHolder.txtTai_khoan= (TextView) convertView.findViewById(R.id.txtTien_con_lai);
            convertView.setTag(convertView);
        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        CustomListViewTaiKhoan custom= arrayList.get(position);

        viewHolder.txtTai_khoan_ten.setText(custom.getTentaikhoan());
        viewHolder.txtTai_khoan.setText(custom.getTienconlai());

        return convertView;
    }

    private static class ViewHolder {

        TextView txtTai_khoan_ten,  txtTai_khoan;
    }
}
