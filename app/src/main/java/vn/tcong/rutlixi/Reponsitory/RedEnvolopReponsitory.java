package vn.tcong.rutlixi.Reponsitory;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import vn.tcong.rutlixi.DAO.RedEnvolopDAO;
import vn.tcong.rutlixi.Database.RedEnvolopDatabase;
import vn.tcong.rutlixi.entity.RedEnvolopEntity;

public class RedEnvolopReponsitory {
    private RedEnvolopDAO redEnvolopDAO;
    private LiveData<List<RedEnvolopEntity>> getAllRedEnvolop;

    public RedEnvolopReponsitory(Application application) {
        RedEnvolopDatabase redEnvolopDatabase = RedEnvolopDatabase.getInstance(application);
        redEnvolopDAO = redEnvolopDatabase.redEnvolopDAO();
        getAllRedEnvolop = redEnvolopDAO.getAllRedEnvolop();
    }

    public void insert(RedEnvolopEntity redEnvolopEntity){
        redEnvolopDAO.inserRedEnvolop(redEnvolopEntity);
    }

    public LiveData<List<RedEnvolopEntity>> getAllRedEnvolop(){
        return redEnvolopDAO.getAllRedEnvolop();
    }
}
