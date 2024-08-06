/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_cuoikhoa_javabase.QuocGia;

import project_cuoikhoa_javabase.QuocGia.QuocGia;
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
            //Lấy đối tượng khoa
            QuocGia objKhoa = (QuocGia)value;
            //Hiển thị lại nội dung
            setText(objKhoa.getTenQuocGia());
        }
        
        setHorizontalAlignment(SwingConstants.CENTER);
        
        return this;
    }
}
