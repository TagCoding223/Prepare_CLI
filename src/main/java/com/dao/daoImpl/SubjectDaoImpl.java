package com.dao.daoImpl;

import com.dao.SubjectDao;
import com.entities.Subject;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class SubjectDaoImpl implements SubjectDao {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public Subject getSubjectById(int id) {
        try(Session session = HibernateUtil.getSession()) {
            return session.load(Subject.class,id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Subject createSubject(Subject subject) {
        try(Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.save(subject);
            session.getTransaction().commit();
            return subject;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Subject updateSubject(Subject subject) {
        try(Session session = HibernateUtil.getSession()) {
            Subject updatedSubject = session.load(Subject.class,subject.getId());
            updatedSubject.setName(subject.getName());
            updatedSubject.setFieldModelSubjects(subject.getFieldModelSubjects());
            session.beginTransaction();
            session.saveOrUpdate(updatedSubject);
            session.getTransaction().commit();
            return updatedSubject;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteSubject(int id) {
        String msg = "null";
        try(Session session = HibernateUtil.getSession()) {
            Subject deletedSubject = session.load(Subject.class,id);
            System.out.print("\nAre You Sure: ");
            String status = scanner.nextLine();
            if (deletedSubject!=null && status.equalsIgnoreCase("yes")){
                session.beginTransaction();
                session.delete(deletedSubject);
                session.getTransaction().commit();
                session.persist(deletedSubject);
                msg = "Subject Deleted Successfully.";
            }else {
                msg = "Subject Delete Process Not Completed.";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return msg;
    }

    @Override
    public List<Subject> getAllSubjects() {
        try(Session session = HibernateUtil.getSession()) {
            Query<Subject> query = session.createQuery("from Subject",Subject.class);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
