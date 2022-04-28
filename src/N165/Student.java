/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package N165;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Student  implements Serializable{
    private String maSV, hoTen, toan, van , anh, avg;    

    public Student() {
    }

    public Student(String maSV, String hoTen, String toan, String van, String anh, String avg) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.toan = toan;
        this.van = van;
        this.anh = anh;
        this.avg = avg;
    }

    public String toString(){
        return getMaSV() + ";" + getHoTen() + ";"+ getToan() +";" + getVan() + ";" + getAnh()+";"+getAvg();
    }

   
    
    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getToan() {
        return toan;
    }

    public void setToan(String toan) {
        this.toan = toan;
    }

    public String getVan() {
        return van;
    }

    public void setVan(String van) {
        this.van = van;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }
    
    
    
}
