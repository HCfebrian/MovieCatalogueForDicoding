package com.example.moviecataloguefordicoding.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelFilm implements Parcelable {
    private String judul;
    private String deskripsi;
    private int foto;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }


    public ModelFilm() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeInt(this.foto);
        dest.writeString(this.deskripsi);
    }

    protected ModelFilm(Parcel in) {
        this.judul = in.readString();
        this.foto = in.readInt();
        this.deskripsi = in.readString();
    }

    public static final Creator<ModelFilm> CREATOR = new Creator<ModelFilm>() {
        @Override
        public ModelFilm createFromParcel(Parcel source) {
            return new ModelFilm(source);
        }

        @Override
        public ModelFilm[] newArray(int size) {
            return new ModelFilm[size];
        }
    };
}
