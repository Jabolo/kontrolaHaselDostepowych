package org.example.database.dao;

import org.example.database.models.AccessData;
import org.example.database.models.User;
import org.example.database.tools.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AccessDataDao {

    public void addAccessData(AccessData ad) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            System.out.println(ad.getLogin() + " 121121" + ad.getPassword());
            session.save(ad);
    } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        }

    public List<AccessData> querryForAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            List<AccessData> accessData = session.createQuery("from AccessData ", AccessData.class).list();
            return accessData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }
    }
