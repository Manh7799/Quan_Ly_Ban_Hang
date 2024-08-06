/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_cuoikhoa_javabase.nguoidung;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import project_cuoikhoa_javabase.DataProvider;

/**
 *
 * @author minhp
 */
public class NguoiDungBusiness {

    public List<NguoiDung> layDanhSachNguoiDung() {
        //Khai bao danh sach
        List<NguoiDung> lstNguoiDung = new ArrayList<>();

        String strSQL = "Select * from qlbanhang.nguoidung";
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
            NguoiDung ObjNguoiDung;
            while (rs.next()) {
                ObjNguoiDung = new NguoiDung();
                ObjNguoiDung.setUserId(rs.getInt("UserId"));
                ObjNguoiDung.setTenDangNhap(rs.getString("TenDangNhap"));
                ObjNguoiDung.setMatKhau(rs.getString("MatKhau"));
                ObjNguoiDung.setHoTen(rs.getString("HoTen"));
                ObjNguoiDung.setEmail(rs.getString("Email"));
                ObjNguoiDung.setDienThoai(rs.getString("DienThoai"));
                ObjNguoiDung.setDiaChi(rs.getString("DiaChi"));
                ObjNguoiDung.setQuyen(rs.getString("Quyen"));
                //Them vao list
                lstNguoiDung.add(ObjNguoiDung);
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

        return lstNguoiDung;
    }

    public boolean kiemTraTenDangNhap(String tenDangNhap) {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean tonTai = false;

        try {

            conn = DataProvider.ketNoi();

            String sql = "SELECT COUNT(*) FROM qlbanhang.nguoidung WHERE TenDangNhap = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tenDangNhap);

            rs = pstmt.executeQuery();

            // Kiểm tra kết quả
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    tonTai = true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi!!!");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Lỗi Kết Nối !!!");
            }
        }

        return tonTai;
    }

    public NguoiDung layThongTinDangNhap(String tenDangNhap) {
        NguoiDung objUser = null;

        String strSQL = "Select UserId, TenDangNhap, MatKhau, HoTen, Quyen  from qlbanhang.nguoidung where TenDangNhap = '" + tenDangNhap + "'";

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
                objUser = new NguoiDung();
                objUser.setUserId(rs.getInt("UserId"));
                objUser.setHoTen(rs.getString("HoTen"));
                objUser.setTenDangNhap(rs.getString("TenDangNhap"));
                objUser.setMatKhau(rs.getString("MatKhau"));
                objUser.setQuyen(rs.getString("Quyen"));

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

        return objUser;

    }

    public List<NguoiDung> timKiem(String tuKhoa) {
        //Khai báo danh sách
        List<NguoiDung> lstNguoiDung = new ArrayList();

        String strSQL = "Select * from qlbanhang.nguoidung where 1 = 1 ";

        if (!tuKhoa.isEmpty() && tuKhoa.length() > 0) {
            strSQL += " AND (TenDangNhap = '" + tuKhoa + "' OR Email like '%" + tuKhoa + "%')";
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
            NguoiDung ObjNguoiDung;
            while (rs.next()) {
                ObjNguoiDung = new NguoiDung();
                ObjNguoiDung.setUserId(rs.getInt("UserId"));
                ObjNguoiDung.setTenDangNhap(rs.getString("TenDangNhap"));
                ObjNguoiDung.setMatKhau(rs.getString("MatKhau"));
                ObjNguoiDung.setHoTen(rs.getString("HoTen"));
                ObjNguoiDung.setEmail(rs.getString("Email"));
                ObjNguoiDung.setDienThoai(rs.getString("DienThoai"));
                ObjNguoiDung.setDiaChi(rs.getString("DiaChi"));
                ObjNguoiDung.setQuyen(rs.getString("Quyen"));
                //Them vao list
                lstNguoiDung.add(ObjNguoiDung);
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

        return lstNguoiDung;
    }

    public NguoiDung layChiTietNguoiDung(String TenDangNhap) {
        NguoiDung objNguoiDung = null;

        String strSQL = "Select * from qlbanhang.nguoidung where UserId = '" + TenDangNhap + "'";
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
                objNguoiDung = new NguoiDung();
                objNguoiDung.setTenDangNhap(rs.getString("TenDangNhap"));
                objNguoiDung.setMatKhau(rs.getString("MatKhau"));
                objNguoiDung.setHoTen(rs.getString("HoTen"));
                objNguoiDung.setEmail(rs.getString("Email"));
                objNguoiDung.setDienThoai(rs.getString("DienThoai"));
                objNguoiDung.setDiaChi(rs.getString("DiaChi"));
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

        return objNguoiDung;
    }

    public boolean themMoi(NguoiDung objND) {
        boolean ketQua = false;
        Connection conn = null;
        conn = DataProvider.ketNoi();
        String strInsert = "Insert into qlbanhang.nguoidung(TenDangNhap, MatKhau, HoTen, Email, DienThoai, DiaChi, Quyen) values(?, ?, ?, ?, ?, ?, ?)";
        try {
            //Khai báo công việc cần thực hiện
            PreparedStatement preStament = conn.prepareStatement(strInsert);
            //Thiết lập giá trị cho các tham số
            preStament.setString(1, objND.getTenDangNhap());
            preStament.setString(2, objND.getMatKhau());
            preStament.setString(3, objND.getHoTen());
            preStament.setString(4, objND.getEmail());
            preStament.setString(5, objND.getDienThoai());
            preStament.setString(6, objND.getDiaChi());
            preStament.setString(7, objND.getQuyen());
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

    public boolean themMoiTaiKhoan(NguoiDung objND) {
        boolean ketQua = false;
        Connection conn = null;
        conn = DataProvider.ketNoi();
        String strInsert = "Insert into qlbanhang.nguoidung(TenDangNhap, MatKhau, Email, Quyen) values(?, ?, ?, ?)";
        try {
            //Khai báo công việc cần thực hiện
            PreparedStatement preStament = conn.prepareStatement(strInsert);
            //Thiết lập giá trị cho các tham số
            preStament.setString(1, objND.getTenDangNhap());
            preStament.setString(2, objND.getMatKhau());
            preStament.setString(3, objND.getEmail());
            preStament.setString(4, objND.getQuyen());

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

    public boolean capNhat(NguoiDung objND) {
        boolean ketQua = false;

        Connection conn = null;

        conn = DataProvider.ketNoi();

        String strUpdate = "Update qlbanhang.nguoidung set MatKhau =?, HoTen =?, Email = ?, DienThoai =?, DiaChi=?, Quyen = ? where TenDangNhap =?";

        try {
            //Khai báo công việc cần thực hiện
            PreparedStatement preStament = conn.prepareStatement(strUpdate);

            //Thiết lập giá trị cho các tham số
            preStament.setString(1, objND.getMatKhau());
            preStament.setString(3, objND.getEmail());
            preStament.setString(2, objND.getHoTen());
            preStament.setString(4, objND.getDienThoai());
            preStament.setString(5, objND.getDiaChi());
            preStament.setString(6, objND.getQuyen());
            preStament.setString(7, objND.getTenDangNhap());

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

    public boolean xoa(String UserId) {
        boolean ketQua = false;
        Connection conn = null;
        conn = DataProvider.ketNoi();
        String strDelete = "Delete from qlbanhang.nguoidung where UserId = '" + UserId + "'";
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

    public NguoiDung layThongTinHienThi(String tenDangNhap) {
        NguoiDung objNguoiDung = null;

        String strSQL = "Select * from qlbanhang.nguoidung where TenDangNhap = '" + tenDangNhap + "'";
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
                objNguoiDung = new NguoiDung();
                objNguoiDung.setTenDangNhap(rs.getString("TenDangNhap"));
                objNguoiDung.setMatKhau(rs.getString("MatKhau"));
                objNguoiDung.setHoTen(rs.getString("HoTen"));
                objNguoiDung.setEmail(rs.getString("Email"));
                objNguoiDung.setDienThoai(rs.getString("DienThoai"));
                objNguoiDung.setDiaChi(rs.getString("DiaChi"));
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

        return objNguoiDung;
    }

    public List<NguoiDung> xemQuyen() {
        //Khai bao danh sach
        List<NguoiDung> lstNguoiDung = new ArrayList<>();

        String strSQL = "Select UserId, TenDangNhap, Quyen from qlbanhang.nguoidung;";
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
            NguoiDung ObjNguoiDung;
            while (rs.next()) {
                ObjNguoiDung = new NguoiDung();
                ObjNguoiDung.setUserId(rs.getInt("UserId"));
                ObjNguoiDung.setTenDangNhap(rs.getString("TenDangNhap"));
                ObjNguoiDung.setQuyen(rs.getString("Quyen"));

                //Them vao list
                lstNguoiDung.add(ObjNguoiDung);
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

        return lstNguoiDung;
    }

    public boolean capNhatQuyen(NguoiDung objND) {
        boolean ketQua = false;

        Connection conn = null;

        conn = DataProvider.ketNoi();

        String strUpdate = "Update qlbanhang.nguoidung set Quyen = ? where UserID = ?";

        try {
            //Khai báo công việc cần thực hiện
            PreparedStatement preStament = conn.prepareStatement(strUpdate);

            //Thiết lập giá trị cho các tham số
            preStament.setString(1, objND.getQuyen());
            preStament.setInt(2, objND.getUserId());

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

    public NguoiDung layChiTietQuyen(String iD) {
        NguoiDung objNguoiDung = null;

        String strSQL = "Select Quyen, TenDangNhap from qlbanhang.nguoidung where UserId = '" + iD + "'";
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
                objNguoiDung = new NguoiDung();
                objNguoiDung.setUserId(rs.getInt("UserID"));
                objNguoiDung.setTenDangNhap(rs.getString("TenDangNhap"));
                objNguoiDung.setQuyen(rs.getString("Quyen"));

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

        return objNguoiDung;
    }
}
