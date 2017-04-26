package com.example.user.myapplication.CustomList;

/**
 * Created by user on 10/04/2017.
 */

public class CustomListViewGhiChep {

    private String tieude;
    private String giaithich;
    private int img;

    public CustomListViewGhiChep(String tieude, String giaithich, int img) {
        this.tieude = tieude;
        this.giaithich = giaithich;
        this.img = img;
    }

    public CustomListViewGhiChep(String tieude, String giaithich) {
        this.tieude = tieude;
        this.giaithich = giaithich;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
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
