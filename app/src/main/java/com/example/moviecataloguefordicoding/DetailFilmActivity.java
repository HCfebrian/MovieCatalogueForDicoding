package com.example.moviecataloguefordicoding;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.example.moviecataloguefordicoding.Model.ModelFilm;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;



public class DetailFilmActivity extends AppCompatActivity {
    TextView tvJudul,tvDeskripsi;
    ImageView ivPhotoDiterima,ivPhotoBackground;

    public static final String EXTRA_FILM = "extra_person";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        tvJudul = findViewById(R.id.tv_judul_diterima);
        tvDeskripsi = findViewById(R.id.tv_deskripsi_diterima);
        ivPhotoDiterima = findViewById(R.id.iv_photo_recived);
        ivPhotoBackground = findViewById(R.id.iv_detail_background);

        ModelFilm movie = getIntent().getParcelableExtra("EXTRA_FILM");

        tvJudul.setText(movie.getJudul());
        tvDeskripsi.setText(movie.getDeskripsi());
        Glide.with(this)
                .load(movie.getFoto())
                .transform(new RoundedCornersTransformation(60, 15))
                .into(ivPhotoDiterima);

        Glide.with(this)
                .load(movie.getFoto())
                .override(1200, 300)
                .centerCrop()
                .transform(new BlurTransformation())
                .into(ivPhotoBackground);

    }
}
