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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minhtuyet
 */
public class studentMain implements studentInterface {

    @Override
    public ArrayList<student> getAll() {
        ArrayList<student> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from SinhVien");
                rs = ps.executeQuery();

                list = new ArrayList<>();
                while (rs.next()) {
                    student sv = new student();
                    sv.setStdID(rs.getString(1));
                    sv.setStdName(rs.getString(2));
                    sv.setClassID(rs.getString(3));
                    sv.setStdLevel(rs.getString(4));
                    sv.setStdBirth(new Date(rs.getDate(5).getTime()));
                    sv.setStdAddress(rs.getString(6));
                    sv.setStdGender(rs.getBoolean(7));
                    sv.setStdPhone(rs.getString(8));
                    sv.setStdSchoolyear(rs.getString(9));

                    list.add(sv);
                }
            } catch (Exception ex) {
                ex.toString();
            }

        }
        return list;
    }

    @Override
    public student addNew(student std) {
        PreparedStatement ps = null;

        if (DBConnect.open()) {
            try {

                ps = DBConnect.cnn.prepareStatement("insert into SinhVien (MaSV, HoTen, MaLop, HeDaoTao, NgaySinh, DiaChi, GioiTinh, SDT, NamHoc) values (?,?,?,?,?,?,?,?,?)");
                ps.setNString(1, std.getStdID());
                ps.setNString(2, std.getStdName());
                ps.setNString(3, std.getClassID());
                ps.setNString(4, std.getStdLevel());
                ps.setDate(5, new java.sql.Date(std.getStdBirth().getTime()));
                ps.setNString(6, std.getStdAddress());
                ps.setBoolean(7, std.isStdGender());
                ps.setNString(8, std.getStdPhone());
                ps.setNString(9, std.getStdSchoolyear());

                int row = ps.executeUpdate();
                if (row < 1) {
                    std = null;
                }

            } catch (Exception ex) {
                ex.toString();
            }
        }
        return std;
    }

    @Override
    public student updatebyStudentID(student std) {

        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("update SinhVien set HoTen = ?, MaLop = ?, HeDaoTao = ?, NgaySinh = ?, DiaChi = ?, GioiTinh = ?, SDT = ?, Namhoc=? where MaSV = ?");

                ps.setNString(1, std.getStdName());
                ps.setNString(2, std.getClassID());
                ps.setNString(3, std.getStdLevel());
                ps.setDate(4, new java.sql.Date(std.getStdBirth().getTime()));
                ps.setNString(5, std.getStdAddress());
                ps.setBoolean(6, std.isStdGender());
                ps.setNString(7, std.getStdPhone());
                ps.setNString(8, std.getStdSchoolyear());
                ps.setNString(9, std.getStdID());

                if (ps.executeUpdate() < 1) {
                    std = null;
                }

            } catch (Exception ex) {
                ex.toString();
            }
        }
        return std;
    }

    public void deleteStudentID(String studentID) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            ps = DBConnect.cnn.prepareStatement("delete from SinhVien where MaSV= ?");
            ps.setNString(1, studentID);
            ps.executeUpdate();
            DBConnect.close();
        }
    }

    @Override
    public ArrayList<student> CheckID(String stdID) {
        ArrayList<student> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                psCheck = DBConnect.cnn.prepareStatement("select *from SinhVien where MaSV=?");
                psCheck.setString(1, stdID);
                rs = psCheck.executeQuery();
                list = new ArrayList<student>();
                while (rs.next()) {
                    student sinhVien = new student();
                    sinhVien.setStdID(rs.getString(1));
                    list.add(sinhVien);
                }
            } catch (Exception ex) {
                ex.toString();
            }
        }
        return list;
    }

    @Override
    public ArrayList<student> findByClassID(String classID) {
        ArrayList<student> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("select * from SinhVien where MaLop = ?");
                ps.setString(1, classID);
                rs = ps.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    student sv = new student();
                    sv.setStdID(rs.getString(1));
                    sv.setStdName(rs.getString(2));
                    sv.setClassID(rs.getString(3));
                    sv.setStdLevel(rs.getString(4));
                    sv.setStdBirth(new Date(rs.getDate(5).getTime()));
                    sv.setStdAddress(rs.getString(6));
                    sv.setStdGender(rs.getBoolean(7));
                    sv.setStdPhone(rs.getString(8));
                    sv.setStdSchoolyear(rs.getString(9));

                    list.add(sv);
                }

            } catch (Exception ex) {
                ex.toString();
            }

        }

        return list;
    }

    /**
     * @param args the command line arguments
     */
}
