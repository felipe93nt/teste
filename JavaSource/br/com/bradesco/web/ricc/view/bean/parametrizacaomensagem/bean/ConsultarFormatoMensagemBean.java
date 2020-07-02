package br.com.bradesco.web.ricc.view.bean.parametrizacaomensagem.bean;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

import br.com.bradesco.web.ricc.model.parametrizacaomensagem.FormatoMensagemVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.parametrizacaomensagem.viewhelper.ConsultarFormatoMensagemViewHelper;

/**
 * @name PesquisaFormatoMensagemBean
 * @author Foursys
 * @version 1.0
 * @since 23/06/2020
 */
@SessionScoped
@Named(value = "consultarFormatoMensagemBean")
public class ConsultarFormatoMensagemBean extends
		AbstractBean<ConsultarFormatoMensagemViewHelper> {

	/**
	 * Atributo serialVersionUID Tipo long
	 */
	private static final long serialVersionUID = 1631866463606968265L;

	private String paginaAnterior = "nav_index";

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.Swrm.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		setViewHelper(new ConsultarFormatoMensagemViewHelper());
		viewHelper.inicializar();
		carregarListaFormatos();
		return RiccConstants.TELA_PARAMETRIZACAO_CONSULTAR_FORMATO_MENSAGEM;
	}

	public String voltar() {
		return paginaAnterior;
	}

	public void habilitarBotoes(AjaxBehaviorEvent ae) {
		this.viewHelper.setBtnDetalhar(Boolean.FALSE);
		if (!this.viewHelper.getItemSelecionado().isEmpty()) {
			this.viewHelper.setBtnDetalhar(Boolean.TRUE);
		}
	}

	private void carregarListaFormatos() {
		FormatoMensagemVO f1 = new FormatoMensagemVO();
		f1.setIdentificacao("1");
		f1.setMt("103");
		f1.setDescricao("Single Customer Credit Transfer");
		f1.setInicioVigencia("15/10/2019");
		f1.setFimVigencia("15/10/2020");
		f1.setNivelAutorizacao("Dupla Alçada");
		f1.setUltimaAtualizacao("23/06/2020 11:45");
		f1.setUsuario("F123456");
		f1.setStatus("Ativa");
		viewHelper.getListaFormatos().add(f1);
		FormatoMensagemVO f2 = new FormatoMensagemVO();
		f2.setIdentificacao("2");
		f2.setMt("103");
		f2.setDescricao("STP Single Customer Credit Transfer");
		f2.setInicioVigencia("15/10/2019");
		f2.setFimVigencia("15/10/2020");
		f2.setNivelAutorizacao("Feito/Confer.");
		f2.setUltimaAtualizacao("22/06/2020 16:32");
		f2.setUsuario("F123456");
		f2.setStatus("Inativa");
		viewHelper.getListaFormatos().add(f2);

	}
}
