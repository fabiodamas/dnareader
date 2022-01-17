package br.com.fabio.dnareader.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DnaUtilService {
  private static final Logger logger = LoggerFactory.getLogger(SequenceService.class);

  static final int DIMENSION = 6;
  static final String[] REPETITION = { "AAAA", "TTTT", "CCCC", "GGGG" };

  public boolean isSimianDiagonal(char[][] dnaMatrix) {
    int contagem = 0;
    String diagonal = "";

    for (int k = 0; k < DIMENSION * 2; k++) {
      for (int j = 0; j <= k; j++) {
        int i = k - j;
        if (i < DIMENSION && j < DIMENSION) {
          diagonal += dnaMatrix[i][j];
        }
      }

      if (diagonal.length() >= 4) {
        for (String repeticao : REPETITION) {
          if (diagonal.contains(repeticao)) {
            contagem++;
          }
        }
      }

      diagonal = "";
    }

    logger.info("isSimioDiagonal: {}", contagem);

    return (contagem >= 2);

  }

  public boolean isSimianLine(char[][] dnaMatrix) {
    int contagem = 0;
    String linha = "";

    for (char[] row : dnaMatrix) {
      for (char num : row) {
        linha += num;
      }

      for (String repeticao : REPETITION) {
        if (linha.contains(repeticao)) {
          contagem++;
        }
      }

      linha = "";
    }

    logger.info("isSimioLine, {}", contagem);

    return (contagem >= 2);
  }

  public boolean isSimianColumn(char[][] dnaMatrix) {
    int contagem = 0;

    for (int i = 0; i < dnaMatrix.length; i++) {
      StringBuilder sb = new StringBuilder();

      for (int j = 0; j < dnaMatrix.length; j++) {
        sb.append(dnaMatrix[j][i]);
      }

      for (String repeticao : REPETITION) {
        if (sb.toString().contains(repeticao)) {
          contagem++;
        }
      }

    }

    logger.info("isSimianColumn, {}", contagem);

    return (contagem >= 2);

  }

  public char[][] assembleMatrix(String[] dnaSequence) {
    char[][] dnaMatrix = new char[DIMENSION][DIMENSION];

    for (int i = 0; i < DIMENSION; i++) {
      for (int j = 0; j < DIMENSION; j++) {
        dnaMatrix[i][j] = dnaSequence[i].charAt(j);
      }
    }

    return dnaMatrix;
  }

}
