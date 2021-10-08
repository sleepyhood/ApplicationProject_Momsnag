package com.example.user.applicationproject_momsnag;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.CheckBox;

public class Alarms implements Parcelable{
    private String title;
    private String content;

   /*private int category;
    private String homepage;
    private String menu1;
    private String menu2;
    private String menu3;
    private CheckBox checkBox;*/

    public Alarms(){}


    public Alarms(String title, String content){
        this.title = title;
        //this.category = category;
        this.content = content;

       /* this.homepage = homepage;
        this.menu1 = menu1;
        this.menu2 = menu2;
        this.menu3 = menu3;*/
    }

    protected Alarms(Parcel in) {
        title = in.readString();
        content = in.readString();
       /* category = in.readInt();
        homepage = in.readString();
        menu1 = in.readString();
        menu2 = in.readString();
        menu3 = in.readString();*/
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(content);

        /*dest.writeInt(category);
        dest.writeString(homepage);
        dest.writeString(menu1);
        dest.writeString(menu2);
        dest.writeString(menu3);*/
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Alarms> CREATOR = new Parcelable.Creator<Alarms>() {
        @Override
        public Alarms createFromParcel(Parcel in) {
            return new Alarms(in);
        }

        @Override
        public Alarms[] newArray(int size) {
            return new Alarms[size];
        }
    };

    public String getTitle(){
        return title;
    }




    public String getContent() {
        return content;
    }

    /*public int getCategory() {
        return category;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getMenu1() {
        return menu1;
    }

    public String getMenu2() {
        return menu2;
    }

    public String getMenu3() {
        return menu3;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }*/
}

