package br.com.analiseacoes.analiseacoes.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DividendsDTO implements Serializable, Comparable<DividendsDTO> {

	/**
	 * @author Jailton de Andrade
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("y")
	private Integer y;
	@JsonProperty("m")
	private Integer m;
	@JsonProperty("d")
	private Integer d;
	@JsonProperty("ad")
	private Integer ad;
	@JsonProperty("ed")
	private String ed;
	@JsonProperty("pd")
	private String pd;
	@JsonProperty("et")
	private String et;
	@JsonProperty("etd")
	private String etd;
	@JsonProperty("v")
	private double v;
	@JsonProperty("ov")
	private Integer ov;
	@JsonProperty("sv")
	private String sv;
	@JsonProperty("sov")
	private String sov;
	@JsonProperty("adj")
	private boolean adj;

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Integer getM() {
		return m;
	}

	public void setM(Integer m) {
		this.m = m;
	}

	public Integer getD() {
		return d;
	}

	public void setD(Integer d) {
		this.d = d;
	}

	public Integer getAd() {
		return ad;
	}

	public void setAd(Integer ad) {
		this.ad = ad;
	}

	public String getEd() {
		return ed;
	}

	public void setEd(String ed) {
		this.ed = ed;
	}

	public String getPd() {
		return pd;
	}

	public void setPd(String pd) {
		this.pd = pd;
	}

	public String getEt() {
		return et;
	}

	public void setEt(String et) {
		this.et = et;
	}

	public String getEtd() {
		return etd;
	}

	public void setEtd(String etd) {
		this.etd = etd;
	}

	public double getV() {
		return v;
	}

	public void setV(double v) {
		this.v = v;
	}

	public Integer getOv() {
		return ov;
	}

	public void setOv(Integer ov) {
		this.ov = ov;
	}

	public String getSv() {
		return sv;
	}

	public void setSv(String sv) {
		this.sv = sv;
	}

	public String getSov() {
		return sov;
	}

	public void setSov(String sov) {
		this.sov = sov;
	}

	public boolean isAdj() {
		return adj;
	}

	public void setAdj(boolean adj) {
		this.adj = adj;
	}

	@Override
	public int compareTo(DividendsDTO dDTO1) {
		if (getPd() == null || dDTO1.getPd() == null) {
			return 0;
		}

		if (getPd().equals("") || dDTO1.getPd().equals("")) {
			return 0;
		}

		return getPd().compareTo(dDTO1.getPd());
	}

}
