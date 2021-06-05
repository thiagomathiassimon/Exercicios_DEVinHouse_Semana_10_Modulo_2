package br.com.devinhouse.sql.controller;

import br.com.devinhouse.sql.model.Medico;
import br.com.devinhouse.sql.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/medico")
public class MedicoController {

    @Autowired
    MedicoService service;

    @GetMapping
    public List<Medico> buscarMedicosEmOrdemAlfabetica(){
        return service.buscarMedicosEmOrdemAlfabetica();
    }

}
