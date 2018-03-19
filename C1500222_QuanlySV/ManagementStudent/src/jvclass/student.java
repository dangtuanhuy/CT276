/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jvclass;

import java.util.Date;

/**
 *
 * @author minhtuyet
 */
public class student {

    private String stdID;
    private String stdName;
    private String classID;
    private String stdAddress;
    private String stdLevel;
    private Date stdBirth;
    private boolean stdGender;
    private String stdPhone;
    private String stdSchoolyear;

    public String getStdID() {
        return stdID;
    }

    public void setStdID(String stdID) {
        this.stdID = stdID;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getStdAddress() {
        return stdAddress;
    }

    public void setStdAddress(String stuAddress) {
        this.stdAddress = stuAddress;
    }

    public String getStdLevel() {
        return stdLevel;
    }

    public void setStdLevel(String stdLevel) {
        this.stdLevel = stdLevel;
    }

    public Date getStdBirth() {
        return stdBirth;
    }

    public void setStdBirth(Date stdBirth) {
        this.stdBirth = stdBirth;
    }

    public boolean isStdGender() {
        return stdGender;
    }

    public void setStdGender(boolean stdGender) {
        this.stdGender = stdGender;
    }

    public String getStdPhone() {
        return stdPhone;
    }

    public void setStdPhone(String stdPhone) {
        this.stdPhone = stdPhone;
    }

    public String getStdSchoolyear() {
        return stdSchoolyear;
    }

    public void setStdSchoolyear(String stdSchoolyear) {
        this.stdSchoolyear = stdSchoolyear;
    }

    public student() {
    }
     public student(String stdID, String stdName, String classID, String stdAddress, String stdLevel, Date stdBirth, boolean stdGender, String stdPhone, String stdSchoolyear) {
        this.stdID = stdID;
        this.stdName = stdName;
        this.classID = classID;    
        this.stdAddress = stdAddress;
        this.stdLevel = stdLevel;
        this.stdBirth = stdBirth;
        this.stdGender = stdGender;
        this.stdPhone = stdPhone;
        this.stdSchoolyear = stdSchoolyear;
    }
}
