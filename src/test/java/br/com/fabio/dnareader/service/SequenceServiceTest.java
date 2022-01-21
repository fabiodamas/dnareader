package br.com.fabio.dnareader.service;

import br.com.fabio.dnareader.dto.DnaDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class SequenceServiceTest {

  @Autowired
  private SequenceService service;

  @Test
  public void shouldReturn3Simion() {
    DnaDto dnaDto1 = new DnaDto();
    DnaDto dnaDto2 = new DnaDto();
    DnaDto dnaDto3 = new DnaDto();

    String[] dna1 = { "AAAAAA", "CCCCCC", "TTATGT", "AGAAGG", "CCCCTA", "GGGGGG" };
    String[] dna2 = { "TTTTTT", "CCCCCC", "TTATGT", "AGAAGG", "CCCCTA", "GGGGGG" };
    String[] dna3 = { "GGGGGG", "CCCCCC", "TTATGT", "AGAAGG", "CCCCTA", "GGGGGG" };

    dnaDto1.setDna(dna1);
    dnaDto2.setDna(dna2);
    dnaDto3.setDna(dna3);

    service.save(dnaDto1);
    service.save(dnaDto2);
    service.save(dnaDto3);
    
    assertEquals(3, service.countSimian());
  }  

  @Test
  public void shouldReturn3Human() {
    DnaDto dnaDto1 = new DnaDto();
    DnaDto dnaDto2 = new DnaDto();
    DnaDto dnaDto3 = new DnaDto();

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

    dnaDto1.setDna(dna1);
    dnaDto2.setDna(dna2);
    dnaDto3.setDna(dna3);

    service.save(dnaDto1);
    service.save(dnaDto2);
    service.save(dnaDto3);
    
    assertEquals(3, service.countHuman());
  }  

  @Test
  public void shouldReturnRatio2() {
    DnaDto dnaDtoSimian1 = new DnaDto();
    DnaDto dnaDtoSimian2 = new DnaDto();

    String[] dnaSimian1 = { "AAAAAA", "CCCCCC", "TTATGT", "AGAAGG", "CCCCTA", "GGGGGG" };
    String[] dnaSimian2 = { "TTTTTT", "CCCCCC", "TTATGT", "AGAAGG", "CCCCTA", "GGGGGG" };

    dnaDtoSimian1.setDna(dnaSimian1);
    dnaDtoSimian2.setDna(dnaSimian2);

    service.save(dnaDtoSimian1);
    service.save(dnaDtoSimian2);


    DnaDto dnaDtoHuman1 = new DnaDto();

    String[] dnaHuman1 = { "AGAAGG",
            "CATACT",
            "TTATGT",
            "CATGCT",
            "CGCATA",
            "GGCATA" };

    dnaDtoHuman1.setDna(dnaHuman1);

    service.save(dnaDtoHuman1);


    assertEquals(new BigDecimal(2).setScale(2, RoundingMode.HALF_EVEN), service.calculateRatio());


  }
  
 


}
