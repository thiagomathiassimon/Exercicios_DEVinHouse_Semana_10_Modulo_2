package main;

import dao.AtendimentoDAO;
import dao.MedicoDAO;
import dao.PacienteDAO;
import dto.PacienteComMaiorEMenorIdadeDTO;
import dto.PacienteESeuMedicoDTO;
import model.Atendimento;
import model.Medico;
import model.Paciente;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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
        paciente.setNascimento(Date.valueOf("1985-04-30"));
        paciente.setEmail("alberto@gmail.com");
        paciente.setTelefone("888");

        //paciente.setCodigo(2L);
//
//        pacienteDAO.alterar(paciente);


        // pacienteDAO.deletar(paciente);

        //   pacienteDAO.inserir(paciente);
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

        //       atendimentoDAO.deletar(atendimento);

        //   System.out.println(atendimento);

        // List<Paciente> list = pacienteDAO.litarPacientesPorAnoDeNascimento(1990);

        //   List<PacientesPorMesDeNascimentoDTO> list = pacienteDAO.listarPacientesAgrupadosPorMesDeNascimento();

        List<PacienteESeuMedicoDTO> list = pacienteDAO.buscarPacientesEOsMedicosAssociadosAEles();

        if(list.isEmpty()){
            list.forEach(System.out::println);
        }

    }

}
