package dao;

import javax.persistence.EntityManager;
import java.util.List;

import static model.JPAUtil.entityManagerFactory;

public abstract class DAO<T> implements IDao<T> {

    @Override
    public void inserir(T objeto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            System.out.println(objeto);
            entityManager.persist(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void alterar(T objeto) {

    }

    @Override
    public abstract void deletar(Long codigo);

    @Override
    public abstract List<T> listar(T objeto);
}
