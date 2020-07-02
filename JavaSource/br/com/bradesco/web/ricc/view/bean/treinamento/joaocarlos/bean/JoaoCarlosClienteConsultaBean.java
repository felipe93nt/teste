package br.com.bradesco.web.ricc.view.bean.treinamento.joaocarlos.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.ricc.model.segmento.ClienteVO;
import br.com.bradesco.web.ricc.model.treinamento.ClienteJoaoCarlosVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.joaocarlos.viewhelper.JoaoCarlosClienteViewHelper;

/**
 * @name JoaoCarlosClienteConsultaBean
 * @author João Carlos - Foursys
 * @see JoaoCarlosClienteConsultaBean.java
 * @version 1.0
 * @since 04/05/2020
 */
@SessionScoped
@Named(value = "joaoCarlosClienteConsultaBean")
public class JoaoCarlosClienteConsultaBean extends
		AbstractBean<JoaoCarlosClienteViewHelper> {
	/**
	 *
	 */
	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "nav_index";
	
	private ClienteJoaoCarlosVO clienteVO = new ClienteJoaoCarlosVO();

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		this.viewHelper = new JoaoCarlosClienteViewHelper();
		this.viewHelper.inicializar();
		carregarDadosCliente();
		return RiccConstants.TELA_TREINAMENTO_JOAOCARLOS_CONSULTA_CLIENTE;
	}
	
	public void carregarDadosCliente(){
		clienteVO.setNome("Joao Araujo");
		clienteVO.setCpf("123.456.789-00");
		clienteVO.setRg("12.345.789-0");
		clienteVO.setDataNascimento("14/01/1998");
		clienteVO.setSexo("Masculino");
		clienteVO.setLogradouro("Avenida Esmeralda");
		clienteVO.setNumeroLogradouro("1000");
		clienteVO.setComplemento("Bloco 11 Apto 10");
		clienteVO.setBairro("Jardim Mutinga");
		clienteVO.setCidade("Osasco");
		clienteVO.setEstado("São Paulo");
		clienteVO.setCep("06286-000");
		clienteVO.setTelefone("(11) 3603-7291");
		clienteVO.setCelular("(11) 94761-4880");
		clienteVO.setEmail("joao.araujo@foursys.com.br");
		
		
		this.viewHelper.setClienteVO(clienteVO);
	}

	public String voltar() {

		return paginaAnterior;
	}

}
