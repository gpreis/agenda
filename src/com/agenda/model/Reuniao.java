package com.agenda.model;

public class Reuniao  extends Compromisso{

	private String assunto;
	private String documentos;
	public Reuniao(String descricao, Integer dia, Integer mes, Integer ano,
			Integer hora, String assunto, String documentos) {
		super(descricao, dia, mes, ano, hora);
		this.assunto = assunto;
		this.documentos = documentos;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getDocumentos() {
		return documentos;
	}
	public void setDocumentos(String documentos) {
		this.documentos = documentos;
	}
	
}
