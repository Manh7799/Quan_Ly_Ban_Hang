package project_cuoikhoa_javabase.HangHoa;


import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author minhp
 */
public class HangHoa {

    private String Id;
    private String maHang;
    private String tenHang;
    private String moTa;
    private String giaBan;

    public String getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

   
    
    private String xuatXuId;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getXuatXuId() {
        return xuatXuId;
    }

    public void setXuatXuId(String xuatXuId) {
        this.xuatXuId = xuatXuId;
    }

    public Date getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Date orderNumber) {
        this.orderNumber = orderNumber;
    }
    private Date orderNumber;
}
