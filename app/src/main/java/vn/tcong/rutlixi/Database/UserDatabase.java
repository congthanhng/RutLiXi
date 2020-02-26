package vn.tcong.rutlixi.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import vn.tcong.rutlixi.DAO.UserDAO;
import vn.tcong.rutlixi.entity.UserEntity;

@Database(entities = {UserEntity.class},version = 1,exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDAO userDAO();

    private static volatile UserDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static UserDatabase getInstance(final Context context){
        if(INSTANCE == null ){
            synchronized (UserDatabase.class){
                if(INSTANCE == null ){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),UserDatabase.class,"user_database")
                            .build();
                }
            }
        }
        return INSTANCE;

    }
}
