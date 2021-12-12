package com.example.music_api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//@Generated("jsonschema2pojo")
public class Albums {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("uId")
    @Expose
    private String uId;
    @SerializedName("uNm")
    @Expose
    private String uNm;
    @SerializedName("text")
    @Expose
    private String text;
    //    @SerializedName("pl")
//    @Expose
//    private Pl pl;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("eId")
    @Expose
    private String eId;
    @SerializedName("ctx")
    @Expose
    private String ctx;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("nbP")
    @Expose
    private int nbP;
    @SerializedName("lov")
    @Expose
    private List<String> lov = null;
    @SerializedName("nbR")
    @Expose
    private int nbR;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuNm() {
        return uNm;
    }

    public void setuNm(String uNm) {
        this.uNm = uNm;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

//    public Pl getPl() {
//        return pl;
//    }

//    public void setPl(Pl pl) {
//        this.pl = pl;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String getCtx() {
        return ctx;
    }

    public void setCtx(String ctx) {
        this.ctx = ctx;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getNbP() {
        return nbP;
    }

    public void setNbP(int nbP) {
        this.nbP = nbP;
    }

    public List<String> getLov() {
        return lov;
    }

    public void setLov(List<String> lov) {
        this.lov = lov;
    }

    public int getNbR() {
        return nbR;
    }

    public void setNbR(int nbR) {
        this.nbR = nbR;
    }
}
