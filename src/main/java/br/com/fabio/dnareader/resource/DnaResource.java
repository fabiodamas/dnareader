package br.com.fabio.dnareader.resource;

import br.com.fabio.dnareader.dto.DnaDto;
import br.com.fabio.dnareader.model.Dna;
import br.com.fabio.dnareader.model.SimianResponse;
import br.com.fabio.dnareader.model.StatsResponse;
import br.com.fabio.dnareader.service.SequenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DnaResource {

  private final SequenceService sequenceService;

  public DnaResource(SequenceService sequenceService) {
    this.sequenceService = sequenceService;
  }

  @PostMapping("/simian")
  public ResponseEntity<SimianResponse> simian(@RequestBody @Valid DnaDto dnaDto) {
    return ResponseEntity.status(HttpStatus.OK).body(
            sequenceService.save(dnaDto)
    );
  }

  @GetMapping("/stats")
  public ResponseEntity<StatsResponse> stats() {
    return ResponseEntity.status(HttpStatus.OK).body(
            sequenceService.getStatsResponse()
    );
  }

  @GetMapping("/listAll")
  public ResponseEntity<List<Dna>> listAll() {
    return sequenceService.getAll();
  }



}
