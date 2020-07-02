package br.com.bradesco.web.ricc.view.bean.cadastro.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.cadastro.CadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.PesquisaCadastramentoVO;
import br.com.bradesco.web.ricc.model.cadastro.TipoQuestionarioVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

/**
 * @name CadastramentoRicViewHelper
 * @author Foursys
 * @see Equipe3ViewHelper.java
 * @version 1.0
 * @since 04/09/2018
 */
public class CadastramentoRicViewHelper extends AbstractViewHelper {

	/**
	 * Atributo modelPesquisa 
	 * Tipo PesquisaCadastramentoVO
	 */
	private PesquisaCadastramentoVO modelPesquisa  = null;
	/**
	 * Atributo itemSelecionado 
	 * Tipo List<CadastramentoVO>
	 */
	private List<CadastramentoVO> itemSelecionado = new ArrayList<CadastramentoVO>();
	/**
	 * Atributo listaCadastramento 
	 * Tipo List<CadastramentoVO>
	 */
	private List<CadastramentoVO> listaCadastramento = null;
	/**
	 * Atributo listaSegmento 
	 * Tipo List<TipoQuestionarioVO>
	 */
	private List<TipoQuestionarioVO> listaSegmento = null;
	/**
	 * Atributo segmentoSelecionado 
	 * Tipo TipoQuestionarioVO
	 */
	private TipoQuestionarioVO segmentoSelecionado = null;
	/**
	 * Atributo listaSetor 
	 * Tipo List<TipoQuestionarioVO>
	 */
	private List<TipoQuestionarioVO> listaSetor = null;
	/**
	 * Atributo listaSetorSelecionado 
	 * Tipo List<TipoQuestionarioVO>
	 */
	private List<TipoQuestionarioVO> listaSetorSelecionado = null;
	/**
	 * Atributo btnAlterar 
	 * Tipo Boolean
	 */
	private Boolean btnAlterar = Boolean.FALSE;
	/**
	 * Atributo btnExcluir
	 * Tipo Boolean
	 */
	private Boolean btnExcluir = Boolean.FALSE;
	/**
	 * Atributo btnCopiar 
	 * Tipo Boolean
	 */
	private Boolean btnCopiar = Boolean.FALSE;
	/**
	 * Atributo btnConsultar 
	 * Tipo Boolean
	 */
	private Boolean btnConsultar = Boolean.FALSE;
	
	private Boolean renderModal = Boolean.FALSE;

	private Boolean renderModalExcluir = Boolean.FALSE;

	private static final long serialVersionUID = -1817303582028361985L;

	@Override
	public void inicializar() {
		modelPesquisa = new PesquisaCadastramentoVO();
		listaCadastramento = new ArrayList<CadastramentoVO>();
		segmentoSelecionado = new TipoQuestionarioVO();
		listaSetorSelecionado = new ArrayList<TipoQuestionarioVO>();
		listaSegmento = siteUtil.carregarListaSegmento();
		listaSetor = siteUtil.carregarListaSetor();
		renderModal = Boolean.FALSE;
		renderModalExcluir = Boolean.FALSE;
	}
	

	public List<SelectItem> getComboStatus() {
		return siteUtil.carregarComboStatusTodos();
	}
	
	public PesquisaCadastramentoVO getModelPesquisa() {
		return modelPesquisa;
	}

	public void setModelPesquisa(PesquisaCadastramentoVO modelPesquisa) {
		this.modelPesquisa = modelPesquisa;
	}

	public List<CadastramentoVO> getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(List<CadastramentoVO> itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public List<CadastramentoVO> getListaCadastramento() {
		return listaCadastramento;
	}

	public void setListaCadastramento(List<CadastramentoVO> listaCadastramento) {
		this.listaCadastramento = listaCadastramento;
	}

	public List<TipoQuestionarioVO> getListaSegmento() {
		return listaSegmento;
	}

	public void setListaSegmento(List<TipoQuestionarioVO> listaSegmento) {
		this.listaSegmento = listaSegmento;
	}

	public TipoQuestionarioVO getSegmentoSelecionado() {
		return segmentoSelecionado;
	}

	public void setSegmentoSelecionado(TipoQuestionarioVO segmentoSelecionado) {
		this.segmentoSelecionado = segmentoSelecionado;
	}

	public List<TipoQuestionarioVO> getListaSetor() {
		return listaSetor;
	}

	public void setListaSetor(List<TipoQuestionarioVO> listaSetor) {
		this.listaSetor = listaSetor;
	}

	public List<TipoQuestionarioVO> getListaSetorSelecionado() {
		return listaSetorSelecionado;
	}

	public void setListaSetorSelecionado(
			List<TipoQuestionarioVO> listaSetorSelecionado) {
		this.listaSetorSelecionado = listaSetorSelecionado;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
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


	public Boolean getBtnExcluir() {
		return btnExcluir;
	}


	public void setBtnExcluir(Boolean btnExcluir) {
		this.btnExcluir = btnExcluir;
	}


	/**
	 * @return the btnCopiar
	 */
	public Boolean getBtnCopiar() {
		return btnCopiar;
	}


	/**
	 * @param btnCopiar the btnCopiar to set
	 */
	public void setBtnCopiar(Boolean btnCopiar) {
		this.btnCopiar = btnCopiar;
	}


	/**
	 * @return the btnConsultar
	 */
	public Boolean getBtnConsultar() {
		return btnConsultar;
	}


	/**
	 * @param btnConsultar the btnConsultar to set
	 */
	public void setBtnConsultar(Boolean btnConsultar) {
		this.btnConsultar = btnConsultar;
	}


	public Boolean getRenderModal() {
		return renderModal;
	}


	public void setRenderModal(Boolean renderModal) {
		this.renderModal = renderModal;
	}


	public Boolean getRenderModalExcluir() {
		return renderModalExcluir;
	}


	public void setRenderModalExcluir(Boolean renderModalExcluir) {
		this.renderModalExcluir = renderModalExcluir;
	}

}
