package com.example.fragmentsfilms.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.fragmentsfilms.R;
import com.example.fragmentsfilms.controller.ControllerFilme;
import com.example.fragmentsfilms.fragments.RecyclerFragmentFilme;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationview);
        navigationView.setNavigationItemSelectedListener(this) ;

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        ControllerFilme controllerFilme = ControllerFilme.getInstance();
        Log.i("log", String.valueOf("TESTE:"+controllerFilme.getListaFilme()==null));
     //   fragmentTransaction =   fragmentManager.beginTransaction();
     //   MainFragment mainFragment = new MainFragment();
    //    fragmentTransaction.replace(R.id.container_fragment, mainFragment);
    //    fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);

        int menuItem = item.getItemId();

        if(menuItem == R.id.menuAtores){

        //    fragmentManager = getSupportFragmentManager();
       //     fragmentTransaction =   fragmentManager.beginTransaction();
        //    fragmentTransaction.replace(R.id.container_fragment, new MainFragment());
        //    fragmentTransaction.commit();
        }

        if(menuItem == R.id.menuDiretores){
       //     fragmentManager = getSupportFragmentManager();
       //     fragmentTransaction =   fragmentManager.beginTransaction();
       //     fragmentTransaction.replace(R.id.container_fragment, new FragmentSecond());
        //    fragmentTransaction.commit();
        }
        if(menuItem == R.id.menuFilmes){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment, new RecyclerFragmentFilme());
            fragmentTransaction.commit();
        }
        return true;
    }
}
