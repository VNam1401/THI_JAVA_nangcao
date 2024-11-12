/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.SanPham;

/**
 *
 * @author ADMIN
 */
public class SanPhamDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<SanPham> getTop6() {
        ArrayList<SanPham> ds = new ArrayList();
        String sql = "select top 6 * from SanPham order by NgayCapNhat desc";
        conn = new DbContext().getConnection();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
               ds.add(new SanPham(rs.getInt(1),rs.getString(2),rs.getDouble(3),
                       rs.getString(4),rs.getInt(5),rs.getDate(6)));
            }
        } catch (Exception ex) {
            System.out.println("Loi SQL:" + ex.toString());
        }
        return ds;
    }
    
     public ArrayList<SanPham> Laychude(int maloai) {
        ArrayList<SanPham> ds = new ArrayList();
        String sql = "select * from SanPham where MaLoai=?";
        conn = new DbContext().getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, maloai);
            rs = ps.executeQuery();
            while(rs.next())
            {
               ds.add(new SanPham(rs.getInt(1),rs.getString(2),rs.getDouble(3),
                       rs.getString(4),rs.getInt(5),rs.getDate(6)));
            }
        } catch (Exception ex) {
            System.out.println("Loi SQL:" + ex.toString());
        }
        return ds;
    }
    
    
    //phuong thuc doc tat ca san pham (Hoa) từ CSDL
    public ArrayList<SanPham> getAll(){
        ArrayList<SanPham> dssanpham = new ArrayList<>();
        String sql = "select * from SanPham";
       conn = new DbContext().getConnection();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dssanpham.add(new SanPham(rs.getInt(1), rs.getString(2), 
                        rs.getDouble(3), rs.getString(4),
                        rs.getInt(5), rs.getDate(6)));
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return dssanpham;
    }
    
    public static void main(String[] args) {
        for(SanPham x:  new SanPhamDAO().Laychude(2))
        {
            System.out.println(x); 
        }
    }
}
