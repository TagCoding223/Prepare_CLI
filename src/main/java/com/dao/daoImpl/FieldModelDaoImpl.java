package com.dao.daoImpl;

import com.dao.FieldModelDao;
import com.entities.FieldModel;
import com.entities.FieldModelSubject;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class FieldModelDaoImpl implements FieldModelDao {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public FieldModel getFieldModelById(int id) {
        try(Session session = HibernateUtil.getSession()){
            return session.load(FieldModel.class,id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public FieldModel createFieldModel(FieldModel fieldModel) {
        try (Session session = HibernateUtil.getSession()){
            session.beginTransaction();
            session.save(fieldModel);
            session.getTransaction().commit();
            return fieldModel;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public FieldModel updateFieldModel(FieldModel fieldModel, List<FieldModelSubject> fieldModelSubjects) {
        try(Session session = HibernateUtil.getSession()){
            session.beginTransaction();
            FieldModel updatedFieldModel = new FieldModel();
            updatedFieldModel.setName(fieldModel.getName());
            updatedFieldModel.setFieldModelSubjects(fieldModelSubjects);
            updatedFieldModel.setId(fieldModel.getId());

            session.saveOrUpdate(updatedFieldModel);

            session.getTransaction().commit();

            return updatedFieldModel;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteFieldModel(int id) {
        String msg = null;
        try (Session session = HibernateUtil.getSession()){
            FieldModel fieldModel = session.get(FieldModel.class,id);
            System.out.print("\nAre You Sure? : ");
            String status = scanner.nextLine();
            if (status.equalsIgnoreCase("Yes")){
                session.beginTransaction();
                session.delete(fieldModel);
                session.getTransaction().commit();
                session.evict(fieldModel);
                msg = fieldModel.getName()+" Field Model Deleted Successfully!";
            }else{
                msg = fieldModel.getName()+" Field Model Delete Process Deny By User!";
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return msg;
    }

    @Override
    public List<FieldModel> getAllFieldModel() {
        try(Session session = HibernateUtil.getSession()){
            Query<FieldModel> query = session.createQuery("from FieldModel", FieldModel.class);
            return query.getResultList();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
