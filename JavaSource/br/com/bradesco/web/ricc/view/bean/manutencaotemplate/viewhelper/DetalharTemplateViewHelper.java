package br.com.bradesco.web.ricc.view.bean.manutencaotemplate.viewhelper;

import java.util.ArrayList;
import java.util.List;

import br.com.bradesco.web.ricc.model.manutencao.InstructionCodeVO;
import br.com.bradesco.web.ricc.model.manutencao.SendersChargesVO;
import br.com.bradesco.web.ricc.model.manutencao.TimeIndicationVO;
import br.com.bradesco.web.ricc.view.bean.AbstractViewHelper;

public class DetalharTemplateViewHelper extends AbstractViewHelper {
	private static final long serialVersionUID = 4201953050604850242L;

	private Boolean btnRemoverTimeIndication = Boolean.FALSE;
	private List<TimeIndicationVO> timeIndicationSelecionado = new ArrayList<TimeIndicationVO>();
	private List<TimeIndicationVO> listaTimeIndicationVO = new ArrayList<TimeIndicationVO>();

	private Boolean btnRemoverInstructionCode = Boolean.FALSE;
	private List<InstructionCodeVO> instructionCodeSelecionado = new ArrayList<InstructionCodeVO>();
	private List<InstructionCodeVO> listaInstructionCodeVO = new ArrayList<InstructionCodeVO>();

	private Boolean btnRemoverSendersCharges = Boolean.FALSE;
	private List<SendersChargesVO> SendersChargesSelecionado = new ArrayList<SendersChargesVO>();
	private List<SendersChargesVO> listaSendersChargesVO = new ArrayList<SendersChargesVO>();

	private String textArea57 = "";
	private String textArea59 = "";
	private String textArea72 = "";
	private String textArea77 = "";
	private String textAreaTrailer = "";

	public Boolean getBtnRemoverInstructionCode() {
		return btnRemoverInstructionCode;
	}

	public void setBtnRemoverInstructionCode(Boolean btnRemoverInstructionCode) {
		this.btnRemoverInstructionCode = btnRemoverInstructionCode;
	}

	public List<InstructionCodeVO> getInstructionCodeSelecionado() {
		return instructionCodeSelecionado;
	}

	public void setInstructionCodeSelecionado(
			List<InstructionCodeVO> instructionCodeSelecionado) {
		this.instructionCodeSelecionado = instructionCodeSelecionado;
	}

	public List<InstructionCodeVO> getListaInstructionCodeVO() {
		return listaInstructionCodeVO;
	}

	public void setListaInstructionCodeVO(
			List<InstructionCodeVO> listaInstructionCodeVO) {
		this.listaInstructionCodeVO = listaInstructionCodeVO;
	}

	public Boolean getBtnRemoverTimeIndication() {
		return btnRemoverTimeIndication;
	}

	public void setBtnRemoverTimeIndication(Boolean btnRemoverTimeIndication) {
		this.btnRemoverTimeIndication = btnRemoverTimeIndication;
	}

	public List<TimeIndicationVO> getTimeIndicationSelecionado() {
		return timeIndicationSelecionado;
	}

	public void setTimeIndicationSelecionado(
			List<TimeIndicationVO> timeIndicationSelecionado) {
		this.timeIndicationSelecionado = timeIndicationSelecionado;
	}

	public List<TimeIndicationVO> getListaTimeIndicationVO() {
		return listaTimeIndicationVO;
	}

	public void setListaTimeIndicationVO(
			List<TimeIndicationVO> listaTimeIndicationVO) {
		this.listaTimeIndicationVO = listaTimeIndicationVO;
	}

	public String getTextArea57() {
		return textArea57;
	}

	public void setTextArea57(String textArea57) {
		this.textArea57 = textArea57;
	}

	public String getTextArea59() {
		return textArea59;
	}

	public void setTextArea59(String textArea5) {
		this.textArea59 = textArea5;
	}

	public String getTextArea72() {
		return textArea72;
	}

	public void setTextArea72(String textArea72) {
		this.textArea72 = textArea72;
	}

	public String getTextArea77() {
		return textArea77;
	}

	public void setTextArea77(String textArea77) {
		this.textArea77 = textArea77;
	}

	public List<SendersChargesVO> getListaSendersChargesVO() {
		return listaSendersChargesVO;
	}

	public void setListaSendersChargesVO(
			List<SendersChargesVO> listaSendersChargesVO) {
		this.listaSendersChargesVO = listaSendersChargesVO;
	}

	public Boolean getBtnRemoverSendersCharges() {
		return btnRemoverSendersCharges;
	}

	public void setBtnRemoverSendersCharges(Boolean btnRemoverSendersCharges) {
		this.btnRemoverSendersCharges = btnRemoverSendersCharges;
	}

	public List<SendersChargesVO> getSendersChargesSelecionado() {
		return SendersChargesSelecionado;
	}

	public void setSendersChargesSelecionado(
			List<SendersChargesVO> sendersChargesSelecionado) {
		SendersChargesSelecionado = sendersChargesSelecionado;
	}

	@Override
	public void inicializar() {

	}

	public String getTextAreaTrailer() {
		return textAreaTrailer;
	}

	public void setTextAreaTrailer(String textAreaTrailer) {
		this.textAreaTrailer = textAreaTrailer;
	}

}