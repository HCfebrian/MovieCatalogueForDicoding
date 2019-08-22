package com.example.moviecataloguefordicoding.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelTvSHow implements Parcelable {
    private String judul,deskripsi,genre,durasi, studio,rating,namaPemeran;
    private int foto,pemeran;

    public ModelTvSHow() {
    }

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getNamaPemeran() {
        return namaPemeran;
    }

    public void setNamaPemeran(String namaPemeran) {
        this.namaPemeran = namaPemeran;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getPemeran() {
        return pemeran;
    }

    public void setPemeran(int pemeran) {
        this.pemeran = pemeran;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.deskripsi);
        dest.writeString(this.genre);
        dest.writeString(this.durasi);
        dest.writeString(this.studio);
        dest.writeString(this.rating);
        dest.writeString(this.namaPemeran);
        dest.writeInt(this.foto);
        dest.writeInt(this.pemeran);
    }

    protected ModelTvSHow(Parcel in) {
        this.judul = in.readString();
        this.deskripsi = in.readString();
        this.genre = in.readString();
        this.durasi = in.readString();
        this.studio = in.readString();
        this.rating = in.readString();
        this.namaPemeran = in.readString();
        this.foto = in.readInt();
        this.pemeran = in.readInt();
    }

    public static final Parcelable.Creator<ModelTvSHow> CREATOR = new Parcelable.Creator<ModelTvSHow>() {
        @Override
        public ModelTvSHow createFromParcel(Parcel source) {
            return new ModelTvSHow(source);
        }

        @Override
        public ModelTvSHow[] newArray(int size) {
            return new ModelTvSHow[size];
        }
    };
}
