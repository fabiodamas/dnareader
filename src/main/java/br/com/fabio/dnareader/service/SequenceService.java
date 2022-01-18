package br.com.fabio.dnareader.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fabio.dnareader.dto.SequenceDto;
import br.com.fabio.dnareader.model.DnaType;
import br.com.fabio.dnareader.model.Sequence;
import br.com.fabio.dnareader.repository.SequenceRepository;

@Service
public class SequenceService implements ISequenceService {

	private SequenceRepository sequenceRepository;
	private DnaUtilService dnaUtilService;

	public SequenceService(DnaUtilService dnaUtilService, SequenceRepository sequenceRepository){
		this.dnaUtilService =  dnaUtilService;
		this.sequenceRepository = sequenceRepository;
	}

	@Override
	public ResponseEntity<List<Sequence>> getAll() {
		List<Sequence> items = new ArrayList<>();

		sequenceRepository.findAll().forEach(items::add);

		if (items.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(items, HttpStatus.OK);

	}


	@Override
	public Sequence save(SequenceDto sequenceDto) {
		Sequence sequence = new Sequence(new HashMap<>());

		sequence.getDnaValues().put("dna", sequenceDto.getDna());
		sequence.setDnaType(getDnaType(sequenceDto));

		return sequenceRepository.save(sequence);
	}

	@Override
	public boolean isSimian(SequenceDto sequenceDto) {
		char[][] dnaMatrix = dnaUtilService.assembleMatrix(sequenceDto.getDna());

		return dnaUtilService.isPropertiesSimian(dnaMatrix);

	}

	@Override
	public DnaType getDnaType(SequenceDto sequenceDto) {
		char[][] dnaMatrix = dnaUtilService.assembleMatrix(sequenceDto.getDna());

		return dnaUtilService.isPropertiesSimian(dnaMatrix) ? DnaType.SIMIAN : DnaType.HUMAN;
	}

	@Override
	public long countSimian() {
    Sequence sequenceFind = new Sequence();
    sequenceFind.setDnaType(DnaType.SIMIAN);
		return sequenceRepository.count( Example.of(sequenceFind) );
	}

	@Override
	public long countHuman() {
    Sequence sequenceFind = new Sequence();
    sequenceFind.setDnaType(DnaType.HUMAN);
		return sequenceRepository.count( Example.of(sequenceFind) );
	}

	@Override
	public long calculateRatio() {
		return countSimian() / countHuman();
	}

	

}
