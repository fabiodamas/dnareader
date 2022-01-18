package br.com.fabio.dnareader.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
public class DnaUtilService implements IDnaUtilService{
  private static final Logger logger = LoggerFactory.getLogger(SequenceService.class);

  static final int DIMENSION = 6;
  static final String[] REPETITION = { "AAAA", "TTTT", "CCCC", "GGGG" };

  @Override
  public boolean isSimianDiagonal(char[][] dnaMatrix) {
    int count = 0;

    for (int k = 0; k < DIMENSION * 2; k++) {
      StringBuilder diagonal = new StringBuilder();

      for (int j = 0; j <= k; j++) {
        int i = k - j;
        if (i < DIMENSION && j < DIMENSION) {
          diagonal.append(dnaMatrix[i][j]);
        }
      }
      count = diagonalCount(count, diagonal);

    }

    logger.info("Number of repeating diagonals:  {}", count);

    return (count >= 2);

  }

  private int diagonalCount(int contagem, StringBuilder diagonal) {
    if (diagonal.length() >= 4) {
      for (String repeticao : REPETITION) {
        if (diagonal.toString().contains(repeticao)) {
          contagem++;
        }
      }
    }
    return contagem;
  }

  @Override
  public boolean isSimianLine(char[][] dnaMatrix) {
    int count = 0;

    for (char[] row : dnaMatrix) {
      StringBuilder line = new StringBuilder();

      for (char num : row) {
        line.append(num);

      }

      for (String repeticao : REPETITION) {
        if (line.toString().contains(repeticao)) {
          count++;
        }
      }

    }

    logger.info("Number of repeating lines:  {}", count);

    return (count >= 2);
  }

  @Override
  public boolean isSimianColumn(char[][] dnaMatrix) {
    int count = 0;

    for (int i = 0; i < dnaMatrix.length; i++) {
      StringBuilder sb = new StringBuilder();

      for (int j = 0; j < dnaMatrix.length; j++) {
        sb.append(dnaMatrix[j][i]);
      }

      for (String repeticao : REPETITION) {
        if (sb.toString().contains(repeticao)) {
          count++;
        }
      }

    }

    logger.info("Number of repeating columns: {}", count);

    return (count >= 2);

  }

  @Override
  public char[][] assembleMatrix(String[] dnaSequence) {
    char[][] dnaMatrix = new char[DIMENSION][DIMENSION];

    for (int i = 0; i < DIMENSION; i++) {
      for (int j = 0; j < DIMENSION; j++) {
        dnaMatrix[i][j] = dnaSequence[i].charAt(j);
      }
    }

    return dnaMatrix;
  }

  @Override
	public boolean isPropertiesSimian(char[][] dnaMatrix) {
		return (isSimianLine(dnaMatrix) || isSimianDiagonal(dnaMatrix) || isSimianColumn(dnaMatrix));
	}  

}
