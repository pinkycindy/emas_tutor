package com.pinkycindy.emas_tutor.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class KecamatanItem implements Parcelable {

	@SerializedName("nama")
	private String nama;

	@SerializedName("id")
	private int id;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"KecamatanItem{" + 
			"nama = '" + nama + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.nama);
		dest.writeInt(this.id);
	}

	public KecamatanItem() {
	}

	protected KecamatanItem(Parcel in) {
		this.nama = in.readString();
		this.id = in.readInt();
	}

	public static final Parcelable.Creator<KecamatanItem> CREATOR = new Parcelable.Creator<KecamatanItem>() {
		@Override
		public KecamatanItem createFromParcel(Parcel source) {
			return new KecamatanItem(source);
		}

		@Override
		public KecamatanItem[] newArray(int size) {
			return new KecamatanItem[size];
		}
	};
}