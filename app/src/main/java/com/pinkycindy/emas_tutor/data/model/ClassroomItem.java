package com.pinkycindy.emas_tutor.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ClassroomItem implements Parcelable {

	@SerializedName("day_second")
	private int daySecond;

	@SerializedName("spot_id")
	private int spotId;

	@SerializedName("day_first")
	private int dayFirst;

	@SerializedName("hour_first")
	private String hourFirst;

	@SerializedName("description")
	private String description;

	@SerializedName("type_class")
	private String typeClass;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("capacity")
	private int capacity;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("employee_id")
	private int employeeId;

	@SerializedName("hour_second")
	private String hourSecond;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public void setDaySecond(int daySecond){
		this.daySecond = daySecond;
	}

	public int getDaySecond(){
		return daySecond;
	}

	public void setSpotId(int spotId){
		this.spotId = spotId;
	}

	public int getSpotId(){
		return spotId;
	}

	public void setDayFirst(int dayFirst){
		this.dayFirst = dayFirst;
	}

	public int getDayFirst(){
		return dayFirst;
	}

	public void setHourFirst(String hourFirst){
		this.hourFirst = hourFirst;
	}

	public String getHourFirst(){
		return hourFirst;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setTypeClass(String typeClass){
		this.typeClass = typeClass;
	}

	public String getTypeClass(){
		return typeClass;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setCapacity(int capacity){
		this.capacity = capacity;
	}

	public int getCapacity(){
		return capacity;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setEmployeeId(int employeeId){
		this.employeeId = employeeId;
	}

	public int getEmployeeId(){
		return employeeId;
	}

	public void setHourSecond(String hourSecond){
		this.hourSecond = hourSecond;
	}

	public String getHourSecond(){
		return hourSecond;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
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
			"ClassroomItem{" + 
			"day_second = '" + daySecond + '\'' + 
			",spot_id = '" + spotId + '\'' + 
			",day_first = '" + dayFirst + '\'' + 
			",hour_first = '" + hourFirst + '\'' + 
			",description = '" + description + '\'' + 
			",type_class = '" + typeClass + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",capacity = '" + capacity + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",employee_id = '" + employeeId + '\'' + 
			",hour_second = '" + hourSecond + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.daySecond);
		dest.writeInt(this.spotId);
		dest.writeInt(this.dayFirst);
		dest.writeString(this.hourFirst);
		dest.writeString(this.description);
		dest.writeString(this.typeClass);
		dest.writeString(this.createdAt);
		dest.writeInt(this.capacity);
		dest.writeString(this.updatedAt);
		dest.writeInt(this.employeeId);
		dest.writeString(this.hourSecond);
		dest.writeString(this.name);
		dest.writeInt(this.id);
	}

	public ClassroomItem() {
	}

	protected ClassroomItem(Parcel in) {
		this.daySecond = in.readInt();
		this.spotId = in.readInt();
		this.dayFirst = in.readInt();
		this.hourFirst = in.readString();
		this.description = in.readString();
		this.typeClass = in.readString();
		this.createdAt = in.readString();
		this.capacity = in.readInt();
		this.updatedAt = in.readString();
		this.employeeId = in.readInt();
		this.hourSecond = in.readString();
		this.name = in.readString();
		this.id = in.readInt();
	}

	public static final Creator<ClassroomItem> CREATOR = new Creator<ClassroomItem>() {
		@Override
		public ClassroomItem createFromParcel(Parcel source) {
			return new ClassroomItem(source);
		}

		@Override
		public ClassroomItem[] newArray(int size) {
			return new ClassroomItem[size];
		}
	};
}