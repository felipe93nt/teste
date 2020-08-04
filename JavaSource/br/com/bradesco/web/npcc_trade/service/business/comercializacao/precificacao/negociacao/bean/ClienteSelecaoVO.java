/**
 * Nome: br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean
 * 
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * 
 * Data da Criação: 13/01/2016
 *
 * @see : Referencias externas.
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean;

import br.com.bradesco.web.aq.view.components.UICnpj.CnpjDataType;
import br.com.bradesco.web.aq.view.components.UICpf.CpfDataType;
import br.com.bradesco.web.npcc_trade.utils.Numeros;

/**
 * Nome: ClienteSelecaoVO.java
 * 
 * Propósito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.5
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 13/01/2016
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public class ClienteSelecaoVO {
	
	private Long codCliente = null;
	
	private String nomeCliente = null;
	private String iredzdpssoacmbio = null;

    private CnpjDataType cnpj = new CnpjDataType();
    private CpfDataType cpf = new CpfDataType();

	private String nomeBanco = null;

	private String codAgencia = null;

	private String contaDv = null;
	
	/**
	 * INDICADOR DE PESQUISA POR CPF OU CNPJ
	 */
	private Integer codCpfCnpj = Numeros.DOIS;
	
	/**
	 * CÓDIGO ÚNICO DO CLIENTE
	 */
	private Long cunicpssoacmbio = Numeros.NUM0_LONG;

	
	private Integer cdcpfcnpj = 0;

    private Integer cdfilial = 0;

    private Integer cdctrlcpfcnpj = 0;

    private Integer caditvbletocmbio = 0;

    private Long cunicclicmbio = 0L;

    private Long cpssoajurid = 0L;
    
    private Integer nctabcriacmbio = 0;
    
    /**
     * CPF CNPJ FORMATADO
     */
    private String cpfCnpjFormatado;
	
	/**
	 * @return o valor do nomeCliente
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}

	/**
	 * @param nomeCliente seta o novo valor para o campo nomeCliente
	 */
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	/**
	 * @return o valor do cnpj
	 */
	public CnpjDataType getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj seta o novo valor para o campo cnpj
	 */
	public void setCnpj(CnpjDataType cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return o valor do cpf
	 */
	public CpfDataType getCpf() {
		return cpf;
	}

	/**
	 * @param cpf seta o novo valor para o campo cpf
	 */
	public void setCpf(CpfDataType cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return o valor do nomeBanco
	 */
	public String getNomeBanco() {
		return nomeBanco;
	}

	/**
	 * @param nomeBanco seta o novo valor para o campo nomeBanco
	 */
	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	/**
	 * @return o valor do codAgencia
	 */
	public String getCodAgencia() {
		return codAgencia;
	}

	/**
	 * @param codAgencia seta o novo valor para o campo codAgencia
	 */
	public void setCodAgencia(String codAgencia) {
		this.codAgencia = codAgencia;
	}

	/**
	 * @return o valor do contaDv
	 */
	public String getContaDv() {
		return contaDv;
	}

	/**
	 * @param contaDv seta o novo valor para o campo contaDv
	 */
	public void setContaDv(String contaDv) {
		this.contaDv = contaDv;
	}

	public Long getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Long codCliente) {
		this.codCliente = codCliente;
	}

	public Integer getCodCpfCnpj() {
		return codCpfCnpj;
	}

	public void setCodCpfCnpj(Integer codCpfCnpj) {
		this.codCpfCnpj = codCpfCnpj;
	}

	public Long getCunicpssoacmbio() {
		return cunicpssoacmbio;
	}

	public void setCunicpssoacmbio(Long cunicpssoacmbio) {
		this.cunicpssoacmbio = cunicpssoacmbio;
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
     * @return o valor do caditvbletocmbio
     */
    public Integer getCaditvbletocmbio() {
        return caditvbletocmbio;
    }

    /**
     * @param caditvbletocmbio seta o novo valor para o campo caditvbletocmbio
     */
    public void setCaditvbletocmbio(Integer caditvbletocmbio) {
        this.caditvbletocmbio = caditvbletocmbio;
    }

    /**
     * @return o valor do cunicclicmbio
     */
    public Long getCunicclicmbio() {
        return cunicclicmbio;
    }

    /**
     * @param cunicclicmbio seta o novo valor para o campo cunicclicmbio
     */
    public void setCunicclicmbio(Long cunicclicmbio) {
        this.cunicclicmbio = cunicclicmbio;
    }

    /**
     * @return o valor do cpssoajurid
     */
    public Long getCpssoajurid() {
        return cpssoajurid;
    }

    /**
     * @param cpssoajurid seta o novo valor para o campo cpssoajurid
     */
    public void setCpssoajurid(Long cpssoajurid) {
        this.cpssoajurid = cpssoajurid;
    }

    /**
     * @return o valor do nctabcriacmbio
     */
    public Integer getNctabcriacmbio() {
        return nctabcriacmbio;
    }

    /**
     * @param nctabcriacmbio seta o novo valor para o campo nctabcriacmbio
     */
    public void setNctabcriacmbio(Integer nctabcriacmbio) {
        this.nctabcriacmbio = nctabcriacmbio;
    }

    /**
     * @return o valor do iredzdpssoacmbio
     */
    public String getIredzdpssoacmbio() {
        return iredzdpssoacmbio;
    }

    /**
     * @param iredzdpssoacmbio seta o novo valor para o campo iredzdpssoacmbio
     */
    public void setIredzdpssoacmbio(String iredzdpssoacmbio) {
        this.iredzdpssoacmbio = iredzdpssoacmbio;
    }

    /**
     * @return o valor do cpfCnpjFormatado
     */
    public String getCpfCnpjFormatado() {
        return cpfCnpjFormatado;
    }

    /**
     * @param cpfCnpjFormatado seta o novo valor para o campo cpfCnpjFormatado
     */
    public void setCpfCnpjFormatado(String cpfCnpjFormatado) {
        this.cpfCnpjFormatado = cpfCnpjFormatado;
    }
}
