/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_cuoikhoa_javabase.KhachHang;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author minhp
 */
public class Render extends BasicComboBoxRenderer{
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, 
            int index, boolean isSelected, boolean cellHasFocus) {
        
        
        if(value != null)
        {
            //Lấy đối tượng 
            KhachHang objKH = (KhachHang)value;
            //Hiển thị lại nội dung
            setText(objKH.getTenKhachHang());
        }
        
        setHorizontalAlignment(SwingConstants.CENTER);
        
        return this;
        
    }
}


