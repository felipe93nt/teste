/**
 * Nome: br.com.bradesco.web.cursojava.view.bean.SessionBean.java<BR/>
 * Propósito: Classe bpmh<BR/>
 *
 * Compilador: 1.6<BR/>
 * Data da Criação: 23/11/2016-15:01:32<BR/>
 * Parâmetros de Compilação -d<BR/>
 * Registro de Manutenção: 23/11/2016<BR/>
 *
 * - Autor: m126112 <BR/>
 * - Responsável: Equipe bpmh
 */
package br.com.bradesco.web.ricc.view.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.myfaces.shared_impl.util.MessageUtils;

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;


/**
 * <p>
 * <b>Título:</b> Nome do Projeto.
 * </p>
 * <p>
 * <b>Descrição:</b>
 * </p>
 * <p>
 * Descrição da classe.
 * </p>
 *
 * @author CPM Braxis / Edwin M. A. Costa
 * @version 1.0
 */
@Named
@SessionScoped
public class SessionBean implements Serializable{

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Constante para o número 8. */
	private static final int NUMERO_OITO = 8;

	/** Constante para o número 10. */
	private static final int NUMERO_DEZ = 10;

	/** Constante para o número 12. */
	private static final int NUMERO_DOZE = 12;

    /**
     * Nome: getDataAtual
     * Propósito: Recupera o valor do atributo 'dataAtual'.
     *
     * @return Retorna a data atual.
     * @see
     */
    public String getDataAtual() {
        Locale locale = BradescoFacesUtils.getLocale();
        DateFormat dataFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
        Calendar calendar = Calendar.getInstance(locale);
        Date dataAtual = calendar.getTime();
        String dataFormatada = dataFormat.format(dataAtual);
        return dataFormatada;
    }

    /**
     * Nome: getHoraAtual
     * Propósito: Recupera o valor do atributo 'horaAtual'.
     *
     * @return Retorna a data atual.
     * @see
     */
    public String getHoraAtual() {
        Locale locale = BradescoFacesUtils.getLocale();
        Calendar calendar = Calendar.getInstance(locale);
        Date dataAtual = calendar.getTime();
        SimpleDateFormat smf = new SimpleDateFormat("HH:mm");
        String dataFormatada = smf.format(dataAtual);
        dataFormatada = dataFormatada.replaceAll(":", "h");
        return dataFormatada;
    }

    /**
     * Nome: getSaudacao
     * Propósito: Recupera o valor do atributo 'saudacao'.
     *
     * @return saudacao - Retorna texto "Bom Dia" ou "Boa Tarde" ou "Boa Noite" de acordo com o horário.
     * @see
     */
    public String getSaudacao() {
        Locale locale = BradescoFacesUtils.getLocale();
        Calendar calendar = Calendar.getInstance(locale);
        int horaAtual = calendar.get(Calendar.HOUR_OF_DAY);
        String saudacao = null;
        if (horaAtual >= 0 && horaAtual < NUMERO_DOZE) {
            saudacao = getFacesMessage("label_dia");
        } else if (horaAtual >= NUMERO_DOZE && horaAtual < NUMERO_DEZ + NUMERO_OITO) {
            saudacao = getFacesMessage("label_tarde");
        } else {
            saudacao = getFacesMessage("label_noite");
        }
        return saudacao + ", ";
    }

    /**
     * Obtem o valor do atributo messageKey.
     *
     * @param messageKey -
     *            Chave da mensagem
     * @return Mensagem definida pelo atributo messageKey.
     * @see
     */
    private String getFacesMessage(String messageKey) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = MessageUtils.getMessage(facesContext, messageKey);
        return facesMessage.getSummary();
    }

    /**
     * Nome: getUsername
     * Propósito: Recupera o valor do atributo 'username'.
     *
     * @return valor do atributo 'username'
     * @see
     */
    public String getUsername() {
    	String username = "";
    	if (BradescoCommonServiceFactory.getSecurityManager() != null &&
    		BradescoCommonServiceFactory.getSecurityManager().getUsername() != null) {
    		username = BradescoCommonServiceFactory.getSecurityManager().getUsername();
    	}
    	return username;
    }
    
    public int getSessionTimeoutInvervalMili(){
    	return BradescoFacesUtils.getSession().getMaxInactiveInterval() * 1000;
    }
}
