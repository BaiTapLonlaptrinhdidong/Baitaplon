package com.example.user.myapplication.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.user.myapplication.R;

/**
 * Created by user on 24/04/2017.
 */

public class AdapterSpinnerDanhSachThu extends CursorAdapter {
    public AdapterSpinnerDanhSachThu(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_customspinner_danhsach, null);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtDateThu= (TextView) view.findViewById(R.id.txtSpnDate_danh_sach);

        txtDateThu.setText(cursor.getString(1));
    }
}
