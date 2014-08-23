/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cnqaos.bdo.student;

import com.cnqaos.hibernate.dao.StudentCenterDAO;
import com.cnqaos.hibernate.dao.UserMasterDAO;
import com.cnqaos.hibernate.dao.UserRoleDAO;
import com.cnqaos.hibernate.pojo.Role;
import com.cnqaos.hibernate.pojo.StudentCenter;
import com.cnqaos.hibernate.pojo.UserMaster;
import com.cnqaos.hibernate.pojo.UserRole;
import com.cnqaos.util.CnqaosConstant;
import java.util.List;
import org.hibernate.Transaction;

/**
 *
 * @author Vimal
 */
public class StudentBDO {

    private final UserMasterDAO userMasterDAO = new UserMasterDAO();
    private final UserRoleDAO userRoleDAO = new UserRoleDAO();
    private final StudentCenterDAO studentCenterDAO = new StudentCenterDAO();

    public void create(UserMaster userMaster, UserRole userRole, StudentCenter studentCenter) throws Exception {
        Transaction transaction = null;
        try {
            transaction = userMasterDAO.getSession().getTransaction();
            transaction.begin();
            userMasterDAO.save(userMaster);
            userRoleDAO.save(userRole);
            studentCenterDAO.save(studentCenter);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            throw ex;
        }
    }

    public void edit(UserMaster userMaster, StudentCenter studentCenter) throws Exception {
        Transaction transaction = null;
        try {
            transaction = userMasterDAO.getSession().getTransaction();
            transaction.begin();
            userMasterDAO.attachDirty(userMaster);
            studentCenterDAO.attachDirty(studentCenter);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw ex;
        }
    }

    public void remove(int userId) throws Exception {
        Transaction transaction = null;
        try {
            UserMaster student = userMasterDAO.findById(userId);
            List userRoleList = userRoleDAO.findByProperty("userMaster", student);
            List studentCenterList = studentCenterDAO.findByProperty("userMaster", student);

            UserRole userRole = userRoleList != null && userRoleList.size() > 0 ? (UserRole) userRoleList.get(0) : null;
            StudentCenter studentCenter = studentCenterList != null && studentCenterList.size() > 0 ? (StudentCenter) studentCenterList.get(0) : null;

            transaction = userMasterDAO.getSession().getTransaction();
            transaction.begin();
            if (studentCenter != null) {
                studentCenterDAO.delete(studentCenter);
            }
            if (userRole != null) {
                userRoleDAO.delete(userRole);
            }
            userMasterDAO.delete(student);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw ex;
        }
    }
    
    public List<UserMaster> getStudentList(){
        Role role = (Role) userRoleDAO.getSession().get(Role.class, CnqaosConstant.STUDENT_ROLE_ID);
        return userRoleDAO.findUserByRole("role", role);
    }
    
    public UserMaster findStudent(Integer id){
        return userMasterDAO.findById(id);
    }

}
