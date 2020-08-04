/**
 * Nome: br.com.bradesco.web.piloto.example.model
 * Propósito: Classe comum para a funcionalidade
 * Data da Criação: 16/06/2015
 *
 * @author mauricio.sako / Capgemini
 *         copyright Copyright (c) 2015
 *         Compilador: 1.6.0_45
 *         Parâmetros de Compilação: -d
 */

package br.com.bradesco.web.npcc_trade.service.business.parametrosPrecificacao.modeloBoleto;

import java.io.Serializable;

/**
 * Nome: Item
 * Propósito: Classe que define o Item <br/>
 * Data: 17/06/2015 <br/>
 *
 * @author mauricio.sako / Capgemini <br/>
 *         copyright Copyright (c) 2015 <br/>
 * @version 1.0
 * @see
 */
public class Item implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -784468677938776379L;
    /**
     * codigo
     */
    private Integer codigo = null;
    /**
     * descricao
     */
    private String descricao = null;

    /**
     * Nome: getCodigo <br/>
     * Propósito: Método get para o atributo codigo <br/>
     * Data: <19/06/2015> <br/>
     *
     * @author r.fernandes / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     * @return
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * Nome: setCodigo <br/>
     * Propósito: Método set para o atributo codigo <br/>
     * Data: <19/06/2015> <br/>
     *
     * @author r.fernandes / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     * @param codigo
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * Nome: getDescricao <br/>
     * Propósito: Método get para o atributo descricao <br/>
     * Data: <19/06/2015> <br/>
     *
     * @author r.fernandes / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Nome: setDescricao <br/>
     * Propósito: Método set para o atributo descricao <br/>
     * Data: <19/06/2015> <br/>
     *
     * @author r.fernandes / Capgemini <br/>
     *         copyright Copyright (c) 2015 <br/>
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
