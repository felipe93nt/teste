package br.com.bradesco.web.ricc.view.bean.treinamento.pedro.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.ricc.model.treinamento.ClientePedroVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.treinamento.pedro.viewhelper.PedroClienteViewHelper;

/**
 * @name PedroClienteConsultaBean
 * @author Pedro Bido - Foursys
 * @see PedroClienteConsultaBean.java
 * @version 1.0
 * @since 08/05/2020
 */
@SessionScoped
@Named(value = "pedroClienteConsultaBean")
public class PedroClienteConsultaBean extends
		AbstractBean<PedroClienteViewHelper> {
	/**
	 *
	 */
	private static final long serialVersionUID = -6473037990504221688L;

	private String paginaAnterior = "nav_index";
	private ClientePedroVO clienteVO = new ClientePedroVO();

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.ricc.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		this.viewHelper = new PedroClienteViewHelper();
		this.viewHelper.inicializar();
		carregarClienteVO();
		return RiccConstants.TELA_TREINAMENTO_PEDRO_CLIENTE_CONSULTA;
	}

	public void carregarClienteVO() {
		PedroClienteViewHelper model = this.viewHelper;
		clienteVO.setNome("PEDRO HENRIQUE DOS SANTOS BIDO");
		clienteVO.setCpf("457.842.888-57");
		clienteVO.setRg("37.124.525-4");
		clienteVO.setDataNascimento("04/06/2000");
		clienteVO.setSexo("MASCULINO");
		clienteVO.setLogradouro("AV. DIOGO ANTÔNIO FEIJÓ");
		clienteVO.setNumeroLogradouro("477");
		clienteVO.setComplemento("APTO. 104");
		clienteVO.setBairro("KM 18");
		clienteVO.setCidade("OSASCO");
		clienteVO.setEstado("SÃO PAULO - SP");
		clienteVO.setCep("06114-022");
		clienteVO.setTelefone("(11)4567-4562");
		clienteVO.setCelular("(11)91234-8524");
		clienteVO.setEmail("pedro.bido@foursys.com.br");
		model.setClienteVO(clienteVO);
	}

	public String voltar() {
		return paginaAnterior;
	}

}
