package org.example.database.dao;

import org.example.database.models.AccessData;
import org.example.database.tools.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class AccessDataDao {

    public void createAccess(AccessData ad){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(ad);
        }
        catch (Exception e){
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

    public void updateById(int id, String object, String login, String password, String note) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            AccessData accessData = session.find(AccessData.class, id);
            accessData.setObject(object);
            accessData.setLogin(login);
            accessData.setPassword(password);
            accessData.setNote(note);
            session.save(accessData);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
    }

    public void deleteById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            AccessData accessData = session.find(AccessData.class, id);
            session.delete(accessData);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
    }

}
