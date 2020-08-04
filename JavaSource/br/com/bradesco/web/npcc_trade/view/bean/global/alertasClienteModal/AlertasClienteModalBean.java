/**
 * Nome: br.com.bradesco.web.npcc.view.bean.global.alertasClienteModal
 * Propósito: Classe comum para o controle do modal de cliente
 * Data da Criação: 05/01/2016
 *
 * @author BRQ
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Parâmetros de Compilação: -d
 */
package br.com.bradesco.web.npcc_trade.view.bean.global.alertasClienteModal;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.com.bradesco.web.aq.view.context.BradescoFacesContext;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
 *
 * Nome: AlertasClienteModalBean
 * 
 * Propósito: Bean de controle para modal de cliente
 *
 * Data: 05/01/2016 <br/>
 * 
 * @author BRQ <br/>
 *         copyright Copyright (c) 2016 <br/>
 *
 * @version 1.0
 * @see
 */
@Named(value = "alertasClienteModalBean")
@SessionScoped
public class AlertasClienteModalBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;

    /** Variavel de auxilio a tela */
    private AlertasClienteModalViewHelper viewHelper = new AlertasClienteModalViewHelper();

    /**
     * Nome: openModal
     * 
     * Propósito: Efetua pesquisa do cliente
     *
     * @param : 
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 05/01/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void openModal(AjaxBehaviorEvent event) {
        // recupera o código do cliente
        Long codigoCliente = SiteUtil.getLong(event.getComponent().getAttributes().get("paramCodPessoaAlertas"));

        carregarDados(codigoCliente);
    }

    /**
     * Nome: openModal
     * 
     * Propósito: Efetua pesquisa do cliente
     *
     * @param : 
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 05/01/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void openModal(Long codigoCliente) {

        carregarDados(codigoCliente);
    }
    
    /**
     * Nome: closeModalCliente
     * 
     * Propósito: Fecha modal cliente
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 05/01/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModal() {

        getViewHelper().setUrl(SiteUtil.STRING_EMPTY);
        getViewHelper().setRenderModal(Boolean.FALSE);
    }
    
    private void carregarDados(Long codigoCliente) {
        StringBuilder url = new StringBuilder();
        
        // valida cliente selecionado
        if (codigoCliente == Numeros.NUM0_LONG) {

            NpcFacesUtils.addInfoModalMessage("Selecione um cliente.", false);

        // monta url de acesso ao alertas de cliente
        } else {
            
            /** HABILITAR QUANDO ESTENDER O BASE BEAN
             * Raiz de contexto NPCP
             * Ex: http://localhost:8080 
             */
            String contextPath = getBaseUrl();
            url.append(contextPath);

            /** REMOVER QUANDO ESTENDER O BASE BEAN
             * Raiz de contexto NPCP
             * Ex: http://localhost:8080/npcp 
             */
            //String contextPath = SiteUtil.getApplicationProperty("npcp.contextPath"); 
            //url.append(contextPath);

            /**
             * URL pagina alertas de clientes
             * EX: /content/relatorioauditor/alertaClienteRelAuditor.xhtml?codigoPessoaCambio=0001
             */
            String urlRel = SiteUtil.getApplicationProperty("npcp.url.alertasCliente");
            if(!contextPath.endsWith("/npcp") && !urlRel.startsWith("/npcp")) {
                url.append("/npcp");
            }
            url.append(urlRel);

            // parametro codigo pessoal
            url.append("?codigoPessoaCambio=");
            url.append(codigoCliente);

            getViewHelper().setUrl(url.toString());
            getViewHelper().setRenderModal(Boolean.TRUE);
        }
    }

    /**
     * @return o valor do viewHelper
     */
    public AlertasClienteModalViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * @param viewHelper
     *            seta o novo valor para o campo viewHelper
     */
    public void setViewHelper(AlertasClienteModalViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }
    
    /**
     * REMOVER QUANDO ESSE BEAN ESTENDER O BaseBean.java
     * 
     * @return Retorna URL Base do servidor
     */
    @Deprecated
    private String getBaseUrl() {
        StringBuffer buffer = new StringBuffer();
        
        // recupera o contexto http
        HttpServletRequest request = (HttpServletRequest)BradescoFacesContext.getCurrentInstance().getExternalContext().getRequest();

        buffer.append(request.getScheme());
        buffer.append("://");
        buffer.append(request.getServerName());

        if (request.getServerPort() != 80){
            buffer.append(":");
            buffer.append(request.getServerPort());
        }
        
        return buffer.toString();
    }

}