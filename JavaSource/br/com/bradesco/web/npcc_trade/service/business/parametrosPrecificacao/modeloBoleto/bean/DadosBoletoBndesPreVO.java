package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.npcc_trade.utils.Numeros;


/**
 * 
 * Nome: DadosBoletoVO.java
 * 
 * Propósito:
 * <p>
 * Dados para impressão de uma boleto
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
public class DadosBoletoBndesPreVO extends DadosBoletoVO {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1352308782238373213L;
    
    private List<ClausulasBoletoVO> clausulasRegiaoUm = new ArrayList<ClausulasBoletoVO>();
    
    private List<ClausulasBoletoVO> clausulasRegiaoDois = new ArrayList<ClausulasBoletoVO>();
    
    /**
     * Construtor
     * */
    public DadosBoletoBndesPreVO() {
        super.numeroClausula = Numeros.DOIS;
    }

    /**
     * 
     * Nome: getClausulasRegiaoUm
     * 
     * Propósito: Retorna as clausulas da primeira região do modelo de boleto do produto BNDES POS
     *
     * @return : List<ClausulasBoletoVO>
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<ClausulasBoletoVO> getClausulasRegiaoUm() {
        
        clausulasRegiaoUm = new ArrayList<ClausulasBoletoVO>();
        
        if(!getClausulas().isEmpty()) {
            clausulasRegiaoUm.add(getClausulas().get(0));
        }
        
        return clausulasRegiaoUm;
    }
	
    /**
     * 
     * Nome: getClausulasRegiaoDois
     * 
     * Propósito: Retorna as clausulas da segunda região do modelo de boleto do produto BNDES POS
     *
     * @return : List<ClausulasBoletoVO>
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<ClausulasBoletoVO> getClausulasRegiaoDois() {
        
        clausulasRegiaoDois = new ArrayList<ClausulasBoletoVO>();
        
        if(!getClausulas().isEmpty() && getClausulas().size() > 1) {
            clausulasRegiaoDois.addAll(getClausulas().subList(1, getClausulas().size()));
        }
        
        return clausulasRegiaoDois;
    }

    /**
     * @param clausulasRegiaoUm seta o novo valor para o campo clausulasRegiaoUm
     */
    public void setClausulasRegiaoUm(List<ClausulasBoletoVO> clausulasRegiaoUm) {
        this.clausulasRegiaoUm = clausulasRegiaoUm;
    }

    /**
     * @param clausulasRegiaoDois seta o novo valor para o campo clausulasRegiaoDois
     */
    public void setClausulasRegiaoDois(List<ClausulasBoletoVO> clausulasRegiaoDois) {
        this.clausulasRegiaoDois = clausulasRegiaoDois;
    }
    
    
}
