package vn.tcong.rutlixi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.BaseAdapter;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

import vn.tcong.rutlixi.adapter.MainRecyclerViewAdapter;
import vn.tcong.rutlixi.commons.GridSpacingItemDecorator;
import vn.tcong.rutlixi.entity.RedEnvolop;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        ArrayList<RedEnvolop> redEnvolops = prepareData();
        MainRecyclerViewAdapter mainRecyclerViewAdapter = new MainRecyclerViewAdapter(getApplicationContext(),redEnvolops);
        recyclerView.setAdapter(mainRecyclerViewAdapter);

        recyclerView.addItemDecoration(new GridSpacingItemDecorator(2,16));

    }

    /**
     * inflater menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    private ArrayList<RedEnvolop> prepareData(){
        ArrayList<RedEnvolop> envolops = new ArrayList<>();
        envolops.add(new RedEnvolop(0,R.drawable.form1,2020));
        envolops.add(new RedEnvolop(1,R.drawable.form1,2020));
        envolops.add(new RedEnvolop(2,R.drawable.form1,2020));
        envolops.add(new RedEnvolop(3,R.drawable.form1,2020));
        envolops.add(new RedEnvolop(4,R.drawable.form1,2020));
        envolops.add(new RedEnvolop(5,R.drawable.form1,2020));
        envolops.add(new RedEnvolop(6,R.drawable.form1,2020));
        envolops.add(new RedEnvolop(7,R.drawable.form1,2020));
        return envolops;
    }
}
