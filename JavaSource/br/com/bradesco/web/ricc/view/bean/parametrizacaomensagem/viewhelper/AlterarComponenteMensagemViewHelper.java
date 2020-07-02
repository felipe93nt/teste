package br.com.bradesco.web.ricc.view.bean.parametrizacaomensagem.viewhelper;

import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class AlterarComponenteMensagemViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = 6728360388728831027L;

	private List<SelectItem> comboTipoComponente;
	private List<SelectItem> comboGrupoComponente;
	private List<SelectItem> comboBlocoCampo;
	private List<SelectItem> comboTipoDado;
	private List<SelectItem> comboFormatoCampo;

	@Override
	public void inicializar() {
		comboTipoComponente = siteUtil.carregarComboTipoComponente();
		comboGrupoComponente = siteUtil.carregarComboGrupoComponente();
		comboBlocoCampo = siteUtil.carregarComboBlocoCampo();
		comboTipoDado = siteUtil.carregarComboTipoDados();
		comboFormatoCampo = siteUtil.carregarComboFormatoCampo();

	}

	public List<SelectItem> getComboTipoComponente() {
		return comboTipoComponente;
	}

	public void setComboTipoComponente(List<SelectItem> comboTipoComponente) {
		this.comboTipoComponente = comboTipoComponente;
	}

	public List<SelectItem> getComboGrupoComponente() {
		return comboGrupoComponente;
	}

	public void setComboGrupoComponente(List<SelectItem> comboGrupoComponente) {
		this.comboGrupoComponente = comboGrupoComponente;
	}

	public List<SelectItem> getComboBlocoCampo() {
		return comboBlocoCampo;
	}

	public void setComboBlocoCampo(List<SelectItem> comboBlocoCampo) {
		this.comboBlocoCampo = comboBlocoCampo;
	}

	public List<SelectItem> getComboTipoDado() {
		return comboTipoDado;
	}

	public void setComboTipoDado(List<SelectItem> comboTipoDado) {
		this.comboTipoDado = comboTipoDado;
	}

	public List<SelectItem> getComboFormatoCampo() {
		return comboFormatoCampo;
	}

	public void setComboFormatoCampo(List<SelectItem> comboFormatoCampo) {
		this.comboFormatoCampo = comboFormatoCampo;
	}

}