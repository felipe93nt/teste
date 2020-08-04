/**
*
* Nome: IComissaoExterna.java
* Propósito: <p> </p>
*
* @author :  BRQ <BR>
* Equipe : Web <BR>
* @version:  1.6
*          Parametro  de compilação -d
*
* @see : Referencias externas. 
*
* Registro  de Manutenção: 09/03/2017
*	- Autor: BRQ
*	- Responsavel: Equipe Web
*	_ Ajuste para deixar no padrão hexavision.
*/
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor;

import br.com.bradesco.web.npcc_trade.utils.enums.EnumTipoComissao;

/**
 *
 * Nome: IComissaoExterna.java
 * Propósito: <p> </p>
 *
 * @author :  BRQ <BR>
 * Equipe : Web <BR>
 * @version:  1.6
 *          Parametro  de compilação -d
 *
 * @see : Referencias externas. 
 *
 * Registro  de Manutenção: 09/03/2017
 *	- Autor: BRQ
 *	- Responsavel: Equipe Web
 *	_ Ajuste para deixar no padrão hexavision.
 */
public interface IComissaoExterna {

    public EnumTipoComissao getTipoComissao();
    public void setTipoComissao(EnumTipoComissao tipoComissao);
}
