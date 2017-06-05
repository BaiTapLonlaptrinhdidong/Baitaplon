package com.example.user.myapplication.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 14/04/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 22;
    private static final String DATABASE_NAME = "myDatabase";

    private static final String TABLE_NAME = "taikhoan";

    private static final String KEY_ID = "_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_MONEY = "money";
    private static final String KET_IMG= "img";

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getKeyId() {
        return KEY_ID;
    }

    public static String getKeyName() {
        return KEY_NAME;
    }

    public static String getKeyMoney() {
        return KEY_MONEY;
    }

    public static String getKetImg() {
        return KET_IMG;
    }

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String TABLE_NAME_CHI= "danhsachchi";

    private static final String KEY_ID_CHI= "_id";
    private static final String KEY_MONEY_CHI= "moneychi";
    private static final String KEY_MUCCHI= "mucchi";
    private static final String KEY_DIENGIAI_CHI= "diengiai";
    private static final String KEY_TAIKHOAN_CHI= "taikhoan";
    private static final String KEY_SUKIEN_CHI= "sukien";
    private static final String KEY_NGAY_CHI= "date";
    private static final String KEY_THANG_CHI= "month";
    private static final String KEY_NAM_CHI= "year";

    public static String getTableNameChi() {
        return TABLE_NAME_CHI;
    }

    public static String getKeyIdChi() {
        return KEY_ID_CHI;
    }

    public static String getKeyMoneyChi() {
        return KEY_MONEY_CHI;
    }

    public static String getKeyMucchi() {
        return KEY_MUCCHI;
    }

    public static String getKeyDiengiaiChi() {
        return KEY_DIENGIAI_CHI;
    }

    public static String getKeyTaikhoanChi() {
        return KEY_TAIKHOAN_CHI;
    }

    public static String getKeySukienChi() {
        return KEY_SUKIEN_CHI;
    }

    public static String getKeyNgayChi() {
        return KEY_NGAY_CHI;
    }

    public static String getKeyNamChi() {
        return KEY_NAM_CHI;
    }

    public static String getKeyThangChi() {
        return KEY_THANG_CHI;
    }

    private static final String TABLE_NAME_THU= "danhsachthu";

    private static final String KEY_ID_THU= "_id";
    private static final String KEY_MONEY_THU= "moneythu";
    private static final String KEY_DIENGIAI_THU= "diengiai";
    private static final String KEY_TAIKHOAN_THU= "taikhoan";
    private static final String KEY_SUKIEN_THU= "sukien";
    private static final String KEY_NGAY_THU= "date";
    private static final String KEY_THANG_THU="moth";
    private static final String KEY_NAM_THU= "year";

    public static String getTableNameThu() {
        return TABLE_NAME_THU;
    }

    public static String getKeyIdThu() {
        return KEY_ID_THU;
    }

    public static String getKeyMoneyThu() {
        return KEY_MONEY_THU;
    }

    public static String getKeyDiengiaiThu() {
        return KEY_DIENGIAI_THU;
    }

    public static String getKeyTaikhoanThu() {
        return KEY_TAIKHOAN_THU;
    }

    public static String getKeySukienThu() {
        return KEY_SUKIEN_THU;
    }

    public static String getKeyNgayThu() {
        return KEY_NGAY_THU;
    }

    public static String getKeyThangThu() {
        return KEY_THANG_THU;
    }

    public static String getKeyNamThu() {
        return KEY_NAM_THU;
    }

    //tao bảng
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_TAIKHOAN = "CREATE TABLE " + TABLE_NAME + " ("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME + " TEXT,"
                + KEY_MONEY + " TEXT,"
                + KET_IMG + " BOLB)";
        db.execSQL(CREATE_TABLE_TAIKHOAN);

        String CREATE_TABLE_DANHSACH = "CREATE TABLE " + TABLE_NAME_CHI + " ("
                + KEY_ID_CHI + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_MONEY_CHI + " TEXT,"
                + KEY_MUCCHI + " TEXT,"
                + KEY_DIENGIAI_CHI + " TEXT,"
                + KEY_TAIKHOAN_CHI + " BOLB,"
                + KEY_SUKIEN_CHI + " TEXT,"
                + KEY_NGAY_CHI + " TEXT,"
                + KEY_THANG_CHI + " TEXT,"
                + KEY_NAM_CHI + " TEXT)";
        db.execSQL(CREATE_TABLE_DANHSACH);

        String CREATE_TABLE_DANHSACH_THU = "CREATE TABLE " + TABLE_NAME_THU + " ("
                + KEY_ID_THU + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_MONEY_THU + " TEXT,"
                + KEY_DIENGIAI_THU + " TEXT,"
                + KEY_TAIKHOAN_THU + " BOLB,"
                + KEY_SUKIEN_THU + " TEXT,"
                + KEY_NGAY_THU + " TEXT,"
                + KEY_THANG_THU + " TEXT,"
                +KEY_NAM_THU + " TEXT)";
        db.execSQL(CREATE_TABLE_DANHSACH_THU);
    }
    // tạo lại bảng
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_CHI);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_THU);
        onCreate(db);
    }
}
