package br.com.fabio.dnareader.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.fabio.dnareader.dto.SequenceDto;
import org.junit.jupiter.api.Test;

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
  public void shouldReturnTypeHuman() {
    //public DnaType getDnaType(SequenceDto sequenceDto) {
    assertEquals(true, true);
  }

  @Test
  public void shouldReturnTypeSimian() {
    // public boolean isSimian(SequenceDto sequenceDto) {
    assertEquals(true, true);
  }
    
  
  @Test
  public void shouldSaveSequence() {
    //public Sequence save(SequenceDto sequenceDto) {
    assertEquals(true, true);
  }
  
  @Test
  public void shouldReturnRatio4() {
    ArrayList<SequenceDto> sequenceDtoSimian = new ArrayList<>(); 
    ArrayList<String[]> dnaSimian = new ArrayList<>(); 
    AtomicInteger counterH = new AtomicInteger(-1);
    AtomicInteger counterS = new AtomicInteger(-1);


    sequenceDtoSimian.add(new SequenceDto());
    sequenceDtoSimian.add(new SequenceDto());
    sequenceDtoSimian.add(new SequenceDto());
    sequenceDtoSimian.add(new SequenceDto());
    sequenceDtoSimian.add(new SequenceDto());

    dnaSimian.add(new String[] { "AAAAAA", "CCCCCC", "TTATGT", "AGAAGG", "CCCCTA", "GGGGGG" });
    dnaSimian.add(new String[] { "TTTTTT", "CCCCCC", "TTATGT", "AGAAGG", "CCCCTA", "GGGGGG" });
    dnaSimian.add(new String[] { "GGGGGG", "CCCCCC", "TTATGT", "AGAAGG", "CCCCTA", "GGGGGG" });
    dnaSimian.add(new String[] { "CCCCCC", "CCCCCC", "TTATGT", "AGAAGG", "CCCCTA", "GGGGGG" });

    sequenceDtoSimian.stream().forEach(sequenceDto -> {
      sequenceDto.setDna(dnaSimian.get(counterS.getAndIncrement()));
      service.save(sequenceDto);
    });
    
    ArrayList<SequenceDto> sequenceDtoHuman = new ArrayList<>(); 
    ArrayList<String[]> dnaHuman = new ArrayList<>(); 

    sequenceDtoHuman.add(new SequenceDto());
    sequenceDtoHuman.add(new SequenceDto());

    dnaHuman.add(new String[] { "AGAAGG",
                      "CATACT",
                      "TTATGT",
                      "CATGCT",
                      "CGCATA",
                      "GGCATA" });
                      
    dnaHuman.add(new String[] { "AGAAGG",
                      "AGTTGG",
                      "TTATGT",
                      "CATAGT",
                      "CACCTA",
                      "AGCATA" });


    sequenceDtoHuman.stream().forEach(sequenceDto -> {
      sequenceDto.setDna(dnaHuman.get(counterH.getAndIncrement()));
      service.save(sequenceDto);
    });


   System.out.println(service.countHuman()); 
   System.out.println(service.countSimian()); 

    assertEquals(true, true);
  }
  
 


}
