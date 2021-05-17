package dao;

import model.Atendimento;
import model.Paciente;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static model.JPAUtil.entityManagerFactory;

public class PacienteDAO extends DAO<Paciente> {
    @Override
    public void deletar(Paciente objeto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Paciente.class, objeto.getCodigo());
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
    public List<Paciente> listar(Paciente objeto) {
        return null;
    }

    public List<Paciente> litarPacientesPorAnoDeNascimento(int anoDeNascimento){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Paciente> list = null;
        try {
            TypedQuery<Paciente> query = entityManager.createQuery(
                    "FROM Paciente p WHERE EXTRACT(YEAR FROM p.nascimento) = ?1" , Paciente.class);
            list = query.setParameter(1, anoDeNascimento).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return list;
    }

}
