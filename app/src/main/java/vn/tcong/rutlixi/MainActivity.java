package vn.tcong.rutlixi;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;

import vn.tcong.rutlixi.adapter.MainRecyclerViewAdapter;
import vn.tcong.rutlixi.commons.GridSpacingItemDecorator;
import vn.tcong.rutlixi.entity.RedEnvolop;

import static vn.tcong.rutlixi.commons.Constant.*;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private FloatingActionMenu floatingActionMenu;
    private FloatingActionButton fab_newLiXi, fab_history, fab_settings, fab_information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewMapping();
        viewListener();
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

    /**
     * listener of menu
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_main_add : Toast.makeText(getApplicationContext(),R.string.fab_new,Toast.LENGTH_SHORT).show(); break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * set Views and mapping
     */
    private void viewMapping(){
        //Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        //set color status bar
        getWindow().setStatusBarColor(getApplicationContext().getColor(R.color.colorPrimaryDark));

        //RecyclerView
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),SPAN_COUNT);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        ArrayList<RedEnvolop> redEnvolops = prepareData();  //List entity
        MainRecyclerViewAdapter mainRecyclerViewAdapter = new MainRecyclerViewAdapter(getApplicationContext(),redEnvolops);
        recyclerView.setAdapter(mainRecyclerViewAdapter);
        recyclerView.addItemDecoration(new GridSpacingItemDecorator(SPAN_COUNT,SPACING_ITEM_RECYCLER)); //spacing between items in grid

        //FloatingActionButton group
        floatingActionMenu = (FloatingActionMenu) findViewById(R.id.floatingActionMenu);
        fab_newLiXi = (FloatingActionButton)findViewById(R.id.fab_addLiXi);
        fab_history = (FloatingActionButton)findViewById(R.id.fab_history);
        fab_settings = (FloatingActionButton)findViewById(R.id.fab_settings);
        fab_information = (FloatingActionButton)findViewById(R.id.fab_infomation);
    }

    /**
     * Views Listener
     */
    private void viewListener(){
        /*
         * RecyclerView
         */
        //Scroll listener
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if (dy<0 && !floatingActionMenu.isShown())
                    floatingActionMenu.showMenu(true);
                else if(dy>0 && floatingActionMenu.isShown())
                    floatingActionMenu.hideMenu(true);
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        //item recyclerView click listener
        recyclerView.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener());

        /*
         * FloatingActionMenu
         */
        //item fab_newLiXi onClickListener
        fab_newLiXi.setOnClickListener(mOnClickListener);

        //item fab_history onClickListener
        fab_history.setOnClickListener(mOnClickListener);

        //item fab_settings onClickListener
        fab_settings.setOnClickListener(mOnClickListener);

        //item fab_information onClickListener
        fab_information.setOnClickListener(mOnClickListener);
    }

    // an anonymous implementation of OnClickListener
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.fab_addLiXi:Toast.makeText(getApplicationContext(),R.string.fab_new,Toast.LENGTH_SHORT).show(); break;
                case R.id.fab_history:Toast.makeText(getApplicationContext(),R.string.fab_history,Toast.LENGTH_SHORT).show(); break;
                case R.id.fab_settings:Toast.makeText(getApplicationContext(),R.string.fab_settings,Toast.LENGTH_SHORT).show(); break;
                case R.id.fab_infomation:Toast.makeText(getApplicationContext(),R.string.fab_information,Toast.LENGTH_SHORT).show(); break;

            }
        }
    };


    private ArrayList<RedEnvolop> prepareData(){
        ArrayList<RedEnvolop> envolops = new ArrayList<>();
        envolops.add(new RedEnvolop(0,R.drawable.form1,2020));
        envolops.add(new RedEnvolop(1,R.drawable.form1,2021));
        envolops.add(new RedEnvolop(2,R.drawable.form1,2022));
        envolops.add(new RedEnvolop(3,R.drawable.form1,2023));
        envolops.add(new RedEnvolop(4,R.drawable.form1,2024));
        envolops.add(new RedEnvolop(5,R.drawable.form1,2025));
        envolops.add(new RedEnvolop(6,R.drawable.form1,2026));
        return envolops;
    }


}
