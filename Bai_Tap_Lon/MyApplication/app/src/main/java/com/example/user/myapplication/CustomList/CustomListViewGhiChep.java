package com.example.user.myapplication.CustomList;

/**
 * Created by user on 10/04/2017.
 */

public class CustomListViewGhiChep {

    private String tieude;
    private String giaithich;

    public CustomListViewGhiChep(String tieude, String giaithich) {
        this.tieude = tieude;
        this.giaithich = giaithich;
    }

    public String getGiaithich() {
        return giaithich;
    }

    public void setGiaithich(String giaithich) {
        this.giaithich = giaithich;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }
}
