package com.example.user.myapplication.DTO;

/**
 * Created by user on 21/04/2017.
 */

public class TaiKhoan {
    private int mId;
    private String mName;
    private String mMoney;
    private byte[] mImg;

    public TaiKhoan(int mId, String mName, String mMoney, byte[] mImg) {
        this.mId = mId;
        this.mName = mName;
        this.mMoney = mMoney;
        this.mImg = mImg;
    }

    public TaiKhoan(String mName, String mMoney, byte[] mImg) {
        this.mName = mName;
        this.mMoney = mMoney;
        this.mImg = mImg;
    }

    public TaiKhoan(String mName, String mMoney) {
        this.mName = mName;
        this.mMoney = mMoney;
    }

    public TaiKhoan() {
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmMoney() {
        return mMoney;
    }

    public void setmMoney(String mMoney) {
        this.mMoney = mMoney;
    }

    public byte[] getmImg() {
        return mImg;
    }

    public void setmImg(byte[] mImg) {
        this.mImg = mImg;
    }
}
