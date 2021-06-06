package br.com.devinhouse.sql.dto;

import br.com.devinhouse.sql.model.Medico;
import br.com.devinhouse.sql.model.Paciente;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MedicoEPacienteDTO {

    private Medico medico;
    private Paciente paciente;

}
