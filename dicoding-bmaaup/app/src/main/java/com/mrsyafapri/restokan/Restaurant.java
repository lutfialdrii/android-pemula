package com.mrsyafapri.restokan;

import android.os.Parcel;
import android.os.Parcelable;

public class Restaurant implements Parcelable {
    private String name;
    private String desc;
    private String address;
    private double rating;
    private int photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.desc);
        dest.writeString(this.address);
        dest.writeDouble(this.rating);
        dest.writeInt(this.photo);
    }

    public Restaurant() {
    }

    protected Restaurant(Parcel in) {
        this.name = in.readString();
        this.desc = in.readString();
        this.address = in.readString();
        this.rating = in.readDouble();
        this.photo = in.readInt();
    }

    public static final Parcelable.Creator<Restaurant> CREATOR = new Parcelable.Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel source) {
            return new Restaurant(source);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };
}
