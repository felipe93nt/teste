package br.com.bradesco.web.ricc.view.bean.treinamento.joaogil.bean;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.util.FacesUtils;
import br.com.bradesco.web.ricc.model.treinamento.ClienteJoaogilVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.joaogil.viewhelper.JoaogilTesteViewHelper;

@SessionScoped
@Named(value = "joaogilTesteBean")
public class JoaogilTesteBean extends AbstractBean<JoaogilTesteViewHelper> {
	private static final long serialVersionUID = -6473037990504221688L;
	private String paginaAnterior = "nav_index";

	@Override
	public String iniciarPagina() {
		this.viewHelper = new JoaogilTesteViewHelper();
		this.viewHelper.inicializar();
		return RiccConstants.TREINAMENTO_JOAOGIL_TESTE_CADASTRO;
	}

	public String iniciarPaginaConsulta() {
		return RiccConstants.TREINAMENTO_JOAOGIL_TESTE_CONSULTA;
	}

	public String voltar() {
		return paginaAnterior;
	}

	/**
	 * @description
	 * @name salvar
	 * @see JoaogilClienteBean
	 * @return
	 * @return String
	 */

	public String salvar() {
		String retorno = "Cliente salvo com sucesso!";
		if (validarTodosCamposEntradaString(this.viewHelper.getNome(),
				this.viewHelper.getCpf(), this.viewHelper.getRg(),
				this.viewHelper.getDataNascimento(), this.viewHelper.getSexo(),
				this.viewHelper.getLogradouro(),
				this.viewHelper.getNumeroLogradouro(),
				this.viewHelper.getBairro(), this.viewHelper.getCidade(),
				this.viewHelper.getEstado(), this.viewHelper.getCep(),
				this.viewHelper.getTelefone(), this.viewHelper.getCelular())) {

			ClienteJoaogilVO clienteVO = new ClienteJoaogilVO();
			clienteVO.setNomeCompleto(this.viewHelper.getNome());
			clienteVO.setCpf(this.viewHelper.getCpf());
			clienteVO.setRg(this.viewHelper.getRg());
			clienteVO.setDataNascimento(this.viewHelper.getDataNascimento());
			clienteVO.setSexo(this.viewHelper.getSexo());
			clienteVO.setLogradouro(this.viewHelper.getLogradouro());
			clienteVO
					.setNumeroLogradouro(this.viewHelper.getNumeroLogradouro());
			clienteVO.setComplemento(this.viewHelper.getComplemento());
			clienteVO.setBairro(this.viewHelper.getBairro());
			clienteVO.setCidade(retornaCidade(this.viewHelper.getCidade()));
			clienteVO.setEstado(retornaEstado(this.viewHelper.getEstado()));
			clienteVO.setCep(this.viewHelper.getCep());
			clienteVO.setTelefone(this.viewHelper.getTelefone());
			clienteVO.setCelular(this.viewHelper.getCelular());
			clienteVO.setEmail(this.viewHelper.getEmail());
			viewHelper.getListaCadastramento().add(clienteVO);
			viewHelper.setBtnConsultar(Boolean.TRUE);

			BradescoFacesUtils.addInfoModalMessage(retorno, Boolean.FALSE);
			limparCampos();
		}
		return null;
	}
	
	private void limparCampos() {
		this.viewHelper.setNome(null);
		this.viewHelper.setCpf(null);
		this.viewHelper.setRg(null);
		this.viewHelper.setDataNascimento(null);
		this.viewHelper.setSexo(null);
		this.viewHelper.setLogradouro(null);
		this.viewHelper.setNumeroLogradouro(null);
		this.viewHelper.setComplemento(null);
		this.viewHelper.setBairro(null);
		this.viewHelper.setCidade(null);
		this.viewHelper.setEstado(null);
		this.viewHelper.setCep(null);
		this.viewHelper.setTelefone(null);
		this.viewHelper.setCelular(null);
		this.viewHelper.setEmail(null);
	}

	private boolean validarTodosCamposEntradaString(String... entrada) {
		String retornoUsuario = "";

		for (int i = 0; i < entrada.length; i++) {
			if (entrada[i] == null || "".equals(entrada[i])) {
				retornoUsuario += validaPreenchimento(i, retornoUsuario)
						+ "<br>";
			}
		}
		if (retornoUsuario != "") {
			BradescoFacesUtils.addInfoModalMessage(retornoUsuario,
					Boolean.FALSE);
			return false;
		}

		return true;
	}

	private String validaPreenchimento(int entrada, String retornoUsuario) {
		switch (entrada) {
		case 0:
			retornoUsuario = "O campo nome completo é obrigatório";
			break;
		case 1:
			retornoUsuario = "O campo CPF é obrigatório";
			break;
		case 2:
			retornoUsuario = "O campo RG é obrigatório";
			break;
		case 3:
			retornoUsuario = "O campo data de nascimento é obrigatório";
			break;
		case 4:
			retornoUsuario = "O campo sexo é obrigatório";
			break;
		case 5:
			retornoUsuario = "O campo logradouro é obrigatório";
			break;
		case 6:
			retornoUsuario = "O campo número logradouro é obrigatório";
			break;
		case 7:
			retornoUsuario = "O campo bairro é obrigatório";
			break;
		case 8:
			retornoUsuario = "O campo cidade é obrigatório";
			break;
		case 9:
			retornoUsuario = "O campo estado é obrigatório";
			break;
		case 10:
			retornoUsuario = "O campo CEP é obrigatório";
			break;
		case 11:
			retornoUsuario = "O campo telefone é obrigatório";
			break;
		case 12:
			retornoUsuario = "O campo celular é obrigatório";
			break;
		default:
			retornoUsuario = "";
		}
		return retornoUsuario;
	}

	private String retornaCidade(String cidadeAntiga) {
		String retorno = "";
		switch (cidadeAntiga) {
		case "1":
			retorno = "São Paulo";
			break;
		case "2":
			retorno = "São José do Rio Preto";
			break;
		case "3":
			retorno = "Ourinhos";
			break;
		case "4":
			retorno = "Olímpia";
			break;
		case "5":
			retorno = "Rio de Janeiro";
			break;
		default:
			retorno = cidadeAntiga;
			break;
		}
		return retorno;
	}

	private String retornaEstado(String estadoAntigo) {
		String retorno = "";
		switch (estadoAntigo) {
		case "1":
			retorno = "São Paulo";
			break;
		case "2":
			retorno = "Rio de Janeiro";
			break;
		default:
			retorno = estadoAntigo;
			break;
		}
		return retorno;
	}

	public void abrirModalCidade() {
		limparCamposModalCidade();// Limpa os campos do modal ao abri-lo
		viewHelper.setRenderModalCidade(Boolean.TRUE);
	}

	private void limparCamposModalCidade() {
		viewHelper.setNovaCidade("");
	}

	public List<SelectItem> incluirCidade() {
		SelectItem aux = new SelectItem();
		aux.setValue(viewHelper.getNovaCidade());
		aux.setLabel(viewHelper.getNovaCidade());
		viewHelper.getListaNovasCidades().add(aux);
		fecharModalCidade();
		return viewHelper.getListaNovasCidades();
	}

	public void fecharModalCidade() {
		viewHelper.setRenderModalCidade(Boolean.FALSE);
	}

	public void abrirModalEstado() {
		limparCamposModalEstado();// Limpa os campos do modal ao abri-lo
		viewHelper.setRenderModalEstado(Boolean.TRUE);
	}

	private void limparCamposModalEstado() {
		viewHelper.setNovoEstado("");
	}

	public List<SelectItem> incluirEstado() {
		SelectItem aux = new SelectItem();
		aux.setValue(viewHelper.getNovoEstado());
		aux.setLabel(viewHelper.getNovoEstado());
		viewHelper.getListaNovosEstados().add(aux);
		fecharModalEstado();
		return viewHelper.getListaNovosEstados();
	}

	public void fecharModalEstado() {
		viewHelper.setRenderModalEstado(Boolean.FALSE);
	}

	public String consultar() {
		String retorno = "";
		ClienteJoaogilVO itemSelecionado = null;
		List<ClienteJoaogilVO> listaAux = null;
		try {
			itemSelecionado = getViewHelper().getItemSelecionado().get(0);
			listaAux = getViewHelper().getListaCadastramento();
			paginaAnterior = RiccConstants.TREINAMENTO_JOAOGIL_TESTE_CADASTRO;
			JoaogilTesteBean bean = (JoaogilTesteBean) FacesUtils
					.getManagedBean("joaogilTesteBean");
			
			bean.setViewHelper(new JoaogilTesteViewHelper());
			bean.getViewHelper().setCliente(itemSelecionado);
			bean.getViewHelper().setListaCadastramento(listaAux);
			bean.getViewHelper().setBtnConsultar(Boolean.TRUE);
			bean.getViewHelper().inicializar();
			retorno = bean.iniciarPaginaConsulta();
		} catch (Exception E) {
			siteUtil.getMessages().getMsgSelecioneUmItemLista("label_cadastro");
		}

		return retorno;
	}
	
	public void paginar(ActionEvent ae) {
		this.viewHelper.getListaCadastramento();
	}
}
