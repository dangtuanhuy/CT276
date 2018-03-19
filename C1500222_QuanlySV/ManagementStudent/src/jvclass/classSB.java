/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jvclass;

/**
 *
 * @author minhtuyet
 */
public class classSB {
    private String malop;
    private String tenlop;
    private String makhoa;
    private String khoahoc;

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getMakhoa() {
        return makhoa;
    }

    public void setMakhoa(String makhoa) {
        this.makhoa = makhoa;
    }

    public String getKhoahoc() {
        return khoahoc;
    }

    public void setKhoahoc(String khoahoc) {
        this.khoahoc = khoahoc;
    }

    public classSB() {
    }

    public classSB(String malop, String tenlop, String makhoa, String khoahoc) {
        this.malop = malop;
        this.tenlop = tenlop;
        this.makhoa = makhoa;
        this.khoahoc = khoahoc;
    }

}
