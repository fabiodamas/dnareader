package br.com.fabio.dnareader.resource;

import br.com.fabio.dnareader.dto.SequenceDto;
import br.com.fabio.dnareader.model.Sequence;
import br.com.fabio.dnareader.service.SequenceService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DnaResource {

  private final SequenceService sequenceService;


  public DnaResource(SequenceService sequenceService) {
    this.sequenceService = sequenceService;
  }

  @PostMapping("/simian")
  public ResponseEntity<HashMap<String, Boolean>> simian(@RequestBody SequenceDto sequenceDto) {

    sequenceService.save(sequenceDto);

    HashMap<String, Boolean> map = new HashMap<>();

    map.put("is_simian", sequenceService.isSimian(sequenceDto));
    
    return ResponseEntity.status(HttpStatus.OK).body(map);
  }

  @GetMapping("/listAll")
  public ResponseEntity<List<Sequence>> listAll() {
    return sequenceService.getAll();
  }

  @GetMapping("/stats")
  public ResponseEntity<HashMap<String, Object>>  stats() {
    HashMap<String, Object> map = new HashMap<>();

    map.put("count_simian_dna", sequenceService.countSimian());
    map.put("count_human_dna", sequenceService.countHuman());
    map.put("ratio", sequenceService.calculateRatio());

    return ResponseEntity.status(HttpStatus.OK).body(map);
  }

  @PostMapping("/isSimianLine")
  public Boolean isSimianLine(@RequestBody SequenceDto sequenceDto) {
    return sequenceService.isSimian(sequenceDto);
  }


}
