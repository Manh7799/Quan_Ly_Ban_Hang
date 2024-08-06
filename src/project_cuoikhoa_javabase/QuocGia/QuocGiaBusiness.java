/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_cuoikhoa_javabase.QuocGia;

import project_cuoikhoa_javabase.QuocGia.QuocGia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import project_cuoikhoa_javabase.DataProvider;

/**
 *
 * @author minhp
 */
public class QuocGiaBusiness {

    public List<QuocGia> layDanhSach() {
        //Khai báo danh sách
        List<QuocGia> lstKhoa = new ArrayList();
        String strSQL = "Select MaQuocGia, TenQuocGia from qlbanhang.quocgia";
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
            QuocGia objqQuocGia;
            while (rs.next()) {
                objqQuocGia = new QuocGia();
                objqQuocGia.setMaQuocGia(rs.getString("MaQuocGia"));
                objqQuocGia.setTenQuocGia(rs.getString("TenQuocGia"));
                //Thêm vào danh sách
                lstKhoa.add(objqQuocGia);
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
        return lstKhoa;
    }

    public QuocGia layChiTietKhoa(String maQuocGia) {
        //Khai báo biến
        QuocGia objKhoa = null;
        String strSQL = "Select MaQuocGia, TenQuocGia from  qlbanhang.quocgia where MaQuocGia ='" + maQuocGia + "'";
        //Khai báo kết nối
        Connection conn = null;
        try {
            //Kết nối với db cần làm việc
            conn = DataProvider.ketNoi();
            //Tạo công việc
            Statement stm = conn.createStatement();
            //Thực hiện và trả về kết quả
            ResultSet rs = stm.executeQuery(strSQL);
            //Duyệt từng dòng để đưa về object QuocGia
            while (rs.next()) {
                objKhoa = new QuocGia();
                objKhoa.setMaQuocGia(rs.getString("MaQuocGia"));
                objKhoa.setTenQuocGia(rs.getString("TenQuocGia"));
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
        return objKhoa;
    }
}
