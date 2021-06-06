package br.com.devinhouse.sql.repository;

import br.com.devinhouse.sql.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    @Query(value = "SELECT * FROM medico m ORDER BY m.nome", nativeQuery = true)
    List<Medico> buscarMedicosEmOrdemAlfabetica();

}
