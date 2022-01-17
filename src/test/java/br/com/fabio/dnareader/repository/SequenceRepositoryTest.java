package br.com.fabio.dnareader.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.fabio.dnareader.model.Sequence;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SequenceRepositoryTest {

  @Autowired
  private SequenceRepository sequenceRepository;

  @Test
  public void deveriaSalvarUmaSequenciaDeDna() {

    Sequence sequence = new Sequence();

    String[] dna = new String[] { "AAAAAA", "CCCCCC", "TTATGT", "AGAAGG", "CCCCTA", "GGGGGG" };
    Map<String, Object> dnaValues = new java.util.HashMap<String, Object>();
    dnaValues.put("dna", dna);

    sequence.setDnaValues(dnaValues);

    Long id = sequenceRepository.save(sequence).getId();

    Sequence sequenceSaved = sequenceRepository.findById(id).get();

    assertEquals(sequenceSaved.getDnaValues().get("dna"), dnaValues.get("dna"));
  }

}
