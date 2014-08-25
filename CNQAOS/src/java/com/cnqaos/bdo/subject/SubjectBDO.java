/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cnqaos.bdo.subject;

import com.cnqaos.hibernate.dao.SubjectDAO;
import com.cnqaos.hibernate.pojo.Subject;
import java.util.List;
import org.hibernate.Transaction;

/**
 *
 * @author Vimal
 */
public class SubjectBDO {
    private SubjectDAO subjectDAO = new SubjectDAO();
    
    
    public void create(Subject subject) throws Exception{
        Transaction transaction = null;
        try{
            transaction = subjectDAO.getSession().getTransaction();
            transaction.begin();
            subjectDAO.save(subject);
            transaction.commit();
        }catch(Exception ex){
             if(transaction != null)transaction.rollback();
             ex.printStackTrace();
            throw ex;
        }
    }
    
    public void edit(Subject subject) throws Exception{
        Transaction transaction = null;
        try{
            transaction = subjectDAO.getSession().getTransaction();
            transaction.begin();
            subjectDAO.attachDirty(subject);
            transaction.commit();
        }catch(Exception ex){
            if(transaction != null)transaction.rollback();
            throw ex;
        }
    }
    
    
    public void remove(int subjectId) throws Exception{
        Transaction transaction = null;
        try{
            transaction = subjectDAO.getSession().getTransaction();
            transaction.begin();
            subjectDAO.delete(subjectDAO.findById(subjectId));
            transaction.commit();
        }catch(Exception ex){
            if(transaction != null)transaction.rollback();
            throw ex;
        }
    }
    
    public List<Subject> getSubjectList(){
        return subjectDAO.findAll();
    }
    
    public Subject findSubject(Integer id){
        return subjectDAO.findById(id);
    }
}
