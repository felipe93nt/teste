package br.com.bradesco.web.ricc.view.bean.parametrizacaoalcada.viewhelper;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.ricc.model.parametrizacaoalcada.AlcadaVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class ConsultarParametrizacaoAlcadaViewHelper extends AbstractViewHelper {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1657673372699105232L;
	
	private Boolean renderTabelaAlcada = Boolean.TRUE;
	private Boolean btnAlterar = Boolean.FALSE;
	private Boolean btnExcluir = Boolean.FALSE;

	private List<AlcadaVO> itemSelecionado = new ArrayList<AlcadaVO>();
	private List<AlcadaVO> ListaAlcadaVO = new ArrayList<AlcadaVO>();


	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @return the renderTabelaMensagem
	 */
	public Boolean getRenderTabelaAlcada() {
		return renderTabelaAlcada;
	}

	/**
	 * @param renderTabelaAlcada the renderTabelaMensagem to set
	 */
	public void setRenderTabelaAlcada(Boolean renderTabelaAlcada) {
		this.renderTabelaAlcada = renderTabelaAlcada;
	}

	/**
	 * @return the btnAlterar
	 */
	public Boolean getBtnAlterar() {
		return btnAlterar;
	}

	/**
	 * @param btnAlterar the btnAlterar to set
	 */
	public void setBtnAlterar(Boolean btnAlterar) {
		this.btnAlterar = btnAlterar;
	}

	/**
	 * @return the btnExcluir
	 */
	public Boolean getBtnExcluir() {
		return btnExcluir;
	}

	/**
	 * @param btnExcluir the btnExcluir to set
	 */
	public void setBtnExcluir(Boolean btnExcluir) {
		this.btnExcluir = btnExcluir;
	}

	/**
	 * @return the itemSelecionado
	 */
	public List<AlcadaVO> getItemSelecionado() {
		return itemSelecionado;
	}

	/**
	 * @param itemSelecionado the itemSelecionado to set
	 */
	public void setItemSelecionado(List<AlcadaVO> itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	/**
	 * @return the listaAlcadaVO
	 */
	public List<AlcadaVO> getListaAlcadaVO() {
		return ListaAlcadaVO;
	}

	/**
	 * @param listaAlcadaVO the listaAlcadaVO to set
	 */
	public void setListaAlcadaVO(List<AlcadaVO> listaAlcadaVO) {
		ListaAlcadaVO = listaAlcadaVO;
	}
}
