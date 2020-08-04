package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean;

import java.util.ArrayList;
import java.util.List;
/**
 * 
  * Nome: BolAgexVO.java
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
  * Registro  de Manutenção: 18/04/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
 */
public class BolAgexVO {
    
    /*Quantidade de ocorrências*/
    private Integer qtdeocorr = 0;
    private List<BolAgexListVO> lista = new ArrayList<BolAgexListVO>();

//	/**
//	 * CODIGO DO STATUS DA COTACAO
//	 */
//	private Integer csitbletocmbio;
//
//	/**
//	 * DESCRICAO DO STATUS
//	 */
//	private String dsitbletocmbio;

    
    /**
     * Construtor
     * 
     * @param
     */
    public BolAgexVO() {
        super();
    }

    /**
     * @return o valor do qtdeocorr
     */
    public Integer getQtdeocorr() {
        return qtdeocorr;
    }

    /**
     * @param qtdeocorr seta o novo valor para o campo qtdeocorr
     */
    public void setQtdeocorr(Integer qtdeocorr) {
        this.qtdeocorr = qtdeocorr;
    }

    /**
     * @return o valor do lista
     */
    public List<BolAgexListVO> getLista() {
        return lista;
    }

    /**
     * @param lista seta o novo valor para o campo lista
     */
    public void setLista(List<BolAgexListVO> lista) {
        this.lista = lista;
    }

}
