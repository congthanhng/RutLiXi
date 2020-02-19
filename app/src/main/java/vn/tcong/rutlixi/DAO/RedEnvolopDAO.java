package vn.tcong.rutlixi.DAO;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import vn.tcong.rutlixi.entity.RedEnvolopEntity;

@Dao
public interface RedEnvolopDAO {
    @Query("SELECT * FROM red_envolop ORDER BY id ASC")
    LiveData<List<RedEnvolopEntity>> getAllRedEnvolop();

    @Insert
    void inserRedEnvolop(RedEnvolopEntity... redEnvolopEntities);
}
