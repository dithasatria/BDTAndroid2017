package com.example.android.listviewbekraf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.listviewbekraf.Utilities.PrefManager;
import com.example.android.listviewbekraf.adapter.OrangAdapter;
import com.example.android.listviewbekraf.pojo.Orang;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DITHA on 19/06/2017.
 */

public class MainRecyclerView extends AppCompatActivity {

    private RecyclerView rv;
    private OrangAdapter adapter;
    private List<Orang> orang = new ArrayList<>();

    PrefManager pref = new PrefManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampil_recyclerview);

        rv = (RecyclerView) findViewById(R.id.recyclerView);

        String username = pref.getString(this, "username");
        getSupportActionBar().setSubtitle(username);

        createDataDummy();
        adapter = new OrangAdapter(orang, this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        if(!pref.getBoolean(this, "isLoggedIn")) {
            Intent login = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(login);
            this.finish();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menu_logout :
                Logout();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }

    }

    private void createDataDummy(){
        Orang orang1 = new Orang("Kupank","Artist/Game Designer", "https://media.giphy.com/media/1Jo6dlAIpwB7G/giphy.gif");
        Orang orang2 = new Orang("Darmajaya", "Enemy Tivu Tivu", "http://lorempixel.com/output/food-q-c-200-200-9.jpg");
        Orang orang3 = new Orang("Chandrariz", "Time to Shine", "http://lorempixel.com/output/food-q-c-200-200-9.jpg");
        Orang orang4 = new Orang("Pramana", "Sail To The Sea", "http://lorempixel.com/output/food-q-c-200-200-9.jpg");

        orang.add(orang1);
        orang.add(orang2);
        orang.add(orang3);
    }

    private void  Logout(){
        pref.saveBoolean(this, "isLoggedIn", false);
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }

    /*
    private void validate(){
        Alerter.create(this)
                .setTitle("Login Failure")
                .setText("Invalid Username or Password")
                .show();
    }
    */
}
