package com.cnqaos.hibernate.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 * Center entity. @author MyEclipse Persistence Tools
 */
public class Center implements java.io.Serializable {

	// Fields
    private Integer centerIdPk;
    private String centerName;
    private String centerAddress;
    private String street;
    private String city;
    private String pin;
    private String description;
    private Double latitude;
    private Double longitude;
    private Set studentCenters = new HashSet(0);
    private Set centerTrainings = new HashSet(0);

	// Constructors
    /**
     * default constructor
     */
    public Center() {
    }

    /**
     * minimal constructor
     */
    public Center(String centerName, String centerAddress, String street,
            String city, Double latitude, Double longitude) {
        this.centerName = centerName;
        this.centerAddress = centerAddress;
        this.street = street;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * full constructor
     */
    public Center(String centerName, String centerAddress, String street,
            String city, String pin, String description, Double latitude,
            Double longitude, Set studentCenters, Set centerTrainings) {
        this.centerName = centerName;
        this.centerAddress = centerAddress;
        this.street = street;
        this.city = city;
        this.pin = pin;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.studentCenters = studentCenters;
        this.centerTrainings = centerTrainings;
    }

	// Property accessors
    public Integer getCenterIdPk() {
        return this.centerIdPk;
    }

    public void setCenterIdPk(Integer centerIdPk) {
        this.centerIdPk = centerIdPk;
    }

    public String getCenterName() {
        return this.centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterAddress() {
        return this.centerAddress;
    }

    public void setCenterAddress(String centerAddress) {
        this.centerAddress = centerAddress;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Set getStudentCenters() {
        return this.studentCenters;
    }

    public void setStudentCenters(Set studentCenters) {
        this.studentCenters = studentCenters;
    }

    public Set getCenterTrainings() {
        return this.centerTrainings;
    }

    public void setCenterTrainings(Set centerTrainings) {
        this.centerTrainings = centerTrainings;
    }
 @Override
    public String toString(){
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("id",centerIdPk)
                .add("centerName", centerName)
                .add("centerAddress", centerAddress)
                .add("street",street)
                .add("city", city)
                .add("pin", pin)
                .add("description", description)
                .add("latitude", latitude)
                .add("longitude",longitude);
        return builder.build().toString();
    }
    
    public JsonObject getJSONObject(){
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("id",centerIdPk)
                .add("centerName", centerName)
                .add("centerAddress", centerAddress)
                .add("street",street)
                .add("city", city)
                .add("pin", pin)
                .add("description", description)
                .add("latitude", latitude)
                .add("longitude",longitude);
        return builder.build();
    }
}
