package dao;

import dto.PacienteComMaiorEMenorIdadeDTO;
import dto.PacienteESeuMedicoDTO;
import dto.PacientesPorMesDeNascimentoDTO;
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

    public List<PacientesPorMesDeNascimentoDTO> listarPacientesAgrupadosPorMesDeNascimento(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<PacientesPorMesDeNascimentoDTO> list = null;
        try {
            list = entityManager.createQuery("SELECT new dto.PacientesPorMesDeNascimentoDTO(EXTRACT(MONTH FROM p.nascimento), COUNT(*))\n" +
                    "\tFROM Paciente p GROUP BY EXTRACT(MONTH FROM p.nascimento)").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return list;
    }

    public List<PacienteComMaiorEMenorIdadeDTO> buscarPacienteComMaiorEMenorIdade(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<PacienteComMaiorEMenorIdadeDTO> list = null;
        try {
            list = entityManager.createQuery("SELECT new dto.PacienteComMaiorEMenorIdadeDTO(p.nome) FROM Paciente p \n" +
                    "\tWHERE AGE(p.nascimento) = (SELECT MAX(AGE(p.nascimento)) FROM Paciente p) \n" +
                    "\tOR AGE(p.nascimento) = (SELECT MIN(AGE(p.nascimento)) FROM Paciente p)").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        System.out.println(list);
        return list;
    }

   public List<PacienteESeuMedicoDTO> buscarPacientesEOsMedicosAssociadosAEles(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<PacienteESeuMedicoDTO> list = null;
        try {
            list = entityManager.createQuery("SELECT new dto.PacienteESeuMedicoDTO(p.nome, m.nome) FROM Paciente p INNER JOIN Atendimento a \n" +
                    "\tON p.codigo = a.paciente INNER JOIN \n" +
                    "\tMedico m ON m.codigo = a.medico ORDER BY p.nome ASC").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        System.out.println(list);
        return list;
    }

}
