package br.com.bradesco.web.npcc_trade.utils.enums;



/**
  * Nome: EnumCadastroNacionalPessoa.java
  * 
  * Propósito: <p> </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compilação -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manutenção: 11/04/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
public enum EnumCadastroNacionalPessoa {
    
    /** Variavel do tipo EnumCadastroNacionalPessoa. */
    FISICA("F", "Pessoa Física"),
    
    /** Variavel do tipo EnumCadastroNacionalPessoa. */
    JURIDICA("J", "Pessoa Jurídica");
    
    private String codigo;
    private String descricao;
    
    private EnumCadastroNacionalPessoa(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    /**
     * Nome: getCodigo
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 09/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Nome: getDescricao
     * 
     * Propósito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manutenção: 11/04/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequação ao padrão hexavision.
     */
    public String getDescricao() {
        return descricao;
    }
}
