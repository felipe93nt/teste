package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.npcc_trade.utils.Numeros;


/**
 * 
 * Nome: DadosBoletoVO.java
 * 
 * Prop�sito:
 * <p>
 * Dados para impress�o de uma boleto
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compila��o -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manuten��o: 27/11/2015 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padr�o hexavision.
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
     * Prop�sito: Retorna as clausulas da primeira regi�o do modelo de boleto do produto BNDES POS
     *
     * @return : List<ClausulasBoletoVO>
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 08/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
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
     * Prop�sito: Retorna as clausulas da segunda regi�o do modelo de boleto do produto BNDES POS
     *
     * @return : List<ClausulasBoletoVO>
     * @see : Referencias externas.
     *
     *      Registro de Manuten��o: 08/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequa��o ao padr�o hexavision.
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
