package com.dao.daoImpl;

import com.dao.QuestionDao;
import com.entities.Question;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class QuestionDaoImpl implements QuestionDao {

    @Override
    public Question createQuestion(Question question) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.save(question);
            session.getTransaction().commit();
            return question;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Question> getQuestionsByFieldModelSubjectAndChapter(Long fieldModelId, Long subjectId, Long chapterId) {
        try (Session session = HibernateUtil.getSession()) {
            Query<Question> query = session.createQuery(
                    "FROM Question WHERE fieldModel.id = :fieldModelId AND subject.id = :subjectId AND chapter.id = :chapterId",
                    Question.class);
            query.setParameter("fieldModelId", fieldModelId);
            query.setParameter("subjectId", subjectId);
            query.setParameter("chapterId", chapterId);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int getCount(Long fieldModelId, Long subjectId, Long chapterId) {
        try (Session session = HibernateUtil.getSession()) {

            // Create CriteriaBuilder
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            // Create CriteriaQuery for Long (count result)
            CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);

            // Define the root entity (Question)
            Root<Question> root = criteriaQuery.from(Question.class);

            // Add conditions for fieldModelId, subjectId, and chapterId
            criteriaQuery.select(criteriaBuilder.count(root))
                    .where(
                            criteriaBuilder.equal(root.get("fieldModel").get("id"), fieldModelId),
                            criteriaBuilder.equal(root.get("subject").get("id"), subjectId),
                            criteriaBuilder.equal(root.get("chapter").get("id"), chapterId));

            // Execute the query and get the count
            Long count = session.createQuery(criteriaQuery).getSingleResult();
            return count.intValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public List<Question> getTestSet(int startIndex, Long fieldModelId, Long subjectId, Long chapterId) {
        try (Session session = HibernateUtil.getSession()) {

            Query<Question> query = session.createQuery(
                    "FROM Question WHERE fieldModel.id = :fieldModelId AND subject.id = :subjectId AND chapter.id = :chapterId",
                    Question.class);
            query.setParameter("fieldModelId", fieldModelId);
            query.setParameter("subjectId", subjectId);
            query.setParameter("chapterId", chapterId);
            query.setFirstResult(startIndex);
            query.setMaxResults(10);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;

    }
}