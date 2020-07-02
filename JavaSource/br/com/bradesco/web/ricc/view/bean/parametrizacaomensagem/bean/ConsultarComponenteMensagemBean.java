package br.com.bradesco.web.ricc.view.bean.parametrizacaomensagem.bean;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

import br.com.bradesco.web.ricc.model.parametrizacaomensagem.ComponenteMensagemVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.parametrizacaomensagem.viewhelper.ConsultarComponenteMensagemViewHelper;

/**
 * @name ConsultarComponenteMensagemBean
 * @author Foursys
 * @version 1.0
 * @since 25/06/2020
 */
@SessionScoped
@Named(value = "consultarComponenteMensagemBean")
public class ConsultarComponenteMensagemBean extends AbstractBean<ConsultarComponenteMensagemViewHelper>{
	/**
	 * Atributo serialVersionUID Tipo long
	 */
	private static final long serialVersionUID = 1631866463606968265L;
	
	private String paginaAnterior = "nav_index";
	
	@Override
	public String iniciarPagina() {
		setViewHelper(new ConsultarComponenteMensagemViewHelper());
		viewHelper.inicializar();
		carregarListaComponenteMensagemVO();
		return RiccConstants.TELA_PARAMETRIZACAO_CONSULTAR_COMPONENTE_MENSAGEM;
	}
	
	public void habilitarBotoes(AjaxBehaviorEvent ae) {
		this.viewHelper.setBtnAlterar(Boolean.FALSE);
		this.viewHelper.setBtnAutorizar(Boolean.FALSE);
		this.viewHelper.setBtnExcluir(Boolean.FALSE);
		this.viewHelper.setBtnDetalhar(Boolean.FALSE);
		this.viewHelper.setBtnCopiar(Boolean.FALSE);
		if (!this.viewHelper.getItemSelecionado().isEmpty()) {
			this.viewHelper.setBtnAlterar(Boolean.TRUE);
			this.viewHelper.setBtnAutorizar(Boolean.TRUE);
			this.viewHelper.setBtnExcluir(Boolean.TRUE);
			this.viewHelper.setBtnDetalhar(Boolean.TRUE);
			this.viewHelper.setBtnCopiar(Boolean.TRUE);
		}
	}

	public String voltar() {
		return paginaAnterior;
	}
	
	public void carregarListaComponenteMensagemVO(){
		ComponenteMensagemVO c1 = new ComponenteMensagemVO();
		c1.setIdentidade("38");
		c1.setIdGrupo("");
		c1.setTpComp("Campo");
		c1.setDescricao("Sender's Ref");
		c1.setBloco("Text");
		c1.setTagOpc("20");
		c1.setTagXML("");
		c1.setLinhas("1");
		c1.setTipoDado("Referência");
		c1.setFormato("Carac.Set X");
		c1.setTamanho("16");
		c1.setFixo("Não");
		c1.setValidador("SWRM0020");
		c1.setUltAlt("20/02/2020 10:15");
		c1.setUsuario("F123456");
		viewHelper.getListaComponenteMensagemVO().add(c1);
		
		ComponenteMensagemVO c2 = new ComponenteMensagemVO();
		c2.setIdentidade("49");
		c2.setIdGrupo("20 Sender's Reference");
		c2.setTpComp("Campo");
		c2.setDescricao("Value-Date, Curr., Amount");
		c2.setBloco("Text");
		c2.setTagOpc("32 A");
		c2.setTagXML("");
		c2.setLinhas("1");
		c2.setTipoDado("Grupo Dados");
		c2.setFormato("Carac. Set X");
		c2.setTamanho("24");
		c2.setFixo("Não");
		c2.setValidador("SWRM0020");
		c2.setUltAlt("20/02/2020 10:19");
		c2.setUsuario("F123456");
		viewHelper.getListaComponenteMensagemVO().add(c2);
		
		ComponenteMensagemVO c3 = new ComponenteMensagemVO();
		c3.setIdentidade("50");
		c3.setIdGrupo("13C Time Indication");
		c3.setTpComp("SubCpo");
		c3.setDescricao("Value Date");
		c3.setBloco("Text");
		c3.setTagOpc("");
		c3.setTagXML("");
		c3.setLinhas("1");
		c3.setTipoDado("Dataamd6");
		c3.setFormato("Numérico");
		c3.setTamanho("6");
		c3.setFixo("Sim");
		c3.setValidador("SWRM0030");
		c3.setUltAlt("20/02/2020 10:21");
		c3.setUsuario("F123456");
		viewHelper.getListaComponenteMensagemVO().add(c3);
		
		ComponenteMensagemVO c4 = new ComponenteMensagemVO();
		c4.setIdentidade("51");
		c4.setIdGrupo("23B Bank Operation Code");
		c4.setTpComp("SubCpo");
		c4.setDescricao("Currency");
		c4.setBloco("Text");
		c4.setTagOpc("");
		c4.setTagXML("");
		c4.setLinhas("1");
		c4.setTipoDado("Moeda");
		c4.setFormato("Alfabético");
		c4.setTamanho("6");
		c4.setFixo("Sim");
		c4.setValidador("SWRM0030");
		c4.setUltAlt("20/02/2020 10:25");
		c4.setUsuario("F123456");
		viewHelper.getListaComponenteMensagemVO().add(c4);
		
		ComponenteMensagemVO c5 = new ComponenteMensagemVO();
		c5.setIdentidade("52");
		c5.setIdGrupo("23B Bank Operation Code");
		c5.setTpComp("SubCpo");
		c5.setDescricao("Amount");
		c5.setBloco("Text");
		c5.setTagOpc("");
		c5.setTagXML("");
		c5.setLinhas("1");
		c5.setTipoDado("Valor");
		c5.setFormato("Carac.Set D");
		c5.setTamanho("15");
		c5.setFixo("Não");
		c5.setValidador("SWRM0030");
		c5.setUltAlt("20/02/2020 10:27");
		c5.setUsuario("F123456");
		viewHelper.getListaComponenteMensagemVO().add(c5);
	}

}
