package br.com.devinhouse.sql.repository;

import br.com.devinhouse.sql.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

    @Query(value = "\n" +
            "SELECT * FROM (SELECT a.paciente, COUNT(a.medico) FROM atendimento a\n" +
            "\tGROUP BY a.paciente) as result \n" +
            "\tINNER JOIN atendimento a \n" +
            "\tON a.paciente = result.paciente\n" +
            "\tWHERE result.count > 1", nativeQuery = true)
    List<Atendimento> buscarAtendimentosDePacientesComMaisDeUMMedico();

    @Query(value = "SELECT * FROM Atendimento a WHERE a.medico = ?1", nativeQuery = true)
    List<Atendimento> buscartendimentoPeloIdDoMedico(Long idMedico);

    @Query(value = "SELECT * FROM atendimento", nativeQuery = true)
    List<Atendimento> buscarAtendimentosComMedicoEPaciente();
}
