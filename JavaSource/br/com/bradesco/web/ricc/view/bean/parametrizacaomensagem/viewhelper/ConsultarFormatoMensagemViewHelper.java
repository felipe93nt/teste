package br.com.bradesco.web.ricc.view.bean.parametrizacaomensagem.viewhelper;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.ricc.model.parametrizacaomensagem.FormatoMensagemVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class ConsultarFormatoMensagemViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = 6728360388728831027L;

	private Boolean btnDetalhar = Boolean.FALSE;
	private List<FormatoMensagemVO> itemSelecionado = new ArrayList<FormatoMensagemVO>();
	private List<FormatoMensagemVO> listaFormatosVO = new ArrayList<FormatoMensagemVO>();

	public List<FormatoMensagemVO> getListaFormatosVO() {
		return listaFormatosVO;
	}

	public void setListaFormatosVO(List<FormatoMensagemVO> listaFormatosVO) {
		this.listaFormatosVO = listaFormatosVO;
	}

	public List<FormatoMensagemVO> getListaFormatos() {
		return listaFormatosVO;
	}

	public void setListaFormatos(List<FormatoMensagemVO> listaFormatosVO) {
		this.listaFormatosVO = listaFormatosVO;
	}

	public Boolean getBtnDetalhar() {
		return btnDetalhar;
	}

	public void setBtnDetalhar(Boolean btnDetalhar) {
		this.btnDetalhar = btnDetalhar;
	}

	public List<FormatoMensagemVO> getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(List<FormatoMensagemVO> itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	@Override
	public void inicializar() {

	}

}