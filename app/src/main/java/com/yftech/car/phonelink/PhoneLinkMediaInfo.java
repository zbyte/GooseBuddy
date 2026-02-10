package com.yftech.car.phonelink;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class PhoneLinkMediaInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR = null;
    public static final int MEDIA_STATUS_INVALID = 2;
    public static final int MEDIA_STATUS_PAUSE = 0;
    public static final int MEDIA_STATUS_PLAY = 1;
    private String album;
    private String artist;
    private long duration;
    private int isPlaying;
    private String phoneType;
    private long progress;
    private String song;

    static {
        PhoneLinkMediaInfo.CREATOR = new Parcelable.Creator() {
            public PhoneLinkMediaInfo createFromParcel(Parcel in) {
                PhoneLinkMediaInfo link = new PhoneLinkMediaInfo();
                link.phoneType = in.readString();
                link.song = in.readString();
                link.artist = in.readString();
                link.album = in.readString();
                link.progress = in.readLong();
                link.duration = in.readLong();
                link.isPlaying = in.readInt();
                return link;
            }

            public PhoneLinkMediaInfo[] newArray(int size) {
                return new PhoneLinkMediaInfo[size];
            }
        };
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlbum() {
        return this.album;
    }

    public String getArtist() {
        return this.artist;
    }

    public static Parcelable.Creator getCREATOR() {
        return PhoneLinkMediaInfo.CREATOR;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getPhoneType() {
        return this.phoneType;
    }

    public long getProgress() {
        return this.progress;
    }

    public String getSong() {
        return this.song;
    }

    public int isPlaying() {
        return this.isPlaying;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setIsPlaying(int isPlaying) {
        this.isPlaying = isPlaying;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public void setProgress(long progress) {
        this.progress = progress;
    }

    public void setSong(String song) {
        this.song = song;
    }

    @Override
    public String toString() {
        return "PhoneLinkMediaInfo{phoneType=\'" + this.phoneType + '\'' + ", song=\'" + this.song + '\'' + ", artist=\'" + this.artist + '\'' + ", album=\'" + this.album + '\'' + ", progress=" + this.progress + ", duration=" + this.duration + ", isPlaying=" + this.isPlaying + '}';
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.phoneType);
        dest.writeString(this.song);
        dest.writeString(this.artist);
        dest.writeString(this.album);
        dest.writeLong(this.progress);
        dest.writeLong(this.duration);
        dest.writeInt(this.isPlaying);
    }
}

