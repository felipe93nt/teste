package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.consultas.divisaoInternacional;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.divisaoInternacional.IConsultasDivisaoInternacionalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.divisaoInternacional.bean.ConsultaDivInternacFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.divisaoInternacional.bean.ConsultaDivInternacVO;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.components.CalendarioPeriodo;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.view.bean.SelectItemBean;
import br.com.bradesco.web.npcd.view.bean.BaseBean;

@Named("consultaDivInternacBean")
@SessionScoped
public class ConsultaDivInternacBean extends BaseBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 7846264074721883074L;
    
    private ConsultaDivInternacVO consulta = new ConsultaDivInternacVO();
    private ConsultaDivInternacFiltroVO filtroVO = new ConsultaDivInternacFiltroVO();
    private ConsultaDivInternacViewHelper viewHelper = new ConsultaDivInternacViewHelper();

    @Inject
    @Named("selectItemBean")
    protected SelectItemBean selectItemBean;

    @Inject
    @Named("consultasDivisaoInternacionalService")
    private IConsultasDivisaoInternacionalService consultasDivisaoInternacionalService;

    /**
     * 
     * Nome: iniciar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/08/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String iniciar() {

        try {
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ConsultaDivInternacBean.iniciar <<<<<<<<<<<");
            
            // Recarrega página se não for um postback ou se foi marcado para recaregar
            if (!isPostback() || getIniciarPagina()) {
                setIniciarPagina(false);
            }
                       
            getViewHelper().setComboTipoCotacao(selectItemBean.getCodigoTipoCotacao());
            getViewHelper().setComboStatus(selectItemBean.getListaSituacaoBoleto());
            getViewHelper().setComboProduto(selectItemBean.getProduto(
                                                    EnumProduto.CODIGO_DA_MESA_MESA_TRADE.getCodigo(),
                                                    EnumProduto.CODIGO_CAMBIO_ZERO.getCodigo(),
                                                    EnumProduto.CODIGO_COMPRA_VENDA_ZERO.getCodigo()));

            return "consultaDivInternacList";

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ConsultaDivInternacBean.iniciar <<<<<<<<<<<");
        }
        
    }

    /**
     * Nome: pesquisar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void pesquisar(AjaxBehaviorEvent event) {
        
        try {
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ConsultaDivInternacBean.pesquisar  <<<<<<<<<<<");
            
            filtroVO.setDtperini(SiteUtil.dataWebToMainframe(viewHelper.getPeriodoCotacao().getInicio()));
            filtroVO.setDtperfim(SiteUtil.dataWebToMainframe(viewHelper.getPeriodoCotacao().getFim()));
            consulta = consultasDivisaoInternacionalService.getListaCotacoesDivisaoInternacional(filtroVO);
    
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ConsultaDivInternacBean.pesquisar  <<<<<<<<<<<");
        }
    }

    /**
     * 
     * Nome: paginar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void paginar(ActionEvent event) {
        
        try {
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ConsultaDivInternacBean.paginar  <<<<<<<<<<<");
            
            consulta = consultasDivisaoInternacionalService.getListaCotacoesDivisaoInternacional(filtroVO);

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ConsultaDivInternacBean.paginar  <<<<<<<<<<<");
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
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ConsultaDivInternacBean.exportar  <<<<<<<<<<<");
            
            filtroVO.setDtperini(SiteUtil.dataWebToMainframe(viewHelper.getPeriodoCotacao().getInicio()));
            filtroVO.setDtperfim(SiteUtil.dataWebToMainframe(viewHelper.getPeriodoCotacao().getFim()));
            
            consulta = consultasDivisaoInternacionalService.getListaCotacoesDivisaoInternacional(filtroVO);
    
            BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("lista1", consulta.getListaCotacoes());        
            BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("lista2", consulta.getListaTotais());        
    
            return "divisaoInternacionalListExportTemplate";
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ConsultaDivInternacBean.exportar  <<<<<<<<<<<");
        }
    }

    /**
     * Nome: imprimir
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
    public String imprimir() {    

        try {
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ConsultaDivInternacBean.imprimir  <<<<<<<<<<<");
            
            filtroVO.setDtperini(SiteUtil.dataWebToMainframe(viewHelper.getPeriodoCotacao().getInicio()));
            filtroVO.setDtperfim(SiteUtil.dataWebToMainframe(viewHelper.getPeriodoCotacao().getFim()));
            
            consulta = consultasDivisaoInternacionalService.getListaCotacoesDivisaoInternacional(filtroVO);
    
            BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("lista1", consulta.getListaCotacoes());        
            BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("lista2", consulta.getListaTotais());        
    
            return "divisaoInternacionalListPrintTemplate";
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ConsultaDivInternacBean.imprimir  <<<<<<<<<<<");
        }
    }

    /**
     * Nome: listenerLimparPesquisa
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 01/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerLimparPesquisa(AjaxBehaviorEvent e) {
        
        try {
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ConsultaDivInternacBean.listenerLimparPesquisa <<<<<<<<<<<");
            
            filtroVO = new ConsultaDivInternacFiltroVO();
            viewHelper.setPeriodoCotacao(new CalendarioPeriodo());
            consulta = new ConsultaDivInternacVO();
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ConsultaDivInternacBean.listenerLimparPesquisa <<<<<<<<<<<");
        }
            
    }
      
    /**
     * @return o valor do consulta
     */
    public ConsultaDivInternacVO getConsulta() {
        return consulta;
    }

    /**
     * @param consulta seta o novo valor para o campo consulta
     */
    public void setConsulta(ConsultaDivInternacVO consulta) {
        this.consulta = consulta;
    }

    /**
     * @return o valor do filtroVO
     */
    public ConsultaDivInternacFiltroVO getFiltroVO() {
        return filtroVO;
    }

    /**
     * @param filtroVO seta o novo valor para o campo filtroVO
     */
    public void setFiltroVO(ConsultaDivInternacFiltroVO filtroVO) {
        this.filtroVO = filtroVO;
    }

    /**
     * @return o valor do viewHelper
     */
    public ConsultaDivInternacViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * @param viewHelper seta o novo valor para o campo viewHelper
     */
    public void setViewHelper(ConsultaDivInternacViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

}
