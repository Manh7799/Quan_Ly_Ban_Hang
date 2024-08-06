/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_cuoikhoa_javabase.thongtinchung;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import project_cuoikhoa_javabase.DataProvider;

/**
 *
 * @author minhp
 */
public class HoaDonChiTietKhachHangBusiness {

    private List<HoaDonChiTietKhachHang> lstSinhVien = new ArrayList();
    
    public List<HoaDonChiTietKhachHang> layDanhSachHoaDon() {
        //Khai bao danh sach
        List<HoaDonChiTietKhachHang> lstHoaDonBan = new ArrayList<>();

        String strSQL = """
                        SELECT 
                                                    hoadonbanchitiet.MaHoaDon, 
                                                    hoadonbanchitiet.MaHang,
                                                    hanghoa.TenHang,
                                                    hoadonbanchitiet.SoLuong, 
                                                    hoadonbanchitiet.DonGia, 
                                                    hoadonbanchitiet.XuatXu, 
                                                    hoadonbanchitiet.MoTa
                                                FROM 
                                                    qlbanhang.hoadonbanchitiet 
                                                JOIN 
                                                    qlbanhang.hoadonban 
                                                ON 
                                                    hoadonbanchitiet.MaHoaDon = hoadonban.MaHoaDon
                                                JOIN 
                                                    qlbanhang.hanghoa 
                                                ON 
                                                    hoadonbanchitiet.MaHang = hanghoa.MaHang
                                                JOIN 
                                                qlbanhang.khachhang
                                                ON
                                                hoadonbanchitiet.TenKhachHang = khachhang.TenKhachHang""";
        //Khai bao ket noi
        Connection conn = null;

        try {
            //Kết nối data cần lm vc
            conn = DataProvider.ketNoi();

            //Tao cong viec
            Statement stm = conn.createStatement();

            //Thuc hien tra ve ket qua
            ResultSet rs = stm.executeQuery(strSQL);

            //Duyet tung dong de dua ve object HangHoa
            HoaDonChiTietKhachHang objHoaDonBan;
            while (rs.next()) {
                objHoaDonBan = new HoaDonChiTietKhachHang();
                objHoaDonBan.setMaHoaDon(rs.getString("hoadonbanchitiet.MaHoaDon"));
                objHoaDonBan.setMaKhachHang(rs.getString("hoadonbanchitiet.MaHang"));
                objHoaDonBan.setTenKhachHang(rs.getString("hanghoa.TenHang"));
                objHoaDonBan.setSoLuong(rs.getInt("hoadonbanchitiet.SoLuong"));
                objHoaDonBan.setDonGia(rs.getInt(" hoadonbanchitiet.DonGia"));
                objHoaDonBan.setDiaChi(rs.getString("hoadonbanchitiet.XuatXu"));
                objHoaDonBan.setMoTa(rs.getString("hoadonbanchitiet.MoTa"));

                //Them vao list
                lstHoaDonBan.add(objHoaDonBan);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi!!! Chi tiết: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Lỗi Kết Nối !!!");
            }
        }

        return lstHoaDonBan;
    }
    
    public HoaDonChiTietKhachHang layChiTietKhachHang(String maKhachHang, String maHoaDon) {
        //Khai báo biến
        HoaDonChiTietKhachHang objKH = null;
        String strSQL = """
                        Select hoadonban.MaHoaDon, hoadonban.MaKhachHang, TenKhachHang, DienThoai, DiaChi, hoadonban.SoLuong, hoadonban.ThanhTien
                        from qlbanhang.khachhang, qlbanhang.hoadonban where hoadonban.MaHoaDon = '""" + maHoaDon + "' and khachhang.MaKhachHang = '" + maKhachHang + "'";
        //Khai báo kết nối
        Connection conn = null;
        try {
            //Kết nối với db cần làm việc
            conn = DataProvider.ketNoi();
            //Tạo công việc
            Statement stm = conn.createStatement();
            //Thực hiện và trả về kết quả
            ResultSet rs = stm.executeQuery(strSQL);
            //Duyệt từng dòng để đưa về object ChuyenKhoa
            while (rs.next()) {
                objKH = new HoaDonChiTietKhachHang();
                objKH.setMaHoaDon(rs.getString("hoadonban.MaHoaDon"));
                objKH.setMaKhachHang(rs.getString("hoadonban.MaKhachHang"));
                objKH.setTenKhachHang(rs.getString("TenKhachHang"));
                objKH.setDienThoai(rs.getString("DienThoai"));
                objKH.setDiaChi(rs.getString("DiaChi"));
                objKH.setSoLuong(rs.getInt("hoadonban.SoLuong"));
                objKH.setThanhTien(rs.getInt("hoadonban.ThanhTien"));

            }
        } catch (SQLException ex) {
            System.err.println("Lỗi hiển thị !!! Chi tiết: " + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.err.println("Lỗi kết nối !!!");
            }
        }
        return objKH;
    }    

   public List<HoaDonChiTietKhachHang> layChiTietHoaDon(String maHoaDon) {
        List<HoaDonChiTietKhachHang> danhSachChiTiet = new ArrayList<>();

        String strInsert = """
                        SELECT 
                            hoadonbanchitiet.MaHoaDon, 
                            hoadonbanchitiet.MaHang,
                            hanghoa.TenHang,
                            hoadonbanchitiet.SoLuong, 
                            hoadonbanchitiet.DonGia, 
                            hoadonbanchitiet.XuatXu, 
                            hoadonbanchitiet.MoTa
                        FROM 
                            qlbanhang.hoadonbanchitiet 
                        JOIN 
                            qlbanhang.hoadonban 
                        ON 
                            hoadonbanchitiet.MaHoaDon = hoadonban.MaHoaDon
                        JOIN 
                            qlbanhang.hanghoa 
                        ON 
                            hoadonbanchitiet.MaHang = hanghoa.MaHang
                        JOIN 
                        \t qlbanhang.khachhang
                        ON
                        \t hoadonbanchitiet.TenKhachHang = khachhang.TenKhachHang
                        WHERE 
                            hoadonbanchitiet.MaHoaDon = '""" + maHoaDon + "'";
        //Khai báo kết nối
        Connection conn = null;
        conn = DataProvider.ketNoi();
        
        try {
            PreparedStatement preStament = conn.prepareStatement(strInsert);
            
//            preStament.setString(1, maHoaDon);

            try (ResultSet rs = preStament.executeQuery()) {
                while (rs.next()) {
                    HoaDonChiTietKhachHang chiTiet = new HoaDonChiTietKhachHang();
                    chiTiet.setMaHang(rs.getString("MaHang"));
                    chiTiet.setTenHang(rs.getString("TenHang"));
                    chiTiet.setSoLuong(rs.getInt("SoLuong"));
                    chiTiet.setDonGia(rs.getInt("DonGia"));
                    chiTiet.setXuatXu(rs.getString("XuatXu"));
                    chiTiet.setMoTa(rs.getString("MoTa"));

                    danhSachChiTiet.add(chiTiet);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Lỗi hiển thị !!! Chi tiết: " + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Lỗi kết nối !!!");
            }
        }

        return danhSachChiTiet;
    }
   
    public static void main(String[] args) {
        HoaDonChiTietKhachHang hoadon = new HoaDonChiTietKhachHang();
        
        System.err.println("" + hoadon.getTenKhachHang());
    }
}
