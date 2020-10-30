package br.com.analiseacoes.analiseacoes.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockExchangeDTO implements Serializable, Comparable<StockExchangeDTO> {

	/**
	 * @author Jailton de Andrade
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("companyId")
	private Integer companyId;
	@JsonProperty("companyName")
	private String companyName;
	@JsonProperty("ticker")
	private String ticker;
	@JsonProperty("price")
	private double price;
	@JsonProperty("p_L")
	private double pL;
	@JsonProperty("dy")
	private double dy;
	@JsonProperty("p_VP")
	private double pVP;
	@JsonProperty("p_Ebit")
	private double pEbit;
	@JsonProperty("p_Ativo")
	private double pAtivo;
	@JsonProperty("eV_Ebit")
	private double eVEbit;
	@JsonProperty("margemBruta")
	private double margemBruta;
	@JsonProperty("margemEbit")
	private double margemEbit;
	@JsonProperty("margemLiquida")
	private double margemLiquida;
	@JsonProperty("p_SR")
	private double pSR;
	@JsonProperty("p_CapitalGiro")
	private double pCapitalGiro;
	@JsonProperty("p_AtivoCirculante")
	private double pAtivoCirculante;
	@JsonProperty("giroAtivos")
	private double giroAtivos;
	@JsonProperty("roe")
	private double roe;
	@JsonProperty("roa")
	private double roa;
	@JsonProperty("roic")
	private double roic;
	@JsonProperty("dividaliquidaPatrimonioLiquido")
	private double dividaliquidaPatrimonioLiquido;
	@JsonProperty("dividaLiquidaEbit")
	private double dividaLiquidaEbit;
	@JsonProperty("pl_Ativo")
	private double plAtivo;
	@JsonProperty("passivo_Ativo")
	private double passivoAtivo;
	@JsonProperty("liquidezCorrente")
	private double liquidezCorrente;
	@JsonProperty("receitas_Cagr5")
	private double receitasCagr5;
	@JsonProperty("lucros_Cagr5")
	private double lucrosCagr5;
	@JsonProperty("liquidezMediaDiaria")
	private double liquidezMediaDiaria;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getpL() {
		return pL;
	}

	public void setpL(double pL) {
		this.pL = pL;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public double getpVP() {
		return pVP;
	}

	public void setpVP(double pVP) {
		this.pVP = pVP;
	}

	public double getpEbit() {
		return pEbit;
	}

	public void setpEbit(double pEbit) {
		this.pEbit = pEbit;
	}

	public double getpAtivo() {
		return pAtivo;
	}

	public void setpAtivo(double pAtivo) {
		this.pAtivo = pAtivo;
	}

	public double geteVEbit() {
		return eVEbit;
	}

	public void seteVEbit(double eVEbit) {
		this.eVEbit = eVEbit;
	}

	public double getMargemBruta() {
		return margemBruta;
	}

	public void setMargemBruta(double margemBruta) {
		this.margemBruta = margemBruta;
	}

	public double getMargemEbit() {
		return margemEbit;
	}

	public void setMargemEbit(double margemEbit) {
		this.margemEbit = margemEbit;
	}

	public double getMargemLiquida() {
		return margemLiquida;
	}

	public void setMargemLiquida(double margemLiquida) {
		this.margemLiquida = margemLiquida;
	}

	public double getpSR() {
		return pSR;
	}

	public void setpSR(double pSR) {
		this.pSR = pSR;
	}

	public double getpCapitalGiro() {
		return pCapitalGiro;
	}

	public void setpCapitalGiro(double pCapitalGiro) {
		this.pCapitalGiro = pCapitalGiro;
	}

	public double getpAtivoCirculante() {
		return pAtivoCirculante;
	}

	public void setpAtivoCirculante(double pAtivoCirculante) {
		this.pAtivoCirculante = pAtivoCirculante;
	}

	public double getGiroAtivos() {
		return giroAtivos;
	}

	public void setGiroAtivos(double giroAtivos) {
		this.giroAtivos = giroAtivos;
	}

	public double getRoe() {
		return roe;
	}

	public void setRoe(double roe) {
		this.roe = roe;
	}

	public double getRoa() {
		return roa;
	}

	public void setRoa(double roa) {
		this.roa = roa;
	}

	public double getRoic() {
		return roic;
	}

	public void setRoic(double roic) {
		this.roic = roic;
	}

	public double getDividaliquidaPatrimonioLiquido() {
		return dividaliquidaPatrimonioLiquido;
	}

	public void setDividaliquidaPatrimonioLiquido(double dividaliquidaPatrimonioLiquido) {
		this.dividaliquidaPatrimonioLiquido = dividaliquidaPatrimonioLiquido;
	}

	public double getDividaLiquidaEbit() {
		return dividaLiquidaEbit;
	}

	public void setDividaLiquidaEbit(double dividaLiquidaEbit) {
		this.dividaLiquidaEbit = dividaLiquidaEbit;
	}

	public double getPlAtivo() {
		return plAtivo;
	}

	public void setPlAtivo(double plAtivo) {
		this.plAtivo = plAtivo;
	}

	public double getPassivoAtivo() {
		return passivoAtivo;
	}

	public void setPassivoAtivo(double passivoAtivo) {
		this.passivoAtivo = passivoAtivo;
	}

	public double getLiquidezCorrente() {
		return liquidezCorrente;
	}

	public void setLiquidezCorrente(double liquidezCorrente) {
		this.liquidezCorrente = liquidezCorrente;
	}

	public double getReceitasCagr5() {
		return receitasCagr5;
	}

	public void setReceitasCagr5(double receitasCagr5) {
		this.receitasCagr5 = receitasCagr5;
	}

	public double getLucrosCagr5() {
		return lucrosCagr5;
	}

	public void setLucrosCagr5(double lucrosCagr5) {
		this.lucrosCagr5 = lucrosCagr5;
	}

	public double getLiquidezMediaDiaria() {
		return liquidezMediaDiaria;
	}

	public void setLiquidezMediaDiaria(double liquidezMediaDiaria) {
		this.liquidezMediaDiaria = liquidezMediaDiaria;
	}

	@Override
	public int compareTo(StockExchangeDTO stockExchangeDTO) {
		return Double.compare(getDy(), stockExchangeDTO.getDy());
	}

}
