package vn.tcong.rutlixi.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "red_envolop")
public class RedEnvolopEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "src")
    private int src;

    @ColumnInfo(name = "year")
    private int year;



    public RedEnvolopEntity(int id, int src, int year) {
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
