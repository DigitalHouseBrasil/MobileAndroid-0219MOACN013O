package com.example.viewpagertabview.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.viewpagertabview.R;
import com.example.viewpagertabview.adapter.AlbumPageAdapter;
import com.example.viewpagertabview.model.Album;
import com.example.viewpagertabview.view.fragment.FotoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Album> listaAlbum = new ArrayList<>();

        listaAlbum.add(new Album("Big Ones",
                FotoFragment.novaInstancia(R.drawable.albumdois, "Big Ones")));

        listaAlbum.add(new Album("Lucas Album",
                FotoFragment.novaInstancia(R.drawable.joaocarreiro, "João Carreiro e Capataz")));

        listaAlbum.add(new Album("Aero",
                FotoFragment.novaInstancia(R.drawable.album, "Aerosmith")));


        AlbumPageAdapter adapter = new AlbumPageAdapter(getSupportFragmentManager(), listaAlbum);

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        viewPager.setOffscreenPageLimit(listaAlbum.size());

        tabLayout.setupWithViewPager(viewPager);


    }


}
