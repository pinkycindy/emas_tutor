package com.pinkycindy.emas_tutor.modul;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.pinkycindy.emas_tutor.R;
import com.pinkycindy.emas_tutor.data.source.local.SessionManager;
import com.pinkycindy.emas_tutor.modul.main.HomeFragment;
import com.pinkycindy.emas_tutor.modul.profil.ProfilFragment;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loadFragment(new HomeFragment());
        // inisialisasi BottomNavigaionView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        session = new SessionManager(getApplicationContext());
        session.checkLogin();
        HashMap<String, String> user = session.getUserDetails();


        String name = user.get(SessionManager.KEY_NAMA);
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.home_menu:
                fragment = new HomeFragment();
                break;
            case R.id.search_menu:
                fragment = new ProfilFragment();
                break;
            case R.id.favorite_menu:
                fragment = new HomeFragment();
                break;
            case R.id.account_menu:
                fragment = new ProfilFragment();
                break;
        }
        return loadFragment(fragment);
    }


}
