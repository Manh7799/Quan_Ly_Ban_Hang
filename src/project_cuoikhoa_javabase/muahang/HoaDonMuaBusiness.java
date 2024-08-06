/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_cuoikhoa_javabase.muahang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import project_cuoikhoa_javabase.DataProvider;

/**
 *
 * @author minhp
 */
public class HoaDonMuaBusiness {

    public List<HoaDonMuaChiTiet> layDanhSachHoaDonBan() {
        //Khai bao danh sach
        List<HoaDonMuaChiTiet> lstHoaDonMua = new ArrayList<>();

        String strSQL = "Select * from qlbanhang.hoadonmuachitiet";
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
            HoaDonMuaChiTiet objHoaDonMua;
            while (rs.next()) {
                objHoaDonMua = new HoaDonMuaChiTiet();
                objHoaDonMua.setMaHoaDon(rs.getString("MaHoaDon"));
                objHoaDonMua.setMaKhachHang(rs.getString("MaHang"));
                objHoaDonMua.setSoLuong(rs.getInt("SoLuong"));
                objHoaDonMua.setDonGia(rs.getInt("DonGia"));
                objHoaDonMua.setNgayMua(rs.getDate("NgayMua"));
                objHoaDonMua.setXuatXu(rs.getString("XuatXu"));
                objHoaDonMua.setMoTa(rs.getString("MoTa"));

                //Them vao list
                lstHoaDonMua.add(objHoaDonMua);
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

        return lstHoaDonMua;
    }

    public List<HoaDonMua> danhSachHoaDonMua() {
        //Khai bao danh sach
        List<HoaDonMua> lstHoaDonMua = new ArrayList<>();

        String strSQL = "Select * from qlbanhang.hoadonmua";
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
            HoaDonMua objHoaDonMua;
            while (rs.next()) {
                objHoaDonMua = new HoaDonMua();
                objHoaDonMua.setMaHoaDon(rs.getString("MaHoaDon"));
                objHoaDonMua.setSoLuong(rs.getInt("SoLuong"));
                objHoaDonMua.setNgayMua(rs.getDate("NgayMua"));
                objHoaDonMua.setTongTien(rs.getInt("TongTien"));

                //Them vao list
                lstHoaDonMua.add(objHoaDonMua);
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

        return lstHoaDonMua;
    }

    public boolean themMoiHoaDonBan(HoaDonMua objHDB) {

        boolean ketQua = false;
        Connection conn = null;
        conn = DataProvider.ketNoi();

        String strInsert = "Insert into qlbanhang.hoadonmua (MaHoaDon, SoLuong, NgayMua, TongTien) values(?, ?, ?, ?)";

        try {
            PreparedStatement preStament = conn.prepareStatement(strInsert);
            //Thiết lập giá trị cho các tham số
            preStament.setString(1, objHDB.getMaHoaDon());
            preStament.setInt(2, objHDB.getSoLuong());
            preStament.setDate(3, new Date(objHDB.getNgayMua().getTime()));
            preStament.setInt(4, objHDB.getTongTien());

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
    
    public List<HoaDonMua> timKiem(String tuKhoa) {
        //Khai báo danh sách
        List<HoaDonMua> lstHoaDonMua = new ArrayList();

        String strSQL = "Select * from qlbanhang.hoadonmua where 1 = 1 ";

        if (!tuKhoa.isEmpty() && tuKhoa.length() > 0) {
            strSQL += " AND (MaHoaDon = '" + tuKhoa + "' OR SoLuong like '%" + tuKhoa + "%' OR TongTien like '%" + tuKhoa + "%')";
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

            HoaDonMua objHoaDonMua;
            while (rs.next()) {
                objHoaDonMua = new HoaDonMua();
                objHoaDonMua.setMaHoaDon(rs.getString("MaHoaDon"));
                objHoaDonMua.setSoLuong(rs.getInt("SoLuong"));
                objHoaDonMua.setNgayMua(rs.getDate("NgayMua"));
                objHoaDonMua.setTongTien(rs.getInt("TongTien"));

                //Thêm vào danh sách
                lstHoaDonMua.add(objHoaDonMua);
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

        return lstHoaDonMua;
    }
    
    public boolean xoaHoaDon(String maHD) {
        boolean ketQua = false;
        Connection conn = null;
        conn = DataProvider.ketNoi();
        String strDelete = """
                           DELETE t1, t2 
                           FROM qlbanhang.hoadonmuachitiet t1
                           JOIN qlbanhang.hoadonmua t2 ON t1.MaHoaDon = t2.MaHoaDon
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
}
