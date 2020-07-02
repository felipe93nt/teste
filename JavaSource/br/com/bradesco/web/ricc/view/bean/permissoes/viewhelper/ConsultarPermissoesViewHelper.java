package br.com.bradesco.web.ricc.view.bean.permissoes.viewhelper;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.ricc.model.permissoes.PermissoesVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class ConsultarPermissoesViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = 4201953050604850242L;

	private String matriculaFunc = "";
	private String codigoBic = "";
	private Boolean btnAlterar = Boolean.FALSE;
	private Boolean btnExcluir = Boolean.FALSE;
	private Boolean btnDetalhar = Boolean.FALSE;
	private List<PermissoesVO> itemSelecionado = new ArrayList<PermissoesVO>();
	private List<PermissoesVO> listaPermissoesVO = new ArrayList<PermissoesVO>();

	public String getMatriculaFunc() {
		return matriculaFunc;
	}

	public void setMatriculaFunc(String matriculaFunc) {
		this.matriculaFunc = matriculaFunc;
	}

	public String getCodigoBic() {
		return codigoBic;
	}

	public void setCodigoBic(String codigoBic) {
		this.codigoBic = codigoBic;
	}

	public Boolean getBtnAlterar() {
		return btnAlterar;
	}

	public void setBtnAlterar(Boolean btnAlterar) {
		this.btnAlterar = btnAlterar;
	}

	public Boolean getBtnExcluir() {
		return btnExcluir;
	}

	public void setBtnExcluir(Boolean btnExcluir) {
		this.btnExcluir = btnExcluir;
	}

	public Boolean getBtnDetalhar() {
		return btnDetalhar;
	}

	public void setBtnDetalhar(Boolean btnDetalhar) {
		this.btnDetalhar = btnDetalhar;
	}

	public List<PermissoesVO> getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(List<PermissoesVO> itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public List<PermissoesVO> getListaPermissoesVO() {
		return listaPermissoesVO;
	}

	public void setListaPermissoesVO(List<PermissoesVO> listaPermissoesVO) {
		this.listaPermissoesVO = listaPermissoesVO;
	}

	@Override
	public void inicializar() {
	}

}
