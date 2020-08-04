package br.com.bradesco.web.npcc_trade.view.bean.global.clienteModal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.poi.hssf.record.PageBreakRecord.Break;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.clienteModal.IClienteModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.global.desenquadradaModal.IDesenquadradaModalService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ClienteSelecaoVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.TradeFinNegocListasVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.components.CadastroNacionalPessoa;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumSimNaoStr;
import br.com.bradesco.web.npcd.utils.EnumButtonBehavior;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;

/**
  * Nome: ClienteModalBean.java
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
  * Registro  de Manutenção: 07/07/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
@Named(value = "clienteModalBean")
@SessionScoped
public class ClienteModalBean implements Serializable {
	
	/** Variavel do tipo long. */
	private static final long serialVersionUID = 4026940636965008720L;
	private ClienteModalViewHelper viewHelper = new ClienteModalViewHelper();
	private List<TradeFinNegocListasVO> lista = new ArrayList<TradeFinNegocListasVO>();
	private ClienteSelecaoVO clienteSelecaoVO = new ClienteSelecaoVO();
	private TradeFinNegocListasVO clienteSelecionado =  new TradeFinNegocListasVO();
	
	@Inject
	@Named("clienteModalService")
	private IClienteModalService clienteModalService;
	
    @Inject
    @Named("desenquadradaModalService")
    private IDesenquadradaModalService desenquadradaModalService;
	
	    /**
	     * Construtor
	     * 
	     * @param 
	     */
	public ClienteModalBean() {
		super();
	}
	
	/**
     * Nome: openModal
     * 
     * Propósito: Efetua pesquisa do banco emissor
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 11/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void openModal() {
    	
        try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ClienteModalBean.openModal <<<<<<<<<<<");
            
            setClienteSelecionado(new TradeFinNegocListasVO());
            
            getViewHelper().setConfirmar(Boolean.FALSE);
            getViewHelper().setItemSelecListaSelCliente(null);
            getViewHelper().setNomeStateIdListaSelCliente("NPCCIASJ");
            
            setLista(clienteModalService.listar(clienteSelecaoVO, getViewHelper().isPesqCpf()));
            
            if (!getLista().isEmpty()) {
                
                getViewHelper().setRenderModalCliente(Boolean.TRUE); 
                
            } else {
                NpcFacesUtils.addInfoModalMessage(clienteModalService.getMsgRetorno(), false);
            }
            
		} finally {
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ClienteModalBean.openModal <<<<<<<<<<<");
		}
    }
	
	/**
	 * 
		* Nome: selecionarCliente
		* 
		* Propósito: 
		*
		* @param : 
		* @return : 
		* @throws :
		* @exception : 
		* @see : Referencias externas.	
		*
		* Registro  de Manutenção: 23/03/2016
		*        - Autor: BRQ
		*        - Responsavel: Equipe Web
		*        - Adequação ao padrão hexavision.
	 */
	public String selecionarCliente() {
		
		try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ClienteModalBean.selecionarCliente <<<<<<<<<<<");
            
            // valida se foi selecionado um item na lista
            if (SiteUtil.isEmptyOrNull(viewHelper.getItemSelecListaSelCliente())) {
            	NpcFacesUtils.addInfoModalMessage("Selecione um Registro.", false);
            	return null;
            }
            
            setClienteSelecionado(getLista().get(SiteUtil.getInt(viewHelper.getItemSelecListaSelCliente())));
            
            // Apresenta dados da lista na tela
            clienteSelecaoVO.setCunicpssoacmbio(getClienteSelecionado().getCunicpssoacmbio());
            clienteSelecaoVO.setIredzdpssoacmbio(getClienteSelecionado().getIredzdpssoacmbio());
            clienteSelecaoVO.setNomeCliente(getClienteSelecionado().getIredzdpssoacmbio());
            
            if (SiteUtil.isEmptyOrNull(getClienteSelecionado().getCdfilial())) {
            	// tipo CPF
            	getViewHelper().setCodCpfCnpjSelecionado(Numeros.TRES);
            	clienteSelecaoVO.setCodCpfCnpj(Numeros.TRES);
            	clienteSelecaoVO.setCpf(SiteUtil.formatarCpfComponente(clienteSelecaoVO.getCpf(),
            			getClienteSelecionado().getCdcpfcnpj(),
            			getClienteSelecionado().getCdctrlcpfcnpj()));
            	
            	clienteSelecaoVO.setCpfCnpjFormatado(CadastroNacionalPessoa.format(getClienteSelecionado().getCdcpfcnpj(), 
            			getClienteSelecionado().getCdctrlcpfcnpj()));
            	
            } else {
            	// tipo CNPJ
            	getViewHelper().setCodCpfCnpjSelecionado(Numeros.DOIS);
            	clienteSelecaoVO.setCodCpfCnpj(Numeros.DOIS);
            	clienteSelecaoVO.setCnpj(SiteUtil.formatarCnpjComponente(clienteSelecaoVO.getCnpj(),
            			getClienteSelecionado().getCdcpfcnpj(),
            			getClienteSelecionado().getCdfilial(),
            			getClienteSelecionado().getCdctrlcpfcnpj()));
            	
            	clienteSelecaoVO.setCpfCnpjFormatado(CadastroNacionalPessoa.format(getClienteSelecionado().getCdcpfcnpj(),
            			getClienteSelecionado().getCdfilial(), getClienteSelecionado().getCdctrlcpfcnpj()));
            }
            
            clienteSelecaoVO.setNomeBanco(getClienteSelecionado().getBconome());
            clienteSelecaoVO.setCodAgencia(getClienteSelecionado().getCagbcria().toString());
            clienteSelecaoVO.setContaDv(getClienteSelecionado().getContaDvFormatado());
            clienteSelecaoVO.setCodCliente(getClienteSelecionado().getCunicpssoacmbio());
            
            clienteSelecaoVO.setCdcpfcnpj(getClienteSelecionado().getCdcpfcnpj());
            clienteSelecaoVO.setCdfilial(getClienteSelecionado().getCdfilial());
            clienteSelecaoVO.setCdctrlcpfcnpj(getClienteSelecionado().getCdctrlcpfcnpj());
            clienteSelecaoVO.setNctabcriacmbio(getClienteSelecionado().getNctabcriacmbio());
            
            getViewHelper().setConfirmar(true);
            
            return "/content/global/clienteModal/tradeFinModalClose.xhtml";
            
		} finally {
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ClienteModalBean.selecionarCliente <<<<<<<<<<<");
		}
		
        
        
    }
	
	/**
     * Nome: closeModal
     * 
     * Propósito: Fecha modal banco emissor
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 11/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModal(ActionEvent event) {

		try {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] ClienteModalBean.closeModal <<<<<<<<<<<");
            
            // ao fechar o modal limpa a lista
            setLista(new ArrayList<TradeFinNegocListasVO>());
            
            // desabilita modal
            getViewHelper().setRenderModalCliente(Boolean.FALSE);
            
            // reseta variáveis
            getViewHelper().setConfirmar(false);
            
		} finally {
			BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] ClienteModalBean.closeModal <<<<<<<<<<<");
		}
        
    }
	
	/**
	* Nome: getSelectItemRadiolista
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 29/03/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
	/*public List<SelectItem> getSelectItemRadiolista() {
	    List<SelectItem> selectItemRadioLista = new ArrayList<SelectItem>();
	    
	    SiteUtil.atualizarSelectItem(getLista(), selectItemRadioLista);
	    
	    return selectItemRadioLista;
	}*/

    /**
     * 
    	* Nome: paginarCliente
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 28/03/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
     */
    public void paginarCliente(ActionEvent event) {
    	setLista(clienteModalService.listar(clienteSelecaoVO, viewHelper.isPesqCpf()));
    }
    
	public ClienteModalViewHelper getViewHelper() {
		return viewHelper;
	}

	public void setViewHelper(ClienteModalViewHelper viewHelper) {
		this.viewHelper = viewHelper;
	}

	public TradeFinNegocListasVO getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(TradeFinNegocListasVO clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public ClienteSelecaoVO getClienteSelecaoVO() {
		return clienteSelecaoVO;
	}

	public void setClienteSelecaoVO(ClienteSelecaoVO clienteSelecaoVO) {
		this.clienteSelecaoVO = clienteSelecaoVO;
	}

	public List<TradeFinNegocListasVO> getLista() {
		return lista;
	}

	public void setLista(List<TradeFinNegocListasVO> lista) {
		this.lista = lista;
	}

	public List<SelectItem> getSelectItemRadioLista() {
		List<SelectItem> selectItemRadioLista = new ArrayList<SelectItem>();
	    
	    SiteUtil.atualizarSelectItem(getLista(), selectItemRadioLista);
	    
		return selectItemRadioLista;
	}

}
