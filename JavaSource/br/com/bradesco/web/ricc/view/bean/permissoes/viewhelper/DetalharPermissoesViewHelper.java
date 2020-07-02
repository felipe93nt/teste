package br.com.bradesco.web.ricc.view.bean.permissoes.viewhelper;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.ricc.model.permissoes.InstrucoesVO;
import br.com.bradesco.web.ricc.model.permissoes.MtVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class DetalharPermissoesViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = 6728360388728831027L;
	
	private List<InstrucoesVO> listaInstrucaoSelecionadaVO = new ArrayList<InstrucoesVO>();
	private List<InstrucoesVO> listaInstrucoesVO = new ArrayList<InstrucoesVO>();
	
	private List<MtVO> listaMtSelecionadaVO = new ArrayList<MtVO>();
	private List<MtVO> listaMtVO = new ArrayList<MtVO>();
		

	public List<InstrucoesVO> getListaInstrucaoSelecionadaVO() {
		return listaInstrucaoSelecionadaVO;
	}


	public void setListaInstrucaoSelecionadaVO(
			List<InstrucoesVO> listaInstrucaoSelecionadaVO) {
		this.listaInstrucaoSelecionadaVO = listaInstrucaoSelecionadaVO;
	}


	public List<InstrucoesVO> getListaInstrucoesVO() {
		return listaInstrucoesVO;
	}


	public void setListaInstrucoesVO(List<InstrucoesVO> listaInstrucoesVO) {
		this.listaInstrucoesVO = listaInstrucoesVO;
	}


	public List<MtVO> getListaMtSelecionadaVO() {
		return listaMtSelecionadaVO;
	}


	public void setListaMtSelecionadaVO(List<MtVO> listaMtSelecionadaVO) {
		this.listaMtSelecionadaVO = listaMtSelecionadaVO;
	}


	public List<MtVO> getListaMtVO() {
		return listaMtVO;
	}

	public void setListaMtVO(List<MtVO> listaMtVO) {
		this.listaMtVO = listaMtVO;
	}


	@Override
	public void inicializar() {

	}
}