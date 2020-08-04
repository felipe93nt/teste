 package br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.garantiasModal.bean;

import java.io.Serializable;
/**
 * 
  * Nome: GarantiasAva.java
  * 
  * Propósito: <p> Classe utilizada para apresentacao da listagem de Historico Antecipacao Boleto </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilação -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manutenção: 14/01/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
 */
public class GarantiasAvaListaVO implements Serializable {
    
    private static final long serialVersionUID = 0L;

	//@Adapter(transactionField = "NPCCWJQE-REGISTRO.NPCCWJQE-NBLETO-NEGOC-CMBIO")
	private Long nbletonegoccmbio = null;

	//@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA.NPCCWJQS-CUNIC-PSSOA-CMBIO")
	private Long cunicpssoacmbio = null;

	//@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA.NPCCWJQS-CPSSOA")
	private Long cpssoa = null;

	//@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA.NPCCWJQS-DOCUMENTO")
	private String documento = null;

	//@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA.NPCCWJQS-CD-EMPRESA")
	private Long cdempresa = null;

	//@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA.NPCCWJQS-CD-CPFCNPJ")
	private Integer cdcpfcnpj = null;

	//@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA.NPCCWJQS-CD-FILIAL")
	private Integer cdfilial = null;

	//@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA.NPCCWJQS-CD-CTRL-CPFCNPJ")
	private Integer cdctrlcpfcnpj = null;

	//@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA.NPCCWJQS-NM-NOME-CLIENTE")
	private String nmnomecliente = null;

	//@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA.NPCCWJQS-NM-CONJUGE")
	private String nmconjuge = null;

	//@Adapter(transactionField = "NPCCWJQS-REGISTRO.NPCCWJQS-LISTA.NPCCWJQS-QUALIFICACAO")
	private String qualificacao = null;
	
	private String dcocliente = null;
	
	private String cpfcnpjformatado = null;
	
	/**
	 * @return o valor do nbletonegoccmbio
	 */
	public Long getNbletonegoccmbio() {
		return nbletonegoccmbio;
	}

	/**
	 * @param nbletonegoccmbio seta o novo valor para o campo nbletonegoccmbio
	 */
	public void setNbletonegoccmbio(Long nbletonegoccmbio) {
		this.nbletonegoccmbio = nbletonegoccmbio;
	}

	/**
	 * @return o valor do cunicpssoacmbio
	 */
	public Long getCunicpssoacmbio() {
		return cunicpssoacmbio;
	}

	/**
	 * @param cunicpssoacmbio seta o novo valor para o campo cunicpssoacmbio
	 */
	public void setCunicpssoacmbio(Long cunicpssoacmbio) {
		this.cunicpssoacmbio = cunicpssoacmbio;
	}

	/**
	 * @return o valor do cpssoa
	 */
	public Long getCpssoa() {
		return cpssoa;
	}

	/**
	 * @param cpssoa seta o novo valor para o campo cpssoa
	 */
	public void setCpssoa(Long cpssoa) {
		this.cpssoa = cpssoa;
	}

	/**
	 * @return o valor do documento
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * @param documento seta o novo valor para o campo documento
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	/**
	 * @return o valor do cdempresa
	 */
	public Long getCdempresa() {
		return cdempresa;
	}

	/**
	 * @param cdempresa seta o novo valor para o campo cdempresa
	 */
	public void setCdempresa(Long cdempresa) {
		this.cdempresa = cdempresa;
	}

	/**
	 * @return o valor do cdcpfcnpj
	 */
	public Integer getCdcpfcnpj() {
		return cdcpfcnpj;
	}

	/**
	 * @param cdcpfcnpj seta o novo valor para o campo cdcpfcnpj
	 */
	public void setCdcpfcnpj(Integer cdcpfcnpj) {
		this.cdcpfcnpj = cdcpfcnpj;
	}

	/**
	 * @return o valor do cdfilial
	 */
	public Integer getCdfilial() {
		return cdfilial;
	}

	/**
	 * @param cdfilial seta o novo valor para o campo cdfilial
	 */
	public void setCdfilial(Integer cdfilial) {
		this.cdfilial = cdfilial;
	}

	/**
	 * @return o valor do cdctrlcpfcnpj
	 */
	public Integer getCdctrlcpfcnpj() {
		return cdctrlcpfcnpj;
	}

	/**
	 * @param cdctrlcpfcnpj seta o novo valor para o campo cdctrlcpfcnpj
	 */
	public void setCdctrlcpfcnpj(Integer cdctrlcpfcnpj) {
		this.cdctrlcpfcnpj = cdctrlcpfcnpj;
	}

	/**
	 * @return o valor do nmnomecliente
	 */
	public String getNmnomecliente() {
		return nmnomecliente;
	}

	/**
	 * @param nmnomecliente seta o novo valor para o campo nmnomecliente
	 */
	public void setNmnomecliente(String nmnomecliente) {
		this.nmnomecliente = nmnomecliente;
	}

	/**
	 * @return o valor do nmconjuge
	 */
	public String getNmconjuge() {
		return nmconjuge;
	}

	/**
	 * @param nmconjuge seta o novo valor para o campo nmconjuge
	 */
	public void setNmconjuge(String nmconjuge) {
		this.nmconjuge = nmconjuge;
	}

	/**
	 * @return o valor do qualificacao
	 */
	public String getQualificacao() {
		return qualificacao;
	}

	/**
	 * @param qualificacao seta o novo valor para o campo qualificacao
	 */
	public void setQualificacao(String qualificacao) {
		this.qualificacao = qualificacao;
	}

	/**
	 * @return o valor do serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDcocliente() {
		return dcocliente;
	}

	public void setDcocliente(String dcocliente) {
		this.dcocliente = dcocliente;
	}

    /**
     * @return o valor do cpfcnpjformatado
     */
    public String getCpfcnpjformatado() {
        return cpfcnpjformatado;
    }

    /**
     * @param cpfcnpjformatado seta o novo valor para o campo cpfcnpjformatado
     */
    public void setCpfcnpjformatado(String cpfcnpjformatado) {
        this.cpfcnpjformatado = cpfcnpjformatado;
    }

}
