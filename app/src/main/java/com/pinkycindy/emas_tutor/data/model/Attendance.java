package com.pinkycindy.emas_tutor.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Pinky Cindy
 */
public class Attendance implements Parcelable {

    @SerializedName("id")
    private int id;

    @SerializedName("employee_id")
    private int empId;

    @SerializedName("classroom_id")
    private int classroomId;

    @SerializedName("classroom_name")
    private String classroomName;

    @SerializedName("spot_name")
    private String spotName;

    @SerializedName("spot_id")
    private String spotId;


    @SerializedName("checkoin")
    private String checkin;

    @SerializedName("checkout")
    private String checkout;

    @SerializedName("work_hours")
    private int workHour;

    @SerializedName("checkin_lat")
    private Double checkinLat;

    @SerializedName("checkin_lng")
    private Double checkinLng;

    @SerializedName("checkout_lat")
    private Double checkoutLat;

    @SerializedName("checkout_lng")
    private Double checkoutLng;

    @SerializedName("photo_file_name")
    private String photoFile;

    @SerializedName("photo_current_type")
    private String photoType;

    @SerializedName("photo_file_size")
    private String photoSize;

    @SerializedName("photo_updated_at")
    private String photoUpdateat;

    @SerializedName("description")
    private String description;

    @SerializedName("topic")
    private String topic;

    @SerializedName("participant")
    private int participant;

    @SerializedName("Strenght")
    private String Strenght;

    @SerializedName("Weaknes")
    private String Weaknes;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("sub_topic")
    private String subTopic;

    @SerializedName("employee")
    private ArrayList<Employee> employee;

    @SerializedName("spot")
    private ArrayList<SpotItem> spot;

    @SerializedName("classroom")
    private ArrayList<ClassroomItem> classroom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }



    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public int getWorkHour() {
        return workHour;
    }

    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }

    public Double getCheckinLat() {
        return checkinLat;
    }

    public void setCheckinLat(Double checkinLat) {
        this.checkinLat = checkinLat;
    }

    public Double getCheckinLng() {
        return checkinLng;
    }

    public void setCheckinLng(Double checkinLng) {
        this.checkinLng = checkinLng;
    }

    public Double getCheckoutLat() {
        return checkoutLat;
    }

    public void setCheckoutLat(Double checkoutLat) {
        this.checkoutLat = checkoutLat;
    }

    public Double getCheckoutLng() {
        return checkoutLng;
    }

    public void setCheckoutLng(Double checkoutLng) {
        this.checkoutLng = checkoutLng;
    }

    public String getPhotoFile() {
        return photoFile;
    }

    public void setPhotoFile(String photoFile) {
        this.photoFile = photoFile;
    }

    public String getPhotoType() {
        return photoType;
    }

    public void setPhotoType(String photoType) {
        this.photoType = photoType;
    }

    public String getPhotoSize() {
        return photoSize;
    }

    public void setPhotoSize(String photoSize) {
        this.photoSize = photoSize;
    }

    public String getPhotoUpdateat() {
        return photoUpdateat;
    }

    public void setPhotoUpdateat(String photoUpdateat) {
        this.photoUpdateat = photoUpdateat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getParticipant() {
        return participant;
    }

    public void setParticipant(int participant) {
        this.participant = participant;
    }

    public String getStrenght() {
        return Strenght;
    }

    public void setStrenght(String strenght) {
        Strenght = strenght;
    }

    public String getWeaknes() {
        return Weaknes;
    }

    public void setWeaknes(String weaknes) {
        Weaknes = weaknes;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getSubTopic() {
        return subTopic;
    }

    public void setSubTopic(String subTopic) {
        this.subTopic = subTopic;
    }

    public ArrayList<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(ArrayList<Employee> employee) {
        this.employee = employee;
    }

    public ArrayList<SpotItem> getSpot() {
        return spot;
    }

    public void setSpot(ArrayList<SpotItem> spot) {
        this.spot = spot;
    }

    public ArrayList<ClassroomItem> getClassroom() {
        return classroom;
    }

    public void setClassroom(ArrayList<ClassroomItem> classroom) {
        this.classroom = classroom;
    }

    public Attendance() {
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", empId=" + empId +
                ", classroomId=" + classroomId +
                ", classroomName='" + classroomName + '\'' +
                ", spotName='" + spotName + '\'' +
                ", spotId='" + spotId + '\'' +
                ", checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                ", workHour=" + workHour +
                ", checkinLat=" + checkinLat +
                ", checkinLng=" + checkinLng +
                ", checkoutLat=" + checkoutLat +
                ", checkoutLng=" + checkoutLng +
                ", photoFile='" + photoFile + '\'' +
                ", photoType='" + photoType + '\'' +
                ", photoSize='" + photoSize + '\'' +
                ", photoUpdateat='" + photoUpdateat + '\'' +
                ", description='" + description + '\'' +
                ", topic='" + topic + '\'' +
                ", participant=" + participant +
                ", Strenght='" + Strenght + '\'' +
                ", Weaknes='" + Weaknes + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", subTopic='" + subTopic + '\'' +
                ", employee=" + employee +
                ", spot=" + spot +
                ", classroom=" + classroom +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.empId);
        dest.writeInt(this.classroomId);
        dest.writeString(this.classroomName);
        dest.writeString(this.spotName);
        dest.writeString(this.spotId);
        dest.writeString(this.checkin);
        dest.writeString(this.checkout);
        dest.writeInt(this.workHour);
        dest.writeValue(this.checkinLat);
        dest.writeValue(this.checkinLng);
        dest.writeValue(this.checkoutLat);
        dest.writeValue(this.checkoutLng);
        dest.writeString(this.photoFile);
        dest.writeString(this.photoType);
        dest.writeString(this.photoSize);
        dest.writeString(this.photoUpdateat);
        dest.writeString(this.description);
        dest.writeString(this.topic);
        dest.writeInt(this.participant);
        dest.writeString(this.Strenght);
        dest.writeString(this.Weaknes);
        dest.writeString(this.createdAt);
        dest.writeString(this.updatedAt);
        dest.writeString(this.subTopic);
        dest.writeTypedList(this.employee);
        dest.writeTypedList(this.spot);
        dest.writeTypedList(this.classroom);
    }

    protected Attendance(Parcel in) {
        this.id = in.readInt();
        this.empId = in.readInt();
        this.classroomId = in.readInt();
        this.classroomName = in.readString();
        this.spotName = in.readString();
        this.spotId = in.readString();
        this.checkin = in.readString();
        this.checkout = in.readString();
        this.workHour = in.readInt();
        this.checkinLat = (Double) in.readValue(Double.class.getClassLoader());
        this.checkinLng = (Double) in.readValue(Double.class.getClassLoader());
        this.checkoutLat = (Double) in.readValue(Double.class.getClassLoader());
        this.checkoutLng = (Double) in.readValue(Double.class.getClassLoader());
        this.photoFile = in.readString();
        this.photoType = in.readString();
        this.photoSize = in.readString();
        this.photoUpdateat = in.readString();
        this.description = in.readString();
        this.topic = in.readString();
        this.participant = in.readInt();
        this.Strenght = in.readString();
        this.Weaknes = in.readString();
        this.createdAt = in.readString();
        this.updatedAt = in.readString();
        this.subTopic = in.readString();
        this.employee = in.createTypedArrayList(Employee.CREATOR);
        this.spot = in.createTypedArrayList(SpotItem.CREATOR);
        this.classroom = in.createTypedArrayList(ClassroomItem.CREATOR);
    }

    public static final Creator<Attendance> CREATOR = new Creator<Attendance>() {
        @Override
        public Attendance createFromParcel(Parcel source) {
            return new Attendance(source);
        }

        @Override
        public Attendance[] newArray(int size) {
            return new Attendance[size];
        }
    };
}
