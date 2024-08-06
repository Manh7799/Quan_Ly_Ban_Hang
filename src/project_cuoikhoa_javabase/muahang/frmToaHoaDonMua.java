/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project_cuoikhoa_javabase.muahang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project_cuoikhoa_javabase.DataProvider;
import project_cuoikhoa_javabase.HangHoa.HangHoa;
import project_cuoikhoa_javabase.HangHoa.HangHoaBusiness;
import project_cuoikhoa_javabase.QuocGia.QuocGia;
import project_cuoikhoa_javabase.QuocGia.QuocGiaBusiness;

/**
 *
 * @author minhp
 */
public class frmToaHoaDonMua extends javax.swing.JFrame {

    /**
     * Creates new form frmToaHoaDonMua
     */
    public frmToaHoaDonMua() {
        initComponents();

        initTableModel();

        this.setLocationRelativeTo(null);
    }

    private DefaultTableModel tableModel;
    private int tongSoLuong = 0;
    private double tongSoTien = 0.0;

    private void initTableModel() {
        tableModel = new DefaultTableModel(new String[]{"Mã hóa đơn", "Mã hàng", "Số lượng", "Đơn giá", "Ngày mua", "Xuất xứ", "Mô Tả"}, 0);
        tblHoaDon.setModel(tableModel);
    }

    private String maHangHoa = "";
    private String maHoaDon = "";

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaHangHoa() {
        return maHangHoa;
    }

    public void setMaHangHoa(String maHangHoa) {
        this.maHangHoa = maHangHoa;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING:
     * Do NOT modify this code. The content of this method is always regenerated by the
     * Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        txtTimKiem = new javax.swing.JTextField();
        cboChon = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHangHoa = new javax.swing.JTable();
        TimKiem = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaHang = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnThemSanPham = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnThemHoaDon = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        btnTaiLai = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        lblThanhTien = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dateNgayMua = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextField();
        txtXuatXu = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        jLabel3.setText("Danh sách sản phẩm:");

        tblHangHoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã hàng", "Tên hàng", "Giá ", "Mô tả"
            }
        ));
        tblHangHoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHangHoaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHangHoa);

        TimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_cuoikhoa_javabase/Images/ZoomHS.png"))); // NOI18N
        TimKiem.setText("Tìm Kiếm");
        TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemActionPerformed(evt);
            }
        });

        btnLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_cuoikhoa_javabase/Images/renew.png"))); // NOI18N
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_cuoikhoa_javabase/Images/delete.png"))); // NOI18N
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(TimKiem)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTimKiem)
                            .addComponent(cboChon, 0, 147, Short.MAX_VALUE))
                        .addGap(26, 26, 26))))
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimKiem))
                .addGap(18, 18, 18)
                .addComponent(cboChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn mua hàng"));

        jLabel1.setText("Mã Hàng:");

        jLabel4.setText("Số lượng:");

        jLabel5.setText("Giá mua:");

        jLabel7.setText("Mô tả:");

        btnThemSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_cuoikhoa_javabase/Images/add-icon.png"))); // NOI18N
        btnThemSanPham.setText("Thêm sản phẩm");
        btnThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPhamActionPerformed(evt);
            }
        });

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Mã hàng", "Khách hàng", "Số lượng", "Đơn giá", "Xuất xứ", "Mô tả"
            }
        ));
        jScrollPane4.setViewportView(tblHoaDon);

        btnThemHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_cuoikhoa_javabase/Images/register.gif"))); // NOI18N
        btnThemHoaDon.setText("Thanh toán");
        btnThemHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHoaDonActionPerformed(evt);
            }
        });

        jLabel6.setText("Mã hóa đơn:");

        btnTaiLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project_cuoikhoa_javabase/Images/renew.png"))); // NOI18N
        btnTaiLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiLaiActionPerformed(evt);
            }
        });

        jLabel9.setText("Bảng danh sách sản phẩm: ");

        jLabel10.setText("Thành tiền:");

        lblThanhTien.setText("0");

        jLabel12.setText("Ngày mua:");

        jLabel13.setText("Xuất xứ:");

        jLabel11.setText("Số lượng mặt hàng:");

        lblSoLuong.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(txtGiaBan)
                            .addComponent(txtMaHang)
                            .addComponent(txtSoLuong))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel7))
                        .addGap(18, 32, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnTaiLai, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThemSanPham))
                            .addComponent(txtXuatXu, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateNgayMua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(txtMoTa)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(lblThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThemHoaDon)
                        .addContainerGap())))
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(dateNgayMua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(txtXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTaiLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThemSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblThanhTien)
                    .addComponent(lblSoLuong)
                    .addComponent(btnThemHoaDon)
                    .addComponent(jLabel11))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void tblHangHoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHangHoaMouseClicked

        List<HangHoa> lstHangHoa = DataProvider.getHangHoaBus().layDanhSach();
        int selectedIndex;
        selectedIndex = tblHangHoa.getSelectedRow();
        HangHoa hh = lstHangHoa.get(selectedIndex);
        txtMaHang.setText(hh.getMaHang());
        txtGiaBan.setText(hh.getGiaBan());
        txtXuatXu.setText(hh.getXuatXuId());

    }//GEN-LAST:event_tblHangHoaMouseClicked

    private void TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemActionPerformed
        // TODO add your handling code here:
        hienThiDanhSachHangHoa();
    }//GEN-LAST:event_TimKiemActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
        hienThiDanhSachHangHoa();

    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPhamActionPerformed

        String maHoaDon = txtMaHoaDon.getText().trim();
        String maHang = txtMaHang.getText().trim();
        String soLuongText = txtSoLuong.getText().trim();
        String donGiaText = txtGiaBan.getText().trim();
        String mota = txtMoTa.getText().trim();
        String xuatXu = txtXuatXu.getText().trim();
        Date date = dateNgayMua.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


        if (maHoaDon.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Không được để trống mã hóa đơn!");
            txtMaHoaDon.requestFocus();
            return;
        }

        if (maHang.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Không được để trống mã hàng!");
            txtMaHang.requestFocus();
            return;
        }

        if (soLuongText.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Không được để trống số lượng!");
            txtSoLuong.requestFocus();
            return;
        }

        if (donGiaText.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Không được để trống đơn giá!");
            txtGiaBan.requestFocus();
            return;
        }

        if (mota.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập mô tả!");
            txtMoTa.requestFocus();
            return;
        }

        if (xuatXu.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Không được để trống xuất xứ!");
            txtXuatXu.requestFocus();
            return;
        }

        if (date == null) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn ngày mua!");
            dateNgayMua.requestFocus();
            return;
        }


        int soLuong;
        double donGia;

        try {
            soLuong = Integer.parseInt(soLuongText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Số lượng phải là một số nguyên!");
            txtSoLuong.requestFocus();
            return;
        }

        try {
            donGia = Double.parseDouble(donGiaText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Đơn giá phải là một số!");
            txtGiaBan.requestFocus();
            return;
        }

        double thanhTien = soLuong * donGia;
        String ngayMuaFormatted = dateFormat.format(date);

        NumberFormat numberFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
        String soLuongFormatted = numberFormat.format(soLuong);
        String donGiaFormatted = numberFormat.format(donGia);
        String thanhTienFormatted = numberFormat.format(thanhTien);

        tableModel.addRow(new Object[]{maHoaDon, maHang, soLuongFormatted, donGiaFormatted, ngayMuaFormatted, xuatXu, mota});

        txtMaHang.setText("");
        txtSoLuong.setText("");
        txtGiaBan.setText("");
        txtMoTa.setText("");
        txtXuatXu.setText("");

        try {
            tongSoLuong += numberFormat.parse(soLuongFormatted).intValue();
        } catch (ParseException ex) {
            System.err.println("Lỗi tính toán. Chi tiết: " + ex.getMessage());
        }

        tongSoTien += thanhTien;

        lblSoLuong.setText(numberFormat.format(tongSoLuong));
        lblThanhTien.setText(numberFormat.format(tongSoTien));

    }//GEN-LAST:event_btnThemSanPhamActionPerformed

    private void btnThemHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHoaDonActionPerformed
        String maHD = "", maHang = "", maKhachHang = "";
        int soLuong = 0;
        double thanhTien = 0.0;

        maHD = txtMaHoaDon.getText();
        maHang = txtMaHang.getText();

        if (maHD.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Không được để trống mã hóa đơn!");
            txtMaHoaDon.requestFocus();
            return;
        }
        
        if (maHang.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Không được để trống mã hàng!");
            txtMaHang.requestFocus();
            return;
        }
        
        // Định dạng số
        NumberFormat numberFormat = NumberFormat.getInstance(new Locale("vi", "VN"));

        try {
            soLuong = numberFormat.parse(lblSoLuong.getText()).intValue();
            thanhTien = numberFormat.parse(lblThanhTien.getText()).doubleValue();
        } catch (ParseException ex) {
            System.err.println("Lỗi chuyển đổi số: " + ex.getMessage());
            return;
        }

        HoaDonMua objHoaDonBan = new HoaDonMua();

        objHoaDonBan.setMaHoaDon(maHD);
        objHoaDonBan.setNgayMua(dateNgayMua.getDate());
        objHoaDonBan.setSoLuong(soLuong);
        objHoaDonBan.setTongTien((int) thanhTien);

        boolean ketQua;

        HoaDonMuaBusiness HDM = new HoaDonMuaBusiness();

        ketQua = HDM.themMoiHoaDonBan(objHoaDonBan);

        try {
            themMoi();

        } catch (ParseException ex) {
            System.err.println("Thêm thất bại!!! Chi tiết: " + ex.getMessage());
        }

        lblThanhTien.setText("");
        lblSoLuong.setText("");
        tongSoLuong = 0;
        tongSoTien = 0;
    }//GEN-LAST:event_btnThemHoaDonActionPerformed

    private void btnTaiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiLaiActionPerformed

        resetTable();
        txtMaHang.setText("");
        txtSoLuong.setText("");
        txtGiaBan.setText("");
        txtMoTa.setText("");
        txtMaHoaDon.setText("");
        lblSoLuong.setText("");
        lblThanhTien.setText("");
        txtXuatXu.setText("");
    }//GEN-LAST:event_btnTaiLaiActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        hienThiDanhSachQuocGia();

        hienThiDanhSachHangHoa();

    }//GEN-LAST:event_formWindowOpened

    public boolean themMoi() throws ParseException {
        boolean ketQua = false;

        Connection conn = null;
        conn = DataProvider.ketNoi();

        String strThem = "INSERT INTO qlbanhang.hoadonmuachitiet (MaHoaDon, MaHang, SoLuong, DonGia, NgayMua, XuatXu, MoTa) VALUES (?, ?, ?, ?,?,?,?)";
        try {
            //Khai báo công việc cần thực hiện
            PreparedStatement preStament = conn.prepareStatement(strThem);
            //Thiết lập giá trị cho các tham số
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String maHD = (String) tableModel.getValueAt(i, 0);
                String maHang = (String) tableModel.getValueAt(i, 1);
                int soLuong = Integer.parseInt(tableModel.getValueAt(i, 2).toString().replace(".", ""));
                double donGia = Double.parseDouble(tableModel.getValueAt(i, 3).toString().replace(".", ""));

                String ngayMua = (String) tableModel.getValueAt(i, 4);
                String xuatXu = (String) tableModel.getValueAt(i, 5);
                String moTa = (String) tableModel.getValueAt(i, 6);

                // Chuyển đổi định dạng ngày mua
                SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy"); // định dạng gốc
                SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd"); // định dạng SQL
                Date date = originalFormat.parse(ngayMua);
                String formattedDate = targetFormat.format(date);

                preStament.setString(1, maHD);
                preStament.setString(2, maHang);
                preStament.setInt(3, soLuong);
                preStament.setDouble(4, donGia);
                preStament.setString(5, formattedDate);
                preStament.setString(6, xuatXu);
                preStament.setString(7, moTa);

                preStament.addBatch();
            }

            preStament.executeBatch();
            JOptionPane.showMessageDialog(this, "Thanh toán thành công!");

            resetTable();

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

    private void resetTable() {
        // Xóa tất cả các hàng trong table model
        tableModel.setRowCount(0);
    }

    private void hienThiDanhSachQuocGia() {
        QuocGiaBusiness chuyenKhoaBusiness = new QuocGiaBusiness();

        //Lấy danh sách
        List<QuocGia> lstQuocGia = chuyenKhoaBusiness.layDanhSach();

        QuocGia root = new QuocGia();

        root.setMaQuocGia("");
        root.setTenQuocGia("Chọn quốc gia");
        lstQuocGia.add(0, root);

        DefaultComboBoxModel model = new DefaultComboBoxModel();

        //Đuyệt để thêm vào model
        for (QuocGia objQuocGia : lstQuocGia) {
            model.addElement(objQuocGia);
        }

        //Render lại thông tin hiển thị lên combobox
        cboChon.setRenderer(new project_cuoikhoa_javabase.QuocGia.Render());

        cboChon.setModel(model);
    }

    public static void hienThiDanhSachHangHoa() {
        String tuKhoa = "", quocGia = "";

        tuKhoa = txtTimKiem.getText();

        QuocGia objQuocGia = (QuocGia) cboChon.getSelectedItem();

        if (objQuocGia != null) {
            quocGia = objQuocGia.getMaQuocGia();
        }

        //Khai Bao Tieu De
        String tieuDe[] = new String[]{"Mã hàng", "Tên hàng", "Giá Bán", "Xuất xứ id "};

        //Khai báo 1 đối tượng để phục vụ hiển thị lên table
        DefaultTableModel model = new DefaultTableModel(tieuDe, 0);

        HangHoaBusiness hangHoaBusiness = new HangHoaBusiness();

        //Lay danh sach hang hoa
        List<HangHoa> lstHangHoa = hangHoaBusiness.timKiem(tuKhoa, quocGia);

        Object row[];

        //Duyet tung dong
        for (HangHoa hh : lstHangHoa) {
            row = new Object[4];

            //Gan gia tri
            row[0] = hh.getMaHang();
            row[1] = hh.getTenHang();
            row[2] = hh.getGiaBan();
            row[3] = hh.getXuatXuId();

            //Them vao model
            model.addRow(row);
        }

        tblHangHoa.setModel(model);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmToaHoaDonMua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmToaHoaDonMua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmToaHoaDonMua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmToaHoaDonMua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmToaHoaDonMua().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TimKiem;
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnTaiLai;
    private javax.swing.JButton btnThemHoaDon;
    private javax.swing.JButton btnThemSanPham;
    private static javax.swing.JComboBox<String> cboChon;
    private com.toedter.calendar.JDateChooser dateNgayMua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblThanhTien;
    private static javax.swing.JTable tblHangHoa;
    private static javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMaHang;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSoLuong;
    private static javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtXuatXu;
    // End of variables declaration//GEN-END:variables
}