package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboClausulaVO;
import br.com.bradesco.web.npcc_trade.service.business.global.common.bean.ComboTipoClausulaVO;

/**
 * 
 * Nome: DadosBoletoVO.java
 * 
 * Propósito:
 * <p>
 *      Dados para impressão de uma boleto
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
public class ClausulasBoletoVO {
	
	private ComboTipoClausulaVO tipoClausula = new ComboTipoClausulaVO();
	private List<ComboClausulaVO> clausulas = new ArrayList<ComboClausulaVO>();
	
	public ClausulasBoletoVO() {
	    super();
	}
	
	public ClausulasBoletoVO(Integer ctpoclauscmbio) {
	    this.tipoClausula.setCtpoclauscmbio(ctpoclauscmbio);
	}
	
    /**
     * @return o valor do tipoClausula
     */
    public ComboTipoClausulaVO getTipoClausula() {
        return tipoClausula;
    }
    /**
     * @param tipoClausula seta o novo valor para o campo tipoClausula
     */
    public void setTipoClausula(ComboTipoClausulaVO tipoClausula) {
        this.tipoClausula = tipoClausula;
    }
    /**
     * @return o valor do clausulas
     */
    public List<ComboClausulaVO> getClausulas() {
        return clausulas;
    }
    /**
     * @param clausulas seta o novo valor para o campo clausulas
     */
    public void setClausulas(List<ComboClausulaVO> clausulas) {
        this.clausulas = clausulas;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof ClausulasBoletoVO && this.getTipoClausula() != null) {
            final ClausulasBoletoVO other = (ClausulasBoletoVO) obj;
            return other.getTipoClausula().getCtpoclauscmbio().equals(this.getTipoClausula().getCtpoclauscmbio());
        } else {
            return false;
        }
    }
    
}
