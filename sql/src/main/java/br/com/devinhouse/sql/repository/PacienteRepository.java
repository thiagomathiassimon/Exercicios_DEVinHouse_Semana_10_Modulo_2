package br.com.devinhouse.sql.repository;

import br.com.devinhouse.sql.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query(value = "SELECT * FROM paciente LIMIT ?1 OFFSET ?2", nativeQuery = true)
    List<Paciente> buscarPacientesPaginados(int limit, int offset);
}
