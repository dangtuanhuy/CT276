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
public interface studentInterface {
    
    public ArrayList<student> getAll();

    public ArrayList<student> findByClassID(String classID);

    public student addNew(student std);

    public student updatebyStudentID(student std);
    
    public ArrayList<student> CheckID(String stdID);
    
}
