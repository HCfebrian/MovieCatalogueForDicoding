package com.example.moviecataloguefordicoding;


import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.moviecataloguefordicoding.Model.ModelTvSHow;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


public class DetailTvShowActivity extends AppCompatActivity {
    TextView tvJudul,tvDeskripsi, tvGenre, tvStudio, tvDurasi,tvRating;
    ImageView ivPhotoDiterima,ivBackground;
    String judul;

    public static final String EXTRA_FILM = "extra_person";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_show);
        ModelTvSHow tvShow = getIntent().getParcelableExtra("EXTRA_FILM");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(tvShow.getJudul());

        collapsingToolbarLayout.setCollapsedTitleTextColor(
                ContextCompat.getColor(this, R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(
                ContextCompat.getColor(this, R.color.transparent));


        tvJudul = findViewById(R.id.tv_judul_diterima);
        tvGenre = findViewById(R.id.tv_genre);
        tvStudio = findViewById(R.id.tv_studio);
        tvDurasi = findViewById(R.id.tv_duration);
        tvRating = findViewById(R.id.tv_rating);
        tvDeskripsi = findViewById(R.id.tv_description);

        ivPhotoDiterima = findViewById(R.id.iv_photo_recived);
        ivBackground = findViewById(R.id.iv_detail_background);


        tvJudul.setText(tvShow.getJudul());
        tvGenre.setText(tvShow.getGenre());
        tvStudio.setText(tvShow.getStudio());
        tvDurasi.setText(tvShow.getDurasi());
        tvRating.setText(tvShow.getRating());
        tvDeskripsi.setText(tvShow.getDeskripsi());

        Glide.with(this)
                .load(tvShow.getFoto())
                .centerCrop()
                .into(ivBackground);
        Glide.with(this)
                .load(tvShow.getFoto())
                .transform(new RoundedCornersTransformation(20, 10),new CenterCrop())
                .into(ivPhotoDiterima);

    }
}
