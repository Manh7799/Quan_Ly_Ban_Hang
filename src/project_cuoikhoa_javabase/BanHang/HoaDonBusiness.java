/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_cuoikhoa_javabase.BanHang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import project_cuoikhoa_javabase.DataProvider;
import project_cuoikhoa_javabase.thongtinchung.HoaDonChiTiet;

/**
 *
 * @author minhp
 */
public class HoaDonBusiness {

    public List<HoaDonBan> layDanhSachHoaDonBan() {
        //Khai bao danh sach
        List<HoaDonBan> lstHoaDonBan = new ArrayList<>();

        String strSQL = "Select * from qlbanhang.hoadonban";
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
            HoaDonBan objHoaDonBan;
            while (rs.next()) {
                objHoaDonBan = new HoaDonBan();
                objHoaDonBan.setMaHoaDon(rs.getString("MaHoaDon"));
                objHoaDonBan.setMaKhachHang(rs.getString("MaKhachHang"));
                objHoaDonBan.setSoLuong(rs.getInt("SoLuong"));
                objHoaDonBan.setThanhTien(rs.getInt("ThanhTien"));

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

    public boolean themMoiHoaDonBan(HoaDonBan objHDB) {

        boolean ketQua = false;
        Connection conn = null;
        conn = DataProvider.ketNoi();

        String strInsert = "Insert into qlbanhang.hoadonban (MaHoaDon, MaKhachHang, SoLuong, ThanhTien) values(?, ?, ?, ?)";

        try {
            PreparedStatement preStament = conn.prepareStatement(strInsert);
            //Thiết lập giá trị cho các tham số
            preStament.setString(1, objHDB.getMaHoaDon());
            preStament.setString(2, objHDB.getMaKhachHang());
            preStament.setInt(3, objHDB.getSoLuong());
            preStament.setInt(4, objHDB.getThanhTien());

            //Thực hiện công việc
            ketQua = preStament.executeUpdate() > 0;
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
        return ketQua;
    }

    public boolean xoaHoaDon(String maHD) {
        boolean ketQua = false;
        Connection conn = null;
        conn = DataProvider.ketNoi();
        String strDelete = """
                           DELETE t1, t2 
                           FROM qlbanhang.hoadonbanchitiet t1
                           JOIN qlbanhang.hoadonban t2 ON t1.MaHoaDon = t2.MaHoaDon
                           WHERE t1.MaHoaDon = '""" + maHD + "'";
        try {
            Statement stm = conn.createStatement();
            //Thực hiện công việc
            ketQua = stm.executeUpdate(strDelete) > 0;
        } catch (SQLException ex) {
            System.err.println("lỗi hiển thị !!! Chi tiet: " + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.err.println("Lỗi kết nối !!! Chi tiết: " + ex.getMessage());
            }
        }
        return ketQua;
    }

    public boolean xoaHoaDonChiTiet(String maHD) {
        boolean ketQua = false;
        Connection conn = null;
        conn = DataProvider.ketNoi();
        String strDelete = "Delete from qlbanhang.hoadonbanchitiet where MaHoaDon = '" + maHD + "'";
        try {
            Statement stm = conn.createStatement();
            //Thực hiện công việc
            ketQua = stm.executeUpdate(strDelete) > 0;
        } catch (SQLException ex) {
            System.err.println("lỗi hiển thị !!! Chi tiet: " + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.err.println("Lỗi kết nối !!! Chi tiết: " + ex.getMessage());
            }
        }
        return ketQua;
    }

    public List<HoaDonBan> timKiem(String tuKhoa, String maKhachHang) {
        //Khai báo danh sách
        List<HoaDonBan> lstHoaDonBan = new ArrayList();

        String strSQL = "Select * from qlbanhang.hoadonban where 1 = 1 ";

        if (!tuKhoa.isEmpty() && tuKhoa.length() > 0) {
            strSQL += " AND (MaHoaDon = '" + tuKhoa + "' OR SoLuong like '%" + tuKhoa + "%' OR ThanhTien like '%" + tuKhoa + "%')";
        }

        if (!maKhachHang.isEmpty() && maKhachHang.length() > 0) {
            strSQL += "AND MaKhachHang = '" + maKhachHang + "'";
        }
        //Khai báo kết nối
        Connection conn = null;

        try {

            //Kết nối với db cần làm việc
            conn = DataProvider.ketNoi();

            //Tạo công việc
            Statement stm = conn.createStatement();

            //Thực hiện và trả về kết quả
            ResultSet rs = stm.executeQuery(strSQL);

            HoaDonBan objHoaDonBan;
            while (rs.next()) {
                objHoaDonBan = new HoaDonBan();
                objHoaDonBan.setMaHoaDon(rs.getString("MaHoaDon"));
                objHoaDonBan.setMaKhachHang(rs.getString("MaKhachHang"));
                objHoaDonBan.setSoLuong(rs.getInt("SoLuong"));
                objHoaDonBan.setThanhTien(rs.getInt("ThanhTien"));

                //Thêm vào danh sách
                lstHoaDonBan.add(objHoaDonBan);
            }
        } catch (SQLException ex) {
            System.err.println("Lỗi hiển thị!!!");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                System.err.println("Lỗi Kết Nối !!!");
            }
        }

        return lstHoaDonBan;
    }

    public HoaDonChiTiet layChiTietHoaDon(String maHoaDon, String maKhachHang) {
        HoaDonChiTiet objHoaDon = null;

        String strSQL = "SELECT \n"
                + "    hoadonbanchitiet.MaHoaDon, \n"
                + "    hoadonbanchitiet.MaHang,\n"
                + "    hanghoa.TenHang,\n"
                + "    hoadonban.MaKhachHang, \n"
                + "    hoadonbanchitiet.SoLuong, \n"
                + "    hoadonbanchitiet.DonGia, \n"
                + "    hoadonbanchitiet.XuatXu, \n"
                + "    hoadonbanchitiet.MoTa\n"
                + "FROM \n"
                + "    qlbanhang.hoadonbanchitiet \n"
                + "JOIN \n"
                + "    qlbanhang.hoadonban \n"
                + "ON \n"
                + "    hoadonbanchitiet.MaHoaDon = hoadonban.MaHoaDon\n"
                + "JOIN \n"
                + "    qlbanhang.hanghoa \n"
                + "ON \n"
                + "    hoadonbanchitiet.MaHang = hanghoa.MaHang\n"
                + "WHERE \n"
                + "    hoadonbanchitiet.MaHoaDon = '" + maHoaDon + "'\n"
                + "AND \n"
                + "    hoadonban.MaKhachHang = '" + maKhachHang + "'";
        //Khai báo kết nối
        Connection conn = null;
        try {
            //Kết nối với db cần làm việc
            conn = DataProvider.ketNoi();
            //Tạo công việc
            Statement stm = conn.createStatement();
            //Thực hiện và trả về kết quả
            ResultSet rs = stm.executeQuery(strSQL);
            //Duyệt từng dòng để đưa về object SinhVien
            while (rs.next()) {
                objHoaDon = new HoaDonChiTiet();
                objHoaDon.setMaHoaDon(rs.getString("MaHoaDon"));
                objHoaDon.setMaHang(rs.getString("MaHang"));
                objHoaDon.setTenHang(rs.getString("TenHang"));
                objHoaDon.setMaKhachHang(rs.getString("MaKhachHang"));
                objHoaDon.setSoLuong(rs.getInt("SoLuong"));
                objHoaDon.setDonGia(rs.getInt("DonGia"));
                objHoaDon.setXuatXu(rs.getString("XuatXu"));
                objHoaDon.setMoTa(rs.getString("MoTa"));
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

        return objHoaDon;
    }

}
