package br.com.fabio.dnareader.resource;

import br.com.fabio.dnareader.dto.SequenceDto;
import br.com.fabio.dnareader.model.Sequence;
import br.com.fabio.dnareader.service.SequenceService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DnaResource {
  SequenceService sequenceService;

  public DnaResource(SequenceService sequenceService) {
    this.sequenceService = sequenceService;
  }

  @PostMapping("/simian")
    public Map<String, Boolean> simian(@RequestBody SequenceDto sequenceDto) {

    sequenceService.save(sequenceDto);


    
    return Collections.singletonMap("is_simian", true);
  }

  @GetMapping("/stats")
  public ResponseEntity<List<Sequence>> getAll() {
    return sequenceService.getAll();
  }

}
