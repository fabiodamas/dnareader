package br.com.fabio.dnareader.dto;


import br.com.fabio.dnareader.dto.validations.DnaConstraint;

public class DnaDto {

	@DnaConstraint
	private String[] dna;

	public DnaDto() {
	}

	public DnaDto(String[] dna) {
		this.dna = dna;
	}

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}
}
