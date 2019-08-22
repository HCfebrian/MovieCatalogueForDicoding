package com.example.moviecataloguefordicoding.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.moviecataloguefordicoding.Model.ModelTvSHow;
import com.example.moviecataloguefordicoding.R;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class TvShowAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ModelTvSHow> tvShow;

    public void setTvShow(ArrayList<ModelTvSHow> tvShow) {
        this.tvShow = tvShow;
    }

    public TvShowAdapter(Context context) {
        this.context = context;
        tvShow = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return tvShow.size();
    }

    @Override
    public Object getItem(int position) {
        return tvShow.get(position);
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
        ModelTvSHow show = (ModelTvSHow) getItem(position);
        viewHolder.bind(show);
        return convertView;
    }

    private class ViewHolder {
        private TextView txtJudul;
        private TextView txtDeskripsi;
        private ImageView ivTvShow;

        ViewHolder (View view){
        txtJudul = view.findViewById(R.id.tv_judul);
        txtDeskripsi = view.findViewById(R.id.tv_deskripsi);
        ivTvShow = view.findViewById(R.id.iv_film_photo);
        }

        void bind(ModelTvSHow tvShow){
        txtJudul.setText(tvShow.getJudul());
        txtDeskripsi.setText(tvShow.getDeskripsi());
        Glide.with(context)
                .load(tvShow.getFoto())
                .transform(new RoundedCornersTransformation(20, 10), new CenterCrop())
                .into(ivTvShow);
        }
    }
}
