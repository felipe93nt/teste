package br.com.bradesco.web.ricc.view.bean.duplavalidacao.viewhelper;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.ricc.enums.SegmentoEnum;
import br.com.bradesco.web.ricc.model.duplavalidacao.DuplaValidacaoVO;
import br.com.bradesco.web.ricc.model.parametrizacao.ListaObrigatoriedadeParamVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class DuplaValidacaoViewHelper extends AbstractViewHelper {

	/**
	 * 
	 */
	private static final long serialVersionUID = -994922576088787060L;
	
	public DuplaValidacaoVO modelDe;
	
	public DuplaValidacaoVO modelPara;
	
	public String justificativa = "";
	
	private List<ListaObrigatoriedadeParamVO> listaObrigatoriedade;
	
	//flag para desabilitar os botoes Aprovar/Recusar
	public Boolean flagDesabBotao = Boolean.FALSE;
	
	//flag para desabilitar Justificativa
	public Boolean flagDesabJust = Boolean.FALSE;
	
	//flag para renderizar os campos DE
	public Boolean flagRenderCamposDe = Boolean.FALSE;
	
	//flag para renderizar os campos PARA
	public Boolean flagRenderCamposPara = Boolean.FALSE;
		

	@Override
	public void inicializar() {
		setModelDe(new DuplaValidacaoVO());
		setModelPara(new DuplaValidacaoVO());
		setListaObrigatoriedade(new ArrayList<ListaObrigatoriedadeParamVO>());
		carregarListaObrigatoriedade();
		setFlagDesabBotao(Boolean.FALSE);
		setFlagRenderCamposDe(Boolean.FALSE);
		setFlagRenderCamposPara(Boolean.FALSE);
	}

	private void carregarListaObrigatoriedade() {
		ListaObrigatoriedadeParamVO item = null;
		for (SegmentoEnum _segmentoEnum : SegmentoEnum.values()) {
			item = new ListaObrigatoriedadeParamVO();
			item.setCodigo(_segmentoEnum.getCodigo());
			item.setDescricao(_segmentoEnum.getDescricao());
			listaObrigatoriedade.add(item);
		}
	}

	public DuplaValidacaoVO getModelDe() {
		return modelDe;
	}

	public void setModelDe(DuplaValidacaoVO modelDe) {
		this.modelDe = modelDe;
	}
	
	public DuplaValidacaoVO getModelPara() {
		return modelPara;
	}

	public void setModelPara(DuplaValidacaoVO modelPara) {
		this.modelPara = modelPara;
	}
	
	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public List<ListaObrigatoriedadeParamVO> getListaObrigatoriedade() {
		return listaObrigatoriedade;
	}

	public void setListaObrigatoriedade(
			List<ListaObrigatoriedadeParamVO> listaObrigatoriedade) {
		this.listaObrigatoriedade = listaObrigatoriedade;
	}

	public Boolean getFlagDesabBotao() {
		return flagDesabBotao;
	}

	public void setFlagDesabBotao(Boolean flagDesabBotao) {
		this.flagDesabBotao = flagDesabBotao;
	}
	
	public Boolean getFlagDesabJust() {
		return flagDesabJust;
	}

	public void setFlagDesabJust(Boolean flagDesabJust) {
		this.flagDesabJust = flagDesabJust;
	}

	public Boolean getFlagRenderCamposDe() {
		return flagRenderCamposDe;
	}

	public void setFlagRenderCamposDe(Boolean flagRenderCamposDe) {
		this.flagRenderCamposDe = flagRenderCamposDe;
	}

	public Boolean getFlagRenderCamposPara() {
		return flagRenderCamposPara;
	}

	public void setFlagRenderCamposPara(Boolean flagRenderCamposPara) {
		this.flagRenderCamposPara = flagRenderCamposPara;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
