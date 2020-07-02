package br.com.bradesco.web.ricc.view.bean.manutencaotemplate.viewhelper;

import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class ConsultarTemplateViewHelper extends AbstractViewHelper{
	private static final long serialVersionUID = 4201953050604850242L;
	
	private String texto;
	private List<SelectItem> comboStatos;
	private List<SelectItem> comboCodigo;
	private List<SelectItem> comboMoeda;
	private List<SelectItem> comboTipoTransmissao;

	@Override
	public void inicializar() {
		comboStatos = siteUtil.carregarComboStatus();
		comboCodigo = siteUtil.carregarComboCodigoMensagem();
		comboMoeda = siteUtil.carregarComboMoeda();
		comboTipoTransmissao = siteUtil.carregarComboTipoTransmissao();
	}
	
	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public List<SelectItem> getComboStatos() {
		return comboStatos;
	}

	public void setComboStatos(List<SelectItem> comboStatos) {
		this.comboStatos = comboStatos;
	}

	public List<SelectItem> getComboCodigo() {
		return comboCodigo;
	}

	public void setComboCodigo(List<SelectItem> comboCodigo) {
		this.comboCodigo = comboCodigo;
	}

	public List<SelectItem> getComboMoeda() {
		return comboMoeda;
	}

	public void setComboMoeda(List<SelectItem> comboMoeda) {
		this.comboMoeda = comboMoeda;
	}

	public List<SelectItem> getComboTipoTransmissao() {
		return comboTipoTransmissao;
	}

	public void setComboTipoTransmissao(List<SelectItem> comboTipoTransmissao) {
		this.comboTipoTransmissao = comboTipoTransmissao;
	}	


}
