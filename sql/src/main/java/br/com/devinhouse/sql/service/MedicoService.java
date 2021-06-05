package br.com.devinhouse.sql.service;

import br.com.devinhouse.sql.model.Medico;
import br.com.devinhouse.sql.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository repository;

    public List<Medico> buscarMedicosEmOrdemAlfabetica(){
        return repository.buscarMedicosEmOrdemAlfabetica();
    }

}
