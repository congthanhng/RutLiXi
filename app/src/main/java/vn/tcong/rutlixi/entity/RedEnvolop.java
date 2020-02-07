package vn.tcong.rutlixi.entity;

public class RedEnvolop {
    private int id;
    private int src;
    private int year;

    public RedEnvolop(int id, int src, int year) {
        this.id = id;
        this.src = src;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
