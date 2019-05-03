package com.pinkycindy.emas_tutor.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Employee implements Parcelable {

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

	@SerializedName("classroom")
	private ArrayList<ClassroomItem> classroom;

	@SerializedName("avatar")
	private String avatar;

	@SerializedName("kecamatan_id")
	private int kecamatanId;

	@SerializedName("kabupaten")
	private ArrayList<KabupatenItem> kabupaten;

	@SerializedName("kelurahan")
	private ArrayList<KelurahanItem> kelurahan;

	@SerializedName("propinsi")
	private ArrayList<PropinsiItem> propinsi;

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
	private ArrayList<KecamatanItem> kecamatan;

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public static Creator<Employee> getCREATOR() {
		return CREATOR;
	}

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

	public ArrayList<ClassroomItem> getClassroom() {
		return classroom;
	}

	public void setClassroom(ArrayList<ClassroomItem> classroom) {
		this.classroom = classroom;
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

	public ArrayList<KabupatenItem> getKabupaten() {
		return kabupaten;
	}

	public void setKabupaten(ArrayList<KabupatenItem> kabupaten) {
		this.kabupaten = kabupaten;
	}

	public ArrayList<KelurahanItem> getKelurahan() {
		return kelurahan;
	}

	public void setKelurahan(ArrayList<KelurahanItem> kelurahan) {
		this.kelurahan = kelurahan;
	}

	public ArrayList<PropinsiItem> getPropinsi() {
		return propinsi;
	}

	public void setPropinsi(ArrayList<PropinsiItem> propinsi) {
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

	public ArrayList<KecamatanItem> getKecamatan() {
		return kecamatan;
	}

	public void setKecamatan(ArrayList<KecamatanItem> kecamatan) {
		this.kecamatan = kecamatan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
 	public String toString(){
		return 
			"Employee{" +
			"birthday = '" + birthday + '\'' + 
			",address = '" + address + '\'' + 
			",gender = '" + gender + '\'' + 
			",pass = '" + pass + '\'' + 
			",propinsi_id = '" + propinsiId + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",classroom = '" + classroom + '\'' + 
			",avatar = '" + avatar + '\'' + 
			",kecamatan_id = '" + kecamatanId + '\'' + 
			",kabupaten = '" + kabupaten + '\'' + 
			",kelurahan = '" + kelurahan + '\'' + 
			",propinsi = '" + propinsi + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",phone = '" + phone + '\'' + 
			",user_id = '" + userId + '\'' + 
			",kelurahan_id = '" + kelurahanId + '\'' + 
			",kabupaten_id = '" + kabupatenId + '\'' + 
			",name = '" + name + '\'' + 
			",kecamatan = '" + kecamatan + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.birthday);
		dest.writeString(this.address);
		dest.writeString(this.gender);
		dest.writeString(this.pass);
		dest.writeInt(this.propinsiId);
		dest.writeString(this.createdAt);
		dest.writeList(this.classroom);
		dest.writeString(this.avatar);
		dest.writeInt(this.kecamatanId);
		dest.writeList(this.kabupaten);
		dest.writeList(this.kelurahan);
		dest.writeList(this.propinsi);
		dest.writeString(this.updatedAt);
		dest.writeString(this.phone);
		dest.writeInt(this.userId);
		dest.writeInt(this.kelurahanId);
		dest.writeInt(this.kabupatenId);
		dest.writeString(this.name);
		dest.writeList(this.kecamatan);
		dest.writeInt(this.id);
		dest.writeString(this.email);
		dest.writeString(this.username);
	}

	public Employee() {
	}

	protected Employee(Parcel in) {
		this.birthday = in.readString();
		this.address = in.readString();
		this.gender = in.readString();
		this.pass = in.readString();
		this.propinsiId = in.readInt();
		this.createdAt = in.readString();
		this.classroom = new ArrayList<ClassroomItem>();
		in.readList(this.classroom, ClassroomItem.class.getClassLoader());
		this.avatar = in.readString();
		this.kecamatanId = in.readInt();
		this.kabupaten = new ArrayList<KabupatenItem>();
		in.readList(this.kabupaten, KabupatenItem.class.getClassLoader());
		this.kelurahan = new ArrayList<KelurahanItem>();
		in.readList(this.kelurahan, KelurahanItem.class.getClassLoader());
		this.propinsi = new ArrayList<PropinsiItem>();
		in.readList(this.propinsi, PropinsiItem.class.getClassLoader());
		this.updatedAt = in.readString();
		this.phone = in.readString();
		this.userId = in.readInt();
		this.kelurahanId = in.readInt();
		this.kabupatenId = in.readInt();
		this.name = in.readString();
		this.kecamatan = new ArrayList<KecamatanItem>();
		in.readList(this.kecamatan, KecamatanItem.class.getClassLoader());
		this.id = in.readInt();
		this.email = in.readString();
		this.username = in.readString();
	}

	public static final Creator<Employee> CREATOR = new Creator<Employee>() {
		@Override
		public Employee createFromParcel(Parcel source) {
			return new Employee(source);
		}

		@Override
		public Employee[] newArray(int size) {
			return new Employee[size];
		}
	};
}