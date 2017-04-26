package com.example.user.myapplication.Modify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.user.myapplication.DTO.DanhSach;
import com.example.user.myapplication.Database.DBHelper;

/**
 * Created by user on 23/04/2017.
 */

public class DanhSachModify {
    private DBHelper dbHelper;

    public DanhSachModify(Context context)
    {
        dbHelper= new DBHelper(context);
    }

    public Cursor getListDanhSach()
    {
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        try {
            Cursor cursor = db.query(DBHelper.getTableNameChi(), new String[]{DBHelper.getKeyIdChi(), DBHelper.getKeyNgayChi()}, null, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        finally {
            db.close();
        }
    }

    public void insertDanhSach(DanhSach danhsach)
    {
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values= new ContentValues();

        values.put(DBHelper.getKeyMoneyChi(), danhsach.getmMoney());
        values.put(DBHelper.getKeyMucchi(), danhsach.getmMucChi());
        values.put(DBHelper.getKeyDiengiaiChi(), danhsach.getmDienGiai());
        values.put(DBHelper.getKeySukienChi(), danhsach.getmSuKien());
        values.put(DBHelper.getKeyNgayChi(), danhsach.getmNgay());
        values.put(DBHelper.getKeyTaikhoanChi(), danhsach.getmTaiKhoan());

        db.insert(DBHelper.getTableNameChi(), null, values);
        db.close();
    }

    public Cursor getOneDate(String date)
    {
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor;
        try {
            cursor = db.query(DBHelper.getTableNameChi(), new String[]{DBHelper.getKeyIdChi(), DBHelper.getKeyMoneyChi(), DBHelper.getKeyMucchi(),
                    DBHelper.getKeyDiengiaiChi(), DBHelper.getKeyTaikhoanChi(), DBHelper.getKeySukienChi(), DBHelper.getKeyNgayChi()}, DBHelper.getKeyNgayChi() + "=?", new String[]{date}, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        finally {
            db.close();
        }
    }
}
