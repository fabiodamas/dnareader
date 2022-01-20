package br.com.fabio.dnareader.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fabio.dnareader.model.Dna;

@Repository
public interface DnaRepository extends JpaRepository<Dna, Long>{

}
