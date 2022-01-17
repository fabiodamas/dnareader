package br.com.fabio.dnareader.dto;


public class SequenceDto {
	private String[] dna;

	
	public SequenceDto() {
	}


	public SequenceDto(String[] dna) {
		this.dna = dna;
	}


	public String[] getDna() {
		return dna;
	}


	public void setDna(String[] dna) {
		this.dna = dna;
	}

	
}
