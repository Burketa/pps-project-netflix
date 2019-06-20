package com.teamfive.trailerflix.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.teamfive.trailerflix.R;
import com.teamfive.trailerflix.fragment.ActionFragment;
import com.teamfive.trailerflix.fragment.AdventureFragment;
import com.teamfive.trailerflix.fragment.ComedyFragment;
import com.teamfive.trailerflix.fragment.FavoritesFragment;
import com.teamfive.trailerflix.fragment.FictionFragment;
import com.teamfive.trailerflix.fragment.TerrorFragment;
import com.teamfive.trailerflix.utils.Data;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbarPrincipal);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Favoritos", FavoritesFragment.class)
                        .add("Açâo", ActionFragment.class)
                        .add("Aventura", AdventureFragment.class)
                        .add("Comédia", ComedyFragment.class)
                        .add("Ficção", FictionFragment.class)
                        .add("Terror", TerrorFragment.class)
                        .create()
        );

        final ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        //TODO: Evento de mudar de tela refresh no recycler view.
        SmartTabLayout viewPagerTab = findViewById(R.id.viewPagerTab);
        viewPagerTab.setViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.sair)
            sair();

        return super.onOptionsItemSelected(item);
    }

    public void sair()
    {
        Intent i = new Intent(getBaseContext(), LoginActivity.class);
        startActivity(i);
    }
}
