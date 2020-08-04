package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.log.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
  * Nome: LogAlteracaoVO.java
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
  * Registro  de Manutenção: 04/02/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
public final class TradeFinanceLogDiferencasListaVo implements Serializable {    
    /** Variavel do tipo long. */
    private static final long serialVersionUID = 5090324198753252147L;
    
    private List<String> antes = null;
    
    private List<String> depois = null;
        
    /**
     * Construtor Padrão
     * 
     * @param 
     */
    public TradeFinanceLogDiferencasListaVo() {
        super();
        
        antes = new ArrayList<String>();
        depois = new ArrayList<String>();
    }

    /**
     * @return o valor do antes
     */
    public List<String> getAntes() {
        return antes;
    }

    /**
     * @param antes seta o novo valor para o campo antes
     */
    public void setAntes(List<String> antes) {
        this.antes = antes;
    }

    /**
     * @return o valor do depois
     */
    public List<String> getDepois() {
        return depois;
    }

    /**
     * @param depois seta o novo valor para o campo depois
     */
    public void setDepois(List<String> depois) {
        this.depois = depois;
    }
    
    /**
     * @return o valor do itensAlterados
     */
    public List<Integer> getItensAlterados() {
        if (getAntes() != null && getDepois() != null) {
            List<Integer> itensAlterados = new ArrayList<Integer>();
            
            // Percorre todos os itens "depois" e verifica se existe
            // correspondencia em "antes"
            for (int i = 0; i < getDepois().size(); i++) {
                
                // Caso exista o item retorna adiciona à lista
                if (!getAntes().contains(getDepois().get(i))) {
                    itensAlterados.add(i);
                }
            }
            
            return itensAlterados;
        } else {
            return new ArrayList<Integer>();
        }        
    }
}
