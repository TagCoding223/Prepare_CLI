package com.dao.daoImpl;

import com.dao.UserDao;
import com.util.HibernateUtil;
import com.entities.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class UserDaoImpl implements UserDao {

    Scanner scanner = new Scanner(System.in);

    @Override
    public User createUser(User user) {
        try(Session session = HibernateUtil.getSession()){
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findUserById(int id) {
        try(Session session = HibernateUtil.getSession()){
            return session.load(User.class,id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        try(Session session = HibernateUtil.getSession()){
            Query<User> query = session.createQuery("from User where email=:e and password=:p",User.class);
            query.setParameter("e",email);
            query.setParameter("p",password);
            return query.getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public User updateUser(int id,User updatedUser) {
        try(Session session = HibernateUtil.getSession()){
            System.out.println("1");
            User user = session.load(User.class,id);
            System.out.println("2");
            session.beginTransaction();
            System.out.println("3");
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setCity(updatedUser.getCity());
            user.setPassword(updatedUser.getPassword());
            user.setPhone(updatedUser.getPhone());
            user.setRole(updatedUser.getRole());
            System.out.println("4");
            session.saveOrUpdate(user);
            System.out.println("5");
            session.getTransaction().commit();

            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteUser(int id) {
        String msg = null;
        try (Session session = HibernateUtil.getSession()){
            User user = session.get(User.class,id);
            System.out.print("\nAre You Sure? : ");
            String status = scanner.nextLine();
            if (status.equalsIgnoreCase("Yes")){
                session.beginTransaction();
                session.delete(user);
                session.getTransaction().commit();
                session.evict(user);
                msg = "User Account Deleted Successfully!";
            }else{
                msg = "User Account Delete Process Deny By User!";
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return msg;
    }

    @Override
    public List<User> getAllUser() {
        try(Session session = HibernateUtil.getSession()){
            Query<User> query = session.createQuery("from User",User.class);
            return query.getResultList();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        try (Session session = HibernateUtil.getSession()){
            Query<User> query = session.createQuery("from User where email=:e", User.class);
            query.setParameter("e",email);
            return query.getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
