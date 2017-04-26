package com.example.user.myapplication.CustomList;

/**
 * Created by user on 10/04/2017.
 */

public class CustomSpinnerHangMuc {

    private String TenHangMuc;
    private int Img;

    public CustomSpinnerHangMuc(String tenHangMuc, int img) {
        TenHangMuc = tenHangMuc;
        Img = img;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }

    public CustomSpinnerHangMuc(String tenHangMuc) {
        TenHangMuc = tenHangMuc;
    }

    public String getTenHangMuc() {
        return TenHangMuc;
    }

    public void setTenHangMuc(String tenHangMuc) {
        TenHangMuc = tenHangMuc;
    }
}
