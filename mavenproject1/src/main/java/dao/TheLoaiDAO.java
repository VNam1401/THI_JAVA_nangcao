package dao;

import context.DbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.TheLoai;

/**
 *
 * @author ADMIN
 */
public class TheLoaiDAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public ArrayList<TheLoai> getAll()
    {
       ArrayList<TheLoai>  dstheloai = new ArrayList<>();
      
       String sql="select * from TheLoai";
       conn= new DbContext().getConnection();
       try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                 dstheloai.add(new TheLoai(rs.getInt(1),rs.getString(2)));
            }
        } catch (SQLException ex) {
            System.out.println("Loi SQL:" + ex.toString());
        }  
       return dstheloai;       
    }
    
    public static void main(String[] args) {
        for(TheLoai x: new TheLoaiDAO().getAll())
        {
            System.out.println(x);
        }
    }
}
