package br.com.bradesco.web.npcc_trade.service.business.global.common.bean;

/**
  * Nome: ComboCidadeVO.java
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
  * Registro  de Manutenção: 25/09/2015
  *	- Autor: BRQ
  *	- Responsavel: Equipe Web
  *	_ Ajuste para deixar no padrão hexavision.
*/
public class ComboCidadeVO {

    private String npcdwf7iscodmun = null;

    private String npcdwf7isnomemun = null;

    /**
         * Construtor
         * 
         * @param 
         */
    public ComboCidadeVO() {
        super();
    }

    /**
     * @return o valor do npcdwf7iscodmun
     */
	public String getNpcdwf7iscodmun() {
		return npcdwf7iscodmun;
	}

    /**
     * @param npcdwf7iscodmun seta o novo valor para o campo npcdwf7iscodmun
     */
	public void setNpcdwf7iscodmun(String npcdwf7iscodmun) {
		this.npcdwf7iscodmun = npcdwf7iscodmun;
	}

    /**
     * @return o valor do npcdwf7isnomemun
     */
	public String getNpcdwf7isnomemun() {
		return npcdwf7isnomemun;
	}

    /**
     * @param npcdwf7isnomemun seta o novo valor para o campo npcdwf7isnomemun
     */
	public void setNpcdwf7isnomemun(String npcdwf7isnomemun) {
		this.npcdwf7isnomemun = npcdwf7isnomemun;
	}
}
