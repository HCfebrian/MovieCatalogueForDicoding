package com.example.moviecataloguefordicoding;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.moviecataloguefordicoding.Adapter.MovieAdapter;
import com.example.moviecataloguefordicoding.Model.ModelFilm;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    private String[] dataJudul;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private ArrayList<ModelFilm> films;
    private MovieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        final ListView listView = findViewById(R.id.lv_movie_list);
        listView.setAdapter(adapter);
        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this,DetailFilmActivity.class);
                intent.putExtra("EXTRA_FILM",films.get(position));
                startActivity(intent);
            }
        });
    }
    private void addItem(){
        films = new ArrayList<ModelFilm>();
        for (int i = 0; i < dataJudul.length; i++) {
            ModelFilm film = new ModelFilm();
            film.setFoto(dataPhoto.getResourceId(i, -1));
            film.setJudul(dataJudul[i]);
            film.setDeskripsi(dataDescription[i]);
            films.add(film);
        }
        adapter.setFilms(films);

    }
    private void prepare(){
        dataJudul = getResources().getStringArray(R.array.array_judul);
        dataDescription = getResources().getStringArray(R.array.array_deskripsi);
        dataPhoto = getResources().obtainTypedArray(R.array.array_foto);
    }
}
