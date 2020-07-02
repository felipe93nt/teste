package br.com.bradesco.web.ricc.view.bean.treinamento.vitoria.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.ricc.model.treinamento.ClienteVitoriaVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.vitoria.viewhelper.VitoriaClienteViewHelper;

/**
 * @name VitoriaClienteConsultaBean
 * @author Vitoria Furtado - Foursys
 * @see VitoriaClienteConsultaBean.java
 * @version 1.0
 * @since 07/09/2018
 */
@SessionScoped
@Named(value = "vitoriaClienteConsultaBean")
public class VitoriaClienteConsultaBean extends AbstractBean<VitoriaClienteViewHelper> {
	/**
	 *
	 */
	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "nav_index";
	private ClienteVitoriaVO cliente = new ClienteVitoriaVO();

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		this.viewHelper = new VitoriaClienteViewHelper();
		this.viewHelper.inicializar();
		carregarCliente();
		return RiccConstants.TELA_TREINAMENTO_VITORIA_CONSULTA;
	}
	
	public void carregarCliente(){
		
		
		cliente.setNome("Pedro Teofilo");
		cliente.setCpf("422.935.789-00");
		cliente.setRg("45.776.489-0");
		cliente.setDataNascimento("20/08/1999");
		cliente.setSexo("Masculino");
		cliente.setLogradouro("Rua teste");
		cliente.setNumeroLogradouro("106");
		cliente.setComplemento("Casa 1");
		cliente.setBairro("Bairro Teste");
		cliente.setCidade("Barueri");
		cliente.setEstado("São Paulo");
		cliente.setCep("06535-145");
		cliente.setTelefone("(11) 4002-8922");
		cliente.setCelular("(11) 99715-8048");
		cliente.setEmail("pedro.teofilovt@gmail.com");
		
		this.viewHelper.setCliente(cliente);
	}
	



	/**
	 * @description
	 * @name salvar
	 * @see VitoriaClienteConsultaBean
	 * @return
	 * @return String
	 */

	public String voltar() {

		return paginaAnterior;
	}

}
