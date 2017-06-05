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
    private String mThang= "";
    private String mNam= "";

    public DanhSach(String mMoney, String mMucChi, String mDienGiai, byte[] mTaiKhoan, String mSuKien, String mNgay, String mThang, String mNam) {
        this.mMoney = mMoney;
        this.mMucChi = mMucChi;
        this.mDienGiai = mDienGiai;
        this.mTaiKhoan = mTaiKhoan;
        this.mSuKien = mSuKien;
        this.mNgay = mNgay;
        this.mThang = mThang;
        this.mNam = mNam;
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

    public String getmThang() {
        return mThang;
    }

    public void setmThang(String mThang) {
        this.mThang = mThang;
    }

    public String getmNam() {
        return mNam;
    }

    public void setmNam(String mNam) {
        this.mNam = mNam;
    }
}
