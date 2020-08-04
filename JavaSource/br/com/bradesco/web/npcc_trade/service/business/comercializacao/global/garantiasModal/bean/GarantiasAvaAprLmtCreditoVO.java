package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean;


public class GarantiasAvaAprLmtCreditoVO {

	/**
	 * TIPO DE DOCUMENTO
	 */
	private String documento = null;

	/**
	 * NUMERO DO CONTRATO DE LIMITE
	 */
	private Long nseqcontrlim = 0L;

	/**
	 * RAIZ DO CPF/CNPJ
	 */
	private Integer cdcpfcnpj = 0;

	/**
	 * FILIAL DO CNPJ
	 */
	private Integer cdfilial = 0;

	/**
	 * DIGITO DE CONTROLE DO CPF/CNPJ
	 */
	private Integer cdctrlcpfcnpj = 0;

	/**
	 * NOME DO AVALISTA
	 */
	private String nmnomecliente = null;

	/**
	 * QUALIFICACAO
	 */
	private String cdoctopssoaempr = null;

	/**
	 * E/OU
	 */
	private String dindcdobrigavals = null;
	
	/**
	 * CPF/CNPJ FORMATADO
	 */
	private String cpfcnpjformatado;

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Long getNseqcontrlim() {
		return nseqcontrlim;
	}

	public void setNseqcontrlim(Long nseqcontrlim) {
		this.nseqcontrlim = nseqcontrlim;
	}

	public Integer getCdcpfcnpj() {
		return cdcpfcnpj;
	}

	public void setCdcpfcnpj(Integer cdcpfcnpj) {
		this.cdcpfcnpj = cdcpfcnpj;
	}

	public Integer getCdfilial() {
		return cdfilial;
	}

	public void setCdfilial(Integer cdfilial) {
		this.cdfilial = cdfilial;
	}

	public Integer getCdctrlcpfcnpj() {
		return cdctrlcpfcnpj;
	}

	public void setCdctrlcpfcnpj(Integer cdctrlcpfcnpj) {
		this.cdctrlcpfcnpj = cdctrlcpfcnpj;
	}

	public String getNmnomecliente() {
		return nmnomecliente;
	}

	public void setNmnomecliente(String nmnomecliente) {
		this.nmnomecliente = nmnomecliente;
	}

	public String getCdoctopssoaempr() {
		return cdoctopssoaempr;
	}

	public void setCdoctopssoaempr(String cdoctopssoaempr) {
		this.cdoctopssoaempr = cdoctopssoaempr;
	}

	public String getDindcdobrigavals() {
		return dindcdobrigavals;
	}

	public void setDindcdobrigavals(String dindcdobrigavals) {
		this.dindcdobrigavals = dindcdobrigavals;
	}

	public String getCpfcnpjformatado() {
		return cpfcnpjformatado;
	}

	public void setCpfcnpjformatado(String cpfcnpjformatado) {
		this.cpfcnpjformatado = cpfcnpjformatado;
	}
	
	
}
