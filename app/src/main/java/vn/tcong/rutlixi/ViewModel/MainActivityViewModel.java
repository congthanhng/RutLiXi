package vn.tcong.rutlixi.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import vn.tcong.rutlixi.Reponsitory.RedEnvolopReponsitory;
import vn.tcong.rutlixi.entity.RedEnvolopEntity;

public class MainActivityViewModel extends AndroidViewModel {

    private RedEnvolopReponsitory redEnvolopReponsitory;
    private LiveData<List<RedEnvolopEntity>> getAllRedEnvolop;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        redEnvolopReponsitory = new RedEnvolopReponsitory(application);
        getAllRedEnvolop= redEnvolopReponsitory.getAllRedEnvolop();
    }

    public void insert(RedEnvolopEntity redEnvolopEntity){
        redEnvolopReponsitory.insert(redEnvolopEntity);
    }

    public LiveData<List<RedEnvolopEntity>> getAllRedEnvolop(){
        return redEnvolopReponsitory.getAllRedEnvolop();
    }
}
