package com.example.user.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
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

    private Context context;
    private int layoutId;
    private ArrayList<CustomSpinnerHangMuc> arrayList;

    public AdapterSpinnerHangMuc(Context context, int layout, ArrayList<CustomSpinnerHangMuc> arrayList) {
        this.context = context;
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
        ViewHolder viewHolder;
        if(convertView== null)
        {
            convertView= LayoutInflater.from(context).inflate(layoutId, null);
            viewHolder= new ViewHolder();

            viewHolder.txtTenHangmuc=(TextView) convertView.findViewById(R.id.txtTen_hang_muc);
            viewHolder.imgHang_muc= (ImageView) convertView.findViewById(R.id.imgIcon_hang_muc);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        CustomSpinnerHangMuc custom= arrayList.get(position);

        viewHolder.txtTenHangmuc.setText(custom.getTenHangMuc());
        viewHolder.imgHang_muc.setImageResource(custom.getImg());

        return convertView;
    }

    private static class ViewHolder{
        TextView txtTenHangmuc;
        ImageView imgHang_muc;
    }
}
