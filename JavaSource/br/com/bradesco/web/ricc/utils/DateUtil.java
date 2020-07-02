package br.com.bradesco.web.ricc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

@Named(value= "dateUtil")
@Singleton
public final class DateUtil {

	public static final String DATA_SEM_HORA_BARRA = "dd/MM/yyyy";

	public static final String DATA_HORA_APRESENTACAO = "dd/MM/yyyy 'às' HH:mm:ss";

	public static final String DATA_SEM_HORA_PONTO = "dd.MM.yyyy";

	public static final String DATA_COM_HORA_PONTO = "dd.MM.yyyy HH:mm";

	public static final String DATA_COM_HORA_HIFEN = "yyyy-MM-dd-HH.mm";

	public static final String TIMESTAMP = "yyyy-MM-dd HH.mm.ss.SSSSS";

	public static final String HORA = "HH:mm:ss";

	public static final String DATA_COM_HORA_BARRA = "dd/MM/yyyy HH:mm:ss";

	public static final String DATA = "dd";

	private static DatatypeFactory df = null;

	private static DateUtil instance = null;

	private SiteUtil siteUtil = SiteUtil.getInstance();

	private DateUtil() {

	}

	public static DateUtil getCurrentInstance() {
		if (instance == null) {
			instance = new DateUtil();
		}
		return instance;
	}

	public String formatarDataDiaMesAno(Date data){
		SimpleDateFormat sdf = new SimpleDateFormat(RiccConstants.FORMATO_DIA_MES_ANO);
		return sdf.format(data);
	}


	public String formatarDataHora(Date date) {
		if(date != null){
			SimpleDateFormat sdf = new SimpleDateFormat(RiccConstants.FORMATO_DATA_HORA);
			return sdf.format(date);
		} else {
			return null;
		}
	}

	public String formatarDataTimestamp(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(TIMESTAMP);
		return sdf.format(date);
	}

	public Date transformarStringParaDate(String date, String pattern) {
		if (siteUtil.isEmptyOrNull(date)) {
			return null;
		}
		Date retorno = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			retorno = format.parse(date);
		} catch (Exception e) {
			retorno = null;
		}
		return retorno;
	}

	public String transformarDateParaStringComHora(Date date, String pattern) {
		if (date == null) {
			return "";
		}
		pattern = DATA_HORA_APRESENTACAO;
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	@SuppressWarnings("deprecation")
	public Long patternTimestamp(Date data, String hora) {

		Integer hour = Integer.parseInt(hora.substring(0,2));
		Integer min = Integer.parseInt(hora.substring(3,5));
		Integer sec = Integer.parseInt(hora.substring(6, hora.length()));

		data.setHours(hour);
		data.setMinutes(min);
		data.setSeconds(sec);

		String horaFormatada = hora.replace(":", ".");

		String dataFormatada = formatarDataTimestamp(data);
		dataFormatada.replace(dataFormatada.substring(11, 19), horaFormatada);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.getTimeInMillis();

		return calendar.getTimeInMillis();
	}

	static {

		try {
			df = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
			throw new IllegalStateException(
					"Error while trying to obtain a new instance of DatatypeFactory",
					e);
		}
	}

	public XMLGregorianCalendar dateToXMLGregorianCalendar(java.util.Date  date) {

		if (date == null) {
			return null;
		} else {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTimeInMillis(date.getTime());
			return df.newXMLGregorianCalendar(gc);
		}
	}

	public XMLGregorianCalendar longToXmlGregorianCalendar(Long timestamp) {
		GregorianCalendar gc = new GregorianCalendar();

		if (timestamp == null) {
			gc.setTime(new Date(0));
			return df.newXMLGregorianCalendar(gc);
		}else {
			gc.setTimeInMillis(timestamp);
			return df.newXMLGregorianCalendar(gc);
		}
	}

	public String dateToString(Date date, String pattern) {
		if (siteUtil.isNull(date)) {
			return "";
		}

		if (siteUtil.isEmptyOrNull(pattern)) {
			throw new IllegalArgumentException(
					"Padrão não pode ser nulo ou vazio!");
		}

		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	public String formatarHora(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(RiccConstants.FORMATO_HORA);
		return sdf.format(date);
	}

	  /**
     * Método que retorna uma Data ou Hora em um formato específico, definido pelo cliente, a partir de uma
     * variável de entrada Data e/ou Hora.
     *
     * @param pDateString
     *        Data ou Hora a ter o formato modificado
     * @param pPadraoOrigem
     *        Formato inicial da Data ou Hora. Ex: yyyy/MM/dd-HH:mm:ss
     * @param pPadraoDestino
     *        Formato da Data ou Hora a ser retornada
     * @return String com o formato de data ou hora
     * @throws ParseException caso ocorra um erro na formatação
     */
    public String changeStringDateFormat(String pDateString, String pPadraoOrigem, String pPadraoDestino) {
        try {
			if (siteUtil.isEmptyOrNull(pDateString)) {
			    return pDateString;
			}
			return dateToString(stringToDate(pDateString, pPadraoOrigem), pPadraoDestino);
		} catch (Exception e) {
			return "";
		}
    }

    /**
     * Cria um objeto Date a partir de uma String e um padrão. Exemplo de pattern: ddMMyyyy.
     *
     * @param date
     *        Data a ser criada.
     * @param pattern
     *        padrão.
     * @return Data criada
     * @throws ParseException
     *         Caso ocorra algum erro.
     */
    public Date stringToDate(String date, String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
			return format.parse(date);
		} catch (Exception e) {
			return  null;
			
		}
    }
    
    /**
	 * Get: dataAtual.
	 * 
	 * @return dataAtual
	 */
	public Date getDataAtual() {
		Calendar data = getCalendarAtual();

		return data.getTime();
	}
	
	 /**
     * Nome: getCalendarAtual
     * 
     * @return
     */
    private Calendar getCalendarAtual() {
        Calendar data = Calendar.getInstance(SiteUtil.PT_BR);
		data.set(Calendar.HOUR_OF_DAY, 0);
		data.set(Calendar.MINUTE, 0);
		data.set(Calendar.SECOND, 0);
		data.set(Calendar.MILLISECOND, 0);
        return data;
    }
	
	/**
	 * Igual maior.
	 * 
	 * @param data1
	 *            the data1
	 * @param data2
	 *            the data2
	 * @return true, if igual maior
	 */
	public boolean igualMaior(Date data1, Date data2) {
		if (!igual(data1, data2)) {
			return data1.after(data2);
		}
		return true;
	}

	/**
	 * Igual.
	 * 
	 * @param data1
	 *            the data1
	 * @param data2
	 *            the data2
	 * @return true, if igual
	 */
	public boolean igual(Date data1, Date data2) {
		return org.apache.commons.lang.time.DateUtils.isSameDay(data1, data2);
	}
 
	/**
	 * Igual maior.
	 * 
	 * @param data1
	 *            the data1
	 * @param data2
	 *            the data2
	 * @return true, if igual maior
	 */
	public boolean igualMenor(Date data1, Date data2) {
		if (!igual(data1, data2)) {
			return data1.before(data2);
		}
		return true;
	}
	
	public boolean validarAno(int ano, int minimo, int maximo) {
		return ano == 0 || (ano > minimo && ano < maximo);
	}
	
}


