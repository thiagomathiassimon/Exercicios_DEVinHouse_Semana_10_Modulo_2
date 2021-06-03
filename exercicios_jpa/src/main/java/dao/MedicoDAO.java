package dao;

import dto.MedicoENumeroDePacientes;
import model.Medico;

import javax.persistence.EntityManager;
import java.util.List;

import static model.JPAUtil.entityManagerFactory;

public class MedicoDAO extends DAO<Medico> {

    @Override
    public void deletar(Medico objeto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Medico.class, objeto.getCodigo());
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
    public List<Medico> listar(Medico objeto) {
        return null;
    }

    public List<Medico> buscarMedicoSemAgendamentos(){
        List<Medico> list = null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            list = entityManager.createQuery("SELECT new model.Medico(m.codigo, m.nome, m.crm) FROM Medico m \n" +
                    "\tLEFT JOIN Atendimento a ON m.codigo = a.medico WHERE a.paciente IS null").getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            entityManager.close();
        }

        return list;
    }

        public List<MedicoENumeroDePacientes> buscarMedicosENumeroDePacientes(){
        List<MedicoENumeroDePacientes> list = null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
                  list  = entityManager
                    .createQuery("SELECT new dto.MedicoENumeroDePacientes( a.medico, COUNT(a.paciente)) FROM Medico m INNER JOIN Atendimento a ON m.codigo = a.medico \n" +
                    "GROUP BY a.medico")
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return list;
    }
}
