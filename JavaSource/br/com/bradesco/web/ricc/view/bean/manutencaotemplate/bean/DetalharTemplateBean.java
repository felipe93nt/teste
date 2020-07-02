package br.com.bradesco.web.ricc.view.bean.manutencaotemplate.bean;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

import br.com.bradesco.web.ricc.model.manutencao.InstructionCodeVO;
import br.com.bradesco.web.ricc.model.manutencao.SendersChargesVO;
import br.com.bradesco.web.ricc.model.manutencao.TimeIndicationVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.manutencaotemplate.viewhelper.DetalharTemplateViewHelper;

/**
 * @name DetalharTemplateBean
 * @author Foursys
 * @version 1.0
 * @since 16/06/2020
 */
@SessionScoped
@Named(value = "detalharTemplateBean")
public class DetalharTemplateBean extends
		AbstractBean<DetalharTemplateViewHelper> {
	/**
	 * Atributo serialVersionUID Tipo long
	 */
	private static final long serialVersionUID = 1631866463606968265L;

	private String paginaAnterior = RiccConstants.TELA_MANUTENCAO_LISTAR_TEMPLATE;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.bradesco.web.Swft.view.bean.AbstractBean#iniciarPagina()
	 */
	@Override
	public String iniciarPagina() {
		setViewHelper(new DetalharTemplateViewHelper());
		viewHelper.inicializar();
		carregarListaTimeIndicationVO();
		carregarListaInstructionCodeVO();
		carregarListaSendersChargesVO();
		return RiccConstants.TELA_MANUTENCAO_DETALHAR_TEMPLATE;
	}

	private void carregarListaSendersChargesVO() {
		SendersChargesVO sc1 = new SendersChargesVO();
		sc1.setOccur("1");
		sc1.setCurrency("EUR");
		sc1.setAmount("8,00");
		viewHelper.getListaSendersChargesVO().add(sc1);
		SendersChargesVO sc2 = new SendersChargesVO();
		sc2.setOccur("2");
		sc2.setCurrency("");
		sc2.setAmount("");
		viewHelper.getListaSendersChargesVO().add(sc2);
	}

	private void carregarListaInstructionCodeVO() {
		InstructionCodeVO ic1 = new InstructionCodeVO();
		ic1.setOccur("1");
		ic1.setCode("TEJI");
		ic1.setInstruction("3226553478");
		viewHelper.getListaInstructionCodeVO().add(ic1);
		InstructionCodeVO ic2 = new InstructionCodeVO();
		ic2.setOccur("2");
		ic2.setCode("");
		ic2.setInstruction("");
		viewHelper.getListaInstructionCodeVO().add(ic2);
	}

	private void carregarListaTimeIndicationVO() {
		TimeIndicationVO ti1 = new TimeIndicationVO();
		ti1.setOccur("1");
		ti1.setCode("CLSTIME");
		ti1.setTime("09:15");
		ti1.setSign("+");
		ti1.setOffset("0100");
		viewHelper.getListaTimeIndicationVO().add(ti1);
		TimeIndicationVO ti2 = new TimeIndicationVO();
		ti2.setOccur("2");
		ti2.setCode("CLSTIME");
		ti2.setTime("08:50");
		ti2.setSign("");
		ti2.setOffset("");
		viewHelper.getListaTimeIndicationVO().add(ti2);
		TimeIndicationVO ti3 = new TimeIndicationVO();
		ti3.setOccur("3");
		ti3.setCode("");
		ti3.setTime("");
		ti3.setSign("");
		ti3.setOffset("");
		viewHelper.getListaTimeIndicationVO().add(ti3);
	}

	public String voltar() {
		return paginaAnterior;
	}

	public void habilitarBotoesTimeIndication(AjaxBehaviorEvent ae) {
		this.viewHelper.setBtnRemoverTimeIndication(Boolean.FALSE);
		if (!this.viewHelper.getTimeIndicationSelecionado().isEmpty()) {
			this.viewHelper.setBtnRemoverTimeIndication(Boolean.TRUE);
		}
	}

	public void habilitarBotoesInstructionCode(AjaxBehaviorEvent ae) {
		this.viewHelper.setBtnRemoverInstructionCode(Boolean.FALSE);
		if (!this.viewHelper.getInstructionCodeSelecionado().isEmpty()) {
			this.viewHelper.setBtnRemoverInstructionCode(Boolean.TRUE);
		}
	}

	public void habilitarBotoesSendersCharges(AjaxBehaviorEvent ae) {
		this.viewHelper.setBtnRemoverSendersCharges(Boolean.FALSE);
		if (!this.viewHelper.getSendersChargesSelecionado().isEmpty()) {
			this.viewHelper.setBtnRemoverSendersCharges(Boolean.TRUE);
		}
	}

}