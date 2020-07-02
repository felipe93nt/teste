package br.com.bradesco.web.ricc.view.bean.manutencaotemplate.bean;


import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;


import br.com.bradesco.web.ricc.model.manutencaotemplate.TemplateVO;
import br.com.bradesco.web.ricc.utils.RiccConstants;
import br.com.bradesco.web.ricc.view.bean.AbstractBean;
import br.com.bradesco.web.ricc.view.bean.manutencaotemplate.viewhelper.ListarTemplateViewHelper;


/**
 * @name ListaMensagemBean
 * @author Foursys
 * @version 1.0
 * @since 08/06/2020
 */
@SessionScoped
@Named(value = "listarTemplateBean")
public class ListarTemplateBean extends AbstractBean<ListarTemplateViewHelper>{
    /**
     * Atributo serialVersionUID Tipo long
     */
    private static final long serialVersionUID = 1631866463606968265L;


    private String paginaAnterior = RiccConstants.TELA_MANUTENCAO_CONSULTAR_TEMPLATE;
    
    /*
     * (non-Javadoc)
     * 
     * @see br.com.bradesco.web.Swft.view.bean.AbstractBean#iniciarPagina()
     */
    @Override
    public String iniciarPagina() {
        setViewHelper(new ListarTemplateViewHelper());
        viewHelper.inicializar();
        carregarListaTemplateVO();
        return RiccConstants.TELA_MANUTENCAO_LISTAR_TEMPLATE;
    }


    public void habilitarBotoes(AjaxBehaviorEvent ae) {
        this.viewHelper.setBtnAlterar(Boolean.FALSE);
        this.viewHelper.setBtnAutorizar(Boolean.FALSE);
        this.viewHelper.setBtnExcluir(Boolean.FALSE);
        this.viewHelper.setBtnDetalhar(Boolean.FALSE);
        this.viewHelper.setBtnCopiar(Boolean.FALSE);
        if (!this.viewHelper.getItemSelecionado().isEmpty()) {
            this.viewHelper.setBtnAlterar(Boolean.TRUE);
            this.viewHelper.setBtnAutorizar(Boolean.TRUE);
            this.viewHelper.setBtnExcluir(Boolean.TRUE);
            this.viewHelper.setBtnDetalhar(Boolean.TRUE);
            this.viewHelper.setBtnCopiar(Boolean.TRUE);
        }
    }


    public String voltar() {


        return paginaAnterior;
    }


    private void carregarListaTemplateVO() {
        TemplateVO msg1 = new TemplateVO();
        msg1.setCodigoTemplate("103");
        msg1.setDescricao("Manut Residente Londres Cliente Jose do Patrocinio");
        msg1.setReferencia("09751008724");
        msg1.setData("15/02/2020 10:31:15");
        msg1.setDataManutencao("16/02/2020 11:10:10");
        viewHelper.getListaTemplateVO().add(msg1);
        
        TemplateVO msg2 = new TemplateVO();
        msg2.setCodigoTemplate("103");
        msg2.setDescricao("Pagto Salario Funcionarios da Petrobras Florida");
        msg2.setReferencia("09751008724");
        msg2.setData("15/02/2020 12:11:15");
        msg2.setDataManutencao("16/02/2020 11:10:13");
        viewHelper.getListaTemplateVO().add(msg2);
        
        TemplateVO msg3 = new TemplateVO();
        msg3.setCodigoTemplate("103");
        msg3.setDescricao("Aposentadoria do Cliente Antonio de Souza");
        msg3.setReferencia("09751008724");
        msg3.setData("15/02/2020 13:00:20");
        msg3.setDataManutencao("16/02/2020 11:12:11");
        viewHelper.getListaTemplateVO().add(msg3);
        
        TemplateVO msg4 = new TemplateVO();
        msg4.setCodigoTemplate("103");
        msg4.setDescricao("Aluguel do Escritorio Sede NY da JBS");
        msg4.setReferencia("09751008724");
        msg4.setData("15/02/2020 14:50:15");
        msg4.setDataManutencao("16/02/2020 11:13:00");
        viewHelper.getListaTemplateVO().add(msg4);
        
        TemplateVO msg5 = new TemplateVO();
        msg5.setCodigoTemplate("103");
        msg5.setDescricao("Aposentadoria da Cliente Maria de Jesus");
        msg5.setReferencia("09751008724");
        msg5.setData("15/02/2020 15:10:00");
        msg5.setDataManutencao("16/02/2020 12:10:10");
        viewHelper.getListaTemplateVO().add(msg5);
        
        TemplateVO msg6 = new TemplateVO();
        msg6.setCodigoTemplate("103");
        msg6.setDescricao("Aposentadoria da Cliente Ana Clara");
        msg6.setReferencia("09751008724");
        msg6.setData("15/02/2020 15:31:15");
        msg6.setDataManutencao("16/02/2020 12:15:00");
        viewHelper.getListaTemplateVO().add(msg6);
        
        TemplateVO msg7 = new TemplateVO();
        msg7.setCodigoTemplate("103");
        msg7.setDescricao("Aluguel do Escritorio Sede J&F");
        msg7.setReferencia("09751008724");
        msg7.setData("15/02/2020 15:40:25");
        msg7.setDataManutencao("16/02/2020 13:10:00");
        viewHelper.getListaTemplateVO().add(msg7);
        
        TemplateVO msg8 = new TemplateVO();
        msg8.setCodigoTemplate("103");
        msg8.setDescricao("Manut Residente Londres Cliente Paulo Villar");
        msg8.setReferencia("09751008724");
        msg8.setData("15/02/2020 15:11:17");
        msg8.setDataManutencao("16/02/2020 13:16:10");
        viewHelper.getListaTemplateVO().add(msg8);
    }
}










