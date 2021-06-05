package br.com.devinhouse.sql.repository;

import br.com.devinhouse.sql.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

    @Query(value = "\n" +
            "SELECT * FROM (SELECT a.paciente, COUNT(a.medico) FROM atendimento a\n" +
            "\tGROUP BY a.paciente) as result \n" +
            "\tINNER JOIN atendimento a \n" +
            "\tON a.paciente = result.paciente\n" +
            "\tWHERE result.count > 1", nativeQuery = true)
    List<Atendimento> buscarAtendimentosDePacientesComMaisDeUMMedico();

}
