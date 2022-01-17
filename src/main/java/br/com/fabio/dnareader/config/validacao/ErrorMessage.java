package br.com.fabio.dnareader.config.validacao;

public class ErrorMessage {
	
	private String campo;
	private String mensagem;
	
	public ErrorMessage(String field, String error) {
		this.campo = field;
		this.mensagem = error;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}
	
	

}
