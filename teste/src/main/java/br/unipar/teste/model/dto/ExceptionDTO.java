package br.unipar.teste.model.dto;

public class ExceptionDTO {
	private String messege;
	
	public ExceptionDTO(String messege) {
		this.messege = messege;
	}

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}
	
	
}
