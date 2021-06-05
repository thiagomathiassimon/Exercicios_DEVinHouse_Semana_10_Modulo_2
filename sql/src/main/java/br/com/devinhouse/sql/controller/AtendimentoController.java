package br.com.devinhouse.sql.controller;

import br.com.devinhouse.sql.model.Atendimento;
import br.com.devinhouse.sql.service.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/atendimento")
public class AtendimentoController {

    @Autowired
    AtendimentoService service;

    @GetMapping
    public List<Atendimento> buscarAtendimentoComPacientesQuePossuemMaisDeUmMedico(){
        return service.buscarAtendimentosDePacientesComMaisDeUMMedico();
    }

}
