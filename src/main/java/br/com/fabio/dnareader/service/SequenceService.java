package br.com.fabio.dnareader.service;

import br.com.fabio.dnareader.dto.DnaDto;
import br.com.fabio.dnareader.model.DnaType;
import br.com.fabio.dnareader.model.Dna;
import br.com.fabio.dnareader.model.SimianResponse;
import br.com.fabio.dnareader.model.StatsResponse;
import br.com.fabio.dnareader.repository.DnaRepository;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;

@Service
public class SequenceService {

    private final DnaRepository dnaRepository;
    private final DnaUtilService dnaUtilService;

    public SequenceService(DnaUtilService dnaUtilService, DnaRepository dnaRepository) {
        this.dnaUtilService = dnaUtilService;
        this.dnaRepository = dnaRepository;
    }

    public ResponseEntity<List<Dna>> getAll() {
        List<Dna> items = dnaRepository.findAll();

        if (items.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(items, HttpStatus.OK);

    }


    public SimianResponse save(DnaDto dnaDto) {
        SimianResponse simianResponse = new SimianResponse();
        Dna sequence = new Dna(new HashMap<>());

        sequence.getDnaValues().put("dna", dnaDto.getDna());

        sequence.setDnaType(getDnaType(dnaDto));

        dnaRepository.save(sequence);

        simianResponse.setValue(isSimian(dnaDto));

        return simianResponse;
    }

    public boolean isSimian(DnaDto dnaDto) {
        char[][] dnaMatrix = dnaUtilService.assembleMatrix(dnaDto.getDna());

        return dnaUtilService.isPropertiesSimian(dnaMatrix);

    }

    public DnaType getDnaType(DnaDto dnaDto) {
        char[][] dnaMatrix = dnaUtilService.assembleMatrix(dnaDto.getDna());

        return dnaUtilService.isPropertiesSimian(dnaMatrix) ? DnaType.SIMIAN : DnaType.HUMAN;
    }

    public long countSimian() {
        Dna sequenceFind = new Dna();
        sequenceFind.setDnaType(DnaType.SIMIAN);
        return dnaRepository.count(Example.of(sequenceFind));
    }

    public long countHuman() {
        Dna sequenceFind = new Dna();
        sequenceFind.setDnaType(DnaType.HUMAN);
        return dnaRepository.count(Example.of(sequenceFind));
    }

    public BigDecimal calculateRatio() {
        return BigDecimal.valueOf(countSimian())
                .divide(BigDecimal.valueOf(countHuman()), 2, RoundingMode.HALF_EVEN);
    }

    public StatsResponse getStatsResponse() {
        StatsResponse statsResponse = new StatsResponse();

        statsResponse.setCountHuman(countHuman());
        statsResponse.setCountSimian(countSimian());
        statsResponse.setRatio(calculateRatio());

        return statsResponse;
    }

}
