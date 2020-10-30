package br.com.analiseacoes.analiseacoes.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Siglas implements Serializable, Comparable<Siglas> {

	/**
	 * @author Jailton de Andrade
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("servidor")
	private String servidor;
	@JsonProperty("acao")
	private String acao;
	@JsonProperty("preco")
	private String preco;
	@JsonProperty("setor")
	private String setor;
	@JsonProperty("ultimo5Anos")
	private String ultimo5Anos;
	@JsonProperty("ultimo10Anos")
	private String ultimo10Anos;

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getUltimo5Anos() {
		return ultimo5Anos;
	}

	public void setUltimo5Anos(String ultimo5Anos) {
		this.ultimo5Anos = ultimo5Anos;
	}

	public String getUltimo10Anos() {
		return ultimo10Anos;
	}

	public void setUltimo10Anos(String ultimo10Anos) {
		this.ultimo10Anos = ultimo10Anos;
	}

	@Override
	public int compareTo(Siglas lotsbs) {
		if (getUltimo5Anos() == null || lotsbs.getUltimo5Anos() == null) {
			return 0;
		}

		return getUltimo5Anos().compareTo(lotsbs.getUltimo5Anos());
	}

}
