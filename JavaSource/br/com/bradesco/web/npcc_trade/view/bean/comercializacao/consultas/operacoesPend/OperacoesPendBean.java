package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.consultas.operacoesPend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.OperacoesPend.IOperacoesPendService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.OperacoesPend.bean.OperacoesPendTotaisVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.OperacoesPend.bean.OperacoesPendVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumPendTotais;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.view.bean.SelectItemBean;
import br.com.bradesco.web.npcd.view.bean.BaseBean;

@Named("operacoesPendBean")
@SessionScoped
public class OperacoesPendBean extends BaseBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 7846264074721883074L;

    private List<OperacoesPendVO> lista = new ArrayList<OperacoesPendVO>();
    private List<OperacoesPendTotaisVO> listaOperDeDesembolsadas = new ArrayList<OperacoesPendTotaisVO>();
    private List<OperacoesPendTotaisVO> listaTotaisGeraisDeDesembolsadas = new ArrayList<OperacoesPendTotaisVO>();
    private List<OperacoesPendTotaisVO> listaOperDesembolsar = new ArrayList<OperacoesPendTotaisVO>();
    private List<OperacoesPendTotaisVO> listaTotaisGeraisDesembolsar = new ArrayList<OperacoesPendTotaisVO>();
    private OperacoesPendViewHelper viewhelper = new OperacoesPendViewHelper();

    @Inject
    @Named("operacoesPendService")
    private IOperacoesPendService operacoesPendService;

    @Inject
    @Named("selectItemBean")
    protected SelectItemBean selectItemBean;
    
    public String iniciar() {

        try {

            BradescoCommonServiceFactory.getLogManager().info(
                    ">>>>>>>>>>>  [Inicio] OperacoesPendBean.iniciar <<<<<<<<<<<");

            // Recarrega página se não for um postback ou se foi marcado para
            // recaregar
            if (!isPostback() || getIniciarPagina()) {
                setIniciarPagina(false);

                setListaOperDeDesembolsadas(new ArrayList<OperacoesPendTotaisVO>());
                setListaTotaisGeraisDeDesembolsadas(new ArrayList<OperacoesPendTotaisVO>());
                setListaOperDesembolsar(new ArrayList<OperacoesPendTotaisVO>());
                setListaTotaisGeraisDesembolsar(new ArrayList<OperacoesPendTotaisVO>());
                setLista(null);
                viewhelper = new OperacoesPendViewHelper();
            }

            viewhelper.setComboProduto(selectItemBean.getProduto(EnumProduto.CODIGO_DA_MESA_MESA_TRADE.getCodigo(),
                    EnumProduto.CODIGO_CAMBIO_ZERO.getCodigo(), EnumProduto.CODIGO_COMPRA_VENDA_ZERO.getCodigo()));
            viewhelper.setComboSituacao(selectItemBean.getSituacao());

            return "operacoesPendlist";

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                    ">>>>>>>>>>>  [Fim] OperacoesPendBean.iniciar <<<<<<<<<<<");
        }
    }

    public void PesquisarOperacoesPend(AjaxBehaviorEvent e) {

        try {
            BradescoCommonServiceFactory.getLogManager().info(
                    ">>>>>>>>>>>  [Inicio] PesquisarOperacoesPend.iniciar pesquisa <<<<<<<<<<<");

            setLista(new ArrayList<OperacoesPendVO>());
            setLista(operacoesPendService.getOperacoesPend(viewhelper));

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                    ">>>>>>>>>>>  [Fim] PesquisarOperacoesPend.iniciar pesquisa <<<<<<<<<<<");
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
     *      Registro de Manutenção: 08/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void paginar(ActionEvent event) {

        setLista(operacoesPendService.getOperacoesPend(viewhelper));
    }

    public void PesquisarOperacoesPendTotais() {

        try {

            BradescoCommonServiceFactory.getLogManager().info(
                    ">>>>>>>>>>>  [Inicio] PesquisarOperacoesPendTotais.iniciar pesquisa <<<<<<<<<<<");

            setListaOperDeDesembolsadas(null);
            setListaTotaisGeraisDeDesembolsadas(null);
            setListaOperDesembolsar(null);
            setListaTotaisGeraisDesembolsar(null);

            if (viewhelper.getCsitbletocmbio().equals(Numeros.UM)) {

                setListaOperDesembolsar(operacoesPendService.getOperacoesPendTotais(viewhelper,
                        EnumPendTotais.OPERACOES_A_DESEMBOLSAR.getCodigo()));

                setListaTotaisGeraisDesembolsar(operacoesPendService.getOperacoesPendTotais(viewhelper,
                        EnumPendTotais.TOTAIS_GERAIS_A_DESEMBOLSAR.getCodigo()));

            } else if (viewhelper.getCsitbletocmbio().equals(Numeros.DOIS)) {

                setListaOperDeDesembolsadas(operacoesPendService.getOperacoesPendTotais(viewhelper,
                        EnumPendTotais.OPERACOES_DE_DESEMBOLSADAS.getCodigo()));

                setListaTotaisGeraisDeDesembolsadas(operacoesPendService.getOperacoesPendTotais(viewhelper,
                        EnumPendTotais.TOTAIS_GERAIS_DE_DESEMBOLSADAS.getCodigo()));

            } else {

                setListaOperDeDesembolsadas(operacoesPendService.getOperacoesPendTotais(viewhelper,
                        EnumPendTotais.OPERACOES_DE_DESEMBOLSADAS.getCodigo()));

                setListaTotaisGeraisDeDesembolsadas(operacoesPendService.getOperacoesPendTotais(viewhelper,
                        EnumPendTotais.TOTAIS_GERAIS_DE_DESEMBOLSADAS.getCodigo()));
                setListaOperDesembolsar(operacoesPendService.getOperacoesPendTotais(viewhelper,
                        EnumPendTotais.OPERACOES_A_DESEMBOLSAR.getCodigo()));

                setListaTotaisGeraisDesembolsar(operacoesPendService.getOperacoesPendTotais(viewhelper,
                        EnumPendTotais.TOTAIS_GERAIS_A_DESEMBOLSAR.getCodigo()));
            }

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                    ">>>>>>>>>>>  [Fim] PesquisarOperacoesPendTotais.iniciar pesquisa <<<<<<<<<<<");
        }

    }

    public String imprimir() {
        try {
            BradescoCommonServiceFactory.getLogManager().info(
                    ">>>>>>>>>>>  [Inicio] OperacoesPendBean.imprimir <<<<<<<<<<<");

            viewhelper.setDprevtdsembi(SiteUtil.dataWebToMainframe(viewhelper.getPeriodoCotacao().getInicio()));
            viewhelper.setDprevtdsembf(SiteUtil.dataWebToMainframe(viewhelper.getPeriodoCotacao().getFim()));

            setLista(operacoesPendService.getOperacoesPend(viewhelper));

            BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("lista1", getLista());

            return "operacoesPendListPrintTemplate";

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                    ">>>>>>>>>>>  [Fim] OperacoesPendBean.imprimir <<<<<<<<<<<");
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
     *      Registro de Manutenção: 08/07/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String exportar() {

        BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("lista1",
                operacoesPendService.pesquisarCotacoesExportacao(getViewhelper()));

        return "operacoesPendListPrintTemplate";
    }

    /**
     * 
     * Nome: openModalUnidadeExterna
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void openModalPendTotais(AjaxBehaviorEvent ajaxBehaviorEvent) {

        try {

            BradescoCommonServiceFactory.getLogManager().info(
                    ">>>>>>>>>>>  [Inicio] OperacoesPendBean.openModalPendTotais<<<<<<<<<<<");

            PesquisarOperacoesPendTotais();
            getViewhelper().setModalId("formConsultaOperacoesPend\\:content_modalPendTotais");
            getViewhelper().setRenderModal(Boolean.TRUE);

        } finally {
            BradescoCommonServiceFactory.getLogManager().info(
                    ">>>>>>>>>>>  [Fim] OperacoesPendBean.openModalPendTotais <<<<<<<<<<<");
        }
    }

    /**
     * 
     * Nome: closeModal
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModal(ActionEvent event) {
        getViewhelper().setRenderModal(Boolean.FALSE);
    }

    public List<OperacoesPendVO> getLista() {
        return lista;
    }

    public void setLista(List<OperacoesPendVO> lista) {
        this.lista = lista;
    }

    public OperacoesPendViewHelper getViewhelper() {
        return viewhelper;
    }

    public void setViewhelper(OperacoesPendViewHelper viewHelper) {
        this.viewhelper = viewHelper;
    }

    public List<OperacoesPendTotaisVO> getListaOperDeDesembolsadas() {
        return listaOperDeDesembolsadas;
    }

    public void setListaOperDeDesembolsadas(List<OperacoesPendTotaisVO> listaOperDeDesembolsadas) {
        this.listaOperDeDesembolsadas = listaOperDeDesembolsadas;
    }

    public List<OperacoesPendTotaisVO> getListaTotaisGeraisDeDesembolsadas() {
        return listaTotaisGeraisDeDesembolsadas;
    }

    public void setListaTotaisGeraisDeDesembolsadas(List<OperacoesPendTotaisVO> listaTotaisGeraisDeDesembolsadas) {
        this.listaTotaisGeraisDeDesembolsadas = listaTotaisGeraisDeDesembolsadas;
    }

    public List<OperacoesPendTotaisVO> getListaOperDesembolsar() {
        return listaOperDesembolsar;
    }

    public void setListaOperDesembolsar(List<OperacoesPendTotaisVO> listaOperDesembolsar) {
        this.listaOperDesembolsar = listaOperDesembolsar;
    }

    public List<OperacoesPendTotaisVO> getListaTotaisGeraisDesembolsar() {
        return listaTotaisGeraisDesembolsar;
    }

    public void setListaTotaisGeraisDesembolsar(List<OperacoesPendTotaisVO> listaTotaisGeraisDesembolsar) {
        this.listaTotaisGeraisDesembolsar = listaTotaisGeraisDesembolsar;
    }
}
