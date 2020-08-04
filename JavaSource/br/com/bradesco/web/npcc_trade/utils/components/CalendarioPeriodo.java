package br.com.bradesco.web.npcc_trade.utils.components;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <b>Nome:</b>
 * <p>
 * CalendarioPeriodo.java
 * </p>
 * 
 * <b>Prop�sito:</b>
 * <p>
 * Representa��o de um per�odo atrv�s de dois campos de data
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR/>
 * @version: 1.5 Parametro de compila��o -d
 *
 *
 *           Registro de Manuten��o: 11/04/2016 - Autor: BRQ - Responsavel:
 *           Equipe Web _ Ajuste para deixar no padr�o hexavision.
 */
public class CalendarioPeriodo implements Cloneable, Comparable<CalendarioPeriodo> {

    private Date inicio;
    private Date fim;
    private SimpleDateFormat dateFormat;

    /**
     * Construtor
     * 
     * @param
     */
    public CalendarioPeriodo() {
        super();

        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }

    /**
     * Construtor
     * 
     * @param @param inicio
     * @param @param fim
     */
    public CalendarioPeriodo(Date inicio, Date fim) {
        this();

        this.inicio = inicio;
        this.fim = fim;
    }

    /**
     * Construtor
     * 
     * @param @param inicio
     * @param @param fim
     * @param @param dateFormat
     */
    public CalendarioPeriodo(Date inicio, Date fim, String dateFormat) {
        this(inicio, fim);

        this.dateFormat = new SimpleDateFormat(dateFormat);
    }

    /**
     * @return Retorna a data de inicio formatada
     */
    public String getInicioFormatado() {

        return inicio == null ? "" : dateFormat.format(inicio);
    }

    /**
     * @return Retorna a data fim formatada
     */
    public String getFimFormatado() {

        return fim == null ? "" : dateFormat.format(fim);
    }

    /**
     * @return Retorna o per�odo formatado
     */
    public String getPeriodoFormatado() {

        if (getInicioFormatado() != "" && getFimFormatado() != "") {
            return getInicioFormatado().concat(" � ").concat(getFimFormatado());
        } else if (getInicioFormatado() != "") {
            return "A partir de ".concat(getInicioFormatado());
        } else if (getFimFormatado() != "") {
            return "At� ".concat(getFimFormatado());
        } else {
            return "";
        }
    }

    /**
     * @return Retorna true caso o uma das datas esteja preenchida
     */
    public boolean isIndeterminado() {
        return (inicio == null && fim == null);
    }

    /**
     * @return Retorna true caso o periodo seja v�lido
     */
    public boolean isValid() {
        return (inicio != null && fim != null && !fim.before(inicio));
    }

    /**
     * @return Retorna uma lista com todas as mensagens de valida��o
     */
    public String getMensagemValidacao(String campo) {
        String mensagem;

        if (inicio == null && fim == null) {
            mensagem = "O " + campo + " informado � inv�lido.";
        } else if (inicio == null || fim == null) {
            mensagem = "Informe o in�cio e o fim do " + campo + ".";
        } else if (fim.before(inicio)) {
            mensagem = "A data in�cio do " + campo + " n�o pode ser maior que a data fim.";
        } else {
            mensagem = "";
        }

        return mensagem;
    }

    /**
     * @return Retorna uma lista com todas as mensagens de valida��o
     */
    public List<String> getMensagensValidacao() {
        List<String> mensagens = new ArrayList<String>();

        if (inicio == null) {
            mensagens.add("A data de in�cio deve ser informada.");
        }

        if (fim == null) {
            mensagens.add("A data final deve ser informada.");
        }

        if (fim != null && fim.before(inicio)) {
            mensagens.add("A data final n�o pode ser inferior � data inicial.");
        }

        return mensagens;
    }

    /**
     * @return Retorna a quantidade de dias do per�odo
     */
    public long getDiasPeriodo() {
        if (inicio != null && fim != null) {
            return (fim.getTime() - inicio.getTime()) / (24 * 60 * 60 * 1000);
        } else {
            return -1;
        }
    }

    /**
     * @return Retorna uma c�pia do objeto
     */
    public CalendarioPeriodo copy() {
        try {
            return (CalendarioPeriodo) this.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return getPeriodoFormatado();
    }

    @Override
    public boolean equals(Object otherObject) {
        // Verifica se o objeto n�o � nulo ou se h� dados para comparar
        if (otherObject == null || this.toString() == null || this.toString().isEmpty()) {
            return false;
        }

        // Verifica se o objeto passado � uma instancia v�lida para comparar
        if (otherObject instanceof CalendarioPeriodo) {
            CalendarioPeriodo CalendarioPeriodo = (CalendarioPeriodo) otherObject;

            return this.toString().equals(CalendarioPeriodo.toString());
        } else {
            return false;
        }
    };

    @Override
    public int compareTo(CalendarioPeriodo next) {
        // Verifica se possui valor antes de fazer a compara��o
        if (this.toString() != null) {
            return this.toString().compareToIgnoreCase(next.toString());
        } else {
            return -1;
        }
    }

    /**
     * @return o valor do inicio
     */
    public Date getInicio() {
        return inicio;
    }

    /**
     * @param inicio
     *            seta o novo valor para o campo inicio
     */
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    /**
     * @return o valor do fim
     */
    public Date getFim() {
        return fim;
    }

    /**
     * @param fim
     *            seta o novo valor para o campo fim
     */
    public void setFim(Date fim) {
        this.fim = fim;
    }
}
