package vn.tcong.rutlixi.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import vn.tcong.rutlixi.entity.UserEntity;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM user_table ORDER BY id ASC ")
    LiveData<List<UserEntity>> getAllUser();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUser(UserEntity user);

    @Update
    void updateUser(UserEntity user);

    @Delete
    void deleteUser(UserEntity user);
}
