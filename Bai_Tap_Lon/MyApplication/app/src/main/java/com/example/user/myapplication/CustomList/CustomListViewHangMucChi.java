package com.example.user.myapplication.CustomList;

/**
 * Created by user on 10/04/2017.
 */

public class CustomListViewHangMucChi {

    private String Tieude;
    private int Img;

    public CustomListViewHangMucChi(String tieude, int img) {
        Tieude = tieude;
        Img = img;
    }

    public CustomListViewHangMucChi(String tieude) {
        Tieude = tieude;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }

    public String getTieude() {
        return Tieude;
    }

    public void setTieude(String tieude) {
        Tieude = tieude;
    }
}
