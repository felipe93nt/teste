package br.com.bradesco.web.ricc.view.bean.treinamento.ajuda.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.bradesco.web.ricc.model.treinamento.ListaCheckboxVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class AjudaTreinamentoViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = -1116835804304222911L;

	private List<ListaCheckboxVO> listaCheckboxSelecionada = new ArrayList<ListaCheckboxVO>();

	private List<ListaCheckboxVO> listaCheckbox = new ArrayList<ListaCheckboxVO>();
	
	private String exemploInputText;

	private String exemploOutputText;
	
	private String exemploComboBox;
	
	@Override
	public void inicializar() {
		listaCheckbox = carregarListaCheckbox();
		listaCheckboxSelecionada = new ArrayList<ListaCheckboxVO>();
		capturarUsuario();
	}
	
	public void capturarUsuario(){
		this.exemploOutputText = "Exemplo de informação em OutputText!";
	}

	public List<ListaCheckboxVO> carregarListaCheckbox() {

		listaCheckbox = new ArrayList<ListaCheckboxVO>();

		ListaCheckboxVO obParam = new ListaCheckboxVO();
		obParam.setCodigo(1);
		obParam.setDescricao("Opção 1");
		listaCheckbox.add(obParam);

		ListaCheckboxVO obParam2 = new ListaCheckboxVO();
		obParam2.setCodigo(1);
		obParam2.setDescricao("Opção 2");
		listaCheckbox.add(obParam2);

		ListaCheckboxVO obParam3 = new ListaCheckboxVO();
		obParam3.setCodigo(1);
		obParam3.setDescricao("Opção 3");
		listaCheckbox.add(obParam3);

		ListaCheckboxVO obParam4 = new ListaCheckboxVO();
		obParam4.setCodigo(1);
		obParam4.setDescricao("Opção 4");
		listaCheckbox.add(obParam4);

		return listaCheckbox;
	}
	
	public List<SelectItem> getComboTreinamento() {
		return siteUtil.carregarExemploComboTreinamento();
		
	}

	public List<ListaCheckboxVO> getListaCheckboxSelecionada() {
		return listaCheckboxSelecionada;
	}

	public void setListaCheckboxSelecionada(
			List<ListaCheckboxVO> listaCheckboxSelecionada) {
		this.listaCheckboxSelecionada = listaCheckboxSelecionada;
	}

	public List<ListaCheckboxVO> getListaCheckbox() {
		return listaCheckbox;
	}

	public void setListaCheckbox(List<ListaCheckboxVO> listaCheckbox) {
		this.listaCheckbox = listaCheckbox;
	}

	public String getExemploInputText() {
		return exemploInputText;
	}

	public void setExemploInputText(String exemploInputText) {
		this.exemploInputText = exemploInputText;
	}

	public String getExemploOutputText() {
		return exemploOutputText;
	}

	public void setExemploOutputText(String exemploOutputText) {
		this.exemploOutputText = exemploOutputText;
	}

	public String getExemploComboBox() {
		return exemploComboBox;
	}

	public void setExemploComboBox(String exemploComboBox) {
		this.exemploComboBox = exemploComboBox;
	}

}
