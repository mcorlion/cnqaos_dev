/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cnqaos.bdo.teacher;

import com.cnqaos.hibernate.dao.SubjectTeacherDAO;
import com.cnqaos.hibernate.dao.UserMasterDAO;
import com.cnqaos.hibernate.dao.UserRoleDAO;
import com.cnqaos.hibernate.pojo.Center;
import com.cnqaos.hibernate.pojo.Role;
import com.cnqaos.hibernate.pojo.StudentCenter;
import com.cnqaos.hibernate.pojo.Subject;
import com.cnqaos.hibernate.pojo.SubjectTeacher;
import com.cnqaos.hibernate.pojo.UserMaster;
import com.cnqaos.hibernate.pojo.UserRole;
import com.cnqaos.util.CnqaosConstant;
import java.util.List;
import org.hibernate.Transaction;

/**
 *
 * @author GPS
 */
public class TeacherBDO {
 
    private final UserMasterDAO userMasterDAO = new UserMasterDAO();
    private final UserRoleDAO userRoleDAO = new UserRoleDAO();
    private final SubjectTeacherDAO subjectTeacherDAO = new SubjectTeacherDAO();

    public void create(UserMaster userMaster, UserRole userRole, SubjectTeacher subjectTeacher) throws Exception {
        Transaction transaction = null;
        try {
            transaction = userMasterDAO.getSession().getTransaction();
            transaction.begin();
            userMasterDAO.save(userMaster);
            userRoleDAO.save(userRole);
            subjectTeacherDAO.save(subjectTeacher);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            throw ex;
        }
    }

    public void edit(UserMaster userMaster, Subject subject) throws Exception {
        Transaction transaction = null;
        try {
            SubjectTeacher subjectTeacher = findSubjectTeacher(userMaster, subject);
            transaction = userMasterDAO.getSession().getTransaction();
            transaction.begin();
            userMasterDAO.attachDirty(userMaster);
            if (subjectTeacher == null) {
                subjectTeacher = findSubjectTeacherForTeacher(userMaster);
                if (subjectTeacher == null) {
                    subjectTeacher = new SubjectTeacher(subject, userMaster);
                } else {
                    subjectTeacher.setSubject(subject);
                }
                subjectTeacherDAO.attachDirty(subjectTeacher);
            }
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
            UserMaster teacher = userMasterDAO.findById(userId);
            List userRoleList = userRoleDAO.findByProperty("userMaster", teacher);
            List subjectTeacherList = subjectTeacherDAO.findByProperty("userMaster", teacher);

            UserRole userRole = userRoleList != null && userRoleList.size() > 0 ? (UserRole) userRoleList.get(0) : null;
            SubjectTeacher subjectTeacher = subjectTeacherList != null && subjectTeacherList.size() > 0 ? (SubjectTeacher) subjectTeacherList.get(0) : null;

            transaction = userMasterDAO.getSession().getTransaction();
            transaction.begin();
            if (subjectTeacher != null) {
                subjectTeacherDAO.delete(subjectTeacher);
            }
            if (userRole != null) {
                userRoleDAO.delete(userRole);
            }
            userMasterDAO.delete(teacher);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw ex;
        }
    }
    
    public List<UserMaster> getTeacherList(){
        Role role = (Role) userRoleDAO.getSession().get(Role.class, CnqaosConstant.TEACHER_ROLE_ID);
        return userRoleDAO.findUserByRole("role", role);
    }
    
    public UserMaster findTeacher(Integer id){
        return userMasterDAO.findById(id);
    }
    
    public SubjectTeacher findSubjectTeacher(UserMaster teacher, Subject subject) {
        return subjectTeacherDAO.findBySubjetTeacher(teacher, subject);
    }

    public SubjectTeacher findSubjectTeacherForTeacher(UserMaster teacher) {
        return subjectTeacherDAO.findSubjectTeacherForTeacher(teacher);
    }
}
