package org.example.database.dao;

import org.example.database.models.User;
import org.example.database.tools.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class UserDao {


    public void createUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            user.setUz_Status(true);
            user.setUz_IV("tH9l5JRIPRI1fGH4vKxSOlgIDT4x7UiJ");
            session.save(user);
        }
        catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
    }

    public List<User> querryForAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            List<User> users = session.createQuery("from User ", User.class).list();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }

    public void updateById(int uz_id, String uz_login, String uz_name, String uz_password, String uz_surname) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            User user = session.find(User.class, uz_id);
            user.setUz_Login(uz_login);
            user.setUz_Name(uz_name);
            user.setUz_Password(uz_password);
            user.setUz_Surname(uz_surname);
            session.save(user);
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
            User user = session.find(User.class, id);
            session.delete(user);
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
