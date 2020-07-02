package br.com.bradesco.web.ricc.view.bean.parametrizacaomensagem.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.parametrizacaomensagem.ComponenteMensagemVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class ConsultarComponenteMensagemViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = 4201953050604850242L;

	private Boolean renderTabelaComponenteMensagem = Boolean.TRUE;
	private Boolean btnAlterar = Boolean.FALSE;
	private Boolean btnAutorizar = Boolean.FALSE;
	private Boolean btnExcluir = Boolean.FALSE;
	private Boolean btnDetalhar = Boolean.FALSE;
	private Boolean btnCopiar = Boolean.FALSE;
	private List<ComponenteMensagemVO> itemSelecionado = new ArrayList<ComponenteMensagemVO>();
	private List<ComponenteMensagemVO> listaComponenteMensagemVO = new ArrayList<ComponenteMensagemVO>();
	private List<SelectItem> comboCodigo;

	@Override
	public void inicializar() {
		comboCodigo = siteUtil.carregarComboCodigoMensagem();
	}

	public Boolean getRenderTabelaComponenteMensagem() {
		return renderTabelaComponenteMensagem;
	}

	public void setRenderTabelaComponenteMensagem(
			Boolean renderTabelaComponenteMensagem) {
		this.renderTabelaComponenteMensagem = renderTabelaComponenteMensagem;
	}

	public Boolean getBtnDetalhar() {
		return btnDetalhar;
	}

	public void setBtnDetalhar(Boolean btnDetalhar) {
		this.btnDetalhar = btnDetalhar;
	}

	public List<ComponenteMensagemVO> getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(List<ComponenteMensagemVO> itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public List<ComponenteMensagemVO> getListaComponenteMensagemVO() {
		return listaComponenteMensagemVO;
	}

	public void setListaComponenteMensagemVO(
			List<ComponenteMensagemVO> listaComponenteMensagemVO) {
		this.listaComponenteMensagemVO = listaComponenteMensagemVO;
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

	public List<SelectItem> getComboCodigo() {
		return comboCodigo;
	}

	public void setComboCodigo(List<SelectItem> comboCodigo) {
		this.comboCodigo = comboCodigo;
	}	
}