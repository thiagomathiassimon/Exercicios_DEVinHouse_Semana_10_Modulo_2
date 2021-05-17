package dao;

import model.Atendimento;
import model.Medico;

import javax.persistence.EntityManager;
import java.util.List;

import static model.JPAUtil.entityManagerFactory;

public class AtendimentoDAO extends DAO<Atendimento>{
    @Override
    public void deletar(Atendimento objeto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Atendimento.class, objeto.getCodigo());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Atendimento> listar(Atendimento objeto) {
        return null;
    }
}
