/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jvclass;

/**
 *
 * @author minhtuyet
 */
public class subject {

    private String MaHP;
    private String TenHP;
    private int SoTinChi;
    private String HocKy;
    private String NamHoc;

    public subject() {
    }

    public subject(String MaHP, String TenHP, int SoTinChi, String HocKy, String NamHoc) {
        this.MaHP = MaHP;
        this.TenHP = TenHP;
        this.SoTinChi = SoTinChi;
      
        this.HocKy = HocKy;
        this.NamHoc = NamHoc;
    }

    public String getMaHP() {
        return MaHP;
    }

    public void setMaHP(String MaHP) {
        this.MaHP = MaHP;
    }

    public String getTenHP() {
        return TenHP;
    }

    public void setTenHP(String TenHP) {
        this.TenHP = TenHP;
    }

    public int getSoTinChi() {
        return SoTinChi;
    }

    public void setSoTinChi(int SoTinChi) {
        this.SoTinChi = SoTinChi;
    }

    public String getHocKy() {
        return HocKy;
    }

    public void setHocKy(String HocKy) {
        this.HocKy = HocKy;
    }

    public String getNamHoc() {
        return NamHoc;
    }

    public void setNamHoc(String NamHoc) {
        this.NamHoc = NamHoc;
    }

}
