package br.com.analiseacoes.analiseacoes.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SummaryDyByYearDTO implements Serializable {

	/**
	 * @author Jailton de Andrade
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("ano")
	private String ano;
	@JsonProperty("valor")
	private Double valor;

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
