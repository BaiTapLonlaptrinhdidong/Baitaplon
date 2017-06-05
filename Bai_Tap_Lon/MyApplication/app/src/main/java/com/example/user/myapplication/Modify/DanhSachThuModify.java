package com.example.user.myapplication.Modify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.user.myapplication.DTO.DanhSach;
import com.example.user.myapplication.DTO.DanhSachThu;
import com.example.user.myapplication.Database.DBHelper;

/**
 * Created by user on 24/04/2017.
 */

public class DanhSachThuModify {
    private DBHelper dbHelper;

    public DanhSachThuModify(Context context)
    {
        dbHelper= new DBHelper(context);
    }

    public Cursor getListDanhSachThu()
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor = db.query(DBHelper.getTableNameThu(), new String[]{DBHelper.getKeyIdChi(), DBHelper.getKeyNgayThu()}, null, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        finally {
            db.close();
        }
    }

    public void insertDanhSachThu(DanhSachThu danhsachthu)
    {
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values= new ContentValues();

        values.put(DBHelper.getKeyMoneyThu(), danhsachthu.getnMoney());
        values.put(DBHelper.getKeyDiengiaiThu(), danhsachthu.getnDienGiai());
        values.put(DBHelper.getKeySukienThu(), danhsachthu.getnSuKien());
        values.put(DBHelper.getKeyNgayThu(), danhsachthu.getnNgay());
        values.put(DBHelper.getKeyTaikhoanThu(), danhsachthu.getnTaiKhoan());
        values.put(DBHelper.getKeyThangThu(), danhsachthu.getnThang());
        values.put(DBHelper.getKeyNamThu(), danhsachthu.getnNam());

        db.insert(DBHelper.getTableNameThu(), null, values);
        db.close();
    }

    public Cursor getOneDate(String date)
    {
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        try {
            Cursor cursor = db.query(DBHelper.getTableNameThu(), new String[]{DBHelper.getKeyIdThu(), DBHelper.getKeyMoneyThu(),
                    DBHelper.getKeyDiengiaiThu(), DBHelper.getKeyTaikhoanThu(), DBHelper.getKeySukienThu(), DBHelper.getKeyNgayThu()}, DBHelper.getKeyNgayThu() + "=?", new String[]{date}, null, null, null);
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
