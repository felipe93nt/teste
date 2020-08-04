package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.consultas.estatisticasCotacoes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.estatisticasCotacoes.bean.EstatisticasCotacoesFechadaPerdidaVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.estatisticasCotacoes.bean.EstatisticaCotacoesVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.estatisticasCotacoes.impl.EstatisticasCotacoesServiceImpl;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.components.CalendarioPeriodo;
import br.com.bradesco.web.npcd.view.bean.BaseBean;

@Named("estatisticasCotacoesBean")
@SessionScoped
public class EstatisticasCotacoesBean extends BaseBean implements Serializable{

	private static final long serialVersionUID = 527085209118928669L;
	
	private EstatisticaCotacoesVO estatisticaCotacoesVO = new EstatisticaCotacoesVO();
	private List<EstatisticasCotacoesFechadaPerdidaVO> listaCotacoesFechadasPerdidas = new ArrayList<EstatisticasCotacoesFechadaPerdidaVO>();
    private EstatisticasCotacoesViewHelper viewHelper = new EstatisticasCotacoesViewHelper();
    
	@Inject
    @Named("estatisticasCotacoesServiceImpl")
    private EstatisticasCotacoesServiceImpl estatisticasCotacoesServiceImpl;
	
	public String iniciar() {

        try{
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] EstatisticasCotacoesBean.iniciar <<<<<<<<<<<");
            
//          Recarrega página se não for um postback ou se foi marcado para recaregar
            if (!isPostback() || getIniciarPagina()) {
            	viewHelper = new EstatisticasCotacoesViewHelper();
                setIniciarPagina(false);
        		estatisticaCotacoesVO = new EstatisticaCotacoesVO();
        		listaCotacoesFechadasPerdidas = new ArrayList<EstatisticasCotacoesFechadaPerdidaVO>();
            }
            return "estatisticasCotacoesList";

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] EstatisticasCotacoesBean.iniciar <<<<<<<<<<<");
        }		

	}
	
	public void limparGridConsulta(AjaxBehaviorEvent e){
		
		viewHelper.setAnoBase(0);
		viewHelper.setPeriodoCotacao(new CalendarioPeriodo());
		estatisticaCotacoesVO = new EstatisticaCotacoesVO();
		listaCotacoesFechadasPerdidas = new ArrayList<EstatisticasCotacoesFechadaPerdidaVO>();
		
	}

	public void pesquisarCotacoes(AjaxBehaviorEvent e) {
    	
        try{
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] EstatisticasCotacoesBean.PesquisarEstatiscitasCotacoes <<<<<<<<<<<");
            
            estatisticaCotacoesVO = new EstatisticaCotacoesVO();
            
            String validationMessage = SiteUtil.STRING_EMPTY;
            Boolean isValid = true;
            
            if(viewHelper.getPeriodoCotacao() == null || viewHelper.getPeriodoCotacao().getInicio() == null || viewHelper.getPeriodoCotacao().getFim() == null){
            	validationMessage = "É obrigatório informar um Período para realizar a pesquisa.";
            	isValid = false;
            }else if(viewHelper.getPeriodoCotacao().getFim().before(viewHelper.getPeriodoCotacao().getInicio())){
            	validationMessage = "Data final do Período maior que Data inicial .";
            	isValid = false;
            }
            
            // exibe o modal com as mensagems lançadas pelas validações.
	        if (!isValid) {
	            BradescoFacesUtils.addInfoModalMessage(validationMessage, false);
	        }else{
	        	estatisticaCotacoesVO = estatisticasCotacoesServiceImpl.getEstatisticasCotacoes(viewHelper.getPeriodoCotacao(), viewHelper.getCodTipoConsultaSelecionads());
	    
	               if(viewHelper.getCodTipoConsultaSelecionads() == Numeros.UM){
	            	   estatisticaCotacoesVO.setNomedocampo("Produto");
	               }else{
	            	   estatisticaCotacoesVO.setNomedocampo("Operador");
	               }
	        	
	        	if(estatisticaCotacoesVO.getCotacoes().size() < Numeros.UM){
	        		BradescoFacesUtils.addInfoModalMessage("Não existe informações para a pesquisa efetuada!!!", false);
	        	}
	        
	        }
	

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] EstatisticasCotacoesBean.PesquisarEstatiscitasCotacoes <<<<<<<<<<<");
        }
    	
    }

	public void pesquisarCotacoesFechadasPendentes(AjaxBehaviorEvent e) {
		
		try{
			
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] EstatisticasCotacoesBean.PesquisarEstatiscitasCotacoesFechadasPendentes <<<<<<<<<<<");
			
			String validationMessage = SiteUtil.STRING_EMPTY;
			Boolean isValid = true;
			
			listaCotacoesFechadasPerdidas = new ArrayList<EstatisticasCotacoesFechadaPerdidaVO>();
			
			if(SiteUtil.isEmptyOrNull(viewHelper.getAnoBase())){
				validationMessage = "É obrigatório informar o Ano Base para realizar a pesquisa.";
				isValid = false;
			}else if(viewHelper.getAnoBase().toString().length() != 4){
				validationMessage = "Ano Base é inválido.";
				isValid = false;
			}
			
			// exibe o modal com as mensagems lançadas pelas validações.
	        if (!isValid) {
	            BradescoFacesUtils.addInfoModalMessage(validationMessage, false);
	        }else{
	        	listaCotacoesFechadasPerdidas.addAll(estatisticasCotacoesServiceImpl.getEstatisticasCotacoesFechadasPerdidas(viewHelper.getAnoBase()));
	        
	        	if(listaCotacoesFechadasPerdidas.size() < Numeros.UM){
	        		BradescoFacesUtils.addInfoModalMessage("Não existe informações para a pesquisa efetuada!!!", false);
	        	}
	        	
	        }
			
		}finally{
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] EstatisticasCotacoesBean.PesquisarEstatiscitasCotacoesFechadasPendentes <<<<<<<<<<<");
		}
		
	}
	
    /**
     * Nome: exportar
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas. 
     *
     *      Registro de Manutenção: 02/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String exportar() {    

        try {
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] EstatisticasCotacoesBean.exportar  <<<<<<<<<<<");
			String retorno = "estatisticasCotacoesProdutoOperadorListExportTemplate";
            
			if (viewHelper.getCodTipoConsultaSelecionads() <= Numeros.DOIS) {
				
				BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("listaCotacoesEstatisticasProdutoOperador", estatisticaCotacoesVO.getCotacoes());
				BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("listaCotacoesEstatisticasTotais", estatisticaCotacoesVO);

				retorno = "estatisticasCotacoesProdutoOperadorListExportTemplate";

			} else {

				BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("listaCotacoesEstatisticasFechadasPerdidas", listaCotacoesFechadasPerdidas);

				retorno = "estatisticasCotacoesFechadasPerdidasListExportTemplate";
			}
            return retorno;
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] EstatisticasCotacoesBean.exportar  <<<<<<<<<<<");
        }
    }
	
	public EstatisticaCotacoesVO getEstatisticaCotacoesVO() {
		return estatisticaCotacoesVO;
	}

	public void setEstatisticaCotacoesVO(EstatisticaCotacoesVO estatisticaCotacoesVO) {
		this.estatisticaCotacoesVO = estatisticaCotacoesVO;
	}

	public List<EstatisticasCotacoesFechadaPerdidaVO> getListaCotacoesFechadasPerdidas() {
		return listaCotacoesFechadasPerdidas;
	}

	public void setListaCotacoesFechadasPerdidas(
			List<EstatisticasCotacoesFechadaPerdidaVO> listaCotacoesFechadasPerdidas) {
		this.listaCotacoesFechadasPerdidas = listaCotacoesFechadasPerdidas;
	}

	public EstatisticasCotacoesViewHelper getViewHelper() {
		return viewHelper;
	}
	public void setViewHelper(EstatisticasCotacoesViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}
	

	
	
}
