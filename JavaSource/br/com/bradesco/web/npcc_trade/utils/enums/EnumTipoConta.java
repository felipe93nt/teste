/**
*
* Nome: EnumTipoConta.java
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
* Nome: EnumTipoConta.java
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
public enum EnumTipoConta {

    /**
     * 
     */
    CONCENTRATION("C", "Concentration"),
    
    /**
     * 
     */
    NEW_NOSTRO("N", "New Nostro");
    
    private String codigo;
    
    private String descricao;
    
    private EnumTipoConta(String codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    /**
     * @param codigo
     * @return
     */
    public static EnumTipoConta fromCode(String code) {
    	
    	if (code.equals("C")) {
    		return CONCENTRATION;
		} else if (code.equals("N")) {
			 return NEW_NOSTRO;
		} else {
			throw new IllegalArgumentException("Inconsist�ncia nos dados informados: " + code);
		}
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
    public String getCodigo() {
        return codigo;
    }

}
