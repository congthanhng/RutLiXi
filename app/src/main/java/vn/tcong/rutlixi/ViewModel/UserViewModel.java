package vn.tcong.rutlixi.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import vn.tcong.rutlixi.Reponsitory.UserReponsitory;
import vn.tcong.rutlixi.entity.UserEntity;

public class UserViewModel extends AndroidViewModel {

    private UserReponsitory mReponsitory;
    private LiveData<List<UserEntity>> mAllUsers;

    public UserViewModel(@NonNull Application application) {
        super(application);
        mReponsitory = new UserReponsitory(application);
        mAllUsers = mReponsitory.getAllUsers();
    }

    public LiveData<List<UserEntity>> getAllUsers(){
        return mAllUsers;
    }

    public void insert(UserEntity user){
        mReponsitory.insert(user);
    }
}
