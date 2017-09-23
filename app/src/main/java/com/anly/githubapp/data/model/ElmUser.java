package com.anly.githubapp.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.StrictMode;
import android.util.StringBuilderPrinter;

/**
 * Created by 000 on 2017/9/18.
 */

public class ElmUser implements Parcelable {

/*    {
         username: "1",
         user_id: 2,
         id: 2,
         point: 0,
         mobile: "",
         is_mobile_valid: true,
         is_email_valid: false,
         is_active: 1,
         gift_amount: 3,
         email: "",
         delivery_card_expire_days: 0,
         current_invoice_id: 0,
         current_address_id: 0,
         brand_member_new: 0,
         balance: 0,
         avatar: "/img/default/default.jpg",
         __v: 0
     }*/

    private String username;
    private int user_id;
    private int id;
    private int point;
    private String mobile;
    private boolean is_mobile_valid;
    private boolean is_email_valid;
    private int is_active;
    private int gift_amount;
    private String email;
    private int delivery_card_expire_days;
    private int current_invoice_id;
    private int current_address_id;
    private int brand_member_new;
    private int balance;
    private String avatar;
    private int __v;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean is_mobile_valid() {
        return is_mobile_valid;
    }

    public void setIs_mobile_valid(boolean is_mobile_valid) {
        this.is_mobile_valid = is_mobile_valid;
    }

    public boolean is_email_valid() {
        return is_email_valid;
    }

    public void setIs_email_valid(boolean is_email_valid) {
        this.is_email_valid = is_email_valid;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public int getGift_amount() {
        return gift_amount;
    }

    public void setGift_amount(int gift_amount) {
        this.gift_amount = gift_amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDelivery_card_expire_days() {
        return delivery_card_expire_days;
    }

    public void setDelivery_card_expire_days(int delivery_card_expire_days) {
        this.delivery_card_expire_days = delivery_card_expire_days;
    }

    public int getCurrent_invoice_id() {
        return current_invoice_id;
    }

    public void setCurrent_invoice_id(int current_invoice_id) {
        this.current_invoice_id = current_invoice_id;
    }

    public int getCurrent_address_id() {
        return current_address_id;
    }

    public void setCurrent_address_id(int current_address_id) {
        this.current_address_id = current_address_id;
    }

    public int getBrand_member_new() {
        return brand_member_new;
    }

    public void setBrand_member_new(int brand_member_new) {
        this.brand_member_new = brand_member_new;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeInt(this.user_id);
        parcel.writeInt(this.id);
        parcel.writeInt(this.point);
        parcel.writeString(this.mobile);
        parcel.writeByte(this.is_mobile_valid ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.is_email_valid ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.is_active);
        parcel.writeInt(this.gift_amount);
        parcel.writeString(this.email);
        parcel.writeInt(this.delivery_card_expire_days);
        parcel.writeInt(this.current_invoice_id);
        parcel.writeInt(this.current_address_id);
        parcel.writeInt(this.balance);
        parcel.writeString(this.avatar);
        parcel.writeInt(this.__v);
    }

    public ElmUser() {
    }

    protected ElmUser(Parcel in) {
        this.username = in.readString();
        this.user_id = in.readInt();
        this.id = in.readInt();
        this.point = in.readInt();
        this.mobile = in.readString();
        this.is_mobile_valid = in.readByte() != 0;
        this.is_email_valid = in.readByte() != 0;
        this.is_active = in.readInt();
        this.gift_amount = in.readInt();
        this.email = in.readString();
        this.delivery_card_expire_days = in.readInt();
        this.current_invoice_id = in.readInt();
        this.current_address_id = in.readInt();
        this.balance = in.readInt();
        this.avatar = in.readString();
        this.__v = in.readInt();
    }

    public static final Parcelable.Creator<ElmUser> CREATOR = new Parcelable.Creator<ElmUser>() {
        @Override
        public ElmUser createFromParcel(Parcel source) {
            return new ElmUser(source);
        }

        @Override
        public ElmUser[] newArray(int size) {
            return new ElmUser[size];
        }
    };

}
