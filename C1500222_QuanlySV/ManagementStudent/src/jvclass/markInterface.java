/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jvclass;

import java.util.ArrayList;

/**
 *
 * @author minhtuyet
 */
public interface markInterface {

    public ArrayList<mark> getAll();

    public ArrayList<mark> findByIDStudent(String masv, String hocky);

    public ArrayList<mark> findByIDSubject(String mamh);

    public mark addNew(mark diem);

    public mark upDate(mark diem);

    public boolean CheckID(String masv, String mamh);

    public ArrayList<mark> findSubjectID(String masv);

    public ArrayList<mark> findStudentID();

    public ArrayList<mark> loadMark(String masv, String maMon);

   
}
