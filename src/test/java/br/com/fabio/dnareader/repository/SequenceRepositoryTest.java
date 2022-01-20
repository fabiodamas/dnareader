package br.com.fabio.dnareader.repository;

import br.com.fabio.dnareader.model.Dna;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SequenceRepositoryTest {

  @Autowired
  private DnaRepository dnaRepository;

  @Test
  public void deveriaSalvarUmaSequenciaDeDna() {

    Dna sequence = new Dna();

    String[] dna = new String[] { "AAAAAA", "CCCCCC", "TTATGT", "AGAAGG", "CCCCTA", "GGGGGG" };
    Map<String, Object> dnaValues = new java.util.HashMap<>();
    dnaValues.put("dna", dna);

    sequence.setDnaValues(dnaValues);

    Long id = dnaRepository.save(sequence).getId();

    Dna sequenceSaved = dnaRepository.findById(id).orElse(fail());

    assertEquals(sequenceSaved.getDnaValues().get("dna"), dnaValues.get("dna"));
  }


}
