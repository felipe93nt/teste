package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.consultas.operacoesPend;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.aq.view.util.Numeros;
import br.com.bradesco.web.npcc_trade.utils.components.CalendarioPeriodo;

public class OperacoesPendViewHelper {

	private String dprevtdsembi;
	private String dprevtdsembf;
	private Integer cprodtservc;
	private Double vprevtdsembi;
	private Double vprevtdsembf;
	private Integer csitbletocmbio;
	private String modalId;
	private Boolean renderModal = Boolean.FALSE;
	private List<SelectItem> comboSituacao = new ArrayList<SelectItem>();
    private List<SelectItem> comboProduto = new ArrayList<SelectItem>();
    private CalendarioPeriodo periodoCotacao = new CalendarioPeriodo();


	public String getDprevtdsembi() {
		return dprevtdsembi;
	}

	public void setDprevtdsembi(String dprevtdsembi) {
		this.dprevtdsembi = dprevtdsembi;
	}

	public String getDprevtdsembf() {
		return dprevtdsembf;
	}

	public void setDprevtdsembf(String dprevtdsembf) {
		this.dprevtdsembf = dprevtdsembf;
	}

	public Integer getCprodtservc() {
		return cprodtservc;
	}

	public void setCprodtservc(Integer cprodtservc) {
		this.cprodtservc = cprodtservc;
	}

	public Double getVprevtdsembi() {
		return vprevtdsembi;
	}

	public void setVprevtdsembi(Double vprevtdsembi) {
		this.vprevtdsembi = vprevtdsembi;
	}

	public Double getVprevtdsembf() {
		return vprevtdsembf;
	}

	public void setVprevtdsembf(Double vprevtdsembf) {
		this.vprevtdsembf = vprevtdsembf;
	}

	public Integer getCsitbletocmbio() {
		return csitbletocmbio;
	}

	public void setCsitbletocmbio(Integer csitbletocmbio) {
		this.csitbletocmbio = csitbletocmbio;
	}
	
    public List<SelectItem> getComboSituacao() {
		return comboSituacao;
	}

	public void setComboSituacao(List<SelectItem> comboSituacao) {
		this.comboSituacao = comboSituacao;
	}

	public List<SelectItem> getComboProduto() {
		return comboProduto;
	}

	public void setComboProduto(List<SelectItem> comboProduto) {
		this.comboProduto = comboProduto;
	}
	
	public CalendarioPeriodo getPeriodoCotacao() {
		return periodoCotacao;
	}

	public void setPeriodoCotacao(CalendarioPeriodo periodoCotacao) {
		this.periodoCotacao = periodoCotacao;
	}
	
	public String getModalId() {
		return modalId;
	}

	public void setModalId(String modalId) {
		this.modalId = modalId;
	}
	
	public Boolean getRenderModal() {
		return renderModal;
	}

	public void setRenderModal(Boolean renderModal) {
		this.renderModal = renderModal;
	}	

}

