package com.example.user.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.myapplication.CustomList.CustomListViewGhiChep;
import com.example.user.myapplication.R;

import java.util.ArrayList;

/**
 * Created by user on 10/04/2017.
 */

public class AdapterListViewGhiChep extends ArrayAdapter {

    private Context context;
    private int LayoutID;
    private ArrayList<CustomListViewGhiChep> arrayList;

    public AdapterListViewGhiChep(Context context, int resource, ArrayList objects) {
        super(context, resource, objects);

        this.context= context;
        this.LayoutID= resource;
        this.arrayList= objects;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView== null)
        {
            viewHolder= new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(LayoutID, null);

            viewHolder.imgTitle_ghi_chep= (ImageView) convertView.findViewById(R.id.imgTitle_listview_ghichep);
            viewHolder.imgGhi_chep=(ImageView) convertView.findViewById(R.id.img_listview_ghichep);

            viewHolder.txtTieu_de= (TextView) convertView.findViewById(R.id.txtTitle_listvew_ghichep);
            viewHolder.txtGiai_thich=(TextView) convertView.findViewById(R.id.txtLisview_chuthich_ghichep);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        CustomListViewGhiChep custom= arrayList.get(position);

        viewHolder.txtTieu_de.setText(custom.getTieude());
        viewHolder.txtGiai_thich.setText(custom.getGiaithich());
        viewHolder.imgTitle_ghi_chep.setImageResource(custom.getImg());

        return convertView;
    }

    private static class ViewHolder{
        ImageView imgTitle_ghi_chep, imgGhi_chep;
        TextView txtTieu_de, txtGiai_thich;
    }
}
