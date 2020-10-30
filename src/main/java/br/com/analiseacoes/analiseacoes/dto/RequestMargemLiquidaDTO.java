package br.com.analiseacoes.analiseacoes.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestMargemLiquidaDTO implements Serializable {

	/**
	 * @author Jailton de Andrade
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("Item1")
	private Integer item1;
	@JsonProperty("Item2")
	private Integer item2;

	public Integer getItem1() {
		return item1;
	}

	public void setItem1(Integer item1) {
		this.item1 = item1;
	}

	public Integer getItem2() {
		return item2;
	}

	public void setItem2(Integer item2) {
		this.item2 = item2;
	}

}
