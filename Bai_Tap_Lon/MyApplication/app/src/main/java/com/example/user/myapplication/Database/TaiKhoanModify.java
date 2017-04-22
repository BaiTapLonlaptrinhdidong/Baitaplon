package com.example.user.myapplication.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.user.myapplication.DTO.TaiKhoan;

/**
 * Created by user on 16/04/2017.
 */

public class TaiKhoanModify {
    private DBHelper dbHelper;

    public TaiKhoanModify (Context context)
    {
        dbHelper= new DBHelper(context);
    }

    public Cursor getListTaiKhoan()
    {
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        db.beginTransaction();
        try {
            Cursor cursor= db.query(DBHelper.getTableName(), new String[]{DBHelper.getKeyId(), DBHelper.getKeyName(), DBHelper.getKeyMoney(), DBHelper.getKetImg()},null, null, null, null, null);
            if(cursor!= null)
            {
                cursor.moveToFirst();
            }
            return cursor;
        }
        finally {
            db.endTransaction();
        }

    }
    //thêm
    public void insert(TaiKhoan taiKhoan) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.getKeyName(), taiKhoan.getmName());
        values.put(DBHelper.getKeyMoney(), taiKhoan.getmMoney());
        values.put(DBHelper.getKetImg(), taiKhoan.getmImg());
        db.insert(DBHelper.getTableName(), null, values);
        db.close();
    }
    //xóa
    public void delete(int mId)
    {

        SQLiteDatabase db= dbHelper.getWritableDatabase();
        db.delete(DBHelper.getTableName(), DBHelper.getKeyId() + "=?", new String[]{String.valueOf(mId)});
        db.close();
    }
    //sửa
    public void upDate(TaiKhoan taikhoan)
    {
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values= new ContentValues();

        values.put(DBHelper.getKeyName(), taikhoan.getmName());
        values.put(DBHelper.getKeyMoney(), taikhoan.getmMoney());
        values.put(DBHelper.getKetImg(), taikhoan.getmImg());

        db.update(DBHelper.getTableName(), values, DBHelper.getKeyId()+ "=?",new String[]{String.valueOf(taikhoan.getmId())});
        db.close();
    }

    public TaiKhoan getOneTaiKhoan(int id)
    {
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor= db.query(DBHelper.getTableName(), new String[]{DBHelper.getKeyId(), DBHelper.getKeyName(), DBHelper.getKeyMoney(), DBHelper.getKetImg()}, DBHelper.getKeyId()+ "=?", new String[]{String.valueOf(id)}, null, null, null);
        if(cursor!= null) {
            cursor.moveToFirst();
        }
        return new TaiKhoan(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getBlob(3));
    }
}
