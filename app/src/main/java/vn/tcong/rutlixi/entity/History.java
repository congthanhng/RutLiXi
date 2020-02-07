package vn.tcong.rutlixi.entity;

import java.util.Date;

public class History {
    private int id;
    private String name;
    private int idLiXi;
    private Date date;

    public History() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdLiXi() {
        return idLiXi;
    }

    public void setIdLiXi(int idLiXi) {
        this.idLiXi = idLiXi;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
