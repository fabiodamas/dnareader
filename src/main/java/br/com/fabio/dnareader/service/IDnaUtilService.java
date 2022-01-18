package br.com.fabio.dnareader.service;

import org.springframework.stereotype.Service;

@Service
public interface IDnaUtilService {

  public boolean isSimianDiagonal(char[][] dnaMatrix) ;
  public boolean isSimianLine(char[][] dnaMatrix);
  public boolean isSimianColumn(char[][] dnaMatrix);
	public boolean isPropertiesSimian(char[][] dnaMatrix);
  
  public char[][] assembleMatrix(String[] dnaSequence);

}
