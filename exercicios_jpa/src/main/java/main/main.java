package main;

import dao.AtendimentoDAO;
import dao.MedicoDAO;
import dao.PacienteDAO;
import model.Atendimento;
import model.Medico;
import model.Paciente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import static model.JPAUtil.entityManagerFactory;

public class main {

    public static void main(String[] args) {

        MedicoDAO medicoDAO = new MedicoDAO();

        Medico medico = new Medico();
        medico.setNome("Doutor Ziraldo");
        medico.setCrm("969/SP");
      medico.setCodigo(5L);

//        medicoDAO.alterar(medico);
//
//        System.out.println(medico);

//medicoDAO.deletar(medico);

   //     medicoDAO.inserir(medico);
//
//        System.out.println(medico);

        PacienteDAO pacienteDAO = new PacienteDAO();
        Paciente paciente = new Paciente();
        paciente.setNome("Alberto");
        paciente.setNascimento(Date.valueOf("1960-04-30"));
        paciente.setEmail("alberto@gmail.com");
        paciente.setTelefone("888");

      paciente.setCodigo(2L);
//
//        pacienteDAO.alterar(paciente);


       // pacienteDAO.deletar(paciente);

      //  pacienteDAO.inserir(paciente);
//
//        System.out.println(paciente);

        paciente.setCodigo(1L);

       // medicoDAO.deletar(medico);

        //medico.setCodigo(1L);

        AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
        Atendimento atendimento = new Atendimento();
        atendimento.setPaciente(paciente);
        atendimento.setMedico(medico);
        atendimento.setDescricao("Tratamento Odontológico");
        atendimento.setSituacao("Remarcado");
        atendimento.setValor(250.00);
        atendimento.setData(Timestamp.from(Instant.now()));

        atendimento.setCodigo(2L);

      //  atendimentoDAO.alterar(atendimento);

        //atendimentoDAO.inserir(atendimento);

        atendimentoDAO.deletar(atendimento);

        System.out.println(atendimento);


    }

}
