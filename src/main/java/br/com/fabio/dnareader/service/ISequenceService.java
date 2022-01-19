package br.com.fabio.dnareader.service;

import br.com.fabio.dnareader.dto.SequenceDto;
import br.com.fabio.dnareader.model.DnaType;
import br.com.fabio.dnareader.model.Sequence;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

public interface ISequenceService {
  ResponseEntity<List<Sequence>> getAll();
  void save(SequenceDto sequenceDto);
  boolean isSimian(SequenceDto sequenceDto);
  DnaType getDnaType(SequenceDto sequenceDto) ;
  long countSimian ();
  long countHuman();
  BigDecimal calculateRatio();

}
