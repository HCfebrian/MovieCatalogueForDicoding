package com.example.moviecataloguefordicoding.Data;

import com.example.moviecataloguefordicoding.Model.ModelFilm;
import com.example.moviecataloguefordicoding.R;

import java.util.ArrayList;

public class MovieData {
    public static String[][] movieData = new String[][]{
            {"A Star Is Born", "Romance","120 min","Sony Studio","A", "@drawable/poster_a_star","","haha"},
            {"Aquaman", "Action, Superhero","140 min","Worner Bros","E","@drawable/poster_aquaman","","haha"},
            {"Avenger Infinity War","Action, Superhero","180 min","Marvel Studio","E","@drawable/poster_avengerinfinity","","haha"},
            {"Bird Box","Thriller","120 min","21 Century","A","@drawable/poster_birdbox","","haha"},
            {"Bohemian Repshody","Music","140 min","Sony Studio","PG","@drawable/poster_bohemian","","haha"},
            {"Bumblebee","Action","120 min","21 Century","E","@drawable/poster_bumblebee","","haha"},
            {"Creed II","Action, Material Art","120 min","Sony Studio","PG","@drawable/poster_creed","","haha"},
            {"Deadpool","Action, Superhero","90 min","Sony Studio","A","@drawable/poster_deadpool","","haha"},
            {"How To Train Your Dragon 3","Fantasy","90 min","21 Century","E","@drawable/poster_dragon","","haha"},
            {"Dragon Ball Movie","Fantasy","140 min","Sony Studio","E","@drawable/poster_dragonball","","haha"},
            {"Glass","Drama","120 min","120 min","21 Century","PG","@drawable/poster_glass","","haha"},
            {"Hunter Killer","Thriller","140 min","Sony Studio","A","@drawable/poster_hunterkiller","","haha"},
            {"Marry Popins","Drama","120 min","Sony Studio","E","@drawable/poster_marrypopins","","haha"},
            {"Mortal Engines","Drama","140 min","21 Century","PG","@drawable/poster_mortalengine","","haha"},
            {"Preman Pensiun","Comedy","90 min","Sony Studio","E","@drawable/poster_preman","","haha"},
            {"Preman Pensiun","Comedy","90 min","Sony Studio","E","@drawable/poster_preman","","haha"},
            };

    public static int [] moviePicture = new int[]{
            R.drawable.poster_a_star,
            R.drawable.poster_aquaman,
            R.drawable.poster_avengerinfinity,
            R.drawable.poster_birdbox,
            R.drawable.poster_bohemian,
            R.drawable.poster_bumblebee,
            R.drawable.poster_creed,
            R.drawable.poster_deadpool,
            R.drawable.poster_dragonball,
            R.drawable.poster_glass,
            R.drawable.poster_hunterkiller,
            R.drawable.poster_marrypopins,
            R.drawable.poster_mortalengine,
            R.drawable.poster_preman,
            R.drawable.poster_preman
    };

    public static String[][] tvShowData = new String[][]{
            {"Hunter x Hunter", "Romance","120 min","Sony Studio","A", "@drawable/poster_a_star","","haha"},
            {"Aquaman", "Action, Superhero","140 min","Worner Bros","E","@drawable/poster_aquaman","","haha"},
            {"Avenger Infinity War","Action, Superhero","180 min","Marvel Studio","E","@drawable/poster_avengerinfinity","","haha"},
            {"Bird Box","Thriller","120 min","21 Century","A","@drawable/poster_birdbox","","haha"},
            {"Bohemian Repshody","Music","140 min","Sony Studio","PG","@drawable/poster_bohemian","","haha"},
            {"Bumblebee","Action","120 min","21 Century","E","@drawable/poster_bumblebee","","haha"},
            {"Creed II","Action, Material Art","120 min","Sony Studio","PG","@drawable/poster_creed","","haha"},
            {"Deadpool","Action, Superhero","90 min","Sony Studio","A","@drawable/poster_deadpool","","haha"},
            {"How To Train Your Dragon 3","Fantasy","90 min","21 Century","E","@drawable/poster_dragon","","haha"},
            {"Dragon Ball Movie","Fantasy","140 min","Sony Studio","E","@drawable/poster_dragonball","","haha"},
            {"Glass","Drama","120 min","120 min","21 Century","PG","@drawable/poster_glass","","haha"},
            {"Hunter Killer","Thriller","140 min","Sony Studio","A","@drawable/poster_hunterkiller","","haha"},
            {"Marry Popins","Drama","120 min","Sony Studio","E","@drawable/poster_marrypopins","","haha"},
            {"Mortal Engines","Drama","140 min","21 Century","PG","@drawable/poster_mortalengine","","haha"},
            {"Preman Pensiun","Comedy","90 min","Sony Studio","E","@drawable/poster_preman","","haha"},
            {"Preman Pensiun","Comedy","90 min","Sony Studio","E","@drawable/poster_preman","","haha"},
    };

    public static int [] tvShowPicture = new int[]{
            R.drawable.poster_a_star,
            R.drawable.poster_aquaman,
            R.drawable.poster_avengerinfinity,
            R.drawable.poster_birdbox,
            R.drawable.poster_bohemian,
            R.drawable.poster_bumblebee,
            R.drawable.poster_creed,
            R.drawable.poster_deadpool,
            R.drawable.poster_dragonball,
            R.drawable.poster_glass,
            R.drawable.poster_hunterkiller,
            R.drawable.poster_marrypopins,
            R.drawable.poster_mortalengine,
            R.drawable.poster_preman,
            R.drawable.poster_preman
    };
    public static ArrayList<ModelFilm> getListdata(){
        ArrayList<ModelFilm> list = new ArrayList<>();
        for (int i = 0; i<= moviePicture.length-1 ; i++ ){
            ModelFilm film = new ModelFilm();
            film.setJudul(movieData[i][0]);
            film.setGenre(movieData[i][1]);
            film.setDurasi(movieData[i][2]);
            film.setStudio(movieData[i][3]);
            film.setRating(movieData[i][4]);
            film.setDeskripsi(movieData[i][7]);
            film.setFoto(moviePicture[i]);
            list.add(film);
        }
        return list;
    }
    public static ArrayList<ModelFilm> getListDataTv(){
        ArrayList<ModelFilm> list = new ArrayList<>();
        for (int i = 0; i<= moviePicture.length-1 ; i++ ){
            ModelFilm film = new ModelFilm();
            film.setJudul(tvShowData[i][0]);
            film.setGenre(tvShowData[i][1]);
            film.setDurasi(tvShowData[i][2]);
            film.setStudio(tvShowData[i][3]);
            film.setRating(tvShowData[i][4]);
            film.setDeskripsi(tvShowData[i][7]);
            film.setFoto(tvShowPicture[i]);
            list.add(film);
        }
        return list;
    }
}
