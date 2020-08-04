/**
 * Nome: br.com.bradesco.web.npcc_trade.view.bean
 * Propósito: Classe comum para a funcionalidade
 * Data da Criação: 16/06/2015
 *
 * @author mauricio.sako / Capgemini
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Parâmetros de Compilação: -d
 */
package br.com.bradesco.web.npcc_trade.view.bean;

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

import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.core.th.ext.util.BradescoTHMessageUtils;


/**
*
* Nome: SessionBean
* Propósito: TODO <br/>
*
* Data: 17/06/2015 <br/>
* @author mauricio.sako / Capgemini <br/>
* copyright Copyright (c) 2015 <br/>
*
* @version 1.0
* @see
*/
@Named(value="sessionBean")
@SessionScoped
public class SessionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4256744174425622429L;

	/**
	 * Constante para o número 8
	 */
	private static final int NUMERO_OITO = 8;

	/**
	 * Constante para o número 10
	 */
	private static final int NUMERO_DEZ = 10;

	/**
	 * Constante para o número 12
	 */
	private static final int NUMERO_DOZE = 12;
	
	private String errorMessage = null;

    /**
     * @return Retorna a data atual.
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
     * @return Retorna a data atual.
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
     * @return saudacao - Retorna texto "Bom Dia" ou "Boa Tarde" ou "Boa Noite" de acordo com o horário.
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
     *
     * Obtem o valor do atributo messageKey.
     *
     * @param messageKey -
     *            Chave da mensagem
     * @return Mensagem definida pelo atributo messageKey.
     */
    private String getFacesMessage(String messageKey) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = BradescoTHMessageUtils.getMessage(facesContext, messageKey);
        return facesMessage.getSummary();
    }

    	/**
    	* Nome: getUsername
        *
    	* Propósito: 
    	*
    	* @param : 
    	*       <BR/>
    	* @return : 
    	*
    	* @throws :
    	* 
    	* @exception : 
    	*
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 12/08/2015
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public String getUsername() {
    	String username = "";
    	if (BradescoCommonServiceFactory.getSecurityManager() != null &&
    		BradescoCommonServiceFactory.getSecurityManager().getUsername() != null) {
    		username = BradescoCommonServiceFactory.getSecurityManager().getUsername();
    	}
    	return username;
    }

    public String getErrorMessage() {
    	return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
    	this.errorMessage = errorMessage;
    }
}
