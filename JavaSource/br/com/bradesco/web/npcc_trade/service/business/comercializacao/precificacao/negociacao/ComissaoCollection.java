/**
*
* Nome: ComissaoCollection.java
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
package br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.monitor.IComissaoExterna;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumTipoComissao;

/**
 *
 * Nome: ComissaoCollection.java
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
public class ComissaoCollection extends ArrayList<IComissaoExterna> {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = -3770695645715287570L;

    public List<IComissaoExterna> getComissaoBanqueiro() {
        
        return getComissao(EnumTipoComissao.BANQUEIRO);
    }
    
    public List<IComissaoExterna> getComissaoAdicional() {
        
        return getComissao(EnumTipoComissao.ADICIONAL);
    }
    
    private List<IComissaoExterna> getComissao(EnumTipoComissao tipo) {
        
        List<IComissaoExterna> result = new ArrayList<IComissaoExterna>();
        
        for (Iterator<IComissaoExterna> iterator = this.iterator(); iterator.hasNext();) {
            IComissaoExterna item = (IComissaoExterna)iterator.next();            
            
            if (item.getTipoComissao().equals(tipo)) {
                result.add(item);
            }
        }
        
        return result;
    }
    
    public IComissaoExterna get(int paramInt, EnumTipoComissao tipoComissao) {
        
        int realIndex = getRealIndex(paramInt, tipoComissao);
        return super.get(realIndex);
    }
    
    public IComissaoExterna set(int paramInt, IComissaoExterna comissao) {
        
        int realIndex = getRealIndex(paramInt, comissao.getTipoComissao());
        return super.set(realIndex, comissao);
    }
    
    public IComissaoExterna remove(int paramInt, EnumTipoComissao tipoComissao) {
        
        int realIndex = getRealIndex(paramInt, tipoComissao);
        return super.remove(realIndex);
    }
    
    public int getRealIndex(int paramInt, EnumTipoComissao tipoComissao) {
        
        int indexTipo = -1;
        int indexTemp = 0;
        
        if (paramInt >= getComissao(tipoComissao).size()) {
            throw new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.size());
        }
        
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getTipoComissao().equals(tipoComissao)
                    && paramInt == indexTemp) {
                indexTipo = i;
                break;
            } else if (this.get(i).getTipoComissao().equals(tipoComissao)) {
                indexTemp++;
            }
        }
        
        return indexTipo;
    }
    
}
