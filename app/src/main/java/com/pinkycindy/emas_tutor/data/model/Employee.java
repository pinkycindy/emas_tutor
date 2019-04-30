package com.pinkycindy.emas_tutor.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Employee  implements Parcelable {

	@SerializedName("birthday")
	private String birthday;

	@SerializedName("address")
	private String address;

	@SerializedName("gender")
	private String gender;

	@SerializedName("pass")
	private String pass;

	@SerializedName("propinsi_id")
	private int propinsiId;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("avatar")
	private String avatar;

	@SerializedName("kecamatan_id")
	private int kecamatanId;

	@SerializedName("kabupaten")
	private List<KabupatenItem> kabupaten;

	@SerializedName("kelurahan")
	private List<KelurahanItem> kelurahan;

	@SerializedName("propinsi")
	private List<PropinsiItem> propinsi;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("phone")
	private String phone;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("kelurahan_id")
	private int kelurahanId;

	@SerializedName("kabupaten_id")
	private int kabupatenId;

	@SerializedName("name")
	private String name;

	@SerializedName("kecamatan")
	private List<KecamatanItem> kecamatan;

	@SerializedName("id")
	private int id;

	@SerializedName("classsroom")
	private List<ClassroomItem> classsroom;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getPropinsiId() {
		return propinsiId;
	}

	public void setPropinsiId(int propinsiId) {
		this.propinsiId = propinsiId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getKecamatanId() {
		return kecamatanId;
	}

	public void setKecamatanId(int kecamatanId) {
		this.kecamatanId = kecamatanId;
	}

	public List<KabupatenItem> getKabupaten() {
		return kabupaten;
	}

	public void setKabupaten(List<KabupatenItem> kabupaten) {
		this.kabupaten = kabupaten;
	}

	public List<KelurahanItem> getKelurahan() {
		return kelurahan;
	}

	public void setKelurahan(List<KelurahanItem> kelurahan) {
		this.kelurahan = kelurahan;
	}

	public List<PropinsiItem> getPropinsi() {
		return propinsi;
	}

	public void setPropinsi(List<PropinsiItem> propinsi) {
		this.propinsi = propinsi;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getKelurahanId() {
		return kelurahanId;
	}

	public void setKelurahanId(int kelurahanId) {
		this.kelurahanId = kelurahanId;
	}

	public int getKabupatenId() {
		return kabupatenId;
	}

	public void setKabupatenId(int kabupatenId) {
		this.kabupatenId = kabupatenId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<KecamatanItem> getKecamatan() {
		return kecamatan;
	}

	public void setKecamatan(List<KecamatanItem> kecamatan) {
		this.kecamatan = kecamatan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ClassroomItem> getClasssroom() {
		return classsroom;
	}

	public void setClasssroom(List<ClassroomItem> classsroom) {
		this.classsroom = classsroom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(this.name);
		parcel.writeString(this.address);
		parcel.writeString(this.avatar);
		parcel.writeString(this.birthday);
		parcel.writeString(this.createdAt);
		parcel.writeString(this.email);
		parcel.writeString(this.gender);
		parcel.writeString(this.pass);
		parcel.writeString(this.phone);
		parcel.writeString(this.updatedAt);
		parcel.writeString(this.username);
		parcel.writeInt(this.id);
		parcel.writeInt(this.kabupatenId);
		parcel.writeInt(this.kecamatanId);
		parcel.writeInt(this.kelurahanId);
		parcel.writeInt(this.propinsiId);
		parcel.writeInt(this.userId);
		if (kelurahan == null) {
			parcel.writeByte((byte) (0x00));
		} else {
			parcel.writeByte((byte) (0x01));
			parcel.writeList(kelurahan);
		}
		if (classsroom == null) {
			parcel.writeByte((byte) (0x00));
		} else {
			parcel.writeByte((byte) (0x01));
			parcel.writeList(classsroom);
		}



	}

	protected Employee(Parcel in)
	{
		name = in.readString();
		if (in.readByte() == 0x01) {
			kelurahan = new ArrayList<KelurahanItem>();
			in.readList(kelurahan, String.class.getClassLoader());
		} else {
			kelurahan = null;
		}

		if (in.readByte() == 0x01) {
			classsroom = new ArrayList<ClassroomItem>();
			in.readList(classsroom, String.class.getClassLoader());
		} else {
			classsroom = null;
		}

	}
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
		public Employee createFromParcel(Parcel in) {
			return new Employee(in);
		}

		public Employee[] newArray(int size) {
			return new Employee[size];
		}
	};

	public Employee(){

	}
	public Employee(String birthday, String address, String gender, String pass, int propinsiId, String createdAt, String avatar, int kecamatanId, List<KabupatenItem> kabupaten, List<KelurahanItem> kelurahan, List<PropinsiItem> propinsi, String updatedAt, String phone, int userId, int kelurahanId, int kabupatenId, String name, List<KecamatanItem> kecamatan, int id, List<ClassroomItem> classsroom, String email, String username) {
		this.birthday = birthday;
		this.address = address;
		this.gender = gender;
		this.pass = pass;
		this.propinsiId = propinsiId;
		this.createdAt = createdAt;
		this.avatar = avatar;
		this.kecamatanId = kecamatanId;
		this.kabupaten = kabupaten;
		this.kelurahan = kelurahan;
		this.propinsi = propinsi;
		this.updatedAt = updatedAt;
		this.phone = phone;
		this.userId = userId;
		this.kelurahanId = kelurahanId;
		this.kabupatenId = kabupatenId;
		this.name = name;
		this.kecamatan = kecamatan;
		this.id = id;
		this.classsroom = classsroom;
		this.email = email;
		this.username = username;
	}
}