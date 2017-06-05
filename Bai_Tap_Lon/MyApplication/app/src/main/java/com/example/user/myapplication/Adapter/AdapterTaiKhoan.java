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

import com.example.user.myapplication.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by user on 21/04/2017.
 */

public class AdapterTaiKhoan extends CursorAdapter {
    public AdapterTaiKhoan(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_customlistview_tai_khoan, parent, false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtName= (TextView) view.findViewById(R.id.txtTai_khoan_ten);
        TextView txtMoney= (TextView) view.findViewById(R.id.txtTien_con_lai);
        ImageView imgTaiKhoan= (ImageView) view.findViewById(R.id.imgTai_khoan);

        txtName.setText(cursor.getString(1));
        txtMoney.setText(cursor.getString(2));

        ByteArrayInputStream stream= new ByteArrayInputStream(cursor.getBlob(3));
        Bitmap bmp= BitmapFactory.decodeStream(stream);
        imgTaiKhoan.setImageBitmap(bmp);

        //txtMoney.setText(cursor.getInt(1));
    }
}
