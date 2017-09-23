package com.anly.githubapp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 000 on 2017/9/22.
 */

public class Doctor implements Parcelable {

    private String name;
    private int did;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String desc;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeInt(this.did);
        parcel.writeString(this.desc);
    }

    public Doctor() {
    }

    protected Doctor(Parcel in) {
        this.name = in.readString();
        this.did = in.readInt();
        this.desc = in.readString();
    }

    public static final Parcelable.Creator<Doctor> CREATOR = new Parcelable.Creator<Doctor>() {
        @Override
        public Doctor createFromParcel(Parcel source) {
            return new Doctor(source);
        }

        @Override
        public Doctor[] newArray(int size) {
            return new Doctor[size];
        }
    };
}
