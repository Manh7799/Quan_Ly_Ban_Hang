/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_cuoikhoa_javabase.BanHang;

/**
 *
 * @author minhp
 */
public class SanPham {

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    private String tenHang;
    private int soLuong;
    private int gia;

    public SanPham(String tenHang, int soLuong, int gia) {
        this.tenHang = tenHang;
        this.soLuong = soLuong;
        this.gia = gia;
    }

}
