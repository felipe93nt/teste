package br.com.bradesco.web.npcc_trade.utils.components;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Nome: DateTime.java
 * 
 * Propósito: <p> Manipulação de datas </p>
 *
 * @author :  BRQ - Nicholas M. Dantas
 * Equipe : Web <BR>
 * @version:  1.5
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 19/08/2016
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public class DateTime {
    private static String DEFAULT_SHORT_PATTERN = "dd-MM-yyyy";
    private static String DEFAULT_CITY = "São Paulo";
    //private static String DEFAULT_FULL_PATTERN = "dd-MM-yyyy hh:mm:ss";
    
    private Calendar calendar;
    private Date value;

    /**
     * Nome: getNow
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 19/08/2016
     *        - Autor: BRQ - Francinaldo
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public static Date getNow() {
        return new Date();
    }

    /**
     * Nome: getToday
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 19/08/2016
     *        - Autor: BRQ - Francinaldo
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public static Date getToday() {
        Date now = getNow();

        return clearTime(now);
    }

    /**
     * Nome: clearTime
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 19/08/2016
     *        - Autor: BRQ - Francinaldo
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public static Date clearTime(Date date) {
        // Verifica a nulidade
        if (date == null) {
            return null;
        }

        Calendar calendarInstance = Calendar.getInstance();

        calendarInstance.setTime(date);
        calendarInstance.set(Calendar.HOUR_OF_DAY, 0);
        calendarInstance.set(Calendar.MINUTE, 0);
        calendarInstance.set(Calendar.SECOND, 0);
        calendarInstance.set(Calendar.MILLISECOND, 0);

        return calendarInstance.getTime();
    }

    /**
     * Nome: clearDate
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 19/08/2016
     *        - Autor: BRQ - Francinaldo
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public static void clearDate(Date date) {
        // Verifica a nulidade
        if (date == null) {
            return;
        }

        Calendar calendarInstance = Calendar.getInstance();

        calendarInstance.setTime(date);
        calendarInstance.set(Calendar.DAY_OF_MONTH, 0);
        calendarInstance.set(Calendar.MONTH, 0);
        calendarInstance.set(Calendar.YEAR, 0);

        date = calendarInstance.getTime();
    }

    /**
     * Nome: isValid
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 19/08/2016
     *        - Autor: BRQ - Francinaldo
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public static boolean isValid(String dateTime) {
        return tryParse(dateTime);
    }

    /**
     * Nome: tryParse
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 19/08/2016
     *        - Autor: BRQ - Francinaldo
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public static boolean tryParse(String date) {
        // Verifica a nulidade
        if (date == null || date.trim().length() == 0) {
            return false;
        }

        return tryParse(date, DEFAULT_SHORT_PATTERN);
    }
    
    /**
     * Nome: tryParse
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 19/08/2016
     *        - Autor: BRQ - Francinaldo
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public static boolean tryParse(String date, String format) {
        // Verifica a nulidade
        if (date == null || date.trim().length() == 0 || 
            format == null || format.trim().length() == 0) {
            
            return false;
        }
        
        date = date.replaceAll("\\.", "-")
                   .replaceAll("/", "-");
        
        SimpleDateFormat formatFactory = new SimpleDateFormat(format);
        formatFactory.setLenient(false);
        
        try {
            formatFactory.parse(date);
            
            return true;
        } catch (ParseException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    /**
     * Nome: tryParse
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 19/08/2016
     *        - Autor: BRQ - Francinaldo
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public static boolean tryParse(String date, Date outDate) {
        // Verifica a nulidade
        if (date == null || date.trim().length() == 0) {
            outDate = null;

            return false;
        }

        return tryParse(date, DEFAULT_SHORT_PATTERN, outDate);
    }

    /**
     * Nome: tryParse
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 19/08/2016
     *        - Autor: BRQ - Francinaldo
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public static boolean tryParse(String date, String format, Date outDate) {
        // Verifica a nulidade
        if (date == null || date.trim().length() == 0 || 
            format == null || format.trim().length() == 0) {
            
            return false;
        }
        
        date = date.replaceAll("\\.", "-")
                   .replaceAll("/", "-");
        
        SimpleDateFormat formatFactory = new SimpleDateFormat(format);
        formatFactory.setLenient(false);
        
        try {
            outDate = formatFactory.parse(date);
            
            return true;
        } catch (ParseException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    /**
     * Nome: inWords
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 13/12/2016
     *        - Autor: BRQ - Francinaldo
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public static String inWords(Date date) {        
        return inWords(date, DEFAULT_CITY);
    }
    
    /**
     * Nome: inWords
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 13/12/2016
     *        - Autor: BRQ - Francinaldo
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public static String inWords(Date date, String city) {
        if (date == null) {
            return null;
        }
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                        String.format("'%s,' dd 'de' MMMMM 'de' yyyy", city), 
                        new Locale("pt", "BR"));
        
        return simpleDateFormat.format(date);
    }
    
    /**
     * Construtor
     * 
     * @param 
     */
    public DateTime() {
        super();

        this.value = new Date();
        this.calendar = Calendar.getInstance();
        this.calendar.setTime(value);
    }

    /**
     * Construtor
     * 
     * @param @param value
     */
    public DateTime(Date value) {
        super();

        this.value = value;

        // Verifica a nulidade
        if (value != null) {
            this.calendar = Calendar.getInstance();
            this.calendar.setTime(value);
        } 
    }

    /**
     * Nome: clearTime
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 19/08/2016
     *        - Autor: BRQ - Francinaldo
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void clearTime() {
        this.value = clearTime(getValue());
    }

    /**
     * Nome: clearDate
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 19/08/2016
     *        - Autor: BRQ - Francinaldo
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public void clearDate() {
        clearDate(getValue());
    }
    
    /**
     * Nome: getInWords
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 13/12/2016
     *        - Autor: BRQ - Francinaldo
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public String getInWords() {
        return inWords(getValue());
    }
    
    /**
     * Nome: getInWords
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 13/12/2016
     *        - Autor: BRQ - Francinaldo
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public String getInWords(String city) {
        return inWords(getValue(), city);
    }

    /**
     * Nome: diff
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 19/08/2016
     *        - Autor: BRQ - Francinaldo
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public TimeSpan diff(DateTime anotherDateTime) {
        return TimeSpan.diff(this, anotherDateTime);
    }
    
    /**
     * @return o valor do value
     */
    public Date getValue() {
        return value;
    }

    /**
     * @return o valor do years
     */
    public int getYear() {
        // Verifica a nulidade
        if (this.calendar == null) {
            return 0;
        }

        return this.calendar.get(Calendar.YEAR);
    }

    /**
     * @return o valor do months
     */
    public int getMonth() {
        // Verifica a nulidade
        if (this.calendar == null) {
            return 0;
        }

        return this.calendar.get(Calendar.MONTH);
    }

    /**
     * @return o valor do days
     */
    public int getDay() {
        // Verifica a nulidade
        if (this.calendar == null) {
            return 0;
        }

        return this.calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * @return o valor do hours
     */
    public int getHour() {
        // Verifica a nulidade
        if (this.calendar == null) {
            return 0;
        }

        return this.calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * @return o valor do minutes
     */
    public int getMinutes() {
        // Verifica a nulidade
        if (this.calendar == null) {
            return 0;
        }

        return this.calendar.get(Calendar.MINUTE);
    }

    /**
     * @return o valor do seconds
     */
    public int getSeconds() {
        // Verifica a nulidade
        if (this.calendar == null) {
            return 0;
        }

        return this.calendar.get(Calendar.SECOND);
    }

    /**
     * @return o valor do milliseconds
     */
    public int getMilliseconds() {
        // Verifica a nulidade
        if (this.calendar == null) {
            return 0;
        }

        return this.calendar.get(Calendar.MILLISECOND);
    }

    /**
     * @return o valor do time
     */
    public long getTime() {
        // Verifica a nulidade
        if (getValue() == null) {
            return 0L;
        }

        return getValue().getTime();
    }

    @Override
    public boolean equals(Object anotherDate) {
        // Verifica a nulidade
        if (anotherDate == null || getTime() == 0){
            return false;
        }

        // Verifica se é uma instancia que pode haver comparação
        if (anotherDate instanceof DateTime) {
            DateTime instance = (DateTime)anotherDate;

            return getTime() == instance.getTime();
        } else {
            return false;
        }
    }
}
