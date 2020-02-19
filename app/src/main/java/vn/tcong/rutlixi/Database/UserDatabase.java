package vn.tcong.rutlixi.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import vn.tcong.rutlixi.DAO.UserDAO;
import vn.tcong.rutlixi.entity.UserEntity;

@Database(entities = {UserEntity.class},version = 1,exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    public static UserDatabase sInstance;
    public abstract UserDAO userDAO();

    public static synchronized UserDatabase getInstance(Context context){
        if(sInstance == null){
            sInstance = Room.databaseBuilder(context,UserDatabase.class,"user-db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return sInstance;
    }
}
