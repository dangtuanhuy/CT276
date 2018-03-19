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
public class mark {

    private String masv;
    private String mamh;
    private float diem;
    private String diemchu;

    public mark() {
    }

    public mark(String masv, String mamh, float diem, String diemchu) {
        this.masv = masv;
        this.mamh = mamh;
        this.diem = diem;
        this.diemchu = diemchu;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getMamh() {
        return mamh;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public String getDiemchu() {
        return diemchu;
    }

    public void setDiemchu(String diemchu) {
        this.diemchu = diemchu;
    }
}
