/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jvclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jvclass.DBConnect;
import jvclass.subject;
import jvclass.subjectInterface;

/**
 *
 * @author minhtuyet
 */
public class subjectMain implements subjectInterface {

    @Override
    public ArrayList<subject> getAll() {
        ArrayList<subject> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from HocPhan");
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    subject sj = new subject();
                    sj.setMaHP(rs.getString(1));
                    sj.setTenHP(rs.getString(2));
                    sj.setSoTinChi(rs.getInt(3));
                   
                    sj.setHocKy(rs.getString(3));
                    sj.setNamHoc(rs.getString(4));
                    list.add(sj);
                }
            } catch (SQLException ex) {
                Logger.getLogger(subjectMain.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return list;
    }

    @Override
    public ArrayList<subject> getSemeter() {
        ArrayList<subject> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select DISTINCT HocKy from HocPhan");
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    subject sj = new subject();
                    sj.setHocKy(rs.getString(1));
                    list.add(sj);
                }
            } catch (SQLException ex) {
                Logger.getLogger(subjectMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    
}


