/**
 * Nome: br.com.bradesco.web.npcc_trade.view.bean
 * Propósito: Uso exclusivo do Bradesco, contém
 *            informações a respeito do Cambio.
 * Data da Criação: 12/08/2015
 *
 * @see : Referencias externas.
 *
 * @author BRQ
 *         Responsavel: Equipe Web
 *         copyright Copyright (c) 2015
 *         Compilador: JDK 1.5
 *
 *         Parametro  de compilação -d
 */
package br.com.bradesco.web.npcc_trade.view.bean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import br.com.bradesco.web.aq.view.components.UICalendar.UICalendar;
import br.com.bradesco.web.aq.view.components.UICalendarPeriod.CalendarPeriodDataType;
import br.com.bradesco.web.aq.view.components.UICalendarPeriod.UICalendarPeriod;
import br.com.bradesco.web.aq.view.components.UICalendarSchedule.UICalendarSchedule;

/**
 *
 * Nome: CalendarBean.java Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 12/08/2015 - Autor: BRQ - Responsavel: Equipe Web _ Ajuste para deixar no padrão
 *      hexavision.
 */
@Named(value = "calendarBean")
@SessionScoped
public class CalendarBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;
    
    private Date selectedDay = null;
    private Date selectedMonth = null;
    private CalendarPeriodDataType selectedPeriodDay = null;
    private Date selectedScheduleDay = null;
    private Date selectedScheduleMonth = null;
    private String labelSelectedDate = null;
    private String labelSelectedPeriodDate = null;
    private String labelSelectedScheduleDate = null;
    private UICalendar calendar = new UICalendar();
    private UICalendarPeriod calendarPeriod = new UICalendarPeriod();
    private UICalendarSchedule calendarSchedule = new UICalendarSchedule();

    /**
     * Construtor
     * 
     * @param
     */
    public CalendarBean() {
        calendar.setValue(new Date());
    }

    /**
     * @return o valor do calendar
     */
    public UICalendar getCalendar() {
        return calendar;
    }

    /**
     * @param calendar seta o novo valor para o campo calendar
     */
    public void setCalendar(UICalendar calendar) {
        this.calendar = calendar;
    }

    /**
     * @return o valor do selectedDay
     */
    public Date getSelectedDay() {
        return selectedDay;
    }

    /**
     * @param selectedDay seta o novo valor para o campo selectedDay
     */
    public void setSelectedDay(Date selectedDay) {
        this.selectedDay = selectedDay;
    }

    /**
     * @return o valor do selectedMonth
     */
    public Date getSelectedMonth() {
        return selectedMonth;
    }

    /**
     * @param selectedMonth seta o novo valor para o campo selectedMonth
     */
    public void setSelectedMonth(Date selectedMonth) {
        this.selectedMonth = selectedMonth;
    }

    /**
     * @return o valor do selectedPeriodDay
     */
    public CalendarPeriodDataType getSelectedPeriodDay() {
        return selectedPeriodDay;
    }

    /**
     * @param selectedPeriodDay seta o novo valor para o campo selectedPeriodDay
     */
    public void setSelectedPeriodDay(CalendarPeriodDataType selectedPeriodDay) {
        this.selectedPeriodDay = selectedPeriodDay;
    }

    /**
     * @return o valor do selectedScheduleDay
     */
    public Date getSelectedScheduleDay() {
        return selectedScheduleDay;
    }

    /**
     * @param selectedScheduleDay seta o novo valor para o campo selectedScheduleDay
     */
    public void setSelectedScheduleDay(Date selectedScheduleDay) {
        this.selectedScheduleDay = selectedScheduleDay;
    }

    /**
     * @return o valor do selectedScheduleMonth
     */
    public Date getSelectedScheduleMonth() {
        return selectedScheduleMonth;
    }

    /**
     * @param selectedScheduleMonth seta o novo valor para o campo selectedScheduleMonth
     */
    public void setSelectedScheduleMonth(Date selectedScheduleMonth) {
        this.selectedScheduleMonth = selectedScheduleMonth;
    }

    /**
     * @return o valor do labelSelectedDate
     */
    public String getLabelSelectedDate() {
        return labelSelectedDate;
    }

    /**
     * @param labelSelectedDate seta o novo valor para o campo labelSelectedDate
     */
    public void setLabelSelectedDate(String labelSelectedDate) {
        this.labelSelectedDate = labelSelectedDate;
    }

    /**
     * @return o valor do labelSelectedPeriodDate
     */
    public String getLabelSelectedPeriodDate() {
        return labelSelectedPeriodDate;
    }

    /**
     * @param labelSelectedPeriodDate seta o novo valor para o campo labelSelectedPeriodDate
     */
    public void setLabelSelectedPeriodDate(String labelSelectedPeriodDate) {
        this.labelSelectedPeriodDate = labelSelectedPeriodDate;
    }

    /**
     * @return o valor do labelSelectedScheduleDate
     */
    public String getLabelSelectedScheduleDate() {
        return labelSelectedScheduleDate;
    }

    /**
     * @param labelSelectedScheduleDate seta o novo valor para o campo labelSelectedScheduleDate
     */
    public void setLabelSelectedScheduleDate(String labelSelectedScheduleDate) {
        this.labelSelectedScheduleDate = labelSelectedScheduleDate;
    }

    /**
     * @return o valor do calendarPeriod
     */
    public UICalendarPeriod getCalendarPeriod() {
        return calendarPeriod;
    }

    /**
     * @param calendarPeriod seta o novo valor para o campo calendarPeriod
     */
    public void setCalendarPeriod(UICalendarPeriod calendarPeriod) {
        this.calendarPeriod = calendarPeriod;
    }

    /**
     * @return o valor do calendarSchedule
     */
    public UICalendarSchedule getCalendarSchedule() {
        return calendarSchedule;
    }

    /**
     * @param calendarSchedule seta o novo valor para o campo calendarSchedule
     */
    public void setCalendarSchedule(UICalendarSchedule calendarSchedule) {
        this.calendarSchedule = calendarSchedule;
    }
    
    

}
