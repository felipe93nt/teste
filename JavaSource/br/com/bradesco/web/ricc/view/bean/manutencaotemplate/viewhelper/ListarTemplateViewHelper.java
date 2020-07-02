package br.com.bradesco.web.ricc.view.bean.manutencaotemplate.viewhelper;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.ricc.model.manutencaotemplate.TemplateVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class ListarTemplateViewHelper extends AbstractViewHelper{
	private static final long serialVersionUID = 4201953050604850242L;

	private Boolean renderTabelaTemplate = Boolean.TRUE;
	private Boolean btnAlterar = Boolean.FALSE;
	private Boolean btnAutorizar = Boolean.FALSE;
	private Boolean btnExcluir = Boolean.FALSE;
	private Boolean btnDetalhar = Boolean.FALSE;
	private Boolean btnCopiar = Boolean.FALSE;
	private List<TemplateVO> itemSelecionado = new ArrayList<TemplateVO>();
	private List<TemplateVO> listaTemplateVO = new ArrayList<TemplateVO>();

	@Override
	public void inicializar() {

	}

	public Boolean getRenderTabelaTemplate() {
		return renderTabelaTemplate;
	}

	public void setRenderTabelaTemplate(Boolean renderTabelaTemplate) {
		this.renderTabelaTemplate = renderTabelaTemplate;
	}

	public List<TemplateVO> getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(List<TemplateVO> itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public Boolean getBtnDetalhar() {
		return btnDetalhar;
	}

	public void setBtnDetalhar(Boolean btnDetalhar) {
		this.btnDetalhar = btnDetalhar;
	}

	public List<TemplateVO> getListaTemplateVO() {
		return listaTemplateVO;
	}

	public void setListaTemplateVO(List<TemplateVO> listaTemplateVO) {
		this.listaTemplateVO = listaTemplateVO;
	}

	public Boolean getBtnAlterar() {
		return btnAlterar;
	}

	public void setBtnAlterar(Boolean btnAlterar) {
		this.btnAlterar = btnAlterar;
	}

	public Boolean getBtnAutorizar() {
		return btnAutorizar;
	}

	public void setBtnAutorizar(Boolean btnAutorizar) {
		this.btnAutorizar = btnAutorizar;
	}

	public Boolean getBtnExcluir() {
		return btnExcluir;
	}

	public void setBtnExcluir(Boolean btnExcluir) {
		this.btnExcluir = btnExcluir;
	}

	public Boolean getBtnCopiar() {
		return btnCopiar;
	}

	public void setBtnCopiar(Boolean btnCopiar) {
		this.btnCopiar = btnCopiar;
	}

}
