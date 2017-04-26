package com.example.user.myapplication.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.myapplication.DTO.DanhSach;
import com.example.user.myapplication.R;

import java.io.ByteArrayInputStream;

/**
 * Created by user on 23/04/2017.
 */

public class AdapterCursorDanhSachChi extends CursorAdapter{
    public AdapterCursorDanhSachChi(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_customlistview_danh_sach, parent, false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtMoney= (TextView) view.findViewById(R.id.txtMoney_danh_sach);
        TextView txtMucChi= (TextView) view.findViewById(R.id.txtMucchi_danh_sach);
        TextView txtDienGiai=(TextView) view.findViewById(R.id.txtDiengiai_danh_sach);
        TextView txtSuKien= (TextView) view.findViewById(R.id.txtSuKien_danh_sach);

        ImageView imgChi= (ImageView) view.findViewById(R.id.imgTaiKhoan_danh_sach);

        txtMoney.setText(cursor.getString(1));
        txtMucChi.setText(cursor.getString(2));
        txtDienGiai.setText(cursor.getString(3));
        txtSuKien.setText(cursor.getString(5));

        ByteArrayInputStream stream= new ByteArrayInputStream(cursor.getBlob(4));
        Bitmap bmp= BitmapFactory.decodeStream(stream);
        imgChi.setImageBitmap(bmp);
    }
}
