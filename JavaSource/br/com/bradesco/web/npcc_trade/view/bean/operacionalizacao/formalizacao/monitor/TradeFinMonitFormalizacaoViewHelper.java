package br.com.bradesco.web.npcc_trade.view.bean.operacionalizacao.formalizacao.monitor;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;


/**
 * 
  * Nome: TradeFinMonitViewHelper.java
  * 
  * Propósito: <p> </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilação -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manutenção: 31/12/2015
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
 */
public class TradeFinMonitFormalizacaoViewHelper {
	
	private String valueMaisMenosFluxoPagto = "+";
	
	private String valueMaisMenosPrecificacao = "+";
	
	private String valueMaisMenosComissaoInterna = "+";
	
	private String valueMaisMenosMercadoria = "+";
	
	private String valueMaisMenosOperacaoVinculada = "+";

    private String valueMaisMenosResponsavelEmpresa = "+";
	
	private String valueMaisMenosTarifas = "+";
	
    private String valueMaisMenosComissao = "+";
    
    private boolean renderFluxoPagto = true;
    
    private boolean renderPrecificacao = true;
    
    private boolean renderComissaoInterna = true;
    
    private boolean renderMercadoria = true;
    
    private boolean renderOperacaoVinculada = true;
    
    private boolean renderResponsavelEmpresa = true;
    
    private boolean renderTarifas = true;
    
    private boolean renderComissao = true;
    
    private boolean renderFechar = false;
    
    private boolean renderModalFluxoPgt = false;
    
    private boolean renderModalComissaoInt = false;
    
    private boolean renderModalComissaoExt = false;
    
    private boolean renderModalGarantias = false;
    
    private Integer fluxoPgtSelecionado;
    
    private Integer comissaoIntSelecionado;
    
    private Integer comissaoExtSelecionado;
    
    private String descricaoMomento;
    private String filtroMoeda;
    
    private String filtroMotivoPerda;
    
    private boolean renderModalDevolver = false;
    
    /**
     * Variável de controle do modal de confirmação
     */
    
 
    private List<SelectItem> comboMoedaItens = new ArrayList<SelectItem>();
    private List<SelectItem> comboMotivosPerdaItens = new ArrayList<SelectItem>();
    
    private Integer refSelecionado;
    
	public String getValueMaisMenosFluxoPagto() {
		return valueMaisMenosFluxoPagto;
	}

	public void setValueMaisMenosFluxoPagto(String valueMaisMenosFluxoPagto) {
		this.valueMaisMenosFluxoPagto = valueMaisMenosFluxoPagto;
	}

	public String getValueMaisMenosPrecificacao() {
		return valueMaisMenosPrecificacao;
	}

	public void setValueMaisMenosPrecificacao(String valueMaisMenosPrecificacao) {
		this.valueMaisMenosPrecificacao = valueMaisMenosPrecificacao;
	}

	public String getValueMaisMenosComissaoInterna() {
		return valueMaisMenosComissaoInterna;
	}

	public void setValueMaisMenosComissaoInterna(
			String valueMaisMenosComissaoInterna) {
		this.valueMaisMenosComissaoInterna = valueMaisMenosComissaoInterna;
	}

	public String getValueMaisMenosMercadoria() {
		return valueMaisMenosMercadoria;
	}

	public void setValueMaisMenosMercadoria(String valueMaisMenosMercadoria) {
		this.valueMaisMenosMercadoria = valueMaisMenosMercadoria;
	}

	public String getValueMaisMenosOperacaoVinculada() {
		return valueMaisMenosOperacaoVinculada;
	}

	public void setValueMaisMenosOperacaoVinculada(
			String valueMaisMenosOperacaoVinculada) {
		this.valueMaisMenosOperacaoVinculada = valueMaisMenosOperacaoVinculada;
	}

	public String getValueMaisMenosResponsavelEmpresa() {
		return valueMaisMenosResponsavelEmpresa;
	}

	public void setValueMaisMenosResponsavelEmpresa(
			String valueMaisMenosResponsavelEmpresa) {
		this.valueMaisMenosResponsavelEmpresa = valueMaisMenosResponsavelEmpresa;
	}

	public String getValueMaisMenosTarifas() {
		return valueMaisMenosTarifas;
	}

	public void setValueMaisMenosTarifas(String valueMaisMenosTarifas) {
		this.valueMaisMenosTarifas = valueMaisMenosTarifas;
	}

	public String getValueMaisMenosComissao() {
		return valueMaisMenosComissao;
	}

	public void setValueMaisMenosComissao(String valueMaisMenosComissao) {
		this.valueMaisMenosComissao = valueMaisMenosComissao;
	}

	public boolean isRenderFluxoPagto() {
		return renderFluxoPagto;
	}

	public void setRenderFluxoPagto(boolean renderFluxoPagto) {
		this.renderFluxoPagto = renderFluxoPagto;
	}

	public boolean isRenderPrecificacao() {
		return renderPrecificacao;
	}

	public void setRenderPrecificacao(boolean renderPrecificacao) {
		this.renderPrecificacao = renderPrecificacao;
	}

	public boolean isRenderComissaoInterna() {
		return renderComissaoInterna;
	}

	public void setRenderComissaoInterna(boolean renderComissaoInterna) {
		this.renderComissaoInterna = renderComissaoInterna;
	}

	public boolean isRenderMercadoria() {
		return renderMercadoria;
	}

	public void setRenderMercadoria(boolean renderMercadoria) {
		this.renderMercadoria = renderMercadoria;
	}

	public boolean isRenderOperacaoVinculada() {
		return renderOperacaoVinculada;
	}

	public void setRenderOperacaoVinculada(boolean renderOperacaoVinculada) {
		this.renderOperacaoVinculada = renderOperacaoVinculada;
	}

	public boolean isRenderResponsavelEmpresa() {
		return renderResponsavelEmpresa;
	}

	public void setRenderResponsavelEmpresa(boolean renderResponsavelEmpresa) {
		this.renderResponsavelEmpresa = renderResponsavelEmpresa;
	}

	public boolean isRenderTarifas() {
		return renderTarifas;
	}

	public void setRenderTarifas(boolean renderTarifas) {
		this.renderTarifas = renderTarifas;
	}

	public boolean isRenderComissao() {
		return renderComissao;
	}

	public void setRenderComissao(boolean renderComissao) {
		this.renderComissao = renderComissao;
	}

	public boolean isRenderFechar() {
		return renderFechar;
	}

	public void setRenderFechar(boolean renderFechar) {
		this.renderFechar = renderFechar;
	}

	public boolean isRenderModalFluxoPgt() {
		return renderModalFluxoPgt;
	}

	public void setRenderModalFluxoPgt(boolean renderModalFluxoPgt) {
		this.renderModalFluxoPgt = renderModalFluxoPgt;
	}

	public boolean isRenderModalComissaoInt() {
		return renderModalComissaoInt;
	}

	public void setRenderModalComissaoInt(boolean renderModalComissaoInt) {
		this.renderModalComissaoInt = renderModalComissaoInt;
	}

	public boolean isRenderModalComissaoExt() {
		return renderModalComissaoExt;
	}

	public void setRenderModalComissaoExt(boolean renderModalComissaoExt) {
		this.renderModalComissaoExt = renderModalComissaoExt;
	}

	public Integer getComissaoIntSelecionado() {
		return comissaoIntSelecionado;
	}

	public void setComissaoIntSelecionado(Integer comissaoIntSelecionado) {
		this.comissaoIntSelecionado = comissaoIntSelecionado;
	}

	public Integer getComissaoExtSelecionado() {
		return comissaoExtSelecionado;
	}

	public void setComissaoExtSelecionado(Integer comissaoExtSelecionado) {
		this.comissaoExtSelecionado = comissaoExtSelecionado;
	}

	public boolean isRenderModalGarantias() {
		return renderModalGarantias;
	}

	public void setRenderModalGarantias(boolean renderModalGarantias) {
		this.renderModalGarantias = renderModalGarantias;
	}

	public Integer getFluxoPgtSelecionado() {
		return fluxoPgtSelecionado;
	}

	public void setFluxoPgtSelecionado(Integer fluxoPgtSelecionado) {
		this.fluxoPgtSelecionado = fluxoPgtSelecionado;
	}

	public String getDescricaoMomento() {
		return descricaoMomento;
	}

	public void setDescricaoMomento(String descricaoMomento) {
		this.descricaoMomento = descricaoMomento;
	}

	public List<SelectItem> getComboMoedaItens() {
		return comboMoedaItens;
	}

	public void setComboMoedaItens(List<SelectItem> comboMoedaItens) {
		this.comboMoedaItens = comboMoedaItens;
	}

	public String getFiltroMoeda() {
		return filtroMoeda;
	}

	public void setFiltroMoeda(String filtroMoeda) {
		this.filtroMoeda = filtroMoeda;
	}

	public Integer getRefSelecionado() {
		return refSelecionado;
	}

	public void setRefSelecionado(Integer refSelecionado) {
		this.refSelecionado = refSelecionado;
	}

	public List<SelectItem> getComboMotivosPerdaItens() {
		return comboMotivosPerdaItens;
	}

	public void setComboMotivosPerdaItens(List<SelectItem> comboMotivosPerdaItens) {
		this.comboMotivosPerdaItens = comboMotivosPerdaItens;
	}

	public String getFiltroMotivoPerda() {
		return filtroMotivoPerda;
	}

	public void setFiltroMotivoPerda(String filtroMotivoPerda) {
		this.filtroMotivoPerda = filtroMotivoPerda;
	}


	public boolean isRenderModalDevolver() {
		return renderModalDevolver;
	}

	public void setRenderModalDevolver(boolean renderModalDevolver) {
		this.renderModalDevolver = renderModalDevolver;
	}
	
	
}
