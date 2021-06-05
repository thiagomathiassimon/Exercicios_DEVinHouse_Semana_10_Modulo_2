package br.com.devinhouse.sql.service;

import br.com.devinhouse.sql.model.Atendimento;
import br.com.devinhouse.sql.repository.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoService {

    @Autowired
    AtendimentoRepository repository;

    public List<Atendimento> buscarAtendimentosDePacientesComMaisDeUMMedico(){
        return repository.buscarAtendimentosDePacientesComMaisDeUMMedico();
    }

}
