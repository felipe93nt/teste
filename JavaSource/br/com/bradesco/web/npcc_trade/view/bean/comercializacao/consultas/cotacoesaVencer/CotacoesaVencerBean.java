package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.consultas.cotacoesaVencer;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.cotacoesaVencer.bean.CotacoesaVencerVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.consultas.cotacoesaVencer.impl.CotacoesaVencerServiceImpl;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcd.view.bean.BaseBean;

@Named("cotacoesaVencerBean")
@SessionScoped
public class CotacoesaVencerBean extends BaseBean implements Serializable{

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 7846264074721883074L;
    

    private List<CotacoesaVencerVO> lista = new ArrayList<CotacoesaVencerVO>();
    private CotacoesaVencerViewHelper viewhelper = new CotacoesaVencerViewHelper();
    
    
	@Inject
    @Named("cotacoesaVencerServiceImpl")
    private CotacoesaVencerServiceImpl cotacoesaVencerServiceImpl;
    private int qtdiaux = 0;  

	public void pesquisarCotacoesaVencer(AjaxBehaviorEvent e){
    	
        try{
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] CotacoesaVencerBean.iniciar pesquisa <<<<<<<<<<<");
            
			if (viewhelper.getQtdDias() <= Numeros.ZERO) {
				
				BradescoFacesUtils.addInfoModalMessage("Favor informar o prazo para vencimento", false);

			} else{	
				qtdiaux = viewhelper.getQtdDias();
				setLista(cotacoesaVencerServiceImpl.getCotacoesaVencer(viewhelper.getQtdDias()));
			}            

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] CotacoesaVencerBean.iniciar pesquisa <<<<<<<<<<<");
        }
    	
    }
	
	public void pesquisarCotacoesaVencer(){
		viewhelper.setQtdDias(qtdiaux);
		pesquisarCotacoesaVencer(null);		
	}
	

	public String iniciar() {

        try{
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] CotacoesaVencerBean.iniciar <<<<<<<<<<<");
            
//          Recarrega página se não for um postback ou se foi marcado para recaregar
            if (!isPostback() || getIniciarPagina()) {
                setIniciarPagina(false);
                setLista(null);
            }

            setViewhelper(new CotacoesaVencerViewHelper());
            
            return "cotacoesaVencerList";

        }finally{
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] CotacoesaVencerBean.iniciar <<<<<<<<<<<");
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
            
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Inicio] CotacoesaVencerBean.exportar  <<<<<<<<<<<");
    
            BradescoCommonServiceFactory.getObjectManager().setRequestAttribute("listaCotacoesaVencer", getLista());           
    
            return "cotacoesaVencerListExportTemplate";
            
        } finally {
            BradescoCommonServiceFactory.getLogManager().info(">>>>>>>>>>>  [Fim] CotacoesaVencerBean.exportar  <<<<<<<<<<<");
        }
    }
	
	public List<CotacoesaVencerVO> getLista() {
		return lista;
	}

	public void setLista(List<CotacoesaVencerVO> lista) {
		this.lista = lista;
	}
	
    public CotacoesaVencerViewHelper getViewhelper() {
		return viewhelper;
	}

	public void setViewhelper(CotacoesaVencerViewHelper viewhelper) {
		this.viewhelper = viewhelper;
	}
	
}
