package com.example.android.listviewbekraf.pojo;

import java.io.Serializable;

/**
 * Created by DITHA on 19/06/2017.
 */

public class Orang implements Serializable{
    private String nama;
    private String pekerjaan;
    private String imgURL;

    public Orang(String nama, String pekerjaan, String imgURL) {
        this.nama = nama;
        this.pekerjaan = pekerjaan;
        this.imgURL = imgURL;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setPekerjaan(String pekerjaan){
        this.pekerjaan = pekerjaan;
    }

    public void setImgURL(String imgURL){
        this.imgURL = imgURL;
    }

    public String getNama(){
        return nama;
    }

    public String getPekerjaan(){
        return pekerjaan;
    }

    public String getImgURL(){
        return imgURL;
    }
}
