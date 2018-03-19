/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jvclass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minhtuyet
 */
public class classMain implements classInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    @Override
    public ArrayList<classSB> getAll() {
        ArrayList<classSB> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select *from Lop");
                rs = ps.executeQuery();
                list = new ArrayList<classSB>();
                while (rs.next()) {
                    classSB lh = new classSB();
                    lh.setMalop(rs.getString(1));
                    lh.setTenlop(rs.getString(2));
                    lh.setMakhoa(rs.getString(3));
                    lh.setKhoahoc(rs.getString(4));
                    list.add(lh);
                }
            } catch (SQLException ex) {
                Logger.getLogger(classMain.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public ArrayList<classSB> checkID(String malop) {
        ArrayList<classSB> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select * from Lop where MaLop=?");
                psCheck.setString(1, malop);
                rs = psCheck.executeQuery();
                list = new ArrayList<classSB>();
                while (rs.next()) {
                    classSB lh = new classSB();
                    lh.setMalop(rs.getString(1));
                    list.add(lh);
                }
            } catch (SQLException ex) {
                Logger.getLogger(classMain.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(psCheck, rs);
            }

        }
        return list;
    }

}
