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
        medico.setNome("Doctor Who");
        medico.setCrm("123/RS");

//        medicoDAO.inserir(medico);
//
//        System.out.println(medico);

        PacienteDAO pacienteDAO = new PacienteDAO();
        Paciente paciente = new Paciente();
        paciente.setNome("André");
        paciente.setNascimento(Date.valueOf("1960-04-30"));
        paciente.setEmail("andre@gmail.com");
        paciente.setTelefone("999");
//
//        pacienteDAO.inserir(paciente);
//
//        System.out.println(paciente);

        paciente.setCodigo(1L);
        medico.setCodigo(1L);

        AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
        Atendimento atendimento = new Atendimento();
        atendimento.setPaciente(paciente);
        atendimento.setMedico(medico);
        atendimento.setDescricao("Tratamento Cardiológico");
        atendimento.setSituacao("Agendado");
        atendimento.setValor(100.00);
        atendimento.setData(Timestamp.from(Instant.now()));

        atendimentoDAO.inserir(atendimento);

        System.out.println(atendimento);


    }

}
