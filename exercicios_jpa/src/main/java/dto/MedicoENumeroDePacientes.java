package dto;

import lombok.*;
import model.Medico;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MedicoENumeroDePacientes {

    private Medico medico;
    private Long numeroDePacientes;

}
