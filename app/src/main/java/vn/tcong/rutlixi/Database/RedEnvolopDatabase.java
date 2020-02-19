package vn.tcong.rutlixi.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import vn.tcong.rutlixi.DAO.RedEnvolopDAO;
import vn.tcong.rutlixi.entity.RedEnvolopEntity;

@Database(entities = {RedEnvolopEntity.class}, version = 1,exportSchema = false)
public abstract class RedEnvolopDatabase extends RoomDatabase {

    public abstract RedEnvolopDAO redEnvolopDAO();


    public static final String DB_NAME = "RedEnvolop-database";

    private static RedEnvolopDatabase sRedEnvolopDatabase;

    public static synchronized RedEnvolopDatabase getInstance(Context context){
        if(sRedEnvolopDatabase == null){
            sRedEnvolopDatabase = Room.databaseBuilder(context, RedEnvolopDatabase.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return sRedEnvolopDatabase;
    }
}
