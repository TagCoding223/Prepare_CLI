package com.dao.daoImpl;

import com.dao.ChapterDao;
import com.entities.Chapter;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class ChapterDaoImpl implements ChapterDao {

    private static final Scanner scanner = new Scanner(System.in);
    @Override
    public Chapter createChapter(Chapter chapter) {
        try (Session session = HibernateUtil.getSession()){
            session.beginTransaction();
            session.save(chapter);
            session.getTransaction().commit();
            return chapter;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Chapter findChapterById(long id) {
        try(Session session = HibernateUtil.getSession()) {
            return session.load(Chapter.class,id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Chapter updateChapter(Chapter chapter) {
        try(Session session = HibernateUtil.getSession()) {
            Chapter updatedChapter = session.load(Chapter.class,chapter.getId());
            if (updatedChapter!=null){
                updatedChapter.setName(chapter.getName());
                updatedChapter.setFieldModelSubjectChapters(chapter.getFieldModelSubjectChapters());
                session.beginTransaction();
                session.saveOrUpdate(updatedChapter);
                session.getTransaction().commit();
                return updatedChapter;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteChapter(int id) {
        String msg = "null";
        try(Session session = HibernateUtil.getSession()) {
            Chapter deleteChapter = session.load(Chapter.class,id);
            System.out.print("\nAre You Sure? : ");
            String status = scanner.nextLine();
            if (deleteChapter!=null && status.equalsIgnoreCase("yes")){
                session.beginTransaction();
                session.delete(deleteChapter);
                session.getTransaction().commit();
                session.persist(deleteChapter);
                msg = "Chapter Deleted Successfully!";
            }else{
                msg = "Chapter not found to delete it.";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return msg;
    }

    @Override
    public List<Chapter> getAllChapters() {
        try(Session session = HibernateUtil.getSession()) {
            Query<Chapter> query = session.createQuery("from Chapter", Chapter.class);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
