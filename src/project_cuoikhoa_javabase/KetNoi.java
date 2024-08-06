/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_cuoikhoa_javabase;

import java.sql.SQLException;

/**
 *
 * @author minhp
 */
public class KetNoi {
    public static void main(String[] args) {
        try {
            if(!DataProvider.ketNoi().isClosed()){
                System.out.println("Ket noi den MySQL thanh cong !!!");
            }} catch (SQLException ex) {
            System.out.println("Loi. Chi tiet: " + ex.getMessage());
        }
    }
}
