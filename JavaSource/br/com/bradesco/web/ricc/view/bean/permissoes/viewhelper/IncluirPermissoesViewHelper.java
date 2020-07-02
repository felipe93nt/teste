package br.com.bradesco.web.ricc.view.bean.permissoes.viewhelper;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.ricc.model.permissoes.InstrucoesVO;
import br.com.bradesco.web.ricc.model.permissoes.MtVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class IncluirPermissoesViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = 6728360388728831027L;
	
	private Boolean btnRemoverInstrucoesAutorizadas = Boolean.FALSE;
	private List<InstrucoesVO> listaInstrucaoSelecionadaVO = new ArrayList<InstrucoesVO>();
	private List<InstrucoesVO> listaInstrucoesVO = new ArrayList<InstrucoesVO>();
	
	private Boolean btnRemoverMensagensAutorizadas = Boolean.FALSE;
	private List<MtVO> listaMtSelecionadaVO = new ArrayList<MtVO>();
	private List<MtVO> listaMtVO = new ArrayList<MtVO>();
		
	public Boolean getBtnRemoverInstrucoesAutorizadas() {
		return btnRemoverInstrucoesAutorizadas;
	}

	public void setBtnRemoverInstrucoesAutorizadas(
			Boolean btnRemoverInstrucoesAutorizadas) {
		this.btnRemoverInstrucoesAutorizadas = btnRemoverInstrucoesAutorizadas;
	}


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


	public Boolean getBtnRemoverMensagensAutorizadas() {
		return btnRemoverMensagensAutorizadas;
	}


	public void setBtnRemoverMensagensAutorizadas(
			Boolean btnRemoverMensagensAutorizadas) {
		this.btnRemoverMensagensAutorizadas = btnRemoverMensagensAutorizadas;
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
