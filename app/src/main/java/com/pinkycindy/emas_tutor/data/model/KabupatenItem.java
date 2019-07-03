package com.pinkycindy.emas_tutor.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class KabupatenItem implements Parcelable {

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
			"KabupatenItem{" + 
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

	public KabupatenItem() {
	}

	protected KabupatenItem(Parcel in) {
		this.nama = in.readString();
		this.id = in.readInt();
	}

	public static final Parcelable.Creator<KabupatenItem> CREATOR = new Parcelable.Creator<KabupatenItem>() {
		@Override
		public KabupatenItem createFromParcel(Parcel source) {
			return new KabupatenItem(source);
		}

		@Override
		public KabupatenItem[] newArray(int size) {
			return new KabupatenItem[size];
		}
	};
}