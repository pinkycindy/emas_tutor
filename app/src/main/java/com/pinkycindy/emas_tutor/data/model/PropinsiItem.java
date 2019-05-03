package com.pinkycindy.emas_tutor.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PropinsiItem implements Parcelable {

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
			"PropinsiItem{" + 
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

	public PropinsiItem() {
	}

	protected PropinsiItem(Parcel in) {
		this.nama = in.readString();
		this.id = in.readInt();
	}

	public static final Creator<PropinsiItem> CREATOR = new Creator<PropinsiItem>() {
		@Override
		public PropinsiItem createFromParcel(Parcel source) {
			return new PropinsiItem(source);
		}

		@Override
		public PropinsiItem[] newArray(int size) {
			return new PropinsiItem[size];
		}
	};
}