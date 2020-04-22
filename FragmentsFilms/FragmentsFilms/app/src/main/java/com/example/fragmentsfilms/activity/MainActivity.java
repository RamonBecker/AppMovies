package com.example.fragmentsfilms.activity;

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
import com.example.fragmentsfilms.controller.ControllerAtor;
import com.example.fragmentsfilms.controller.ControllerFilme;
import com.example.fragmentsfilms.fragments.DateFrag;
import com.example.fragmentsfilms.fragments.RecyclerFragmentAtor;
import com.example.fragmentsfilms.fragments.RecyclerFragmentDiretor;
import com.example.fragmentsfilms.fragments.RecyclerFragmentFilme;
import com.example.fragmentsfilms.fragments.RegisterPerson;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private RegisterPerson registerPerson;


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
        ControllerAtor controllerAtor = ControllerAtor.getInstance();
        Log.i("log", String.valueOf(controllerAtor.getListAtor()==null));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);

        fragmentTransaction =getSupportFragmentManager().beginTransaction();
        int menuItem = item.getItemId();

        if(menuItem == R.id.menuAtores){
            Log.i("log", "Ator");
            fragmentTransaction.replace(R.id.container_fragment, new RecyclerFragmentAtor());
            fragmentTransaction.commit();

        }

        if(menuItem == R.id.menuDiretores){

            fragmentTransaction.replace(R.id.container_fragment, new RecyclerFragmentDiretor());
            fragmentTransaction.commit();
        }
        if(menuItem == R.id.menuFilmes){
            fragmentTransaction.replace(R.id.container_fragment, new RecyclerFragmentFilme());
            fragmentTransaction.commit();
        }

        if(menuItem == R.id.menuCadastrarAtor){
            registerPerson.typeRegister = "Cadastrar Ator";
            Log.i("log", "Cadastrar Ator");
            fragmentTransaction.replace(R.id.container_fragment, new RegisterPerson());
            fragmentTransaction.commit();
        }

        if(menuItem == R.id.menuItemCadastrarDiretor){
            registerPerson.typeRegister = "Cadastrar Diretor";
            Log.i("log", "Cadastrar Diretor");
            fragmentTransaction.replace(R.id.container_fragment, new RegisterPerson());
            fragmentTransaction.commit();
        }
        return true;
    }
}
