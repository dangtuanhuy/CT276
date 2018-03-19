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
public class markMain implements markInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    @Override
    public ArrayList<mark> getAll() {
        ArrayList<mark> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select Masv, Mamh, Diem from Diem");
                rs = ps.executeQuery();
                list = new ArrayList<mark>();
                while (rs.next()) {
                    mark bd = new mark();
                    bd.setMasv(rs.getString(1));
                    bd.setMamh(rs.getString(2));
                    bd.setDiem(rs.getFloat(3));
                    // bd.setDiemchu(rs.getString(4));

                    list.add(bd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(markMain.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    public ArrayList<mark> getAllDK() {
        ArrayList<mark> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select Masv, Mamh from Diem where Diemchu like 'null' ");
                rs = ps.executeQuery();
                list = new ArrayList<mark>();
                while (rs.next()) {
                    mark bd = new mark();
                    bd.setMasv(rs.getString(1));
                    bd.setMamh(rs.getString(2));
                   // bd.setDiem(rs.getFloat(3));
                    // bd.setDiemchu(rs.getString(4));

                    list.add(bd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(markMain.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public ArrayList<mark> findByIDStudent(String masv, String hocky) {
        ArrayList<mark> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select distinct a.MaHP, b.Diem, b.Diemchu from HocPhan a, Diem b where a.MaHP= b.MaMH and Diem >-1 and b.MaSV = ? and a.HocKy= ?");
                ps.setString(1, masv);
                ps.setString(2, hocky);
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    mark bd = new mark();
                    bd.setMamh(rs.getString(1));
                    bd.setDiem(rs.getFloat(2));
                    bd.setDiemchu(rs.getString(3));

                    list.add(bd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(markMain.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public ArrayList<mark> findByIDSubject(String mamh) {
        ArrayList<mark> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from Diem where MaMH = ?");
                ps.setString(1, mamh);
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    mark bd = new mark();
                    bd.setMasv(rs.getString(1));
                    bd.setMamh(rs.getString(2));
                    bd.setDiem(rs.getFloat(3));
                    bd.setDiemchu(rs.getString(4));

                    list.add(bd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(markMain.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public mark addNew(mark diem) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("insert into Diem (MaSV,MaMH,Diem,Diemchu) values (?,?,?,?)");
                ps.setString(1, diem.getMasv());
                ps.setString(2, diem.getMamh());

                ps.setFloat(3, diem.getDiem());
                ps.setString(4, diem.getDiemchu());
                int row = ps.executeUpdate();
                if (row < 1) {
                    diem = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(markMain.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps);
            }
        }
        return diem;
    }

    @Override
    public mark upDate(mark diem) {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("update Diem set Diem =? ,DiemChu = ?where MaSV =? and MaMH =?");

                ps.setFloat(1, diem.getDiem());
                ps.setString(2, diem.getDiemchu());
                ps.setString(3, diem.getMasv());
                ps.setString(4, diem.getMamh());

                int row = ps.executeUpdate();
                if (row < 1) {
                    diem = null;
                }
            } catch (SQLException ex) {
                Logger.getLogger(markMain.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close();
            }
        }
        return diem;
    }

    public void delBangDiem(String MaSV, String MaMH) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from Diem where MaSV =? and MaMH =?");
            ps.setString(1, MaSV);
            ps.setString(2, MaMH);

            ps.executeUpdate();
            DBConnect.close();
        }
    }

    public void delDangky(String MaSV, String MaMH) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;

        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from Diem where MaSV =? and MaMH =? and Diemchu like 'null'");
            ps.setString(1, MaSV);
            ps.setString(2, MaMH);
            ps.executeUpdate();
            DBConnect.close();
        }

    }

    @Override
    public boolean CheckID(String masv, String mamh) {
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        boolean result = true;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select * from Diem where MaSV =? and MaMH =?");
                psCheck.setString(1, masv);
                psCheck.setString(2, mamh);

                rs = psCheck.executeQuery();
                result = rs.next();
            } catch (SQLException ex) {
                Logger.getLogger(markMain.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(psCheck, rs);
            }
        }
        return result;
    }

    @Override
    public ArrayList<mark> findSubjectID(String masv) {
        ArrayList<mark> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select DISTINCT mamh from Diem where masv=?");
                ps.setString(1, masv);
                rs = ps.executeQuery();
                list = new ArrayList<mark>();
                while (rs.next()) {
                    mark bd = new mark();
                    bd.setMasv(rs.getString(1));
                    bd.setMamh(rs.getString("mamh"));
                    list.add(bd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(markMain.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public ArrayList<mark> findStudentID() {
        ArrayList<mark> list = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        if (DBConnect.open()) {
//            try {
//                ps = DBConnect.cnn.prepareStatement("select DISTINCT masv from Diem where  fldtrangthai is not null");
//                rs = ps.executeQuery();
//                list = new ArrayList<mark>();
//                while (rs.next()) {
//                    mark bd = new mark();
//                    bd.setMasv(rs.getString(1));
//                    list.add(bd);
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(markMain.class.getName()).log(Level.SEVERE, null, ex);
//            } finally {
//                DBConnect.close(ps, rs);
//            }
//        }
        return list;
    }

    @Override
    public ArrayList<mark> loadMark(String masv, String maMon) {

        ArrayList<mark> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select diem, diemchu from Diem where mamh =? and masv=?");
                ps.setString(1, maMon);
                ps.setString(2, masv);
                rs = ps.executeQuery();
                list = new ArrayList<mark>();
                while (rs.next()) {
                    mark bd = new mark();
                    bd.setDiem(rs.getFloat("Diem"));
                    bd.setDiemchu(rs.getString("Diemchu"));
                    list.add(bd);
                }
            } catch (SQLException ex) {
                Logger.getLogger(markMain.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps, rs);
            }
        }
        return list;
    }

    
}
