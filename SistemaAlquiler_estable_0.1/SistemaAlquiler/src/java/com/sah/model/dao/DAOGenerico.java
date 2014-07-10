/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sah.model.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author Meli
 */
public abstract class DAOGenerico {
    protected Logger logger;
    protected Session session;
    protected Transaction transaction;
    public void init(){
        session=HibernateUtil.getSessionFactory().getCurrentSession();
        transaction=session.beginTransaction();
    }
    public void end(){
        if(session!=null){
            if(session.isOpen()){
               session.close(); 
            }
            
        }
    }
    public void endError(){
        if(session!=null){
            if(transaction!=null){
                transaction.rollback();
            }
        }
    }
    public boolean insert(Object object){
        try {
            init();
            Object pojo = convertDTO_Pojo(object);
            session.save(pojo);
            transaction.commit();
            return true;
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
            endError();
            return false;
        }finally{
            end();
        }

    }
    
    public boolean update(Object object){
        try {
            init();
            Object pojo = convertDTO_Pojo(object);
            session.update(pojo);
            transaction.commit();
            return true;
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
            endError();
            return false;
        }finally{
            end();
        }

    }
    public boolean delete(Object object){
        try {
            init();
            Object pojo = convertDTO_Pojo(object);
            session.delete(pojo);
            transaction.commit();
            return true;
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
            endError();
            return false;
        }finally{
            end();
        }

    }
    

    
    
    public abstract Object convertPojo_DTO(Object object);
    public abstract Object convertDTO_Pojo(Object object);
    





}