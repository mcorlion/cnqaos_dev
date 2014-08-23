package com.cnqaos.hibernate.pojo;
// Generated 23 Aug, 2014 9:46:56 PM by Hibernate Tools 3.6.0

import com.cnqaos.hibernate.dao.StudentCenterDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 * UserMaster generated by hbm2java
 */
public class UserMaster implements java.io.Serializable {

    private Integer userIdPk;
    private String id;
    private String name;
    private String surName;
    private Date dateOfBirth;
    private String phoneNumber;
    private String cellphoneNumber;
    private String emailAddress;
    private String password;
    private Set subjectTeachers = new HashSet(0);
    private Set studentCenters = new HashSet(0);
    private Set employerStudentsForEmployerIdFk = new HashSet(0);
    private Set employerStudentsForStudentIdFk = new HashSet(0);
    private Set userRoles = new HashSet(0);

    public UserMaster() {
    }

    public UserMaster(String id, String name, String surName, Date dateOfBirth, String password) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    public UserMaster(String id, String name, String surName, Date dateOfBirth, String phoneNumber, String cellphoneNumber, String emailAddress, String password, Set subjectTeachers, Set studentCenters, Set employerStudentsForEmployerIdFk, Set employerStudentsForStudentIdFk, Set userRoles) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.cellphoneNumber = cellphoneNumber;
        this.emailAddress = emailAddress;
        this.password = password;
        this.subjectTeachers = subjectTeachers;
        this.studentCenters = studentCenters;
        this.employerStudentsForEmployerIdFk = employerStudentsForEmployerIdFk;
        this.employerStudentsForStudentIdFk = employerStudentsForStudentIdFk;
        this.userRoles = userRoles;
    }

    public Integer getUserIdPk() {
        return this.userIdPk;
    }

    public void setUserIdPk(Integer userIdPk) {
        this.userIdPk = userIdPk;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return this.surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCellphoneNumber() {
        return this.cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set getSubjectTeachers() {
        return this.subjectTeachers;
    }

    public void setSubjectTeachers(Set subjectTeachers) {
        this.subjectTeachers = subjectTeachers;
    }

    public Set getStudentCenters() {
        return this.studentCenters;
    }

    public void setStudentCenters(Set studentCenters) {
        this.studentCenters = studentCenters;
    }

    public Set getEmployerStudentsForEmployerIdFk() {
        return this.employerStudentsForEmployerIdFk;
    }

    public void setEmployerStudentsForEmployerIdFk(Set employerStudentsForEmployerIdFk) {
        this.employerStudentsForEmployerIdFk = employerStudentsForEmployerIdFk;
    }

    public Set getEmployerStudentsForStudentIdFk() {
        return this.employerStudentsForStudentIdFk;
    }

    public void setEmployerStudentsForStudentIdFk(Set employerStudentsForStudentIdFk) {
        this.employerStudentsForStudentIdFk = employerStudentsForStudentIdFk;
    }

    public Set getUserRoles() {
        return this.userRoles;
    }

    public void setUserRoles(Set userRoles) {
        this.userRoles = userRoles;
    }

    public JsonObject getJSONObjectForStudent() {
        JsonObjectBuilder builder = Json.createObjectBuilder();

        builder.add("idPk", userIdPk)
                .add("id", id)
                .add("name", name)
                .add("surName", surName)
                .add("dateOfBirth", this.getDateString())
                .add("phoneNumber", phoneNumber)
                .add("cellphoneNumber", cellphoneNumber)
                .add("emailAddress", emailAddress)
                .add("centerId", this.getCenterForStudent() != null ? this.getCenterForStudent().getCenterIdPk() : 0)
                .add("centerName", this.getCenterForStudent() != null ? this.getCenterForStudent().getCenterName() : "");
        return builder.build();
    }

    private String getDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-yy");
        String strDate = sdf.format(dateOfBirth);
        return strDate;
    }

    private Center getCenterForStudent() {
        Center center = null;
        StudentCenterDAO studentCenterDAO = new StudentCenterDAO();
        List studentCenterList = studentCenterDAO.findByProperty("userMaster", this);
        if (studentCenterList != null && studentCenterList.size() > 0) {
            center = ((StudentCenter) studentCenterList.get(0)).getCenter();
        }
        return center;
    }

}
