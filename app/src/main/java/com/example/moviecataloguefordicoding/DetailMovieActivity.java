package com.example.moviecataloguefordicoding;


import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.moviecataloguefordicoding.Model.ModelFilm;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


public class DetailMovieActivity extends AppCompatActivity {
    TextView tvJudul,tvDeskripsi, tvGenre, tvStudio, tvDurasi,tvRating;
    ImageView ivPhotoDiterima,ivBackground;


    public static final String EXTRA_FILM = "extra_person";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_show);
        ModelFilm movie = getIntent().getParcelableExtra("EXTRA_FILM");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(movie.getJudul());

        collapsingToolbarLayout.setCollapsedTitleTextColor(
                ContextCompat.getColor(this, R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(
                ContextCompat.getColor(this, R.color.transparent));


        tvJudul = findViewById(R.id.tv_judul_diterima);
        tvGenre = findViewById(R.id.tv_genre);
        tvStudio = findViewById(R.id.tv_studio);
        tvDurasi = findViewById(R.id.tv_duration);
        tvRating = findViewById(R.id.tv_rating);
        ivBackground = findViewById(R.id.iv_detail_background);
        tvDeskripsi = findViewById(R.id.tv_description);
        ivPhotoDiterima = findViewById(R.id.iv_photo_recived);


        tvJudul.setText(movie.getJudul());
        tvGenre.setText(movie.getGenre());
        tvStudio.setText(movie.getStudio());
        tvDurasi.setText(movie.getDurasi());
        tvRating.setText(movie.getRating());
        tvDeskripsi.setText(movie.getDeskripsi());


        Glide.with(this)
                .load(movie.getFoto())
                .centerCrop()
                .into(ivBackground);

        Glide.with(this)
                .load(movie.getFoto())
                .transform(new RoundedCornersTransformation(20, 10), new CenterCrop())
                .into(ivPhotoDiterima);

    }
}
