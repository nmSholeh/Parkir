/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input_data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author User
 */
public class data {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String ID_Pelanggan;
    public String No_Plat;
    public String Jenis_Kendaraan;
    
    
    public void Print() throws SQLException {
        conn = Koneksi.Getkoneksi();
        sql = "INSERT INTO MASUK(ID_PELANGGAN,No_Plat,Jenis_Kendaraan)VALUE(?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, ID_Pelanggan);
        pst.setString(2, No_Plat);
        pst.setString(3, Jenis_Kendaraan);
        pst.execute();
        pst.close();
        
        
    }
    
    public void Scan() throws SQLException {
        conn = Koneksi.Getkoneksi();
        sql = "select * from masuk where ID_Pelanggan like ?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, ID_Pelanggan);
        rs = pst.executeQuery();
        //return rs;
        
    }
    
}
