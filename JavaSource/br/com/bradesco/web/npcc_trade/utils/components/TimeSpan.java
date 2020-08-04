package br.com.bradesco.web.npcc_trade.utils.components;

import java.util.Date;

/**
 * Nome: TimeSpan.java
 * 
 * Propósito: <p> Dados de intervalo de tempo </p>
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
public class TimeSpan {
    private static final long MILLISECONDS_IN_DAY    = 24 * 60 * 60 * 1000;
    
    private int years;
    private int months;
    private int days;
    private int hours;
    private int minutes;
    private int seconds;
    private int milliseconds;
    
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
    public static TimeSpan diff(Date begin, Date end) {
        // Verifica se um dos campos é nulo
        if (begin == null || end == null) {
            return new TimeSpan(0, 0, 0);
        }
        
        return diff(new DateTime(begin), new DateTime(end));
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
    public static TimeSpan diff(DateTime begin, DateTime end) {
        // Verifica se um dos campos é nulo
        if (begin == null || end == null || begin.getTime() == 0L || end.getTime() == 0L) {
            return new TimeSpan(0, 0, 0);
        }
        
        int yearsDiff = end.getYear() - begin.getYear();
        int monthsDiff = (end.getMonth() - begin.getMonth()) + (12 * yearsDiff);
        int daysDiff = (int)((end.getTime() - begin.getTime()) / MILLISECONDS_IN_DAY);
        int hoursDiff = end.getHour() - begin.getHour();
        int minutesDiff = end.getMinutes() - begin.getMinutes();
        int secondsDiff = end.getSeconds() - begin.getSeconds();
        int millisecondsDiff = end.getMilliseconds() - begin.getMilliseconds();
        
        return new TimeSpan(yearsDiff, monthsDiff, daysDiff, hoursDiff, minutesDiff, secondsDiff, millisecondsDiff);
    }

    /**
     * Construtor
     * 
     * @param @param years
     * @param @param months
     * @param @param days
     */
    public TimeSpan(int years, int months, int days) {
        super();

        this.years = years;
        this.months = months;
        this.days = days;
    }

    /**
     * Construtor
     * 
     * @param @param days
     * @param @param hours
     * @param @param minutes
     * @param @param seconds
     */
    public TimeSpan(int days, int hours, int minutes, int seconds) {
        this(0, 0, days);

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    
    /**
     * Construtor
     * 
     * @param @param years
     * @param @param months
     * @param @param days
     * @param @param hours
     * @param @param minutes
     * @param @param seconds
     */
    public TimeSpan(int years, int months, int days, int hours, int minutes, int seconds) {
        super();
        
        this.years = years;
        this.months = months;
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     * Construtor
     * 
     * @param @param years
     * @param @param months
     * @param @param days
     * @param @param hours
     * @param @param minutes
     * @param @param seconds
     * @param @param milliseconds
     */
    public TimeSpan(int years, int months, int days, int hours, int minutes, int seconds, int milliseconds) {
        super();
        
        this.years = years;
        this.months = months;
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.milliseconds = milliseconds;
    }
        
    /**
     * Construtor
     * 
     * @param @param begin
     * @param @param end
     */
    public TimeSpan(DateTime begin, DateTime end) {
        super();
        
        TimeSpan timeSpan = diff(begin, end);
        this.years = timeSpan.getYears();
        this.months = timeSpan.getMonths();
        this.days = timeSpan.getDays();
        this.hours = timeSpan.getHours();
        this.minutes = timeSpan.getMinutes();
        this.seconds = timeSpan.getSeconds();
        this.milliseconds = timeSpan.getMilliseconds();
    }
    
    /**
     * Construtor
     * 
     * @param @param begin
     * @param @param end
     */
    public TimeSpan(Date begin, Date end) {
        super();
        
        TimeSpan timeSpan = diff(begin, end);
        this.years = timeSpan.getYears();
        this.months = timeSpan.getMonths();
        this.days = timeSpan.getDays();
        this.hours = timeSpan.getHours();
        this.minutes = timeSpan.getMinutes();
        this.seconds = timeSpan.getSeconds();
        this.milliseconds = timeSpan.getMilliseconds();
    }
    
    /**
     * Nome: isEmpty
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
    public boolean isEmpty() {
        boolean empty = true;
        
        empty &= getYears() == 0;
        empty &= getMonths() == 0;
        empty &= getDays() == 0;
        empty &= getHours() == 0;
        empty &= getMinutes() == 0;
        empty &= getSeconds() == 0;
        empty &= getMilliseconds() == 0;
        
        return empty;
    }
    
    /**
     * @return o valor do years
     */
    public int getYears() {
        return years;
    }

    /**
     * @return o valor do months
     */
    public int getMonths() {
        return months;
    }

    /**
     * @return o valor do days
     */
    public int getDays() {
        return days;
    }

    /**
     * @return o valor do hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * @return o valor do minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * @return o valor do seconds
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * @return o valor do milliseconds
     */
    public int getMilliseconds() {
        return milliseconds;
    }
}
