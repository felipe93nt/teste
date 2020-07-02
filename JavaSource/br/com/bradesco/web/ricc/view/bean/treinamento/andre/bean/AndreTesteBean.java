package br.com.bradesco.web.ricc.view.bean.treinamento.andre.bean;

import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.ricc.model.treinamento.ClienteIsaacVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.andre.viewhelper.AndreTesteViewHelper;

@SessionScoped
@Named(value = "andreTesteBean")
public class AndreTesteBean extends AbstractBean<AndreTesteViewHelper> {

	private static final long serialVersionUID = -7071158837919599207L;

	ArrayList<ClienteIsaacVO> listaClientes = new ArrayList<ClienteIsaacVO>();

	ClienteIsaacVO cliente;
	ClienteIsaacVO clienteSelecionado;

	private String mensagem = "";
	private String paginaAnterior = "voltar";
	private boolean ligaTabela = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		this.viewHelper = new AndreTesteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TELA_ANDRE_TESTE_CADASTRO;

	}

	public String iniciarPaginaConsulta() {
		this.viewHelper = new AndreTesteViewHelper();
		this.viewHelper.inicializar();

		return RiccConstants.TELA_ANDRE_TESTE_CONSULTA;

	}

	public ArrayList<ClienteIsaacVO> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<ClienteIsaacVO> listaClientes) {
		this.listaClientes = listaClientes;
	}

	// public String consultar() {
	//
	// ClienteIsaacVO itemSelecionado = getViewHelper().getListaClientes()
	// .get(0);
	// String retorno = "";
	//
	// // if (siteUtil.isNotEmptyOrNull(itemSelecionado)) {
	//
	// clienteSelecionado = new ClienteIsaacVO();
	// clienteSelecionado.setNomeCompleto(itemSelecionado.getNomeCompleto());
	// clienteSelecionado.setCpf(itemSelecionado.getCpf());
	// clienteSelecionado.setRg(itemSelecionado.getRg());
	// clienteSelecionado.setDataNascimento(itemSelecionado.getDataNascimento());
	// clienteSelecionado.setSexo(itemSelecionado.getSexo());
	// clienteSelecionado.setLogradouro(itemSelecionado.getLogradouro());
	// clienteSelecionado.setNumeroLogradouro(itemSelecionado.getNumeroLogradouro());
	// clienteSelecionado.setComplemento(itemSelecionado.getComplemento());
	// clienteSelecionado.setBairro(itemSelecionado.getBairro());
	// clienteSelecionado.setCidade(itemSelecionado.getCidade());
	// clienteSelecionado.setEstado(itemSelecionado.getEstado());
	// clienteSelecionado.setCep(itemSelecionado.getCep());
	// clienteSelecionado.setTelefone(itemSelecionado.getTelefone());
	// clienteSelecionado.setCelular(itemSelecionado.getCelular());
	// clienteSelecionado.setEmail(itemSelecionado.getEmail());
	//
	// // }
	//
	// return retorno;
	// }

	public String salvar() {
		if (validarCampos()) {
			setLigaTabela(true);

			try {

				// validou os dados
				cliente = new ClienteIsaacVO();

				cliente.setNomeCompleto(viewHelper.getNomeCompleto());
				cliente.setCpf(viewHelper.getCpf());
				cliente.setRg(viewHelper.getRg());
				cliente.setDataNascimento(viewHelper.getDataFormatada()
						.toString());
				cliente.setSexo(viewHelper.getSexo().toString());
				cliente.setLogradouro(viewHelper.getLogradouro());
				cliente.setNumeroLogradouro(viewHelper.getNumeroLogradouro());
				cliente.setComplemento(viewHelper.getComplemento());
				cliente.setBairro(viewHelper.getBairro());
				cliente.setCidade(viewHelper.getCidade().toString());
				cliente.setEstado(viewHelper.getEstado().toString());
				cliente.setCep(viewHelper.getCep());
				cliente.setTelefone(viewHelper.getTelefone());
				cliente.setCelular(viewHelper.getCelular());
				cliente.setEmail(viewHelper.getEmail());

				listaClientes.add(cliente);
				String retorno = "Cliente salvo com sucesso!";
				limparCamposCadastro();

				BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
			} catch (Exception e) {

				String retorno = "Erro ao salvar Cliente";
				BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
			}
		} else {
			BradescoFacesUtils.addInfoModalMessage("Informe os Dados:<br><br>"
					+ mensagem + "<br>Campos Obrigatórios!", Boolean.FALSE);
			mensagem = "";

		}
		return null;
	}

	public String voltar() {
		iniciarPagina();
		return "";
	}

	private void limparCamposCadastro() {
		this.viewHelper.setNomeCompleto(null);
		this.viewHelper.setBairro(null);
		this.viewHelper.setCelular(null);
		this.viewHelper.setCep(null);
		this.viewHelper.setCidade(null);
		this.viewHelper.setComplemento(null);
		this.viewHelper.setCpf(null);
		this.viewHelper.setDataNascimento(null);
		this.viewHelper.setEmail(null);
		this.viewHelper.setEstado(null);
		this.viewHelper.setLogradouro(null);
		this.viewHelper.setNumeroLogradouro(null);
		this.viewHelper.setRg(null);
		this.viewHelper.setSexo(null);
		this.viewHelper.setTelefone(null);

	}

	public boolean validarCampos() {

		if (siteUtil.isEmptyOrNull(viewHelper.getNomeCompleto())) {
			mensagem += "Nome<br>";

		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCpf())) {
			mensagem += "CPF<Br>";

		}
		if (siteUtil.isEmptyOrNull(viewHelper.getRg())) {
			mensagem += "RG<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getDataNascimento())) {
			mensagem += "Data de Nascimento<br>";
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getSexo())) {
			mensagem += "Sexo<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getLogradouro())) {
			mensagem += "Logradouro<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getNumeroLogradouro())) {
			mensagem += "Numero<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getBairro())) {
			mensagem += "Bairro<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCidade())) {
			mensagem += "Cidade<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getEstado())) {
			mensagem += "Estado<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getCep())) {
			mensagem += "CEP<br>";
		}
		if (siteUtil.isEmptyOrNull(viewHelper.getTelefone())) {
			mensagem += "Telefone<br>";
		}

		if (siteUtil.isEmptyOrNull(viewHelper.getCelular())) {
			mensagem += "Celular<br>";

			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}




	public boolean isLigaTabela() {
		return ligaTabela;
	}

	public void setLigaTabela(boolean ligaTabela) {
		this.ligaTabela = ligaTabela;
	}

}
