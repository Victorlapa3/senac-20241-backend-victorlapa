package model.seletor.carros;

import model.seletor.BaseSeletor;

public class CarroSeletor extends BaseSeletor {

	private String nomeMarca;
	private String modelo;
	private Integer anoInicial;
	private Integer anoFinal;
	private Double valorInicial;
	private Double valorFinal;

	public boolean temFiltro() {
		return (this.nomeMarca != null && !this.nomeMarca.trim().isEmpty())
				|| (this.modelo != null && !this.modelo.trim().isEmpty()) || (this.anoInicial != null)
				|| (this.anoFinal != null) || (this.valorInicial != null) || (this.valorFinal != null);
	}

	public boolean anoEhValido() {
		return (this.anoInicial == null && this.anoFinal == null) || (this.anoInicial != null && this.anoFinal != null);
	}

	public boolean valorEhValido() {
		return (this.valorInicial == null && this.valorFinal == null)
				|| (this.valorInicial != null && this.valorFinal != null);
	}

	public CarroSeletor() {

	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnoInicial() {
		return anoInicial;
	}

	public void setAnoInicial(Integer anoInicial) {
		this.anoInicial = anoInicial;
	}

	public Integer getAnoFinal() {
		return anoFinal;
	}

	public void setAnoFinal(Integer anoFinal) {
		this.anoFinal = anoFinal;
	}

	public Double getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(Double valorInicial) {
		this.valorInicial = valorInicial;
	}

	public Double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}

}
