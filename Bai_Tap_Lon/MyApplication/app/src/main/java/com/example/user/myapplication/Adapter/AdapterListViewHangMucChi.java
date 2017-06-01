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

import com.example.user.myapplication.CustomList.CustomListViewHangMucChi;
import com.example.user.myapplication.R;

import java.util.ArrayList;

/**
 * Created by user on 10/04/2017.
 */

public class AdapterListViewHangMucChi  extends ArrayAdapter {

    private Context context;
    private int layout;
    private ArrayList<CustomListViewHangMucChi>  arrayList;

    public AdapterListViewHangMucChi(Activity context, int resource, ArrayList objects) {
        super(context, resource, objects);

        this.context= context;
        this.layout= resource;
        this.arrayList= objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView== null)
        {
            convertView= LayoutInflater.from(context).inflate(layout, null);
            viewHolder= new ViewHolder();

            viewHolder.imgTitle_hang_muc_chi= (ImageView) convertView.findViewById(R.id.imgTitle_listview_hang_muc_chi);
            viewHolder.imgListview_hang_muc_chi= (ImageView) convertView.findViewById(R.id.imgListview_hang_muc_chi);

            viewHolder.txtTitle_hang_muc_chi= (TextView) convertView.findViewById(R.id.txtLisview_title_hang_muc_chi);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        CustomListViewHangMucChi custom= arrayList.get(position);

        viewHolder.txtTitle_hang_muc_chi.setText(custom.getTieude());
        viewHolder.imgTitle_hang_muc_chi.setImageResource(custom.getImg());
        viewHolder.imgListview_hang_muc_chi.setImageResource(R.mipmap.intend);

        return convertView;
    }
    private static class ViewHolder{
        ImageView imgTitle_hang_muc_chi, imgListview_hang_muc_chi;
        TextView txtTitle_hang_muc_chi;
    }
}
