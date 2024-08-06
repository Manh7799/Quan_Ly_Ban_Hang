/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_cuoikhoa_javabase.HangHoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import project_cuoikhoa_javabase.DataProvider;

/**
 *
 * @author minhp
 */
public class HangHoaBusiness {

    public List<HangHoa> layDanhSach() {
        //Khai bao danh sach
        List<HangHoa> lstHangHoa = new ArrayList<>();

        String strSQL = "Select MaHang, TenHang, MoTa, GiaBan, XuatXuId from qlbanhang.hanghoa";
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
            HangHoa objHangHoa;
            while (rs.next()) {
                objHangHoa = new HangHoa();
                objHangHoa.setMaHang(rs.getString("MaHang"));
                objHangHoa.setTenHang(rs.getString("TenHang"));
                objHangHoa.setMoTa(rs.getString("MoTa"));
                objHangHoa.setGiaBan(rs.getString("GiaBan"));
                objHangHoa.setXuatXuId(rs.getString("XuatXuId"));

                //Them vao list
                lstHangHoa.add(objHangHoa);
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

        return lstHangHoa;
    }

    public HangHoa layChiTiet(String maHang) {
        HangHoa objHangHoa = null;

        String strSQL = "Select * from qlbanhang.hanghoa where MaHang = '" + maHang + "'";
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
                objHangHoa = new HangHoa();
                objHangHoa.setMaHang(rs.getString("MaHang"));
                objHangHoa.setTenHang(rs.getString("TenHang"));
                objHangHoa.setMoTa(rs.getString("MoTa"));
                objHangHoa.setGiaBan(rs.getString("GiaBan"));
                objHangHoa.setXuatXuId(rs.getString("XuatXuId"));
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

    public boolean themMoi(HangHoa objHangHoa) {
        boolean ketQua = false;

        Connection conn = null;
        conn = DataProvider.ketNoi();

        String strThemMoi = "Insert into qlbanhang.hanghoa(MaHang, TenHang, MoTa, GiaBan, XuatXuId) values(?, ?, ?, ?, ?)";
        try {
            //Khai báo công việc cần thực hiện
            PreparedStatement preStament = conn.prepareStatement(strThemMoi);
            //Thiết lập giá trị cho các tham số
            preStament.setString(1, objHangHoa.getMaHang());
            preStament.setString(2, objHangHoa.getTenHang());
            preStament.setString(3, objHangHoa.getMoTa());
            preStament.setString(4, objHangHoa.getGiaBan());
            preStament.setString(5, objHangHoa.getXuatXuId());
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

    public boolean suaDoi(HangHoa objHangHoa) {
        boolean ketQua = false;

        Connection conn = null;
        conn = DataProvider.ketNoi();

        String strUpdate = "Update qlbanhang.hanghoa set TenHang = ?, MoTa = ?,GiaBan = ?, XuatXuId = ? where MaHang = ?";
        try {
            //Khai báo công việc cần thực hiện
            PreparedStatement preStament = conn.prepareStatement(strUpdate);
            //Thiết lập giá trị cho các tham số
            preStament.setString(1, objHangHoa.getTenHang());
            preStament.setString(2, objHangHoa.getMoTa());
            preStament.setString(3, objHangHoa.getGiaBan());
            preStament.setString(4, objHangHoa.getXuatXuId());
            preStament.setString(5, objHangHoa.getMaHang());

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

    public boolean xoa(String maHang) {
        boolean ketQua = false;
        Connection conn = null;
        conn = DataProvider.ketNoi();
        String strDelete = "Delete from qlbanhang.hanghoa where MaHang = '" + maHang + "'";
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

    public List<HangHoa> timKiem(String tuKhoa, String quocGia) {
        //Khai báo danh sách
        List<HangHoa> lstHangHoa = new ArrayList();

        String strSQL = "Select MaHang, TenHang, GiaBan, XuatXuId from qlbanhang.hanghoa where 1 = 1 ";

        if (!tuKhoa.isEmpty() && tuKhoa.length() > 0) {
            strSQL += " AND (MaHang = '" + tuKhoa + "' OR TenHang like '%" + tuKhoa + "%' OR GiaBan like '%" + tuKhoa + "%')";
        }

        if (!quocGia.isEmpty() && quocGia.length() > 0) {
            strSQL += "AND XuatXuId = '" + quocGia + "'";
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

            //Duyệt từng dòng để đưa về object HangHoa
            HangHoa objHH;
            while (rs.next()) {
                objHH = new HangHoa();
                objHH.setMaHang(rs.getString("MaHang"));
                objHH.setTenHang(rs.getString("TenHang"));
                objHH.setGiaBan(rs.getString("GiaBan"));
                objHH.setXuatXuId(rs.getString("XuatXuId"));

                //Thêm vào danh sách
                lstHangHoa.add(objHH);
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

        return lstHangHoa;
    }
}
