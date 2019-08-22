package com.example.moviecataloguefordicoding.Adapter;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.moviecataloguefordicoding.DetailMovieActivity;
import com.example.moviecataloguefordicoding.Model.ModelFilm;
import com.example.moviecataloguefordicoding.R;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;



public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private ArrayList<ModelFilm> listMovie;




    public MovieAdapter(ArrayList<ModelFilm> list) {
        this.listMovie = list;
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_film,viewGroup,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieAdapter.MovieViewHolder movieViewHolder, int i) {
        final ModelFilm film = listMovie.get(i);

        movieViewHolder.tvTitle.setText(film.getJudul());
        movieViewHolder.tvDescription.setText(film.getDeskripsi());
        Glide.with(movieViewHolder.itemView.getContext())
                .load(film.getFoto())
                .transform(new RoundedCornersTransformation(20, 10), new CenterCrop())
                .into(movieViewHolder.ivPoster);


        movieViewHolder.rlItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailMovieActivity.class);
                intent.putExtra("EXTRA_FILM",listMovie.get(movieViewHolder.getAdapterPosition()));
                v.getContext().startActivity(intent);
            }
        });
        }


    @Override
    public int getItemCount() {
        return listMovie.size();
    }



    class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPoster;
        TextView tvTitle, tvDescription;
        RelativeLayout rlItem;
        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPoster = itemView.findViewById(R.id.iv_film_photo);
            tvTitle = itemView.findViewById(R.id.tv_judul);
            tvDescription = itemView.findViewById(R.id.tv_deskripsi);
            rlItem = itemView.findViewById(R.id.list_item);


        }
    }


}

//    private Context context;
//    private ArrayList<ModelFilm> films;
//
//    public void setFilms(ArrayList<ModelFilm> films) {
//        this.films = films;
//    }
//
//    public MovieAdapter(Context context) {
//        this.context = context;
//        films = new ArrayList<>();
//    }
//
//
//    @Override
//    public int getCount() {
//        return films.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return films.get(position);
//    }
//
//    @NonNull
//    @Override
//    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder movieViewHolder, int i) {
//
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if(convertView == null){
//            convertView = LayoutInflater.from(context).inflate(R.layout.list_film,parent,false);
//        }
//        ViewHolder viewHolder = new ViewHolder(convertView);
//        ModelFilm film = (ModelFilm) getItem(position);
//        viewHolder.bind(film);
//        return convertView;
//    }
//
//    private class ViewHolder {
//        private TextView txtJudul;
//        private TextView txtDeskripsi;
//        private ImageView ivFilm;
//
//        ViewHolder (View view){
//        txtJudul = view.findViewById(R.id.tv_judul);
//        txtDeskripsi = view.findViewById(R.id.tv_deskripsi);
//        ivFilm = view.findViewById(R.id.iv_film_photo);
//
//        }
//
//        void bind(ModelFilm film){
//        txtJudul.setText(film.getJudul());
//        txtDeskripsi.setText(film.getDeskripsi());
////        imgFilm.setImageResource(film.getFoto());
//        Glide.with(context)
//                .load(film.getFoto())
//                .transform(new RoundedCornersTransformation(20, 10), new CenterCrop())
//                .into(ivFilm);
//        }
//    }

