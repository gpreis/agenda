package com.agenda.model;

public class Contas extends Compromisso{

	private double valor;
	private String vencimento;
	private boolean paguei;
	
	
	public Contas(String descricao, Integer dia, Integer mes, Integer ano,
			Integer hora, double valor, String vencimento , boolean paguei) {
		super(descricao, dia, mes, ano, hora);
	    this.valor = valor;
	    this.vencimento = vencimento;
	    this.paguei = paguei;
	}
	
    public void pagamentoRealizado(){
    	this.paguei = true;
    }

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getVencimento() {
		return vencimento;
	}

	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}

	public boolean isPaguei() {
		return paguei;
	}

	public void setPaguei(boolean paguei) {
		this.paguei = paguei;
	}
    
    
	
	
}
