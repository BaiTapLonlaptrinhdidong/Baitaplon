package com.example.user.myapplication.DTO;

/**
 * Created by user on 24/04/2017.
 */

public class DanhSachThu {
    private int nId;
    private String nMoney = "";
    private String nDienGiai = "";
    private byte[] nTaiKhoan;
    private String nSuKien = "";
    private String nNgay= "";

    public DanhSachThu(int nId, String nMoney, String nDienGiai, byte[] nTaiKhoan, String nSuKien, String nNgay) {
        this.nId = nId;
        this.nMoney = nMoney;
        this.nDienGiai = nDienGiai;
        this.nTaiKhoan = nTaiKhoan;
        this.nSuKien = nSuKien;
        this.nNgay = nNgay;
    }

    public DanhSachThu(String nMoney, String nDienGiai, byte[] nTaiKhoan, String nSuKien, String nNgay) {
        this.nMoney = nMoney;
        this.nDienGiai = nDienGiai;
        this.nTaiKhoan = nTaiKhoan;
        this.nSuKien = nSuKien;
        this.nNgay = nNgay;
    }

    public DanhSachThu() {
    }

    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    public String getnMoney() {
        return nMoney;
    }

    public void setnMoney(String nMoney) {
        this.nMoney = nMoney;
    }

    public String getnDienGiai() {
        return nDienGiai;
    }

    public void setnDienGiai(String nDienGiai) {
        this.nDienGiai = nDienGiai;
    }

    public byte[] getnTaiKhoan() {
        return nTaiKhoan;
    }

    public void setnTaiKhoan(byte[] nTaiKhoan) {
        this.nTaiKhoan = nTaiKhoan;
    }

    public String getnSuKien() {
        return nSuKien;
    }

    public void setnSuKien(String nSuKien) {
        this.nSuKien = nSuKien;
    }

    public String getnNgay() {
        return nNgay;
    }

    public void setnNgay(String nNgay) {
        this.nNgay = nNgay;
    }
}
