/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_cuoikhoa_javabase.BanHang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import project_cuoikhoa_javabase.DataProvider;
import project_cuoikhoa_javabase.HangHoa.HangHoa;
/**
 *
 * @author minhp
 */
public class SanPhamBusiness {
       private List<HangHoa> lstHangHoa = new ArrayList<>();
    
    public List<HangHoa> layDanhSach(){
        //Khai bao danh sach
        List<HangHoa> lstHangHoa = new ArrayList<>();
        
        String strSQL = "SELECT * FROM qlbanhang.sanpham;";
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
            while(rs.next()){
                objHangHoa = new HangHoa();
                objHangHoa.setTenHang(rs.getString("TenHang"));
                objHangHoa.setMoTa(rs.getString("SoLuong"));
                objHangHoa.setGiaBan(rs.getString("Gia"));
                
                //Them vao list
                lstHangHoa.add(objHangHoa);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi!!!");
        } finally{
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Lỗi Kết Nối !!!");
            }
        }
        
        return lstHangHoa;
    }
    
    public boolean themMoi(SanPham objSP)
    {
        boolean ketQua = false;
        
        Connection conn = null;
        
        conn = DataProvider.ketNoi();
        
        String strInsert = "Insert into qlbanhang.sanpham(TenHang, SoLuong, Gia) values(?, ?, ?)";
        
        try {
            //Khai báo công việc cần thực hiện
            PreparedStatement preStament = conn.prepareStatement(strInsert);
            
            //Thiết lập giá trị cho các tham số
            preStament.setString(1, objSP.getTenHang());
            preStament.setInt(2, objSP.getSoLuong());
            preStament.setInt(3, objSP.getGia());
            
            //Thực hiện công việc
            ketQua = preStament.executeUpdate() > 0;
            
        } catch (SQLException ex) {
           System.err.println("lỗi hiển thị !!! Chi tiet: " + ex.getMessage());
        }
        finally{
        try {
                if(conn!= null){
                    conn.close();
                }
            
            } catch (SQLException ex) {
               System.err.println("lỗi Kết Nối !!! Chi tiet: " + ex.getMessage());
            }
        }      
        
        return ketQua;
    }
}
