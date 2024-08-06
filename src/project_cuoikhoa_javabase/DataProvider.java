/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_cuoikhoa_javabase;

import java.sql.*;
import java.sql.Connection;
import project_cuoikhoa_javabase.BanHang.HoaDonBusiness;
import project_cuoikhoa_javabase.HangHoa.HangHoaBusiness;
import project_cuoikhoa_javabase.KhachHang.KhachHangBusiness;
import project_cuoikhoa_javabase.nguoidung.NguoiDungBusiness;
import project_cuoikhoa_javabase.thongtinchung.HoaDonChiTietKhachHang;
import project_cuoikhoa_javabase.thongtinchung.HoaDonChiTietKhachHangBusiness;

/**
 *
 * @author minhp
 */
public class DataProvider {
    //Khai báo driver mysql cần làm việc
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //Khai báo db cần làm việc
    private static final String DATABASE_LINK = "jdbc:mysql://localhost:3306/j042401cb?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false"; 

   /**
     * Hàm kết nối đến db cần làm việc
     * @return 
     */
    public static Connection ketNoi()
    {
        Connection conn = null;
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DATABASE_LINK, "root", "manh2811");
        } catch (ClassNotFoundException ex) {
            System.err.println("Không tìm thấy driver của MySQL cần dùng. Chi tiết: " + ex.getMessage());
        } catch (SQLException ex) {
            System.err.println("Có lỗi xảy ra khi thực hiện trong MySQL. Chi tiết: " + ex.getMessage());
        }
        return conn;
    }
    
    private static HangHoaBusiness hangHoaBus = null;

    public static HangHoaBusiness getHangHoaBus() {
        if (hangHoaBus == null) {
            hangHoaBus = new HangHoaBusiness();
        }

        return hangHoaBus;
    }
    
    private static KhachHangBusiness khbuss = null;

    public static KhachHangBusiness getKhachHangBus() {
        if (khbuss == null) {
            khbuss = new KhachHangBusiness();
        }

        return khbuss;
    }
    
    private static HoaDonBusiness hdbuss = null;
    
    public static HoaDonBusiness getHoaDonBusiness(){
        if (hdbuss == null) {
            hdbuss = new HoaDonBusiness();
        }
        
        return hdbuss;
    }
    
    private static NguoiDungBusiness ndbuss = null;
    public static NguoiDungBusiness getNguoiDungBusiness(){
        if (ndbuss == null) {
            ndbuss = new NguoiDungBusiness();
        }
        return ndbuss;
    }
    
    private static HoaDonChiTietKhachHangBusiness HDCTBuss = null;
    public static HoaDonChiTietKhachHangBusiness getHoaDonChiTietKhachHangBusiness(){
        if (HDCTBuss == null) {
            HDCTBuss = new HoaDonChiTietKhachHangBusiness();
        }
        return HDCTBuss;
    }
}
