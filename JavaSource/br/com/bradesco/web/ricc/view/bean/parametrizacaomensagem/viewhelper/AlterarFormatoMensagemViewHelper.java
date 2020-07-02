package br.com.bradesco.web.ricc.view.bean.parametrizacaomensagem.viewhelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.bradesco.web.ricc.model.parametrizacaomensagem.CampoIntegranteVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class AlterarFormatoMensagemViewHelper extends AbstractViewHelper {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6728360388728831027L;

	private String nivelAutorizacao = "";
	private String interfaceSaaAtiva = "";
	private List<CampoIntegranteVO> listaCamposIntegrantesVO = new ArrayList<CampoIntegranteVO>();
	private List<CampoIntegranteVO> listaCamposVO = new ArrayList<CampoIntegranteVO>();
	private List<CampoIntegranteVO> campoIntegranteSelecionado = new ArrayList<CampoIntegranteVO>();
	private List<CampoIntegranteVO> campoSelecionado = new ArrayList<CampoIntegranteVO>();
	private Boolean btnRemoverCampoIntegrante = Boolean.FALSE;
	private Boolean btnAdicionarCampoIntegrante = Boolean.FALSE;
	private Date inicioVigencia = new GregorianCalendar(2018, Calendar.JUNE, 4)
			.getTime();

	@Override
	public void inicializar() {

	}

	public String getNivelAutorizacao() {
		return nivelAutorizacao;
	}

	public void setNivelAutorizacao(String nivelAutorizacao) {
		this.nivelAutorizacao = nivelAutorizacao;
	}

	public List<CampoIntegranteVO> getListaCamposIntegrantesVO() {
		return listaCamposIntegrantesVO;
	}

	public void setListaCamposIntegrantesVO(
			ArrayList<CampoIntegranteVO> listaCamposIntegrantesVO) {
		this.listaCamposIntegrantesVO = listaCamposIntegrantesVO;
	}

	public List<CampoIntegranteVO> getListaCamposVO() {
		return listaCamposVO;
	}

	public void setListaCamposVO(ArrayList<CampoIntegranteVO> listaCamposVO) {
		this.listaCamposVO = listaCamposVO;
	}

	public Boolean getBtnRemoverCampoIntegrante() {
		return btnRemoverCampoIntegrante;
	}

	public void setBtnRemoverCampoIntegrante(Boolean btnRemoverCampoIntegrante) {
		this.btnRemoverCampoIntegrante = btnRemoverCampoIntegrante;
	}

	public Boolean getBtnAdicionarCampoIntegrante() {
		return btnAdicionarCampoIntegrante;
	}

	public void setBtnAdicionarCampoIntegrante(
			Boolean btnAdicionarCampoIntegrante) {
		this.btnAdicionarCampoIntegrante = btnAdicionarCampoIntegrante;
	}

	public List<CampoIntegranteVO> getCampoIntegranteSelecionado() {
		return campoIntegranteSelecionado;
	}

	public void setCampoIntegranteSelecionado(
			List<CampoIntegranteVO> campoIntegranteSelecionado) {
		this.campoIntegranteSelecionado = campoIntegranteSelecionado;
	}

	public List<CampoIntegranteVO> getCampoSelecionado() {
		return campoSelecionado;
	}

	public void setCampoSelecionado(List<CampoIntegranteVO> campoSelecionado) {
		this.campoSelecionado = campoSelecionado;
	}

	public Date getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(Date inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public String getInterfaceSaaAtiva() {
		return interfaceSaaAtiva;
	}

	public void setInterfaceSaaAtiva(String interfaceSaaAtiva) {
		this.interfaceSaaAtiva = interfaceSaaAtiva;
	}
}