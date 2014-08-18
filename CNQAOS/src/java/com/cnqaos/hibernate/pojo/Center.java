package com.cnqaos.hibernate.pojo;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
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
    private double latitude;
    private double longitude;
    private Set centreTrainings = new HashSet(0);
    private Set studentCentres = new HashSet(0);

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
            String city, double latitude, double longitude) {
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
            String city, String pin, String description, double latitude, double longitude) {
        this.centerName = centerName;
        this.centerAddress = centerAddress;
        this.street = street;
        this.city = city;
        this.pin = pin;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public Set getCentreTrainings() {
        return this.centreTrainings;
    }

    public void setCentreTrainings(Set centreTrainings) {
        this.centreTrainings = centreTrainings;
    }

    public Set getStudentCentres() {
        return this.studentCentres;
    }

    public void setStudentCentres(Set studentCentres) {
        this.studentCentres = studentCentres;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.centerName);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.latitude) ^ (Double.doubleToLongBits(this.latitude) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.longitude) ^ (Double.doubleToLongBits(this.longitude) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Center other = (Center) obj;
        if (!Objects.equals(this.centerName, other.centerName)) {
            return false;
        }
        if (Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(other.latitude)) {
            return false;
        }
        return Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(other.longitude);
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
