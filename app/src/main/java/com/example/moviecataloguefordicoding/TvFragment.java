package com.example.moviecataloguefordicoding;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviecataloguefordicoding.Adapter.MovieAdapter;
import com.example.moviecataloguefordicoding.Data.MovieData;
import com.example.moviecataloguefordicoding.Model.ModelFilm;

import java.util.ArrayList;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvFragment extends Fragment {
    private int x;
    private MovieAdapter adapter;
    private ArrayList<ModelFilm> films;
    private TypedArray dataPhoto;
    private String[] dataDescription,dataJudul,dataGenre,dataDuration,dataStudio,dataRating;
    private RecyclerView rvMovie;
    private ArrayList<ModelFilm> list = new ArrayList<>();
    private static final String ARG_SECTION_NUMBER = "section_number";


    public TvFragment() {
        // Required empty public constructor
    }

    public static TvFragment newInstance(int index) {
        TvFragment fragment = new TvFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        adapter = new MovieAdapter(getContext());
//        final RecyclerView listView = rootView.findViewById(R.id.lv_movie_list);
//        listView.setAdapter(adapter);
//        prepare();
//        addItem();on
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Intent intent = new Intent(getContext(), DetailMovieActivity.class);
//                intent.putExtra("EXTRA_FILM",films.get(position));
//                startActivity(intent);
//            }
//        });


        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovie = view.findViewById(R.id.rv_movie_list);
        rvMovie.setHasFixedSize(true);
        MovieAdapter movieAdapter = new MovieAdapter(list);
        list.addAll(MovieData.getListDataTv());
        rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMovie.setAdapter(movieAdapter);



    }

//    private void prepare() {
//        dataJudul = getResources().getStringArray(R.array.array_title);
//        dataGenre = getResources().getStringArray(R.array.array_genre);
//        dataStudio = getResources().getStringArray(R.array.array_studio);
//        dataDuration = getResources().getStringArray(R.array.array_duration);
//        dataRating = getResources().getStringArray(R.array.array_rating);
//        dataDescription = getResources().getStringArray(R.array.array_description);
//        dataPhoto = getResources().obtainTypedArray(R.array.array_photo);
//
//
//    }

//    private void addItem() {
//        films = new ArrayList<>();
//        for (int i = 0; i < dataJudul.length; i++) {
//            ModelFilm film = new ModelFilm();
//            film.setFoto(dataPhoto.getResourceId(i, -1));
//            film.setJudul(dataJudul[i]);
//            film.setGenre(dataGenre[i]);
//            film.setDurasi(dataDuration[i]);
//            film.setStudio(dataStudio[i]);
//            film.setRating(dataRating[i]);
//            film.setDeskripsi(dataDescription[i]);
//            films.add(film);
//        }
//        adapter.setFilms(films);
//    }


}
