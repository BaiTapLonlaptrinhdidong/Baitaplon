package com.example.user.myapplication.Modify;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.user.myapplication.Database.DBHelper;

/**
 * Created by user on 05/06/2017.
 */

public class ThongKeModify {
    private DBHelper dbHelper;

    public ThongKeModify(Context context)
    {
        dbHelper= new DBHelper(context);
    }

    public Cursor getMonth()
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor = db.query(DBHelper.getTableNameChi(), new String[]{DBHelper.getKeyIdChi(), DBHelper.getKeyMoneyChi()}, null, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor;
        }
        finally {
            db.close();
        }
    }

    public Cursor getMonthThu()
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            Cursor cursor = db.query(DBHelper.getTableNameThu(), new String[]{DBHelper.getKeyIdThu(), DBHelper.getKeyMoneyThu()}, null, null, null, null, null);
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
