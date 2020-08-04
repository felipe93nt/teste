package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.aq.view.util.Numeros;
import br.com.bradesco.web.npcc_trade.service.business.global.BaseVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboClausulaVO;

/**
 * 
 * Nome: TipoClausulaVO.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 27/11/2015 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */
public class ModeloBoletoVO extends BaseVO implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -784468677938776379L;

    /** Inclusão */
    private Integer cmodldprodtcmbio = null;
    private Integer cunicpssoacmbio = null;
    private Integer cclauscontrcmbio = Numeros.ZERO;
    private List<ComboClausulaVO> lista = new ArrayList<ComboClausulaVO>();

    /** Obeter dados */
    private String itpoclauscmbio = null;
    private Integer cclausmodcmbio = Numeros.ZERO;
    private String rclausmodcmbio = null;
    
    /** Lista combo */
    private Integer cprodtservc = Numeros.ZERO;
    private String dprodtservc = null;
    private Integer ctpoclauscmbio = null;
    private String rclauscontrcmbio = null;
    private String imodcontrcmbio = null;
    private Integer cmodcontrcmbio = null;
    private boolean cindcdmodpdrao = false;


    public ModeloBoletoVO() {
        super();
    }

    public String getItpoclauscmbio() {
        return itpoclauscmbio;
    }

    public void setItpoclauscmbio(String itpoclauscmbio) {
        this.itpoclauscmbio = itpoclauscmbio;
    }

    public Integer getCclausmodcmbio() {
        return cclausmodcmbio;
    }

    public void setCclausmodcmbio(Integer cclausmodcmbio) {
        this.cclausmodcmbio = cclausmodcmbio;
    }

    public String getRclausmodcmbio() {
        return rclausmodcmbio;
    }

    public void setRclausmodcmbio(String rclausmodcmbio) {
        this.rclausmodcmbio = rclausmodcmbio;
    }

    public Integer getCprodtservc() {
        return cprodtservc;
    }

    public void setCprodtservc(Integer cprodtservc) {
        this.cprodtservc = cprodtservc;
    }

    public Integer getCmodcontrcmbio() {
        return cmodcontrcmbio;
    }

    public void setCmodcontrcmbio(Integer cmodcontrcmbio) {
        this.cmodcontrcmbio = cmodcontrcmbio;
    }

    public Integer getCmodldprodtcmbio() {
        return cmodldprodtcmbio;
    }

    public void setCmodldprodtcmbio(Integer cmodldprodtcmbio) {
        this.cmodldprodtcmbio = cmodldprodtcmbio;
    }

    public Integer getCunicpssoacmbio() {
        return cunicpssoacmbio;
    }

    public void setCunicpssoacmbio(Integer cunicpssoacmbio) {
        this.cunicpssoacmbio = cunicpssoacmbio;
    }

    public Integer getCclauscontrcmbio() {
        return cclauscontrcmbio;
    }

    public void setCclauscontrcmbio(Integer cclauscontrcmbio) {
        this.cclauscontrcmbio = cclauscontrcmbio;
    }

    public List<ComboClausulaVO> getLista() {
        return lista;
    }

    public void setLista(List<ComboClausulaVO> lista) {
        this.lista = lista;
    }

    public String getImodcontrcmbio() {
        return imodcontrcmbio;
    }

    public void setImodcontrcmbio(String imodcontrcmbio) {
        this.imodcontrcmbio = imodcontrcmbio;
    }

    public Integer getCtpoclauscmbio() {
        return ctpoclauscmbio;
    }

    public void setCtpoclauscmbio(Integer ctpoclauscmbio) {
        this.ctpoclauscmbio = ctpoclauscmbio;
    }

    public String getRclauscontrcmbio() {
        if (rclauscontrcmbio == null) {
            rclauscontrcmbio = "";
        }
        return rclauscontrcmbio;
    }

    public void setRclauscontrcmbio(String rclauscontrcmbio) {
        this.rclauscontrcmbio = rclauscontrcmbio;
    }

	/**
	 * @return the dprodtservc
	 */
	public String getDprodtservc() {
		return dprodtservc;
	}

	/**
	 * @param dprodtservc the dprodtservc to set
	 */
	public void setDprodtservc(String dprodtservc) {
		this.dprodtservc = dprodtservc;
	}

	public boolean getCindcdmodpdrao() {
		return cindcdmodpdrao;
	}

	public void setCindcdmodpdrao(boolean cindcdmodpdrao) {
		this.cindcdmodpdrao = cindcdmodpdrao;
	}

}
