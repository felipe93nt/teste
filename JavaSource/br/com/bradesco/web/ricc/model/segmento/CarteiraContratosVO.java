package br.com.bradesco.web.ricc.model.segmento;

import br.com.bradesco.web.ricc.utils.SiteUtil;

public class CarteiraContratosVO implements Comparable<CarteiraContratosVO>{
	
	private String projetoObraServico;
	private String cliente;
	private String valorContrato;
	private String saldoPerformar;
	private String dataTermino;
	private String numSequencial = "0";
	
	private SiteUtil siteUtil = SiteUtil.getInstance();
	
	public CarteiraContratosVO(){
		
	}
	
	public CarteiraContratosVO(String projetoObraServico,
			String cliente, String valorContrato, String saldoPerformar,
			String dataTermino) {
		super();
		this.projetoObraServico = projetoObraServico;
		this.cliente = cliente;
		this.valorContrato = valorContrato;
		this.saldoPerformar = saldoPerformar;
		this.dataTermino = dataTermino;
	}

	public String getValorContratoFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(valorContrato);
	}
	
	public String getSaldoPerformarFormatado() {
		return SiteUtil.getInstance().formatValoresToStringInteger(saldoPerformar);
	}
	
	public String getProjetoObraServico() {
		return projetoObraServico;
	}

	public void setProjetoObraServico(String projetoObraServico) {
		this.projetoObraServico = projetoObraServico;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getValorContrato() {
		return valorContrato;
	}
	
	public void setValorContrato(String valorContrato) {
		this.valorContrato = valorContrato;
	}

	public String getSaldoPerformar() {
		return saldoPerformar;
	}
	
	public void setSaldoPerformar(String saldoPerformar) {
		this.saldoPerformar = saldoPerformar;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}
	
	public String getNumSequencial() {
		return numSequencial;
	}

	public void setNumSequencial(String numSequencial) {
		this.numSequencial = numSequencial;
	}

	@Override
	public int compareTo(CarteiraContratosVO o) {
		if (this.hashCode() == o.hashCode()) {
			return 0;
		} else {
			return this.hashCode() - o.hashCode();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result
				+ ((dataTermino == null) ? 0 : dataTermino.hashCode());
		result = prime * result
				+ ((numSequencial == null) ? 0 : numSequencial.hashCode());
		result = prime
				* result
				+ ((projetoObraServico == null) ? 0 : projetoObraServico
						.hashCode());
		result = prime * result
				+ ((saldoPerformar == null) ? 0 : saldoPerformar.hashCode());
		result = prime * result
				+ ((valorContrato == null) ? 0 : valorContrato.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarteiraContratosVO other = (CarteiraContratosVO) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (dataTermino == null) {
			if (other.dataTermino != null)
				return false;
		} else if (!dataTermino.equals(other.dataTermino.replace(".", "/")))
			return false;
		if (numSequencial == null) {
			if (other.numSequencial != null)
				return false;
		} else if (!numSequencial.equals(other.numSequencial))
			return false;
		if (projetoObraServico == null) {
			if (other.projetoObraServico != null)
				return false;
		} else if (!projetoObraServico.equals(other.projetoObraServico))
			return false;
		if (saldoPerformar == null) {
			if (other.saldoPerformar != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(saldoPerformar).equals(other.saldoPerformar))
			return false;
		if (valorContrato == null) {
			if (other.valorContrato != null)
				return false;
		} else if (!siteUtil.valueToMainframeString(valorContrato).equals(other.valorContrato))
			return false;
		return true;
	}
	
	

}
