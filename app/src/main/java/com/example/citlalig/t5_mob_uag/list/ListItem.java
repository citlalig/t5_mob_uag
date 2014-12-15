package com.example.citlalig.t5_mob_uag.list;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jerry on 15/11/14.
 */
public class ListItem implements Parcelable {

    //Variable
    private String header = null;
    private String subHeader = null;
    private Drawable imageUser = null;

    public ListItem() {

    }

    public ListItem(Parcel source) {
        header = source.readString();
        subHeader = source.readString();

        Bitmap bitmap = (Bitmap) source.readParcelable(((Object) this).getClass().getClassLoader());
        if ( bitmap != null ) {
            imageUser = new BitmapDrawable(bitmap);
        }
        else {
            imageUser = null;
        }

    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }


    public String getSubHeader() {
        return subHeader;
    }

    public void setSubHeader(String subHeader) {
        this.subHeader = subHeader;
    }

    public Drawable getImageUser() {
        return imageUser;
    }

    public void setImageUser(Drawable imageUser) {
        this.imageUser = imageUser;
    }


    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(header);
        dest.writeString(subHeader);

        if (imageUser != null) {
            Bitmap bitmap = ((BitmapDrawable) imageUser).getBitmap();
            dest.writeParcelable(bitmap, flags);
        } else {
            dest.writeParcelable(null, flags);
        }
    }

    public static final Parcelable.Creator<ListItem> CREATOR  = new Parcelable.Creator<ListItem>() {
        public ListItem createFromParcel(Parcel in) {
            return new ListItem(in);
        }

        public ListItem[] newArray(int size) {
            return new ListItem[size];
        }
    };

    @Override
    public int hashCode() {
        int result = header != null ? header.hashCode() : 0;
        result = 31 * result + (subHeader != null ? subHeader.hashCode() : 0);
        result = 31 * result + (imageUser != null ? imageUser.hashCode() : 0);
        return result;
    }
}