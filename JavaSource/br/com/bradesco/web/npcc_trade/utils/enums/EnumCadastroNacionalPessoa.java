package br.com.bradesco.web.npcc_trade.utils.enums;



/**
  * Nome: EnumCadastroNacionalPessoa.java
  * 
  * Prop�sito: <p> </p>
  *
  * @author :  BRQ<BR/>
  * Equipe : Web <BR>
  * @version:  1.5
  *          Parametro  de compila��o -d
  *
  * @see : Referencias externas. 
  *
  * Registro  de Manuten��o: 11/04/2016
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padr�o hexavision.
*/
public enum EnumCadastroNacionalPessoa {
    
    /** Variavel do tipo EnumCadastroNacionalPessoa. */
    FISICA("F", "Pessoa F�sica"),
    
    /** Variavel do tipo EnumCadastroNacionalPessoa. */
    JURIDICA("J", "Pessoa Jur�dica");
    
    private String codigo;
    private String descricao;
    
    private EnumCadastroNacionalPessoa(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    /**
     * Nome: getCodigo
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 09/05/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Nome: getDescricao
     * 
     * Prop�sito: 
     *
     * @param : 
     * @return : 
     * @throws :
     * @exception : 
     * @see : Referencias externas.	
     *
     * Registro  de Manuten��o: 11/04/2016
     *        - Autor: BRQ
     *        - Responsavel: Equipe Web
     *        - Adequa��o ao padr�o hexavision.
     */
    public String getDescricao() {
        return descricao;
    }
}
