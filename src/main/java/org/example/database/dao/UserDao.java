package org.example.database.dao;

import org.example.database.models.User;
import org.example.database.tools.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class UserDao {

    public void addUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
                try{
                    session.save(user);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    session.close();
                }
    }

    public List<User> querryForAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            List<User> users = session.createQuery("from User ", User.class).list();
            System.out.println("Pzed");
            for (User uz: users
            ) {
                System.out.println(uz.getUz_Name());
                uz.toString();
            }
            System.out.println("po");
                    return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }

    public void createOrUpdate(User user) {
        //Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            System.out.println(user.getUz_Name());
         //   System.out.println(user.getClass().getName());
//            System.out.println("Pzed");
////            for (User uz: users
////            ) {
////                System.out.println(uz.getUz_Name());
////                uz.toString();
////            }
            System.out.println("po");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
