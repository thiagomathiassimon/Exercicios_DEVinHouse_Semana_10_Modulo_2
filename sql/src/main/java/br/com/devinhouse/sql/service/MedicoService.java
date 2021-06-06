package br.com.devinhouse.sql.service;

import br.com.devinhouse.sql.dto.MedicoEPacienteDTO;
import br.com.devinhouse.sql.model.Atendimento;
import br.com.devinhouse.sql.model.Medico;
import br.com.devinhouse.sql.model.Paciente;
import br.com.devinhouse.sql.repository.AtendimentoRepository;
import br.com.devinhouse.sql.repository.MedicoRepository;
import br.com.devinhouse.sql.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository repository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    AtendimentoRepository atendimentoRepository;

    public List<Medico> buscarMedicosEmOrdemAlfabetica(){
        return repository.buscarMedicosEmOrdemAlfabetica();
    }

    public List<MedicoEPacienteDTO> buscarMedicoEPaceinte(){
        List<MedicoEPacienteDTO>  list = new ArrayList<>();

        try {
            List<Medico> medicos = repository.findAll();
            List<Atendimento> atendimentos = new ArrayList<>();
            medicos.forEach((Medico medico) -> {
                atendimentos.addAll(atendimentoRepository.buscartendimentoPeloIdDoMedico(1L));
            });
            atendimentos.forEach((Atendimento atendimento)-> {
                MedicoEPacienteDTO mep = new MedicoEPacienteDTO(atendimento.getMedico(), atendimento.getPaciente());
                list.add(mep);
            });
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

}
