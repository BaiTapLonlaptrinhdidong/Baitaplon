package com.example.user.myapplication.DTO;

/**
 * Created by user on 05/06/2017.
 */

public class MothYear {
    private String thang;
    private String nam;

    public MothYear(String thang, String nam) {
        this.thang = thang;
        this.nam = nam;
    }

    public MothYear() {
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }
}
