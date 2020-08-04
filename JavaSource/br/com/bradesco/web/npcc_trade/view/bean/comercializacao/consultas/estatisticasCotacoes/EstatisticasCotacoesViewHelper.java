package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.consultas.estatisticasCotacoes;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.components.CalendarioPeriodo;


public class EstatisticasCotacoesViewHelper {
	
	private Integer codTipoConsultaSelecionads;
	private Integer anoBase;

    /**
     * PERIODO DA COTACAO
     */
    private CalendarioPeriodo periodoCotacao = new CalendarioPeriodo();
	
	/**
     * Nome: ArrayList
     * 
     * Propósito: Monta a lista de Radio Button dos tipos de consulta
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     */
    public List<SelectItem> getTiposConsulta() {
        List<SelectItem> tipo = new ArrayList<SelectItem>();
        tipo.add(new SelectItem(Numeros.NUM1, "Por Produto"));
        tipo.add(new SelectItem(Numeros.NUM2, "Por Operador"));
        tipo.add(new SelectItem(Numeros.NUM3, "Fechadas e Perdidas em USD"));
        return tipo;
    }

	public Integer getCodTipoConsultaSelecionads() {
		return codTipoConsultaSelecionads;
	}

	public void setCodTipoConsultaSelecionads(Integer codTipoConsultaSelecionads) {
		this.codTipoConsultaSelecionads = codTipoConsultaSelecionads;
	}

	public Integer getAnoBase() {
		return anoBase;
	}
	public void setAnoBase(Integer anoBase) {
		this.anoBase = anoBase;
	}

	public CalendarioPeriodo getPeriodoCotacao() {
		return periodoCotacao;
	}
	public void setPeriodoCotacao(CalendarioPeriodo periodoCotacao) {
		this.periodoCotacao = periodoCotacao;
	}
    
}

