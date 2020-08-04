package br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.divisaoInternacional.bean;

import java.util.ArrayList;
import java.util.List;

public class ConsultaDivInternacVO {
    
    private List<ListaCotacDivInternacVO> listaCotacoes = new ArrayList<ListaCotacDivInternacVO>();
    
    private List<ListaCotacDivInternacTotaisVO> listaTotais = new ArrayList<ListaCotacDivInternacTotaisVO>();

    /**
     * @return o valor do listaCotacoes
     */
    public List<ListaCotacDivInternacVO> getListaCotacoes() {
        return listaCotacoes;
    }

    /**
     * @param listaCotacoes seta o novo valor para o campo listaCotacoes
     */
    public void setListaCotacoes(List<ListaCotacDivInternacVO> listaCotacoes) {
        this.listaCotacoes = listaCotacoes;
    }

    /**
     * @return o valor do listaTotais
     */
    public List<ListaCotacDivInternacTotaisVO> getListaTotais() {
        return listaTotais;
    }

    /**
     * @param listaTotais seta o novo valor para o campo listaTotais
     */
    public void setListaTotais(List<ListaCotacDivInternacTotaisVO> listaTotais) {
        this.listaTotais = listaTotais;
    }
    
}
