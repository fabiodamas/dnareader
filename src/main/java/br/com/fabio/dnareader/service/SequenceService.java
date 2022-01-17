package br.com.fabio.dnareader.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fabio.dnareader.dto.SequenceDto;
import br.com.fabio.dnareader.model.Sequence;
import br.com.fabio.dnareader.repository.SequenceRepository;

@Service
public class SequenceService implements ISequenceService {

	@Autowired
	private SequenceRepository sequenceRepository;

	private DnaUtilService dnaUtilService;

	public SequenceService(DnaUtilService dnaUtilService){
		// dnaUtilService = new DnaUtilService();
		this.dnaUtilService =  dnaUtilService;
	}

	@Override
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


	@Override
	public Sequence save(SequenceDto sequenceDto) {
		Sequence sequence = new Sequence(new HashMap<String, Object>());
		sequence.getDnaValues().put("dna", sequenceDto.getDna());
		return sequenceRepository.save(sequence);
	}

	public boolean isSimian(SequenceDto sequenceDto) {
		char[][] dnaMatrix = dnaUtilService.assembleMatrix(sequenceDto.getDna());

		return isPropertiesSimian(dnaMatrix);

	}

	private boolean isPropertiesSimian(char[][] dnaMatrix) {
		return (dnaUtilService.isSimianLine(dnaMatrix) || dnaUtilService.isSimianDiagonal(dnaMatrix) || dnaUtilService.isSimianColumn(dnaMatrix));
	}

}
