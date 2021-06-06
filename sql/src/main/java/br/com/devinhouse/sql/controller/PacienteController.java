package br.com.devinhouse.sql.controller;

import br.com.devinhouse.sql.model.Paciente;
import br.com.devinhouse.sql.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/paciente")
public class PacienteController {

    @Autowired
    PacienteService service;

    @GetMapping(value = "/limit/{limit}/offset/{offset}")
    public List<Paciente> buscarPacientesPaginados(@PathVariable int limit, @PathVariable int offset) {
        return service.buscarPacientesPaginados(limit, offset);
    }

}
