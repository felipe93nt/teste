package br.com.bradesco.web.ricc.view.bean.manutencaomensagem.bean;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

import br.com.bradesco.web.ricc.model.manutencao.MensagemVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.manutencaomensagem.viewhelper.ListaMensagemViewHelper;

/**
 * @name ListaMensagemBean
 * @author Foursys
 * @version 1.0
 * @since 08/06/2020
 */
@SessionScoped
@Named(value = "listaMensagemBean")
public class ListaMensagemBean extends AbstractBean<ListaMensagemViewHelper> {
	/**
	 * Atributo serialVersionUID Tipo long
	 */
	private static final long serialVersionUID = 1631866463606968265L;

	private String paginaAnterior = RiccConstants.TELA_MANUTENCAO_MENSAGEM_CONSULTA;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.Swft.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		setViewHelper(new ListaMensagemViewHelper());
		viewHelper.inicializar();
		carregarListaMensagemVO();
		return RiccConstants.TELA_MANUTENCAO_LISTA_MENSAGEM;
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

	public void carregarListaMensagemVO() {
		MensagemVO msg1 = new MensagemVO();
		msg1.setCodigoMensagem("103");
		msg1.setReferencia("09751008724");
		msg1.setData("15/02/2020 10:31:15");
		msg1.setUsuario("I907475");
		msg1.setStatus("PENDENTE DE AUTORIZAÇÃO");
		msg1.setBeneficiario("00012367493 DUPONT SARL 21 RUE DU COMÉRCIO PARIS");
		msg1.setOrdenante("098735711000 GALLMAN COMPANY GMBH RAEMISTRASSE, 71 8006 ZURIQUE SUÍÇA");
		msg1.setIsnOsn("121822");
		msg1.setCorrespondente("BRASBRRJCAS");
		msg1.setDepartamento("CAS");
		msg1.setMoeda("EUR");
		msg1.setValor("28.310,27");
		msg1.setTipoTransmissao("Enviada");
		viewHelper.getListaMensagemVO().add(msg1);
		MensagemVO msg2 = new MensagemVO();
		msg2.setCodigoMensagem("103");
		msg2.setReferencia("09751008724");
		msg2.setData("15/02/2020 10:31:17");
		msg2.setUsuario("I907475");
		msg2.setStatus("PENDENTE DE AUTORIZAÇÃO");
		msg2.setBeneficiario("00012367493 DUPONT SARL 21 RUE DU COMÉRCIO PARIS");
		msg2.setOrdenante("098735711000 GALLMAN COMPANY GMBH RAEMISTRASSE, 71 8006 ZURIQUE SUÍÇA");
		msg2.setIsnOsn("121822");
		msg2.setCorrespondente("BRASBRRJCAS");
		msg2.setDepartamento("CAS");
		msg2.setMoeda("EUR");
		msg2.setValor("33.566,00");
		msg2.setTipoTransmissao("Enviada");
		viewHelper.getListaMensagemVO().add(msg2);
		MensagemVO msg3 = new MensagemVO();
		msg3.setCodigoMensagem("103");
		msg3.setReferencia("09751008724");
		msg3.setData("15/02/2020 10:31:19");
		msg3.setUsuario("I907475");
		msg3.setStatus("PENDENTE DE AUTORIZAÇÃO");
		msg3.setBeneficiario("00012367493 DUPONT SARL 21 RUE DU COMÉRCIO PARIS");
		msg3.setOrdenante("098735711000 GALLMAN COMPANY GMBH RAEMISTRASSE, 71 8006 ZURIQUE SUÍÇA");
		msg3.setIsnOsn("121822");
		msg3.setCorrespondente("BRASBRRJCAS");
		msg3.setDepartamento("CAS");
		msg3.setMoeda("EUR");
		msg3.setValor("28.310,27");
		msg3.setTipoTransmissao("Enviada");
		viewHelper.getListaMensagemVO().add(msg3);
		MensagemVO msg4 = new MensagemVO();
		msg4.setCodigoMensagem("103");
		msg4.setReferencia("09751008724");
		msg4.setData("15/02/2020 10:32:20");
		msg4.setUsuario("I907475");
		msg4.setStatus("PENDENTE DE AUTORIZAÇÃO");
		msg4.setBeneficiario("00012367493 DUPONT SARL 21 RUE DU COMÉRCIO PARIS");
		msg4.setOrdenante("098735711000 GALLMAN COMPANY GMBH RAEMISTRASSE, 71 8006 ZURIQUE SUÍÇA");
		msg4.setIsnOsn("121822");
		msg4.setCorrespondente("BRASBRRJCAS");
		msg4.setDepartamento("CAS");
		msg4.setMoeda("EUR");
		msg4.setValor("77.810,10");
		msg4.setTipoTransmissao("Enviada");
		viewHelper.getListaMensagemVO().add(msg4);
		MensagemVO msg5 = new MensagemVO();
		msg5.setCodigoMensagem("103");
		msg5.setReferencia("09751008724");
		msg5.setData("15/02/2020 10:31:21");
		msg5.setUsuario("I907475");
		msg5.setStatus("PENDENTE DE AUTORIZAÇÃO");
		msg5.setBeneficiario("00012367493 DUPONT SARL 21 RUE DU COMÉRCIO PARIS");
		msg5.setOrdenante("098735711000 GALLMAN COMPANY GMBH RAEMISTRASSE, 71 8006 ZURIQUE SUÍÇA");
		msg5.setIsnOsn("121822");
		msg5.setCorrespondente("BRASBRRJCAS");
		msg5.setDepartamento("CAS");
		msg5.setMoeda("EUR");
		msg5.setValor("80.550,27");
		msg5.setTipoTransmissao("Enviada");
		viewHelper.getListaMensagemVO().add(msg5);
		MensagemVO msg6 = new MensagemVO();
		msg6.setCodigoMensagem("103");
		msg6.setReferencia("09751008724");
		msg6.setData("15/02/2020 10:31:22");
		msg6.setUsuario("I907475");
		msg6.setStatus("PENDENTE DE AUTORIZAÇÃO");
		msg6.setBeneficiario("00012367493 DUPONT SARL 21 RUE DU COMÉRCIO PARIS");
		msg6.setOrdenante("098735711000 GALLMAN COMPANY GMBH RAEMISTRASSE, 71 8006 ZURIQUE SUÍÇA");
		msg6.setIsnOsn("121822");
		msg6.setCorrespondente("BRASBRRJCAS");
		msg6.setDepartamento("CAS");
		msg6.setMoeda("EUR");
		msg6.setValor("33.330,30");
		msg6.setTipoTransmissao("Enviada");
		viewHelper.getListaMensagemVO().add(msg6);
		MensagemVO msg7 = new MensagemVO();
		msg7.setCodigoMensagem("103");
		msg7.setReferencia("09751008724");
		msg7.setData("15/02/2020 10:31:23");
		msg7.setUsuario("I907475");
		msg7.setStatus("PENDENTE DE AUTORIZAÇÃO");
		msg7.setBeneficiario("00012367493 DUPONT SARL 21 RUE DU COMÉRCIO PARIS");
		msg7.setOrdenante("098735711000 GALLMAN COMPANY GMBH RAEMISTRASSE, 71 8006 ZURIQUE SUÍÇA");
		msg7.setIsnOsn("121822");
		msg7.setCorrespondente("BRASBRRJCAS");
		msg7.setDepartamento("CAS");
		msg7.setMoeda("EUR");
		msg7.setValor("44.770,00");
		msg7.setTipoTransmissao("Enviada");
		viewHelper.getListaMensagemVO().add(msg7);
		MensagemVO msg8 = new MensagemVO();
		msg8.setCodigoMensagem("103");
		msg8.setReferencia("09751008724");
		msg8.setData("15/02/2020 10:41:16");
		msg8.setUsuario("I907475");
		msg8.setStatus("PENDENTE DE AUTORIZAÇÃO");
		msg8.setBeneficiario("00012367493 DUPONT SARL 21 RUE DU COMÉRCIO PARIS");
		msg8.setOrdenante("098735711000 GALLMAN COMPANY GMBH RAEMISTRASSE, 71 8006 ZURIQUE SUÍÇA");
		msg8.setIsnOsn("121822");
		msg8.setCorrespondente("BRASBRRJCAS");
		msg8.setDepartamento("CAS");
		msg8.setMoeda("EUR");
		msg8.setValor("30.440,27");
		msg8.setTipoTransmissao("Enviada");
		viewHelper.getListaMensagemVO().add(msg8);
		
	}

}