package br.com.fabio.dnareader.service;

import java.util.List;
import org.springframework.http.ResponseEntity;

import br.com.fabio.dnareader.dto.SequenceDto;
import br.com.fabio.dnareader.model.Sequence;

public interface ISequenceService {

  public ResponseEntity<List<Sequence>> getAll();

  public Sequence save(SequenceDto sequenceDto);


  public boolean isSimioDiagonal(char[][] todosDNA, int dim, String[] repeticoes) ;
  public boolean isSimioLine(char[][] todosDNA, String[] repeticoes);
  public void montarMatriz6d(String[] sequenciaDNA, char[][] todosDNA);
}
