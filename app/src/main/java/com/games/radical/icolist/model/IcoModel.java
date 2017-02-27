package com.games.radical.icolist.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.text.ICUCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by prajeetshrestha on 2/14/17.
 */

public class IcoModel implements Parcelable {
    public String name;
    public String openingDate;
    public String closingDate;
    public String description;
    public String imageUrl;

    public IcoModel(String name, String openingDate, String closingDate, String description, String imageUrl) {
        this.name = name;
        this.openingDate = openingDate;
        this.closingDate = closingDate;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.openingDate);
        dest.writeString(this.closingDate);
        dest.writeString(this.description);
        dest.writeString(this.imageUrl);

    }

    public IcoModel() {
    }

    protected IcoModel(Parcel in) {
        this.name = in.readString();
        this.openingDate = in.readString();
        this.closingDate = in.readString();
        this.description = in.readString();
        this.imageUrl = in.readString();

    }

    public static final Creator<IcoModel> CREATOR = new Creator<IcoModel>() {
        @Override
        public IcoModel createFromParcel(Parcel source) {
            return new IcoModel(source);
        }

        @Override
        public IcoModel[] newArray(int size) {
            return new IcoModel[size];
        }
    };
}
