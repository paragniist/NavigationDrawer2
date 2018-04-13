package com.example.vinove.navigationdrawer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
        View hell;
        Snackbar snackbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
        hell = findViewById(R.id.activity_main);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer,R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){

            drawerLayout.closeDrawer(GravityCompat.START);
        }else{

        super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id){


            case R.id.inbox_id:

                snackbar =Snackbar.make(hell,"Inbox",Snackbar.LENGTH_INDEFINITE);
                snackbar.show();
                break;

            case R.id.stared_id:
                snackbar = Snackbar.make(hell,"Stared",Snackbar.LENGTH_SHORT);
                snackbar.setDuration(8000);
                snackbar.show();
                break;

            case R.id.sent_id:
                snackbar =Snackbar.make(hell,"Sent",Snackbar.LENGTH_SHORT);
                snackbar.show();
                break;

            case R.id.draft_id:
                snackbar = Snackbar.make(hell,"Draft",Snackbar.LENGTH_SHORT);
                snackbar.show();
                break;

            case R.id.allmail_id:
                snackbar = Snackbar.make(hell,"All Mails",Snackbar.LENGTH_SHORT);
                snackbar.setDuration(8000);
                snackbar.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });
                snackbar.show();
                break;

            case R.id.trash_id:
                snackbar = Snackbar.make(hell,"Trash",Snackbar.LENGTH_LONG);
                snackbar.setDuration(8000);
                snackbar.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });
                snackbar.show();
                break;

            case R.id.spam_id:
                snackbar = Snackbar.make(hell,"Spam", Snackbar.LENGTH_INDEFINITE);
                snackbar.setDuration(8000);
                snackbar.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });

                View v =snackbar.getView();
                v.setBackgroundColor(getResources().getColor(R.color.colorsBarBackground));

                TextView txt = (TextView)v.findViewById(android.support.design.R.id.snackbar_text);
                txt.setTextColor(getResources().getColor(R.color.colorBackground));

                TextView txtAction = (TextView)v.findViewById(android.support.design.R.id.snackbar_action);
                txtAction.setTextColor(getResources().getColor(R.color.colorSnackbarActionText)) ;
                snackbar.show();


                break;


        }

            drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
