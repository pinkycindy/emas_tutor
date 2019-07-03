package com.pinkycindy.emas_tutor.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Pinky Cindy
 */
public class SpotItem implements Parcelable {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("address")
    private String address;

    @SerializedName("lat")
    private Double lat;

    @SerializedName("lng")
    private Double lng;

    @SerializedName("propinsi_id")
    private int propinsiId;

    @SerializedName("kabupaten_id")
    private int kabupatenId;

    @SerializedName("kecamatan_id")
    private int kecamatanId;

    @SerializedName("kelurahan_id")
    private int kelurahanId;

    @SerializedName("children_total")
    private int childrenTotal;

    @SerializedName("teenager_total")
    private int teenegarTotal;

    @SerializedName("adult_total")
    private int adultTotal;

    @SerializedName("photo_file_name")
    private String photoFile;

    @SerializedName("photo_content_type")
    private String photoType;

    @SerializedName("photo_update_at")
    private String photoUpdateat;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("update_at")
    private String updateAt;


    @SerializedName("propinsi")
    private ArrayList<PropinsiItem> propinsi;

    @SerializedName("kabupaten")
    private ArrayList<KabupatenItem> kabupaten;

    @SerializedName("kecamatan")
    private ArrayList<KecamatanItem> kecamatan;

    @SerializedName("kelurahan")
    private ArrayList<KelurahanItem> kelurahan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public int getPropinsiId() {
        return propinsiId;
    }

    public void setPropinsiId(int propinsiId) {
        this.propinsiId = propinsiId;
    }

    public int getKabupatenId() {
        return kabupatenId;
    }

    public void setKabupatenId(int kabupatenId) {
        this.kabupatenId = kabupatenId;
    }

    public int getKecamatanId() {
        return kecamatanId;
    }

    public void setKecamatanId(int kecamatanId) {
        this.kecamatanId = kecamatanId;
    }

    public int getKelurahanId() {
        return kelurahanId;
    }

    public void setKelurahanId(int kelurahanId) {
        this.kelurahanId = kelurahanId;
    }

    public int getChildrenTotal() {
        return childrenTotal;
    }

    public void setChildrenTotal(int childrenTotal) {
        this.childrenTotal = childrenTotal;
    }

    public int getTeenegarTotal() {
        return teenegarTotal;
    }

    public void setTeenegarTotal(int teenegarTotal) {
        this.teenegarTotal = teenegarTotal;
    }

    public int getAdultTotal() {
        return adultTotal;
    }

    public void setAdultTotal(int adultTotal) {
        this.adultTotal = adultTotal;
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

    public String getPhotoUpdateat() {
        return photoUpdateat;
    }

    public void setPhotoUpdateat(String photoUpdateat) {
        this.photoUpdateat = photoUpdateat;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public ArrayList<PropinsiItem> getPropinsi() {
        return propinsi;
    }

    public void setPropinsi(ArrayList<PropinsiItem> propinsi) {
        this.propinsi = propinsi;
    }

    public ArrayList<KabupatenItem> getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(ArrayList<KabupatenItem> kabupaten) {
        this.kabupaten = kabupaten;
    }

    public ArrayList<KecamatanItem> getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(ArrayList<KecamatanItem> kecamatan) {
        this.kecamatan = kecamatan;
    }

    public ArrayList<KelurahanItem> getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(ArrayList<KelurahanItem> kelurahan) {
        this.kelurahan = kelurahan;
    }

    @Override
    public String toString() {
        return "SpotItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", propinsiId=" + propinsiId +
                ", kabupatenId=" + kabupatenId +
                ", kecamatanId=" + kecamatanId +
                ", kelurahanId=" + kelurahanId +
                ", childrenTotal=" + childrenTotal +
                ", teenegarTotal=" + teenegarTotal +
                ", adultTotal=" + adultTotal +
                ", photoFile='" + photoFile + '\'' +
                ", photoType='" + photoType + '\'' +
                ", photoUpdateat='" + photoUpdateat + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updateAt='" + updateAt + '\'' +
                ", propinsi=" + propinsi +
                ", kabupaten=" + kabupaten +
                ", kecamatan=" + kecamatan +
                ", kelurahan=" + kelurahan +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.address);
        dest.writeValue(this.lat);
        dest.writeValue(this.lng);
        dest.writeInt(this.propinsiId);
        dest.writeInt(this.kabupatenId);
        dest.writeInt(this.kecamatanId);
        dest.writeInt(this.kelurahanId);
        dest.writeInt(this.childrenTotal);
        dest.writeInt(this.teenegarTotal);
        dest.writeInt(this.adultTotal);
        dest.writeString(this.photoFile);
        dest.writeString(this.photoType);
        dest.writeString(this.photoUpdateat);
        dest.writeString(this.createdAt);
        dest.writeString(this.updateAt);
        dest.writeTypedList(this.propinsi);
        dest.writeTypedList(this.kabupaten);
        dest.writeTypedList(this.kecamatan);
        dest.writeTypedList(this.kelurahan);
    }

    public SpotItem() {
    }

    protected SpotItem(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.address = in.readString();
        this.lat = (Double) in.readValue(Double.class.getClassLoader());
        this.lng = (Double) in.readValue(Double.class.getClassLoader());
        this.propinsiId = in.readInt();
        this.kabupatenId = in.readInt();
        this.kecamatanId = in.readInt();
        this.kelurahanId = in.readInt();
        this.childrenTotal = in.readInt();
        this.teenegarTotal = in.readInt();
        this.adultTotal = in.readInt();
        this.photoFile = in.readString();
        this.photoType = in.readString();
        this.photoUpdateat = in.readString();
        this.createdAt = in.readString();
        this.updateAt = in.readString();
        this.propinsi = new ArrayList<PropinsiItem>();
        in.readList(this.propinsi, PropinsiItem.class.getClassLoader());
        this.kabupaten = new ArrayList<KabupatenItem>();
        in.readList(this.kabupaten, KabupatenItem.class.getClassLoader());
        this.kelurahan = new ArrayList<KelurahanItem>();
        this.kecamatan = new ArrayList<KecamatanItem>();
        in.readList(this.kecamatan, KecamatanItem.class.getClassLoader());
        in.readList(this.kelurahan, KelurahanItem.class.getClassLoader());
//        this.propinsi = in.createTypedArrayList(PropinsiItem.CREATOR);
//        this.kabupaten = in.createTypedArrayList(KabupatenItem.CREATOR);
//        this.kecamatan = in.createTypedArrayList(KecamatanItem.CREATOR);
//        this.kelurahan = in.createTypedArrayList(KelurahanItem.CREATOR);
    }

    public static final  Parcelable.Creator<SpotItem> CREATOR = new Parcelable.Creator<SpotItem>() {
        @Override
        public SpotItem createFromParcel(Parcel source) {
            return new SpotItem(source);
        }

        @Override
        public SpotItem[] newArray(int size) {
            return new SpotItem[size];
        }
    };
}
