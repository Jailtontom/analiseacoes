package br.com.analiseacoes.analiseacoes.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestSearchDTO implements Serializable {

	/**
	 * @author Jailton de Andrade
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("Sector")
	private String sector;
	@JsonProperty("SubSector")
	private String subSector;
	@JsonProperty("Segment")
	private String segment;
	@JsonProperty("my_range")
	private String myRange;
	@JsonProperty("dy")
	private RequestDyDTO dy;
	@JsonProperty("p_L")
	private RequestPlDTO pL;
	@JsonProperty("p_VP")
	private RequestPvpDTO pVp;
	@JsonProperty("p_Ativo")
	private RequestPAtivoDTO pAtivo;
	@JsonProperty("margemBruta")
	private RequestMargemBrutaDTO margemBruta;
	@JsonProperty("margemEbit")
	private RequestMargemEbitDTO margemEbit;
	@JsonProperty("margemLiquida")
	private RequestMargemLiquidaDTO margemLiquida;
	@JsonProperty("p_Ebit")
	private RequestPEbitDTO pEbit;
	@JsonProperty("eV_Ebit")
	private RequestEvEbitDTO eVEbit;
	@JsonProperty("dividaLiquidaEbit")
	private RequestDividaLiquidaEbitDTO dividaLiquidaEbit;
	@JsonProperty("dividaliquidaPatrimonioLiquido")
	private RequestDividaLiquidaPatrimonioLiquidoDTO dividaLiquidaPatrimonioLiquido;
	@JsonProperty("p_SR")
	private RequestPSRDTO psr;
	@JsonProperty("p_CapitalGiro")
	private RequestPCapitalGiroDTO pCapitalGiro;
	@JsonProperty("p_AtivoCirculante")
	private RequestPAtivoCirculanteDTO pAtivoCirculante;
	@JsonProperty("roe")
	private RequestRoeDTO roe;
	@JsonProperty("roic")
	private RequestRoicDTO roic;
	@JsonProperty("roa")
	private RequestRoaDTO roa;
	@JsonProperty("liquidezCorrente")
	private RequestLiquidezCorrenteDTO liquidezCorrente;
	@JsonProperty("pl_Ativo")
	private RequestPlAtivoDTO plAtivo;
	@JsonProperty("passivo_Ativo")
	private RequestPassivoAtivoDTO passivoAtivo;
	@JsonProperty("giroAtivos")
	private RequestGiroAtivosDTO giroAtivos;
	@JsonProperty("receitas_Cagr5")
	private RequestReceitasCagr5DTO receitasCagr5;
	@JsonProperty("lucros_Cagr5")
	private RequestLucrosCagr5DTO lucrosCagr5;
	@JsonProperty("liquidezMediaDiaria")
	private RequestLiquidezMediaDiariaDTO liquidezMediaDiaria;

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getSubSector() {
		return subSector;
	}

	public void setSubSector(String subSector) {
		this.subSector = subSector;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getMyRange() {
		return myRange;
	}

	public void setMyRange(String myRange) {
		this.myRange = myRange;
	}

	public RequestDyDTO getDy() {
		return dy;
	}

	public void setDy(RequestDyDTO dy) {
		this.dy = dy;
	}

	public RequestPlDTO getpL() {
		return pL;
	}

	public void setpL(RequestPlDTO pL) {
		this.pL = pL;
	}

	public RequestPvpDTO getpVp() {
		return pVp;
	}

	public void setpVp(RequestPvpDTO pVp) {
		this.pVp = pVp;
	}

	public RequestPAtivoDTO getpAtivo() {
		return pAtivo;
	}

	public void setpAtivo(RequestPAtivoDTO pAtivo) {
		this.pAtivo = pAtivo;
	}

	public RequestMargemBrutaDTO getMargemBruta() {
		return margemBruta;
	}

	public void setMargemBruta(RequestMargemBrutaDTO margemBruta) {
		this.margemBruta = margemBruta;
	}

	public RequestMargemEbitDTO getMargemEbit() {
		return margemEbit;
	}

	public void setMargemEbit(RequestMargemEbitDTO margemEbit) {
		this.margemEbit = margemEbit;
	}

	public RequestMargemLiquidaDTO getMargemLiquida() {
		return margemLiquida;
	}

	public void setMargemLiquida(RequestMargemLiquidaDTO margemLiquida) {
		this.margemLiquida = margemLiquida;
	}

	public RequestPEbitDTO getpEbit() {
		return pEbit;
	}

	public void setpEbit(RequestPEbitDTO pEbit) {
		this.pEbit = pEbit;
	}

	public RequestEvEbitDTO geteVEbit() {
		return eVEbit;
	}

	public void seteVEbit(RequestEvEbitDTO eVEbit) {
		this.eVEbit = eVEbit;
	}

	public RequestDividaLiquidaEbitDTO getDividaLiquidaEbit() {
		return dividaLiquidaEbit;
	}

	public void setDividaLiquidaEbit(RequestDividaLiquidaEbitDTO dividaLiquidaEbit) {
		this.dividaLiquidaEbit = dividaLiquidaEbit;
	}

	public RequestDividaLiquidaPatrimonioLiquidoDTO getDividaLiquidaPatrimonioLiquido() {
		return dividaLiquidaPatrimonioLiquido;
	}

	public void setDividaLiquidaPatrimonioLiquido(
			RequestDividaLiquidaPatrimonioLiquidoDTO dividaLiquidaPatrimonioLiquido) {
		this.dividaLiquidaPatrimonioLiquido = dividaLiquidaPatrimonioLiquido;
	}

	public RequestPSRDTO getPsr() {
		return psr;
	}

	public void setPsr(RequestPSRDTO psr) {
		this.psr = psr;
	}

	public RequestPCapitalGiroDTO getpCapitalGiro() {
		return pCapitalGiro;
	}

	public void setpCapitalGiro(RequestPCapitalGiroDTO pCapitalGiro) {
		this.pCapitalGiro = pCapitalGiro;
	}

	public RequestPAtivoCirculanteDTO getpAtivoCirculante() {
		return pAtivoCirculante;
	}

	public void setpAtivoCirculante(RequestPAtivoCirculanteDTO pAtivoCirculante) {
		this.pAtivoCirculante = pAtivoCirculante;
	}

	public RequestRoeDTO getRoe() {
		return roe;
	}

	public void setRoe(RequestRoeDTO roe) {
		this.roe = roe;
	}

	public RequestRoicDTO getRoic() {
		return roic;
	}

	public void setRoic(RequestRoicDTO roic) {
		this.roic = roic;
	}

	public RequestRoaDTO getRoa() {
		return roa;
	}

	public void setRoa(RequestRoaDTO roa) {
		this.roa = roa;
	}

	public RequestLiquidezCorrenteDTO getLiquidezCorrente() {
		return liquidezCorrente;
	}

	public void setLiquidezCorrente(RequestLiquidezCorrenteDTO liquidezCorrente) {
		this.liquidezCorrente = liquidezCorrente;
	}

	public RequestPlAtivoDTO getPlAtivo() {
		return plAtivo;
	}

	public void setPlAtivo(RequestPlAtivoDTO plAtivo) {
		this.plAtivo = plAtivo;
	}

	public RequestPassivoAtivoDTO getPassivoAtivo() {
		return passivoAtivo;
	}

	public void setPassivoAtivo(RequestPassivoAtivoDTO passivoAtivo) {
		this.passivoAtivo = passivoAtivo;
	}

	public RequestGiroAtivosDTO getGiroAtivos() {
		return giroAtivos;
	}

	public void setGiroAtivos(RequestGiroAtivosDTO giroAtivos) {
		this.giroAtivos = giroAtivos;
	}

	public RequestReceitasCagr5DTO getReceitasCagr5() {
		return receitasCagr5;
	}

	public void setReceitasCagr5(RequestReceitasCagr5DTO receitasCagr5) {
		this.receitasCagr5 = receitasCagr5;
	}

	public RequestLucrosCagr5DTO getLucrosCagr5() {
		return lucrosCagr5;
	}

	public void setLucrosCagr5(RequestLucrosCagr5DTO lucrosCagr5) {
		this.lucrosCagr5 = lucrosCagr5;
	}

	public RequestLiquidezMediaDiariaDTO getLiquidezMediaDiaria() {
		return liquidezMediaDiaria;
	}

	public void setLiquidezMediaDiaria(RequestLiquidezMediaDiariaDTO liquidezMediaDiaria) {
		this.liquidezMediaDiaria = liquidezMediaDiaria;
	}

}
