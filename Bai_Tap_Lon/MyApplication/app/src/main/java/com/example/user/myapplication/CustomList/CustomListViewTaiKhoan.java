package com.example.user.myapplication.CustomList;

/**
 * Created by user on 11/04/2017.
 */

public class CustomListViewTaiKhoan {

    private String Tentaikhoan;
    private String Tienconlai;

    public CustomListViewTaiKhoan(String tentaikhoan, String tienconlai) {
        Tentaikhoan = tentaikhoan;
        Tienconlai = tienconlai;
    }

    public String getTentaikhoan() {
        return Tentaikhoan;
    }

    public void setTentaikhoan(String tentaikhoan) {
        Tentaikhoan = tentaikhoan;
    }

    public String getTienconlai() {
        return Tienconlai;
    }

    public void setTienconlai(String tienconlai) {
        Tienconlai = tienconlai;
    }
}
