package br.com.fabio.dnareader.resource;

import br.com.fabio.dnareader.dto.SequenceDto;
import br.com.fabio.dnareader.model.Sequence;
import br.com.fabio.dnareader.repository.SequenceRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DnaResource {

  private SequenceRepository sequenceRepository;

  public DnaResource(SequenceRepository sequenceRepository) {
    this.sequenceRepository = sequenceRepository;
  }

  /*
   * // FUNCIONA
   * 
   * @PostMapping("/simian")
   * public ResponseEntity<Sequence> simian(@RequestBody SequenceDto sequenceDto)
   * {
   * Sequence sequence = new Sequence(new HashMap<String, Object>());
   * sequence.getDnaValues().put("dna", sequenceDto.getDna());
   * sequence = sequenceRepository.save(sequence);
   * return new ResponseEntity<>(sequence, HttpStatus.CREATED);
   * }
   * 
   * // FUNCIONA
   * 
   * @GetMapping("/sequence")
   * public ResponseEntity<Sequence> getSequence() {
   * Sequence sequence = sequenceRepository.findAll().get(0);
   * return new ResponseEntity<>(sequence, HttpStatus.OK);
   * }
   * 
   */

  @PostMapping("/simian")
  public ResponseEntity<HashMap<String, Boolean>> simian(@RequestBody SequenceDto sequenceDto) {
    Sequence sequence = new Sequence(new HashMap<String, Object>());
    sequence.getDnaValues().put("dna", sequenceDto.getDna());
    sequence = sequenceRepository.save(sequence);
    // return new ResponseEntity<>(sequence, HttpStatus.CREATED);

    HashMap<String, Boolean> map = new HashMap<>();
    map.put("is_simian", true);
    return ResponseEntity.ok(map);

  }


  @GetMapping("/stats")
  public ResponseEntity<List<Sequence>> stats() {
    try {
      List<Sequence> items = new ArrayList<Sequence>();

      sequenceRepository.findAll().forEach(items::add);

      if (items.isEmpty())
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

      return new ResponseEntity<>(items, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }  

  @GetMapping("/listagem")
  public ResponseEntity<List<Sequence>> getAll() {
    try {
      List<Sequence> items = new ArrayList<Sequence>();

      sequenceRepository.findAll().forEach(items::add);

      if (items.isEmpty())
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

      return new ResponseEntity<>(items, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /*
   * @PostMapping("/simian")
   * public ResponseEntity<HashMap<String, Boolean>> simian(@RequestBody
   * SequenceDto sequenceDto) {
   * Sequence sequence = new Sequence();
   * sequence.setDnaValues(sequenceDto.getDnaValues());
   * sequence = sequenceRepository.save(sequence);
   * 
   * HashMap<String, Boolean> map = new HashMap<>();
   * map.put("is_simian", true);
   * 
   * return ResponseEntity.ok(map);
   * 
   * }
   * 
   * 
   * 
   * @PostMapping("/simian")
   * public ResponseEntity<Sequence> simian(@RequestBody SequenceDto sequenceDto)
   * {
   * Sequence sequence = new Sequence();
   * sequence.setDnaValues(sequenceDto.getDnaValues());
   * sequence = sequenceRepository.save(sequence);
   * 
   * HashMap<String, Boolean> map = new HashMap<>();
   * map.put("is_simian", true);
   * 
   * // return ResponseEntity.ok(map);
   * return new ResponseEntity<>(sequence, HttpStatus.CREATED);
   */

}
