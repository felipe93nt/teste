/**
*
* Nome: EnumTipoUnidade.java
* Prop�sito: <p> </p>
*
* @author :  BRQ<BR/>
* Equipe : Web <BR>
* @version:  1.6
*          Parametro  de compila��o -d
*
* @see : Referencias externas. 
*
* Registro  de Manuten��o: 12/11/2015
*	- Autor: BRQ
*	- Responsavel: Equipe Web
*	_ Ajuste para deixar no padr�o hexavision.
*/
package br.com.bradesco.web.npcc_trade.utils.enums;

/**
*
* Nome: EnumTipoUnidade.java
* Prop�sito: <p> </p>
*
* @author :  BRQ<BR/>
* Equipe : Web <BR>
* @version:  1.6
*          Parametro  de compila��o -d
*
* @see : Referencias externas. 
*
* Registro  de Manuten��o: 12/11/2015
*	- Autor: BRQ
*	- Responsavel: Equipe Web
*	_ Ajuste para deixar no padr�o hexavision.
*/
public enum EnumTipoUnidade {

    /**
     * 
     */
    MATRIZ(1, "Matriz"),
    
    
    /**
     * 
     */
    FILIAL(2, "Filial");
    
    private int codigo;
    
    private String descricao;
    
    private EnumTipoUnidade(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    /**
     * @param codigo
     * @return
     */
    public static EnumTipoUnidade fromCode(int code) {
        switch(code) {
        case 1:
            return MATRIZ;
        case 2:
            return FILIAL;
        }
        throw new IllegalArgumentException("Inconsist�ncia nos dados informados: " + code);
    }
    
    /**
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

}
