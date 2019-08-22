package com.example.moviecataloguefordicoding;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.moviecataloguefordicoding.Adapter.TvShowAdapter;
import com.example.moviecataloguefordicoding.Model.ModelTvSHow;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {
    private TvShowAdapter adapter;
    private ArrayList<ModelTvSHow> tvShow;
    private TypedArray dataPhoto;
    private String[] dataDescription,dataJudul,dataGenre,dataDurasi,dataStudio,dataRating;


    public TvShowFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tv_show, container, false);
        adapter = new TvShowAdapter(getContext());
        final ListView listView = rootView.findViewById(R.id.rv_tv_show);
        listView.setAdapter(adapter);
        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getContext(),DetailTvShowActivity.class);
                intent.putExtra("EXTRA_FILM",tvShow.get(position));
                startActivity(intent);
            }
        });
//
        return rootView;
    }
//
    private void prepare() {
        dataJudul = getResources().getStringArray(R.array.array_tv_show_title);
        dataGenre = getResources().getStringArray(R.array.array_tv_show_genre);
        dataDurasi = getResources().getStringArray(R.array.array_tv_show_duration);
        dataStudio = getResources().getStringArray(R.array.array_tv_show_studio);
        dataRating = getResources().getStringArray(R.array.array_tv_show_rating);
        dataDescription = getResources().getStringArray(R.array.array_description_tv_show);
        dataPhoto = getResources().obtainTypedArray(R.array.array_photo_tv_show);

    }

    private void addItem() {
        tvShow = new ArrayList<>();
        for (int i = 0; i < dataJudul.length; i++) {
            ModelTvSHow show = new ModelTvSHow();
            show.setFoto(dataPhoto.getResourceId(i, -1));
            show.setJudul(dataJudul[i]);
            show.setGenre(dataGenre[i]);
            show.setDurasi(dataDurasi[i]);
            show.setStudio(dataStudio[i]);
            show.setRating(dataRating[i]);
            show.setDeskripsi(dataDescription[i]);
            tvShow.add(show);
        }
        adapter.setTvShow(tvShow);
    }


}
