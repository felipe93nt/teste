package br.com.bradesco.web.ricc.view.bean.parametrizacaomensagem.bean;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

import br.com.bradesco.web.ricc.model.parametrizacaomensagem.CampoIntegranteVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.parametrizacaomensagem.viewhelper.DetalharFormatoMensagemViewHelper;

/**
 * @name DetalharFormatoMensagemBean
 * @author Foursys
 * @version 1.0
 * @since 26/06/2020
 */
@SessionScoped
@Named(value = "detalharFormatoMensagemBean")
public class DetalharFormatoMensagemBean extends
		AbstractBean<DetalharFormatoMensagemViewHelper> {

	/**
	 * Atributo serialVersionUID Tipo long
	 */
	private static final long serialVersionUID = 1631866463606968265L;

	private String paginaAnterior = RiccConstants.TELA_PARAMETRIZACAO_CONSULTAR_FORMATO_MENSAGEM;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.Swrm.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		setViewHelper(new DetalharFormatoMensagemViewHelper());
		viewHelper.inicializar();
		carregarCamposIntegrantesVO();
		carregarCamposVO();
		return RiccConstants.TELA_PARAMETRIZACAO_DETALHAR_FORMATOS_MENSAGEM;
	}

	public String voltar() {
		return paginaAnterior;
	}

	public void carregarCamposIntegrantesVO() {
		CampoIntegranteVO c1 = new CampoIntegranteVO();
		c1.setCampo("Basic Header");
		c1.setObrigatorio("true");
		c1.setOrdem("001");
		c1.setBloco("Basic Hdr");
		c1.setTag("");
		viewHelper.getListaCamposIntegrantesVO().add(c1);
		CampoIntegranteVO c2 = new CampoIntegranteVO();
		c2.setCampo("Input Application Header");
		c2.setObrigatorio("true");
		c2.setOrdem("002");
		c2.setBloco("App Hdr");
		c2.setTag("");
		viewHelper.getListaCamposIntegrantesVO().add(c2);
		CampoIntegranteVO c3 = new CampoIntegranteVO();
		c3.setCampo("Service Code");
		c3.setObrigatorio("false");
		c3.setOrdem("003");
		c3.setBloco("User Hdr");
		c3.setTag("103");
		viewHelper.getListaCamposIntegrantesVO().add(c3);
		CampoIntegranteVO c4 = new CampoIntegranteVO();
		c4.setCampo("Bank Priority");
		c4.setObrigatorio("false");
		c4.setOrdem("004");
		c4.setBloco("User Hdr");
		c4.setTag("113");
		viewHelper.getListaCamposIntegrantesVO().add(c4);
		CampoIntegranteVO c5 = new CampoIntegranteVO();
		c5.setCampo("Message User Reference");
		c5.setObrigatorio("false");
		c5.setOrdem("005");
		c5.setBloco("User Hdr");
		c5.setTag("108");
		viewHelper.getListaCamposIntegrantesVO().add(c5);
		CampoIntegranteVO c6 = new CampoIntegranteVO();
		c6.setCampo("Validation Flag");
		c6.setObrigatorio("false");
		c6.setOrdem("006");
		c6.setBloco("User Hdr");
		c6.setTag("119");
		viewHelper.getListaCamposIntegrantesVO().add(c6);
		CampoIntegranteVO c7 = new CampoIntegranteVO();
		c7.setCampo("Service Type Identifier");
		c7.setObrigatorio("false");
		c7.setOrdem("007");
		c7.setBloco("User Hdr");
		c7.setTag("111");
		viewHelper.getListaCamposIntegrantesVO().add(c7);
		CampoIntegranteVO c8 = new CampoIntegranteVO();
		c8.setCampo("Unique End-to-End Tr.Ref.");
		c8.setObrigatorio("false");
		c8.setOrdem("008");
		c8.setBloco("User Hdr");
		c8.setTag("121");
		viewHelper.getListaCamposIntegrantesVO().add(c8);

	}

	public void carregarCamposVO() {
		CampoIntegranteVO c1 = new CampoIntegranteVO();
		c1.setCampo("Basic Header");
		c1.setObrigatorio("true");
		c1.setOrdem("001");
		c1.setBloco("Basic Hdr");
		c1.setTag("");
		viewHelper.getListaCamposVO().add(c1);
		CampoIntegranteVO c2 = new CampoIntegranteVO();
		c2.setCampo("Input Application Header");
		c2.setObrigatorio("true");
		c2.setOrdem("002");
		c2.setBloco("App Hdr");
		c2.setTag("");
		viewHelper.getListaCamposVO().add(c2);
		CampoIntegranteVO c3 = new CampoIntegranteVO();
		c3.setCampo("Service Code");
		c3.setObrigatorio("false");
		c3.setOrdem("003");
		c3.setBloco("User Hdr");
		c3.setTag("103");
		viewHelper.getListaCamposVO().add(c3);
		CampoIntegranteVO c4 = new CampoIntegranteVO();
		c4.setCampo("Bank Priority");
		c4.setObrigatorio("false");
		c4.setOrdem("004");
		c4.setBloco("User Hdr");
		c4.setTag("113");
		viewHelper.getListaCamposVO().add(c4);
		CampoIntegranteVO c5 = new CampoIntegranteVO();
		c5.setCampo("Message User Reference");
		c5.setObrigatorio("false");
		c5.setOrdem("005");
		c5.setBloco("User Hdr");
		c5.setTag("108");
		viewHelper.getListaCamposVO().add(c5);
		CampoIntegranteVO c6 = new CampoIntegranteVO();
		c6.setCampo("Validation Flag");
		c6.setObrigatorio("false");
		c6.setOrdem("006");
		c6.setBloco("User Hdr");
		c6.setTag("119");
		viewHelper.getListaCamposVO().add(c6);
		CampoIntegranteVO c7 = new CampoIntegranteVO();
		c7.setCampo("Service Type Identifier");
		c7.setObrigatorio("false");
		c7.setOrdem("007");
		c7.setBloco("User Hdr");
		c7.setTag("111");
		viewHelper.getListaCamposVO().add(c7);
		CampoIntegranteVO c8 = new CampoIntegranteVO();
		c8.setCampo("Unique End-to-End Tr.Ref.");
		c8.setObrigatorio("false");
		c8.setOrdem("008");
		c8.setBloco("User Hdr");
		c8.setTag("121");
		viewHelper.getListaCamposVO().add(c8);
		CampoIntegranteVO c9 = new CampoIntegranteVO();
		c9.setCampo("Sender's Reference");
		c9.setObrigatorio("");
		c9.setOrdem("009");
		c9.setBloco("Text");
		c9.setTag("20");
		viewHelper.getListaCamposVO().add(c9);
	}

	public void habilitarBotaoRemover(AjaxBehaviorEvent ae) {
		this.viewHelper.setBtnRemoverCampoIntegrante(Boolean.FALSE);
		if (!this.viewHelper.getCampoIntegranteSelecionado().isEmpty()) {
			this.viewHelper.setBtnRemoverCampoIntegrante(Boolean.TRUE);
		}
	}

	public void habilitarBotaoAdicionar(AjaxBehaviorEvent ae) {
		this.viewHelper.setBtnAdicionarCampoIntegrante(Boolean.FALSE);
		if (!this.viewHelper.getCampoSelecionado().isEmpty()) {
			this.viewHelper.setBtnAdicionarCampoIntegrante(Boolean.TRUE);
		}
	}
}
