package com.pinkycindy.emas_tutor.data.model;

import com.google.gson.annotations.SerializedName;

public class KelurahanItem{

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
			"KelurahanItem{" + 
			"nama = '" + nama + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}