/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cnqaos.bdo.center;

import com.cnqaos.hibernate.dao.CenterDAO;
import com.cnqaos.hibernate.pojo.Center;
import java.util.List;
import org.hibernate.Transaction;

/**
 *
 * @author Vimal
 */
public class CenterBDO {
    private final CenterDAO centerDAO = new CenterDAO();
    
    public void create(Center center) throws Exception{
        Transaction transaction = null;
        try{
            transaction = centerDAO.getSession().getTransaction();
            transaction.begin();
            centerDAO.save(center);
            transaction.commit();
        }catch(Exception ex){
             if(transaction != null)transaction.rollback();
             ex.printStackTrace();
            throw ex;
        }
    }
    
    public void edit(Center center) throws Exception{
        Transaction transaction = null;
        try{
            transaction = centerDAO.getSession().getTransaction();
            transaction.begin();
            centerDAO.attachDirty(center);
            transaction.commit();
        }catch(Exception ex){
            if(transaction != null)transaction.rollback();
            throw ex;
        }
    }
    
    public void remove(int centerId) throws Exception{
        Transaction transaction = null;
        try{
            transaction = centerDAO.getSession().getTransaction();
            transaction.begin();
            centerDAO.delete(centerDAO.findById(centerId));
            transaction.commit();
        }catch(Exception ex){
            if(transaction != null)transaction.rollback();
            throw ex;
        }
    }
    
    public List<Center> getCenterList(){
        return centerDAO.findAll();
    }
    
    public Center findCenter(Integer id){
        return centerDAO.findById(id);
    }
    
}
