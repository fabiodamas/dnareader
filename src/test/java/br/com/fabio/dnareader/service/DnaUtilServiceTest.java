package br.com.fabio.dnareader.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@RunWith(SpringRunner.class)
public class DnaUtilServiceTest {

  private DnaUtilService service;

  @BeforeEach
  public void inicializar() {
    service = new DnaUtilService();
  }

  @Test
  public void shouldFindSimianByColumn() {
    String[] dna = {  "ATGGGG",
                      "ACCCCC",
                      "AAGGGT",
                      "AGCCCT",
                      "GGGGGT",
                      "CCCCCT" };

    char[][] dnaMatrix = service.assembleMatrix(dna);

    assertEquals(true, service.isSimianColumn(dnaMatrix));
  }

  @Test
  public void shouldFindSimianByDiagonal() {
    String[] dna = {  "ACGAGG",
                      "CGAGGT",
                      "CAGGGT",
                      "AGCCCA",
                      "GADGGA",
                      "ACGCAG" };

    char[][] dnaMatrix = service.assembleMatrix(dna);

    assertEquals(true, service.isSimianDiagonal(dnaMatrix));
  }

  @Test
  public void shouldFindSimianByLine() {
    String[] dna = {  "AAAAGG",
                      "CCCCGT",
                      "CAGGGT",
                      "AGCCCA",
                      "GADGGA",
                      "ACGCAG" };

    char[][] dnaMatrix = service.assembleMatrix(dna);

    assertEquals(true, service.isSimianLine(dnaMatrix));
  }

  @Test
  public void shouldAssembleMatrixTwoDimension() {
    String[] dna1Dimension = {  "AAAAAA",
                      "CCCCGT",
                      "CAGGGT",
                      "AGCCCA",
                      "GADGGA",
                      "ACGCAG" };

    char[][] dna2Dimension = { {'A','A','A','A','A','A'}, 
                               {'C','C','C','C','G','T'},
                               {'C','A','G','G','G','T'},
                               {'A','G','C','C','C','A'},
                               {'G','A','D','G','G','A'},
                               {'A','C','G','C','A','G'},
                             };

    assertEquals(true, Arrays.deepEquals(dna2Dimension, service.assembleMatrix(dna1Dimension)));

  }

}
