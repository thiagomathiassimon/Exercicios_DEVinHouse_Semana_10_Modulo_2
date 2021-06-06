package br.com.devinhouse.sql.service;

import br.com.devinhouse.sql.model.Paciente;
import br.com.devinhouse.sql.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository repository;

    public List<Paciente> buscarPacientesPaginados(int limit, int offset) {
        return repository.buscarPacientesPaginados(limit, offset);
    }
}
