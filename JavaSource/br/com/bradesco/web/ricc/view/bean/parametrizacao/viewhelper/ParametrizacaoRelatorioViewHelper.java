package br.com.bradesco.web.ricc.view.bean.parametrizacao.viewhelper;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.ricc.model.parametrizacao.ListaObrigatoriedadeParamVO;
import br.com.bradesco.web.ricc.model.parametrizacao.RelatorioParametrizacaoVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class ParametrizacaoRelatorioViewHelper extends AbstractViewHelper {
	/**
	 *
	 */
	private static final long serialVersionUID = -1116835804304222911L;

	private List<ListaObrigatoriedadeParamVO> listaObrigatoriedadeSelecionada = new ArrayList<ListaObrigatoriedadeParamVO>();

	private List<ListaObrigatoriedadeParamVO> listaObrigatoriedade = new ArrayList<ListaObrigatoriedadeParamVO>();

	private RelatorioParametrizacaoVO relatorioParametrizacaoVo = new RelatorioParametrizacaoVO();
	
	private Boolean RiscoTotalInput = false;
	@Override
	public void inicializar() {
		listaObrigatoriedade = carregarListaObrigatoriedade();
		listaObrigatoriedadeSelecionada = new ArrayList<ListaObrigatoriedadeParamVO>();
		relatorioParametrizacaoVo = new RelatorioParametrizacaoVO();

	}

	public List<ListaObrigatoriedadeParamVO> carregarListaObrigatoriedade() {

		listaObrigatoriedade = new ArrayList<ListaObrigatoriedadeParamVO>();

		ListaObrigatoriedadeParamVO obParam = new ListaObrigatoriedadeParamVO();
		obParam.setCodigo(1);
		obParam.setDescricao("Corporate");
		listaObrigatoriedade.add(obParam);

		ListaObrigatoriedadeParamVO obParam2 = new ListaObrigatoriedadeParamVO();
		obParam2.setCodigo(2);
		obParam2.setDescricao("Corporate One");
		listaObrigatoriedade.add(obParam2);

		ListaObrigatoriedadeParamVO obParam3 = new ListaObrigatoriedadeParamVO();
		obParam3.setCodigo(3);
		obParam3.setDescricao("Varejo");
		listaObrigatoriedade.add(obParam3);

		ListaObrigatoriedadeParamVO obParam4 = new ListaObrigatoriedadeParamVO();
		obParam4.setCodigo(4);
		obParam4.setDescricao("Large Corporate");
		listaObrigatoriedade.add(obParam4);

		return listaObrigatoriedade;
	}

	public List<ListaObrigatoriedadeParamVO> getListaObrigatoriedadeSelecionada() {
		return listaObrigatoriedadeSelecionada;
	}

	public void setListaObrigatoriedadeSelecionada(List<ListaObrigatoriedadeParamVO> listaObrigatoriedadeSelecionada) {
		this.listaObrigatoriedadeSelecionada = listaObrigatoriedadeSelecionada;
	}

	public List<ListaObrigatoriedadeParamVO> getListaObrigatoriedade() {
		return listaObrigatoriedade;
	}

	public void setListaObrigatoriedade(List<ListaObrigatoriedadeParamVO> listaObrigatoriedade) {
		this.listaObrigatoriedade = listaObrigatoriedade;
	}

	public RelatorioParametrizacaoVO getRelatorioParametrizacaoVo() {
		return relatorioParametrizacaoVo;
	}

	public void setRelatorioParametrizacaoVo(RelatorioParametrizacaoVO relatorioParametrizacaoVo) {
		this.relatorioParametrizacaoVo = relatorioParametrizacaoVo;
	}
	public Boolean getRiscoTotalInput() {
		return RiscoTotalInput;
	}

	public void setRiscoTotalInput(Boolean riscoTotalInput) {
		RiscoTotalInput = riscoTotalInput;
	}
}
