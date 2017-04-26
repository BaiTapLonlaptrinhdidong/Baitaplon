package com.example.user.myapplication.DTO;

/**
 * Created by user on 23/04/2017.
 */

public class DanhSach {
    private int mId;
    private String mMoney = "";
    private String mMucChi = "";
    private String mDienGiai = "";
    private byte[] mTaiKhoan;
    private String mSuKien = "";
    private String mNgay= "";

    public DanhSach(int mId, String mMoney, String mMucChi, String mDienGiai, byte[] mTaiKhoan, String mNgay, String mSuKien) {
        this.mId = mId;
        this.mMoney = mMoney;
        this.mMucChi = mMucChi;
        this.mDienGiai = mDienGiai;
        this.mTaiKhoan = mTaiKhoan;
        this.mNgay = mNgay;
        this.mSuKien = mSuKien;
    }

    public DanhSach(String mMoney, String mMucChi, String mDienGiai, String mSuKien, byte[] mTaiKhoan, String mNgay) {
        this.mMoney = mMoney;
        this.mMucChi = mMucChi;
        this.mDienGiai = mDienGiai;
        this.mSuKien = mSuKien;
        this.mTaiKhoan = mTaiKhoan;
        this.mNgay = mNgay;
    }

    public DanhSach() {
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmMoney() {
        return mMoney;
    }

    public void setmMoney(String mMoney) {
        this.mMoney = mMoney;
    }

    public String getmMucChi() {
        return mMucChi;
    }

    public void setmMucChi(String mMucChi) {
        this.mMucChi = mMucChi;
    }

    public String getmDienGiai() {
        return mDienGiai;
    }

    public void setmDienGiai(String mDienGiai) {
        this.mDienGiai = mDienGiai;
    }

    public byte[] getmTaiKhoan() {
        return mTaiKhoan;
    }

    public void setmTaiKhoan(byte[] mTaiKhoan) {
        this.mTaiKhoan = mTaiKhoan;
    }

    public String getmSuKien() {
        return mSuKien;
    }

    public void setmSuKien(String mSuKien) {
        this.mSuKien = mSuKien;
    }

    public String getmNgay() {
        return mNgay;
    }

    public void setmNgay(String mNgay) {
        this.mNgay = mNgay;
    }
}
