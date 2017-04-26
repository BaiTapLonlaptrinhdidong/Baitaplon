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

/**
 * Created by user on 24/04/2017.
 */

public class AdapterCursorDanhSachThu extends CursorAdapter {
    public AdapterCursorDanhSachThu(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_customlistview_danh_sach_thu, parent, false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtMoney= (TextView) view.findViewById(R.id.txtMoney_danh_sach_thu);
        TextView txtDienGiai=(TextView) view.findViewById(R.id.txtDiengiai_danh_sach_thu);
        TextView txtSuKien= (TextView) view.findViewById(R.id.txtSuKien_danh_sach_thu);

        ImageView imgThu= (ImageView) view.findViewById(R.id.imgTaiKhoan_danh_sach_thu);

        txtMoney.setText(cursor.getString(1));
        txtDienGiai.setText(cursor.getString(2));
        txtSuKien.setText(cursor.getString(4));

        ByteArrayInputStream stream= new ByteArrayInputStream(cursor.getBlob(3));
        Bitmap bmp= BitmapFactory.decodeStream(stream);
        imgThu.setImageBitmap(bmp);
    }
}
