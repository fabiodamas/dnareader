package br.com.fabio.dnareader.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fabio.dnareader.dto.SequenceDto;
import br.com.fabio.dnareader.model.Sequence;
import br.com.fabio.dnareader.repository.SequenceRepository;

@Service
public class SequenceService  implements ISequenceService {

	private static final Logger logger = LoggerFactory.getLogger(SequenceService.class);

  private SequenceRepository sequenceRepository;

  public SequenceService(SequenceRepository sequenceRepository) {
    this.sequenceRepository = sequenceRepository;
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
	public boolean isSimioDiagonal(char[][] todosDNA, int dim, String[] repeticoes) {
		int contagem = 0;
		String diagonal = "";

		for (int k = 0; k < dim * 2; k++) {
			for (int j = 0; j <= k; j++) {
				int i = k - j;
				if (i < dim && j < dim) {
					diagonal += todosDNA[i][j];
				}
			}

			if (diagonal.length() >= 4) {
				for (String repeticao : repeticoes) {
					if (diagonal.contains(repeticao)) {
						contagem++;
					}
				}
			}

			diagonal = "";
		}

		logger.info("isSimioDiagonal, contagem: " + contagem);

		return (contagem >= 2);

	}

	@Override
	public boolean isSimioLine(char[][] todosDNA, String[] repeticoes) {

		int contagem = 0;
		String linha = "";

		for (char[] row : todosDNA) {
			for (char num : row) {
				linha += num;
			}

			for (String repeticao : repeticoes) {
				if (linha.contains(repeticao)) {
					contagem++;
				}
			}

			linha = "";
		}

		logger.info("isSimioLine, contagem: " + contagem);

		return (contagem >= 2);

	}

	@Override
	public void montarMatriz6d(String[] sequenciaDNA, char[][] todosDNA) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				todosDNA[i][j] = sequenciaDNA[i].charAt(j);
			}
		}
	}


	@Override
	public Sequence save(SequenceDto sequenceDto) {
		Sequence sequence = new Sequence(new HashMap<String, Object>());
    sequence.getDnaValues().put("dna", sequenceDto.getDna());
		return sequenceRepository.save(sequence);
	}



}
