package dto;

import lombok.*;
import model.Medico;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MedicoComMaiorNumeroDePacientesDTO {

    private Medico medico;
    private Long numeroDePacientes;


}
