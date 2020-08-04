/**
*
* Nome: AnexarArquivoGccVO.java
* Propósito: <p> </p>
*
* @author :  BRQ<BR/>
* Equipe : Web <BR>
* @version:  1.6
*          Parametro  de compilação -d
*
* @see : Referencias externas. 
*
* Registro  de Manutenção: 23/11/2015
*	- Autor: BRQ
*	- Responsavel: Equipe Web
*	_ Ajuste para deixar no padrão hexavision.
*/
package br.com.bradesco.web.npcc_trade.service.gcc;

import br.com.bradesco.web.npcc_trade.utils.enums.EnumPastasGcc;

/**
 *
 * Nome: AnexarArquivoGccVO.java
 * Propósito: <p> </p>
 *
 * @author :  BRQ<BR/>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 23/11/2015
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public class AnexarArquivoGccVO {

    private String anoMes = null;
    
    private String nroBoleto = null;
    
    private String cpfCnpj = null;
    
    private String tipoPessoa = null;
    
    private EnumPastasGcc pasta = null;

    /**
     * @return o valor do anoMes
     */
    public String getAnoMes() {
        return anoMes;
    }

    /**
     * @param anoMes seta o novo valor para o campo anoMes
     */
    public void setAnoMes(String anoMes) {
        this.anoMes = anoMes;
    }

    /**
     * @return o valor do nroBoleto
     */
    public String getNroBoleto() {
        return nroBoleto;
    }

    /**
     * @param nroBoleto seta o novo valor para o campo nroBoleto
     */
    public void setNroBoleto(String nroBoleto) {
        this.nroBoleto = nroBoleto;
    }

    /**
     * @return o valor do cpfCnpj
     */
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    /**
     * @param cpfCnpj seta o novo valor para o campo cpfCnpj
     */
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    /**
     * @return o valor do tipoPessoa
     */
    public String getTipoPessoa() {
        return tipoPessoa;
    }

    /**
     * @param tipoPessoa seta o novo valor para o campo tipoPessoa
     */
    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    /**
     * @return o valor do pasta
     */
    public EnumPastasGcc getPasta() {
        return pasta;
    }

    /**
     * @param pasta seta o novo valor para o campo pasta
     */
    public void setPasta(EnumPastasGcc pasta) {
        this.pasta = pasta;
    }
}
