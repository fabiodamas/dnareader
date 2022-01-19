package br.com.fabio.dnareader.service;

import br.com.fabio.dnareader.dto.SequenceDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SequenceServiceTest {

  @Autowired
  private SequenceService service;

  @Test
  public void shouldReturn3Simion() {
    SequenceDto sequenceDto1 = new SequenceDto();
    SequenceDto sequenceDto2 = new SequenceDto();
    SequenceDto sequenceDto3 = new SequenceDto();

    String[] dna1 = { "AAAAAA", "CCCCCC", "TTATGT", "AGAAGG", "CCCCTA", "GGGGGG" };
    String[] dna2 = { "TTTTTT", "CCCCCC", "TTATGT", "AGAAGG", "CCCCTA", "GGGGGG" };
    String[] dna3 = { "GGGGGG", "CCCCCC", "TTATGT", "AGAAGG", "CCCCTA", "GGGGGG" };

    sequenceDto1.setDna(dna1);
    sequenceDto2.setDna(dna2);
    sequenceDto3.setDna(dna3);

    service.save(sequenceDto1);
    service.save(sequenceDto2);
    service.save(sequenceDto3);
    
    assertEquals(3, service.countSimian());
  }  

  @Test
  public void shouldReturn3Human() {
    SequenceDto sequenceDto1 = new SequenceDto();
    SequenceDto sequenceDto2 = new SequenceDto();
    SequenceDto sequenceDto3 = new SequenceDto();

    String[] dna1 = { "AGAAGG",
                      "CATACT",
                      "TTATGT",
                      "CATGCT",
                      "CGCATA",
                      "GGCATA" };
                      
    String[] dna2 = { "AGAAGG",
                      "AGTTGG",
                      "TTATGT",
                      "CATAGT",
                      "CACCTA",
                      "AGCATA" };

    String[] dna3 = { "CATACT",
                      "AGAAGG",
                      "GAAGTA",
                      "CGTACT",
                      "CCACTA",
                      "CGAATA" };

    sequenceDto1.setDna(dna1);
    sequenceDto2.setDna(dna2);
    sequenceDto3.setDna(dna3);

    service.save(sequenceDto1);
    service.save(sequenceDto2);
    service.save(sequenceDto3);
    
    assertEquals(3, service.countHuman());
  }  

  @Test
  public void shouldReturnRatio2() {
    SequenceDto sequenceDtoSimian1 = new SequenceDto();
    SequenceDto sequenceDtoSimian2 = new SequenceDto();

    String[] dnaSimian1 = { "AAAAAA", "CCCCCC", "TTATGT", "AGAAGG", "CCCCTA", "GGGGGG" };
    String[] dnaSimian2 = { "TTTTTT", "CCCCCC", "TTATGT", "AGAAGG", "CCCCTA", "GGGGGG" };

    sequenceDtoSimian1.setDna(dnaSimian1);
    sequenceDtoSimian2.setDna(dnaSimian2);

    service.save(sequenceDtoSimian1);
    service.save(sequenceDtoSimian2);


    SequenceDto sequenceDtoHuman1 = new SequenceDto();

    String[] dnaHuman1 = { "AGAAGG",
            "CATACT",
            "TTATGT",
            "CATGCT",
            "CGCATA",
            "GGCATA" };

    sequenceDtoHuman1.setDna(dnaHuman1);

    service.save(sequenceDtoHuman1);


    assertEquals(new BigDecimal(2).setScale(2, RoundingMode.HALF_EVEN), service.calculateRatio());


  }
  
 


}
