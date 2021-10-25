package com.app.bank.data;

import com.app.bank.config.HibernateConfig;
import com.app.bank.model.BaseEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("JpaQlInspection")
@EnableTransactionManagement
@Repository
@ComponentScan("com.app.bank.config")
abstract class EntityRepository<TEntity extends BaseEntity> implements IRepository<TEntity> {

    @Autowired
    protected HibernateTransactionManager transactionManager;

    @Transactional
    @Override
    public TEntity findById(int id){
        HibernateTransactionManager transactionManager = new AnnotationConfigApplicationContext(HibernateConfig.class).getBean(HibernateTransactionManager.class);

        if(transactionManager != null){
            System.out.println("Suucks");
        }
        return (TEntity) transactionManager.getSessionFactory().openSession().createQuery("from " + getTableName() + " WHERE id = " + id).uniqueResult();
    }

    @Transactional
    @Override
    public List<TEntity> findAll(){
        return (List<TEntity>) transactionManager.getSessionFactory().openSession().createQuery("from " + getTableName()).list();
    }

    @Transactional
    @Override
    public int create(TEntity entity) {
        Session session = Objects.requireNonNull(transactionManager.getSessionFactory()).openSession();
        Transaction tx1 = session.beginTransaction();
        int entityId = (int) session.save(entity);
        tx1.commit();
        session.close();
        return entityId;
    }

    @Transactional
    @Override
    public TEntity update(TEntity entity){
        Session session = Objects.requireNonNull(transactionManager.getSessionFactory()).openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(entity);
        tx1.commit();
        session.close();
        return entity;
    }

    @Transactional
    @Override
    public void delete(TEntity entity){
        Session session = Objects.requireNonNull(transactionManager.getSessionFactory()).openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(entity);
        tx1.commit();
        session.close();
    }

    public abstract String getTableName();
}


