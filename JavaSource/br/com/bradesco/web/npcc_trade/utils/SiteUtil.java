/**
 * Nome: br.com.bradesco.web.npcc_trade.utils
 * Propósito: Classe comum para a funcionalidade
 * Data da Criação: 16/06/2015
 *
 * @author mauricio.sako / Capgemini
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Parâmetros de Compilação: -d
 */

package br.com.bradesco.web.npcc_trade.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.facelets.FaceletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;

import br.com.bradesco.web.aq.application.error.BradescoArchitectureException;
import br.com.bradesco.web.aq.application.pagination.util.AWBPaginationButtonState;
import br.com.bradesco.web.aq.application.pagination.util.AWBPaginationState;
import br.com.bradesco.web.aq.application.property.config.IConfigPropertyManager;
import br.com.bradesco.web.aq.application.security.ICoreSecurityManager;
import br.com.bradesco.web.aq.application.security.ISecurityManager;
import br.com.bradesco.web.aq.application.session.bean.AWBPaginationDataState;
import br.com.bradesco.web.aq.application.session.bean.AWBPaginationSessionState;
import br.com.bradesco.web.aq.application.util.BradescoCommonServiceFactory;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.components.UICalendar.UICalendar;
import br.com.bradesco.web.aq.view.components.UICnpj.CnpjDataType;
import br.com.bradesco.web.aq.view.components.UICnpj.UICnpj;
import br.com.bradesco.web.aq.view.components.UICpf.CpfDataType;
import br.com.bradesco.web.aq.view.components.UICpf.UICpf;
import br.com.bradesco.web.aq.view.components.base.UICalendar.UICalendarBase;
import br.com.bradesco.web.aq.view.components.base.UICalendarPeriod.UICalendarPeriodBase;
import br.com.bradesco.web.aq.view.components.base.UICnpj.UICnpjBase;
import br.com.bradesco.web.aq.view.components.base.UICpf.UICpfBase;
import br.com.bradesco.web.aq.view.core.th.ext.util.BradescoTHMessageUtils;
import br.com.bradesco.web.aq.view.util.FacesUtils;
import br.com.bradesco.web.npcc_trade.exception.NpccTradeException;
import br.com.bradesco.web.npcc_trade.utils.text.TextUtil;

/**
 *
 * Nome: SiteUtil
 * 
 * Propósito:
 *
 * Data: 17/06/2015 <br/>
 * 
 * @author mauricio.sako / Capgemini <br/>
 *         copyright Copyright (c) 2015 <br/>
 *
 * @version 1.0
 * @see
 */
public final class SiteUtil {

    /**
     * Representa uma String vazia.
     */
    public static final String STRING_EMPTY = "";

    /**
     * Acao da tela default
     */
    public static final Integer ACTION_VIEW_EMPTY = 0;

    /**
     * Acao da tela de inclusão
     */
    public static final Integer ACTION_VIEW_INSERT = 1;

    /**
     * Acao da tela de alteração
     */
    public static final Integer ACTION_VIEW_EDIT = 2;

    /**
     * Acao da tela de exclusão
     */
    public static final Integer ACTION_VIEW_DELETE = 3;

    /**
     * Acao da tela de detalhes
     */
    public static final Integer ACTION_VIEW_DETAILS = 3;

    /**
     * estilo do calendario.
     */
    public static final String INPUT_CALENDAR = "HtmlInputTextCalendar";

    /**
     * estilo calendario obrigatorio.
     */
    public static final String INPUT_CALENDAR_OBRIG = "HtmlInputTextCalendarObrigatorio";

    /**
     * estilo calendario obrigatorio que será validado no bean possibilitando uma mensagem de validação personalizada.
     */
    public static final String INPUT_CALENDAR_OBRIG_JAVA = "HtmlInputTextCalendarObrigNoJava";

    /**
     * estilo Select Obrigatorio.
     */
    public static final String SELECT_OBRIG = "HtmlSelectOneMenuObrigatorioBradesco";

    /**
     * estilo Radio Obrigatorio.
     */
    public static final String RADIO_OBRIG = "HtmlSelectOneRadioObrigatorioBradesco";

    /**
     *
     */
    public static final String INPUT_OBRIG = "HtmlInputTextObrigatorioBradesco";

    /**
     *
     */
    public static final String SELECT_ORI = "HtmlSelectOneMenuBradesco";

    /**
    *
    */
    public static final String SELECT_DISABLED = "HtmlSelectOneMenuDesabilitado";

    /**
     *
     */
    public static final String INPUT_ORI = "HtmlInputTextBradesco";

    /**
    *
    */
    public static final String INPUT_DISABLED = "HtmlInputTextDisabled";

    /**
     * Validação de campo obrigatório - prefixo
     */
    public static final String FIELD_VALIDATION_MESSAGE = "O campo ";

    /**
     * Validação de campo obrigatório - sufixo
     */
    public static final String SELECTONE_VALIDATION_MESSAGE = " é obrigatório.";

    /** Formatação Padrão Brasileiro */
    private static Locale locale = new Locale("pt", "BR");

    /** Variavel do tipo String. */
    public static final String STRING_A = "A";

    /** Variavel do tipo String. */
    public static final String STRING_D = "D";
    
    /** Variavel do tipo String. */
    public static final String STRING_I = "I";

    /** Variavel do tipo String. */
    public static final String STRING_S = "S";
    
    /** Variavel do tipo String. */
    public static final String STRING_T = "T";

    /** Variavel do tipo String. */
    public static final String STRING_P = "P";

    /** Constante MENOS_UM. */
    public static final int MENOS_UM = -1;

    /**
     * Constant selecione
     */
    public static final String SELECIONE = "Selecione...";

    /** Variavel do tipo String. */
    public static final String STRING_NULL = "null";

    /**
     * Representa a formatação de moeda.
     */
    public static final String DECIMAL_PATTERN = "#,##0.00";

    /**
     * Representa a formatação de moeda com 5 casas decimais.
     */
    public static final String DECIMAL_PATTERN_CINCO_CASAS = ",##0.00000";

    /**
     * Local para formatação de valores.
     */
    public static final Locale PT_BR = new Locale("pt", "BR");

    /**
     * Indicador NAO
     */
    public static final String NAO = "Não";

    /**
     * Indicador SIM
     */
    public static final String SIM = "Sim";
    
    /** Variavel do tipo SiteUtil. */
    public static final long DAY_TIME_MILLISECONDS = 24 * 60 * 60 * 1000;

    
    /**
     *
     * Construtor privado da classe SiteUtil.
     *
     */
    private SiteUtil() {
    }

    

    /**
     *
     * Obtem o valor do atributo messageKey.
     *
     * @param messageKey - Chave da mensagem
     * @return Mensagem definida pelo atributo messageKey.
     */
    public static String getFacesMessage(String messageKey) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = BradescoTHMessageUtils.getMessage(facesContext, messageKey);
        return facesMessage.getSummary();
    }

    /**
     *
     * Obtem o valor do atributo messageKey, com o valor das variaveis.
     *
     * @param messageKey - Chave da mensagem
     * @param params - Array de parametros
     * @return Mensagem definida pelo atributo messageKey, com as variaveis preenchidas.
     */
    public static String getFacesMessage(String messageKey, Object[] params) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = BradescoTHMessageUtils.getMessage(facesContext, messageKey, params);
        return facesMessage.getSummary();
    }

    /**
     * Insere um novo mensagem de erro GLOBAL no FacesMessages. O mensagem é obtenido pela sua chave.
     *
     * @param messageKey - Chave da mensagem
     */
    public static void addMessageErrorMessage(String messageKey) {
        addMessageErrorMessage(null, messageKey);
    }

    /**
     * Insere um novo mensagem de erro no FacesMessages. O mensagem é obtenido pela sua chave, e associado no compenente
     * correspondente.
     *
     * @param clientId - id do componente
     * @param messageKey - Chave da mensagem
     */
    public static void addMessageErrorMessage(String clientId, String messageKey) {
        String msg = getFacesMessage(messageKey);
        FacesUtils.addErrorMessage(clientId, msg);
    }

    /**
     * Insere um novo mensagem de erro GLOBAL no FacesMessages. O mensagem é obtenido pela sua chave, com o valor das
     * variaveis.
     *
     * @param messageKey - Chave da mensagem
     * @param params - Array de parametros
     */
    public static void addMessageErrorMessage(String messageKey, Object[] params) {
        addMessageErrorMessage(null, messageKey, params);
    }

    /**
     * Insere um novo mensagem de erro no FacesMessages. O mensagem é obtenido pela sua chave, com o valor das
     * variaveis, e associado no compenente correspondente.
     *
     * @param clientId - id do componente
     * @param messageKey - Chave da mensagem
     * @param params - Array de parametros
     */
    public static void addMessageErrorMessage(String clientId, String messageKey, Object[] params) {
        String msg = getFacesMessage(messageKey, params);
        FacesUtils.addErrorMessage(clientId, msg);
    }

    /**
     * Insere uma nova mensagem de campo obrigatório no FacesMessages.
     * 
     * @param mensagem - label do campo obrigatório
     */
    public static void addMenssageRiqueridField(final String mensagem) {
        if (mensagem != null) {
            // MENSAGEM
            addMessageErrorMessage(FIELD_VALIDATION_MESSAGE + mensagem + SELECTONE_VALIDATION_MESSAGE);
        }
    }

    /**
     * <p>
     * Recupera o objeto HttpServletRequest.
     * </p>
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getServletRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    /**
     * Formatar uma string com o número 0 a esquerda de acordo com o tamanho.
     *
     * @param value - Valor a ser formatado.
     * @param size - Tamanho do campo.
     * @return Retorna uma string com zeros à esquerda.
     */
    public static String formatNumber(String value, int size) {
        String ret = null;
        if (value == null) {
            value = STRING_EMPTY;
        }
        if (value.length() > size) {
            ret = value.substring(0, size);
        } else {
            ret = value;
            if (value.length() < size) {
                for (int i = value.length(); i < size; i++) {
                    ret = "0" + ret;
                }
            }
        }
        return ret;
    }

    /**
     * Formatar uma string com o caracter " " a direita de acordo com o tamanho.
     *
     * @param value - Valor a ser formatado.
     * @param size - Tamanho do campo.
     * @return Retorna uma string foramtada.
     */
    public static String formatString(String value, int size) {
        String ret = null;
        if (value == null) {
            value = STRING_EMPTY;
        }
        if (value.length() > size) {
            ret = value.substring(0, size);
        } else {
            ret = value;
            if (value.length() < size) {
                for (int i = value.length(); i < size; i++) {
                    ret += " ";
                }
            }
        }
        return ret;
    }

    /**
     * Formata um bloco de texto autenticado para exibição.
     *
     * @param autenticada Valor da String de autenticação.
     * @return Retorna um objeto da classe <tt>String</tt> com os dados de autenticação prontos para exibição.
     */
    public static String formatarTextoAutenticado2(String autenticada) {
        StringBuffer ret = new StringBuffer();
        ret.append(autenticada.charAt(0));
        for (int i = 1; i < (autenticada.length() - 1); i++) {
            ret.append(autenticada.charAt(i));
        }
        ret.append(autenticada.charAt(autenticada.length() - 1));
        return ret.toString();
    }

    /**
     *
     * Cria um objeto Date a partir de uma String e um padrão. Exemplo de pattern: ddMMyyyy.
     *
     * @param date Data a ser criada.
     * @param pattern padrão.
     * @return Data criada
     * @throws ParseException Caso ocorra algum erro.
     */
    public static Date stringToDate(String date, String pattern) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.parse(date);
    }

    /**
     *
     * Transforma uma data (Date) em String. Exemplo de pattern: ddMMyyyy.
     *
     * @param date Data.
     * @param pattern padrão desejado.
     * @return Data formato String.
     */
    public static String dateToString(Date date, String pattern) {
        if (date == null) {
            return STRING_EMPTY;
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * Objetivo: Verificar se a String é nula ou vazia.
     *
     * @param pSString String a ser comparada.
     * @return <i>true</i>, se a String for nula ou vazia; <i>false</i>, caso contrário.
     */
    public static boolean isEmptyOrNull(String pSString) {

        return (pSString == null || pSString.trim().equals(STRING_EMPTY));
    }
    
    /**
     * Objetivo: Verificar se a Date é nula ou vazia.
     *
     * @param date date a ser comparada.
     * @return <i>true</i>, se a String for nula ou vazia; <i>false</i>, caso contrário.
     */
    public static boolean isEmptyOrNull(Date date) {

        return (date == null || date.equals(STRING_EMPTY));
    }


    /**
     * Objetivo: Verificar se campo Integer é nulo ou zero.
     *
     * @param pInteger Integer a ser comparado.
     * @return <i>true</i>, se o Integer for nulo ou zero; <i>false</i>, caso contrário.
     */
    public static boolean isEmptyOrNull(Integer pInteger) {

        return (pInteger == null || pInteger == Numeros.ZERO);
    }

    /**
     * Objetivo: Verificar se campo Long é nulo ou zero.
     *
     * @param pInteger Integer a ser comparado.
     * @return <i>true</i>, se o Integer for nulo ou zero; <i>false</i>, caso contrário.
     */
    public static boolean isEmptyOrNull(Long pInteger) {

        return (pInteger == null || pInteger == Numeros.ZERO);
    }

    /**
     * Objetivo: Verificar se campo valor tratodo como String é zero
     *
     * @param value String a ser verificado.
     * @return <i>true</i>, se o valor for zero; <i>false</i>, caso contrário.
     */
    public static boolean isValueZero(String value) {

        Long longValue = null;

        try {
            longValue = SiteUtil.getLong(SiteUtil.removeNaoNumericos(value));
        } catch (Exception e) {
            longValue = SiteUtil.getLong(Numeros.MENOS_UM);
        }

        return longValue == Numeros.NUM0_LONG;
    }

    /**
     *
     * Método que retorna uma Data ou Hora em um formato específico, definido pelo cliente, a partir de uma variável de
     * entrada Data e/ou Hora.
     *
     * @param pDateString Data ou Hora a ter o formato modificado
     * @param pPadraoOrigem Formato inicial da Data ou Hora. Ex: yyyy/MM/dd-HH:mm:ss
     * @param pPadraoDestino Formato da Data ou Hora a ser retornada
     * @return String com o formato de data ou hora
     * @throws ParseException caso ocorra um erro na formatação
     */
    public static String changeStringDateFormat(String pDateString, String pPadraoOrigem, String pPadraoDestino)
                    throws ParseException {

        if (SiteUtil.isEmptyOrNull(pDateString)) {
            return pDateString;
        }

        return SiteUtil.dateToString(SiteUtil.stringToDate(pDateString, pPadraoOrigem), pPadraoDestino);
    }

    /**
     * 
     * Nome: atualizarSelectItem Propósito: Atualiza a Lista na Tela com o RadioButton
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 07/08/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static void atualizarSelectItem(final List<?> lista, final List<SelectItem> selectItems) {
        selectItems.clear();
        for (int i = 0; i < lista.size(); i++) {
            selectItems.add(new SelectItem(i, STRING_EMPTY));
        }
    }

    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param valor
     * @return .
     */
    public static String removeNaoNumericos(final String valor) {
        if (valor == null) {
            return STRING_EMPTY;
        }
        return valor.replaceAll("[^0-9]", STRING_EMPTY);
    }
    
    private static void createModalMessageRequired(List<String> mensagensErroList) {
        
        for (int i = 0; i < mensagensErroList.size(); i++) {
            BradescoFacesUtils.addInfoModalMessage(FIELD_VALIDATION_MESSAGE + mensagensErroList.get(i) + SELECTONE_VALIDATION_MESSAGE, false);
        }
    }

    /**
     * Verifica se existe campos obrigatório não preenchidos apartir de um elemento principal (ex: form).
     * 
     * @param parentElement - id do elemento apartir do qual será efetuada a validação
     * @return - Retorna true caso existam erros
     */
    public static final boolean validarCampos(final String parentElement) {

        Boolean retornaMensagem = false;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UIViewRoot viewRoot = facesContext.getViewRoot();
        List<String> mensagensErroList = new ArrayList<String>();

        // RECUPERA TODOS OS COMPONENTES DA TELA
        UIComponent componentes = (UIComponent) viewRoot.findComponent(parentElement);

        validarCampos(componentes, mensagensErroList);

        // VERIFICA SE TEM ALGUMA MENSAGEM P/ SER EXIBIDA
        if (mensagensErroList.size() > 0) {
            createModalMessageRequired(mensagensErroList);
            
            retornaMensagem = true;
        }

        return retornaMensagem;
    }

    /**
     * Função recursiva para verificar todos os elemento obrigatórios apartir de um componente
     * 
     * @param componente - UIComponent principal
     * 
     * @param excessao - Component não deve ser verificado
     */
    private static void validarCampos(UIComponent componente, List<String> mensagensErroList, String... excessao) {
        UIComponent objHTML = null;
        String campo = STRING_EMPTY;
        String value = null;
        Boolean valuePreenchido = false;
        String style = STRING_EMPTY;
        Boolean obrigatorio = false;

        if (mensagensErroList == null)
            mensagensErroList = new ArrayList<String>();

        if (componente instanceof HtmlSelectOneMenu) {
            objHTML = (HtmlSelectOneMenu) componente;
            campo = ((HtmlSelectOneMenu) componente).getTitle();
            style = ((HtmlSelectOneMenu) componente).getStyleClass();
            value = String.valueOf(((HtmlSelectOneMenu) componente).getValue());
            if (value != null && value.length() > 0 && !value.equals("0") && !value.equals("null")
                            && !value.equals(SiteUtil.getString(Numeros.NUM999))) {
                valuePreenchido = true;
            }
            obrigatorio = verificaEstilo(style);
        } else if (componente instanceof HtmlSelectOneRadio) {
            objHTML = (HtmlSelectOneRadio) componente;
            campo = ((HtmlSelectOneRadio) componente).getTitle();
            style = ((HtmlSelectOneRadio) componente).getStyleClass();
            value = String.valueOf(((HtmlSelectOneRadio) componente).getValue());
            if (value != null && value != "null" && value.length() > 0 && !value.equals("0")
                            && !value.equals(SiteUtil.getString(Numeros.NUM999))) {
                valuePreenchido = true;
            }
            obrigatorio = verificaEstilo(style);
        } else if (componente instanceof UICnpj) {

            objHTML = (UICnpj) componente;
            campo = ((UICnpj) componente).getTitleInputsCnpj();
            style = ((UICnpj) componente).getStyleClassInputs();

            value = nullToString(((UICnpj) componente).getValue());

            if (value != null && value.length() > 0) {
                valuePreenchido = true;
            }

            obrigatorio = verificaEstilo(style);
        } else if (componente instanceof UICpf) {

            objHTML = (UICpf) componente;
            campo = ((UICpf) componente).getTitleInputsCpf();
            style = ((UICpf) componente).getStyleClassInputs();

            value = nullToString(((UICpf) componente).getValue());

            if (value != null && value.length() > 0) {
                valuePreenchido = true;
            }

            obrigatorio = verificaEstilo(style);
        } else if (componente instanceof HtmlInputText) {
            objHTML = (HtmlInputText) componente;
            campo = ((HtmlInputText) componente).getTitle();
            style = ((HtmlInputText) componente).getStyleClass();

            if (((HtmlInputText) componente).getValue() instanceof Integer) {
                Integer valor = (Integer) ((HtmlInputText) componente).getValue();
                value = String.valueOf(valor);
            } else if (((HtmlInputText) componente).getValue() instanceof Long) {
                Long valor = (Long) ((HtmlInputText) componente).getValue();
                value = String.valueOf(valor);
            } else if (((HtmlInputText) componente).getValue() instanceof Double) {
                Double valor = (Double) ((HtmlInputText) componente).getValue();
                value = String.valueOf(valor);
            } else if (((HtmlInputText) componente).getValue() instanceof BigDecimal) {
                BigDecimal valor = (BigDecimal) ((HtmlInputText) componente).getValue();
                value = String.valueOf(valor);
            } else
                value = (String) ((HtmlInputText) componente).getValue();

            if (value != null && value.length() > 0) {
                valuePreenchido = true;
            }

            obrigatorio = verificaEstilo(style);
        } else if (componente instanceof HtmlInputTextarea) {
            objHTML = (HtmlInputTextarea) componente;
            campo = ((HtmlInputTextarea) componente).getTitle();
            style = ((HtmlInputTextarea) componente).getStyleClass();
            value = (String) ((HtmlInputTextarea) componente).getValue();
            if (value != null && value.length() > 0) {
                valuePreenchido = true;
            }
            obrigatorio = verificaEstilo(style);
        } else if (componente instanceof UICalendar) {
            objHTML = (UICalendar) componente;
            style = ((UICalendar) componente).getStyleClass();
            Date dataCalendar = (Date) ((UICalendar) componente).getValue();
            String idCalendar = componente.getId();

            if (idCalendar.contains("Ini") || idCalendar.contains("De")) {
                campo = "Data Inicial";
            } else if (idCalendar.contains("Fin") || idCalendar.contains("Ate") || idCalendar.contains("Fim")) {
                campo = "Data Final";
            } else if (idCalendar.contains("Custom")) {
                return;
            } else {
                campo = "Data";
            }
            if (dataCalendar != null) {
                valuePreenchido = true;
            }
            obrigatorio = verificaEstilo(style);
        } else {
            if (componente.getChildren().size() > 0) {
                for (int i = 0; i < componente.getChildren().size(); i++) {
                    UIComponent uiComponent2 = (UIComponent) componente.getChildren().get(i);
                    validarCampos(uiComponent2, mensagensErroList, excessao);
                }
            }
        }

        if ((objHTML != null && !objHTML.getAttributes().isEmpty()) || (componente instanceof UICnpj)
                        || (componente instanceof UICpf) || (componente instanceof UICalendar)) {
            if (valuePreenchido == false && obrigatorio == true) {
                boolean validate = true;
                if (excessao != null && excessao.length > Numeros.NUM0.intValue() && objHTML.getId() != null) {
                    for (String excl : excessao) {
                        if (objHTML.getId().equals(excl)) {
                            validate = false;
                        }
                    }
                }

                // Adiciona campo obrigatório que não foi preenchido e não faz
                // parte da lista de Itens Excessão
                if (validate) {
                    mensagensErroList.add(campo);
                }
            }
        }
    }

    /**
     * Verifica se o styleClass do componente está como obrigatório
     * 
     * @param style
     * @return verdadeiro se estilo obrigatório
     */
    public static final boolean verificaEstilo(String style) {
        boolean obrig = false;
        if (style != null
                        && (style.equals(SELECT_OBRIG) || style.equals(INPUT_OBRIG)
                                        || style.equals(INPUT_CALENDAR_OBRIG) || style.equals(RADIO_OBRIG))) {
            obrig = true;
        }
        return obrig;
    }

    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param valor - String
     * @return - Retorna o valor passado para integer
     */
    public static String getString(final String valor) {
        if (valor == null) {
            return STRING_EMPTY;
        }
        return valor;
    }

    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param valor - String
     * @return - Retorna o valor passado como Integer para String.
     */
    public static String getString(final Integer valor) {
        String retorno = STRING_EMPTY;
        if (valor != null) {
            try {
                retorno = String.valueOf(valor);
            } catch (Exception e) {
                retorno = STRING_EMPTY;
            }
        }
        return retorno;
    }

    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param valor - String
     * @return - Retorna o valor passado como Long para String.
     */
    public static String getString(final Long valor) {
        String retorno = STRING_EMPTY;
        if (valor != null) {
            try {
                retorno = String.valueOf(valor);
            } catch (Exception e) {
                retorno = STRING_EMPTY;
            }
        }
        return retorno;
    }

    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param valor
     * @return 0
     */
    public static int getInt(final String valor) {
        return getInt(valor, false);
    }

    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param valor
     * @param limpar
     * @return 0
     */
    public static int getInt(final String valor, final boolean limpar) {
        try {
            if (limpar) {
                return Integer.parseInt(removeNaoNumericos(valor.trim()));
            } else {
                return Integer.parseInt(valor.trim());
            }
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param valor
     * @return 0
     */
    public static int getInt(final Long valor) {
        try {
            return valor.intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param valor
     * @return 0
     */
    public static int getInt(final Integer valor) {
        try {
            return valor.intValue();
        } catch (Exception e) {
            return 0;
        }
    }
    
    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param valor
     * @return 0
     */
    public static int getInt(final Object valor) {
        if(valor != null) {
            return getInt(valor.toString(), false);
        } else {
            return 0;
        }
    }

    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param valor
     * @return 0L
     */
    public static Long getLong(final Integer valor) {
        try {
            return valor.longValue();
        } catch (Exception e) {
            return 0L;
        }
    }

    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param valor
     * @return 0L
     */
    public static Long getLong(final String valor) {
        return getLong(valor, false);
    }
    
    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param valor
     * @return 0
     */
    public static Long getLong(final Object valor) {
        if(valor != null) {
            return getLong(valor.toString(), false);
        } else {
            return 0L;
        }
    }

    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param valor
     * @param limpar
     * @return 0L
     */
    public static Long getLong(final String valor, final boolean limpar) {
        try {
            if (limpar) {
                return Long.parseLong(removeNaoNumericos(valor));
            } else {
                return Long.parseLong(valor);
            }
        } catch (Exception e) {
            return 0L;
        }
    }

    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param valor
     * @return 0L
     */
    public static Long getLong(final Long valor) {
        try {
            return valor.longValue();
        } catch (Exception e) {
            return 0L;
        }
    }

    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param valor
     * @return 0D
     */
    public static double getDouble(final String valor) {
        try {
            return Double.parseDouble(SiteUtil.trocarVirgulaPorPonto(valor));
        } catch (Exception e) {
            return 0D;
        }
    }

    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param valor
     * @return 0D
     */
    public static double getDouble(final Double valor) {
        try {
            return valor.doubleValue();
        } catch (Exception e) {
            return 0D;
        }
    }

    /**
     * 
     * Nome: getBigDecimal Propósito: Verifica se o BigDecimal é diferente de Nulo
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 07/08/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static BigDecimal getBigDecimal(final BigDecimal valor) {
        if (valor != null)
            return valor;
        else
            return new BigDecimal(0.0);
    }

    /**
     * 
     * Nome: nullToDouble Propósito:
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 19/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static Double nullToDouble(final Object valor) {

        if ((valor != null) && !valor.equals(SiteUtil.STRING_EMPTY)) {
            return Double.parseDouble(String.valueOf(valor));
        } else {
            return 0d;
        }
    }

    /**
     * 
     * Nome: nullToInteger Propósito:
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 19/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static Integer nullToInteger(final Object valor) {

        if ((valor != null) && !valor.equals(SiteUtil.STRING_EMPTY)) {
            return Integer.parseInt((String.valueOf(valor)));
        } else {
            return Numeros.NUM0;
        }
    }

    /**
     * 
     * Nome: nullToLong Propósito:
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 19/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static Long nullToLong(final Object valor) {

        if ((valor != null) && !valor.equals(SiteUtil.STRING_EMPTY)) {
            return Long.parseLong((String.valueOf(valor)));
        } else {
            return 0l;
        }
    }

    /**
     * 
     * Nome: nullToInt Propósito:
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 19/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static Integer nullToInt(final Object valor) {

        if ((valor != null) && !valor.equals(SiteUtil.STRING_EMPTY)) {
            return Integer.parseInt((String.valueOf(valor)));
        } else {
            return 0;
        }
    }

    /**
     * 
     * Nome: nullToString Propósito:
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 19/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String nullToString(final Object object) {

        if (object == null) {
            return SiteUtil.STRING_EMPTY;
        } else {
            return String.valueOf(object);
        }
    }

    /**
     * 
     * Nome: nullToBigDecimal Propósito:
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 19/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static BigDecimal nullToBigDecimal(final Object valor) {

        if ((valor != null) && !valor.equals(SiteUtil.STRING_EMPTY)) {
            return new BigDecimal((String.valueOf(valor)));
        } else {
            return BigDecimal.ZERO;
        }
    }

    /**
     * Nome: getResourceBundleString
     * <p>
     * Propósito: Obtém uma string do bundle de mensagens através de uma chave
     * <p/>
     *
     * @param String resourceBundleKey - a chave da string desejada
     * @see
     */
    public static String getBundleValue(String resourceBundleKey) throws MissingResourceException {

        ResourceBundle bundle = ResourceBundle.getBundle("br.com.bradesco.web.npcc_trade.view.bundle.Messages");
        // Retorna o bundle adequado
        return bundle.getString(resourceBundleKey);
    }

    /**
     * Nome: copyPropertiesObjects
     * <p>
     * Propósito: Realiza get dos metodos de 'getFrom' e set dos metodos de 'setTo' usando como base os atributos de
     * 'getFrom'.
     * <p/>
     *
     * @param Object getFrom: Objeto que fornece valores
     * @param Object getTo: Obejto que recebe valores
     * 
     * @see
     */
    public static void copyPropertiesObjects(final Object getFrom, final Object setTo) {

        copyPropertiesObjects(getFrom, setTo, SiteUtil.STRING_EMPTY, false, null);
    }

    /**
     * Nome: copyPropertiesObjects
     * <p>
     * Propósito: Realiza get dos metodos de 'getFrom' e set dos metodos de 'setTo' usando como base os atributos de
     * 'getFrom' e remove ou adiciona o 'prefixo' no nome do atributo de 'setTo'.
     * <p/>
     *
     * @param Object getFrom: Objeto que fornece valores
     * @param Object getTo: Obejto que recebe valores
     * @param String prefixTo: Prefixo
     * @param Boolean removePrefixTo: true - remove false - adiciona
     * 
     * @see
     */
    public static void copyPropertiesObjects(final Object getFrom, final Object setTo, final String prefixTo,
        final Boolean removePrefixTo) {

        copyPropertiesObjects(getFrom, setTo, prefixTo, removePrefixTo, null);
    }

    /**
     * Nome: copyPropertiesObjects
     * <p>
     * Propósito: Realiza get dos metodos de 'getFrom' e set dos metodos de 'setTo' usando como base os atributos de
     * 'getFrom' e ignora atributos definidos em 'ignoreProperties'.
     * <p/>
     *
     * @param Object getFrom: Objeto que fornece valores
     * @param Object getTo: Obejto que recebe valores
     * @param String[] ignoreProperties: Propriedades ignoradas
     * 
     * @see
     */
    public static void copyPropertiesObjects(final Object getFrom, final Object setTo, final String[] ignoreProperties) {

        copyPropertiesObjects(getFrom, setTo, SiteUtil.STRING_EMPTY, false, ignoreProperties);
    }

    /**
     * Nome: copyPropertiesObjects
     * <p>
     * Propósito: Realiza get dos metodos de 'getFrom' e set dos metodos de 'setTo' usando como base os atributos de
     * 'getFrom', ignora atributos definidos em 'ignoreProperties' e remove ou adiciona o 'prefixo' no nome do atributo
     * de 'setTo'.
     * <p/>
     * 
     * @param Object getFrom: Objeto que fornece valores
     * @param Object getTo: Obejto que recebe valores
     * @param String prefixTo: Prefixo
     * @param Boolean removePrefixTo: true - remove false - adiciona
     * @param String[] ignoreProperties: Propriedades ignoradas
     * 
     * @see
     */
    public static void copyPropertiesObjects(final Object getFrom, Object setTo, final String prefixTo,
        final Boolean removePrefixTo, final String[] ignoreProperties) {

        if (getFrom != null && setTo != null) {
            Class actualEditable = getFrom.getClass();
            executeInvoke(getFrom, setTo, prefixTo, removePrefixTo, ignoreProperties, actualEditable, true);
        }
    }

    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param getFrom:
     * @param setTo:
     * @param ignoreProperties:
     * @param actualEditable:
     * @param setBlank:
     */
    private static void executeInvoke(final Object getFrom, final Object setTo, final String prefixTo,
        final Boolean removePrefixTo, final String[] ignoreProperties, final Class actualEditable,
        final boolean setBlank) {

        PropertyDescriptor[] targetPds = PropertyUtils.getPropertyDescriptors(actualEditable);
        List<?> ignoreList = (ignoreProperties != null) ? Arrays.asList(ignoreProperties) : null;

        for (int i = 0; i < targetPds.length; i++) {
            PropertyDescriptor targetPd = targetPds[i];
            if (targetPd.getWriteMethod() != null
                            && (ignoreProperties == null || (!ignoreList.contains(targetPd.getName())))) {

                String targetPdName = targetPd.getName();
                // trata prefixo do objetoTO
                if (!prefixTo.equals(SiteUtil.STRING_EMPTY)) {
                    targetPdName =
                                    removePrefixTo == true ? targetPdName.replace(prefixTo, SiteUtil.STRING_EMPTY)
                                                    : prefixTo + targetPdName;
                }

                String getName = "get"
                // + targetPd.getName().replace(prefix, SiteUtil.STRING_EMPTY)
                                + targetPd.getName().substring(0, 1).toUpperCase() + targetPd.getName().substring(1);

                String setName = "set" + targetPdName.substring(0, 1).toUpperCase() + targetPdName.substring(1);

                Method getMethod = null;
                Method setMethod = null;

                try {

                    getMethod = getFrom.getClass().getMethod(getName);
                    Object result = getMethod.invoke(getFrom);

                    if (result != null) { // null

                        if (result instanceof Integer) { // int
                            try {

                                setMethod = setTo.getClass().getMethod(setName, boolean.class);

                                // converte int para Boolean
                                int resultInt = (Integer) result;
                                if (resultInt == 1) {
                                    result = true;
                                } else {
                                    result = false;
                                }

                            } catch (NoSuchMethodException e) {
                                try {
                                    setMethod = setTo.getClass().getMethod(setName, result.getClass());
                                } catch (NoSuchMethodException ea) {
                                    setMethod = setTo.getClass().getMethod(setName, int.class);
                                }
                            }
                        } else if (result instanceof Long) { // long
                            try {
                                setMethod = setTo.getClass().getMethod(setName, result.getClass());
                            } catch (NoSuchMethodException e) {
                                setMethod = setTo.getClass().getMethod(setName, long.class);
                            }
                        } else if (result instanceof Float) { // float
                            try {
                                setMethod = setTo.getClass().getMethod(setName, result.getClass());
                            } catch (NoSuchMethodException e) {
                                setMethod = setTo.getClass().getMethod(setName, float.class);
                            }
                        } else if (result instanceof Double) { // double
                            try {
                                setMethod = setTo.getClass().getMethod(setName, result.getClass());
                            } catch (NoSuchMethodException e) {
                                setMethod = setTo.getClass().getMethod(setName, double.class);
                            }
                        } else if (result instanceof Short) { // short
                            try {
                                setMethod = setTo.getClass().getMethod(setName, result.getClass());
                            } catch (NoSuchMethodException e) {
                                setMethod = setTo.getClass().getMethod(setName, short.class);
                            }
                        } else if (result instanceof Character) { // char
                            try {
                                setMethod = setTo.getClass().getMethod(setName, result.getClass());
                            } catch (NoSuchMethodException e) {
                                setMethod = setTo.getClass().getMethod(setName, char.class);
                            }
                        } else if (result instanceof Byte) { // byte
                            try {
                                setMethod = setTo.getClass().getMethod(setName, result.getClass());
                            } catch (NoSuchMethodException e) {
                                setMethod = setTo.getClass().getMethod(setName, byte.class);
                            }
                        } else if (result instanceof Boolean) { // boolean
                            try {
                                setMethod = setTo.getClass().getMethod(setName, result.getClass());
                            } catch (NoSuchMethodException e) {
                                setMethod = setTo.getClass().getMethod(setName, boolean.class);
                            }
                        } else if (result instanceof Date) { // Date
                            try {

                                // procura metodo com Date
                                setMethod = setTo.getClass().getMethod(setName, result.getClass());

                            } catch (NoSuchMethodException e) {
                                try {

                                    // procura metodo com String, converte Date
                                    // para String
                                    setMethod = setTo.getClass().getMethod(setName, String.class);

                                    result = dataWebToMainframe((Date) result);

                                } catch (NoSuchMethodException ea) {
                                    throw new NoSuchMethodException();
                                }
                            }
                        } else if (result instanceof String) { // String
                            try {
                                // procura metodo com Date
                                setMethod = setTo.getClass().getMethod(setName, Date.class);

                                // converte String para Date
                                result = dataMainframeToWeb((String) result);

                            } catch (NoSuchMethodException e) {

                                try {

                                    setMethod = setTo.getClass().getMethod(setName, boolean.class);

                                    // converte String para Boolean
                                    String resultString = (String) result;
                                    if (resultString.equalsIgnoreCase("S")) {
                                        result = true;
                                    } else {
                                        result = false;
                                    }

                                } catch (NoSuchMethodException ea) {

                                    try {

                                        setMethod = setTo.getClass().getMethod(setName, result.getClass());

                                    } catch (NoSuchMethodException eb) {
                                        throw new NoSuchMethodException();
                                    }
                                }

                            }

                        } else {
                            setMethod = setTo.getClass().getMethod(setName, result.getClass());
                        }

                        setMethod.invoke(setTo, result);
                    } else {
                        if (setBlank) {

                            // int
                            try {
                                setMethod = setTo.getClass().getMethod(setName, int.class);

                                setMethod.invoke(setTo, 0);
                            } catch (NoSuchMethodException e) {
                            }

                            // long
                            try {
                                setMethod = setTo.getClass().getMethod(setName, long.class);

                                setMethod.invoke(setTo, 0L);
                            } catch (NoSuchMethodException e) {
                            }

                            // float
                            try {
                                setMethod = setTo.getClass().getMethod(setName, float.class);

                                setMethod.invoke(setTo, 0F);
                            } catch (NoSuchMethodException e) {
                            }

                            // double
                            try {
                                setMethod = setTo.getClass().getMethod(setName, double.class);

                                setMethod.invoke(setTo, 0D);
                            } catch (NoSuchMethodException e) {
                            }

                            // short
                            try {
                                setMethod = setTo.getClass().getMethod(setName, short.class);

                                setMethod.invoke(setTo, 0);
                            } catch (NoSuchMethodException e) {
                            }

                            // String
                            try {
                                setMethod = setTo.getClass().getMethod(setName, String.class);

                                setMethod.invoke(setTo, STRING_EMPTY);
                            } catch (NoSuchMethodException e) {
                            }

                        }
                    }
                } catch (SecurityException e) {
                } catch (NoSuchMethodException e) {

                    String isName =
                                    "is" + targetPd.getName().substring(0, 1).toUpperCase()
                                                    + targetPd.getName().substring(1);

                    try {
                        getMethod = getFrom.getClass().getMethod(isName);
                        Object result = getMethod.invoke(getFrom);

                        if (result != null) { // null

                            boolean resultBoolean = (Boolean) result;

                            try {
                                setMethod = setTo.getClass().getMethod(setName, int.class);

                                if (resultBoolean) {
                                    result = 1;
                                } else {
                                    result = 0;
                                }

                            } catch (NoSuchMethodException ea) {
                                setMethod = setTo.getClass().getMethod(setName, String.class);

                                if (resultBoolean) {
                                    result = "S";
                                } else {
                                    result = "N";
                                }
                            }
                        }

                        setMethod.invoke(setTo, result);

                    } catch (SecurityException ea) {
                    } catch (NoSuchMethodException ea) {
                    } catch (IllegalAccessException ea) {
                    } catch (Exception ea) {
                        throw new NpccTradeException("Could not" + "copy properties from source to target", ea);
                    }

                } catch (IllegalAccessException e) {
                } catch (Exception e) {
                    throw new NpccTradeException("Could not" + "copy properties from source to target", e);
                }

            }
        }

    }

    /**
     * Nome: stringDataWebToMainframe
     * 
     * Propósito: Converte o Padrao dd/mm/yyy para dd.mm.yyyy
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 22/09/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String stringDataWebToMainframe(final String data) {

        if (data != null) {
            return data.replace("/", ".");
        } else {
            return STRING_EMPTY;
        }
    }

    /**
     * 
     * Nome: stringDataMainframeToWeb Propósito: Converte o Padrao dd.mm.yyyy para dd/mm/yyy
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/09/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String stringDataMainframeToWeb(final String data) {

        if (data != null) {
            return data.replace(".", "/");
        } else {
            return STRING_EMPTY;
        }
    }

    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param data - O valor do campo a determinar.
     * @return String
     */
    public static String dataWebToMainframe(final Date data) {

        if (data != null) {
            return new SimpleDateFormat("dd.MM.yyyy").format(data);
        } else {
            return "          ";
        }
    }

    /**
     * Formata o campo date time no padrão mainframe para a exibição na web.
     * 
     * @param data - O valor do campo a determinar.
     * @return Date
     */
    public static String dateTimeMainframeToWeb(String dataTime) {
        SimpleDateFormat sdf1 = new SimpleDateFormat();
        sdf1.applyPattern("dd/MM/yyyy HH:mm:ss");
        Date dt = dataMainframeToWeb(dataTime);

        return dt != null ? sdf1.format(dt) : dataTime;
    }

    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param data - O valor do campo a determinar.
     * @return Date
     */
    public static Date dataMainframeToWeb(String data) {

        if (data == null || data.length() < Numeros.NUM10) {
            return null;
        }

        SimpleDateFormat format = null;

        if (data.length() == Numeros.NUM10) {
            format = new SimpleDateFormat("dd-MM-yyyy");

            data = data.replaceAll("\\.", "-");
            data = data.replaceAll("/", "-");
            data = data.replaceAll(" ", "-");

        } else {
            format = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");

            data = data.replaceAll("/", "-");
            data = data.replaceAll(" ", "-");
        }

        Calendar calendar = GregorianCalendar.getInstance();

        java.sql.Date dataFinal = null;

        try {

            dataFinal = new java.sql.Date(format.parse(data).getTime());
            calendar.setTime(dataFinal);

        } catch (ParseException e) {
            return null;
        }

        return calendar.getTime();

    }

    /**
     * 
     * Nome: getUIParamValue Propósito: Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param String key - Tag <name> do componente UIParam
     * @return String value - Tag <value> do componente UIParam
     */
    public static String getUIParamValue(String key) {
        FaceletContext faceletContext =
                        (FaceletContext) FacesContext.getCurrentInstance().getAttributes()
                                        .get(FaceletContext.FACELET_CONTEXT_KEY);
        return (String) faceletContext.getAttribute(key);
    }

    /**
     * 
     * Nome: formatarAltCampo Propósito: Define os atributos alt e maxLength de acordo com os parametros passados ao
     * método.
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 15/09/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static HtmlInputText formatarAltCampo(HtmlInputText campo, String nomeAltCampo, Integer maxLenth) {

        // Define os atributos alt e maxLength de acordo com os parametros passados ao método.
        if (campo != null) {

            campo.setAlt(nomeAltCampo);
            campo.setMaxlength(maxLenth.intValue());
        }

        return campo;
    }

    /**
     * Nome: browserMoedaToBigDecimal
     * 
     * Propósito: Efetua a Conversão do Valor String em BigDecimal
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 17/09/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static BigDecimal webMoedaToBigDecimal(String valor) {
        return BigDecimal.valueOf(webMoedaToDouble(valor));
    }

    /**
     * Nome: browserMoedaToDouble
     * 
     * Propósito: Efetua a conversão de um String para o Formato Double
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 17/09/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static double webMoedaToDouble(String valor) {
        if (valor.trim().equals(STRING_EMPTY))
            return 0;
        NumberFormat nf = NumberFormat.getNumberInstance(locale);
        double retorno = 0;
        try {
            retorno = nf.parse(valor).doubleValue();
        } catch (ParseException e) {
            return retorno;
        }
        return retorno;
    }

    /**
     * Nome: bigDecimalToWebMoeda
     * 
     * Propósito: Converte um valor BigDecimal para String
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 17/09/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String bigDecimalToWebMoeda(BigDecimal valor) {
        return bigDecimalToWebMoeda(valor, 2);
    }

    /**
     * Nome: bigDecimalToWebMoeda
     * 
     * Propósito: Converte um Valor BigDecimal para String com decimais
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 17/09/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String bigDecimalToWebMoeda(BigDecimal valor, int decimais) {
        NumberFormat nf = NumberFormat.getNumberInstance(locale);
        nf.setMaximumFractionDigits(decimais);
        nf.setMinimumFractionDigits(decimais);
        return nf.format(valor);
    }

    /**
     * Nome: webMoedaToMainframe
     * 
     * Propósito: Formata o valor da tela para o Mainframe Ex: 1.000.000,00 para 1000000.00
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String webMoedaToMainframe(String valor) {
        String resultado = null;
        
        valor = nullToString(valor);
        if(valor.indexOf(",") >= 0) {
            resultado = nullToString(valor).replaceAll("\\.", "");
            resultado = trocarVirgulaPorPonto(resultado);
        } else {
            resultado = valor;
        }
        return resultado;
    }

    /**
     * 
     * Nome: formatarTitleCampo Propósito: Formatar o title de um determinado inputText
     *
     * @param : campo, nomeTitleCampo HtmlInputText, String <BR/>
     * @return : campo HtmlInputText
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 17/09/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static HtmlInputText formatarTitleCampo(HtmlInputText campo, String nomeTitleCampo) {

        // Define os atributos alt e maxLength de acordo com os parametros passados ao método.
        if (campo != null) {

            campo.setTitle(nomeTitleCampo);
        }

        return campo;
    }

    /**
     * 
     * Nome: formatarAtributosCampo Propósito:
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 19/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static UIComponent formatarAtributosCampo(UIComponent campo, String nomeTitleCampo, String style,
        String styleClass, String alt, Integer maxlength, boolean rendered, boolean disabled) {

        if (campo instanceof HtmlSelectOneMenu) {
            ((HtmlSelectOneMenu) campo).setTitle(nomeTitleCampo);
            ((HtmlSelectOneMenu) campo).setStyle(style);
            ((HtmlSelectOneMenu) campo).setStyleClass(styleClass);
            ((HtmlSelectOneMenu) campo).setRendered(rendered);
            ((HtmlSelectOneMenu) campo).setDisabled(disabled);

        } else if (campo instanceof HtmlSelectOneRadio) {

            ((HtmlSelectOneRadio) campo).setTitle(nomeTitleCampo);
            ((HtmlSelectOneRadio) campo).setStyle(style);
            ((HtmlSelectOneRadio) campo).setStyleClass(styleClass);
            ((HtmlSelectOneMenu) campo).setRendered(rendered);
            ((HtmlSelectOneMenu) campo).setDisabled(disabled);

        } else if (campo instanceof UICnpjBase) {

            ((UICnpjBase) campo).setTitleInputsCnpj(nomeTitleCampo);
            ((UICnpjBase) campo).setStyleClassInputs(styleClass);
            ((UICnpjBase) campo).setRendered(rendered);
            ((UICnpjBase) campo).setDisabled(disabled);

        } else if (campo instanceof UICpfBase) {

            ((UICnpjBase) campo).setTitleInputsCnpj(nomeTitleCampo);
            ((UICnpjBase) campo).setStyleClassInputs(styleClass);
            ((UICnpjBase) campo).setRendered(rendered);
            ((UICnpjBase) campo).setDisabled(disabled);

        } else if (campo instanceof HtmlInputText) {

            ((HtmlInputText) campo).setTitle(nomeTitleCampo);
            ((HtmlInputText) campo).setStyle(style);
            ((HtmlInputText) campo).setStyleClass(styleClass);
            ((HtmlInputText) campo).setRendered(rendered);
            ((HtmlInputText) campo).setDisabled(disabled);
            ((HtmlInputText) campo).setAlt(alt);

        } else if (campo instanceof HtmlInputTextarea) {

            ((HtmlInputTextarea) campo).setTitle(nomeTitleCampo);
            ((HtmlInputTextarea) campo).setStyle(style);
            ((HtmlInputTextarea) campo).setStyleClass(styleClass);
            ((HtmlInputTextarea) campo).setRendered(rendered);
            ((HtmlInputTextarea) campo).setDisabled(disabled);

        } else if (campo instanceof UICalendarBase) {
            ((UICalendarBase) campo).setTitulo(nomeTitleCampo);
            ((UICalendarBase) campo).setStyleClass(styleClass);
            ((UICalendarBase) campo).setRendered(rendered);
            ((UICalendarBase) campo).setDisabled(disabled);
            ((UICalendarBase) campo).setAlt(alt);

        } else if (campo instanceof UICalendarPeriodBase) {
            // Não é possível alterar atributos desse tipo de objeto até o momento,
            // pois o mesmo não contem styleclass, alt, title etc..
        }

        return campo;
    }

    /**
     * 
     * Nome: formatarAtributosCampo Propósito:
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 19/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static UIComponent formatarAltTileStyleClassCampo(UIComponent campo, String nomeTitleCampo,
        String styleClass, String alt) {

        if (campo instanceof HtmlSelectOneMenu) {
            ((HtmlSelectOneMenu) campo).setTitle(nomeTitleCampo);
            ((HtmlSelectOneMenu) campo).setStyleClass(styleClass);

        } else if (campo instanceof HtmlSelectOneRadio) {

            ((HtmlSelectOneRadio) campo).setTitle(nomeTitleCampo);
            ((HtmlSelectOneRadio) campo).setStyleClass(styleClass);

        } else if (campo instanceof UICnpjBase) {

            ((UICnpjBase) campo).setTitleInputsCnpj(nomeTitleCampo);
            ((UICnpjBase) campo).setStyleClassInputs(styleClass);

        } else if (campo instanceof UICpfBase) {

            ((UICnpjBase) campo).setTitleInputsCnpj(nomeTitleCampo);
            ((UICnpjBase) campo).setStyleClassInputs(styleClass);

        } else if (campo instanceof HtmlInputText) {

            ((HtmlInputText) campo).setTitle(nomeTitleCampo);
            ((HtmlInputText) campo).setStyleClass(styleClass);
            ((HtmlInputText) campo).setAlt(alt);

        } else if (campo instanceof HtmlInputTextarea) {

            ((HtmlInputTextarea) campo).setTitle(nomeTitleCampo);
            ((HtmlInputTextarea) campo).setStyleClass(styleClass);

        } else if (campo instanceof UICalendarBase) {
            ((UICalendarBase) campo).setTitulo(nomeTitleCampo);
            ((UICalendarBase) campo).setStyleClass(styleClass);
            ((UICalendarBase) campo).setAlt(alt);

        } else if (campo instanceof UICalendarPeriodBase) {
            // Não é possível alterar atributos desse tipo de objeto até o momento,
            // pois o mesmo não contem styleclass, alt, title etc..
        }

        return campo;
    }

    /**
     * 
     * Nome: buscarDescricao Propósito:
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 17/09/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String buscarDescricao(final List<SelectItem> itens, final Long codigo) {
        if (codigo != null && codigo != 0) {
            for (SelectItem item : itens) {
                if (item.getValue().toString().equals(codigo.toString())) {
                    return item.getLabel();
                }
            }
        }
        return STRING_EMPTY;
    }

    /**
     * 
     * Nome: buscarDescricao Propósito:
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 17/09/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String buscarDescricao(final List<SelectItem> itens, final Integer codigo) {
        if (codigo != null && codigo != 0) {
            for (SelectItem item : itens) {
                if (item.getValue().toString().equals(codigo.toString())) {
                    return item.getLabel();
                }
            }
        }
        return STRING_EMPTY;
    }

    /**
     * 
     * Nome: buscarDescricao Propósito:
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 17/09/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String buscarDescricao(final List<SelectItem> itens, final String codigo) {
        if (codigo != null && codigo != STRING_EMPTY) {
            for (SelectItem item : itens) {

                String itemValue = nullToString(item.getValue());

                if (itemValue.equals(codigo.toString())) {
                    return item.getLabel();
                }
            }
        }
        return STRING_EMPTY;
    }

    /**
     * Método para comparar duas data sem considerar as horas.
     * 
     * @param dataInicial
     * @param dataFinal
     * @return 
     *          Igual a zero   - Datas iguais <br/>
     *          Menor que zero - Inicio menor que Fim <br/>
     *          Maior que zero - Inicio maior que Fim <br/>
     */
    public static Integer comparaDatas(Date d1, Date d2) {
        
        Integer result = null;
        
        try {
            if(d1 != null && d2 != null) {
                Calendar c1 = Calendar.getInstance();
                c1.setTime(d1);
                
                Calendar c2 = Calendar.getInstance();
                c2.setTime(d2);
                
                if (c1.get(Calendar.YEAR) != c2.get(Calendar.YEAR)) {
                    result = c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
                } else if (c1.get(Calendar.MONTH) != c2.get(Calendar.MONTH)) {
                    result = c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
                } else {
                    result = c1.get(Calendar.DAY_OF_MONTH) - c2.get(Calendar.DAY_OF_MONTH);
                }
            }
        } catch (Exception e) {
            result = null;
        }
        
        return result;
    }

    /**
     * Método para comparação de duas data, retornando true caso as datas sejam iguais, e false caso as datas sejam
     * diferentes.
     * 
     * @param dataInicial
     * @param dataFinal
     * @return
     */
    public static boolean comparaDatasIguais(Date dataInicial, Date dataFinal) {
        Boolean datasIguais = false;

        try {

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date data1;
            String data1Str = dataWebToMainframe(dataInicial);
            data1Str = data1Str.replace(".", "/");
            data1 = format.parse(data1Str);

            Date data2;
            String data2Str = dataWebToMainframe(dataFinal);
            data2Str = data2Str.replace(".", "/");
            data2 = format.parse(data2Str);

            if (data1 != null && data2 != null) {
                int compareDate = data1.compareTo(data2);

                // Caso as datas sejam iguais
                if (compareDate == 0) {
                    datasIguais = true;
                }
            }

        } catch (ParseException e) {
            datasIguais = false;
        }

        return datasIguais;
    }

    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @throws ParseException
     */
    public static boolean compararDataAtual(Date dataInicial, String nomeCampoData) {
        boolean dataMenorAtual = false;
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dataAtual;
            String data = dataWebToMainframe(new Date());
            data = data.replace(".", "/");
            dataAtual = format.parse(data);

            if (dataInicial != null) {
                data = dataWebToMainframe(dataInicial);
                data = data.replace(".", "/");
                Date dataInic = format.parse(data);

                if (dataInic.compareTo(dataAtual) < Numeros.NUM0.intValue()) {
                    BradescoFacesUtils.addGlobalErrorFacesMessage("O campo " + nomeCampoData
                                    + " é Menor que a Data Atual.", STRING_EMPTY);
                    dataMenorAtual = true;
                }
            }
            return dataMenorAtual;
        } catch (ParseException e) {
            dataMenorAtual = true;
        }
        return dataMenorAtual;
    }

    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @throws ParseException
     */
    public static boolean compararDataMaiorAtual(Date dataInicial, String nomeCampoData) {
        boolean dataMaiorAtual = false;
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dataAtual;
            String data = dataWebToMainframe(new Date());
            data = data.replace(".", "/");
            dataAtual = format.parse(data);

            if (dataInicial != null) {
                data = dataWebToMainframe(dataInicial);
                data = data.replace(".", "/");
                Date dataInic = format.parse(data);

                if (dataInic.compareTo(dataAtual) > Numeros.NUM0.intValue()) {
                    BradescoFacesUtils.addGlobalErrorFacesMessage("O campo " + nomeCampoData
                                    + " é Maior que a Data Atual.", STRING_EMPTY);
                    dataMaiorAtual = true;
                }
            }
            return dataMaiorAtual;
        } catch (ParseException e) {
            dataMaiorAtual = true;
        }
        return dataMaiorAtual;
    }
    
    /**
     * Nome: toDay
     * 
     * Propósito: Retorna a data do dia com o horário 23:59:59:999
     *
     * @return : Date
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 22/09/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static Date toDay() {
        Calendar cal = Calendar.getInstance();  
        cal.setTime(new Date());  
        cal.set(Calendar.HOUR_OF_DAY, 23);  
        cal.set(Calendar.MINUTE, 59);  
        cal.set(Calendar.SECOND, 59);  
        cal.set(Calendar.MILLISECOND, 999);  
        return cal.getTime();
    }

    /**
     * Nome: reiniciarPaginacao
     * 
     * Propósito: Reinicia o componente de paginação
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 22/09/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static void reiniciarPaginacao(String stateID) {
        AWBPaginationDataState awbPaginationDataState =
                        AWBPaginationSessionState.getAWBPaginationDataState("cws", stateID);
        awbPaginationDataState.setAwbPaginationButtonState(AWBPaginationButtonState.DISABLE_LEFT);
        awbPaginationDataState.setLastPageDirection(AWBPaginationState.INITIALIZED_OPERATION);
        AWBPaginationSessionState.setAWBPaginationDataState("cws", null, awbPaginationDataState);
    }

    /**
     * Nome: reiniciarPaginacao
     * 
     * Propósito: Reinicia a Paginação
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static void reiniciarPaginacao() {
        reiniciarPaginacao(null);
    }

    /**
     * Nome: formatarPontosVirgula
     * 
     * Formatar pontos virgula.
     * 
     * @param valor the valor
     * @return string
     * @see
     */
    public static String trocarPontoPorVirgula(String valor) {
        if (valor != null && valor.indexOf('.') != MENOS_UM) {
            valor = valor.replace('.', ',');
        } else if (valor == null) {
            valor = SiteUtil.STRING_EMPTY;
        }

        return valor;
    }

    /**
     * Nome: trocarVirgulaPorPonto
     * 
     * Formatar pontos no lugar das virgulas.
     * 
     * @param valor the valor
     * @return string
     * @see
     */
    public static String trocarVirgulaPorPonto(String valor) {
        if (valor != null && valor.indexOf(',') != MENOS_UM) {
            valor = valor.replace(',', '.');
        } else if (valor == null) {
            valor = SiteUtil.STRING_EMPTY;
        }
        return valor;
    }

    /**
     * Nome: trocarPontoPorBara
     * 
     * Formatar pontos virgula.
     * 
     * @param valor the valor
     * @return string
     * @see
     */
    public static String trocarPontoPorBarra(String valor) {
        if (valor != null && valor.indexOf('.') != MENOS_UM) {
            valor = valor.replace('.', '/');
        } else if (valor == null) {
            valor = SiteUtil.STRING_EMPTY;
        }

        return valor;
    }
    
    /**
     * Nome: trocarPontoPorBara
     * 
     * Formatar pontos virgula.
     * 
     * @param valor the valor
     * @return string
     * @see
     */
    public static String trocarBarraPorPonto(String valor) {
        if (valor != null && valor.indexOf('/') != MENOS_UM) {
            valor = valor.replace('/', '.');
        } else if (valor == null) {
            valor = SiteUtil.STRING_EMPTY;
        }

        return valor;
    }

    /**
     * 
     * Nome: completarZerosEsquerda Propósito: Método para inserir zeros a esquerda do número enviado como parâmetro.
     *
     * @param : qtdZeros, numero <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/09/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String completarZerosEsquerda(Integer qtdZeros, String numero) {
        while (numero.length() < qtdZeros.intValue()) {
            numero = "0" + numero;
        }
        return numero;
    }

    /**
     * 
     * Nome: completarZerosDireita Propósito: Método para inserir zeros a esquerda do número enviado como parâmetro.
     *
     * @param : qtdZeros, numero <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/09/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String completarZerosDireita(Integer qtdZeros, String numero) {
        while (numero.length() < qtdZeros.intValue()) {
            numero = numero + "0";
        }
        return numero;
    }

    /**
     * 
     * Nome: formatarNoveCasasDecimais Propósito:
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 05/10/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String formatarNoveCasasDecimais(String valor, String separadorDecimal) {

        String valorNumerico = null;
        String valorDecimal = null;

        if (valor != null && valor.indexOf('.') != MENOS_UM && separadorDecimal.equals(".")) {

            valorNumerico = valor.substring(Numeros.NUM0, valor.indexOf('.'));
            valorDecimal = valor.substring(valor.indexOf('.'), valor.length());

            valor =
                            SiteUtil.completarZerosEsquerda(Numeros.NUM6, valorNumerico)
                                            + SiteUtil.completarZerosDireita(Numeros.NUM9, valorDecimal);

            valor = valor.replace(".", ",");

        }
        if (valor != null && valor.indexOf(',') != MENOS_UM && separadorDecimal.equals(",")) {

            valorNumerico = valor.substring(Numeros.NUM0, valor.indexOf(','));
            valorDecimal = valor.substring(valor.indexOf(','), valor.length());

            valor =
                            SiteUtil.completarZerosEsquerda(Numeros.NUM6, valorNumerico)
                                            + SiteUtil.completarZerosDireita(Numeros.NUM9, valorDecimal);

            valor = valor.replace(",", ".");
        } else if (valor == null) {
            valor = SiteUtil.STRING_EMPTY;
        }

        return valor;
    }

    /**
     * Atributo que retorna a lista de mensagens.
     */
    private static List<String> mensagensErroValidacaoCampos;

    /**
     * 
     * Nome: validarCamposExcl Propósito:
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 15/10/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static final boolean validarCamposExcl(final String form, String... camposExcessao) {
        Boolean retornaMensagem = false;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UIViewRoot viewRoot = facesContext.getViewRoot();
        // RECUPERA TODOS OS COMPONENTES DA TELA
        mensagensErroValidacaoCampos = new ArrayList<String>();
        UIComponent componentes = (UIComponent) viewRoot.findComponent(form);
        validarCampos(componentes, camposExcessao);

        // VERIFICA SE TEM ALGUMA MENSAGEM P/ SER EXIBIDA
        if (mensagensErroValidacaoCampos.size() > 0) {
            createModalMessageRequired(mensagensErroValidacaoCampos);
            
            retornaMensagem = true;
        }
        return retornaMensagem;
    }

    private static void validarCampos(UIComponent componente, String... excessao) {
        UIComponent objHTML = null;
        String campo = "";
        String value = null;
        Boolean valuePreenchido = false;
        String style = "";
        Boolean obrigatorio = false;

        if (componente instanceof HtmlSelectOneMenu) {
            objHTML = (HtmlSelectOneMenu) componente;
            campo = ((HtmlSelectOneMenu) componente).getTitle();
            style = ((HtmlSelectOneMenu) componente).getStyleClass();
            value = String.valueOf(((HtmlSelectOneMenu) componente).getValue());
            if (!value.equals(STRING_NULL) && value.length() > 0 && !value.equals("0")
                            && !value.equals(getString(Numeros.NUM999))) {
                valuePreenchido = true;
            }
            obrigatorio = verificaEstilo(style);
        } else if (componente instanceof UICnpj) {

            objHTML = (UICnpj) componente;
            campo = ((UICnpj) componente).getTitleInputsCnpj();
            style = ((UICnpj) componente).getStyleClassInputs();

            value = nullToString(((UICnpj) componente).getValue());

            if (value != null && value.length() > 0) {
                valuePreenchido = true;
            }

            obrigatorio = verificaEstilo(style);
        } else if (componente instanceof UICpf) {

            objHTML = (UICpf) componente;
            campo = ((UICpf) componente).getTitleInputsCpf();
            style = ((UICpf) componente).getStyleClassInputs();

            value = nullToString(((UICpf) componente).getValue());

            if (value != null && value.length() > 0) {
                valuePreenchido = true;
            }

            obrigatorio = verificaEstilo(style);
        } else if (componente instanceof HtmlInputText) {
            objHTML = (HtmlInputText) componente;
            campo = ((HtmlInputText) componente).getTitle();
            style = ((HtmlInputText) componente).getStyleClass();

            if (((HtmlInputText) componente).getValue() instanceof Integer) {
                Integer valor = (Integer) ((HtmlInputText) componente).getValue();
                value = String.valueOf(valor);
            } else if (((HtmlInputText) componente).getValue() instanceof Long) {
                Long valor = (Long) ((HtmlInputText) componente).getValue();
                value = String.valueOf(valor);
            } else if (((HtmlInputText) componente).getValue() instanceof Double) {
                Double valor = (Double) ((HtmlInputText) componente).getValue();
                value = String.valueOf(valor);
            } else if (((HtmlInputText) componente).getValue() instanceof BigDecimal) {
                BigDecimal valor = (BigDecimal) ((HtmlInputText) componente).getValue();
                value = String.valueOf(valor);
            } else
                value = (String) ((HtmlInputText) componente).getValue();

            if (value != null && value.length() > 0) {
                valuePreenchido = true;
            }

            obrigatorio = verificaEstilo(style);
        } else if (componente instanceof HtmlInputTextarea) {
            objHTML = (HtmlInputTextarea) componente;
            campo = ((HtmlInputTextarea) componente).getTitle();
            style = ((HtmlInputTextarea) componente).getStyleClass();
            value = (String) ((HtmlInputTextarea) componente).getValue();
            if (value != null && value.length() > 0) {
                valuePreenchido = true;
            }
            obrigatorio = verificaEstilo(style);
        } else if (componente instanceof UICalendarBase) {
            objHTML = (UICalendar) componente;
            style = ((UICalendar) componente).getStyleClass();
            Date dataCalendar = (Date) ((UICalendar) componente).getValue();
            String idCalendar = componente.getId();

            if (idCalendar.contains("Ini") || idCalendar.contains("De")) {
                campo = "Data Inicial";
            } else if (idCalendar.contains("Fin") || idCalendar.contains("Ate") || idCalendar.contains("Fim")) {
                campo = "Data Final";
            } else if (idCalendar.contains("Custom")) {
                return;
            } else {
                campo = "Data";
            }
            if (dataCalendar != null) {
                valuePreenchido = true;
            }
            obrigatorio = verificaEstilo(style);
        } else {
            if (componente.getChildren().size() > 0) {
                for (int i = 0; i < componente.getChildren().size(); i++) {
                    UIComponent uiComponent2 = (UIComponent) componente.getChildren().get(i);
                    validarCampos(uiComponent2, excessao);
                }
            }
        }

        if ((objHTML != null && !objHTML.getAttributes().isEmpty()) || (componente instanceof UICnpj)
                        || (componente instanceof UICpf) || (componente instanceof UICalendar)) {

            if (valuePreenchido == false && obrigatorio == true) {
                boolean validate = true;
                if (excessao != null && excessao.length > Numeros.NUM0.intValue() && objHTML.getId() != null) {
                    for (String excl : excessao) {
                        if (objHTML.getId().equals(excl)) {
                            validate = false;
                        }
                    }
                }

                // Adiciona campo obrigatório que não foi preenchido e não faz
                // parte da lista de Itens Excessão
                if (validate) {
                    mensagensErroValidacaoCampos.add(campo);
                }
            }
        }
    }

    /**
     * Introduzir aqui os comentarios necessarios para o método.
     * 
     * @param mensagem
     */
    public static void addMensagemCampo(final String mensagem) {
        if (mensagem != null) {
            // MENSAGEM
            FacesUtils.addErrorMessage(FIELD_VALIDATION_MESSAGE + mensagem + SELECTONE_VALIDATION_MESSAGE);
        }
    }

    /**
     * Nome: formatarCPFCCNPJ
     * 
     * Propósito: Formata um CPF ou CNPJ. Para CPF, recebe filial com 0.
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String formatarCPFCCNPJ(int numero, int filial, int digito) {
        String saida = null;
        if (numero == 0) {
            saida = "";
            return saida;
        }
        if (filial == 0) {
            saida = separadorMilhar(numero, 9);
        } else {
            saida = separadorMilhar(numero, 8);
            saida += "/" + completarZerosEsquerda(4, getString(filial));
        }
        saida += "-" + completarZerosEsquerda(2, getString(digito));
        return saida;
    }
    
    /**
     * Nome: formatarCnpjBase
     * 
     * Propósito: Retornar uma string com o cnpj base formatado.
     *
     * @param : numero
     * @return : cnpjBaseFormatado cnpj base no padrão 00.000.000
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 02/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
     public static String formatarCnpjBase(int numero) {
         
         String cnpjBaseFormatado = null;
         
         // Verifica se o número do cnpj base não veio zerado.
         if (numero == 0) {
             cnpjBaseFormatado = "";
         } else {
             
             // Formata o cnpj base no padrão 00.000.000
             cnpjBaseFormatado = separadorMilhar(numero, 8);
         }
         return cnpjBaseFormatado;
     }

	/**
	* Nome: separadorMilhar
	* 
	* Propósito: 
	*
	* @param : 
	* @return : 
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 02/06/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
    private static String separadorMilhar(long numero, int tamanhoMinimo) {
        String saida = "";
        int qtdDig = (int) Math.max(Math.floor(Math.log10(numero)) + 1, tamanhoMinimo);
        do {
            saida = completarZerosEsquerda(qtdDig > 3 ? 3 : qtdDig, getString(numero % 1000)) + saida;
            numero /= 1000;
            qtdDig -= 3;
            if ((qtdDig > 0))
                saida = "." + saida;
        } while ((qtdDig > 0));
        return saida;
    }

    /**
     * Nome: formatarCPFCCNPJ
     * 
     * Propósito: Formata um CPF ou CNPJ, considera que se a quantidade de digitos for maior que 11 é CNPJ, senão CPF.
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String formatarCPFCCNPJ(long entrada) {
        int numero = 0, filial = 0, digito = 0;
        digito = (int) (entrada % 100);
        if (!isCpf(entrada)) {
            entrada = entrada / 100;
            filial = (int) (entrada % 10000);
            entrada = entrada / 10000;
        }
        numero = (int) entrada;

        return formatarCPFCCNPJ(numero, filial, digito);
    }

    /**
     * 
     * Nome: formatarCnpjComponente Propósito:
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static CnpjDataType formatarCnpjComponente(CnpjDataType cpf, Integer numero, Integer filial, Integer digito) {

        String cnpjBase = null;
        String numeroFilial = null;
        String controle = null;
        cpf = new CnpjDataType();

        // Verifica se o número do cnpj esta preenchido.
        if (numero != null && numero.compareTo(Numeros.NUM0) != Numeros.NUM0) {

            cnpjBase = completarZerosEsquerda(Numeros.NUM8, getString(numero));
            numeroFilial = completarZerosEsquerda(Numeros.NUM4, getString(filial));
            controle = completarZerosEsquerda(Numeros.NUM2, getString(digito));

            cpf.setCnpjCampo1(cnpjBase.substring(Numeros.NUM0, Numeros.NUM2));
            cpf.setCnpjCampo2(cnpjBase.substring(Numeros.NUM2, Numeros.NUM5));
            cpf.setCnpjCampo3(cnpjBase.substring(Numeros.NUM5, Numeros.NUM8));
            cpf.setCnpjCampo4(numeroFilial);
            cpf.setCnpjCampo5(controle);
        }

        return cpf;
    }

    /**
     * 
     * Nome: formatarCnpjComponente Propósito:
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static CpfDataType formatarCpfComponente(CpfDataType cpf, Integer numero, Integer digito) {

        String cnpjBase = null;
        String controle = null;
        cpf = new CpfDataType();

        // Verifica se o número do cpf esta preenchido.
        if (numero != null && numero.compareTo(Numeros.NUM0) != Numeros.NUM0) {

            cnpjBase = completarZerosEsquerda(Numeros.NUM9, getString(numero));
            controle = completarZerosEsquerda(Numeros.NUM2, getString(digito));

            cpf.setCpfCampo1(cnpjBase.substring(Numeros.NUM0, Numeros.NUM3));
            cpf.setCpfCampo2(cnpjBase.substring(Numeros.NUM3, Numeros.NUM6));
            cpf.setCpfCampo3(cnpjBase.substring(Numeros.NUM6, Numeros.NUM9));
            cpf.setCpfCampo4(controle);
        }

        return cpf;
    }
    
    /**
     * Nome: cpfComponenteToStringFormatado
     * 
     * Propósito: Retornar uma string com o CPF formatado.
     *
     * @param : cpf CpfDataType
     * @return : cpfFormatado
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 02/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
     public static String cpfComponenteToStringFormatado(CpfDataType cpf) {

         String cpfFormatado = null;
         int cnpjBase;
         int filial = Numeros.NUM0.intValue();
         int controle;

         // Verifica se componente cpf não esta nulo.
         if (cpf != null) {

             cnpjBase = nullToInt(cpf.getCpfCampo1().concat(cpf.getCpfCampo2()).concat(cpf.getCpfCampo3()));
             controle = nullToInt(cpf.getCpfCampo4());

             // Formata o CPF para o padrão 000.000.000-00
             cpfFormatado = formatarCPFCCNPJ(cnpjBase, filial, controle);
         }

         return cpfFormatado;
     }
     
     /**
     * Nome: cnpjComponenteToStringFormatado
     * 
     * Propósito: Retornar uma string com o CNPJ formatado.
     *
     * @param : cnpj CnpjDataType
     * @return : cpfFormatado
     * @throws :
     * @exception : 
     * @see : Referencias externas.  
     *
     * Registro  de Manutenção: 02/06/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
     public static String cnpjComponenteToStringFormatado(CnpjDataType cnpj) {

         String cnpjFormatado = null;
         int cnpjBase;
         int filial;
         int controle;

         // Verifica se componente cpf não esta nulo.
         if (cnpj != null) {

             cnpjBase = nullToInt(cnpj.getCnpjCampo1().concat(cnpj.getCnpjCampo2()).concat(cnpj.getCnpjCampo3()));
             filial = nullToInt(cnpj.getCnpjCampo4());
             controle = nullToInt(cnpj.getCnpjCampo5());

             // Verifica se é Cnpj base ou Cnpj completo de acordo com os valores da filial e do controle.
             if (filial == 0 && controle == 0) {
                 // Formata o CNPJ para o padrão 000.000.000
                 cnpjFormatado = formatarCnpjBase(cnpjBase);
             } else {
                 // Formata o CNPJ para o padrão 000.000.000/0000-00
                 cnpjFormatado = formatarCPFCCNPJ(cnpjBase, filial, controle);
             }
         }

         return cnpjFormatado;
     }

    /**
     * Nome: isCpf
     * 
     * Propósito: Valida se o valor é um CPF válido
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static boolean isCpf(long entrada) {
        // cpf = AAA.AAA.AAA-DV
        // dv = d1 * 10 + d2
        if (String.valueOf(entrada).length() > 11) {
            return false;
        }
        long dv = entrada % 100;
        entrada /= 10;
        int d2 = 0;
        for (int i = 1; i <= 10; i++) {
            long x = entrada % (long) Math.pow(10, 11 - i);
            long y = x / (long) Math.pow(10, 10 - i);
            d2 += y * (i - 1);
        }
        d2 = (d2 % 11) % 10;
        entrada /= 10;
        int d1 = 0;
        for (int i = 1; i <= 9; i++) {
            long x = entrada % (long) Math.pow(10, 10 - i);
            long y = x / (long) Math.pow(10, 9 - i);
            d1 += y * i;
        }
        d1 = (d1 % 11) % 10;
        return dv == (d1 * 10 + d2);
    }

    /**
     * Nome: doubleToBrowserMoeda
     * 
     * Propósito: Converte um BigDecimal para o formato de numeros decimais
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 05/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String doubleToBrowserMoeda(BigDecimal valor, int decimais) {
        return doubleToBrowserMoeda(valor.doubleValue(), decimais);
    }

    /**
     * Nome: StringToBrowserMoeda
     * 
     * Propósito: Formata uma Valor String com separador de Milhar e decimais
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 05/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String StringToBrowserMoeda(String valor, int decimais) {
        double db = Double.valueOf(valor);
        return doubleToBrowserMoeda(db, decimais);
    }

    /**
     * Nome: doubleToBrowserMoeda
     * 
     * Propósito: Converte um double para o formato de numeros decimais utilizados
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 05/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String doubleToBrowserMoeda(double valor, int decimais) {
        NumberFormat nf = NumberFormat.getNumberInstance(locale);
        nf.setMaximumFractionDigits(decimais);
        nf.setMinimumFractionDigits(decimais);
        return nf.format(valor);
    }

    /**
     * Nome: doubleToBrowserMoeda
     * 
     * Propósito: Converte um BigDecimal para o formato de numeros decimais utilizados com o valor de 2 decimais
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 05/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String doubleToBrowserMoeda(BigDecimal valor) {
        return doubleToBrowserMoeda(valor.doubleValue());
    }

    /**
     * Nome: doubleToBrowserMoeda
     * 
     * Propósito: Converte um double para o formato de numeros decimais utilizados com 2 decimais
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 05/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String doubleToBrowserMoeda(double valor) {
        return doubleToBrowserMoeda(valor, 2);
    }

    /**
     * 
     * Nome: listaComboVazio Propósito: Popula o combo com a opção "Selecione" apenas.
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 16/11/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static List<SelectItem> listaComboVazio() {
        List<SelectItem> itens = new ArrayList<SelectItem>();
        itens.add(new SelectItem("0", SELECIONE));
        return itens;
    }

    /**
     * Nome: formatarValorWeb
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 07/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String formatarValorWeb(Object valor) {

        String retorno = null;
        String valorSemFormatacao = null;
        String centavos = null;
        String decimais = null;

        valorSemFormatacao = nullToString(valor);

        FormatadorParaView formatador = new FormatadorParaView();

        // Se o valor vier da transação com ponto então o valor será
        // tratado pelo formatador decimalFormat, caso contrário
        // será tratado no bloco "else" para acrescentar o ponto após duas casas decimais.

        if (valorSemFormatacao.equals("0.00")) {
            retorno = "0,00";
        } else if (valorSemFormatacao.contains(".")) {

            retorno = formatador.formatoMilhar(valorSemFormatacao);

        } else if (valorSemFormatacao.equals("") || valorSemFormatacao.equals("0")) {

            retorno = "0,00";

        } else {
            decimais = valorSemFormatacao.substring(0, valorSemFormatacao.length() - 2);
            centavos = valorSemFormatacao.substring(valorSemFormatacao.length() - 2, valorSemFormatacao.length());
            valorSemFormatacao = decimais.concat(".").concat(centavos);
            retorno = formatador.formatoMilhar(valorSemFormatacao);
        }

        return retorno;
    }

    /**
     * 
     * Nome: formatarPontosVirgula Propósito:
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 04/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String formatarPontosVirgula(String valor) {
        if (valor != null && valor.indexOf(',') != Numeros.MENOS_UM) {
            valor = valor.replace(".", "");
            valor = valor.replace(',', '.');
        }
        return valor;
    }

    /**
     * 
     * Nome: compararIgualdadeValorCampos Propósito:
     *
     * @param : <BR/>
     * @return :
     *
     * @throws :
     * 
     * @exception :
     *
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 15/12/2015 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static Boolean compararIgualdadeValorCampos(Object campoUm, Object campoDois) {

        Boolean itensIguais = Boolean.FALSE;
        String campoUmStr = null;
        String campoDoisStr = null;

        campoUmStr = nullToString(campoUm);
        campoDoisStr = nullToString(campoDois);

        // Verifica se os campos tem o mesmo valor, caso sejam diferentes deve-se setar "true"
        // para que na lista seja definido o styleClass que mostra que os valores foram alterados.
        if (!campoUmStr.equals(campoDoisStr)) {
            itensIguais = Boolean.TRUE;
        }

        return itensIguais;
    }

    /**
     * 
     * Nome: mainframeToBoolean
     * 
     * Propósito: Retorna o indicador booleano de acordo com o Mainframe
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 03/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static boolean mainframeToBoolean(String valor) {
        if (valor != null && valor.equalsIgnoreCase("S")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * Nome: indicadorSimNao
     * 
     * Propósito: Retorna texto de acordo com indicador Mainframe S/N
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 03/02/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String indicadorSimNao(String valor) {
        if (valor != null && valor.equalsIgnoreCase("S") || valor.equals("1")) {
            return SIM;
        } else {
            return NAO;
        }
    }

    /**
     * Nome: getApplicationProperty
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 05/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String getApplicationProperty(String propertyKey) {
        IConfigPropertyManager propertyManager = BradescoCommonServiceFactory.getPropertieManager();

        return propertyManager.getProperty(propertyKey);
    }

    /**
     * Nome: formatarTel
     * 
     * Propósito: Formata um Telefone considerando o tamanho 11 caracteres 99999999999 para (999) 9999-9999
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String formatarTel(int ddd, int numero) {
        return formatarTel(0, ddd, numero);
    }

    /**
     * Nome: formatarTel
     * 
     * Propósito: Formata um Telefone considerando o tamanho 14 caracteres 99999999999 para +999 (999) 9999-9999
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 08/03/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static String formatarTel(int ddi, int ddd, int numero) {
        String saida = "";
        if (ddi != 0)
            saida += "+" + ddi + " ";
        if (ddd != 0)
            saida += "(" + ddd + ") ";
        int aux = numero / 10000;
        if (aux != 0) {
            saida += aux + "-";
        }
        saida += numero % 10000;
        return saida;
    }
    
    /**
     * Nome: formatarReferenciaBradesco
     * 
     * Formatar referência Bradesco conforme padrão 0000/000000000.
     * 
     * @param valor the valor
     * @return string
     * @see
     */
    public static String formatarReferenciaBradesco(Integer anoBase, Integer numeroBoleto) {
        // Apenas formatara se os dois valores não forem nulos
        if (anoBase == null || numeroBoleto == null) {
            return "";
        }
        
        return String.format("%d/%s", anoBase, TextUtil.padLeft(numeroBoleto.toString(), 9, "0"));
    }
    
    /**
     * Nome: formatarPontosVirgula
     * 
     * Formatar pontos virgula.
     * 
     * @param valor the valor
     * @return string
     * @see
     */
    public static String trocarUnderlinePorMais(String valor) {
        if (valor != null && valor.indexOf('_') != MENOS_UM) {
            valor = valor.replace('_', '+');
        } else if (valor == null) {
            valor = SiteUtil.STRING_EMPTY;
        }

        return valor;
    }

    /**
     * Converte um número Indo-Arábico para número Romano
     * 
     * Estratégia: O método mapeia todos os simbolos romanos com seus valores
     * arábicos e percorre o Array mapeado a fim de encontrar o simbolo romano
     * que corresponde ao valor numérico arábico. As comparações são realizadas
     * da direita para esquenda, pois desta forma os números de maior ordem são
     * contabilizados primeiro.
     * 
     * @param número
     *            Indo-Arábico
     * @return número Romano
     */
    public static String arabicoToRomano(Integer arabico) {
        int[] arabicos = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        String[] romanos = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };

        String romano = "";
        for (int i = 12; i >= 0; i--) {
            while (arabico >= arabicos[i]) {
                arabico -= arabicos[i];
                romano += romanos[i];
            }
        }
        return romano;
    }
    
    	/**
    	* Nome: dateDiffInDays
    	* 
    	* Propósito: 
    	*
    	* @param : 
    	* @return : 
    	* @throws :
    	* @exception : 
    	* @see : Referencias externas.	
    	*
    	* Registro  de Manutenção: 01/06/2016
    	*        - Autor: BRQ
    	*        - Responsavel: Equipe Web
    	*        - Adequação ao padrão hexavision.
    	*/
    public static long dateDiffInDays(Date begin, Date end) {
        if (begin != null && end != null) {
            return (end.getTime() - begin.getTime()) / DAY_TIME_MILLISECONDS;
        } else {
            return -1;
        }
    }
    
	/**
	* Nome: recuperarUsuarioLogado
	* 
	* Propósito: Recuperar a chave (ID) do usuário logado.
	*
	* @param : 
	* @return : usuario
	* @throws :
	* @exception : 
	* @see : Referencias externas.	
	*
	* Registro  de Manutenção: 08/06/2016
	*        - Autor: BRQ
	*        - Responsavel: Equipe Web
	*        - Adequação ao padrão hexavision.
	*/
    public static String recuperarUsuarioLogado(){
        
        String usuario = null;
        
        ISecurityManager securityManager = null;
        ICoreSecurityManager coreSecurityManager = BradescoCommonServiceFactory.getSecurityManager();

        if ((coreSecurityManager instanceof ISecurityManager)) {
            securityManager = (ISecurityManager) coreSecurityManager;
        } else {
            throw new BradescoArchitectureException("Security Manager não disponível");
        }
        
        usuario = securityManager.getUserId();
        
        return usuario;
    }
    

    /**
     * Nome: calculaDias
     * 
     * Propósito: Efetua o calculo de Dias duas datas tipo String
     *
     * @param :
     * @return :
     * @throws :
     * @exception :co
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/05/2016 - Autor: BRQ - Francinaldo - Responsavel: Equipe Web - Adequação ao
     *      padrão hexavision.
     */
    public static Integer calculaDias(Date inicio, Date fim) {
        Integer dias = Numeros.ZERO;
        GregorianCalendar dataInicio = new GregorianCalendar();
        GregorianCalendar dataFim = new GregorianCalendar();

        try {
            dataInicio.setTime(inicio);
            dataFim.setTime(fim);
        } catch (Exception e) {
            return dias;
        }
        long dt1 = dataInicio.getTimeInMillis();
        long dt2 = dataFim.getTimeInMillis();
        dias = (int) ((dt2 - dt1) / DAY_TIME_MILLISECONDS);

        return dias;
    }
    
    /**
     * Nome: calculaData
     * 
     * Propósito: Calcula a Data Final com base em um Date DataBase e no Prazo em Meses
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 07/01/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    public static Date calculaData(Date data, Integer prazo) {
        Calendar c = Calendar.getInstance();

        try {
            c.setTime(data);
            c.add(Calendar.DAY_OF_YEAR, prazo);
        } catch (Exception e) {
            return null;
        }

        return c.getTime();
    }

	public static String montarTexto(Object... partes) {
		StringBuilder valorRetorno = new StringBuilder("");
		
		for (Object parte : partes) {
			valorRetorno.append(parte);
		}
		
		return valorRetorno.toString();
	}

}
