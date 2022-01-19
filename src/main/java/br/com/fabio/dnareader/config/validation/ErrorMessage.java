package br.com.fabio.dnareader.config.validation;

public class ErrorMessage {

	private final  String campo;
	private final  String mensagem;
	
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
