package vn.tcong.rutlixi.Reponsitory;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import vn.tcong.rutlixi.DAO.UserDAO;
import vn.tcong.rutlixi.Database.UserDatabase;
import vn.tcong.rutlixi.entity.UserEntity;

public class UserReponsitory {

    private UserDAO mUserDAO;
    private LiveData<List<UserEntity>> mAllUser;

    public UserReponsitory(Application application){
        UserDatabase db = UserDatabase.getInstance(application);
        mUserDAO = db.userDAO();
        mAllUser = mUserDAO.getAllUser();
    }

    public LiveData<List<UserEntity>> getAllUsers(){
        return mAllUser;
    }

    public void insert(final UserEntity user){
        mUserDAO.insertUser(user);
    }
}
