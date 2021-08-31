package com.example.wuad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import Fragments.addFriends;
import Fragments.genera_debate;
import Fragments.perfil_user;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    //variables para cargar el fragment
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    String personName;
    ViewPager2 viewPager2;
    ViewPagerAdapter adapter;
    TabLayout tabLayout;
    TabItem firstItem,secondItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//se pasa el toolbar
        viewPager2 = findViewById(R.id.vp_horizontal_ntb);
        tabLayout=findViewById(R.id.tablayout);
        firstItem=findViewById(R.id.perfil_user);
        secondItem=findViewById(R.id.Debate);
        drawerLayout=findViewById(R.id.drawer);
        navigationView=findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        adapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


       /* FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction().setReorderingAllowed(true);
        fragmentTransaction.add(R.id.container, new perfil_user(),null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();*/


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.user){
            FragmentManager fragmentManager;
            FragmentTransaction fragmentTransaction;
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.test, new perfil_user());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        else if (item.getItemId() == R.id.friendslist){
            FragmentManager fragmentManager;
            FragmentTransaction fragmentTransaction;
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.test, new addFriends());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }




        else if (item.getItemId() == R.id.exit){
            finish();

        }
        else{
            //pass
        }
        //aquí van las otros fragment
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

}


