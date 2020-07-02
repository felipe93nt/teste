package br.com.bradesco.web.ricc.view.bean.manutencaomensagem.viewhelper;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.ricc.model.manutencao.MensagemVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class ListaMensagemViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = 4201953050604850242L;

	private Boolean renderTabelaMensagem = Boolean.TRUE;
	private Boolean btnAlterar = Boolean.FALSE;
	private Boolean btnAutorizar = Boolean.FALSE;
	private Boolean btnExcluir = Boolean.FALSE;
	private Boolean btnDetalhar = Boolean.FALSE;
	private Boolean btnCopiar = Boolean.FALSE;
	private List<MensagemVO> itemSelecionado = new ArrayList<MensagemVO>();
	private List<MensagemVO> listaMensagemVO = new ArrayList<MensagemVO>();

	@Override
	public void inicializar() {

	}

	public Boolean getRenderTabelaMensagem() {
		return renderTabelaMensagem;
	}

	public void setRenderTabelaMensagem(Boolean renderTabelaMensagem) {
		this.renderTabelaMensagem = renderTabelaMensagem;
	}

	public List<MensagemVO> getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(List<MensagemVO> itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public Boolean getBtnDetalhar() {
		return btnDetalhar;
	}

	public void setBtnDetalhar(Boolean btnDetalhar) {
		this.btnDetalhar = btnDetalhar;
	}

	public List<MensagemVO> getListaMensagemVO() {
		return listaMensagemVO;
	}

	public void setListaMensagemVO(List<MensagemVO> listaMensagemVO) {
		this.listaMensagemVO = listaMensagemVO;
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