/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_cuoikhoa_javabase.KhachHang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import project_cuoikhoa_javabase.DataProvider;

/**
 *
 * @author minhp
 */
public class KhachHangBusiness {

    public List<KhachHang> layDanhSach() {
        //Khai bao danh sach
        List<KhachHang> lstKhachHang = new ArrayList<>();

        String strSQL = "Select * from qlbanhang.khachhang";
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
            KhachHang objHangHoa;
            while (rs.next()) {
                objHangHoa = new KhachHang();
                objHangHoa.setMaKhachHang(rs.getString("MaKhachHang"));
                objHangHoa.setTenKhachHang(rs.getString("TenKhachHang"));
                objHangHoa.setGioiTinh(rs.getInt("GioiTinh"));
                objHangHoa.setNgaySinh(rs.getDate("NgaySinh"));
                objHangHoa.setDienThoai(rs.getString("DienThoai"));
                objHangHoa.setDiaChi(rs.getString("DiaChi"));

                //Them vao list
                lstKhachHang.add(objHangHoa);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi!!!");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Lỗi Kết Nối !!!");
            }
        }

        return lstKhachHang;
    }

    public KhachHang layChiTiet(String maKhachHang) {
        KhachHang objHangHoa = null;

        String strSQL = "Select * from qlbanhang.khachhang where MaKhachHang = '" + maKhachHang + "'";
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
                objHangHoa = new KhachHang();
                objHangHoa.setMaKhachHang(rs.getString("MaKhachHang"));
                objHangHoa.setTenKhachHang(rs.getString("TenKhachHang"));
                objHangHoa.setGioiTinh(rs.getInt("GioiTinh"));
                objHangHoa.setNgaySinh(rs.getDate("NgaySinh"));
                objHangHoa.setDienThoai(rs.getString("DienThoai"));
                objHangHoa.setDiaChi(rs.getString("DiaChi"));
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

        return objHangHoa;
    }

    public boolean themMoi(KhachHang objKhachHang) {
        boolean ketQua = false;

        Connection conn = null;
        conn = DataProvider.ketNoi();

        String strThemMoi = "Insert into qlbanhang.khachhang(MaKhachHang, TenKhachHang, GioiTinh, NgaySinh, DienThoai, DiaChi) values(?, ?, ?, ?, ?, ?)";
        try {
            //Khai báo công việc cần thực hiện
            PreparedStatement preStament = conn.prepareStatement(strThemMoi);
            //Thiết lập giá trị cho các tham số
            preStament.setString(1, objKhachHang.getMaKhachHang());
            preStament.setString(2, objKhachHang.getTenKhachHang());
            preStament.setInt(3, objKhachHang.getGioiTinh());
            preStament.setDate(4, new Date(objKhachHang.getNgaySinh().getTime()));
            preStament.setString(5, objKhachHang.getDienThoai());
            preStament.setString(6, objKhachHang.getDiaChi());
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

    public boolean suaDoi(KhachHang objKhachHang) {
        boolean ketQua = false;

        Connection conn = null;
        conn = DataProvider.ketNoi();

        String strUpdate = "Update qlbanhang.khachhang set TenKhachHang = ?, GioiTinh = ?,NgaySinh = ?, DienThoai = ?, DiaChi = ? where MaKhachHang = ?";
        try {
            //Khai báo công việc cần thực hiện
            PreparedStatement preStament = conn.prepareStatement(strUpdate);
            //Thiết lập giá trị cho các tham số
            preStament.setString(1, objKhachHang.getTenKhachHang());
            preStament.setInt(2, objKhachHang.getGioiTinh());
            preStament.setDate(3, new Date(objKhachHang.getNgaySinh().getTime()));
            preStament.setString(4, objKhachHang.getDienThoai());
            preStament.setString(5, objKhachHang.getDiaChi());
            preStament.setString(6, objKhachHang.getMaKhachHang());

            //Thực hiện công việc
            ketQua = preStament.executeUpdate() > 0;
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

    public boolean xoa(String maKhachHang) {
        boolean ketQua = false;
        Connection conn = null;
        conn = DataProvider.ketNoi();
        String strDelete = "Delete from qlbanhang.khachhang where MaKhachHang = '" + maKhachHang + "'";
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
