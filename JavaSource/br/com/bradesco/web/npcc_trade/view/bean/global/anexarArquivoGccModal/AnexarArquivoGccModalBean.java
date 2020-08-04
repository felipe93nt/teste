package br.com.bradesco.web.npcc_trade.view.bean.global.anexarArquivoGccModal;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;

import br.com.bradesco.filenet.facade.ArrayOfArrayOfXsdNillableString;
import br.com.bradesco.filenet.facade.ArrayOfXsdNillableString;
import br.com.bradesco.web.aq.application.error.BradescoViewException.BradescoViewExceptionActionType;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeWebException;
import br.com.bradesco.web.npcc_trade.service.gcc.AnexarArquivoGccVO;
import br.com.bradesco.web.npcc_trade.service.gcc.ConnectorGcc;
import br.com.bradesco.web.npcc_trade.service.gcc.InfoDocumentoGccVO;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcd.utils.EnumButtonBehavior;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
 *   * Nome: AnexarArquivoGccModalBean.java
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
  * Registro  de Manutenção: 20/01/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
 */
@Named(value = "anexarArquivoGccModalBean")
@SessionScoped
public class AnexarArquivoGccModalBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;

    /** Variavel de auxilio a tela */
    private AnexarArquivoGccModalViewHelper viewHelper = new AnexarArquivoGccModalViewHelper();
    
    /** MODAL **/
    private AnexarArquivoGccVO parametros = null;
    
    private List<InfoDocumentoGccVO> listaAnexos = new ArrayList<InfoDocumentoGccVO>();
    
    /**
     * Injeção do conector GCC.
     */
    @Inject
    private ConnectorGcc connectorGcc;

    /**
     * Nome: openModal
     * 
     * Propósito: Efetua pesquisa de nome ou login do usuario
     *
     * @param : tipoPesquisa
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 05/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void openModal(AnexarArquivoGccVO parametros) {
    	
        if(parametros == null 
                || SiteUtil.isEmptyOrNull(parametros.getAnoMes())
                || SiteUtil.isEmptyOrNull(parametros.getNroBoleto())
                || parametros.getPasta() == null) {
            NpcFacesUtils.addInfoModalMessage("Parâmetros inválidos", false);
        } else {
            setParametros(parametros);
            
            // habilita modal do usuario
            viewHelper.setRenderModal(Boolean.TRUE);
        }
    }

    /**
     * 
     * Nome: selecionar
     * 
     * Propósito: Obter o usuario selecionado no modal, o valor é passado por
     * referência
     *
     * @return : Tela que fecha o modal
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 06/01/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String selecionar() {

    	BradescoCommonServiceFactory.getLogManager().info("[AnexarArquivoGccModalBean.selecionar] Inicio");
    	
        try {           
            DiskFileItem file = getViewHelper().getArquivo();
            
            // pasta do arquivo
            String path = montaPath();
            
            // nome do arquivo
            String nomeArquivo = file.getName();
            int index = nomeArquivo.lastIndexOf('\\');
            nomeArquivo = nomeArquivo.substring(index + 1);
   
            // mimeType do arquivo
            String mimeType = file.getContentType();
            
            // converte arquivo em array de bytes
            InputStream is = file.getInputStream();
            byte[] fileBytes = IOUtils.toByteArray(is);

            BradescoCommonServiceFactory.getLogManager().info("[AnexarArquivoGccModalBean.selecionar] Chamando o connectorGcc.criarDocumento.");
            
            // cria documento GCC
            String retorno = connectorGcc.criarDocumento(
                    path, 
                    "GccApoioProcesso", 
                    nomeArquivo, 
                    mimeType,
                    SiteUtil.STRING_EMPTY, 
                    getParametros().getTipoPessoa(), 
                    getParametros().getCpfCnpj(),
                    fileBytes);
            
            // trata retorno do GCC
            if (retorno != null) {
            	BradescoCommonServiceFactory.getLogManager().info("[AnexarArquivoGccModalBean.selecionar] Arquivo anexado com sucesso.");
                NpcFacesUtils.addInfoModalMessage("Arquivo anexado com sucesso.", "#{anexarArquivoGccModalBean.actionCloseModal}", 
                    BradescoViewExceptionActionType.ACTION, "frame", false);
            } else {
            	BradescoCommonServiceFactory.getLogManager().info("[AnexarArquivoGccModalBean.selecionar] Erro Não foi possível anexar o arquivo.");
                NpcFacesUtils.addInfoModalMessage("Não foi possível anexar o arquivo.", EnumButtonBehavior.SUBMIT);
            }
            
        } catch (NpccTradeWebException e) {
            BradescoFacesUtils.addInfoModalMessage(e.getMessage(), false);
        } catch (IOException e) {
        	BradescoCommonServiceFactory.getLogManager().info("[AnexarArquivoGccModalBean.selecionar] Erro ao anexar e-mail: "+e.getMessage());
            NpcFacesUtils.addInfoModalMessage("Erro ao anexar e-mail.<br />".concat(e.getMessage()), false);
        } catch (Exception e) {
        	BradescoCommonServiceFactory.getLogManager().info("[AnexarArquivoGccModalBean.selecionar] Erro: "+e.getMessage());
            NpcFacesUtils.addInfoModalMessage("Erro ao carregar o arquivo.", false);
        }
        
        BradescoCommonServiceFactory.getLogManager().info("[AnexarArquivoGccModalBean.selecionar] Fim");
        return null;
    }
    
    /**
     * 
     * Nome: montaPath 
     * 
     * Propósito: Monta e cria pastas para anexar email 
     *
     * @throws : NpcdServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 23/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    private String montaPath() {

    	BradescoCommonServiceFactory.getLogManager().info("[AnexarArquivoGccModalBean.montaPath] Iniciar");
    	
        String path = "/";
        
        // Cria pasta AAAAMM
        if (!connectorGcc.verificarPastaExiste(path + getParametros().getAnoMes())) {
            connectorGcc.criarPasta(getParametros().getAnoMes(), path);
        }
        path += getParametros().getAnoMes();
        
        // Cria pasta nroBoleto
        if (!connectorGcc.verificarPastaExiste(path + "/" + getParametros().getNroBoleto())) {
            connectorGcc.criarPasta(getParametros().getNroBoleto(), path);
        }
        path += "/" + getParametros().getNroBoleto();
        
        // Cria a pasta final "Email" ou "Arquivo"
        if (!connectorGcc.verificarPastaExiste(path + "/" + getParametros().getPasta().getDescricao())) {
            connectorGcc.criarPasta(getParametros().getPasta().getDescricao(), path);
        }
        path += "/" + getParametros().getPasta().getDescricao();

        // Grava log / Apresenta na console o caminho completo a ser enviado para o GCC
        BradescoCommonServiceFactory.getLogManager().info("[AnexarArquivoGccModalBean.montaPath] Fim: Retornou o path = " + path);
        
        // Retorna para o chamador o caminho completo a ser enviado para o GCC
        return path;
    }
    /**
     * Nome: actionCloseModal
     * 
     * Propósito: Fecha modal anexar
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 05/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public String actionCloseModal() {
        
        if(getViewHelper().getRecarregaLista()) {
            carregarAnexos();
        }

        return "/content/global/anexarArquivoGccModal/closeModalAnexarArquivoGcc.xhtml";
        
    }
    
    /**
     * 
        * Nome: carregarAnexos
        * 
        * Propósito: 
        *
        * @param : 
        * @return : 
        * @throws :
        * @exception : 
        * @see : Referencias externas.  
        *
        * Registro  de Manutenção: 22/04/2016
        *        - Autor: BRQ
        *        - Responsavel: Equipe Web
        *        - Adequação ao padrão hexavision.
     */
    public List<InfoDocumentoGccVO> consultarAnexos(AnexarArquivoGccVO param, List<InfoDocumentoGccVO> lista) {
        
        BradescoCommonServiceFactory.getLogManager().info("[AnexarArquivoGccModalBean.consultarAnexos] Inicio");
        
        setParametros(param);
        setListaAnexos(lista);
        carregarAnexos();
        
        BradescoCommonServiceFactory.getLogManager().info("[AnexarArquivoGccModalBean.consultarAnexos] Fim");
        
        return listaAnexos;
    }
    
    /**
     * 
        * Nome: carregarAnexos
        * 
        * Propósito: 
        *
        * @param : 
        * @return : 
        * @throws :
        * @exception : 
        * @see : Referencias externas.  
        *
        * Registro  de Manutenção: 22/04/2016
        *        - Autor: BRQ
        *        - Responsavel: Equipe Web
        *        - Adequação ao padrão hexavision.
     */
    private void carregarAnexos() {
        
        BradescoCommonServiceFactory.getLogManager().info("[AnexarArquivoGccModalBean.carregarAnexos] Inicio");
        
        if(listaAnexos == null) {
            listaAnexos = new ArrayList<InfoDocumentoGccVO>();
        } else {
            listaAnexos.clear();
        }
        
        try {
        
            String path = montaPathConsulta();
            
            ArrayOfArrayOfXsdNillableString documentos = connectorGcc.pesquisarDocumentosPorPath(path);
            
            BradescoCommonServiceFactory.getLogManager().info("[AnexarArquivoGccModalBean.carregarAnexos] Encontro arquivos na pasta =  " + path);
            
            for (ArrayOfXsdNillableString doc : documentos.getArrayOfXsdNillableString()) {
                
                BradescoCommonServiceFactory.getLogManager().info("[AnexarArquivoGccModalBean.carregarAnexos] Arquivo Encontrado =  " + doc.getString().get(2));
                
                InfoDocumentoGccVO info = new InfoDocumentoGccVO(
                        doc.getString().get(0),
                        doc.getString().get(1),
                        doc.getString().get(2),
                        doc.getString().get(3),
                        doc.getString().get(4));
                
                this.listaAnexos.add(info);
            }
        } catch (Exception e2) {
            BradescoCommonServiceFactory.getLogManager().error("[AnexarArquivoGccModalBean.carregarAnexos] Erro: " + e2.getMessage());
        } finally {
        
            BradescoCommonServiceFactory.getLogManager().info("[AnexarArquivoGccModalBean.carregarAnexos] Fim ");
        }
        
    }
    
    /**
     * 
     * Nome: montaPathConsulta 
     * 
     * Propósito: Monta a path para pesquisa de documentos 
     *
     * @throws : NpcdServiceBusinessException
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 23/11/2015 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    private String montaPathConsulta() {

    	BradescoCommonServiceFactory.getLogManager().error("[AnexarArquivoGccModalBean.montaPathConsulta] Inicio");
        
        String path = "/";
        
        // Cria pasta AAAAMM
        if (!connectorGcc.verificarPastaExiste(path + getParametros().getAnoMes())) {
        	BradescoCommonServiceFactory.getLogManager().error("[AnexarArquivoGccModalBean.montaPathConsulta] Pasta não existe = " + path);
        } else {
        
            path += getParametros().getAnoMes();
        
            if (!connectorGcc.verificarPastaExiste(path + "/" + getParametros().getNroBoleto())) {
                
            	BradescoCommonServiceFactory.getLogManager().error("[AnexarArquivoGccModalBean.montaPathConsulta] Pasta não existe = " + path);
                
            } else {
                path += "/" + getParametros().getNroBoleto();
                
                // Cria a pasta final "Email" ou "Arquivo"
                if (!connectorGcc.verificarPastaExiste(path + "/" + getParametros().getPasta().getDescricao())) {
                	BradescoCommonServiceFactory.getLogManager().error("[AnexarArquivoGccModalBean.montaPathConsulta] Pasta não existe = " + path);
                }
                path += "/" + getParametros().getPasta().getDescricao();
        
                BradescoCommonServiceFactory.getLogManager().error("[AnexarArquivoGccModalBean.montaPathConsulta] Pasta = " + path);
            }
        }
        
        BradescoCommonServiceFactory.getLogManager().error("[AnexarArquivoGccModalBean.montaPathConsulta] Fim ");
        
        return path; 
        
    } 

    /**
     * Nome: closeModal
     * 
     * Propósito: Fecha modal usuario
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 05/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModal(ActionEvent event) {

        // desabilita modal
        viewHelper.setRenderModal(Boolean.FALSE);
        
    }

    /**
     * @return o valor do viewHelper
     */
    public AnexarArquivoGccModalViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * @param viewHelper seta o novo valor para o campo viewHelper
     */
    public void setViewHelper(AnexarArquivoGccModalViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

    /**
     * @return o valor do connectorGcc
     */
    public ConnectorGcc getConnectorGcc() {
        return connectorGcc;
    }

    /**
     * @param connectorGcc seta o novo valor para o campo connectorGcc
     */
    public void setConnectorGcc(ConnectorGcc connectorGcc) {
        this.connectorGcc = connectorGcc;
    }

    /**
     * @return o valor do parametros
     */
    public AnexarArquivoGccVO getParametros() {
        return parametros;
    }

    /**
     * @param parametros seta o novo valor para o campo parametros
     */
    public void setParametros(AnexarArquivoGccVO parametros) {
        this.parametros = parametros;
    }

//    /**
//     * 
//     * @return
//     */
//    private ILogManager getLogManager() {
//        return BradescoCommonServiceFactory.getLogManager();
//    }

    /**
     * @return o valor do listaAnexos
     */
    public List<InfoDocumentoGccVO> getListaAnexos() {
        return listaAnexos;
    }

    /**
     * @param listaAnexos seta o novo valor para o campo listaAnexos
     */
    public void setListaAnexos(List<InfoDocumentoGccVO> listaAnexos) {
        this.listaAnexos = listaAnexos;
    }  
    
}