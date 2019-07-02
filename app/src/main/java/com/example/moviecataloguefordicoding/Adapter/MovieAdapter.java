package com.example.moviecataloguefordicoding.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviecataloguefordicoding.Model.ModelFilm;
import com.example.moviecataloguefordicoding.R;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ModelFilm> films;

    public void setFilms(ArrayList<ModelFilm> films) {
        this.films = films;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        films = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int position) {
        return films.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_film,parent,false);
        }
        ViewHolder viewHolder = new ViewHolder(convertView);
        ModelFilm film = (ModelFilm) getItem(position);
        viewHolder.bind(film);
        return convertView;
    }

    private class ViewHolder {
        private TextView txtJudul;
        private TextView txtDeskripsi;
        private ImageView ivFilm;

        ViewHolder (View view){
        txtJudul = view.findViewById(R.id.tv_judul);
        txtDeskripsi = view.findViewById(R.id.tv_deskripsi);
        ivFilm = view.findViewById(R.id.iv_film_photo);

        }

        void bind(ModelFilm film){
        txtJudul.setText(film.getJudul());
        txtDeskripsi.setText(film.getDeskripsi());
//        imgFilm.setImageResource(film.getFoto());
        Glide.with(context)
                .load(film.getFoto())
                .transform(new RoundedCornersTransformation(20, 10))
                .into(ivFilm);
        }
    }
}
